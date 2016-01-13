package sid.practice.strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


/**
 * @author Siddharth Jain
 * 
 * Given any string like "ABCFFBC" and length of the substring, 
 * find the counts of all possible substrings with the given length.
 *
 */
public class SubStringCount {

	public static void main(String[] args) {

		String input = "ABCABC";
		int lenSubString = 3;
		HashMap<String, Integer> map = getSubStringCount(input, lenSubString);

		Set keys = map.keySet();
		Iterator<String> i = keys.iterator();
		while (i.hasNext()) {
			String key = i.next();
			int count = (int) map.get(key);
			System.out.println(key + ":" + count);
		}

	}

	public static HashMap<String, Integer> getSubStringCount(String inputString, int subLength) {

		HashMap<String, Integer> subStringCountMap = new HashMap<String, Integer>();
		for (int i = 0; i + subLength <= inputString.length(); i++) {
			String sub = inputString.substring(i, i + subLength);
			if (!subStringCountMap.containsKey(sub)) {
				subStringCountMap.put(sub, 1);
			} else {
				int OldCount = subStringCountMap.get(sub);
				subStringCountMap.put(sub, OldCount + 1);
			}
		}
		return subStringCountMap;
	}

}
