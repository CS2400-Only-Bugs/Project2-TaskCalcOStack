package project2.taskcalcostack;

public class CalculatorTest {

    // just testing if my code works, delete if you want
    /*
     * MAKE SURE
     * 1) All variables are lowercase
     * 2) The only operands are: + - / * ( )
     * 3) There are no spaces within the infix expression
     */
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        String infix = "a+b/c";
        calc.convertToPostfix(infix);
    }
}
