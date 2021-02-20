package rs.ac.bg.etf.pp1;

import java.util.Stack;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;

public class CodeGenerator extends VisitorAdaptor {

	private int mainPc;
	int nVars;
	static boolean isMinus = false;
	Stack<Boolean> minus = new Stack<>();
	
	public int getMainPc(){
		return mainPc;
	}
	
//	Methods in
	public void visit(MethName methName){
		
		if("main".equalsIgnoreCase(methName.getMethName())){
			mainPc = Code.pc;
		}
		methName.obj.setAdr(Code.pc);
		
		// Generate the entry
		Code.put(Code.enter);
		Code.put(0);
		Code.put(methName.obj.getLocalSymbols().size());
	
	}
	
//	Methods out		
	public void visit(MethodDeclaration methodDeclaration){
		
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
//	Designator in factor	
	public void visit(FactorDesignator factorDesignator){
		
		Code.load(factorDesignator.getDesignator().obj);
		
		if(minus.peek() == true) {
			Code.put(Code.neg);
			minus.pop();
			minus.push(false);
		}
	}
	
//	Load Arrays addres	
	public void visit(ArrayName arrayName){
		
		Code.load(arrayName.obj);
		
	}
	
//	Factor
	public void visit(FactorNum factorNum){

		Code.loadConst(factorNum.getN1());
		
		if(minus.peek() == true) {
			Code.put(Code.neg);
			minus.pop();
			minus.push(false);
		}
	}
	
	public void visit(FactorChar factorChar){
		
		Code.loadConst(factorChar.getC1());
		
	}
	
	public void visit(FactorBool factorBool){
		
		Code.loadConst(factorBool.getB1());
		
	}
	
	public void visit(FactorNew factorNew){//na steku je expr koji je duzina niza
		
		Code.put(Code.newarray);
		if(factorNew.getType().struct.equals(Tab.charType))
			Code.put(0);
		else
			Code.put(1);
		
	}
	
//	Multiple operation
	public void visit(FactorListMulop factorListMulop){
		
		Code.put(factorListMulop.getMulop().struct.getKind());
		
	}
	
// 	Add operation
	public void visit(TermListAddop termListAddop){
		
		Code.put(termListAddop.getAddop().struct.getKind());
		
	}

//	Set designator
	public void visit(Evaluation evaluation){
		
		Code.store(evaluation.getDesignator().obj);
		
	}
	
//	Increment
	
	public void visit(Incrementation incrementation){
		
		Code.load(incrementation.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(incrementation.getDesignator().obj);
		
	}
	
//	Decrement
	public void visit(Decrementation decrementation){
		
		Code.load(decrementation.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(decrementation.getDesignator().obj);
		
	}
	
// Minus before statement
	public void visit(ExpressionSub expressionSub){
		minus.pop();
	}
	
//	Ternary
	int skipTrue = 0;
	int skipFalse = 0;
	
	public void visit(Question quest) {
		
		Code.loadConst(0);
		Code.putFalseJump(Code.ne, 0);
		skipTrue = Code.pc - 2;
		
	}


	public void visit(Colon col) {
		
		Code.putJump(0);
		skipFalse = Code.pc - 2;
		Code.fixup(skipTrue);
		
	}

	public void visit(Ternary ternary){			

		Code.fixup(skipFalse);
		
	}
	
	
//	Return statement
	public void visit(ReturnStat returnStat){
		
		Code.put(Code.exit);
		Code.put(Code.return_);
		
	}
	
//	Print statment
	public void visit(PrintStat printStat){
		
		if(printStat.getConstNumList() instanceof NoConstNumberList)
			Code.loadConst(0);
		else
			Code.loadConst(((ConstNumberList)printStat.getConstNumList()).getN1());
		Code.put(Code.print);
		
	}
	
//	Read statment
	public void visit(ReadStat readStat){
		
		Code.put(Code.read);
		Code.store(readStat.getDesignator().obj);
		
	}
	
//	Minus
	public void visit(YesMinus yesMinus) {
		minus.push(true);
	}
	
	public void visit(NoMinus nNoMinus) {
		minus.push(false);
	}
	
// 	FactorExp
	public void visit(FactorExp factorExp) {
		if(minus.peek() == true) {
			Code.put(Code.neg);
			minus.pop();
			minus.push(false);
		}
	}
	
	
	
	
	
}
