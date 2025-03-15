package project2.taskcalcostack;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }
    //Conversion Tests
    @Test
    @DisplayName("Simple Postfix Addition Equation")
    void testSimpleAddInfix() {
        assertEquals("ab+", calculator.convertToPostfix("a+b"));
    }

    @Test
    @DisplayName("Simple Postfix Subtraction Equation")
    void testSimpleSubInfix() {
        assertEquals("ab-", calculator.convertToPostfix("a-b"));
    }

    @Test
    @DisplayName("Simple Postfix Multiplication Equation")
    void testSimpleMultInfix() {
        assertEquals("ab*", calculator.convertToPostfix("a*b"));
    }

    @Test
    @DisplayName("Simple Postfix Division Equation")
    void testSimpleDivInfix() {
        assertEquals("ab/", calculator.convertToPostfix("a/b"));
    }

    @Test
    @DisplayName("Complex Postfix Addition Subtraction Equation")
    void testComplexAddSubInfix() {
        assertEquals("ab+cd-+", calculator.convertToPostfix("(a+b)+(c-d)"));
    }

    @Test
    @DisplayName("Complex Postfix Multiplication Division Equation")
    void testComplexMultDivInfix() {
        assertEquals("ab*cd/+", calculator.convertToPostfix("(a*b)+(c/d)"));
    }

    @Test
    @DisplayName("Complex Postfix Equation Using All Operands")
    void testComplexAllInfix() {
        assertEquals("ab+cd-*ef/+", calculator.convertToPostfix("(a+b)*(c-d)+(e/f)"));
    }

    @Test
    @DisplayName("Postfix Operation With Spaces")
    void testSpaceInfix() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> calculator.convertToPostfix("a + b"));
        assertEquals("Infix Contains Spaces", e.getMessage());
    }

    @Test
    @DisplayName("Postfix Operations With Incorrect Variables")
    void testInvalidVarInfix() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> calculator.convertToPostfix("!+#"));
        assertEquals("Invalid Character Detected !", e.getMessage());
    }

    @Test
    @DisplayName("Empty Postfix Operations")
    void testEmptyInfix() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> calculator.convertToPostfix(""));
        assertEquals("Infix is Empty", e.getMessage());
    }

    //Evaluation Tests
    @Test
    @DisplayName("Simple Postfix Addition Equation")
    void testSimpleAddPostfix(){
        assertEquals(5, calculator.evaluatePostfix("23+"));
    }

    @Test
    @DisplayName("Simple Postfix Subtraction Equation")
    void testSimpleSubPostfix(){
        assertEquals(-1, calculator.evaluatePostfix("23-"));
    }

    @Test
    @DisplayName("Simple Postfix Multiplaction Equation")
    void testSimpleMultPostfix(){
        assertEquals(6, calculator.evaluatePostfix("23*"));
    }

    @Test
    @DisplayName("Simple Postfix Division Equation")
    void testSimpleDivPostfix(){
        assertEquals(2/3, calculator.evaluatePostfix("23/"));
    }

    @Test
    @DisplayName("Complex Postfix Addition Subtraction Equation")
    void testComplexAddSubPostfix() {
        assertEquals(4, calculator.evaluatePostfix("23+45-+"));
    }

    @Test
    @DisplayName("Complex Postfix Multiplication Division Equation")
    void testComplexMultDivPostfix() {
        assertEquals(6+4/5, calculator.evaluatePostfix("23*45/+"));
    }

    @Test
    @DisplayName("Complex Postfix Equation Using All Operands")
    void testComplexAllPostfix() {
        assertEquals(-3, calculator.evaluatePostfix("23+45-*63/+"));
    }

    @Test
    @DisplayName("Invalid Postfix Expression Throws Exception")
    void testInvalidPostfix() {
        assertThrows(EmptyStackException.class, () -> calculator.evaluatePostfix("2 + 3"));
    }

    @Test
    @DisplayName("Postfix Operations With Incorrect Variables")
    void testInvalidVarPostfix() {
        assertThrows(EmptyStackException.class, () -> calculator.evaluatePostfix("! + -"));
    }

    @Test
    @DisplayName("Empty Postfix Operations")
    void testEmptyPostfix() {
        assertThrows(EmptyStackException.class, () -> calculator.evaluatePostfix(""));
    }
}
