package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.RootPaneContainer;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Classes.ClassDetails;
import Classes.CulcResults;
import Classes.MachineOutput;
import Classes.Sorts;
import Handlers.ExportToExcel;
import Handlers.SendServer;
import Validation.ValidationFunctions;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class Statistics {

	private JFrame frmStatistics;
	private JSpinner spnLengthFromA;
	private JSpinner spnLengthFromB;
	private JSpinner spnLengthFromC;
	private JSpinner spnLengthFromD;
	private JSpinner spnLengthFromE;
	private JSpinner spnLengthFromF;
	private JSpinner spnLengthToA;
	private JSpinner spnLengthToB;
	private JSpinner spnLengthToC;
	private JSpinner spnLengthToD;
	private JSpinner spnLengthToE;
	private JSpinner spnLengthToF;
	private JSpinner spnDiameterFromA;
	private JSpinner spnDiameterFromB;
	private JSpinner spnDiameterFromC;
	private JSpinner spnDiameterFromD;
	private JSpinner spnDiameterFromE;
	private JSpinner spnDiameterFromF;
	private JSpinner spnDiameterToA;
	private JSpinner spnDiameterToB;
	private JSpinner spnDiameterToC;
	private JSpinner spnDiameterToD;
	private JSpinner spnDiameterToE;
	private JSpinner spnDiameterToF;
	private JSpinner spnBrokenA;
	private JSpinner spnBrokenB;
	private JSpinner spnBrokenC;
	private JSpinner spnBrokenD;
	private JSpinner spnBrokenE;
	private JSpinner spnBrokenF;
	private JSpinner spnS_ShapeA;
	private JSpinner spnS_ShapeB;
	private JSpinner spnS_ShapeC;
	private JSpinner spnS_ShapeD;
	private JSpinner spnS_ShapeE;
	private JSpinner spnS_ShapeF;
	private JSpinner spnC_ShapeA;
	private JSpinner spnC_ShapeB;
	private JSpinner spnC_ShapeC;
	private JSpinner spnC_ShapeD;
	private JSpinner spnC_ShapeE;
	private JSpinner spnC_ShapeF;
	private static int[] sensDet = new int[4];
	private SensitivityDetails sensA;
	private SensitivityDetails sensB;
	private SensitivityDetails sensC;
	private SensitivityDetails sensD;
	private SensitivityDetails sensE;
	private SensitivityDetails sensF;
	private int[] classASens = new int[4];
	private int[] classBSens = new int[4];
	private int[] classCSens = new int[4];
	private int[] classDSens = new int[4];
	private int[] classESens = new int[4];
	private int[] classFSens = new int[4];
	private List<Sorts> sorts = new ArrayList<>();
	private JComboBox<String> cmbLastExportRes;

	/**
	 * Create the application.
	 */
	public Statistics() {
		initialize();
		getDataFromDB();
		buildMenu();
		frmStatistics.setVisible(true);
	}


	public Statistics(Sorts sort) {
		initialize();
		getDataFromDB(sort);
		updateFields(sort);
		buildMenu();
		frmStatistics.setVisible(true);
	}

	private void buildMenu(){

		JMenuBar menuBar = new JMenuBar();
		frmStatistics.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		menuBar.add(mnFile);

		JMenuItem mntmMenu = new JMenuItem("Main Menu");
		mntmMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MainMenuWindow();
				frmStatistics.dispose();

			}
		});
		mnFile.add(mntmMenu);

		JSeparator separator = new JSeparator();
		mnFile.add(separator);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(frmStatistics, "Are you sure to close this window?", "Really Closing?", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		mnFile.add(mntmExit);

		JMenu mnNew = new JMenu("New");
		menuBar.add(mnNew);

		JMenuItem mntmNewSort = new JMenuItem("Sort");
		mntmNewSort.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new NewSort();
				frmStatistics.dispose();

			}
		});
		mnNew.add(mntmNewSort);

		JMenuItem mntmUpdatenewCustomer = new JMenuItem("Grower/Plot");
		mntmUpdatenewCustomer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new NewCustomer();
				frmStatistics.dispose();

			}
		});
		mnNew.add(mntmUpdatenewCustomer);

		JMenu mnEdit = new JMenu("Action");
		menuBar.add(mnEdit);

		JMenuItem mntmSearch = new JMenuItem("Search");
		mnEdit.add(mntmSearch);
		mntmSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GlobalSearchWindow();
				frmStatistics.dispose();

			}
		});

		JMenuItem mntmStatistics = new JMenuItem("Statistics");
		mnEdit.add(mntmStatistics);

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


		try {
			frmStatistics.setIconImage(ImageIO.read(new File("img/logo.png")));
		}
		catch (IOException exc) {
			exc.printStackTrace();
		}

		JPanel pnlHeaderWindow = new JPanel();
		pnlHeaderWindow.setBackground(new Color(192, 192, 192));
		FlowLayout fl_pnlHeaderWindow = (FlowLayout) pnlHeaderWindow.getLayout();
		fl_pnlHeaderWindow.setVgap(50);
		frmStatistics.getContentPane().add(pnlHeaderWindow, BorderLayout.NORTH);



		JLabel lblStatistics = new JLabel("Statistics");
		lblStatistics.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 47));
		pnlHeaderWindow.add(lblStatistics);




		JPanel pnLeft = new JPanel();
		pnLeft.setBackground(new Color(192, 192, 192));
		pnLeft.setPreferredSize(new Dimension(600, 10));
		frmStatistics.getContentPane().add(pnLeft, BorderLayout.WEST);
		pnLeft.setLayout(new BorderLayout(0, 20));

		JPanel pnlExport = new JPanel();
		pnlExport.setBackground(new Color(128, 128, 128));
		FlowLayout fl_pnlExport = (FlowLayout) pnlExport.getLayout();
		fl_pnlExport.setVgap(20);
		pnLeft.add(pnlExport, BorderLayout.NORTH);

		JLabel lblExport = new JLabel("Export / Forecast");
		lblExport.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		pnlExport.add(lblExport);

		///////////////



		JPanel pnlExportDetails = new JPanel();
		pnlExportDetails.setBackground(new Color(192, 192, 192));
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

		JLabel lblChooseWhatTo = new JLabel("Choose What To Export/Forecast:");
		lblChooseWhatTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseWhatTo.setFont(new Font("Arial", Font.BOLD, 15));
		lblChooseWhatTo.setPreferredSize(new Dimension(250, 25));
		pnlExportDetails.add(lblChooseWhatTo, "2, 4, 35, 1, center, fill");

		JLabel lblLastSorts = new JLabel("Last Sorts: ");
		lblLastSorts.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLastSorts.setFont(new Font("Arial", Font.PLAIN, 12));
		pnlExportDetails.add(lblLastSorts, "2, 8, right, default");

		cmbLastExportRes = new JComboBox<String>();
		pnlExportDetails.add(cmbLastExportRes, "8, 8, 25, 1, fill, fill");

		cmbLastExportRes.addActionListener(new ActionListener() { 

			@Override
			public void actionPerformed(ActionEvent e) {
				Sorts sort = getCurrentSort();
				if (sort!=null)
					updateFields(getCurrentSort());
			}
		});

		JButton btnFindSort = new JButton("Find Sort");
		btnFindSort.setBackground(new Color(230, 230, 250));
		btnFindSort.setFont(new Font("Arial", Font.PLAIN, 12));
		pnlExportDetails.add(btnFindSort, "14, 12, 1, 3");
		btnFindSort.setContentAreaFilled(false);
		btnFindSort.setOpaque(true);

		btnFindSort.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GlobalSearchWindow();
				frmStatistics.dispose();

			}
		});

		JLabel lblSearchSort = new JLabel("Search for sort:");
		lblSearchSort.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSearchSort.setFont(new Font("Arial", Font.PLAIN, 12));
		pnlExportDetails.add(lblSearchSort, "2, 14, fill, fill");

		JButton btnResort = new JButton("Resort");
		btnResort.setBackground(new Color(230, 230, 250));
		btnResort.setFont(new Font("Arial", Font.PLAIN, 12));
		btnResort.setContentAreaFilled(false);
		btnResort.setOpaque(true);
		pnlExportDetails.add(btnResort, "14, 18, 1, 3");


		//------------------------------------------------------------------------------------------------------------------------------------------//
		btnResort.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				//set date to check 
				Calendar sd = Calendar.getInstance();
				sd.set(2017, Calendar.APRIL, 30, 21, 00);
				Date start = sd.getTime();
				Calendar ed = Calendar.getInstance();
				ed.set(2017, Calendar.APRIL, 30, 22, 59);
				Date end = ed.getTime();


				Sorts tempSort;
				MachineOutput mac = null;
				CulcResults culc = null;


				if (getCurrentSort().getCarrots().size()==0){
					//culc = new CulcResults(new MachineOutput(getCurrentSort().getStartData(), getCurrentSort().getEndDate()), getCurrentSort());
					mac = new MachineOutput(start, end);
					mac.fillDetailsDB();
					culc = new CulcResults(mac, getCurrentSort());
					culc.fillDate();
					tempSort = buildSort();
					tempSort = culc.reSort(tempSort);

				}
				else{
					tempSort = buildSort();
					tempSort.setClassesOutcome(new int[7]);
					tempSort.setClassOutcomeWeight(new float[7]);
					culc = new CulcResults(tempSort);
					tempSort = culc.reSort(tempSort);
				}

				JOptionPane.showMessageDialog(null, buildResult(tempSort), "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);

			}
		});

		JLabel lblResortByNew = new JLabel("Resort by New Details:");
		lblResortByNew.setFont(new Font("Arial", Font.PLAIN, 12));
		pnlExportDetails.add(lblResortByNew, "2, 20");

		JButton btnForecast = new JButton("Forecasting Data");
		btnForecast.setBackground(new Color(230, 230, 250));
		btnForecast.setFont(new Font("Arial", Font.PLAIN, 12));
		btnForecast.setPreferredSize(new Dimension(65, 25));
		btnForecast.setContentAreaFilled(false);
		btnForecast.setOpaque(true);
		pnlExportDetails.add(btnForecast, "14, 24, 9, 3, fill, fill");

		btnForecast.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {


			}
		});

		JLabel lblOptimizeSort = new JLabel("Optimize Sort:");
		lblOptimizeSort.setFont(new Font("Arial", Font.PLAIN, 12));
		pnlExportDetails.add(lblOptimizeSort, "2, 26, right, default");

		JButton btnExport = new JButton("Export");
		btnExport.setBackground(new Color(230, 230, 250));
		btnExport.setFont(new Font("Arial", Font.PLAIN, 12));
		btnExport.setPreferredSize(new Dimension(65, 25));
		btnExport.setContentAreaFilled(false);
		btnExport.setOpaque(true);
		pnlExportDetails.add(btnExport, "14, 30, 1, 3");

		btnExport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ValidationFunctions val = new ValidationFunctions();
				Sorts sort = getCurrentSort();

				if (sort!=null){
					JTextArea textArea = new JTextArea();
					textArea.setEditable(true);
					JScrollPane scrollPane = new JScrollPane(textArea);
					scrollPane.requestFocus();
					textArea.requestFocusInWindow();
					scrollPane.setPreferredSize(new Dimension(800, 600)); 
					JFrame frame = new JFrame("InputDialog Example #1");
					frame.setTitle("Export");
					String name = JOptionPane.showInputDialog(frame, "Enter File Name: ");

					if (name != null){
						if (!val.checkString(name)){
							JOptionPane.showMessageDialog(frmStatistics, "Wrong Name - only letters and numbers!");
						}
						else{
							ExportToExcel ex = new ExportToExcel(sort, name);
							try {
								ex.exportData();
							} catch (FileNotFoundException e1) {
								//System.out.println("something went wrong with excel Export! ");
								JOptionPane.showMessageDialog(frmStatistics, "something went wrong with excel Export!");
								e1.printStackTrace();
							} catch (IOException e1) {
								JOptionPane.showMessageDialog(frmStatistics, "something went wrong with excel Export!");
								//System.out.println("something went wrong with excel Export! ");
								e1.printStackTrace();
							}
						}
					}
				}
				else{
					JOptionPane.showMessageDialog(frmStatistics, "No sorts");
				}
			}
		});


		JLabel lblExportToExcel = new JLabel("Export To Excel:");
		lblExportToExcel.setFont(new Font("Arial", Font.PLAIN, 12));
		pnlExportDetails.add(lblExportToExcel, "2, 32, right, default");

		JButton btnBack = new JButton("Back");
		btnBack.setForeground(new Color(255, 0, 0));
		btnBack.setBackground(new Color(230, 230, 250));
		btnBack.setFont(new Font("Arial", Font.BOLD, 12));
		btnBack.setContentAreaFilled(false);
		btnBack.setOpaque(true);
		pnlExportDetails.add(btnBack, "2, 36");

		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MainMenuWindow();
				frmStatistics.dispose();
			}
		});


		JPanel pnlRight = new JPanel();
		pnlRight.setBackground(new Color(192, 192, 192));
		frmStatistics.getContentPane().add(pnlRight, BorderLayout.CENTER);
		pnlRight.setLayout(new BorderLayout(0, 20));

		JPanel pnlDataAnalysis = new JPanel();
		pnlDataAnalysis.setBackground(new Color(128, 128, 128));
		FlowLayout fl_pnlDataAnalysis = (FlowLayout) pnlDataAnalysis.getLayout();
		fl_pnlDataAnalysis.setVgap(20);
		pnlRight.add(pnlDataAnalysis, BorderLayout.NORTH);

		JLabel lblDataAnalysis = new JLabel("Data Analysis");
		lblDataAnalysis.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		pnlDataAnalysis.add(lblDataAnalysis);

		JPanel pnlExportAnalysis = new JPanel();
		pnlExportAnalysis.setBackground(new Color(192, 192, 192));
		pnlRight.add(pnlExportAnalysis, BorderLayout.CENTER);


		////////////////////////////////////////////////////////////////
		pnlExportAnalysis.setLayout(new GridLayout(7, 7, 4, 0));

		/////////////// class types /////////////////////////////

		JLabel lblInput = new JLabel("Input");
		lblInput.setForeground(new Color(0, 0, 0));
		lblInput.setFont(new Font("Arial", Font.BOLD, 18));
		lblInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblInput.setBackground(new Color(0, 51, 102));
		pnlExportAnalysis.add(lblInput);

		JButton btnClassA = new JButton("Class A");
		btnClassA.setBorderPainted(false);
		btnClassA.setBackground(new Color(230, 230, 250));
		btnClassA.setFont(new Font("Arial", Font.BOLD, 15));
		pnlExportAnalysis.add(btnClassA);
		btnClassA.setContentAreaFilled(false);
		btnClassA.setOpaque(true);

		btnClassA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (sensA==null)
					sensA = new SensitivityDetails();
				else
					sensA.setVisible(true);

			}
		});

		JButton btnClassB = new JButton("Class B");
		btnClassB.setBorderPainted(false);
		btnClassB.setBackground(new Color(230, 230, 250));
		btnClassB.setFont(new Font("Arial", Font.BOLD, 15));
		pnlExportAnalysis.add(btnClassB);
		btnClassB.setContentAreaFilled(false);
		btnClassB.setOpaque(true);

		btnClassB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (sensB==null)
					sensB = new SensitivityDetails();
				else
					sensB.setVisible(true);

			}
		});

		JButton btnClassC = new JButton("Class C");
		btnClassC.setBorderPainted(false);
		btnClassC.setBackground(new Color(230, 230, 250));
		btnClassC.setFont(new Font("Arial", Font.BOLD, 15));
		pnlExportAnalysis.add(btnClassC);
		btnClassC.setContentAreaFilled(false);
		btnClassC.setOpaque(true);

		btnClassC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (sensC==null)
					sensC = new SensitivityDetails();
				else
					sensC.setVisible(true);

			}
		});

		JButton btnClassD = new JButton("Class D");
		btnClassD.setBorderPainted(false);
		btnClassD.setBackground(new Color(224, 255, 255));
		btnClassD.setFont(new Font("Arial", Font.BOLD, 15));
		pnlExportAnalysis.add(btnClassD);
		btnClassD.setContentAreaFilled(false);
		btnClassD.setOpaque(true);

		btnClassD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (sensD==null)
					sensD = new SensitivityDetails();
				else
					sensD.setVisible(true);

			}
		});

		JButton btnClassE = new JButton("Class E");
		btnClassE.setBorderPainted(false);
		btnClassE.setBackground(new Color(224, 255, 255));
		btnClassE.setFont(new Font("Arial", Font.BOLD, 15));
		pnlExportAnalysis.add(btnClassE);
		btnClassE.setContentAreaFilled(false);
		btnClassE.setOpaque(true);

		btnClassE.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (sensE==null)
					sensE = new SensitivityDetails();
				else
					sensE.setVisible(true);

			}
		});

		JButton btnClassF = new JButton("Class F");
		btnClassF.setBorderPainted(false);
		btnClassF.setBackground(new Color(221, 160, 221));
		btnClassF.setFont(new Font("Arial", Font.BOLD, 15));
		pnlExportAnalysis.add(btnClassF);
		btnClassF.setContentAreaFilled(false);
		btnClassF.setOpaque(true);

		btnClassF.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (sensF==null)
					sensF = new SensitivityDetails();
				else
					sensF.setVisible(true);

			}
		});

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

		spnLengthFromA = new JSpinner();
		spnLengthFromA.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		spnLengthFromA.setFont(new Font("Arial", Font.BOLD, 12));
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

		spnLengthToA = new JSpinner();
		spnLengthToA.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		spnLengthToA.setFont(new Font("Arial", Font.BOLD, 12));
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
		gbl_pnlLengthB.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
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

		spnLengthFromB = new JSpinner();
		spnLengthFromB.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		spnLengthFromB.setFont(new Font("Arial", Font.BOLD, 12));
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

		spnLengthToB = new JSpinner();
		spnLengthToB.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		spnLengthToB.setFont(new Font("Arial", Font.BOLD, 12));
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
		gbl_pnlLengthC.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
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

		spnLengthFromC = new JSpinner();
		spnLengthFromC.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		spnLengthFromC.setFont(new Font("Arial", Font.BOLD, 12));
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

		spnLengthToC = new JSpinner();
		spnLengthToC.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		spnLengthToC.setFont(new Font("Arial", Font.BOLD, 12));
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
		gbl_pnlLengthD.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
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

		spnLengthFromD = new JSpinner();
		spnLengthFromD.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		spnLengthFromD.setFont(new Font("Arial", Font.BOLD, 12));
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

		spnLengthToD = new JSpinner();
		spnLengthToD.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		spnLengthToD.setFont(new Font("Arial", Font.BOLD, 12));
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
		gbl_pnlLengthE.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
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

		spnLengthFromE = new JSpinner();
		spnLengthFromE.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		spnLengthFromE.setFont(new Font("Arial", Font.BOLD, 12));
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

		spnLengthToE = new JSpinner();
		spnLengthToE.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		spnLengthToE.setFont(new Font("Arial", Font.BOLD, 12));
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
		gbl_pnlLengthF.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
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

		spnLengthFromF = new JSpinner();
		spnLengthFromF.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		spnLengthFromF.setFont(new Font("Arial", Font.BOLD, 12));
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

		spnLengthToF = new JSpinner();
		spnLengthToF.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		spnLengthToF.setFont(new Font("Arial", Font.BOLD, 12));
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
		gbl_pnlDiameterA.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
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

		spnDiameterFromA = new JSpinner();
		spnDiameterFromA.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		spnDiameterFromA.setFont(new Font("Arial", Font.BOLD, 12));
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

		spnDiameterToA = new JSpinner();
		spnDiameterToA.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		spnDiameterToA.setFont(new Font("Arial", Font.BOLD, 12));
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
		gbl_pnlDiameterB.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
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

		spnDiameterFromB = new JSpinner();
		spnDiameterFromB.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		spnDiameterFromB.setFont(new Font("Arial", Font.BOLD, 12));
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

		spnDiameterToB = new JSpinner();
		spnDiameterToB.setFont(new Font("Arial", Font.BOLD, 12));
		spnDiameterToB.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
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
		gbl_pnlDiameterC.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
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

		spnDiameterFromC = new JSpinner();
		spnDiameterFromC.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		spnDiameterFromC.setFont(new Font("Arial", Font.BOLD, 12));
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

		spnDiameterToC = new JSpinner();
		spnDiameterToC.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		spnDiameterToC.setFont(new Font("Arial", Font.BOLD, 12));
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
		gbl_pnlDiameterD.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
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

		spnDiameterFromD = new JSpinner();
		spnDiameterFromD.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		spnDiameterFromD.setFont(new Font("Arial", Font.BOLD, 12));
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

		spnDiameterToD = new JSpinner();
		spnDiameterToD.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		spnDiameterToD.setFont(new Font("Arial", Font.BOLD, 12));
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
		gbl_pnlDiameterE.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
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

		spnDiameterFromE = new JSpinner();
		spnDiameterFromE.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		spnDiameterFromE.setFont(new Font("Arial", Font.BOLD, 12));
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

		spnDiameterToE = new JSpinner();
		spnDiameterToE.setFont(new Font("Arial", Font.BOLD, 12));
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
		gbl_pnlDiameterF.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
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

		spnDiameterFromF = new JSpinner();
		spnDiameterFromF.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		spnDiameterFromF.setFont(new Font("Arial", Font.BOLD, 12));
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

		spnDiameterToF = new JSpinner();
		spnDiameterToF.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		spnDiameterToF.setFont(new Font("Arial", Font.BOLD, 12));
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

		spnBrokenA = new JSpinner();
		spnBrokenA.setFont(new Font("Arial", Font.BOLD, 12));
		spnBrokenA.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenA.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenA.setPreferredSize(new Dimension(80, 20));
		spnBrokenA.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		pnlBrokenA.add(spnBrokenA);



		JPanel pnlBrokenB = new JPanel();
		pnlExportAnalysis.add(pnlBrokenB);

		pnlBrokenB.setBackground(new Color(230, 230, 250));
		FlowLayout _pnlBrokenB = (FlowLayout) pnlBrokenB.getLayout();
		_pnlBrokenB.setVgap(33);

		spnBrokenB = new JSpinner();
		spnBrokenB.setFont(new Font("Arial", Font.BOLD, 12));
		spnBrokenB.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenB.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenB.setPreferredSize(new Dimension(80, 20));
		spnBrokenB.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		pnlBrokenB.add(spnBrokenB);

		JPanel pnlBrokenC = new JPanel();
		pnlExportAnalysis.add(pnlBrokenC);

		pnlBrokenC.setBackground(new Color(230, 230, 250));
		FlowLayout _pnlBrokenC = (FlowLayout) pnlBrokenC.getLayout();
		_pnlBrokenC.setVgap(33);

		spnBrokenC = new JSpinner();
		spnBrokenC.setFont(new Font("Arial", Font.BOLD, 12));
		spnBrokenC.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenC.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenC.setPreferredSize(new Dimension(80, 20));
		spnBrokenC.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		pnlBrokenC.add(spnBrokenC);

		JPanel pnlBrokenD = new JPanel();
		pnlExportAnalysis.add(pnlBrokenD);

		pnlBrokenD.setBackground(new Color(224, 255, 255));
		FlowLayout _pnlBrokenE = (FlowLayout) pnlBrokenD.getLayout();
		_pnlBrokenE.setVgap(33);

		spnBrokenD = new JSpinner();
		spnBrokenD.setFont(new Font("Arial", Font.BOLD, 12));
		spnBrokenD.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenD.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenD.setPreferredSize(new Dimension(80, 20));
		spnBrokenD.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		pnlBrokenD.add(spnBrokenD);


		JPanel pnlBrokenE = new JPanel();
		pnlExportAnalysis.add(pnlBrokenE);

		pnlBrokenE.setBackground(new Color(224, 255, 255));
		FlowLayout _pnlBrokenF = (FlowLayout) pnlBrokenE.getLayout();
		_pnlBrokenF.setVgap(33);

		spnBrokenE = new JSpinner();
		spnBrokenE.setFont(new Font("Arial", Font.BOLD, 12));
		spnBrokenE.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenE.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenE.setPreferredSize(new Dimension(80, 20));
		spnBrokenE.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		pnlBrokenE.add(spnBrokenE);

		JPanel pnlBrokenF = new JPanel();
		FlowLayout fl_pnlBrokenF1 = (FlowLayout) pnlBrokenF.getLayout();
		fl_pnlBrokenF1.setVgap(33);
		pnlBrokenF.setBackground(new Color(221, 160, 221));
		pnlExportAnalysis.add(pnlBrokenF);


		spnBrokenF = new JSpinner();
		spnBrokenF.setFont(new Font("Arial", Font.BOLD, 12));
		spnBrokenF.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenF.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenF.setPreferredSize(new Dimension(80, 20));
		spnBrokenF.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		pnlBrokenF.add(spnBrokenF);


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

		spnS_ShapeA = new JSpinner();
		spnS_ShapeA.setFont(new Font("Arial", Font.BOLD, 12));
		spnS_ShapeA.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeA.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeA.setPreferredSize(new Dimension(80, 20));
		spnS_ShapeA.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		pnlS_ShapeA.add(spnS_ShapeA);

		JPanel pnlS_ShapeB = new JPanel();
		pnlExportAnalysis.add(pnlS_ShapeB);

		pnlS_ShapeB.setBackground(new Color(230, 230, 250));
		FlowLayout _pnlS_ShapeB = (FlowLayout) pnlS_ShapeB.getLayout();
		_pnlS_ShapeB.setVgap(33);

		spnS_ShapeB = new JSpinner();
		spnS_ShapeB.setFont(new Font("Arial", Font.BOLD, 12));
		spnS_ShapeB.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeB.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeB.setPreferredSize(new Dimension(80, 20));
		spnS_ShapeB.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		pnlS_ShapeB.add(spnS_ShapeB);

		JPanel pnlS_ShapeC = new JPanel();
		pnlExportAnalysis.add(pnlS_ShapeC);

		pnlS_ShapeC.setBackground(new Color(230, 230, 250));
		FlowLayout _pnlS_ShapeC = (FlowLayout) pnlS_ShapeC.getLayout();
		_pnlS_ShapeC.setVgap(33);

		spnS_ShapeC = new JSpinner();
		spnS_ShapeC.setFont(new Font("Arial", Font.BOLD, 12));
		spnS_ShapeC.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeC.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeC.setPreferredSize(new Dimension(80, 20));
		spnS_ShapeC.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		pnlS_ShapeC.add(spnS_ShapeC);

		JPanel pnlS_ShapeD = new JPanel();
		pnlExportAnalysis.add(pnlS_ShapeD);

		pnlS_ShapeD.setBackground(new Color(224, 255, 255));
		FlowLayout _pnlS_ShapeD = (FlowLayout) pnlS_ShapeD.getLayout();
		_pnlS_ShapeD.setVgap(33);;

		spnS_ShapeD = new JSpinner();
		spnS_ShapeD.setFont(new Font("Arial", Font.BOLD, 12));
		spnS_ShapeD.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeD.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeD.setPreferredSize(new Dimension(80, 20));
		spnS_ShapeD.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		pnlS_ShapeD.add(spnS_ShapeD);

		JPanel pnlS_ShapeE = new JPanel();
		pnlExportAnalysis.add(pnlS_ShapeE);

		pnlS_ShapeE.setBackground(new Color(224, 255, 255));
		FlowLayout _pnlS_ShapeE = (FlowLayout) pnlS_ShapeE.getLayout();
		_pnlS_ShapeE.setVgap(33);

		spnS_ShapeE = new JSpinner();
		spnS_ShapeE.setFont(new Font("Arial", Font.BOLD, 12));
		spnS_ShapeE.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeE.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeE.setPreferredSize(new Dimension(80, 20));
		spnS_ShapeE.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		pnlS_ShapeE.add(spnS_ShapeE);


		JPanel pnlS_ShapeF = new JPanel();
		pnlExportAnalysis.add(pnlS_ShapeF);

		pnlS_ShapeF.setBackground(new Color(221, 160, 221));
		FlowLayout _pnlS_ShapeF = (FlowLayout) pnlS_ShapeF.getLayout();
		_pnlS_ShapeF.setVgap(33);

		spnS_ShapeF = new JSpinner();
		spnS_ShapeF.setFont(new Font("Arial", Font.BOLD, 12));
		spnS_ShapeF.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeF.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeF.setPreferredSize(new Dimension(80, 20));
		spnS_ShapeF.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
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

		spnC_ShapeA = new JSpinner();
		spnC_ShapeA.setFont(new Font("Arial", Font.BOLD, 12));
		spnC_ShapeA.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnC_ShapeA.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnC_ShapeA.setPreferredSize(new Dimension(80, 20));
		spnC_ShapeA.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		pnlC_ShapeA.add(spnC_ShapeA);

		JPanel pnlC_ShapeB = new JPanel();
		pnlExportAnalysis.add(pnlC_ShapeB);

		pnlC_ShapeB.setBackground(new Color(230, 230, 250));
		pnlC_ShapeB.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		spnC_ShapeB = new JSpinner();
		spnC_ShapeB.setFont(new Font("Arial", Font.BOLD, 12));
		spnC_ShapeB.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnC_ShapeB.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnC_ShapeB.setPreferredSize(new Dimension(80, 20));
		spnC_ShapeB.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		pnlC_ShapeB.add(spnC_ShapeB);

		JPanel pnlC_ShapeC = new JPanel();
		pnlExportAnalysis.add(pnlC_ShapeC);

		pnlC_ShapeC.setBackground(new Color(230, 230, 250));
		pnlC_ShapeC.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		spnC_ShapeC = new JSpinner();
		spnC_ShapeC.setFont(new Font("Arial", Font.BOLD, 12));
		spnC_ShapeC.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnC_ShapeC.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnC_ShapeC.setPreferredSize(new Dimension(80, 20));
		spnC_ShapeC.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		pnlC_ShapeC.add(spnC_ShapeC);


		JPanel pnlC_ShapeD = new JPanel();
		pnlExportAnalysis.add(pnlC_ShapeD);

		pnlC_ShapeD.setBackground(new Color(224, 255, 255));
		pnlC_ShapeD.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		spnC_ShapeD = new JSpinner();
		spnC_ShapeD.setFont(new Font("Arial", Font.BOLD, 12));
		spnC_ShapeD.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnC_ShapeD.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnC_ShapeD.setPreferredSize(new Dimension(80, 20));
		spnC_ShapeD.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		pnlC_ShapeD.add(spnC_ShapeD);


		JPanel pnlC_ShapeE = new JPanel();
		pnlExportAnalysis.add(pnlC_ShapeE);

		pnlC_ShapeE.setBackground(new Color(224, 255, 255));
		pnlC_ShapeE.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		spnC_ShapeE = new JSpinner();
		spnC_ShapeE.setFont(new Font("Arial", Font.BOLD, 12));
		spnC_ShapeE.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnC_ShapeE.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnC_ShapeE.setPreferredSize(new Dimension(80, 20));
		spnC_ShapeE.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		pnlC_ShapeE.add(spnC_ShapeE);

		JPanel pnlC_ShapeF = new JPanel();
		pnlExportAnalysis.add(pnlC_ShapeF);

		pnlC_ShapeF.setBackground(new Color(221, 160, 221));
		pnlC_ShapeF.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		spnC_ShapeF = new JSpinner();
		spnC_ShapeF.setFont(new Font("Arial", Font.BOLD, 12));
		spnC_ShapeF.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnC_ShapeF.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnC_ShapeF.setPreferredSize(new Dimension(80, 20));
		spnC_ShapeF.setModel(new SpinnerNumberModel(new Integer(0), new Integer(-1), null, new Integer(1)));
		pnlC_ShapeF.add(spnC_ShapeF);

		JPanel pnlbottomEmpty1 = new JPanel();
		pnlbottomEmpty1.setBackground(new Color(192, 192, 192));
		pnlExportAnalysis.add(pnlbottomEmpty1);

		JPanel pnlbottomEmpty2 = new JPanel();
		pnlbottomEmpty2.setBackground(new Color(192, 192, 192));
		pnlExportAnalysis.add(pnlbottomEmpty2);
		pnlbottomEmpty2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel pnlbottomEmpty3 = new JPanel();
		pnlbottomEmpty3.setBackground(new Color(192, 192, 192));
		pnlExportAnalysis.add(pnlbottomEmpty3);
		pnlbottomEmpty3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel pnlBottomSort = new JPanel();
		pnlBottomSort.setBackground(new Color(192, 192, 192));
		pnlExportAnalysis.add(pnlBottomSort);
		pnlBottomSort.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));

		JButton btnSortDetails = new JButton("Sort Details");
		btnSortDetails.setBackground(new Color(230, 230, 250));
		btnSortDetails.setFont(new Font("Arial", Font.PLAIN, 11));
		btnSortDetails.setContentAreaFilled(false);
		btnSortDetails.setOpaque(true);
		pnlBottomSort.add(btnSortDetails);
		btnSortDetails.setPreferredSize(new Dimension(100, 50));

		btnSortDetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Calendar sd = Calendar.getInstance();
				sd.set(2017, Calendar.APRIL, 30, 21, 00);
				Date start = sd.getTime();
				Calendar ed = Calendar.getInstance();
				ed.set(2017, Calendar.APRIL, 30, 22, 59);
				Date end = ed.getTime();
				MachineOutput output;
				CulcResults res;
				String sort = (String)cmbLastExportRes.getSelectedItem();
				if (cmbLastExportRes.getItemCount()!=0){	
					for (int i=0;i<sorts.size();++i){
						if (sort.equals(sorts.get(i).getSortDetails())){
							//output = new MachineOutput(sorts.get(i).getStartData(),sorts.get(i).getEndDate());
							if (sorts.get(i).getTotalProd()==0){
								output = new MachineOutput(start, end);
								output.fillDetailsDB();
								res = new CulcResults(output, sorts.get(i));
								res.fillDate();
								//System.out.println("statistics -- the Division is: " + Arrays.toString( sorts.get(i).getClassesOutcome()));
								//System.out.println("statistics -- the Division weight (kg) is: " + Arrays.toString( sorts.get(i).getClassOutcomeWeight()));
								JOptionPane.showMessageDialog(null, buildResult(getCurrentSort()), "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
							}
							else{
								JOptionPane.showMessageDialog(null, buildResult(getCurrentSort()), "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}
				}
			}
		});



		JPanel pnlBottomReset = new JPanel();
		pnlBottomReset.setBackground(new Color(192, 192, 192));
		pnlExportAnalysis.add(pnlBottomReset);
		pnlBottomReset.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));

		JButton btnDefaultData = new JButton("Default Data ");
		btnDefaultData.setBackground(new Color(230, 230, 250));
		pnlBottomReset.add(btnDefaultData);
		btnDefaultData.setFont(new Font("Arial", Font.PLAIN, 11));
		btnDefaultData.setPreferredSize(new Dimension(100, 50));
		btnDefaultData.setContentAreaFilled(false);
		btnDefaultData.setOpaque(true);
		btnDefaultData.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String sort = (String)cmbLastExportRes.getSelectedItem();
				getDataFromDB();
				if (cmbLastExportRes.getItemCount()!=0){	
					for (int i=0;i<sorts.size();++i){
						if (sort.equals(sorts.get(i).getSortDetails())){
							updateFields(sorts.get(i));
						}
					}
				}
			}
		});


		JPanel pnlBottomDefault = new JPanel();
		pnlBottomDefault.setBackground(new Color(192, 192, 192));
		pnlExportAnalysis.add(pnlBottomDefault);
		pnlBottomDefault.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel pnlbottomEmpty4 = new JPanel();
		pnlbottomEmpty4.setBackground(new Color(192, 192, 192));
		pnlExportAnalysis.add(pnlbottomEmpty4);

	}

	private void getDataFromDB() {
		SendServer get = new SendServer();
		if (sorts.size()!=0)
			sorts.clear();
		sorts = get.getSorts();
		cmbLastExportRes.removeAllItems();

		for (int i=0;i<sorts.size();++i){
			cmbLastExportRes.addItem(sorts.get(i).getSortDetails());
		}

	}

	private void getDataFromDB(Sorts sort) {
		SendServer get = new SendServer();
		if (sorts.size()!=0)
			sorts.clear();
		sorts = get.getSorts();
		cmbLastExportRes.removeAllItems();

		for (int i=0;i<sorts.size();++i){
			cmbLastExportRes.addItem(sorts.get(i).getSortDetails());
		}

		for (int i=0;i<sorts.size();++i){
			if (sorts.get(i).getSortDetails().equals(sort.getSortDetails()))
				cmbLastExportRes.setSelectedItem(sort.getSortDetails());
		}

	}

	private void updateFields(Sorts sort){
		for (ClassDetails cd: sort.getUserClassDetails()){
			switch(cd.getWhatClass()){
			case "A":
				if (sensA!=null)
					sensA.closeWindow();
				sensA = new SensitivityDetails(cd.getSensitivity(), "A");
				spnLengthFromA.setValue(cd.getLengthFrom());
				spnLengthToA.setValue(cd.getLengthTo());
				spnDiameterFromA.setValue(cd.getDiameterFrom());
				spnDiameterToA.setValue(cd.getDiameterTo());
				spnBrokenA.setValue(cd.getBroken());
				spnS_ShapeA.setValue(cd.getsShape());
				spnC_ShapeA.setValue(cd.getcShape());
				classASens = cd.getSensitivity();
				//System.out.println(cd.toString());
				break;
			case "B":
				if (sensB!=null)
					sensB.closeWindow();
				sensB = new SensitivityDetails(cd.getSensitivity(), "B");
				spnLengthFromB.setValue(cd.getLengthFrom());
				spnLengthToB.setValue(cd.getLengthTo());
				spnDiameterFromB.setValue(cd.getDiameterFrom());
				spnDiameterToB.setValue(cd.getDiameterTo());
				spnBrokenB.setValue(cd.getBroken());
				spnS_ShapeB.setValue(cd.getsShape());
				spnC_ShapeB.setValue(cd.getcShape());
				classBSens = cd.getSensitivity();
				break;
			case "C":
				if (sensC!=null)
					sensC.closeWindow();
				sensC = new SensitivityDetails(cd.getSensitivity(), "C");
				spnLengthFromC.setValue(cd.getLengthFrom());
				spnLengthToC.setValue(cd.getLengthTo());
				spnDiameterFromC.setValue(cd.getDiameterFrom());
				spnDiameterToC.setValue(cd.getDiameterTo());
				spnBrokenC.setValue(cd.getBroken());
				spnS_ShapeC.setValue(cd.getsShape());
				spnC_ShapeC.setValue(cd.getcShape());
				classCSens = cd.getSensitivity();
				break;
			case "D":
				if (sensD!=null)
					sensD.closeWindow();
				sensD = new SensitivityDetails(cd.getSensitivity(), "D");
				spnLengthFromD.setValue(cd.getLengthFrom());
				spnLengthToD.setValue(cd.getLengthTo());
				spnDiameterFromD.setValue(cd.getDiameterFrom());
				spnDiameterToD.setValue(cd.getDiameterTo());
				spnBrokenD.setValue(cd.getBroken());
				spnS_ShapeD.setValue(cd.getsShape());
				spnC_ShapeD.setValue(cd.getcShape());
				classDSens = cd.getSensitivity();
				break;
			case "E":
				if (sensE!=null)
					sensE.closeWindow();
				sensE = new SensitivityDetails(cd.getSensitivity(), "E");
				spnLengthFromE.setValue(cd.getLengthFrom());
				spnLengthToE.setValue(cd.getLengthTo());
				spnDiameterFromE.setValue(cd.getDiameterFrom());
				spnDiameterToE.setValue(cd.getDiameterTo());
				spnBrokenE.setValue(cd.getBroken());
				spnS_ShapeE.setValue(cd.getsShape());
				spnC_ShapeE.setValue(cd.getcShape());
				classESens = cd.getSensitivity();
				break;
			case "F":
				if (sensF!=null)
					sensF.closeWindow();
				sensF = new SensitivityDetails(cd.getSensitivity(), "F");
				spnLengthFromF.setValue(cd.getLengthFrom());
				spnLengthToF.setValue(cd.getLengthTo());
				spnDiameterFromF.setValue(cd.getDiameterFrom());
				spnDiameterToF.setValue(cd.getDiameterTo());
				spnBrokenF.setValue(cd.getBroken());
				spnS_ShapeF.setValue(cd.getsShape());
				spnC_ShapeF.setValue(cd.getcShape());
				classFSens = cd.getSensitivity();
				break;
			}
		}
	}

	private Sorts getCurrentSort(){
		if (sorts!=null){
			if (cmbLastExportRes.getItemCount()!=0){
				String sort = (String)cmbLastExportRes.getSelectedItem();
				for (int i=0;i<sorts.size();++i){
					if (sort.equals(sorts.get(i).getSortDetails())){
						return(sorts.get(i));
					}
				}
				return null;
			}	
			else{
				return null;
			}
		}
		return null;
	}

	private Sorts buildSort() {
		Sorts sort = new Sorts(getCurrentSort());
		List<ClassDetails> classes = new ArrayList<>();
		classes = orangeClasses();
		sort.setUserClassDetails(classes);

		//System.out.println(sort.toString());

		return sort;

	}

	private List<ClassDetails> orangeClasses(){
		List<ClassDetails> classes = new ArrayList<>();

		classes.add(new ClassDetails((Integer)spnLengthFromA.getValue(), (Integer)spnLengthToA.getValue(),
				(Integer)spnDiameterFromA.getValue(), (Integer)spnDiameterToA.getValue(), (Integer)spnBrokenA.getValue(),
				(Integer)spnC_ShapeA.getValue(), (Integer)spnS_ShapeA.getValue(), "A",sensA.getArr()));

		classes.add(new ClassDetails((Integer)spnLengthFromB.getValue(), (Integer)spnLengthToB.getValue(),
				(Integer)spnDiameterFromB.getValue(), (Integer)spnDiameterToB.getValue(), (Integer)spnBrokenB.getValue(),
				(Integer)spnC_ShapeB.getValue(), (Integer)spnS_ShapeB.getValue(), "B",sensB.getArr()));

		classes.add(new ClassDetails((Integer)spnLengthFromC.getValue(), (Integer)spnLengthToC.getValue(),
				(Integer)spnDiameterFromC.getValue(), (Integer)spnDiameterToC.getValue(), (Integer)spnBrokenC.getValue(),
				(Integer)spnC_ShapeC.getValue(), (Integer)spnS_ShapeC.getValue(), "C",sensC.getArr()));

		classes.add(new ClassDetails((Integer)spnLengthFromD.getValue(), (Integer)spnLengthToD.getValue(),
				(Integer)spnDiameterFromD.getValue(), (Integer)spnDiameterToD.getValue(), (Integer)spnBrokenD.getValue(),
				(Integer)spnC_ShapeD.getValue(), (Integer)spnS_ShapeD.getValue(), "D",sensD.getArr()));

		classes.add(new ClassDetails((Integer)spnLengthFromE.getValue(), (Integer)spnLengthToE.getValue(),
				(Integer)spnDiameterFromE.getValue(), (Integer)spnDiameterToE.getValue(), (Integer)spnBrokenE.getValue(),
				(Integer)spnC_ShapeE.getValue(), (Integer)spnS_ShapeE.getValue(), "E",sensE.getArr()));

		classes.add(new ClassDetails((Integer)spnLengthFromF.getValue(), (Integer)spnLengthToF.getValue(),
				(Integer)spnDiameterFromF.getValue(), (Integer)spnDiameterToF.getValue(), (Integer)spnBrokenF.getValue(),
				(Integer)spnC_ShapeF.getValue(), (Integer)spnS_ShapeF.getValue(), "F",sensF.getArr()));

		return classes;

	}

	private String buildResult(Sorts sort){

		String ans = "";
		ans+= String.format(" %25s ", "W"); 
		ans+= String.format(" %25s ", "A");
		ans+= String.format(" %25s ", "B");
		ans+= String.format(" %25s ", "C");
		ans+= String.format(" %25s ", "D");
		ans+= String.format(" %25s ", "E");
		ans+= String.format(" %25s ", "F\n");
		for (int i=0;i<sort.getClassesOutcome().length;++i){
			ans+=String.format(" %25d ", sort.getClassesOutcome()[i]);
		}
		ans+="\n";
		for (int i=0;i<sort.getClassOutcomeWeight().length;++i){
			ans+=String.format(" %25.2f ", sort.getClassOutcomeWeight()[i]);
		}


		return ans;
	}
}