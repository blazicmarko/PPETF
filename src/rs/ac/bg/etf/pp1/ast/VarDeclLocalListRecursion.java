// generated with ast extension for cup
// version 0.8
// 20/1/2021 10:55:29


package rs.ac.bg.etf.pp1.ast;

public class VarDeclLocalListRecursion extends VarDeclLocalListRec {

    private VarDeclLocalListRec VarDeclLocalListRec;
    private VarDeclLocalList VarDeclLocalList;

    public VarDeclLocalListRecursion (VarDeclLocalListRec VarDeclLocalListRec, VarDeclLocalList VarDeclLocalList) {
        this.VarDeclLocalListRec=VarDeclLocalListRec;
        if(VarDeclLocalListRec!=null) VarDeclLocalListRec.setParent(this);
        this.VarDeclLocalList=VarDeclLocalList;
        if(VarDeclLocalList!=null) VarDeclLocalList.setParent(this);
    }

    public VarDeclLocalListRec getVarDeclLocalListRec() {
        return VarDeclLocalListRec;
    }

    public void setVarDeclLocalListRec(VarDeclLocalListRec VarDeclLocalListRec) {
        this.VarDeclLocalListRec=VarDeclLocalListRec;
    }

    public VarDeclLocalList getVarDeclLocalList() {
        return VarDeclLocalList;
    }

    public void setVarDeclLocalList(VarDeclLocalList VarDeclLocalList) {
        this.VarDeclLocalList=VarDeclLocalList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclLocalListRec!=null) VarDeclLocalListRec.accept(visitor);
        if(VarDeclLocalList!=null) VarDeclLocalList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclLocalListRec!=null) VarDeclLocalListRec.traverseTopDown(visitor);
        if(VarDeclLocalList!=null) VarDeclLocalList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclLocalListRec!=null) VarDeclLocalListRec.traverseBottomUp(visitor);
        if(VarDeclLocalList!=null) VarDeclLocalList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclLocalListRecursion(\n");

        if(VarDeclLocalListRec!=null)
            buffer.append(VarDeclLocalListRec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclLocalList!=null)
            buffer.append(VarDeclLocalList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclLocalListRecursion]");
        return buffer.toString();
    }
}
