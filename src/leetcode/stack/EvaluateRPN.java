package leetcode.stack;

import java.util.Stack;

public class EvaluateRPN
{

	public static int evalRPN(String[] tokens)
    {
		Stack<Integer> stack = new Stack<Integer>();
        for(String token: tokens)
        {
        		if(!isOperator(token))
        			stack.push(Integer.valueOf(token));
        		else
        		{
        			int operand2 = stack.pop();
        			int operand1 = stack.pop();
        			int result = doOperation(token, operand1, operand2);
        			stack.push(result);
        		}
        }
        return stack.peek();
    }
	
	private static int doOperation(String operator, int operand1, int operand2)
	{
		if(operator.equals("+"))
			return operand1 + operand2;
		else if(operator.equals("-"))
			return operand1 - operand2;
		else if(operator.equals("*"))
			return operand1 * operand2;
		else
			return operand1 / operand2;
	}
	
	private static boolean isOperator(String token) {
		return 	token.equals("+") || 
				token.equals("-") ||
				token.equals("*") ||
				token.equals("/");
	}
	
	public static void main(String[] args)
	{
		String[] tokens = {"1", "2", "+"};
		System.out.println(evalRPN(tokens));
	}

}
