/* Generated By:JJTree: Do not edit this line. ASTImportDeclaration.java */

package net.sourceforge.pmd.ast;

public class ASTImportDeclaration extends SimpleNode {

    private boolean isImportOnDemand;

  public ASTImportDeclaration(int id) {
    super(id);
  }

  public ASTImportDeclaration(JavaParser p, int id) {
    super(p, id);
  }

    public void setImportOnDemand() {
        this.isImportOnDemand= true;
    }

    public boolean isImportOnDemand() {
        return isImportOnDemand;
    }


  /** Accept the visitor. **/
  public Object jjtAccept(JavaParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
