package sid.hacker.dsa;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pangrams {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String inputString = sc.nextLine();
		int count = 0;

		Set<Character> letterSet = new HashSet<Character>();
		inputString = inputString.toLowerCase();

		for (char letter : inputString.toCharArray()) {
			if (Character.isLetter(letter) && letterSet.add(letter)) {
				count++;
				if (count == 26)
					break;
			}
		}
		String result = count == 26 ? "pangram" : "not pangram";
		System.out.println(result);
	}
}
