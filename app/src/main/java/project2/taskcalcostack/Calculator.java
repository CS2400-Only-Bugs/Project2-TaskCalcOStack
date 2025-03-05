package project2.taskcalcostack;

import java.util.HashSet;

public class Calculator {

    // Checks if a char is included within a given char hashset
    private boolean isVariable(char c, HashSet<Character> validVar) {
        return validVar.contains(c);
    }

    // Implements order of operations to see how important a char is
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
    }

    // infix must include only lowercase letters within a-z and operands
    // +,-,*,/,^,(,)
    public String convertToPostfix(String infix) {
        LinkedStack operatorStack = new LinkedStack<>();
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
                                && predence(nextCharacter) <= predence((Character) operatorStack.peek())) {
                            sb.append(operatorStack.pop());
                        }
                        operatorStack.push(nextCharacter);
                        break;
                    case '(':
                        operatorStack.push(nextCharacter);
                        break;
                    case ')':
                        while (operatorStack.peek() != (Character) '(') {
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
    }
}
