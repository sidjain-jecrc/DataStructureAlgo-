package sid.hacker.dsa;

import java.util.Scanner;

public class TimeConversionSolution {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String time = in.next();

		String amOrPm = time.substring(time.length() - 2, time.length());
		String modifiedTime = time.substring(0, time.length() - 2);
		String[] hourMinSec = modifiedTime.split(":");

		if (amOrPm.equalsIgnoreCase("AM")) {
			if (hourMinSec[0].equals("12")) {
				hourMinSec[0] = "00";
			}
			System.out.println(hourMinSec[0] + ":" + hourMinSec[1] + ":" + hourMinSec[2]);

		} else {
			if (!hourMinSec[0].equals("12")) {
				hourMinSec[0] = String.valueOf((12 + Integer.parseInt(hourMinSec[0])));
				System.out.println(hourMinSec[0] + ":" + hourMinSec[1] + ":" + hourMinSec[2]);
			} else
				System.out.println(hourMinSec[0] + ":" + hourMinSec[1] + ":" + hourMinSec[2]);
		}

	}
}
