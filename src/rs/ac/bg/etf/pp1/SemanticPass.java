 package rs.ac.bg.etf.pp1;

import java.util.Stack;

import org.apache.log4j.Logger;

import java_cup.terminal;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;



public class SemanticPass extends VisitorAdaptor {
	
	int nVars = 0;
	int cnt = 0;
	boolean errorDetected = false;
	Obj currentMethod = null;
	Struct currentType = Tab.noType;
	Struct boolType = Tab.find("bool").getType();
	
	
	Logger log = Logger.getLogger(getClass());
	
	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
//	ProgName	
	@Override		
	public void visit(ProgName progName) {
		
		progName.obj =Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
		Tab.openScope();
		
	}
	
//	Program	
	@Override		
	public void visit(Program program) {
		
		Obj mainMeth = Tab.find("main");
		if(mainMeth == Tab.noObj) {
			report_error("Main metoda nije definisana!", program);
			return;
		}
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
		
	}
	
//	Type	
	@Override		
	public void visit(Type type){
		
		Obj typeNode = Tab.find(type.getTypeName());
		if(typeNode == Tab.noObj) {
			report_error("Nije pronadjen tip" + type.getTypeName() + " u tabeli simbola.", type);
			currentType = type.struct = Tab.noType;
		}else {
			if(Obj.Type == typeNode.getKind()) {
				currentType = type.struct = typeNode.getType();
			}else {
				report_error("Greska: Ime" + type.getTypeName() + " ne predstavlja tip!", type);
				currentType = type.struct = Tab.noType;
			}
		}
		
	}
	
//	MethName	
	@Override	
	public void visit(MethName methName) {
		
		currentMethod = Tab.insert(Obj.Meth, methName.getMethName(), Tab.noType);// void main() ...
		methName.obj = currentMethod;
    	Tab.openScope();
		report_info("Obradjuje se funkcija " + methName.getMethName(), methName);
		
	}
	
//	MethodDecl	
	@Override	
	public void visit(MethodDeclaration methodDecl) {
		
		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		currentMethod = null;
		
	}
	
//	ArrayName	
	@Override
	public void visit(ArrayName arrayName) {
		
		Obj arr = Tab.find(arrayName.getArrName());
		if(arr == Tab.noObj) {
			report_error("Niz sa imenom " + arrayName.getArrName() + " nije deklarisan!", arrayName);
			arrayName.obj = Tab.noObj;
		}
		else if (arr.getKind() != Obj.Var || arr.getType().getKind() != Struct.Array) {
			report_error("Promenljiva imena " + arrayName.getArrName() + " nije niz!", arrayName);
			arrayName.obj = Tab.noObj;
		}
		else {
			arrayName.obj = arr;
		}
		
	}
//	Designator
	@Override
	public void visit(DesignatorArray designatorArray) {
		
		if(designatorArray.getExpr().struct != Tab.intType) {
			report_error("Niz" + designatorArray.getArrayName() +" nije tipa int", designatorArray);
			designatorArray.obj = Tab.noObj;
		}
		else {
			designatorArray.obj = new Obj(Obj.Elem, "arr_elem", designatorArray.getArrayName().obj.getType().getElemType());
		}
		
	}
	
	@Override
	public void visit(DesignatorVal designatorVal) {
		
		Obj val = Tab.find(designatorVal.getValName());
		if(val == Tab.noObj) {
			report_error("Promenljiva" + designatorVal.getValName() + " nije nadjena u tabeli simbola", designatorVal);
			designatorVal.obj = Tab.noObj;
		}
		else if (val.getKind() != Obj.Var && val.getKind() != Obj.Con) {
			report_error("Promenljiva" + designatorVal.getValName() + " nije var ili konstanta", designatorVal);
			designatorVal.obj = Tab.noObj;
		}
		else {
			designatorVal.obj = val;
		}
		
	}
// Factor	
	@Override
	public void visit(FactorDesignator factorDesignator) {
		factorDesignator.struct = factorDesignator.getDesignator().obj.getType();
	}
	
	@Override
	public void visit(FactorNum factorNum) {
		factorNum.struct = Tab.intType;
	}
	
	@Override
	public void visit(FactorChar factorChar) {
		factorChar.struct = Tab.charType;
	}
	
	@Override
	public void visit(FactorBool factorBool) {
		factorBool.struct = boolType;
	}
	
	@Override
	public void visit(FactorExp factorExp) {
		factorExp.struct = factorExp.getExpr().struct;
	}
	
	@Override
	public void visit(FactorNew factorNew) {
		
		if(factorNew.getExpr().struct != Tab.intType) {
			report_error("Velicina deklarisanog niza nije tipa int", factorNew);
			factorNew.struct = Tab.noType;
		}
		else {
			factorNew.struct = new Struct(Struct.Array, factorNew.getType().struct);
		}
		
	}
//	FactorList
	@Override
	public void visit(FactorListFactor factorListFactor) {
		
		factorListFactor.struct = factorListFactor.getFactor().struct;
		
	}
	
