package rechner_gui;

public class Check1 {

	public static void check1() {

		char[] c = new char[Rechner.text_input.length()];

		for (int i = 0; i < Rechner.text_input.length(); i++) {
			c[i] = Rechner.text_input.charAt(i);

//			Character.isDigit(string.charAt(index))
			if (Character.isDigit(c[Rechner.text_input.length() - 1])) {

				Rechner.activate = true;
			}
		}

	}
}
