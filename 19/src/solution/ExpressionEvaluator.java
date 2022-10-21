package solution;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * 
 * @author ???
 * @version ???
 * 
 */
public class ExpressionEvaluator
{

    public static final Pattern UNSIGNED_DOUBLE =
            Pattern.compile("((\\d+\\.?\\d*)|(\\.\\d+))([Ee][-+]?\\d+)?.*?");
    public static final Pattern CHARACTER = Pattern.compile("\\S.*?");
    Stack<Character> stack = new Stack<Character>();
    Stack<Double> numberStack = new Stack<Double>();
    /**
     * Takes an infix expression and converts it to postfix.
     * 
     * @param expression
     *            The infix expression.
     * @return the postfix expression.
     */
    public String toPostfix(String expression)
    {
        // ... other local variables
        Scanner input = new Scanner(expression);
        String next;
        char symbol;
        String postfixExpression = "";

        while (input.hasNext())
        {
            if (input.hasNext(UNSIGNED_DOUBLE))
            {
                next = input.findInLine(UNSIGNED_DOUBLE);
                postfixExpression += next + " ";
            }
            else
            {
                next = input.findInLine(CHARACTER);
                symbol = next.charAt(0);
                if (symbol == '(')
                {
                    stack.push(symbol);
                }
                else if (symbol == '/' || symbol == '*')
                {
                    while (!stack.isEmpty() && stack.peek() != '(' && (stack.peek() == '/' || stack.peek() == '*'))
                    {
                        postfixExpression += stack.peek() + " ";
                        stack.pop();
                    }
                    stack.push(symbol);
                }
                else if (symbol == '+' || symbol == '-')
                {
                    while (!stack.isEmpty() && stack.peek() != '(')
                    {
                        postfixExpression += stack.peek() + " ";
                        stack.pop();
                    }
                    stack.push(symbol);
                }
                else if (symbol == ')')
                {
                    while (stack.peek() != '(')
                    {
                            postfixExpression += stack.peek() + " ";
                            stack.pop();
                    }
                    stack.pop();
                }
                else
                {
                    throw new IllegalArgumentException("Invalid symbol");
                }
            }
        }
        while (!stack.isEmpty())
        {
            if (stack.peek() != '(')
            {
                postfixExpression += stack.peek() + " ";
            }
            stack.pop();
        }
        return postfixExpression;
    }

    /**
     * Evaluates a postfix expression and returns the result.
     * 
     * @param postfixExpression
     *            The postfix expression.
     * @return The result of the expression.
     */
    public double evaluate(String postfixExpression)
    {
        // other local variables you may need
        Scanner input = new Scanner(postfixExpression);
        String next;
        char operator;
        double answer = Double.NaN;

        while (input.hasNext())
        {
            if (input.hasNext(UNSIGNED_DOUBLE))
            {
                next = input.findInLine(UNSIGNED_DOUBLE);
                numberStack.push(Double.parseDouble(next));
            }
            else
            {
                next = input.findInLine(CHARACTER);
                operator = next.charAt(0);
                double n2 = numberStack.peek();
                numberStack.pop();
                double n1 = numberStack.peek();
                numberStack.pop();
                switch (operator)
                {
                    case '+':
                        numberStack.push(n1 + n2);
                        break;
                    case '-':
                        numberStack.push(n1 - n2);
                        break;
                    case '/':
                        numberStack.push(n1 / n2);
                        break;
                    case '*':
                        numberStack.push(n1 * n2);
                        break;
                }
            }
        }
        answer = numberStack.peek();
        if (numberStack.size() > 1)
        {
            throw new IllegalArgumentException("Not properly parenthesized!");
        }
        return answer;
    }

}