	@Override
	public void visit(FactorListMulop factorListMulop) {
		
		if(factorListMulop.getFactorList().struct.equals(factorListMulop.getFactor().struct) && factorListMulop.getFactor().struct.equals(Tab.intType)) {
			factorListMulop.struct = Tab.intType;
		}
		else {
			report_error("Faktor kojim se mnozi nije tipa int",  factorListMulop);
			factorListMulop.struct = Tab.noType;
		}
		
	}
	
//	Term
	@Override
	public void visit(Term term) {
		
		term.struct = term.getFactorList().struct;	
		
	}
	
//	TermList
	@Override
	public void visit(TermListTerm termListTerm) {
		
		termListTerm.struct = termListTerm.getTerm().struct;
		
	}
	
	@Override
	public void visit(TermListAddop termListAddop) {
		
		if(termListAddop.getTermList().struct.equals(termListAddop.getTerm().struct) && termListAddop.getTermList().struct.equals(Tab.intType)) {
			termListAddop.struct = Tab.intType;
		}
		else {
			report_error("Term kojim se sabira nije tipa int", termListAddop);
			termListAddop.struct = Tab.noType;
		}
		
	}
	
//	ExprSub
	@Override
	public void visit(ExpressionSub expressionSub) {
		
		if(expressionSub.getMayMinus() instanceof YesMinus) {
			if(expressionSub.getTermList().struct != Tab.intType) {
				report_error("Imamo minus ispred expr a expr nije tipa int", expressionSub);
				expressionSub.struct = Tab.noType;
			}
			else {
				expressionSub.struct = expressionSub.getTermList().struct;
				
			}
		}
		else {
			expressionSub.struct = expressionSub.getTermList().struct;
			
		}
		
	}
	
// 	Expr
	@Override
	public void visit(NoTernary noTernary) {
		
		noTernary.struct = noTernary.getExprSub().struct;
		
	}
	
	@Override
	public void visit(Ternary ternary) {
		
		if(ternary.getExprSub().struct != boolType || !ternary.getExprSub1().struct.compatibleWith(ternary.getExprSub2().struct)) {
			report_error("Ternarni operator ima prvu promenljivu razlicitu od bool ili mu druge dve nisu kompatibilne", ternary);
			ternary.struct = Tab.noType;
		}
		else {
			ternary.struct = ternary.getExprSub1().struct;
		}
		
	}
// 	DesignatorStatement	
	@Override
	public void visit(Evaluation evaluation) {
		
		if((evaluation.getDesignator().obj.getKind() != Obj.Var) && (evaluation.getDesignator().obj.getKind() != Obj.Elem)) {
				report_error("Designator nije promenljiva ili element niza", evaluation);
		}
		else if(!evaluation.getExpr().struct.assignableTo(evaluation.getDesignator().obj.getType())) {
				report_error("Designatoru je nemoguce dodeliti vrednost koja je data", evaluation);
		}
	}
	
	@Override
	public void visit(Incrementation incrementation) {
		
		if((incrementation.getDesignator().obj.getKind() == Obj.Var) || 
				(incrementation.getDesignator().obj.getKind() == Obj.Elem)) {
			if(incrementation.getDesignator().obj.getType().equals(Tab.intType)) {
				incrementation.struct = incrementation.getDesignator().obj.getType();
			}
			else {
				report_error("Designator nije tipa int da bise inkrementirao", incrementation);
			}
		}
		else {
			report_error("Designator nije promenljiva ili element niza", incrementation);
		}
	}
	
	@Override
	public void visit(Decrementation decrementation) {
		
		if((decrementation.getDesignator().obj.getKind() == Obj.Var) || 
				(decrementation.getDesignator().obj.getKind() == Obj.Elem)) {
			if(decrementation.getDesignator().obj.getType().equals(Tab.intType)) {
				decrementation.struct = decrementation.getDesignator().obj.getType();
			}
			else {
				report_error("Designator nije tipa int da bise dekrementirao", decrementation);
			}
		}
		else {
			report_error("Designator nije promenljiva ili element niza", decrementation);
		}
		
	}
	
// 	Statement
	public void visit(Declaration declaration) {
		
		declaration.struct = declaration.getDesignatorStatement().struct;
		
	}
	
	public void visit(ReadStat readStat) {
		
		if((readStat.getDesignator().obj.getKind() == Obj.Var) || 
				(readStat.getDesignator().obj.getKind() == Obj.Elem)) {
			if((readStat.getDesignator().obj.getType().equals(Tab.intType)) ||
					(readStat.getDesignator().obj.getType().equals(Tab.charType)) ||
					(readStat.getDesignator().obj.getType().equals(boolType))) {
				readStat.struct = readStat.getDesignator().obj.getType();
			}
			else {
				report_error("U read funkciji se ne nalazi designator tipa int, char ili bool", readStat);
			}
		}
		else {
			report_error("U read funkciji designator nije promenljiva ili element niza", readStat);
		}
		
	}
	
