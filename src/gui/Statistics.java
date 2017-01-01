package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

public class Statistics {

	private JFrame frmStatistics;
	private JTextField txtFf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statistics window = new Statistics();
					window.frmStatistics.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Statistics() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStatistics = new JFrame();
		frmStatistics.setBounds(100, 100, 1617, 876);
		frmStatistics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStatistics.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmStatistics.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlHeaderWindow = new JPanel();
		pnlHeaderWindow.setBackground(Color.WHITE);
		FlowLayout fl_pnlHeaderWindow = (FlowLayout) pnlHeaderWindow.getLayout();
		fl_pnlHeaderWindow.setVgap(50);
		frmStatistics.getContentPane().add(pnlHeaderWindow, BorderLayout.NORTH);
		
		JLabel lblStatistics = new JLabel("Statistics");
		lblStatistics.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 47));
		pnlHeaderWindow.add(lblStatistics);
		
		JPanel pnLeft = new JPanel();
		pnLeft.setPreferredSize(new Dimension(600, 10));
		frmStatistics.getContentPane().add(pnLeft, BorderLayout.WEST);
		pnLeft.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlExport = new JPanel();
		FlowLayout fl_pnlExport = (FlowLayout) pnlExport.getLayout();
		fl_pnlExport.setVgap(20);
		pnLeft.add(pnlExport, BorderLayout.NORTH);
		
		JLabel lblExport = new JLabel("Export / Forecast");
		lblExport.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		pnlExport.add(lblExport);
		
		///////////////
		
		
		
		JPanel pnlExportDetails = new JPanel();
		pnLeft.add(pnlExportDetails, BorderLayout.CENTER);
		pnlExportDetails.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblChooseWhatTo = new JLabel("Choose What To Export:");
		lblChooseWhatTo.setFont(new Font("Arial", Font.BOLD, 15));
		lblChooseWhatTo.setPreferredSize(new Dimension(200, 25));
		pnlExportDetails.add(lblChooseWhatTo, "2, 4, 28, 1, center, default");
		
		JLabel lblLastSorts = new JLabel("Last Sorts: ");
		lblLastSorts.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLastSorts.setFont(new Font("Arial", Font.PLAIN, 14));
		pnlExportDetails.add(lblLastSorts, "2, 8, right, default");
		
		JComboBox cmbLastExportRes = new JComboBox();
		pnlExportDetails.add(cmbLastExportRes, "4, 8, 9, 1, fill, default");
		
		JLabel lblSearchForSort = new JLabel("Search For Sort By:");
		lblSearchForSort.setFont(new Font("Arial", Font.PLAIN, 14));
		pnlExportDetails.add(lblSearchForSort, "2, 16");
		
		JRadioButton rdbtnGrowerId = new JRadioButton("Grower Id");
		pnlExportDetails.add(rdbtnGrowerId, "4, 16");
		
		JComboBox cmbSearchBy = new JComboBox();
		pnlExportDetails.add(cmbSearchBy, "8, 16, 5, 1, fill, default");
		
		JRadioButton rdbtnDate = new JRadioButton("Date Of Sort");
		pnlExportDetails.add(rdbtnDate, "4, 18");
		
		JRadioButton rdbtnPlotId = new JRadioButton("Plot's Id");
		pnlExportDetails.add(rdbtnPlotId, "4, 20");
		
		JButton btnResort = new JButton("Resort");
		pnlExportDetails.add(btnResort, "8, 24, 1, 3");
		
		JButton btnForecast = new JButton("Forecasting Data");
		btnForecast.setPreferredSize(new Dimension(65, 25));
		pnlExportDetails.add(btnForecast, "8, 28, 1, 3");
		
		JButton btnExport = new JButton("Export");
		btnExport.setPreferredSize(new Dimension(65, 25));
		pnlExportDetails.add(btnExport, "8, 32, 1, 3");

		
		JPanel pnlRight = new JPanel();
		frmStatistics.getContentPane().add(pnlRight, BorderLayout.CENTER);
		pnlRight.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlDataAnalysis = new JPanel();
		FlowLayout fl_pnlDataAnalysis = (FlowLayout) pnlDataAnalysis.getLayout();
		fl_pnlDataAnalysis.setVgap(20);
		pnlRight.add(pnlDataAnalysis, BorderLayout.NORTH);
		
		JLabel lblDataAnalysis = new JLabel("Data Analysis");
		lblDataAnalysis.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		pnlDataAnalysis.add(lblDataAnalysis);
		
		JPanel pnlExportAnalysis = new JPanel();
		pnlRight.add(pnlExportAnalysis, BorderLayout.CENTER);


		////////////////////////////////////////////////////////////////
		pnlExportAnalysis.setLayout(new GridLayout(7, 7, 3, 0));

		/////////////// class types /////////////////////////////
		
		JLabel lblInput = new JLabel("Input");
		lblInput.setForeground(new Color(165, 42, 42));
		lblInput.setFont(new Font("Arial", Font.BOLD, 18));
		lblInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblInput.setBackground(new Color(0, 51, 102));
		pnlExportAnalysis.add(lblInput);

		JLabel lblClassA = new JLabel("Class A");
		lblClassA.setFont(new Font("Arial", Font.BOLD, 15));
		lblClassA.setHorizontalAlignment(SwingConstants.CENTER);
		lblClassA.setBackground(new Color(0, 51, 102));
		pnlExportAnalysis.add(lblClassA);

		JLabel lblClassB = new JLabel("Class B");
		lblClassB.setFont(new Font("Arial", Font.BOLD, 15));
		lblClassB.setHorizontalAlignment(SwingConstants.CENTER);
		lblClassB.setBackground(Color.WHITE);
		pnlExportAnalysis.add(lblClassB);

		JLabel lblClassC = new JLabel("Class c");
		lblClassC.setFont(new Font("Arial", Font.BOLD, 15));
		lblClassC.setHorizontalAlignment(SwingConstants.CENTER);
		lblClassC.setBackground(Color.WHITE);
		pnlExportAnalysis.add(lblClassC);

		JLabel lblClassD = new JLabel("Class D");
		lblClassD.setFont(new Font("Arial", Font.BOLD, 15));
		lblClassD.setHorizontalAlignment(SwingConstants.CENTER);
		lblClassD.setBackground(Color.WHITE);
		pnlExportAnalysis.add(lblClassD);

		JLabel lblClassE = new JLabel("Class E");
		lblClassE.setFont(new Font("Arial", Font.BOLD, 15));
		lblClassE.setHorizontalAlignment(SwingConstants.CENTER);
		lblClassE.setBackground(Color.WHITE);
		pnlExportAnalysis.add(lblClassE);

		JLabel lblClassF = new JLabel("Class F");
		lblClassF.setFont(new Font("Arial", Font.BOLD, 15));
		lblClassF.setHorizontalAlignment(SwingConstants.CENTER);
		lblClassF.setBackground(Color.WHITE);
		pnlExportAnalysis.add(lblClassF);

		JLabel lblLength = new JLabel("Length");
		lblLength.setFont(new Font("Arial", Font.BOLD, 15));
		lblLength.setHorizontalAlignment(SwingConstants.CENTER);
		lblLength.setBackground(new Color(0, 51, 102));
		pnlExportAnalysis.add(lblLength);
		
		JPanel pnlLengthA = new JPanel();
		pnlLengthA.setBackground(new Color(230, 230, 250));
		pnlExportAnalysis.add(pnlLengthA);
		GridBagLayout gbl_pnlLengthA = new GridBagLayout();
		gbl_pnlLengthA.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_pnlLengthA.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlLengthA.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlLengthA.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlLengthA.setLayout(gbl_pnlLengthA);
		
		JLabel lblLengthFromA = new JLabel("From:");
		lblLengthFromA.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblLengthFromA = new GridBagConstraints();
		gbc_lblLengthFromA.ipadx = 2;
		gbc_lblLengthFromA.insets = new Insets(0, 2, 5, 5);
		gbc_lblLengthFromA.gridx = 0;
		gbc_lblLengthFromA.gridy = 1;
		pnlLengthA.add(lblLengthFromA, gbc_lblLengthFromA);
		
		JSpinner spnLengthFromA = new JSpinner();
		GridBagConstraints gbc_spnLengthFromA = new GridBagConstraints();
		gbc_spnLengthFromA.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnLengthFromA.gridwidth = 2;
		gbc_spnLengthFromA.insets = new Insets(0, 0, 5, 0);
		gbc_spnLengthFromA.gridx = 1;
		gbc_spnLengthFromA.gridy = 1;
		pnlLengthA.add(spnLengthFromA, gbc_spnLengthFromA);
		
		JLabel lblLengthToA = new JLabel("To:");
		lblLengthToA.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblLengthToA = new GridBagConstraints();
		gbc_lblLengthToA.insets = new Insets(0, 0, 0, 5);
		gbc_lblLengthToA.gridx = 0;
		gbc_lblLengthToA.gridy = 2;
		pnlLengthA.add(lblLengthToA, gbc_lblLengthToA);
		
		JSpinner spnLengthToA = new JSpinner();
		GridBagConstraints gbc_spnLengthToA = new GridBagConstraints();
		gbc_spnLengthToA.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnLengthToA.gridwidth = 2;
		gbc_spnLengthToA.gridx = 1;
		gbc_spnLengthToA.gridy = 2;
		pnlLengthA.add(spnLengthToA, gbc_spnLengthToA);
		
		JPanel pnlLengthB = new JPanel();
		pnlLengthB.setBackground(new Color(230, 230, 250));
		pnlExportAnalysis.add(pnlLengthB);
		GridBagLayout gbl_pnlLengthB = new GridBagLayout();
		gbl_pnlLengthB.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_pnlLengthB.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlLengthB.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlLengthB.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlLengthB.setLayout(gbl_pnlLengthB);
		
		JLabel lblLengthFromB = new JLabel("From:");
		lblLengthFromB.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblLengthFromB = new GridBagConstraints();
		gbc_lblLengthFromB.ipadx = 2;
		gbc_lblLengthFromB.insets = new Insets(0, 2, 5, 5);
		gbc_lblLengthFromB.gridx = 0;
		gbc_lblLengthFromB.gridy = 1;
		pnlLengthB.add(lblLengthFromB, gbc_lblLengthFromB);
		
		JSpinner spnLengthFromB = new JSpinner();
		GridBagConstraints gbc_spnLengthFromB = new GridBagConstraints();
		gbc_spnLengthFromB.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnLengthFromB.gridwidth = 2;
		gbc_spnLengthFromB.insets = new Insets(0, 0, 5, 0);
		gbc_spnLengthFromB.gridx = 1;
		gbc_spnLengthFromB.gridy = 1;
		pnlLengthB.add(spnLengthFromB, gbc_spnLengthFromB);
		
		JLabel lblLengthToB = new JLabel("To:");
		lblLengthToB.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblLengthToB = new GridBagConstraints();
		gbc_lblLengthToB.insets = new Insets(0, 0, 0, 5);
		gbc_lblLengthToB.gridx = 0;
		gbc_lblLengthToB.gridy = 2;
		pnlLengthB.add(lblLengthToB, gbc_lblLengthToB);
		
		JSpinner spnLengthToB = new JSpinner();
		GridBagConstraints gbc_spnLengthToB = new GridBagConstraints();
		gbc_spnLengthToB.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnLengthToB.gridwidth = 2;
		gbc_spnLengthToB.gridx = 1;
		gbc_spnLengthToB.gridy = 2;
		pnlLengthB.add(spnLengthToB, gbc_spnLengthToB);
		
		JPanel pnlLengthC = new JPanel();
		pnlLengthC.setBackground(new Color(230, 230, 250));
		pnlExportAnalysis.add(pnlLengthC);
		GridBagLayout gbl_pnlLengthC = new GridBagLayout();
		gbl_pnlLengthC.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_pnlLengthC.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlLengthC.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlLengthC.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlLengthC.setLayout(gbl_pnlLengthC);
		
		JLabel lblLengthFromC = new JLabel("From:");
		lblLengthFromC.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblLengthFromC = new GridBagConstraints();
		gbc_lblLengthFromC.ipadx = 2;
		gbc_lblLengthFromC.insets = new Insets(0, 2, 5, 5);
		gbc_lblLengthFromC.gridx = 0;
		gbc_lblLengthFromC.gridy = 1;
		pnlLengthC.add(lblLengthFromC, gbc_lblLengthFromC);
		
		JSpinner spnLengthFromC = new JSpinner();
		GridBagConstraints gbc_spnLengthFromC = new GridBagConstraints();
		gbc_spnLengthFromC.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnLengthFromC.gridwidth = 2;
		gbc_spnLengthFromC.insets = new Insets(0, 0, 5, 0);
		gbc_spnLengthFromC.gridx = 1;
		gbc_spnLengthFromC.gridy = 1;
		pnlLengthC.add(spnLengthFromC, gbc_spnLengthFromC);
		
		JLabel lblLengthToC = new JLabel("To:");
		lblLengthToC.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblLengthToC = new GridBagConstraints();
		gbc_lblLengthToC.insets = new Insets(0, 0, 0, 5);
		gbc_lblLengthToC.gridx = 0;
		gbc_lblLengthToC.gridy = 2;
		pnlLengthC.add(lblLengthToC, gbc_lblLengthToC);
		
		JSpinner spnLengthToC = new JSpinner();
		GridBagConstraints gbc_spnLengthToC = new GridBagConstraints();
		gbc_spnLengthToC.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnLengthToC.gridwidth = 2;
		gbc_spnLengthToC.gridx = 1;
		gbc_spnLengthToC.gridy = 2;
		pnlLengthC.add(spnLengthToC, gbc_spnLengthToC);
		
		JPanel pnlLengthD = new JPanel();
		pnlLengthD.setBackground(new Color(224, 255, 255));
		pnlExportAnalysis.add(pnlLengthD);
		GridBagLayout gbl_pnlLengthD = new GridBagLayout();
		gbl_pnlLengthD.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_pnlLengthD.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlLengthD.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlLengthD.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlLengthD.setLayout(gbl_pnlLengthD);
		
		JLabel lblLengthFromD = new JLabel("From:");
		lblLengthFromD.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblLengthFromD = new GridBagConstraints();
		gbc_lblLengthFromD.ipadx = 2;
		gbc_lblLengthFromD.insets = new Insets(0, 2, 5, 5);
		gbc_lblLengthFromD.gridx = 0;
		gbc_lblLengthFromD.gridy = 1;
		pnlLengthD.add(lblLengthFromD, gbc_lblLengthFromD);
		
		JSpinner spnLengthFromD = new JSpinner();
		GridBagConstraints gbc_spnLengthFromD = new GridBagConstraints();
		gbc_spnLengthFromD.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnLengthFromD.gridwidth = 2;
		gbc_spnLengthFromD.insets = new Insets(0, 0, 5, 0);
		gbc_spnLengthFromD.gridx = 1;
		gbc_spnLengthFromD.gridy = 1;
		pnlLengthD.add(spnLengthFromD, gbc_spnLengthFromD);
		
		JLabel lblLengthToD = new JLabel("To:");
		lblLengthToD.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblLengthToD = new GridBagConstraints();
		gbc_lblLengthToD.insets = new Insets(0, 0, 0, 5);
		gbc_lblLengthToD.gridx = 0;
		gbc_lblLengthToD.gridy = 2;
		pnlLengthD.add(lblLengthToD, gbc_lblLengthToD);
		
		JSpinner spnLengthToD = new JSpinner();
		GridBagConstraints gbc_spnLengthToD = new GridBagConstraints();
		gbc_spnLengthToD.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnLengthToD.gridwidth = 2;
		gbc_spnLengthToD.gridx = 1;
		gbc_spnLengthToD.gridy = 2;
		pnlLengthD.add(spnLengthToD, gbc_spnLengthToD);
		
		JPanel pnlLengthE = new JPanel();
		pnlLengthE.setBackground(new Color(224, 255, 255));
		pnlExportAnalysis.add(pnlLengthE);
		GridBagLayout gbl_pnlLengthE = new GridBagLayout();
		gbl_pnlLengthE.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_pnlLengthE.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlLengthE.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlLengthE.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlLengthE.setLayout(gbl_pnlLengthE);
		
		JLabel lblLengthFromE = new JLabel("From:");
		lblLengthFromE.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblLengthFromE = new GridBagConstraints();
		gbc_lblLengthFromE.ipadx = 2;
		gbc_lblLengthFromE.insets = new Insets(0, 2, 5, 5);
		gbc_lblLengthFromE.gridx = 0;
		gbc_lblLengthFromE.gridy = 1;
		pnlLengthE.add(lblLengthFromE, gbc_lblLengthFromE);
		
		JSpinner spnLengthFromE = new JSpinner();
		GridBagConstraints gbc_spnLengthFromE = new GridBagConstraints();
		gbc_spnLengthFromE.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnLengthFromE.gridwidth = 2;
		gbc_spnLengthFromE.insets = new Insets(0, 0, 5, 0);
		gbc_spnLengthFromE.gridx = 1;
		gbc_spnLengthFromE.gridy = 1;
		pnlLengthE.add(spnLengthFromE, gbc_spnLengthFromE);
		
		JLabel lblLengthToE = new JLabel("To:");
		lblLengthToE.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblLengthToE = new GridBagConstraints();
		gbc_lblLengthToE.insets = new Insets(0, 0, 0, 5);
		gbc_lblLengthToE.gridx = 0;
		gbc_lblLengthToE.gridy = 2;
		pnlLengthE.add(lblLengthToE, gbc_lblLengthToE);
		
		JSpinner spnLengthToE = new JSpinner();
		GridBagConstraints gbc_spnLengthToE = new GridBagConstraints();
		gbc_spnLengthToE.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnLengthToE.gridwidth = 2;
		gbc_spnLengthToE.gridx = 1;
		gbc_spnLengthToE.gridy = 2;
		pnlLengthE.add(spnLengthToE, gbc_spnLengthToE);
		
		JPanel pnlLengthF = new JPanel();
		pnlLengthF.setBackground(new Color(221, 160, 221));
		pnlExportAnalysis.add(pnlLengthF);
		GridBagLayout gbl_pnlLengthF = new GridBagLayout();
		gbl_pnlLengthF.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_pnlLengthF.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlLengthF.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlLengthF.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlLengthF.setLayout(gbl_pnlLengthF);
		
		JLabel lblLengthFromF = new JLabel("From:");
		lblLengthFromF.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblLengthFromF = new GridBagConstraints();
		gbc_lblLengthFromF.ipadx = 2;
		gbc_lblLengthFromF.insets = new Insets(0, 2, 5, 5);
		gbc_lblLengthFromF.gridx = 0;
		gbc_lblLengthFromF.gridy = 1;
		pnlLengthF.add(lblLengthFromF, gbc_lblLengthFromF);
		
		JSpinner spnLengthFromF = new JSpinner();
		GridBagConstraints gbc_spnLengthFromF = new GridBagConstraints();
		gbc_spnLengthFromF.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnLengthFromF.gridwidth = 2;
		gbc_spnLengthFromF.insets = new Insets(0, 0, 5, 0);
		gbc_spnLengthFromF.gridx = 1;
		gbc_spnLengthFromF.gridy = 1;
		pnlLengthF.add(spnLengthFromF, gbc_spnLengthFromF);
		
		JLabel lblLengthToF = new JLabel("To:");
		lblLengthToF.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblLengthToF = new GridBagConstraints();
		gbc_lblLengthToF.insets = new Insets(0, 0, 0, 5);
		gbc_lblLengthToF.gridx = 0;
		gbc_lblLengthToF.gridy = 2;
		pnlLengthF.add(lblLengthToF, gbc_lblLengthToF);
		
		JSpinner spnLengthToF = new JSpinner();
		GridBagConstraints gbc_spnLengthToF = new GridBagConstraints();
		gbc_spnLengthToF.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnLengthToF.gridwidth = 2;
		gbc_spnLengthToF.gridx = 1;
		gbc_spnLengthToF.gridy = 2;
		pnlLengthF.add(spnLengthToF, gbc_spnLengthToF);


		JLabel lblDiameter = new JLabel("Diameter");
		lblDiameter.setFont(new Font("Arial", Font.BOLD, 15));
		lblDiameter.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiameter.setBackground(Color.WHITE);
		pnlExportAnalysis.add(lblDiameter);
		
		JPanel pnlDiameterA = new JPanel();
		pnlDiameterA.setBackground(new Color(230, 230, 250));
		pnlExportAnalysis.add(pnlDiameterA);
		GridBagLayout gbl_pnlDiameterA = new GridBagLayout();
		gbl_pnlDiameterA.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_pnlDiameterA.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlDiameterA.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlDiameterA.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlDiameterA.setLayout(gbl_pnlDiameterA);
		
		JLabel lblDiameterFromA = new JLabel("From:");
		lblDiameterFromA.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblDiameterFromA = new GridBagConstraints();
		gbc_lblDiameterFromA.ipadx = 2;
		gbc_lblDiameterFromA.insets = new Insets(0, 2, 5, 5);
		gbc_lblDiameterFromA.gridx = 0;
		gbc_lblDiameterFromA.gridy = 1;
		pnlDiameterA.add(lblDiameterFromA, gbc_lblDiameterFromA);
		
		JSpinner spnDiameterFromA = new JSpinner();
		GridBagConstraints gbc_spnDiameterFromA = new GridBagConstraints();
		gbc_spnDiameterFromA.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnDiameterFromA.gridwidth = 2;
		gbc_spnDiameterFromA.insets = new Insets(0, 0, 5, 0);
		gbc_spnDiameterFromA.gridx = 1;
		gbc_spnDiameterFromA.gridy = 1;
		pnlDiameterA.add(spnDiameterFromA, gbc_spnDiameterFromA);
		
		JLabel lblDiameterToA = new JLabel("To:");
		lblDiameterToA.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblDiameterToA = new GridBagConstraints();
		gbc_lblDiameterToA.insets = new Insets(0, 0, 0, 5);
		gbc_lblDiameterToA.gridx = 0;
		gbc_lblDiameterToA.gridy = 2;
		pnlDiameterA.add(lblDiameterToA, gbc_lblDiameterToA);
		
		JSpinner spnDiameterToA = new JSpinner();
		GridBagConstraints gbc_spnDiameterToA = new GridBagConstraints();
		gbc_spnDiameterToA.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnDiameterToA.gridwidth = 2;
		gbc_spnDiameterToA.gridx = 1;
		gbc_spnDiameterToA.gridy = 2;
		pnlDiameterA.add(spnDiameterToA, gbc_spnDiameterToA);
		
		JPanel pnlDiameterB = new JPanel();
		pnlDiameterB.setBackground(new Color(230, 230, 250));
		pnlExportAnalysis.add(pnlDiameterB);
		GridBagLayout gbl_pnlDiameterB = new GridBagLayout();
		gbl_pnlDiameterB.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_pnlDiameterB.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlDiameterB.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlDiameterB.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlDiameterB.setLayout(gbl_pnlDiameterB);
		
		JLabel lblDiameterFromB = new JLabel("From:");
		lblDiameterFromB.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblDiameterFromB = new GridBagConstraints();
		gbc_lblDiameterFromB.ipadx = 2;
		gbc_lblDiameterFromB.insets = new Insets(0, 2, 5, 5);
		gbc_lblDiameterFromB.gridx = 0;
		gbc_lblDiameterFromB.gridy = 1;
		pnlDiameterB.add(lblDiameterFromB, gbc_lblDiameterFromB);
		
		JSpinner spnDiameterFromB = new JSpinner();
		GridBagConstraints gbc_spnDiameterFromB = new GridBagConstraints();
		gbc_spnDiameterFromB.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnDiameterFromB.gridwidth = 2;
		gbc_spnDiameterFromB.insets = new Insets(0, 0, 5, 0);
		gbc_spnDiameterFromB.gridx = 1;
		gbc_spnDiameterFromB.gridy = 1;
		pnlDiameterB.add(spnDiameterFromB, gbc_spnDiameterFromB);
		
		JLabel lblDiameterToB = new JLabel("To:");
		lblDiameterToB.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblDiameterToB = new GridBagConstraints();
		gbc_lblDiameterToB.insets = new Insets(0, 0, 0, 5);
		gbc_lblDiameterToB.gridx = 0;
		gbc_lblDiameterToB.gridy = 2;
		pnlDiameterB.add(lblDiameterToB, gbc_lblDiameterToB);
		
		JSpinner spnDiameterToB = new JSpinner();
		GridBagConstraints gbc_spnDiameterToB = new GridBagConstraints();
		gbc_spnDiameterToB.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnDiameterToB.gridwidth = 2;
		gbc_spnDiameterToB.gridx = 1;
		gbc_spnDiameterToB.gridy = 2;
		pnlDiameterB.add(spnDiameterToB, gbc_spnDiameterToB);
		
		JPanel pnlDiameterC = new JPanel();
		pnlDiameterC.setBackground(new Color(230, 230, 250));
		pnlExportAnalysis.add(pnlDiameterC);
		GridBagLayout gbl_pnlDiameterC = new GridBagLayout();
		gbl_pnlDiameterC.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_pnlDiameterC.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlDiameterC.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlDiameterC.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlDiameterC.setLayout(gbl_pnlDiameterC);
		
		JLabel lblDiameterFromC = new JLabel("From:");
		lblDiameterFromC.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblDiameterFromC = new GridBagConstraints();
		gbc_lblDiameterFromC.ipadx = 2;
		gbc_lblDiameterFromC.insets = new Insets(0, 2, 5, 5);
		gbc_lblDiameterFromC.gridx = 0;
		gbc_lblDiameterFromC.gridy = 1;
		pnlDiameterC.add(lblDiameterFromC, gbc_lblDiameterFromC);
		
		JSpinner spnDiameterFromC = new JSpinner();
		GridBagConstraints gbc_spnDiameterFromC = new GridBagConstraints();
		gbc_spnDiameterFromC.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnDiameterFromC.gridwidth = 2;
		gbc_spnDiameterFromC.insets = new Insets(0, 0, 5, 0);
		gbc_spnDiameterFromC.gridx = 1;
		gbc_spnDiameterFromC.gridy = 1;
		pnlDiameterC.add(spnDiameterFromC, gbc_spnDiameterFromC);
		
		JLabel lblDiameterToC = new JLabel("To:");
		lblDiameterToC.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblDiameterToC = new GridBagConstraints();
		gbc_lblDiameterToC.insets = new Insets(0, 0, 0, 5);
		gbc_lblDiameterToC.gridx = 0;
		gbc_lblDiameterToC.gridy = 2;
		pnlDiameterC.add(lblDiameterToC, gbc_lblDiameterToC);
		
		JSpinner spnDiameterToC = new JSpinner();
		GridBagConstraints gbc_spnDiameterToC = new GridBagConstraints();
		gbc_spnDiameterToC.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnDiameterToC.gridwidth = 2;
		gbc_spnDiameterToC.gridx = 1;
		gbc_spnDiameterToC.gridy = 2;
		pnlDiameterC.add(spnDiameterToC, gbc_spnDiameterToC);
		
		JPanel pnlDiameterD = new JPanel();
		pnlDiameterD.setBackground(new Color(224, 255, 255));
		pnlExportAnalysis.add(pnlDiameterD);
		GridBagLayout gbl_pnlDiameterD = new GridBagLayout();
		gbl_pnlDiameterD.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_pnlDiameterD.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlDiameterD.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlDiameterD.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlDiameterD.setLayout(gbl_pnlDiameterD);
		
		JLabel lblDiameterFromD = new JLabel("From:");
		lblDiameterFromD.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblDiameterFromD = new GridBagConstraints();
		gbc_lblDiameterFromD.ipadx = 2;
		gbc_lblDiameterFromD.insets = new Insets(0, 2, 5, 5);
		gbc_lblDiameterFromD.gridx = 0;
		gbc_lblDiameterFromD.gridy = 1;
		pnlDiameterD.add(lblDiameterFromD, gbc_lblDiameterFromD);
		
		JSpinner spnDiameterFromD = new JSpinner();
		GridBagConstraints gbc_spnDiameterFromD = new GridBagConstraints();
		gbc_spnDiameterFromD.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnDiameterFromD.gridwidth = 2;
		gbc_spnDiameterFromD.insets = new Insets(0, 0, 5, 0);
		gbc_spnDiameterFromD.gridx = 1;
		gbc_spnDiameterFromD.gridy = 1;
		pnlDiameterD.add(spnDiameterFromD, gbc_spnDiameterFromD);
		
		JLabel lblDiameterToD = new JLabel("To:");
		lblDiameterToD.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblDiameterToD = new GridBagConstraints();
		gbc_lblDiameterToD.insets = new Insets(0, 0, 0, 5);
		gbc_lblDiameterToD.gridx = 0;
		gbc_lblDiameterToD.gridy = 2;
		pnlDiameterD.add(lblDiameterToD, gbc_lblDiameterToD);
		
		JSpinner spnDiameterToD = new JSpinner();
		GridBagConstraints gbc_spnDiameterToD = new GridBagConstraints();
		gbc_spnDiameterToD.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnDiameterToD.gridwidth = 2;
		gbc_spnDiameterToD.gridx = 1;
		gbc_spnDiameterToD.gridy = 2;
		pnlDiameterD.add(spnDiameterToD, gbc_spnDiameterToD);
		
		JPanel pnlDiameterE = new JPanel();
		pnlDiameterE.setBackground(new Color(224, 255, 255));
		pnlExportAnalysis.add(pnlDiameterE);
		GridBagLayout gbl_pnlDiameterE = new GridBagLayout();
		gbl_pnlDiameterE.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_pnlDiameterE.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlDiameterE.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlDiameterE.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlDiameterE.setLayout(gbl_pnlDiameterE);
		
		JLabel lblDiameterFromE = new JLabel("From:");
		lblDiameterFromE.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblDiameterFromE = new GridBagConstraints();
		gbc_lblDiameterFromE.ipadx = 2;
		gbc_lblDiameterFromE.insets = new Insets(0, 2, 5, 5);
		gbc_lblDiameterFromE.gridx = 0;
		gbc_lblDiameterFromE.gridy = 1;
		pnlDiameterE.add(lblDiameterFromE, gbc_lblDiameterFromE);
		
		JSpinner spnDiameterFromE = new JSpinner();
		GridBagConstraints gbc_spnDiameterFromE = new GridBagConstraints();
		gbc_spnDiameterFromE.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnDiameterFromE.gridwidth = 2;
		gbc_spnDiameterFromE.insets = new Insets(0, 0, 5, 0);
		gbc_spnDiameterFromE.gridx = 1;
		gbc_spnDiameterFromE.gridy = 1;
		pnlDiameterE.add(spnDiameterFromE, gbc_spnDiameterFromE);
		
		JLabel lblDiameterToE = new JLabel("To:");
		lblDiameterToE.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblDiameterToE = new GridBagConstraints();
		gbc_lblDiameterToE.insets = new Insets(0, 0, 0, 5);
		gbc_lblDiameterToE.gridx = 0;
		gbc_lblDiameterToE.gridy = 2;
		pnlDiameterE.add(lblDiameterToE, gbc_lblDiameterToE);
		
		JSpinner spnDiameterToE = new JSpinner();
		GridBagConstraints gbc_spnDiameterToE = new GridBagConstraints();
		gbc_spnDiameterToE.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnDiameterToE.gridwidth = 2;
		gbc_spnDiameterToE.gridx = 1;
		gbc_spnDiameterToE.gridy = 2;
		pnlDiameterE.add(spnDiameterToE, gbc_spnDiameterToE);
		
		JPanel pnlDiameterF = new JPanel();
		pnlDiameterF.setBackground(new Color(221, 160, 221));
		pnlExportAnalysis.add(pnlDiameterF);
		GridBagLayout gbl_pnlDiameterF = new GridBagLayout();
		gbl_pnlDiameterF.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_pnlDiameterF.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlDiameterF.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlDiameterF.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlDiameterF.setLayout(gbl_pnlDiameterF);
		
		JLabel lblDiameterFromF = new JLabel("From:");
		lblDiameterFromF.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblDiameterFromF = new GridBagConstraints();
		gbc_lblDiameterFromF.ipadx = 2;
		gbc_lblDiameterFromF.insets = new Insets(0, 2, 5, 5);
		gbc_lblDiameterFromF.gridx = 0;
		gbc_lblDiameterFromF.gridy = 1;
		pnlDiameterF.add(lblDiameterFromF, gbc_lblDiameterFromF);
		
		JSpinner spnDiameterFromF = new JSpinner();
		GridBagConstraints gbc_spnDiameterFromF = new GridBagConstraints();
		gbc_spnDiameterFromF.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnDiameterFromF.gridwidth = 2;
		gbc_spnDiameterFromF.insets = new Insets(0, 0, 5, 0);
		gbc_spnDiameterFromF.gridx = 1;
		gbc_spnDiameterFromF.gridy = 1;
		pnlDiameterF.add(spnDiameterFromF, gbc_spnDiameterFromF);
		
		JLabel lblDiameterToF = new JLabel("To:");
		lblDiameterToF.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblDiameterToF = new GridBagConstraints();
		gbc_lblDiameterToF.insets = new Insets(0, 0, 0, 5);
		gbc_lblDiameterToF.gridx = 0;
		gbc_lblDiameterToF.gridy = 2;
		pnlDiameterF.add(lblDiameterToF, gbc_lblDiameterToF);
		
		JSpinner spnDiameterToF = new JSpinner();
		GridBagConstraints gbc_spnDiameterToF = new GridBagConstraints();
		gbc_spnDiameterToF.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnDiameterToF.gridwidth = 2;
		gbc_spnDiameterToF.gridx = 1;
		gbc_spnDiameterToF.gridy = 2;
		pnlDiameterF.add(spnDiameterToF, gbc_spnDiameterToF);



		JLabel lblBroken = new JLabel("Broken");
		lblBroken.setFont(new Font("Arial", Font.BOLD, 15));
		lblBroken.setHorizontalAlignment(SwingConstants.CENTER);
		lblBroken.setBackground(Color.WHITE);
		pnlExportAnalysis.add(lblBroken);

		JPanel pnlBrokenA = new JPanel();
		pnlExportAnalysis.add(pnlBrokenA);

		pnlBrokenA.setBackground(new Color(230, 230, 250));
		FlowLayout _pnlBrokenA = (FlowLayout) pnlBrokenA.getLayout();
		_pnlBrokenA.setVgap(33);

		JSpinner spnBrokenA = new JSpinner();
		spnBrokenA.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenA.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenA.setPreferredSize(new Dimension(80, 20));
		spnBrokenA.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlBrokenA.add(spnBrokenA);



		JPanel pnlBrokenB = new JPanel();
		pnlExportAnalysis.add(pnlBrokenB);

		pnlBrokenB.setBackground(new Color(230, 230, 250));
		FlowLayout _pnlBrokenB = (FlowLayout) pnlBrokenB.getLayout();
		_pnlBrokenB.setVgap(33);

		JSpinner spnBrokenB = new JSpinner();
		spnBrokenB.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenB.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenB.setPreferredSize(new Dimension(80, 20));
		spnBrokenB.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlBrokenB.add(spnBrokenB);

		JPanel pnlBrokenC = new JPanel();
		pnlExportAnalysis.add(pnlBrokenC);

		pnlBrokenC.setBackground(new Color(230, 230, 250));
		FlowLayout _pnlBrokenC = (FlowLayout) pnlBrokenC.getLayout();
		_pnlBrokenC.setVgap(33);

		JSpinner spnBrokenC = new JSpinner();
		spnBrokenC.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenC.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenC.setPreferredSize(new Dimension(80, 20));
		spnBrokenC.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlBrokenC.add(spnBrokenC);

		JPanel pnlBrokenE = new JPanel();
		pnlExportAnalysis.add(pnlBrokenE);

		pnlBrokenE.setBackground(new Color(224, 255, 255));
		FlowLayout _pnlBrokenE = (FlowLayout) pnlBrokenE.getLayout();
		_pnlBrokenE.setVgap(33);

		JSpinner spnBrokenE = new JSpinner();
		spnBrokenE.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenE.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenE.setPreferredSize(new Dimension(80, 20));
		spnBrokenE.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlBrokenE.add(spnBrokenE);


		JPanel pnlBrokenF = new JPanel();
		pnlExportAnalysis.add(pnlBrokenF);

		pnlBrokenF.setBackground(new Color(224, 255, 255));
		FlowLayout _pnlBrokenF = (FlowLayout) pnlBrokenF.getLayout();
		_pnlBrokenF.setVgap(33);

		JSpinner spnBrokenF = new JSpinner();
		spnBrokenF.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenF.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenF.setPreferredSize(new Dimension(80, 20));
		spnBrokenF.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlBrokenF.add(spnBrokenF);
		
		JPanel pnlBrokenF1 = new JPanel();
		FlowLayout fl_pnlBrokenF1 = (FlowLayout) pnlBrokenF1.getLayout();
		fl_pnlBrokenF1.setVgap(33);
		pnlBrokenF1.setBackground(new Color(221, 160, 221));
		pnlExportAnalysis.add(pnlBrokenF1);
		
		JSpinner spnBrokenF1 = new JSpinner();
		spnBrokenF1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenF1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenF1.setPreferredSize(new Dimension(80, 20));
		spnBrokenF1.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlBrokenF1.add(spnBrokenF1);
		
		

		JLabel lblS_Shape = new JLabel("S Shape");
		lblS_Shape.setFont(new Font("Arial", Font.BOLD, 15));
		lblS_Shape.setHorizontalAlignment(SwingConstants.CENTER);
		lblS_Shape.setBackground(Color.WHITE);
		pnlExportAnalysis.add(lblS_Shape);


		JPanel pnlS_ShapeA = new JPanel();
		pnlExportAnalysis.add(pnlS_ShapeA);
		
		pnlS_ShapeA.setBackground(new Color(230, 230, 250));
		FlowLayout _pnlS_ShapeA = (FlowLayout) pnlS_ShapeA.getLayout();
		_pnlS_ShapeA.setVgap(33);

		JSpinner spnS_ShapeA = new JSpinner();
		spnS_ShapeA.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeA.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeA.setPreferredSize(new Dimension(80, 20));
		spnS_ShapeA.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlS_ShapeA.add(spnS_ShapeA);

		JPanel pnlS_ShapeB = new JPanel();
		pnlExportAnalysis.add(pnlS_ShapeB);
		
		pnlS_ShapeB.setBackground(new Color(230, 230, 250));
		FlowLayout _pnlS_ShapeB = (FlowLayout) pnlS_ShapeB.getLayout();
		_pnlS_ShapeB.setVgap(33);

		JSpinner spnS_ShapeB = new JSpinner();
		spnS_ShapeB.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeB.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeB.setPreferredSize(new Dimension(80, 20));
		spnS_ShapeB.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlS_ShapeB.add(spnS_ShapeB);

		JPanel pnlS_ShapeC = new JPanel();
		pnlExportAnalysis.add(pnlS_ShapeC);
		
		pnlS_ShapeC.setBackground(new Color(230, 230, 250));
		FlowLayout _pnlS_ShapeC = (FlowLayout) pnlS_ShapeC.getLayout();
		_pnlS_ShapeC.setVgap(33);

		JSpinner spnS_ShapeC = new JSpinner();
		spnS_ShapeC.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeC.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeC.setPreferredSize(new Dimension(80, 20));
		spnS_ShapeC.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlS_ShapeC.add(spnS_ShapeC);

		JPanel pnlS_ShapeD = new JPanel();
		pnlExportAnalysis.add(pnlS_ShapeD);
		
		pnlS_ShapeD.setBackground(new Color(224, 255, 255));
		FlowLayout _pnlS_ShapeD = (FlowLayout) pnlS_ShapeD.getLayout();
		_pnlS_ShapeD.setVgap(33);;

		JSpinner spnS_ShapeD = new JSpinner();
		spnS_ShapeD.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeD.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeD.setPreferredSize(new Dimension(80, 20));
		spnS_ShapeD.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlS_ShapeD.add(spnS_ShapeD);

		JPanel pnlS_ShapeE = new JPanel();
		pnlExportAnalysis.add(pnlS_ShapeE);
		
		pnlS_ShapeE.setBackground(new Color(224, 255, 255));
		FlowLayout _pnlS_ShapeE = (FlowLayout) pnlS_ShapeE.getLayout();
		_pnlS_ShapeE.setVgap(33);

		JSpinner spnS_ShapeE = new JSpinner();
		spnS_ShapeE.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeE.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeE.setPreferredSize(new Dimension(80, 20));
		spnS_ShapeE.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlS_ShapeE.add(spnS_ShapeE);
		
		
		JPanel pnlS_ShapeF = new JPanel();
		pnlExportAnalysis.add(pnlS_ShapeF);
		
		pnlS_ShapeF.setBackground(new Color(221, 160, 221));
		FlowLayout _pnlS_ShapeF = (FlowLayout) pnlS_ShapeF.getLayout();
		_pnlS_ShapeF.setVgap(33);

		JSpinner spnS_ShapeF = new JSpinner();
		spnS_ShapeF.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeF.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeF.setPreferredSize(new Dimension(80, 20));
		spnS_ShapeF.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlS_ShapeF.add(spnS_ShapeF);

		JLabel lblC_Shape = new JLabel("C Shape");
		lblC_Shape.setFont(new Font("Arial", Font.BOLD, 15));
		lblC_Shape.setHorizontalAlignment(SwingConstants.CENTER);
		lblC_Shape.setBackground(Color.WHITE);
		pnlExportAnalysis.add(lblC_Shape);

		JPanel pnlC_ShapeA = new JPanel();
		pnlExportAnalysis.add(pnlC_ShapeA);
		
		pnlC_ShapeA.setBackground(new Color(230, 230, 250));
		pnlC_ShapeA.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		JSpinner spnC_ShapeA = new JSpinner();
		spnC_ShapeA.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnC_ShapeA.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnC_ShapeA.setPreferredSize(new Dimension(80, 20));
		spnC_ShapeA.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlC_ShapeA.add(spnC_ShapeA);

		JPanel pnlC_ShapeB = new JPanel();
		pnlExportAnalysis.add(pnlC_ShapeB);
		
		pnlC_ShapeB.setBackground(new Color(230, 230, 250));
		pnlC_ShapeB.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		JSpinner spnC_ShapeB = new JSpinner();
		spnC_ShapeB.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnC_ShapeB.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnC_ShapeB.setPreferredSize(new Dimension(80, 20));
		spnC_ShapeB.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlC_ShapeB.add(spnC_ShapeB);

		JPanel pnlC_ShapeC = new JPanel();
		pnlExportAnalysis.add(pnlC_ShapeC);
		
		pnlC_ShapeC.setBackground(new Color(230, 230, 250));
		pnlC_ShapeC.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		JSpinner spnC_ShapeC = new JSpinner();
		spnC_ShapeC.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnC_ShapeC.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnC_ShapeC.setPreferredSize(new Dimension(80, 20));
		spnC_ShapeC.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlC_ShapeC.add(spnC_ShapeC);


		JPanel pnlC_ShapeD = new JPanel();
		pnlExportAnalysis.add(pnlC_ShapeD);
		
		pnlC_ShapeD.setBackground(new Color(224, 255, 255));
		pnlC_ShapeD.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		JSpinner spnC_ShapeD = new JSpinner();
		spnC_ShapeD.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnC_ShapeD.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnC_ShapeD.setPreferredSize(new Dimension(80, 20));
		spnC_ShapeD.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlC_ShapeD.add(spnC_ShapeD);
		

		JPanel pnlC_ShapeE = new JPanel();
		pnlExportAnalysis.add(pnlC_ShapeE);
		
		pnlC_ShapeE.setBackground(new Color(224, 255, 255));
		pnlC_ShapeE.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		JSpinner spnC_ShapeE = new JSpinner();
		spnC_ShapeE.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnC_ShapeE.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnC_ShapeE.setPreferredSize(new Dimension(80, 20));
		spnC_ShapeE.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pnlC_ShapeE.add(spnC_ShapeE);
		
				JPanel pnlC_ShapeF = new JPanel();
				pnlExportAnalysis.add(pnlC_ShapeF);
				
						pnlC_ShapeF.setBackground(new Color(221, 160, 221));
						pnlC_ShapeF.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
						
								JSpinner spnC_ShapeF = new JSpinner();
								spnC_ShapeF.setAlignmentX(Component.RIGHT_ALIGNMENT);
								spnC_ShapeF.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
								spnC_ShapeF.setPreferredSize(new Dimension(80, 20));
								spnC_ShapeF.setModel(new SpinnerNumberModel(0, 0, 100, 1));
								pnlC_ShapeF.add(spnC_ShapeF);
		
		JPanel pnlbottomEmpty1 = new JPanel();
		pnlExportAnalysis.add(pnlbottomEmpty1);
		
		JPanel pnlbottomEmpty2 = new JPanel();
		pnlExportAnalysis.add(pnlbottomEmpty2);
		pnlbottomEmpty2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel pnlbottomEmpty3 = new JPanel();
		pnlExportAnalysis.add(pnlbottomEmpty3);
		pnlbottomEmpty3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel pnlBottomSort = new JPanel();
		pnlExportAnalysis.add(pnlBottomSort);
		pnlBottomSort.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSort = new JButton("Sort");
		pnlBottomSort.add(btnSort);
		btnSort.setPreferredSize(new Dimension(100, 50));
		
		JPanel pnlBottomReset = new JPanel();
		pnlExportAnalysis.add(pnlBottomReset);
		pnlBottomReset.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnResert = new JButton("Reset");
		pnlBottomReset.add(btnResert);
		btnResert.setPreferredSize(new Dimension(100, 50));
		
		JPanel pnlBottomDefault = new JPanel();
		pnlExportAnalysis.add(pnlBottomDefault);
		pnlBottomDefault.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnDefaultData = new JButton("Default Data ");
		pnlBottomDefault.add(btnDefaultData);
		btnDefaultData.setPreferredSize(new Dimension(100, 50));
		
		JPanel pnlbottomEmpty4 = new JPanel();
		pnlExportAnalysis.add(pnlbottomEmpty4);
		

	}

}