package rechner_gui;

import java.util.Scanner;

public class CalculateFunction {

	static double erg;

	public static double addition(double erg1, double zahl) {

		erg = erg1 + zahl;
		return erg;

	}

	public static double subtraktion(double erg1, double zahl) {

		erg = erg1 - zahl;
		return erg;

	}

	public static double multiplikation(double erg1, double zahl) {

		erg = erg1 * zahl;
		return erg;

	}

	public static double division(double erg1, double zahl) {

		erg = erg1 / zahl;
		return erg;

	}

}
