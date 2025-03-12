package project2.taskcalcostack;
import project2.taskcalcostack.Calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Simple addition equation")
    void testSimpleAddInfix() {
        assertEquals("ab+", calculator.convertToPostfix("a+b"));
    }

    @Test
    @DisplayName("Simple subtraction equation")
    void testSimpleSubInfix() {
        assertEquals("ab-", calculator.convertToPostfix("a-b"));
    }

    @Test
    @DisplayName("Simple multiplication equation")
    void testSimpleMultInfix() {
        assertEquals("ab*", calculator.convertToPostfix("a*b"));
    }

    @Test
    @DisplayName("Simple division equation")
    void testSimpleDivInfix() {
        assertEquals("ab/", calculator.convertToPostfix("a/b"));
    }

    @Test
    @DisplayName("Complex addition subtraction equation")
    void testComplexAddSubInfix() {
        assertEquals("ab+cd-+", calculator.convertToPostfix("(a+b)+(c-d)"));
    }

    @Test
    @DisplayName("Complex multiplication division equation")
    void testComplexMultDivInfix() {
        assertEquals("ab*cd/+", calculator.convertToPostfix("(a*b)+(c/d)"));
    }

    @Test
    @DisplayName("Complex equation using all operands")
    void testComplexAllInfix() {
        assertEquals("ab+cd-*ef/+", calculator.convertToPostfix("(a+b)*(c-d)+(e/f)"));
    }

    @Test
    @DisplayName("Operation with spaces")
    void testSpaceInfix() {
        assertEquals("Error", calculator.convertToPostfix("a + b"));
    }

    @Test
    @DisplayName("Operations with incorrect variables")
    void testInvalidVarInfix() {
        assertEquals("Error", calculator.convertToPostfix("! + #"));
    }

    @Test
    @DisplayName("Empty Operations")
    void testEmptyInfix() {
        assertEquals("Error", calculator.convertToPostfix(""));
    }
}
