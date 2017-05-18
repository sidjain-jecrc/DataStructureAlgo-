package sid.practice.sort;

import java.util.Scanner;

/**
 * @author Siddharth Jain
 * 
 *         Insertion Sort Algorithm Challenge from Hackerrank.com
 *
 */
public class InsertionSort {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int arraySize = sc.nextInt();
		int[] integerArray = new int[arraySize];

		for (int i = 0; i < arraySize; i++) {
			integerArray[i] = sc.nextInt();
		}
		insertionSort(integerArray);
		printArray(integerArray);
	}

	public static void insertionSort(int[] array) {

		int numOfComparisons = 0;
		int length = array.length;
		for (int i = 1; i < length; i++) {
			int key = array[i];
			int insertPosition = i;

			while (insertPosition > 0 && array[insertPosition - 1] > key) {
				array[insertPosition] = array[insertPosition - 1];
				numOfComparisons++;
				insertPosition--;
			}
			array[insertPosition] = key;
		}
		System.out.println("Number of shifts: " + numOfComparisons);
	}

	public static void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
