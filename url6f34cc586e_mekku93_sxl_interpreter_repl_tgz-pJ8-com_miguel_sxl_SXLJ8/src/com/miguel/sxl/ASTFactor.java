/* Generated By:JJTree: Do not edit this line. ASTFactor.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.miguel.sxl;

public
class ASTFactor extends SXLNode {
  public ASTFactor(int id) {
    super(id);
  }

  public ASTFactor(SXLParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SXLParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=f7b6d0093cc00335ffabb43e012c1c83 (do not edit this line) */