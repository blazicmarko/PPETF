// generated with ast extension for cup
// version 0.8
// 20/1/2021 10:55:29


package rs.ac.bg.etf.pp1.ast;

public class VarDeclMoreLocalComma extends VarDeclMoreLocal {

    private VarDeclLocal VarDeclLocal;
    private VarDeclMoreLocal VarDeclMoreLocal;

    public VarDeclMoreLocalComma (VarDeclLocal VarDeclLocal, VarDeclMoreLocal VarDeclMoreLocal) {
        this.VarDeclLocal=VarDeclLocal;
        if(VarDeclLocal!=null) VarDeclLocal.setParent(this);
        this.VarDeclMoreLocal=VarDeclMoreLocal;
        if(VarDeclMoreLocal!=null) VarDeclMoreLocal.setParent(this);
    }

    public VarDeclLocal getVarDeclLocal() {
        return VarDeclLocal;
    }

    public void setVarDeclLocal(VarDeclLocal VarDeclLocal) {
        this.VarDeclLocal=VarDeclLocal;
    }

    public VarDeclMoreLocal getVarDeclMoreLocal() {
        return VarDeclMoreLocal;
    }

    public void setVarDeclMoreLocal(VarDeclMoreLocal VarDeclMoreLocal) {
        this.VarDeclMoreLocal=VarDeclMoreLocal;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclLocal!=null) VarDeclLocal.accept(visitor);
        if(VarDeclMoreLocal!=null) VarDeclMoreLocal.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclLocal!=null) VarDeclLocal.traverseTopDown(visitor);
        if(VarDeclMoreLocal!=null) VarDeclMoreLocal.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclLocal!=null) VarDeclLocal.traverseBottomUp(visitor);
        if(VarDeclMoreLocal!=null) VarDeclMoreLocal.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclMoreLocalComma(\n");

        if(VarDeclLocal!=null)
            buffer.append(VarDeclLocal.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclMoreLocal!=null)
            buffer.append(VarDeclMoreLocal.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclMoreLocalComma]");
        return buffer.toString();
    }
}
