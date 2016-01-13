package sid.practice.stack;

import java.util.Scanner;
import java.util.Stack;


/**
 * @author Siddharth Jain
 * 
 * Given a sequence consisting of parentheses,determine whether the expression is balanced. 
 * A sequence of parentheses is balanced if every open parentheses can be paired uniquely 
 * with a closed parentheses that occurs after the former. 
 * Also, the interval between them must be balanced. 
 * You will be given three types of parentheses: (, {, and [
 *
 */
public class BalancedParanthesis {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numOfTests = sc.nextInt();
		String[] results = new String[numOfTests];

		for (int i = 0; i < numOfTests; i++) {

			String expression = sc.next();
			Stack<Character> stack = new Stack<Character>();
			boolean isBalanced = false;
			boolean exitIfNotBalanced = false;

			for (int j = 0; j < expression.length(); j++) {

				char currentChar = expression.charAt(j);
				char topChar;

				switch (currentChar) {
				case '{':
					stack.push(currentChar);
					isBalanced = false;
					break;
				case '(':
					stack.push(currentChar);
					isBalanced = false;
					break;
				case '[':
					stack.push(currentChar);
					isBalanced = false;
					break;
				case '}':
					if (!stack.isEmpty()) {
						topChar = stack.peek();
						if (topChar == '{') {
							stack.pop();
							isBalanced = true;
						} else {
							isBalanced = false;
							exitIfNotBalanced = true;
						}
					}
					break;
				case ')':
					if (!stack.isEmpty()) {
						topChar = stack.peek();
						if (topChar == '(') {
							stack.pop();
							isBalanced = true;
						} else {
							isBalanced = false;
							exitIfNotBalanced = true;
						}
					}
					break;
				case ']':
					if (!stack.isEmpty()) {
						topChar = stack.peek();
						if (topChar == '[') {
							stack.pop();
							isBalanced = true;
						} else {
							isBalanced = false;
							exitIfNotBalanced = true;
						}
					}
					break;
				}
				if (exitIfNotBalanced)
					break;
			}

			if (isBalanced)
				results[i] = "YES";
			else
				results[i] = "NO";
		}
		for (String res : results) {
			System.out.println(res);
		}
	}

}
