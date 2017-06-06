package sid.hacker.dsa;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {

	public static void main(String[] args) {

		int[] nums = { 3, 3, 4, 6, 3 };

		long startTime = System.nanoTime();
		int major = getMajorityElement(nums);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);

		System.out.println("Majority Element: " + major + " calculated in " + duration);

	}

	public static int getMajorityElement(int[] nums) {

		int majorElement = 0;
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			int elementCount = 1;
			for (int j = i + 1; j < n; j++) {
				if (nums[i] == nums[j])
					elementCount += 1;
			}
			if (elementCount >= (n / 2)) {
				majorElement = nums[i];
			}
		}
		return majorElement;
	}

	public static int getMajorityElement2(int[] nums) {

		int majorElement = 0;
		int count = 0;
		int n = nums.length;
		HashMap<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {

			if (!elementCountMap.containsKey(nums[i])) {
				elementCountMap.put(nums[i], 1);
			} else {
				count = elementCountMap.get(nums[i]);
				if (count >= (n / 2)) {
					majorElement = nums[i];
					break;
				}
				count += 1;
				elementCountMap.put(nums[i], count);
			}
		}

		return majorElement;
	}

	public static int getMajorityElement3(int[] nums) {

		if(nums.length == 1)
			return nums[0];
		
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

}
