// generated with ast extension for cup
// version 0.8
// 20/1/2021 10:55:29


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclaration extends MethodDecl {

    private MethName MethName;
    private VarDeclLocalListRec VarDeclLocalListRec;
    private StmtList StmtList;

    public MethodDeclaration (MethName MethName, VarDeclLocalListRec VarDeclLocalListRec, StmtList StmtList) {
        this.MethName=MethName;
        if(MethName!=null) MethName.setParent(this);
        this.VarDeclLocalListRec=VarDeclLocalListRec;
        if(VarDeclLocalListRec!=null) VarDeclLocalListRec.setParent(this);
        this.StmtList=StmtList;
        if(StmtList!=null) StmtList.setParent(this);
    }

    public MethName getMethName() {
        return MethName;
    }

    public void setMethName(MethName MethName) {
        this.MethName=MethName;
    }

    public VarDeclLocalListRec getVarDeclLocalListRec() {
        return VarDeclLocalListRec;
    }

    public void setVarDeclLocalListRec(VarDeclLocalListRec VarDeclLocalListRec) {
        this.VarDeclLocalListRec=VarDeclLocalListRec;
    }

    public StmtList getStmtList() {
        return StmtList;
    }

    public void setStmtList(StmtList StmtList) {
        this.StmtList=StmtList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethName!=null) MethName.accept(visitor);
        if(VarDeclLocalListRec!=null) VarDeclLocalListRec.accept(visitor);
        if(StmtList!=null) StmtList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethName!=null) MethName.traverseTopDown(visitor);
        if(VarDeclLocalListRec!=null) VarDeclLocalListRec.traverseTopDown(visitor);
        if(StmtList!=null) StmtList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethName!=null) MethName.traverseBottomUp(visitor);
        if(VarDeclLocalListRec!=null) VarDeclLocalListRec.traverseBottomUp(visitor);
        if(StmtList!=null) StmtList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclaration(\n");

        if(MethName!=null)
            buffer.append(MethName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclLocalListRec!=null)
            buffer.append(VarDeclLocalListRec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StmtList!=null)
            buffer.append(StmtList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclaration]");
        return buffer.toString();
    }
}
