/* Generated By:JJTree: Do not edit this line. ASTRealLiteral.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.miguel.sxl;

public
class ASTRealLiteral extends SXLNode {
  public ASTRealLiteral(int id) {
    super(id);
  }

  public ASTRealLiteral(SXLParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SXLParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=3017e9a1327daf8cc8f9f6e72fd399eb (do not edit this line) */
