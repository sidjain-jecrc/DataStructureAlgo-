package sid.hacker.dsa;

import java.util.Scanner;

public class MaximumSubarray {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numOfTestCases = sc.nextInt();
		String[] resultArray = new String[numOfTestCases];

		for (int i = 0; i < numOfTestCases; i++) {
			int arraySize = sc.nextInt();
			int[] integerArray = new int[arraySize];

			int contiguousSum = 0;
			int nonContiguousSum = 0;
			int currentSum = 0;
			int bestSum = 0;
			int currentIndex = -1;
			int startIndex = -1;
			int endIndex = -1;

			for (int j = 0; j < arraySize; j++) {

				integerArray[j] = sc.nextInt();

				if (integerArray[j] > 0)
					nonContiguousSum += integerArray[j];

				int value = currentSum + integerArray[j];
				if (value > 0) {
					if (currentSum == 0) {
						currentIndex = j;
					}
					currentSum = value;
				} else {
					currentSum = 0;
				}
				if (currentSum > bestSum) {
					bestSum = currentSum;
					startIndex = currentIndex;
					endIndex = j;
				}
			}

			if (startIndex >= 0 && endIndex >= 0) {

				for (int k = startIndex; k <= endIndex; k++) {
					contiguousSum += integerArray[k];
				}
				resultArray[i] = String.valueOf(contiguousSum + " " + nonContiguousSum);

			} else {
				resultArray[i] = maxSubArray(integerArray, arraySize);
			}
		}

		for (int m = 0; m < resultArray.length; m++) {
			System.out.println(resultArray[m]);
		}
	}

	public static String maxSubArray(int[] arr, int arraySize) {

		int maxSoFar = arr[0];
		int currentMax = arr[0];
		int nonContiguousSum = 0;

		for (int i = 1; i < arraySize; i++) {

			currentMax = Math.max(arr[i], currentMax + arr[i]);
			maxSoFar = Math.max(currentMax, maxSoFar);

			if (arr[i] > 0)
				nonContiguousSum += arr[i];

			if (maxSoFar < 0)
				nonContiguousSum = maxSoFar;
		}
		return maxSoFar + " " + nonContiguousSum;
	}
}
