package de.codesourcery.dcpu16.parser;

import de.codesourcery.dcpu16.ast.ASTNode;
import de.codesourcery.dcpu16.ast.FunctionInvocation;
import de.codesourcery.dcpu16.ast.OperatorNode;
import de.codesourcery.dcpu16.util.ITextRegion;


public final class ExpressionToken {

    private final ITextRegion textRegion;
    private final ExpressionTokenType type;
    private final ASTNode token;

    public static enum ExpressionTokenType {
        FUNCTION,
        ARGUMENT_DELIMITER,
        OPERATOR,
        PARENS_OPEN,
        PARENS_CLOSE,
        EXPRESSION,
        VALUE;
    }
    
    public ExpressionToken(ExpressionTokenType type,ITextRegion region)
    {
        this.type = type;
        this.token = null;
        this.textRegion = region;
    }

    public ExpressionToken(ExpressionTokenType type,Token token)
    {
        this.type = type;
        this.token = null;
        this.textRegion = token.getTextRegion();
    }        

    public ExpressionToken(ExpressionTokenType type, ASTNode token)
    {
        this.type = type;
        this.token = token;
        this.textRegion = token.getTextRegion();
    }        

    public ITextRegion getTextRegion()
    {
        return textRegion;
    }

    @Override
    public String toString()
    {
        switch( type ) {
            case ARGUMENT_DELIMITER:
                return ",";
            case FUNCTION:
                return ((FunctionInvocation) getToken()).getFunctionName().toString();
            case OPERATOR:
                return ((OperatorNode) getToken()).getOperator().toString();
            case PARENS_CLOSE:
                return ")";
            case PARENS_OPEN:
                return "(";
            case VALUE:
                return getToken().toString();
            default:
                return type+" | "+token;
        }
    }

    public boolean isArgumentDelimiter() {
        return hasType(ExpressionTokenType.ARGUMENT_DELIMITER);
    }

    public boolean isFunction() {
        return hasType(ExpressionTokenType.FUNCTION);
    }

    public boolean isOperator() {
        return hasType(ExpressionTokenType.OPERATOR);
    }

    public boolean hasAllOperands() {
        if ( ! isOperator() ) {
            throw new UnsupportedOperationException("Not an operator: "+this);
        }
        return ((OperatorNode) getToken()).hasAllOperands();
    }

    public boolean isLeftAssociative() 
    {
        if ( ! isOperator() ) {
            throw new UnsupportedOperationException("Not an operator: "+this);
        }
        return ((OperatorNode) getToken()).getOperator().isLeftAssociative();
    }

    public boolean isValue() {
        return hasType(ExpressionTokenType.VALUE);
    }        

    public boolean isParens() {
        return isParensOpen() || isParensClose();
    }

    public boolean isParensOpen() {
        return hasType(ExpressionTokenType.PARENS_OPEN);
    }         

    public boolean isParensClose() {
        return hasType(ExpressionTokenType.PARENS_CLOSE);
    }         

    public ASTNode getToken()
    {
        return token;
    }

    public boolean hasType(ExpressionTokenType t) {
        return getType() == t;
    }

    public ExpressionTokenType getType()
    {
        return type;
    }
}