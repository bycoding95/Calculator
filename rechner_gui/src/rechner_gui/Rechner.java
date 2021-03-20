package rechner_gui;

import java.lang.Math;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import java.awt.event.KeyAdapter;

public class Rechner extends JPanel implements ActionListener {

	JFrame jf;
	JPanel jp;

	static JTextArea textArea;
	static Action pressedAction;

	static JButton button[] = new JButton[10];
	static JButton btn0;
	static JButton btn1;
	static JButton btn2;
	static JButton btn3;
	static JButton btn4;
	static JButton btn5;
	static JButton btn6;
	static JButton btn7;
	static JButton btn8;
	static JButton btn9;
	static JButton btn10;
	static JButton btn11;
	static JButton btn12;
	static JButton btn13;

	float zahl1;

//	Standardkonstruktor
	public Rechner() {
		// TODO Auto-generated constructor stub

//	width JFrame: 355

//		new JTextArea
		JTextArea textArea = new JTextArea(2, 10);

//		new JScrollPane (Scrollleiste)
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setBounds(20, 50, 335, textArea.getLineCount() * 10);
		textArea.setEditable(true);

//		TextArea Font 
		Font fontTextArea = new Font("Arial", Font.BOLD, 30);
		textArea.setFont(fontTextArea);

//		Erstelle die 10 Tasten: 0 - 9

		for (int i = 0; i < 10; i++) {
			button[i] = new JButton("" + i);
			button[i].setVisible(true);

			button[i].setFocusPainted(true);

		}

		button[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textArea.setText(textArea.getText() + "0");

			}
		});

		button[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textArea.setText(textArea.getText() + "1");

			}
		});

		button[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textArea.setText(textArea.getText() + "2");

			}
		});

		button[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textArea.setText(textArea.getText() + "3");

			}
		});

		button[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textArea.setText(textArea.getText() + "4");

			}
		});

		button[5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textArea.setText(textArea.getText() + "5");

			}
		});

		button[6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textArea.setText(textArea.getText() + "6");

			}
		});

		button[7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textArea.setText(textArea.getText() + "7");

			}
		});

		button[8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textArea.setText(textArea.getText() + "8");

			}
		});

		button[9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textArea.setText(textArea.getText() + "9");

			}
		});

