package rechner_gui;

public class CalculateFunction1 {

	public static void calculation() {

		char[] c = new char[Rechner.text_input.length()];
		char[] o = new char[12];
		int[] operator_place = new int[30];
		operator_place[0] = 0;
		int j, k = 0, hilf = 0;
		double z1 = 0;
		double[] zahl = new double[30];
		int m = 0;
		double z[] = new double[200];
		Rechner.erg = 0;

		for (int i = 0; i < Rechner.text_input.length(); i++) {
			c[i] = Rechner.text_input.charAt(i);

			// Hier wird geprüft ob das char Zeichen an der i. Stelle ein Operator ist
			if (c[i] == '+' || c[i] == '-' || c[i] == 'x' || c[i] == '/' || i == (Rechner.text_input.length() - 1)) {

				operator_place[m] = i;

//					Hier wird der jeweilige Operator in einen Array gespeichert
				if (c[i] == '+') {
					o[k] = '+';
				}

				if (c[i] == '-') {
					o[k] = '-';
				}

				if (c[i] == 'x') {
					o[k] = 'x';
				}

				if (c[i] == '/') {
					o[k] = '/';
				}

				if (m == 0) {
//						double z[] = new double[i];

					// Hier wird die k. Zahl gebildet
					for (j = 0; j < i; j++) {
						hilf = Character.getNumericValue(c[j]);
						z[j] = hilf;
						z[j] = z[j] * Math.pow(10, i - (j + 1));
						z1 = z1 + z[j]; // hier die Zahl in ein Array der eingegebenen Zahlen speichern
					}

					zahl[k] = z1;

				}

//					Ab 2. Zahl bis vorletzte Zahl:
				if (m > 0 && i != (Rechner.text_input.length() - 1)) {
//						double z[] = new double[50];
					z1 = 0;
					// Hier wird die k. Zahl gebildet
					for (j = operator_place[m - 1] + 1; j < i; j++) {
						hilf = Character.getNumericValue(c[j]);
						z[j] = hilf;
						z[j] = z[j] * Math.pow(10, i - (j + 1));
						z1 = z1 + z[j]; // hier die Zahl in ein Array der eingegebenen Zahlen speichern
					}

					zahl[k] = z1;

				}

//					Für die letzte Zahl:
				if (i == (Rechner.text_input.length() - 1)) {
//						double z[] = new double[50];
					z1 = 0;
					// Hier wird die k. Zahl gebildet
					for (j = operator_place[m - 1] + 1; j <= i; j++) {
						hilf = Character.getNumericValue(c[j]);
						z[j] = hilf;
						z[j] = z[j] * Math.pow(10, i - j);
						z1 = z1 + z[j]; // hier die Zahl in ein Array der eingegebenen Zahlen speichern
					}

					zahl[k] = z1;

				}

				m++;
				k++;

			}

		}

//			Rechenoperationen:
//			Hier werden die einzelnen Zahlen an die jeweiligen Operationsfunktionen übergeben

		for (int i = 0; i <= k; i++) {

			if (i == 0) {
				Rechner.erg = zahl[i];
			}

			if (o[i] == '+') {

				Rechner.erg = CalculateFunction2.addition(Rechner.erg, zahl[i + 1]);
			}

			if (o[i] == '-') {
				Rechner.erg = CalculateFunction2.subtraction(Rechner.erg, zahl[i + 1]);
			}

			if (o[i] == 'x') {
				Rechner.erg = CalculateFunction2.multiplication(Rechner.erg, zahl[i + 1]);
			}

			if (o[i] == '/') {
				Rechner.erg = CalculateFunction2.division(Rechner.erg, zahl[i + 1]);
			}

		}

		Rechner.erg_1 = Double.toString(Rechner.erg);

		Rechner.btn2.requestFocusInWindow(); // request that the button has focus

	}

}
