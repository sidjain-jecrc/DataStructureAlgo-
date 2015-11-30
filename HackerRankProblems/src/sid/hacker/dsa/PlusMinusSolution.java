package sid.hacker.dsa;

import java.text.DecimalFormat;
import java.util.Scanner;

public class PlusMinusSolution {

	public static void main(String[] args) {

		int numOfPositives = 0;
		int numOfZeroes = 0;
		DecimalFormat decimalFormatter = new DecimalFormat("#0.000000");

		Scanner in = new Scanner(System.in);
		float n = in.nextInt();
		int num = 0;

		for (int i = 0; i < n; i++) {
			num = in.nextInt();
			if (num > 0)
				numOfPositives++;
			else if (num == 0)
				numOfZeroes++;
		}
		System.out.println(decimalFormatter.format(numOfPositives / n));
		System.out.println(decimalFormatter.format((n - numOfPositives - numOfZeroes) / n));
		System.out.println(decimalFormatter.format(numOfZeroes / n));
	}

}
