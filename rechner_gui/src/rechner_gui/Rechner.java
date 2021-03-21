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

	static ActionListener buttonListener1;

	static double erg;
	static String erg_1;
	static String text_input;
	static boolean activate = false;

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

//		Create the number buttons 0 - 9

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

//		Create the 14 buttons and add to each one ActionListener
		btn0 = new JButton("+/-");
		btn0.setFocusPainted(true);
		btn0.setVisible(true);

		btn1 = new JButton(",");
		btn1.setFocusPainted(true);
		btn1.setVisible(true);

		btn2 = new JButton("=");
		btn2.setFocusPainted(true);

		AbstractAction aa = new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {

				text_input = textArea.getText();
				CalculateFunction1.calculation();
				textArea.setText(textArea.getText() + "=\n" + erg_1);
			}

		};
		btn2.addActionListener(aa); // button kann gedrückt werden
		btn2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
		btn2.getActionMap().put("Enter", aa);
		btn2.setVisible(true);

		btn3 = new JButton("+");
		btn3.setFocusPainted(true);
		btn3.setVisible(true);

		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				Make a '+' only if there is a number before 
				text_input = textArea.getText();
				Check1.check1();

//				
				if (activate == true) {
					textArea.setText(textArea.getText() + "+");
					activate = false;
				}

			}
		}

		);

		btn4 = new JButton("-");
		btn4.setFocusPainted(true);
		btn4.setVisible(true);
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

//				Make a '-' only if there is a number before 
				text_input = textArea.getText();
				Check1.check1();

				if (activate == true) {
					textArea.setText(textArea.getText() + "-");
					activate = false;
				}

			}
		}

		);

		btn5 = new JButton("x");
		btn5.setFocusPainted(true);
		btn5.setVisible(true);
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

//				Make a 'x' only if there is a number before 
				text_input = textArea.getText();
				Check1.check1();

				if (activate == true) {
					textArea.setText(textArea.getText() + "x");
					activate = false;
				}

			}
		}

		);

		btn6 = new JButton("1/x");
		btn6.setFocusPainted(true);
		btn6.setVisible(true);

		btn7 = new JButton("x²");
		btn7.setFocusPainted(true);
		btn7.setVisible(true);
		btn7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				erg = Math.pow(erg, 2);

				erg_1 = Double.toString(erg);

				textArea.setText(textArea.getText() + "=\n" + erg_1);

			}

		});

		btn8 = new JButton("sqrt(x)");
		btn8.setFocusPainted(true);
		btn8.setVisible(true);

		btn9 = new JButton("/");
		btn9.setFocusPainted(true);
		btn9.setVisible(true);
		btn9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

//				Make a '/' only if there is a number before 
				text_input = textArea.getText();
				Check1.check1();

				if (activate == true) {
					textArea.setText(textArea.getText() + "/");
					activate = false;
				}

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

}
