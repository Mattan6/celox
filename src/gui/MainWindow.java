package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class MainWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JLabel textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlHeader = new JPanel();
		pnlHeader.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(pnlHeader, BorderLayout.NORTH);
		
		JButton btnNewButton_2 = new JButton("New button");
		pnlHeader.add(btnNewButton_2);
		
		JPanel pnlFooter = new JPanel();
		pnlFooter.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(pnlFooter, BorderLayout.SOUTH);
		
		JButton btnNewButton_3 = new JButton("New button");
		pnlFooter.add(btnNewButton_3);
		
		JPanel pnlRight = new JPanel();
		pnlRight.setBackground(Color.GREEN);
		frame.getContentPane().add(pnlRight, BorderLayout.EAST);
		
		JButton btnNewButton_1 = new JButton("New button");
		pnlRight.add(btnNewButton_1);
		
		JPanel pnlLeft = new JPanel();
		pnlLeft.setBackground(Color.GREEN);
		frame.getContentPane().add(pnlLeft, BorderLayout.WEST);
		
		JButton btnNewButton = new JButton("New button");
		pnlLeft.add(btnNewButton);
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.setBackground(Color.WHITE);
		frame.getContentPane().add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new GridLayout(6, 8, 1, 4));
		
		JLabel lblInput = new JLabel("Input");
		pnlCenter.add(lblInput);
		
		JLabel lblClassA = new JLabel("Class A");
		lblClassA.setBackground(Color.WHITE);
		pnlCenter.add(lblClassA);
		
		JLabel lblClassB = new JLabel("Class B");
		pnlCenter.add(lblClassB);
		
		JLabel lblClassC = new JLabel("Class c");
		pnlCenter.add(lblClassC);
		
		JLabel lblClassD = new JLabel("Class D");
		pnlCenter.add(lblClassD);
		
		JLabel lblClassE = new JLabel("Class E");
		pnlCenter.add(lblClassE);
		
		JLabel lblClassF = new JLabel("Class F");
		pnlCenter.add(lblClassF);
		
		JLabel lblWaste = new JLabel("Waste");
		pnlCenter.add(lblWaste);
		
		JLabel lblLength = new JLabel("Length");
		pnlCenter.add(lblLength);
		
		textField_5 = new JTextField();
		pnlCenter.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_16 = new JButton("New button");
		pnlCenter.add(btnNewButton_16);
		
		JButton btnNewButton_9 = new JButton("New button");
		pnlCenter.add(btnNewButton_9);
		
		textField_9 = new JTextField();
		pnlCenter.add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnNewButton_11 = new JButton("New button");
		pnlCenter.add(btnNewButton_11);
		
		JButton btnNewButton_10 = new JButton("New button");
		pnlCenter.add(btnNewButton_10);
		
		textField_10 = new JTextField();
		pnlCenter.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblDiameter = new JLabel("Diameter");
		pnlCenter.add(lblDiameter);
		
		JButton btnNewButton_15 = new JButton("New button");
		pnlCenter.add(btnNewButton_15);
		
		JButton btnNewButton_8 = new JButton("New button");
		pnlCenter.add(btnNewButton_8);
		
		JButton btnNewButton_7 = new JButton("New button");
		pnlCenter.add(btnNewButton_7);
		
		JButton btnNewButton_12 = new JButton("New button");
		pnlCenter.add(btnNewButton_12);
		
		JButton btnNewButton_5 = new JButton("New button");
		pnlCenter.add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("New button");
		pnlCenter.add(btnNewButton_4);
		
		textField_8 = new JTextField();
		pnlCenter.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblBroken = new JLabel("Broken");
		pnlCenter.add(lblBroken);
		
		textField_6 = new JTextField();
		pnlCenter.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		pnlCenter.add(textField_7);
		textField_7.setColumns(10);
		
		textField_4 = new JTextField();
		pnlCenter.add(textField_4);
		textField_4.setColumns(10);
		
		textField = new JTextField();
		pnlCenter.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		pnlCenter.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("New button");
		pnlCenter.add(btnNewButton_6);
		
		JButton btnNewButton_13 = new JButton("New button");
		pnlCenter.add(btnNewButton_13);
		
		JLabel lblS_Shape = new JLabel("S Shape");
		pnlCenter.add(lblS_Shape);
		
		JButton btnNewButton_14 = new JButton("New button");
		pnlCenter.add(btnNewButton_14);
		
		textField_2 = new JTextField();
		pnlCenter.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		pnlCenter.add(textField_3);
		textField_3.setColumns(10);
		
		textField_11 = new JTextField();
		pnlCenter.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		pnlCenter.add(textField_12);
		textField_12.setColumns(10);
		
		textField_16 = new JTextField();
		pnlCenter.add(textField_16);
		textField_16.setColumns(10);
		
		textField_13 = new JTextField();
		pnlCenter.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JLabel("C Shape");
		pnlCenter.add(textField_14);
		
		textField_15 = new JTextField();
		pnlCenter.add(textField_15);
		textField_15.setColumns(10);
		
		textField_17 = new JTextField();
		pnlCenter.add(textField_17);
		textField_17.setColumns(10);
		
		JButton btnNewButton_17 = new JButton("New button");
		pnlCenter.add(btnNewButton_17);
		
		JButton btnNewButton_18 = new JButton("New button");
		pnlCenter.add(btnNewButton_18);
		
		JButton btnNewButton_19 = new JButton("New button");
		pnlCenter.add(btnNewButton_19);
		
		JButton btnNewButton_20 = new JButton("New button");
		pnlCenter.add(btnNewButton_20);
		
		textField_18 = new JTextField();
		pnlCenter.add(textField_18);
		textField_18.setColumns(10);
		

		
		
		
	}
}