	public void visit(PrintStat printStat) {
		
		if((printStat.getExpr().struct.equals(Tab.intType)) ||
				(printStat.getExpr().struct.equals(Tab.charType)) ||
				(printStat.getExpr().struct.equals(boolType))) {
					printStat.struct = printStat.getExpr().struct;
		}
		else {
			report_error("U print funkciji se ne nalazi designator tipa int, char ili bool", printStat);
		}
		
	}
	
// 	StmtList
	public void visit(StatementList statementList) {
		
		statementList.struct = statementList.getStatment().struct;
	
	}
	
// VarDeclLocal
	@Override
	public void visit(VarDeclarationLocal varDeclarationLocal) {
		
		Obj var = Tab.find(varDeclarationLocal.getVarNameLocal());
		
		if(var == Tab.noObj) {
			if(varDeclarationLocal.getBrcs() instanceof NoBracket)
				Tab.insert(Obj.Var, varDeclarationLocal.getVarNameLocal(), currentType);
			else
				Tab.insert(Obj.Var, varDeclarationLocal.getVarNameLocal(), new Struct(Struct.Array, currentType));
		}
		else {
			report_error("Vec je deklarisana lokalna promenljiva "+ varDeclarationLocal.getVarNameLocal(), varDeclarationLocal);
		}
			
	}
	
//	VarDecl
	@Override
	public void visit(VarDeclaration varDeclaration) {
		
		Obj var = Tab.find(varDeclaration.getVarName());
		
		if(var == Tab.noObj) {
			if(varDeclaration.getBrcs() instanceof NoBracket)
				Tab.insert(Obj.Var, varDeclaration.getVarName(), currentType);
			else
				Tab.insert(Obj.Var, varDeclaration.getVarName(), new Struct(Struct.Array, currentType));
			nVars++;
		}
		else {
			report_error("Vec je deklarisana globalna promenljiva "+ varDeclaration.getVarName(), varDeclaration);
		}
			
	}
	
//	ConstDecl
	@Override
	public void visit(ConstantNum constantNum) {
		
		Obj var = Tab.find(constantNum.getConstName());
		
		if(var == Tab.noObj) {
			if(currentType == Tab.intType) {
				constantNum.obj =Tab.insert(Obj.Con, constantNum.getConstName(), Tab.intType);
				constantNum.obj.setAdr(constantNum.getN1());
			}
			else {
				report_error("Ne slaze se tip promeljive i podatak za promenljivu " + constantNum.getConstName(), constantNum);
			}
		}
		else {
			report_error("Vec je deklarisana globalna konstanta sa imenom" + constantNum.getConstName() + "tipa int", constantNum);
		}
			
	}
	
	@Override
	public void visit(ConstantChar constantChar) {
		
		Obj var = Tab.find(constantChar.getConstName());
		
		if(var == Tab.noObj) {
			if(currentType == Tab.charType) {
				constantChar.obj =Tab.insert(Obj.Con, constantChar.getConstName(), Tab.charType);
				constantChar.obj.setAdr(constantChar.getC1());
			}
			else {
				report_error("Ne slaze se tip promeljive i podatak za promenljivu " + constantChar.getConstName(), constantChar);
			}
			
		}
		else {
			report_error("Vec je deklarisana globalna konstanta sa imenom" + constantChar.getConstName() + "tipa char", constantChar);
		}
			
	}
	
	@Override
	public void visit(ConstantBool constantBool) {
		
		Obj var = Tab.find(constantBool.getConstName());
		
		if(var == Tab.noObj) {
			if(currentType == boolType) {
				constantBool.obj =Tab.insert(Obj.Con, constantBool.getConstName(), boolType);
				constantBool.obj.setAdr(constantBool.getB1());
			}
			else {
				report_error("Ne slaze se tip promeljive i podatak za promenljivu " + constantBool.getConstName(), constantBool);
			}
			
		}
		else {
			report_error("Vec je deklarisana globalna konstanta sa imenom " + constantBool.getConstName() + " tipa bool", constantBool);
		}
			
	}
	
//	Mulop
	
	@Override
	public void visit(MulopMul mulopMul) {
		mulopMul.struct = new Struct(Code.mul);
	}
	
	@Override
	public void visit(MulopDiv mulopDiv) {
		mulopDiv.struct = new Struct(Code.div);
	}
	
	@Override
	public void visit(MulopPer mulopPer) {
		mulopPer.struct = new Struct(Code.rem);
	}
	
//	Addop
	
	@Override
	public void visit(AddopPlus addopPlus) {
		addopPlus.struct = new Struct(Code.add);
	}
	
	@Override
	public void visit(AddopMinus addopMinus) {
		addopMinus.struct = new Struct(Code.sub);
	}
	
	public boolean passed(){
    	return !errorDetected;
    }
}
