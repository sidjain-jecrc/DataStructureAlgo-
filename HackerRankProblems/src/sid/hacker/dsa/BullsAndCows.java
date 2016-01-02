package sid.hacker.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BullsAndCows {

	public static void main(String[] args) {

		String secret = "1122";
		String guess = "2211";
		String cowsAndBull = getHint(secret, guess);
		System.out.println(cowsAndBull);
	}

	public static String getHint(String secret, String guess) {

		int len = guess.length();
		int cows = 0;
		int bulls = 0;
		List<Character> cowCharsList = new ArrayList<Character>();

		for (int i = 0; i < len; i++) {
			if (guess.charAt(i) == secret.charAt(i)) {
				bulls += 1;
				continue;
			}
			for (int j = 0; j < len; j++) {
				if (guess.charAt(i) == secret.charAt(j) && i != j && !cowCharsList.contains(secret.charAt(j))) {
					cowCharsList.add(secret.charAt(j));
					cows += 1;
				}
			}
		}
		return bulls + "A" + cows + "B";
	}

	public static String getHint2(String secret, String guess) {

		int len = guess.length();
		int cows = 0;
		int bulls = 0;
		List<Character> cowCharsList = new ArrayList<Character>();
		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();

		for (int i = 0; i < len; i++) {
          if(!charCountMap.containsKey(secret.charAt(i))){
        	  charCountMap.put(secret.charAt(i), 1);
          }else{
        	  charCountMap.put(secret.charAt(i), charCountMap.get(secret.charAt(i)) + 1);
          }
		}

		return "";
	}

}
