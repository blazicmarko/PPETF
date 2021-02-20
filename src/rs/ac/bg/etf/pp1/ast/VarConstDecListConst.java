// generated with ast extension for cup
// version 0.8
// 20/1/2021 10:55:29


package rs.ac.bg.etf.pp1.ast;

public class VarConstDecListConst extends VarConstDecList {

    private VarConstDecList VarConstDecList;
    private ConstDeclList ConstDeclList;

    public VarConstDecListConst (VarConstDecList VarConstDecList, ConstDeclList ConstDeclList) {
        this.VarConstDecList=VarConstDecList;
        if(VarConstDecList!=null) VarConstDecList.setParent(this);
        this.ConstDeclList=ConstDeclList;
        if(ConstDeclList!=null) ConstDeclList.setParent(this);
    }

    public VarConstDecList getVarConstDecList() {
        return VarConstDecList;
    }

    public void setVarConstDecList(VarConstDecList VarConstDecList) {
        this.VarConstDecList=VarConstDecList;
    }

    public ConstDeclList getConstDeclList() {
        return ConstDeclList;
    }

    public void setConstDeclList(ConstDeclList ConstDeclList) {
        this.ConstDeclList=ConstDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarConstDecList!=null) VarConstDecList.accept(visitor);
        if(ConstDeclList!=null) ConstDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarConstDecList!=null) VarConstDecList.traverseTopDown(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarConstDecList!=null) VarConstDecList.traverseBottomUp(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarConstDecListConst(\n");

        if(VarConstDecList!=null)
            buffer.append(VarConstDecList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclList!=null)
            buffer.append(ConstDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarConstDecListConst]");
        return buffer.toString();
    }
}
