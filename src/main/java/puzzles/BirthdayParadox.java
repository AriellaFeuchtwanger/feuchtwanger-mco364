package puzzles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class BirthdayParadox {
	static final Random RAND = new Random();

	public static void main(String[] args) {

		// first int = # of ppl. Second in = times matching b-day
		double percentage = 0.0;
		int ppl = 2;

		while (percentage < .99) {
			double timesTrue = 0;
			for (int i = 0; i < 10000; i++) {
				if (findDuplicateBirthdays(ppl)) {
					timesTrue++;
				}
			}
			percentage = timesTrue / 10000;
			System.out.println(ppl + " : " + percentage);
			ppl++;
		}
	}

	public static boolean findDuplicateBirthdays(int ppl) {
		boolean[] birthdays = new boolean[365];
		int day;

		for (int i = 0; i < ppl; i++) {
			day = RAND.nextInt(365);

			if (!birthdays[day]) {
				birthdays[day] = true;
			} else {
				return true;
			}
		}

		return false;
	}
}
