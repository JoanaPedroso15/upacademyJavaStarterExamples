package pt.upacademy.TIStateMachine.ScannerUtils;

import java.util.List;
import java.util.Scanner;

public class ScannerUtils {

	private Scanner sc = new Scanner(System.in);
	private Scanner lineSc;

	public String getValue() {
		return sc.nextLine();
	}

	public boolean isInt(String value) {
		lineSc = new Scanner(value);
		return lineSc.hasNextInt();
	}

	public int toInt(String value) {
		lineSc = new Scanner(value);
		return lineSc.nextInt();
	}

private int getIntFromScannerHelper (String input, boolean canBeNull) {
	if (canBeNull && input.equals("")) {
		return -1;
	} else {
		return 0;
	}
}

	public int getInt(String msg) {
		System.out.println(msg);
		while (true) {
			String value = getValue();
			if (getIntFromScannerHelper(value, true) == -1) {
				return -1;
			};
			Scanner sc2 = new Scanner(value);
			if (sc2.hasNextInt()) {
				return sc2.nextInt();
			} else {
				// System.out.println("Tem que ser um numero inteiro!");
				sc2.nextLine();
			}
			sc2.close();
		}
	}

	public float getFloat(String msg) {
		System.out.println(msg);
		while (true) {
			String value = getValue();
			Scanner sc2 = new Scanner(value);
			if (sc2.hasNextFloat()) {
				return sc2.nextFloat();
			} else {
				// System.out.println("Tem que ser um numero inteiro!");
				sc2.nextLine();
			}
			sc2.close();
		}
	}

	public int isValid(String msg, int[] array) {
		int len = array.length;
		boolean bool = true;
		while (true) {
			int value = getInt(msg);
			for (int index = 0; index < len; index++) {
				if (array[index] == value) {
					return value;
				} else {
					bool = false;
				}
			}
			if (bool == false) {
				System.out.println("Input errado");
			}
		}
	}
	


}
