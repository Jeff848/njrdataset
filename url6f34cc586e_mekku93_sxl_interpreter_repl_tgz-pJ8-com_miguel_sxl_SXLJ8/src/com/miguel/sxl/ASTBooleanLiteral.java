/* Generated By:JJTree: Do not edit this line. ASTBooleanLiteral.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.miguel.sxl;

public
class ASTBooleanLiteral extends SXLNode {
  public ASTBooleanLiteral(int id) {
    super(id);
  }

  public ASTBooleanLiteral(SXLParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SXLParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=7c1d7af1cca158f9cde1c07525c873bb (do not edit this line) */