//		Erstelle die 14 Tasten mit ActionListener: +, -, *, / usw.
		btn0 = new JButton("+/-");
		btn0.setFocusPainted(true);
		btn0.setVisible(true);

		btn1 = new JButton(",");
		btn1.setFocusPainted(true);
		btn1.setVisible(true);

		btn2 = new JButton("=");
		btn2.setFocusPainted(true);

		btn2.addActionListener(new ActionListener() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {

				String s;

				s = textArea.getText();

				char[] c = new char[s.length()];
				char[] o = new char[12];
				int[] operator_place = new int[30];
				operator_place[0] = 0;
				int j, k = 0, hilf = 0;
				double erg = 0, z1 = 0;
				double[] zahl = new double[30];
				int m = 0;
				String erg_1;
				double z[] = new double[200];

				for (int i = 0; i < s.length(); i++) {
					c[i] = s.charAt(i);

					// Hier wird geprüft ob das char Zeichen an der i. Stelle ein Operator ist
					if (c[i] == '+' || c[i] == '-' || c[i] == 'x' || c[i] == '/' || i == (s.length() - 1)) {

						operator_place[m] = i;

//						Hier wird der jeweilige Operator in einen Array gespeichert
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
//							double z[] = new double[i];

							// Hier wird die k. Zahl gebildet
							for (j = 0; j < i; j++) {
								hilf = Character.getNumericValue(c[j]);
								z[j] = hilf;
								z[j] = z[j] * Math.pow(10, i - (j + 1));
								z1 = z1 + z[j]; // hier die Zahl in ein Array der eingegebenen Zahlen speichern
							}

							zahl[k] = z1;

						}

//						Ab 2. Zahl bis vorletzte Zahl:
						if (m > 0 && i != (s.length() - 1)) {
//							double z[] = new double[50];
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

//						Für die letzte Zahl:
						if (i == (s.length() - 1)) {
//							double z[] = new double[50];
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

//				Rechenoperationen:
//				Hier werden die einzelnen Zahlen an die jeweiligen Operationsfunktionen übergeben

				for (int i = 0; i <= k; i++) {

					if (i == 0) {
						erg = zahl[i];
					}

					if (o[i] == '+') {

						erg = CalculateFunction.addition(erg, zahl[i + 1]);
					}

					if (o[i] == '-') {
						erg = CalculateFunction.subtraktion(erg, zahl[i + 1]);
					}

					if (o[i] == 'x') {
						erg = CalculateFunction.multiplikation(erg, zahl[i + 1]);
					}

					if (o[i] == '/') {
						erg = CalculateFunction.division(erg, zahl[i + 1]);
					}

				}

				erg_1 = Double.toString(erg);

				textArea.setText(textArea.getText() + "=\n" + erg_1);

//				Rechner.btn2.requestFocusInWindow(); // request that the button has focus

			}

		});

//		btn2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
//		btn2.getActionMap().put("Enter", aa);
//		btn2.addActionListener(aa); // button kann gedrückt werden
		btn2.setVisible(true);

		btn3 = new JButton("+");
		btn3.setFocusPainted(true);
		btn3.setVisible(true);
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				textArea.setText(textArea.getText() + "+");

			}
		}

		);

		btn4 = new JButton("-");
		btn4.setFocusPainted(true);
		btn4.setVisible(true);
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				textArea.setText(textArea.getText() + "-");

			}
		}

		);

		btn5 = new JButton("x");
		btn5.setFocusPainted(true);
		btn5.setVisible(true);
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				textArea.setText(textArea.getText() + "x");

			}
		}

		);

		btn6 = new JButton("1/x");
		btn6.setFocusPainted(true);
		btn6.setVisible(true);

		btn7 = new JButton("x²");
		btn7.setFocusPainted(true);
		btn7.setVisible(true);

		btn8 = new JButton("sqrt(x)");
		btn8.setFocusPainted(true);
		btn8.setVisible(true);

		btn9 = new JButton("/");
		btn9.setFocusPainted(true);
		btn9.setVisible(true);
		btn9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				textArea.setText(textArea.getText() + "/");

			}
		}

		);

		btn10 = new JButton("%");
		btn10.setFocusPainted(true);
		btn10.setVisible(true);

		btn11 = new JButton("CE");
		btn11.setFocusPainted(true);
		btn11.setVisible(true);

		btn12 = new JButton("C");
		btn12.setFocusPainted(true);
		btn12.setVisible(true);
		btn12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				textArea.setText("");

			}
		}

		);

		btn13 = new JButton("DEL");
		btn13.setFocusPainted(true);
		btn13.setVisible(true);
		btn13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				textArea.setText("" + textArea.getText().substring(0, textArea.getText().length() - 1));
			}

		});

		// Die Positionen der Buttons
		ButtonPlacement.place();

//		JPanel	-	width:330, height: 
		jp = new JPanel();
		jp.setPreferredSize(new Dimension(330, 440));
		jp.setVisible(true);

//		JFrame
		jf = new JFrame();
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setTitle("Rechner");
		jf.getContentPane().add(jp);
		jf.pack();
		jf.setLocationRelativeTo(null);

//		Add Buttons, Panel, Scrollpane

		for (int i = 0; i < 10; i++) {
			jf.add(button[i]);

		}

		jf.add(btn0);
		jf.add(btn1);
		jf.add(btn2);
		jf.add(btn3);
		jf.add(btn4);
		jf.add(btn5);
		jf.add(btn6);
		jf.add(btn7);
		jf.add(btn8);
		jf.add(btn9);
		jf.add(btn10);
		jf.add(btn11);
		jf.add(btn12);
		jf.add(btn13);
		jf.getContentPane().add(jp);
		jp.add(scrollPane, BorderLayout.PAGE_END);

		jf.add(jp);

		textArea.setVisible(true);
		jp.setVisible(true);
		jf.setVisible(true);

	}

	private class DerHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

		}

	}

}
