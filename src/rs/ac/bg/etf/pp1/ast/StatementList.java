// generated with ast extension for cup
// version 0.8
// 20/1/2021 10:55:29


package rs.ac.bg.etf.pp1.ast;

public class StatementList extends StmtList {

    private StmtList StmtList;
    private Statment Statment;

    public StatementList (StmtList StmtList, Statment Statment) {
        this.StmtList=StmtList;
        if(StmtList!=null) StmtList.setParent(this);
        this.Statment=Statment;
        if(Statment!=null) Statment.setParent(this);
    }

    public StmtList getStmtList() {
        return StmtList;
    }

    public void setStmtList(StmtList StmtList) {
        this.StmtList=StmtList;
    }

    public Statment getStatment() {
        return Statment;
    }

    public void setStatment(Statment Statment) {
        this.Statment=Statment;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StmtList!=null) StmtList.accept(visitor);
        if(Statment!=null) Statment.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StmtList!=null) StmtList.traverseTopDown(visitor);
        if(Statment!=null) Statment.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StmtList!=null) StmtList.traverseBottomUp(visitor);
        if(Statment!=null) Statment.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementList(\n");

        if(StmtList!=null)
            buffer.append(StmtList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statment!=null)
            buffer.append(Statment.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementList]");
        return buffer.toString();
    }
}
