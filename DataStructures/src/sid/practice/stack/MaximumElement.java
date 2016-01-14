package sid.practice.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numOfQueries = sc.nextInt();
		Stack<Integer> generalStack = new Stack<Integer>();
		Stack<Integer> maxStack = new Stack<Integer>();
		List<Integer> maxElementList = new ArrayList<Integer>();

		for (int i = 0; i < numOfQueries; i++) {
			int type = sc.nextInt();

			switch (type) {

			case 1:
				int element = sc.nextInt();
				generalStack.push(element);
				if (maxStack.isEmpty()) {
					maxStack.push(element);
				} else if (element > maxStack.peek()) {
					maxStack.push(element);
				}
				break;
			case 2:
				if (!generalStack.isEmpty()) {
					int poppedElement = generalStack.pop();
					if (!maxStack.isEmpty() && poppedElement == maxStack.peek()) {
						maxStack.pop();
					}
				}
				break;
			case 3:
				maxElementList.add(maxStack.peek());
				break;
			}
		}
		
		for (int max : maxElementList) {
			System.out.println(max);
		}
	}

}
