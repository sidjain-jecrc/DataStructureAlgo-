package sid.hacker.array;

import java.util.Scanner;

public class StaircaseSolution {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		for (int i = 0; i < n; i++) {			
			for (int j = n-1; j > i; j--) {
				System.out.print(" ");
			}
			for (int k = 0; k <= i; k++) {
				System.out.print("#");
			}
			System.out.println();
		}

	}

}
