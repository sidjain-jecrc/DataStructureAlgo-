package sid.hacker.dsa;

import java.util.HashSet;

public class LonelyInteger {

	public static void main(String[] args) {

		int[] demo = { 1, 1, 2, 2, 4, 4, 9, 9, 5, 7, 7 };
		System.out.println(lonelyInteger(demo));
	}

	public static int lonelyInteger(int[] arr) {

		int lonelyInt = 0;
		HashSet<Integer> intSet = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {

			if (!intSet.contains(arr[i])) {
				intSet.add(arr[i]);
			} else {
				intSet.remove(arr[i]);
			}
		}
		for (int i : intSet) {
			lonelyInt = i;
		}
		return lonelyInt;

	}

}
