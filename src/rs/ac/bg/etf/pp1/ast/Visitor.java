// generated with ast extension for cup
// version 0.8
// 20/1/2021 10:55:29


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Statment Statment);
    public void visit(Mulop Mulop);
    public void visit(MethodDecl MethodDecl);
    public void visit(TermList TermList);
    public void visit(VarConstDecList VarConstDecList);
    public void visit(VarDeclMoreLocal VarDeclMoreLocal);
    public void visit(FactorList FactorList);
    public void visit(Addop Addop);
    public void visit(Factor Factor);
    public void visit(Brcs Brcs);
    public void visit(Quest Quest);
    public void visit(Designator Designator);
    public void visit(ExprSub ExprSub);
    public void visit(ConstDeclList ConstDeclList);
    public void visit(ConstNumList ConstNumList);
    public void visit(StmtList StmtList);
    public void visit(MayMinus MayMinus);
    public void visit(VarDeclList VarDeclList);
    public void visit(Expr Expr);
    public void visit(ConstDeclMore ConstDeclMore);
    public void visit(VarDeclLocal VarDeclLocal);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(VarDeclLocalListRec VarDeclLocalListRec);
    public void visit(VarDecl VarDecl);
    public void visit(VarDeclMore VarDeclMore);
    public void visit(Col Col);
    public void visit(ConstDecl ConstDecl);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(VarDeclLocalList VarDeclLocalList);
    public void visit(MulopPer MulopPer);
    public void visit(MulopDiv MulopDiv);
    public void visit(MulopMul MulopMul);
    public void visit(FactorNew FactorNew);
    public void visit(FactorBool FactorBool);
    public void visit(FactorExp FactorExp);
    public void visit(FactorChar FactorChar);
    public void visit(FactorNum FactorNum);
    public void visit(FactorDesignator FactorDesignator);
    public void visit(FactorListFactor FactorListFactor);
    public void visit(FactorListMulop FactorListMulop);
    public void visit(Term Term);
    public void visit(AddopMinus AddopMinus);
    public void visit(AddopPlus AddopPlus);
    public void visit(TermListTerm TermListTerm);
    public void visit(TermListAddop TermListAddop);
    public void visit(NoMinus NoMinus);
    public void visit(YesMinus YesMinus);
    public void visit(ExpressionSub ExpressionSub);
    public void visit(Colon Colon);
    public void visit(Question Question);
    public void visit(Ternary Ternary);
    public void visit(NoTernary NoTernary);
    public void visit(ArrayName ArrayName);
    public void visit(DesignatorArray DesignatorArray);
    public void visit(DesignatorVal DesignatorVal);
    public void visit(Decrementation Decrementation);
    public void visit(Incrementation Incrementation);
    public void visit(Evaluation Evaluation);
    public void visit(NoConstNumberList NoConstNumberList);
    public void visit(ConstNumberList ConstNumberList);
    public void visit(Stmts Stmts);
    public void visit(ReturnStat ReturnStat);
    public void visit(PrintStat PrintStat);
    public void visit(ReadStat ReadStat);
    public void visit(Declaration Declaration);
    public void visit(NoStatementList NoStatementList);
    public void visit(StatementList StatementList);
    public void visit(VarDeclarationLocal VarDeclarationLocal);
    public void visit(NoVarDeclMoreLocal NoVarDeclMoreLocal);
    public void visit(VarDeclMoreLocalComma VarDeclMoreLocalComma);
    public void visit(VarLocalDeclarations VarLocalDeclarations);
    public void visit(NoVarDeclLocalListRecursion NoVarDeclLocalListRecursion);
    public void visit(VarDeclLocalListRecursion VarDeclLocalListRecursion);
    public void visit(MethName MethName);
    public void visit(MethodDeclaration MethodDeclaration);
    public void visit(NoMethodDeclaration NoMethodDeclaration);
    public void visit(OneMethodDeclaration OneMethodDeclaration);
    public void visit(Type Type);
    public void visit(NoBracket NoBracket);
    public void visit(Brackets Brackets);
    public void visit(VarDeclaration VarDeclaration);
    public void visit(NoVarDeclMore NoVarDeclMore);
    public void visit(VarDeclMoreComma VarDeclMoreComma);
    public void visit(VarDeclarations VarDeclarations);
    public void visit(ConstantBool ConstantBool);
    public void visit(ConstantChar ConstantChar);
    public void visit(ConstantNum ConstantNum);
    public void visit(NoConstDeclMore NoConstDeclMore);
    public void visit(ConstDeclMoreComma ConstDeclMoreComma);
    public void visit(ConstDeclarations ConstDeclarations);
    public void visit(NoVarConstDecList NoVarConstDecList);
    public void visit(VarConstDecListVar VarConstDecListVar);
    public void visit(VarConstDecListConst VarConstDecListConst);
    public void visit(ProgName ProgName);
    public void visit(Program Program);

}
