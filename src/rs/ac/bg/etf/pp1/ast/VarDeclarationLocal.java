// generated with ast extension for cup
// version 0.8
// 20/1/2021 10:55:29


package rs.ac.bg.etf.pp1.ast;

public class VarDeclarationLocal extends VarDeclLocal {

    private String varNameLocal;
    private Brcs Brcs;

    public VarDeclarationLocal (String varNameLocal, Brcs Brcs) {
        this.varNameLocal=varNameLocal;
        this.Brcs=Brcs;
        if(Brcs!=null) Brcs.setParent(this);
    }

    public String getVarNameLocal() {
        return varNameLocal;
    }

    public void setVarNameLocal(String varNameLocal) {
        this.varNameLocal=varNameLocal;
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
        buffer.append("VarDeclarationLocal(\n");

        buffer.append(" "+tab+varNameLocal);
        buffer.append("\n");

        if(Brcs!=null)
            buffer.append(Brcs.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclarationLocal]");
        return buffer.toString();
    }
}
