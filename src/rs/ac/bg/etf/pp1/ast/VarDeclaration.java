// generated with ast extension for cup
// version 0.8
// 20/1/2021 10:55:29


package rs.ac.bg.etf.pp1.ast;

public class VarDeclaration extends VarDecl {

    private String varName;
    private Brcs Brcs;

    public VarDeclaration (String varName, Brcs Brcs) {
        this.varName=varName;
        this.Brcs=Brcs;
        if(Brcs!=null) Brcs.setParent(this);
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public Brcs getBrcs() {
        return Brcs;
    }

    public void setBrcs(Brcs Brcs) {
        this.Brcs=Brcs;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Brcs!=null) Brcs.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Brcs!=null) Brcs.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Brcs!=null) Brcs.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclaration(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(Brcs!=null)
            buffer.append(Brcs.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclaration]");
        return buffer.toString();
    }
}
