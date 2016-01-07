package sid.hacker.dsa;

import java.util.Arrays;
import java.util.Scanner;

public class CountPairs {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int numOfPairs = 0;

		long[] intArray = new long[N];
		for (int i = 0; i < N; i++) {
			intArray[i] = sc.nextLong();
		}

		Arrays.sort(intArray);
		for (int m = 0; m < N - 1; m++) {
			int found = Arrays.binarySearch(intArray, m + 1, N, intArray[m] + K);
			if (found > 0) {
				numOfPairs++;
			}
		}
		System.out.println(numOfPairs);
	}

}
