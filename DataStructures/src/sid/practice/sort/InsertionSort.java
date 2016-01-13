package sid.practice.sort;

import java.util.Scanner;


/**
 * @author Siddharth Jain
 * 
 * Insertion Sort Algorithm Challenge from Hackerrank.com
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
		insertionSort2(integerArray);
	}

	public static void insertIntoSortedArray(int[] arr) {

		int numToInsert = arr[arr.length - 1];
		boolean isNumInserted = false;
		for (int i = arr.length - 2; i >= -1; i--) {
			if (i != -1) {
				if (arr[i] > numToInsert) {
					arr[i + 1] = arr[i];

				} else {
					arr[i + 1] = numToInsert;
					isNumInserted = true;
				}
			} else {
				arr[i + 1] = numToInsert;
				isNumInserted = true;
			}
			printArray(arr);
			if (isNumInserted)
				break;
		}

	}

	public static void insertionSort(int[] arr) {

		int numOfShifts = 0;
		for (int i = 1; i < arr.length; i++) {

			int key = arr[i];
			boolean isKeyInserted = false;

			for (int j = i - 1; j >= -1; j--) {
				if (j != -1) {
					if (arr[j] > key) {
						arr[j + 1] = arr[j];
						numOfShifts++;

					} else {
						arr[j + 1] = key;
						isKeyInserted = true;
					}
				} else {
					arr[j + 1] = key;
					isKeyInserted = true;
				}
				if (isKeyInserted)
					break;
			}
			printArray(arr);
		}
		System.out.println("Shifts: " + numOfShifts);
	}

	public static void insertionSort2(int[] A) {

		int numOfShifts = 0;
		for (int i = 1; i < A.length; i++) {
			int value = A[i];
			int j = i - 1;

			while (j >= 0 && A[j] > value) {
				A[j + 1] = A[j];
				numOfShifts++;
				j = j - 1;
			}
			A[j + 1] = value;
		}
		System.out.println("Shifts: " + numOfShifts);
	}

	public static void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
