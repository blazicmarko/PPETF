// generated with ast extension for cup
// version 0.8
// 20/1/2021 10:55:29


package rs.ac.bg.etf.pp1.ast;

public class DesignatorVal extends Designator {

    private String valName;

    public DesignatorVal (String valName) {
        this.valName=valName;
    }

    public String getValName() {
        return valName;
    }

    public void setValName(String valName) {
        this.valName=valName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorVal(\n");

        buffer.append(" "+tab+valName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorVal]");
        return buffer.toString();
    }
}
