package sid.practice.stack;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numOfQueries = sc.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> maxElementList = new ArrayList<Integer>();
		int lastTopElement = 0;
		int lastMaxElement = 0;

		for (int i = 0; i < numOfQueries; i++) {
			int type = sc.nextInt();

			switch (type) {

			case 1:
				int toBePushed = sc.nextInt();
				stack.push(toBePushed);
				break;
			case 2:
				if (!stack.isEmpty())
					stack.pop();
				break;
			case 3:
				int maxElement = 0;
				int currentTopElement = stack.peek();
				if (currentTopElement != lastTopElement) {
					for (int element : stack) {
						if (element > maxElement) {
							maxElement = element;
						}
					}
					maxElementList.add(maxElement);
					lastTopElement = currentTopElement;
					lastMaxElement = maxElement;
				} else {
					maxElementList.add(lastMaxElement);
				}
				break;
			}
		}
		for (int max : maxElementList) {
			System.out.println(max);
		}
	}

}
