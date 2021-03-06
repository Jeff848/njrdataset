/* Generated By:JavaCC: Do not edit this line. SXLParserVisitor.java Version 5.0 */
package com.miguel.sxl;

public interface SXLParserVisitor
{
  public Object visit(SimpleNode node, Object data);
  public Object visit(ASTAddOp node, Object data);
  public Object visit(ASTMultOp node, Object data);
  public Object visit(ASTRelOp node, Object data);
  public Object visit(ASTGreaterThan node, Object data);
  public Object visit(ASTLessThan node, Object data);
  public Object visit(ASTGreaterEqualsTo node, Object data);
  public Object visit(ASTLessEqualsTo node, Object data);
  public Object visit(ASTEqualTo node, Object data);
  public Object visit(ASTNotEqualTo node, Object data);
  public Object visit(ASTIntegerLiteral node, Object data);
  public Object visit(ASTRealLiteral node, Object data);
  public Object visit(ASTCharLiteral node, Object data);
  public Object visit(ASTStringLiteral node, Object data);
  public Object visit(ASTBooleanLiteral node, Object data);
  public Object visit(ASTUnitLiteral node, Object data);
  public Object visit(ASTType node, Object data);
  public Object visit(ASTTypeInt node, Object data);
  public Object visit(ASTTypeReal node, Object data);
  public Object visit(ASTTypeBool node, Object data);
  public Object visit(ASTTypeChar node, Object data);
  public Object visit(ASTTypeString node, Object data);
  public Object visit(ASTTypeUnit node, Object data);
  public Object visit(ASTIdentifier node, Object data);
  public Object visit(ASTTypeCast node, Object data);
  public Object visit(ASTArgs node, Object data);
  public Object visit(ASTArg node, Object data);
  public Object visit(ASTFunctionCall node, Object data);
  public Object visit(ASTUnary node, Object data);
  public Object visit(ASTUnaryOp node, Object data);
  public Object visit(ASTFactor node, Object data);
  public Object visit(ASTTerm node, Object data);
  public Object visit(ASTSimpleExpression node, Object data);
  public Object visit(ASTExpression node, Object data);
  public Object visit(ASTVariableDecl node, Object data);
  public Object visit(ASTFunctionDecl node, Object data);
  public Object visit(ASTParams node, Object data);
  public Object visit(ASTParam node, Object data);
  public Object visit(ASTIfStatement node, Object data);
  public Object visit(ASTThenStatement node, Object data);
  public Object visit(ASTBlock node, Object data);
  public Object visit(ASTElseStatement node, Object data);
  public Object visit(ASTWhileStatement node, Object data);
  public Object visit(ASTAssignmentStatement node, Object data);
  public Object visit(ASTReadStatement node, Object data);
  public Object visit(ASTWriteStatement node, Object data);
  public Object visit(ASTHaltStatement node, Object data);
  public Object visit(ASTSXL node, Object data);
}
/* JavaCC - OriginalChecksum=1ca46637d7bbcc3f70be674d440a6108 (do not edit this line) */
