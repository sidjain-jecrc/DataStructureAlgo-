package sid.practice.array;

import java.util.Scanner;

public class ReverseOrder {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int arr_i = 0; arr_i < n; arr_i++) {
			arr[arr_i] = in.nextInt();
		}
		for (int j = n - 1; j >= 0; j--) {
			System.out.print(arr[j] + " ");
		}
	}

}
