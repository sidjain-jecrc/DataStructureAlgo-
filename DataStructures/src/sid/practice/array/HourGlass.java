package sid.practice.array;

import java.util.Scanner;

/**
 * @author Siddharth Jain In this problem, you have to print the largest sum
 *         among all the hourglasses in the array
 *
 */
public class HourGlass {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int arr[][] = new int[6][6];
		for (int arr_i = 0; arr_i < 6; arr_i++) {
			for (int arr_j = 0; arr_j < 6; arr_j++) {
				arr[arr_i][arr_j] = in.nextInt();
			}
		}
		
		int result = getMaxSumHourGlass(arr);
		System.out.println(result);
	}

	static int getMaxSumHourGlass(int[][] ar) {
		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				int localSum = 0;
				if (i + 2 < 6 && j + 2 < 6) {
					localSum = ar[i][j] + ar[i][j+1] + ar[i][j+2] + ar[i+1][j+1] + ar[i+2][j] + ar[i+2][j+1] + ar[i+2][j+2];
					if(localSum > maxSum)
						maxSum = localSum;
				}
			}
		}
		return maxSum;
	}

}
