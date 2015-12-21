package sid.practice.sort;

public class SelectionSort {

	public static void main(String[] args) {

		int arr[] = { 4, 7, 2, 8, 5, 1, 3, 9, 6 };

		System.out.println("Before Selection Sort");
		printArray(arr);
		arr = sortArray(arr);
		System.out.println("\nAfter Selection Sort");
		printArray(arr);
	}

	public static int[] sortArray(int[] arr) {

		int n = arr.length;
		int minValAtIndex, temp;

		// outer loop is equivalent to a trip through all elements
		for (int i = 0; i < n - 1; i++) {
			minValAtIndex = i;
			for (int j = i + 1; j < n; j++) {
				// comparing each value with 'i'th value and resetting the
				// minValueAtIndex variable
				if (arr[j] < arr[minValAtIndex]) {
					minValAtIndex = j;
				}
			}
			// swapping the value at position 'i' with the smaller value
			if (minValAtIndex != i) {
				temp = arr[i];
				arr[i] = arr[minValAtIndex];
				arr[minValAtIndex] = temp;
			}
		}
		return arr;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
