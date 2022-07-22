package com.zc;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author yeyu
 * @since 2022/1/8 5:23 PM
 */
public class SpelTest {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'hello world'.toUpperCase()");
        System.out.println(expression.getValue());
    }
}
