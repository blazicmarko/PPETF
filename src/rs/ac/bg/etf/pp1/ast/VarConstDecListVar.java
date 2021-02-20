// generated with ast extension for cup
// version 0.8
// 20/1/2021 10:55:29


package rs.ac.bg.etf.pp1.ast;

public class VarConstDecListVar extends VarConstDecList {

    private VarConstDecList VarConstDecList;
    private VarDeclList VarDeclList;

    public VarConstDecListVar (VarConstDecList VarConstDecList, VarDeclList VarDeclList) {
        this.VarConstDecList=VarConstDecList;
        if(VarConstDecList!=null) VarConstDecList.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
    }

    public VarConstDecList getVarConstDecList() {
        return VarConstDecList;
    }

    public void setVarConstDecList(VarConstDecList VarConstDecList) {
        this.VarConstDecList=VarConstDecList;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarConstDecList!=null) VarConstDecList.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarConstDecList!=null) VarConstDecList.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarConstDecList!=null) VarConstDecList.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarConstDecListVar(\n");

        if(VarConstDecList!=null)
            buffer.append(VarConstDecList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarConstDecListVar]");
        return buffer.toString();
    }
}
