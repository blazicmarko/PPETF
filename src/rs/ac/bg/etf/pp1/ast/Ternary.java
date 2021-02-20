// generated with ast extension for cup
// version 0.8
// 20/1/2021 10:55:29


package rs.ac.bg.etf.pp1.ast;

public class Ternary extends Expr {

    private ExprSub ExprSub;
    private Quest Quest;
    private ExprSub ExprSub1;
    private Col Col;
    private ExprSub ExprSub2;

    public Ternary (ExprSub ExprSub, Quest Quest, ExprSub ExprSub1, Col Col, ExprSub ExprSub2) {
        this.ExprSub=ExprSub;
        if(ExprSub!=null) ExprSub.setParent(this);
        this.Quest=Quest;
        if(Quest!=null) Quest.setParent(this);
        this.ExprSub1=ExprSub1;
        if(ExprSub1!=null) ExprSub1.setParent(this);
        this.Col=Col;
        if(Col!=null) Col.setParent(this);
        this.ExprSub2=ExprSub2;
        if(ExprSub2!=null) ExprSub2.setParent(this);
    }

    public ExprSub getExprSub() {
        return ExprSub;
    }

    public void setExprSub(ExprSub ExprSub) {
        this.ExprSub=ExprSub;
    }

    public Quest getQuest() {
        return Quest;
    }

    public void setQuest(Quest Quest) {
        this.Quest=Quest;
    }

    public ExprSub getExprSub1() {
        return ExprSub1;
    }

    public void setExprSub1(ExprSub ExprSub1) {
        this.ExprSub1=ExprSub1;
    }

    public Col getCol() {
        return Col;
    }

    public void setCol(Col Col) {
        this.Col=Col;
    }

    public ExprSub getExprSub2() {
        return ExprSub2;
    }

    public void setExprSub2(ExprSub ExprSub2) {
        this.ExprSub2=ExprSub2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprSub!=null) ExprSub.accept(visitor);
        if(Quest!=null) Quest.accept(visitor);
        if(ExprSub1!=null) ExprSub1.accept(visitor);
        if(Col!=null) Col.accept(visitor);
        if(ExprSub2!=null) ExprSub2.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprSub!=null) ExprSub.traverseTopDown(visitor);
        if(Quest!=null) Quest.traverseTopDown(visitor);
        if(ExprSub1!=null) ExprSub1.traverseTopDown(visitor);
        if(Col!=null) Col.traverseTopDown(visitor);
        if(ExprSub2!=null) ExprSub2.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprSub!=null) ExprSub.traverseBottomUp(visitor);
        if(Quest!=null) Quest.traverseBottomUp(visitor);
        if(ExprSub1!=null) ExprSub1.traverseBottomUp(visitor);
        if(Col!=null) Col.traverseBottomUp(visitor);
        if(ExprSub2!=null) ExprSub2.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Ternary(\n");

        if(ExprSub!=null)
            buffer.append(ExprSub.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Quest!=null)
            buffer.append(Quest.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprSub1!=null)
            buffer.append(ExprSub1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Col!=null)
            buffer.append(Col.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprSub2!=null)
            buffer.append(ExprSub2.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Ternary]");
        return buffer.toString();
    }
}
