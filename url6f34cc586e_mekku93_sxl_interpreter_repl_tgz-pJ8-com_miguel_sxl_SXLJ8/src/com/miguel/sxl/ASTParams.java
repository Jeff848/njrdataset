/* Generated By:JJTree: Do not edit this line. ASTParams.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.miguel.sxl;

public
class ASTParams extends SXLNode {
  public ASTParams(int id) {
    super(id);
  }

  public ASTParams(SXLParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SXLParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=97323416a50ee4c98208752946dd5028 (do not edit this line) */
