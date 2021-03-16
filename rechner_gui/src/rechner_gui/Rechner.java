package rechner_gui;

import java.lang.Math;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Rechner extends JPanel implements ActionListener {

	static String s;

	JFrame jf;
	JPanel jp;
	Draw draw;

	static JTextField textField;

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

//		JTextField
		JTextField textField = new JTextField("", 100);
		textField.setBounds(10, 20, 335, 40);

//		10 Tasten: 0 - 9

		for (int i = 0; i < 10; i++) {
			button[i] = new JButton("" + i);
			button[i].setVisible(true);

			button[i].setFocusPainted(true);

		}

		button[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textField.setText(textField.getText() + "0");

			}
		});

		button[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textField.setText(textField.getText() + "1");

			}
		});

		button[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textField.setText(textField.getText() + "2");

			}
		});

		button[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textField.setText(textField.getText() + "3");

			}
		});

		button[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textField.setText(textField.getText() + "4");

			}
		});

		button[5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textField.setText(textField.getText() + "5");

			}
		});

		button[6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textField.setText(textField.getText() + "6");

			}
		});

		button[7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textField.setText(textField.getText() + "7");

			}
		});

		button[8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textField.setText(textField.getText() + "8");

			}
		});

		button[9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textField.setText(textField.getText() + "9");

			}
		});

//		14 Tasten: +, -, *, / usw.
		btn0 = new JButton("+/-");
		btn0.setFocusPainted(true);
		btn0.setVisible(true);

		btn1 = new JButton(",");
		btn1.setFocusPainted(true);
		btn1.setVisible(true);

		btn2 = new JButton("=");
		btn2.setFocusPainted(true);
		btn2.setVisible(true);

		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

//				textField2.setText(textField.getText());
				s = textField.getText();

				char[] c = new char[s.length()];
				char[] o = new char[12];
				int[] operator_place = new int[30];
				operator_place[0] = 0;
				int j, k = 0, hilf = 0;
				double erg = 0, z1 = 0;
				double[] zahl = new double[30];
				int m = 0;
				double erg_2;
				String erg_1;
				double z[] = new double[10];

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

						if (c[i] == '*') {
							o[k] = '*';
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
//				Hier werden die einzelnen Zahlen an die jeweiligen Operationsfunktionen übergeben

				for (int i = 0; i <= k; i++) {

					erg = CalculateFunction.addition(zahl[0], zahl[1]);

				}

				erg_1 = Double.toString(erg);
				textField.setText(erg_1);

			}
		}

		);

		btn3 = new JButton("+");
		btn3.setFocusPainted(true);
		btn3.setVisible(true);
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				textField.setText(textField.getText() + "+");

			}
		}

		);

		btn4 = new JButton("-");
		btn4.setFocusPainted(true);
		btn4.setVisible(true);
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				textField.setText(textField.getText() + "-");

			}
		}

		);

		btn5 = new JButton("x");
		btn5.setFocusPainted(true);
		btn5.setVisible(true);
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				textField.setText(textField.getText() + "x");

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

				textField.setText(textField.getText() + "/");

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

				textField.setText("");

			}
		}

		);

		btn13 = new JButton("DEL");
		btn13.setFocusPainted(true);
		btn13.setVisible(true);

		ButtonPlacement.place();

//		JPanel
		jp = new JPanel();
		jp.setPreferredSize(new Dimension(355, 510));
		jp.setVisible(true);

//		JFrame
		jf = new JFrame();
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setTitle("Rechner");
		jf.getContentPane().add(jp);
		jf.pack();
		jf.setLocationRelativeTo(null);

//		Draw
		draw = new Draw();
		draw.setBounds(0, 0, 355, 510);
		draw.setVisible(true);

//		Add Buttons, jp, draw

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
		jf.add(textField);

		jf.add(draw);
		jf.add(jp);

		textField.setVisible(true);

		jf.setVisible(true);

	}

}
