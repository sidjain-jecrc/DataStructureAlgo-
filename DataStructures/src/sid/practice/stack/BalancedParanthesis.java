package sid.practice.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Siddharth Jain
 * 
 *         Given a sequence consisting of parentheses,determine whether the
 *         expression is balanced. A sequence of parentheses is balanced if
 *         every open parentheses can be paired uniquely with a closed
 *         parentheses that occurs after the former. Also, the interval between
 *         them must be balanced. You will be given three types of parentheses:
 *         (, {, and [
 *
 */
public class BalancedParanthesis {

	public static void main(String[] args) {

		String[] input = { ":", "", "cdsfsdfs  :", "test :) ()", ":( ))", "start :):)", "(:)", "today (:()", ")(",
				"(:)())()a()(()::(():())(:))):((:(a:())()()a)" };
		String[] result = smileys(input);
		for (String res : result) {
			System.out.println(res);
		}
	}

	public static boolean isParanthesisBalanced(String expression) {

		Stack<Character> stack = new Stack<Character>();

		for (int j = 0; j < expression.length(); j++) {

			char currentChar = expression.charAt(j);

			switch (currentChar) {
			case '{':
				stack.push(currentChar);
				break;
			case '(':
				stack.push(currentChar);
				break;
			case '[':
				stack.push(currentChar);
				break;
			case '}':
				if (stack.isEmpty() || stack.peek() != '{') {
					return false;
				} else {
					stack.pop();
				}
				break;
			case ')':
				if (stack.isEmpty() || stack.peek() != '(') {
					return false;
				} else {
					stack.pop();
				}
				break;
			case ']':
				if (stack.isEmpty() || stack.peek() != '[') {
					return false;
				} else {
					stack.pop();
				}
				break;
			}
		}
		return stack.isEmpty();
	}

	public static String[] isParanthesisBalanced(String[] expressions) {

		Stack<Character> stack = new Stack<Character>();
		String[] result = new String[expressions.length];

		for (int i = 0; i < expressions.length; i++) {

			boolean isBalanced = true;

			String expression = expressions[i];
			if (expression.equals("") || expression.equals(":")) {
				result[i] = "YES";
				continue;
			}

			for (int j = 0; j < expression.length(); j++) {
				char currentChar = expression.charAt(j);
				if (currentChar == ':' && j < expression.length() - 1) {
					if (expression.charAt(j + 1) == ')' || expression.charAt(j + 1) == '(') {
						j = j + 1;
						continue;
					}
				}
				if (currentChar == '(') {
					stack.push(currentChar);
				} else if (currentChar == ')') {
					if (stack.isEmpty() || stack.peek() != '(') {
						result[i] = "NO";
						isBalanced = false;
						break;
					} else {
						stack.pop();
					}
				}

			}
			if (isBalanced == true && stack.isEmpty()) {
				result[i] = "YES";
			} else {
				result[i] = "NO";
			}
			stack.clear();
		}
		return result;
	}

	public static String[] smileys(String[] input) {
		String[] ans = new String[input.length];
		for (int i = 0; i < input.length; i++) {
			String s = input[i];
			int maxOpen = 0;
			int minOpen = 0;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '(') {
					maxOpen += 1;
					if (j == 0 || s.charAt(j - 1) != ':') {
						minOpen += 1;
					}
				} else if (s.charAt(j) == ')') {
					minOpen = Math.max(0, minOpen - 1);
					if (j == 0 || s.charAt(j - 1) != ':') {
						maxOpen -= 1;
						if (maxOpen < 0)
							break;
					}
				}
			}
			if (maxOpen >= 0 && minOpen == 0)
				ans[i] = "YES";
			else {
				ans[i] = "NO";
			}
		}
		return ans;
	}

}
