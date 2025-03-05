package project2.taskcalcostack;

import java.util.HashSet;

public class Calculator {

    /**
     * Checks to see if a char is included within a given char hashset
     * 
     * @param c        the character being checked
     * @param validVar the hashset that the character is compared to
     * @return true if the char is within the hashset, false otherwise
     */
    private boolean isVariable(char c, HashSet<Character> validVar) {
        return validVar.contains(c);
    }// end isVariable

    /**
     * Implements order of operations to see how important a char is
     * 
     * @param operator the character being viewed to see precedence
     * @return the number of the corresponding precedence
     */
    private int predence(char operator) {
        switch (operator) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }// end precedence

    /**
     * Converts an infix expression to a postfix expression
     * Must include only a-z variables and only operands + - * / ^ ( )
     * 
     * @param infix the infix expression to convert
     * @return the new postfix expression
     */
    public String convertToPostfix(String infix) {
        infix = infix.toLowerCase();
        LinkedStack<Character> operatorStack = new LinkedStack<Character>();
        String postfix = null;
        StringBuilder sb = new StringBuilder();

        HashSet<Character> validVariables = new HashSet<>();
        for (char c = 'a'; c <= 'z'; c++) {
            validVariables.add(c);
        }

        for (int i = 0; i < infix.length(); i++) {
            char nextCharacter = infix.charAt(i);

            if (isVariable(nextCharacter, validVariables)) {
                sb.append(nextCharacter);
            } else {
                switch (nextCharacter) {
                    case '^':
                        operatorStack.push(nextCharacter);
                        break;
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        while (!operatorStack.isEmpty()
                                && predence(nextCharacter) <= predence(operatorStack.peek())) {
                            sb.append(operatorStack.pop());
                        }
                        operatorStack.push(nextCharacter);
                        break;
                    case '(':
                        operatorStack.push(nextCharacter);
                        break;
                    case ')':
                        while (operatorStack.peek() != '(') {
                            sb.append(operatorStack.pop());
                        }
                        operatorStack.pop();
                        break;
                    default:
                        break;
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            sb.append(operatorStack.pop());
        }

        postfix = sb.toString();
        System.out.println(postfix);
        return postfix;
    }// end convertToPostfix
}
