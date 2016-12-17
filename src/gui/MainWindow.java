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
import javax.swing.JSpinner;
import java.awt.FlowLayout;
import javax.swing.SpinnerNumberModel;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class MainWindow {

	private JFrame frame;

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
		
		///////////// building the main frame ////////////////////
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0,0));
		
		
		////////////// building the main frame's menu bar //////////////////////////
		
		JMenuBar mainMenuBar = new JMenuBar();
		frame.setJMenuBar(mainMenuBar);

		JMenu mnFile = new JMenu("File");
		mainMenuBar.add(mnFile);

		JMenuItem mntmNewSort = new JMenuItem("New Sort");
		mnFile.add(mntmNewSort);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		mntmExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});

		JMenu mnActions = new JMenu("Actions");
		mainMenuBar.add(mnActions);

		JMenu mnStatistics = new JMenu("Statistics");
		mainMenuBar.add(mnStatistics);
		
		////////////////// main window header panel ////////////////

		JPanel pnlHeader = new JPanel();
		pnlHeader.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(pnlHeader, BorderLayout.NORTH);

		JButton btnNewButton_2 = new JButton("New button");
		pnlHeader.add(btnNewButton_2);
		
		
		///////////////// main frame footer panel /////////////////////////

		JPanel pnlFooter = new JPanel();
		pnlFooter.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(pnlFooter, BorderLayout.SOUTH);

		JButton btnNewButton_3 = new JButton("New button");
		pnlFooter.add(btnNewButton_3);
		
		
		/////////////////  main frame right panel /////////////////////////

		JPanel pnlRight = new JPanel();
		pnlRight.setBackground(Color.GREEN);
		frame.getContentPane().add(pnlRight, BorderLayout.EAST);

		JButton btnNewButton_1 = new JButton("New button");
		pnlRight.add(btnNewButton_1);

		
		///////////////// main frame left panel //////////////////////////
		
		JPanel pnlLeft = new JPanel();
		pnlLeft.setBackground(Color.GREEN);
		frame.getContentPane().add(pnlLeft, BorderLayout.WEST);
		
		JButton btnNewButton = new JButton("New button");
		pnlLeft.add(btnNewButton);
		
		//////////////// main frame center panel //////////////////////////

		JPanel pnlCenter = new JPanel();
		pnlCenter.setBackground(Color.WHITE);
		frame.getContentPane().add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new GridLayout(10, 7, 0, 1));

		/////////////// class types /////////////////////////////
		
		JLabel lblInput = new JLabel("Input");
		lblInput.setForeground(Color.RED);
		lblInput.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		lblInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblInput.setBackground(Color.WHITE);
		pnlCenter.add(lblInput);

		JLabel lblClassA = new JLabel("Class A");
		lblClassA.setFont(new Font("Arial", Font.BOLD, 15));
		lblClassA.setHorizontalAlignment(SwingConstants.CENTER);
		lblClassA.setBackground(Color.WHITE);
		pnlCenter.add(lblClassA);

		JLabel lblClassB = new JLabel("Class B");
		lblClassB.setFont(new Font("Arial", Font.BOLD, 15));
		lblClassB.setHorizontalAlignment(SwingConstants.CENTER);
		lblClassB.setBackground(Color.WHITE);
		pnlCenter.add(lblClassB);

		JLabel lblClassC = new JLabel("Class c");
		lblClassC.setFont(new Font("Arial", Font.BOLD, 15));
		lblClassC.setHorizontalAlignment(SwingConstants.CENTER);
		lblClassC.setBackground(Color.WHITE);
		pnlCenter.add(lblClassC);

		JLabel lblClassD = new JLabel("Class D");
		lblClassD.setFont(new Font("Arial", Font.BOLD, 15));
		lblClassD.setHorizontalAlignment(SwingConstants.CENTER);
		lblClassD.setBackground(Color.WHITE);
		pnlCenter.add(lblClassD);

		JLabel lblClassE = new JLabel("Class E");
		lblClassE.setFont(new Font("Arial", Font.BOLD, 15));
		lblClassE.setHorizontalAlignment(SwingConstants.CENTER);
		lblClassE.setBackground(Color.WHITE);
		pnlCenter.add(lblClassE);

		JLabel lblClassF = new JLabel("Class F");
		lblClassF.setFont(new Font("Arial", Font.BOLD, 15));
		lblClassF.setHorizontalAlignment(SwingConstants.CENTER);
		lblClassF.setBackground(Color.WHITE);
		pnlCenter.add(lblClassF);

		JLabel lblLength = new JLabel("Length");
		lblLength.setFont(new Font("Arial", Font.BOLD, 15));
		lblLength.setHorizontalAlignment(SwingConstants.CENTER);
		lblLength.setBackground(Color.WHITE);
		pnlCenter.add(lblLength);

		JPanel pnlLengthA = new JPanel();
		pnlLengthA.setBackground(Color.WHITE);
		pnlCenter.add(pnlLengthA);
		pnlLengthA.setLayout(new GridLayout(2, 2, 0, 20));

		JLabel lblLengthFromA = new JLabel("From");
		lblLengthFromA.setHorizontalAlignment(SwingConstants.CENTER);
		pnlLengthA.add(lblLengthFromA);
		lblLengthFromA.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblLengthFromA.setFont(new Font("Arial", Font.PLAIN, 12));


		JSpinner spnLengthFromA = new JSpinner();
		spnLengthFromA.setPreferredSize(new Dimension(120, 18));
		spnLengthFromA.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnLengthFromA.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlLengthA.add(spnLengthFromA);

		JLabel lblLengthToA = new JLabel("To");
		lblLengthToA.setHorizontalAlignment(SwingConstants.CENTER);
		lblLengthToA.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLengthToA.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pnlLengthA.add(lblLengthToA);

		JSpinner spnLengthToA = new JSpinner();
		spnLengthToA.setPreferredSize(new Dimension(120, 18));
		spnLengthToA.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlLengthA.add(spnLengthToA);



		JPanel pnlLengthB = new JPanel();
		pnlCenter.add(pnlLengthB);



		pnlLengthB.setBackground(Color.WHITE);
		pnlLengthB.setLayout(new GridLayout(2, 2, 0, 20));

		JLabel lblLengthFromB = new JLabel("From");
		lblLengthFromB.setHorizontalAlignment(SwingConstants.CENTER);
		pnlLengthB.add(lblLengthFromB);
		lblLengthFromB.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblLengthFromB.setFont(new Font("Arial", Font.PLAIN, 12));


		JSpinner spnLengthFromB = new JSpinner();
		spnLengthFromB.setPreferredSize(new Dimension(120, 18));
		spnLengthFromB.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnLengthFromB.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlLengthB.add(spnLengthFromB);

		JLabel lblLengthToB = new JLabel("To");
		lblLengthToB.setHorizontalAlignment(SwingConstants.CENTER);
		lblLengthToB.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLengthToB.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pnlLengthB.add(lblLengthToB);

		JSpinner spnLengthToB = new JSpinner();
		spnLengthToB.setPreferredSize(new Dimension(120, 18));
		spnLengthToB.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlLengthB.add(spnLengthToB);



		JPanel pnlLengthC = new JPanel();
		pnlCenter.add(pnlLengthC);


		pnlLengthC.setBackground(Color.WHITE);
		pnlLengthC.setLayout(new GridLayout(2, 2, 0, 20));

		JLabel lblLengthFromC = new JLabel("From");
		lblLengthFromC.setHorizontalAlignment(SwingConstants.CENTER);
		pnlLengthC.add(lblLengthFromC);
		lblLengthFromC.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblLengthFromC.setFont(new Font("Arial", Font.PLAIN, 12));


		JSpinner spnLengthFromC = new JSpinner();
		spnLengthFromC.setPreferredSize(new Dimension(120, 18));
		spnLengthFromC.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnLengthFromC.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlLengthC.add(spnLengthFromC);

		JLabel lbLengthlToC = new JLabel("To");
		lbLengthlToC.setHorizontalAlignment(SwingConstants.CENTER);
		lbLengthlToC.setFont(new Font("Arial", Font.PLAIN, 12));
		lbLengthlToC.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pnlLengthC.add(lbLengthlToC);

		JSpinner spnLengthToC = new JSpinner();
		spnLengthToC.setPreferredSize(new Dimension(120, 18));
		spnLengthToC.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlLengthC.add(spnLengthToC);



		JPanel pnlLengthD = new JPanel();
		pnlCenter.add(pnlLengthD);



		pnlLengthD.setBackground(Color.WHITE);
		pnlLengthD.setLayout(new GridLayout(2, 2, 0, 20));

		JLabel lblLengthFromD = new JLabel("From");
		lblLengthFromD.setHorizontalAlignment(SwingConstants.CENTER);
		pnlLengthD.add(lblLengthFromD);
		lblLengthFromD.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblLengthFromD.setFont(new Font("Arial", Font.PLAIN, 12));


		JSpinner spnLengthFromD = new JSpinner();
		spnLengthFromD.setPreferredSize(new Dimension(120, 18));
		spnLengthFromD.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnLengthFromD.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlLengthD.add(spnLengthFromD);

		JLabel lbLengthlToD = new JLabel("To");
		lbLengthlToD.setHorizontalAlignment(SwingConstants.CENTER);
		lbLengthlToD.setFont(new Font("Arial", Font.PLAIN, 12));
		lbLengthlToD.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pnlLengthD.add(lbLengthlToD);

		JSpinner spnLengthToD = new JSpinner();
		spnLengthToD.setPreferredSize(new Dimension(120, 18));
		spnLengthToD.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlLengthD.add(spnLengthToD);



		JPanel pnlLengthE = new JPanel();
		pnlCenter.add(pnlLengthE);

		pnlLengthE.setBackground(Color.WHITE);
		pnlLengthE.setLayout(new GridLayout(2, 2, 0, 20));

		JLabel lblLengthFromE = new JLabel("From");
		lblLengthFromE.setHorizontalAlignment(SwingConstants.CENTER);
		pnlLengthE.add(lblLengthFromE);
		lblLengthFromE.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblLengthFromE.setFont(new Font("Arial", Font.PLAIN, 12));


		JSpinner spnLengthFromE = new JSpinner();
		spnLengthFromE.setPreferredSize(new Dimension(120, 18));
		spnLengthFromE.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnLengthFromE.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlLengthE.add(spnLengthFromE);

		JLabel lblLengthToE = new JLabel("To");
		lblLengthToE.setHorizontalAlignment(SwingConstants.CENTER);
		lblLengthToE.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLengthToE.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pnlLengthE.add(lblLengthToE);

		JSpinner spnLengthToE = new JSpinner();
		spnLengthToE.setPreferredSize(new Dimension(120, 18));
		spnLengthToE.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlLengthE.add(spnLengthToE);

		JPanel pnlLengthF = new JPanel();
		pnlCenter.add(pnlLengthF);

		pnlLengthF.setBackground(Color.WHITE);
		pnlLengthF.setLayout(new GridLayout(2, 2, 0, 20));

		JLabel lblLengthFromF = new JLabel("From");
		lblLengthFromF.setHorizontalAlignment(SwingConstants.CENTER);
		pnlLengthF.add(lblLengthFromF);
		lblLengthFromF.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblLengthFromF.setFont(new Font("Arial", Font.PLAIN, 12));


		JSpinner spnLengthFromF = new JSpinner();
		spnLengthFromF.setPreferredSize(new Dimension(120, 18));
		spnLengthFromF.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnLengthFromF.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlLengthF.add(spnLengthFromF);

		JLabel lblLengthToF = new JLabel("To");
		lblLengthToF.setHorizontalAlignment(SwingConstants.CENTER);
		lblLengthToF.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLengthToF.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pnlLengthF.add(lblLengthToF);

		JSpinner spnLengthToF = new JSpinner();
		spnLengthToF.setPreferredSize(new Dimension(120, 18));
		spnLengthToF.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlLengthF.add(spnLengthToF);
		
		JPanel pnlSep1 = new JPanel();
		FlowLayout fl_pnlSep1 = (FlowLayout) pnlSep1.getLayout();
		fl_pnlSep1.setVgap(33);
		pnlSep1.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep1);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setPreferredSize(new Dimension(200, 2));
		separator_6.setForeground(Color.BLACK);
		pnlSep1.add(separator_6);
		
		JPanel pnlSep2 = new JPanel();
		FlowLayout fl_pnlSep2 = (FlowLayout) pnlSep2.getLayout();
		fl_pnlSep2.setVgap(33);
		pnlSep2.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep2);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setPreferredSize(new Dimension(200, 2));
		separator_7.setForeground(Color.BLACK);
		pnlSep2.add(separator_7);
		
		JPanel pnlSep3 = new JPanel();
		FlowLayout fl_pnlSep3 = (FlowLayout) pnlSep3.getLayout();
		fl_pnlSep3.setVgap(33);
		pnlSep3.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep3);
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setPreferredSize(new Dimension(200, 2));
		separator_10.setForeground(Color.BLACK);
		pnlSep3.add(separator_10);
		
		JPanel pnlSep4 = new JPanel();
		FlowLayout fl_pnlSep4 = (FlowLayout) pnlSep4.getLayout();
		fl_pnlSep4.setVgap(33);
		pnlSep4.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep4);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setPreferredSize(new Dimension(200, 2));
		separator_11.setForeground(Color.BLACK);
		pnlSep4.add(separator_11);
		
		JPanel pnlSep5 = new JPanel();
		FlowLayout fl_pnlSep5 = (FlowLayout) pnlSep5.getLayout();
		fl_pnlSep5.setVgap(33);
		pnlSep5.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep5);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setPreferredSize(new Dimension(200, 2));
		separator_8.setForeground(Color.BLACK);
		pnlSep5.add(separator_8);
		
		JPanel pnlSep6 = new JPanel();
		FlowLayout fl_pnlSep6 = (FlowLayout) pnlSep6.getLayout();
		fl_pnlSep6.setVgap(33);
		pnlSep6.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep6);
		
		JSeparator separator_12 = new JSeparator();
		separator_12.setPreferredSize(new Dimension(200, 2));
		separator_12.setForeground(Color.BLACK);
		pnlSep6.add(separator_12);
		
		JPanel pnlSep7 = new JPanel();
		FlowLayout fl_pnlSep7 = (FlowLayout) pnlSep7.getLayout();
		fl_pnlSep7.setVgap(33);
		pnlSep7.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep7);
		
		JSeparator separator_13 = new JSeparator();
		separator_13.setPreferredSize(new Dimension(200, 2));
		separator_13.setForeground(Color.BLACK);
		pnlSep7.add(separator_13);


		JLabel lblDiameter = new JLabel("Diameter");
		lblDiameter.setFont(new Font("Arial", Font.BOLD, 15));
		lblDiameter.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiameter.setBackground(Color.WHITE);
		pnlCenter.add(lblDiameter);

		JPanel pnlDiameterA = new JPanel();
		pnlCenter.add(pnlDiameterA);


		pnlDiameterA.setBackground(Color.WHITE);
		pnlDiameterA.setLayout(new GridLayout(2, 2, 0, 20));

		JLabel lblDiameterFromA = new JLabel("From");
		lblDiameterFromA.setHorizontalAlignment(SwingConstants.CENTER);
		pnlDiameterA.add(lblDiameterFromA);
		lblDiameterFromA.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblDiameterFromA.setFont(new Font("Arial", Font.PLAIN, 12));


		JSpinner spnDiameterFromA = new JSpinner();
		spnDiameterFromA.setPreferredSize(new Dimension(120, 18));
		spnDiameterFromA.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnDiameterFromA.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlDiameterA.add(spnDiameterFromA);

		JLabel lblDiameterToA = new JLabel("To");
		lblDiameterToA.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiameterToA.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDiameterToA.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pnlDiameterA.add(lblDiameterToA);

		JSpinner spnDiameterToA = new JSpinner();
		spnDiameterToA.setPreferredSize(new Dimension(120, 18));
		spnDiameterToA.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlDiameterA.add(spnDiameterToA);


		JPanel pnlDiameterB = new JPanel();
		pnlCenter.add(pnlDiameterB);


		pnlDiameterB.setBackground(Color.WHITE);
		pnlDiameterB.setLayout(new GridLayout(2, 2, 0, 20));

		JLabel lblDiameterFromB = new JLabel("From");
		lblDiameterFromB.setHorizontalAlignment(SwingConstants.CENTER);
		pnlDiameterB.add(lblDiameterFromB);
		lblDiameterFromB.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblDiameterFromB.setFont(new Font("Arial", Font.PLAIN, 12));


		JSpinner spnDiameterFromB = new JSpinner();
		spnDiameterFromB.setPreferredSize(new Dimension(120, 18));
		spnDiameterFromB.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnDiameterFromB.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlDiameterB.add(spnDiameterFromB);

		JLabel lblDiameterToB = new JLabel("To");
		lblDiameterToB.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiameterToB.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDiameterToB.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pnlDiameterB.add(lblDiameterToB);

		JSpinner spnDiameterToB = new JSpinner();
		spnDiameterToB.setPreferredSize(new Dimension(120, 18));
		spnDiameterToB.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlDiameterB.add(spnDiameterToB);


		JPanel pnlDiameterC = new JPanel();
		pnlCenter.add(pnlDiameterC);

		pnlDiameterC.setBackground(Color.WHITE);
		pnlDiameterC.setLayout(new GridLayout(2, 2, 0, 20));

		JLabel lblDiameterFromC = new JLabel("From");
		lblDiameterFromC.setHorizontalAlignment(SwingConstants.CENTER);
		pnlDiameterC.add(lblDiameterFromC);
		lblDiameterFromC.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblDiameterFromC.setFont(new Font("Arial", Font.PLAIN, 12));


		JSpinner spnDiameterFromC = new JSpinner();
		spnDiameterFromC.setPreferredSize(new Dimension(120, 18));
		spnDiameterFromC.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnDiameterFromC.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlDiameterC.add(spnDiameterFromC);

		JLabel lblDiameterToC = new JLabel("To");
		lblDiameterToC.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiameterToC.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDiameterToC.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pnlDiameterC.add(lblDiameterToC);

		JSpinner spnDiameterToC = new JSpinner();
		spnDiameterToC.setPreferredSize(new Dimension(120, 18));
		spnDiameterToC.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlDiameterC.add(spnDiameterToC);


		JPanel pnlDiameterD = new JPanel();
		pnlCenter.add(pnlDiameterD);

		pnlDiameterD.setBackground(Color.WHITE);
		pnlDiameterD.setLayout(new GridLayout(2, 2, 0, 20));

		JLabel lblDiameterFromD = new JLabel("From");
		lblDiameterFromD.setHorizontalAlignment(SwingConstants.CENTER);
		pnlDiameterD.add(lblDiameterFromD);
		lblDiameterFromD.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblDiameterFromD.setFont(new Font("Arial", Font.PLAIN, 12));


		JSpinner spnDiameterFromD = new JSpinner();
		spnDiameterFromD.setPreferredSize(new Dimension(120, 18));
		spnDiameterFromD.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnDiameterFromD.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlDiameterD.add(spnDiameterFromD);

		JLabel lblDiameterToD = new JLabel("To");
		lblDiameterToD.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiameterToD.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDiameterToD.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pnlDiameterD.add(lblDiameterToD);

		JSpinner spnDiameterToD = new JSpinner();
		spnDiameterToD.setPreferredSize(new Dimension(120, 18));
		spnDiameterToD.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlDiameterD.add(spnDiameterToD);



		JPanel pnlDiameterE = new JPanel();
		pnlCenter.add(pnlDiameterE);

		pnlDiameterE.setBackground(Color.WHITE);
		pnlDiameterE.setLayout(new GridLayout(2, 2, 0, 20));

		JLabel lblDiameterFromE = new JLabel("From");
		lblDiameterFromE.setHorizontalAlignment(SwingConstants.CENTER);
		pnlDiameterE.add(lblDiameterFromE);
		lblDiameterFromE.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblDiameterFromE.setFont(new Font("Arial", Font.PLAIN, 12));


		JSpinner spnDiameterFromE = new JSpinner();
		spnDiameterFromE.setPreferredSize(new Dimension(120, 18));
		spnDiameterFromE.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnDiameterFromE.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlDiameterE.add(spnDiameterFromE);

		JLabel lblDiameterToE = new JLabel("To");
		lblDiameterToE.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiameterToE.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDiameterToE.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pnlDiameterE.add(lblDiameterToE);

		JSpinner spnDiameterToE = new JSpinner();
		spnDiameterToE.setPreferredSize(new Dimension(120, 18));
		spnDiameterToE.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlDiameterE.add(spnDiameterToE);

		JPanel pnlDiameterF = new JPanel();
		pnlCenter.add(pnlDiameterF);

		pnlDiameterF.setBackground(Color.WHITE);
		pnlDiameterF.setLayout(new GridLayout(2, 2, 0, 20));

		JLabel lblDiameterFromF = new JLabel("From");
		lblDiameterFromF.setHorizontalAlignment(SwingConstants.CENTER);
		pnlDiameterF.add(lblDiameterFromF);
		lblDiameterFromF.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblDiameterFromF.setFont(new Font("Arial", Font.PLAIN, 12));


		JSpinner spnDiameterFromF = new JSpinner();
		spnDiameterFromF.setPreferredSize(new Dimension(120, 18));
		spnDiameterFromF.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnDiameterFromF.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlDiameterF.add(spnDiameterFromF);

		JLabel lblDiameterToF = new JLabel("To");
		lblDiameterToF.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiameterToF.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDiameterToF.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pnlDiameterF.add(lblDiameterToF);

		JSpinner spnDiameterToF = new JSpinner();
		spnDiameterToF.setPreferredSize(new Dimension(120, 18));
		spnDiameterToF.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		pnlDiameterF.add(spnDiameterToF);
		
		JPanel pnlSep8 = new JPanel();
		FlowLayout fl_pnlSep8 = (FlowLayout) pnlSep8.getLayout();
		fl_pnlSep8.setVgap(33);
		pnlSep8.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep8);
		
		JSeparator separator_14 = new JSeparator();
		separator_14.setPreferredSize(new Dimension(200, 2));
		separator_14.setForeground(Color.BLACK);
		pnlSep8.add(separator_14);
		
		JPanel pnlSep9 = new JPanel();
		FlowLayout fl_pnlSep9 = (FlowLayout) pnlSep9.getLayout();
		fl_pnlSep9.setVgap(33);
		pnlSep9.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep9);
		
		JSeparator separator_15 = new JSeparator();
		separator_15.setPreferredSize(new Dimension(200, 2));
		separator_15.setForeground(Color.BLACK);
		pnlSep9.add(separator_15);
		
		JPanel pnlSep10 = new JPanel();
		FlowLayout fl_pnlSep10 = (FlowLayout) pnlSep10.getLayout();
		fl_pnlSep10.setVgap(33);
		pnlSep10.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep10);
		
		JSeparator separator_16 = new JSeparator();
		separator_16.setPreferredSize(new Dimension(200, 2));
		separator_16.setForeground(Color.BLACK);
		pnlSep10.add(separator_16);
		
		JPanel pnlSep11 = new JPanel();
		FlowLayout fl_pnlSep11 = (FlowLayout) pnlSep11.getLayout();
		fl_pnlSep11.setVgap(33);
		pnlSep11.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep11);
		
		JSeparator separator_17 = new JSeparator();
		separator_17.setPreferredSize(new Dimension(200, 2));
		separator_17.setForeground(Color.BLACK);
		pnlSep11.add(separator_17);
		
		JPanel pnlSep12 = new JPanel();
		FlowLayout fl_pnlSep12 = (FlowLayout) pnlSep12.getLayout();
		fl_pnlSep12.setVgap(33);
		pnlSep12.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep12);
		
		JSeparator separator_18 = new JSeparator();
		separator_18.setPreferredSize(new Dimension(200, 2));
		separator_18.setForeground(Color.BLACK);
		pnlSep12.add(separator_18);
		
		JPanel pnlSep13 = new JPanel();
		FlowLayout fl_pnlSep13 = (FlowLayout) pnlSep13.getLayout();
		fl_pnlSep13.setVgap(33);
		pnlSep13.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep13);
		
		JSeparator separator_19 = new JSeparator();
		separator_19.setPreferredSize(new Dimension(200, 2));
		separator_19.setForeground(Color.BLACK);
		pnlSep13.add(separator_19);
		
		JPanel pnlSep14 = new JPanel();
		FlowLayout fl_pnlSep14 = (FlowLayout) pnlSep14.getLayout();
		fl_pnlSep14.setVgap(33);
		pnlSep14.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep14);
		
		JSeparator separator_20 = new JSeparator();
		separator_20.setPreferredSize(new Dimension(200, 2));
		separator_20.setForeground(Color.BLACK);
		pnlSep14.add(separator_20);



		JLabel lblBroken = new JLabel("Broken");
		lblBroken.setFont(new Font("Arial", Font.BOLD, 15));
		lblBroken.setHorizontalAlignment(SwingConstants.CENTER);
		lblBroken.setBackground(Color.WHITE);
		pnlCenter.add(lblBroken);

		JPanel pnlBrokenA = new JPanel();
		pnlCenter.add(pnlBrokenA);

		pnlBrokenA.setBackground(Color.WHITE);
		pnlBrokenA.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JSpinner spnBrokenA = new JSpinner();
		spnBrokenA.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenA.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenA.setPreferredSize(new Dimension(120, 25));
		spnBrokenA.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlBrokenA.add(spnBrokenA);



		JPanel pnlBrokenB = new JPanel();
		pnlCenter.add(pnlBrokenB);

		pnlBrokenB.setBackground(Color.WHITE);
		pnlBrokenB.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JSpinner spnBrokenB = new JSpinner();
		spnBrokenB.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenB.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenB.setPreferredSize(new Dimension(120, 25));
		spnBrokenB.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlBrokenB.add(spnBrokenB);

		JPanel pnlBrokenC = new JPanel();
		pnlCenter.add(pnlBrokenC);

		pnlBrokenC.setBackground(Color.WHITE);
		pnlBrokenC.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JSpinner spnBrokenC = new JSpinner();
		spnBrokenC.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenC.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenC.setPreferredSize(new Dimension(120, 25));
		spnBrokenC.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlBrokenC.add(spnBrokenC);

		JPanel pnlBrokenD = new JPanel();
		pnlCenter.add(pnlBrokenD);

		pnlBrokenD.setBackground(Color.WHITE);
		pnlBrokenD.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JSpinner spnBrokenD = new JSpinner();
		spnBrokenD.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenD.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenD.setPreferredSize(new Dimension(120, 25));
		spnBrokenD.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlBrokenD.add(spnBrokenD);

		JPanel pnlBrokenE = new JPanel();
		pnlCenter.add(pnlBrokenE);

		pnlBrokenE.setBackground(Color.WHITE);
		pnlBrokenE.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JSpinner spnBrokenE = new JSpinner();
		spnBrokenE.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenE.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenE.setPreferredSize(new Dimension(120, 25));
		spnBrokenE.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlBrokenE.add(spnBrokenE);


		JPanel pnlBrokenF = new JPanel();
		pnlCenter.add(pnlBrokenF);

		pnlBrokenF.setBackground(Color.WHITE);
		pnlBrokenF.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JSpinner spnBrokenF = new JSpinner();
		spnBrokenF.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenF.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenF.setPreferredSize(new Dimension(120, 25));
		spnBrokenF.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlBrokenF.add(spnBrokenF);
		
		JPanel pnlSep15 = new JPanel();
		FlowLayout fl_pnlSep15 = (FlowLayout) pnlSep15.getLayout();
		fl_pnlSep15.setVgap(33);
		pnlSep15.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep15);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setPreferredSize(new Dimension(200, 2));
		separator_1.setForeground(Color.BLACK);
		pnlSep15.add(separator_1);
		
		JPanel pnlSep16 = new JPanel();
		FlowLayout fl_pnlSep16 = (FlowLayout) pnlSep16.getLayout();
		fl_pnlSep16.setVgap(33);
		pnlSep16.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep16);
		
		JSeparator separator_22 = new JSeparator();
		separator_22.setPreferredSize(new Dimension(200, 2));
		separator_22.setForeground(Color.BLACK);
		pnlSep16.add(separator_22);
		
		JPanel pnlSep17 = new JPanel();
		FlowLayout fl_pnlSep17 = (FlowLayout) pnlSep17.getLayout();
		fl_pnlSep17.setVgap(33);
		pnlSep17.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep17);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setPreferredSize(new Dimension(200, 2));
		separator_3.setForeground(Color.BLACK);
		pnlSep17.add(separator_3);
		
		JPanel pnlSep18 = new JPanel();
		FlowLayout fl_pnlSep18 = (FlowLayout) pnlSep18.getLayout();
		fl_pnlSep18.setVgap(33);
		pnlSep18.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep18);
		
		JSeparator separator_23 = new JSeparator();
		separator_23.setPreferredSize(new Dimension(200, 2));
		separator_23.setForeground(Color.BLACK);
		pnlSep18.add(separator_23);
		
		JPanel pnlSep19 = new JPanel();
		FlowLayout fl_pnlSep19 = (FlowLayout) pnlSep19.getLayout();
		fl_pnlSep19.setVgap(33);
		pnlSep19.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep19);
		
		JSeparator separator_24 = new JSeparator();
		separator_24.setPreferredSize(new Dimension(200, 2));
		separator_24.setForeground(Color.BLACK);
		pnlSep19.add(separator_24);
		
		JPanel pnlSep20 = new JPanel();
		FlowLayout fl_pnlSep20 = (FlowLayout) pnlSep20.getLayout();
		fl_pnlSep20.setVgap(33);
		pnlSep20.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep20);
		
		JSeparator separator_25 = new JSeparator();
		separator_25.setPreferredSize(new Dimension(200, 2));
		separator_25.setForeground(Color.BLACK);
		pnlSep20.add(separator_25);
		
		JPanel pnlSep21 = new JPanel();
		FlowLayout fl_pnlSep21 = (FlowLayout) pnlSep21.getLayout();
		fl_pnlSep21.setVgap(33);
		pnlSep21.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep21);
		
		JSeparator separator_26 = new JSeparator();
		separator_26.setPreferredSize(new Dimension(200, 2));
		separator_26.setForeground(Color.BLACK);
		pnlSep21.add(separator_26);
		
		

		JLabel lblS_Shape = new JLabel("S Shape");
		lblS_Shape.setFont(new Font("Arial", Font.BOLD, 15));
		lblS_Shape.setHorizontalAlignment(SwingConstants.CENTER);
		lblS_Shape.setBackground(Color.WHITE);
		pnlCenter.add(lblS_Shape);


		JPanel pnlS_ShapeA = new JPanel();
		pnlCenter.add(pnlS_ShapeA);
		
		pnlS_ShapeA.setBackground(Color.WHITE);
		pnlS_ShapeA.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JSpinner spnS_ShapeA = new JSpinner();
		spnS_ShapeA.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeA.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeA.setPreferredSize(new Dimension(120, 25));
		spnS_ShapeA.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlS_ShapeA.add(spnS_ShapeA);

		JPanel pnlS_ShapeB = new JPanel();
		pnlCenter.add(pnlS_ShapeB);
		
		pnlS_ShapeB.setBackground(Color.WHITE);
		pnlS_ShapeB.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JSpinner spnS_ShapeB = new JSpinner();
		spnS_ShapeB.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeB.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeB.setPreferredSize(new Dimension(120, 25));
		spnS_ShapeB.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlS_ShapeB.add(spnS_ShapeB);

		JPanel pnlS_ShapeC = new JPanel();
		pnlCenter.add(pnlS_ShapeC);
		
		pnlS_ShapeC.setBackground(Color.WHITE);
		pnlS_ShapeC.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JSpinner spnS_ShapeC = new JSpinner();
		spnS_ShapeC.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeC.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeC.setPreferredSize(new Dimension(120, 25));
		spnS_ShapeC.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlS_ShapeC.add(spnS_ShapeC);

		JPanel pnlS_ShapeD = new JPanel();
		pnlCenter.add(pnlS_ShapeD);
		
		pnlS_ShapeD.setBackground(Color.WHITE);
		pnlS_ShapeD.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JSpinner spnS_ShapeD = new JSpinner();
		spnS_ShapeD.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeD.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeD.setPreferredSize(new Dimension(120, 25));
		spnS_ShapeD.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlS_ShapeD.add(spnS_ShapeD);

		JPanel pnlS_ShapeE = new JPanel();
		pnlCenter.add(pnlS_ShapeE);
		
		pnlS_ShapeE.setBackground(Color.WHITE);
		pnlS_ShapeE.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JSpinner spnS_ShapeE = new JSpinner();
		spnS_ShapeE.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeE.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeE.setPreferredSize(new Dimension(120, 25));
		spnS_ShapeE.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlS_ShapeE.add(spnS_ShapeE);
		
		
		JPanel pnlS_ShapeF = new JPanel();
		pnlCenter.add(pnlS_ShapeF);
		
		pnlS_ShapeF.setBackground(Color.WHITE);
		pnlS_ShapeF.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JSpinner spnS_ShapeF = new JSpinner();
		spnS_ShapeF.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeF.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeF.setPreferredSize(new Dimension(120, 25));
		spnS_ShapeF.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlS_ShapeF.add(spnS_ShapeF);
		
		JPanel pnlSep22 = new JPanel();
		FlowLayout fl_pnlSep22 = (FlowLayout) pnlSep22.getLayout();
		fl_pnlSep22.setVgap(33);
		pnlSep22.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep22);

		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(Color.BLACK);
		separator_5.setPreferredSize(new Dimension(200, 2));
		pnlSep22.add(separator_5);
		
		JPanel pnlSep23 = new JPanel();
		FlowLayout fl_pnlSep23 = (FlowLayout) pnlSep23.getLayout();
		fl_pnlSep23.setVgap(33);
		pnlSep23.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep23);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setPreferredSize(new Dimension(200, 2));
		separator_9.setForeground(Color.BLACK);
		pnlSep23.add(separator_9);
		
		JPanel pnlSep24 = new JPanel();
		FlowLayout fl_pnlSep24 = (FlowLayout) pnlSep24.getLayout();
		fl_pnlSep24.setVgap(33);
		pnlSep24.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep24);
		
		JSeparator separator_27 = new JSeparator();
		separator_27.setPreferredSize(new Dimension(200, 2));
		separator_27.setForeground(Color.BLACK);
		pnlSep24.add(separator_27);
		
		JPanel pnlSep25 = new JPanel();
		FlowLayout fl_pnlSep25 = (FlowLayout) pnlSep25.getLayout();
		fl_pnlSep25.setVgap(33);
		pnlSep25.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep25);
		
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(200, 2));
		separator.setForeground(Color.BLACK);
		pnlSep25.add(separator);
		
		JPanel pnlSep26 = new JPanel();
		FlowLayout fl_pnlSep26 = (FlowLayout) pnlSep26.getLayout();
		fl_pnlSep26.setVgap(33);
		pnlSep26.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep26);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setPreferredSize(new Dimension(200, 2));
		separator_2.setForeground(Color.BLACK);
		pnlSep26.add(separator_2);
		
		JPanel pnlSep27 = new JPanel();
		FlowLayout fl_pnlSep27 = (FlowLayout) pnlSep27.getLayout();
		fl_pnlSep27.setVgap(33);
		pnlSep27.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep27);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setPreferredSize(new Dimension(200, 2));
		separator_4.setForeground(Color.BLACK);
		pnlSep27.add(separator_4);
		
		JPanel pnlSep28 = new JPanel();
		FlowLayout fl_pnlSep28 = (FlowLayout) pnlSep28.getLayout();
		fl_pnlSep28.setVgap(33);
		pnlSep28.setBackground(Color.WHITE);
		pnlCenter.add(pnlSep28);
		
		JSeparator separator_21 = new JSeparator();
		separator_21.setPreferredSize(new Dimension(200, 2));
		separator_21.setForeground(Color.BLACK);
		pnlSep28.add(separator_21);

		JLabel lblC_Shape = new JLabel("C Shape");
		lblC_Shape.setFont(new Font("Arial", Font.BOLD, 15));
		lblC_Shape.setHorizontalAlignment(SwingConstants.CENTER);
		lblC_Shape.setBackground(Color.WHITE);
		pnlCenter.add(lblC_Shape);

		JPanel pnlC_ShapeA = new JPanel();
		pnlCenter.add(pnlC_ShapeA);
		
		pnlC_ShapeA.setBackground(Color.WHITE);
		pnlC_ShapeA.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		JSpinner spnC_ShapeA = new JSpinner();
		spnC_ShapeA.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnC_ShapeA.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnC_ShapeA.setPreferredSize(new Dimension(120, 25));
		spnC_ShapeA.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlC_ShapeA.add(spnC_ShapeA);

		JPanel pnlC_ShapeB = new JPanel();
		pnlCenter.add(pnlC_ShapeB);
		
		pnlC_ShapeB.setBackground(Color.WHITE);
		pnlC_ShapeB.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		JSpinner spnC_ShapeB = new JSpinner();
		spnC_ShapeB.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnC_ShapeB.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnC_ShapeB.setPreferredSize(new Dimension(120, 25));
		spnC_ShapeB.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlC_ShapeB.add(spnC_ShapeB);

		JPanel pnlC_ShapeC = new JPanel();
		pnlCenter.add(pnlC_ShapeC);
		
		pnlC_ShapeC.setBackground(Color.WHITE);
		pnlC_ShapeC.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		JSpinner spnC_ShapeC = new JSpinner();
		spnC_ShapeC.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnC_ShapeC.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnC_ShapeC.setPreferredSize(new Dimension(120, 25));
		spnC_ShapeC.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlC_ShapeC.add(spnC_ShapeC);


		JPanel pnlC_ShapeD = new JPanel();
		pnlCenter.add(pnlC_ShapeD);
		
		pnlC_ShapeD.setBackground(Color.WHITE);
		pnlC_ShapeD.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		JSpinner spnC_ShapeD = new JSpinner();
		spnC_ShapeD.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnC_ShapeD.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnC_ShapeD.setPreferredSize(new Dimension(120, 25));
		spnC_ShapeD.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlC_ShapeD.add(spnC_ShapeD);
		

		JPanel pnlC_ShapeE = new JPanel();
		pnlCenter.add(pnlC_ShapeE);
		
		pnlC_ShapeE.setBackground(Color.WHITE);
		pnlC_ShapeE.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		JSpinner spnC_ShapeE = new JSpinner();
		spnC_ShapeE.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnC_ShapeE.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnC_ShapeE.setPreferredSize(new Dimension(120, 25));
		spnC_ShapeE.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlC_ShapeE.add(spnC_ShapeE);

		JPanel pnlC_ShapeF = new JPanel();
		pnlCenter.add(pnlC_ShapeF);

		pnlC_ShapeF.setBackground(Color.WHITE);
		pnlC_ShapeF.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		JSpinner spnC_ShapeF = new JSpinner();
		spnC_ShapeF.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnC_ShapeF.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnC_ShapeF.setPreferredSize(new Dimension(120, 25));
		spnC_ShapeF.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlC_ShapeF.add(spnC_ShapeF);






	}
}
