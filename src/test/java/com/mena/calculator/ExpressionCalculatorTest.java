package com.mena.calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionCalculatorTest {

    private static final double EPS = 1e-9;
    /* =============================
        Basic Operations
        ============================= */
    @Test
    void precedence_multiplicationBeforeAddition() {
        assertEquals(14.0, PostfixEvaluation.evaluate("2+3*4"), EPS);
        assertEquals(11.0, PostfixEvaluation.evaluate("2*3+5"), EPS);
    }

    @Test
    void parentheses_overridePrecedence() {
        assertEquals(20.0, PostfixEvaluation.evaluate("(2+3)*4"), EPS);
        assertEquals(9.0, PostfixEvaluation.evaluate("(1+2)*(1+2)"), EPS);
    }

    @Test
    void handles_negativeNumbers() {
        assertEquals(-2.0, PostfixEvaluation.evaluate("-5+3"), EPS);
        assertEquals(8.0, PostfixEvaluation.evaluate("-2*-4"), EPS);
        assertEquals(-12.0, PostfixEvaluation.evaluate("3*-4"), EPS);
        assertEquals(-1.0, PostfixEvaluation.evaluate("(-1)"), EPS);
    }

    @Test
    void handles_decimals() {
        assertEquals(7.5, PostfixEvaluation.evaluate("3.5+4.0"), EPS);
        assertEquals(2.25, PostfixEvaluation.evaluate("9/4"), EPS);
        assertEquals(0.3, PostfixEvaluation.evaluate("0.1+0.2"), 1e-6);
    }

    @Test
    void handles_whitespace() {
        assertEquals(14.0, PostfixEvaluation.evaluate(" 2 + 3 * 4 "), EPS);
        assertEquals(20.0, PostfixEvaluation.evaluate(" ( 2 + 3 ) * 4 "), EPS);
    }

    /* =============================
       Error Handling
       ============================= */

    @Test
    void divisionByZero_shouldThrow() {
        assertThrows(RuntimeException.class,
                () -> PostfixEvaluation.evaluate("1/0"));

        assertThrows(RuntimeException.class,
                () -> PostfixEvaluation.evaluate("10/(5-5)"));
    }

    @Test
    void mismatchedParentheses_shouldThrow() {
        assertThrows(RuntimeException.class,
                () -> PostfixEvaluation.evaluate("(2+3"));

        assertThrows(RuntimeException.class,
                () -> PostfixEvaluation.evaluate("2+3)"));

        assertThrows(RuntimeException.class,
                () -> PostfixEvaluation.evaluate("((2+3)*4"));
    }

    @Test
    void invalidTokens_shouldThrow() {
        assertThrows(RuntimeException.class,
                () -> PostfixEvaluation.evaluate("2+a"));

        assertThrows(RuntimeException.class,
                () -> PostfixEvaluation.evaluate("hello"));

        assertThrows(RuntimeException.class,
                () -> PostfixEvaluation.evaluate("3$4"));
    }

    @Test
    void malformedOperatorSequences_shouldThrow() {
        assertThrows(RuntimeException.class,
                () -> PostfixEvaluation.evaluate("2++3"));

        assertThrows(RuntimeException.class,
                () -> PostfixEvaluation.evaluate("5**2"));

        assertThrows(RuntimeException.class,
                () -> PostfixEvaluation.evaluate("*/2"));

        assertThrows(RuntimeException.class,
                () -> PostfixEvaluation.evaluate("2/"));
    }

    @Test
    void emptyOrBlank_shouldThrow() {
        assertThrows(RuntimeException.class,
                () -> PostfixEvaluation.evaluate(""));

        assertThrows(RuntimeException.class,
                () -> PostfixEvaluation.evaluate("   "));
    }

    /* =============================
       Complex Expression
       ============================= */

    @Test
    void longerExpression_mixedOperations() {
        assertEquals(3.0,
                PostfixEvaluation.evaluate("((3+4)*2-5)/3"),
                EPS);
    }
}