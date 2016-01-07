package sid.hacker.dsa;

import java.util.Scanner;

public class FunnyString {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		sc.nextLine();

		String result = "Funny";
		String[] inputStringArray = new String[testCases];

		for (int k = 0; k < testCases; k++) {
			inputStringArray[k] = sc.nextLine();
		}
		sc.close();

		for (String inputString : inputStringArray) {

			int strLength = inputString.length();
			StringBuilder buildString = new StringBuilder(inputString);
			String reverseString = buildString.reverse().toString();
			int count = 0;

			for (int j = 1; j < strLength; j++) {

				int firstDiff = Math.abs(inputString.charAt(j) - inputString.charAt(j - 1));
				int secondDiff = Math.abs(reverseString.charAt(j) - reverseString.charAt(j - 1));
				if (firstDiff == secondDiff) {
					count++;
				}
			}
			if (count == strLength - 1)
				System.out.println("Funny");
			else
				System.out.println("Not Funny");
		}
	}
}
