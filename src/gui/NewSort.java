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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import Classes.ClassDetails;
import Classes.Growers;
import Classes.Plots;
import Classes.Sorts;
import Handlers.SendServer;

public class NewSort {
	
	private JFrame frmNewSort;
	private List<Growers> growers = new ArrayList<>();
	private JComboBox<String> cmbGrowers;
	private JComboBox<String> cmbChoosePlot;
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
	private JTextArea txtCommets;
	private JButton btnStartSort;
	private JButton btnEndSort;
	private JButton btnResert;
	private JButton btnBack;
	private Sorts sort;
	private int[] classASens = new int[4];
	private int[] classBSens = new int[4];
	private int[] classCSens = new int[4];
	private int[] classDSens = new int[4];
	private int[] classESens = new int[4];
	private int[] classFSens = new int[4];
	private SensitivityDetails sensA = null;
	private SensitivityDetails sensB = null;
	private SensitivityDetails sensC = null;
	private SensitivityDetails sensD = null;
	private SensitivityDetails sensE = null;
	private SensitivityDetails sensF = null;
	private JButton btnClassA;
	private JButton btnClassB;
	private JButton btnClassC;
	private JButton btnClassD;
	private JButton btnClassE;
	private JButton btnClassF;
	

	/**
	 * Create the application.
	 */
	public NewSort() {
		initialize();
		getDataFromDB();
		frmNewSort.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewSort = new JFrame("New Sort");
		frmNewSort.setBounds(100, 100, 1617, 876);
		frmNewSort.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmNewSort.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmNewSort.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel pnlHeaderWindow = new JPanel();
		pnlHeaderWindow.setBackground(Color.WHITE);
		FlowLayout fl_pnlHeaderWindow = (FlowLayout) pnlHeaderWindow.getLayout();
		fl_pnlHeaderWindow.setVgap(50);
		frmNewSort.getContentPane().add(pnlHeaderWindow, BorderLayout.NORTH);

		JLabel lblNewSort = new JLabel("New Sort Details");
		lblNewSort.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 47));
		pnlHeaderWindow.add(lblNewSort);

		JPanel pnLeft = new JPanel();
		pnLeft.setPreferredSize(new Dimension(600, 10));
		frmNewSort.getContentPane().add(pnLeft, BorderLayout.WEST);
		pnLeft.setLayout(new BorderLayout(0, 0));

		JPanel pnlLblChooseGrower = new JPanel();
		FlowLayout fl_pnlLblChooseGrower = (FlowLayout) pnlLblChooseGrower.getLayout();
		fl_pnlLblChooseGrower.setVgap(20);
		pnLeft.add(pnlLblChooseGrower, BorderLayout.NORTH);

		JLabel lblChooseGrower = new JLabel("Choose Grower");
		lblChooseGrower.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		pnlLblChooseGrower.add(lblChooseGrower);

		///////////////



		JPanel pnlGrowerDetails = new JPanel();
		pnLeft.add(pnlGrowerDetails, BorderLayout.CENTER);
		pnlGrowerDetails.setLayout(new FormLayout(new ColumnSpec[] {
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
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
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
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
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
						RowSpec.decode("default:grow"),
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

		JLabel lblChooseWhatGrower = new JLabel("Choose A Grower");
		lblChooseWhatGrower.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseWhatGrower.setFont(new Font("Arial", Font.BOLD, 15));
		lblChooseWhatGrower.setPreferredSize(new Dimension(200, 25));
		pnlGrowerDetails.add(lblChooseWhatGrower, "1, 4, 32, 1, center, default");

		cmbGrowers = new JComboBox<String>();
		pnlGrowerDetails.add(cmbGrowers, "4, 8, 27, 1, fill, default");
		cmbGrowers.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cmbGrowers.getItemCount()!=0){
					String grower = (String)cmbGrowers.getSelectedItem();
					String growerId = grower.substring(grower.lastIndexOf("ID: ")+4, grower.indexOf("  Name: ")).trim();
					for (int i=0;i<growers.size();++i){
						if (growerId.equals(growers.get(i).getgID())){
							updatePlotCmb(growers.get(i));
						}
					}

				}
			}
		});

		JLabel lblChoosePlot = new JLabel("Choose A Plot");
		lblChoosePlot.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoosePlot.setFont(new Font("Arial", Font.BOLD, 15));
		pnlGrowerDetails.add(lblChoosePlot, "2, 13, 31, 3");

		cmbChoosePlot = new JComboBox<String>();
		pnlGrowerDetails.add(cmbChoosePlot, "4, 18, 27, 1, fill, default");

		JLabel lblEnterComments = new JLabel("Comments");
		lblEnterComments.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterComments.setFont(new Font("Arial", Font.BOLD, 15));
		pnlGrowerDetails.add(lblEnterComments, "2, 24, 31, 1");

		txtCommets = new JTextArea();
		txtCommets.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCommets.setBackground(UIManager.getColor("TextField.light"));
		pnlGrowerDetails.add(txtCommets, "4, 28, 27, 7, fill, fill");

		btnEndSort = new JButton("End Sort");
		btnEndSort.setPreferredSize(new Dimension(100, 50));
		pnlGrowerDetails.add(btnEndSort, "18, 38");

		btnEndSort.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SendServer send = new SendServer();
				if (sort!= null){
					sort.setEndDate(new Date());
					if (send.insert(sort)){
						sort=null;
						JOptionPane.showMessageDialog(null, "Sort Saved!", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
						setFieldsEnable(true);
						txtCommets.setText("");
						resetAllFields();
					}
					else{
						JOptionPane.showMessageDialog(null, "***server problem*** Sort Hasnt been saved!", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
					}

				}
				else
					JOptionPane.showMessageDialog(null, "First Start Sort ! ", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
			}
		});




		btnStartSort = new JButton("Start Sort");
		btnStartSort.setPreferredSize(new Dimension(100, 50));
		pnlGrowerDetails.add(btnStartSort, "22, 38");

		btnStartSort.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!checkFileds()){
					JOptionPane.showMessageDialog(null, "    To Start a New Sort\nAll Fields Must Not Be -1 ", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					if (sensA==null)
						sensA = new SensitivityDetails(false);
					if (sensB==null)
						sensB = new SensitivityDetails(false);
					if (sensC==null)
						sensC = new SensitivityDetails(false);
					if (sensD==null)
						sensD = new SensitivityDetails(false);
					if (sensE==null)
						sensE = new SensitivityDetails(false);
					if (sensF==null)
						sensF = new SensitivityDetails(false);
					buildSort();
					setFieldsEnable(false);

					}


			}

		});

		btnBack = new JButton("Back");
		btnBack.setPreferredSize(new Dimension(100, 50));
		pnlGrowerDetails.add(btnBack, "26, 38");
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MainMenuWindow();
				frmNewSort.dispose();
			}
		});

		btnResert = new JButton("Reset");
		pnlGrowerDetails.add(btnResert, "30, 38");
		btnResert.setPreferredSize(new Dimension(100, 50));
		btnResert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resetAllFields();
			}

		});


		JPanel pnlRight = new JPanel();
		frmNewSort.getContentPane().add(pnlRight, BorderLayout.CENTER);
		pnlRight.setLayout(new BorderLayout(0, 0));

		JPanel pnlLblSortInput = new JPanel();
		FlowLayout fl_pnlLblSortInput = (FlowLayout) pnlLblSortInput.getLayout();
		fl_pnlLblSortInput.setVgap(20);
		pnlRight.add(pnlLblSortInput, BorderLayout.NORTH);

		JLabel lblSortDetails = new JLabel("Sort By..");
		lblSortDetails.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		pnlLblSortInput.add(lblSortDetails);

		JPanel pnlSortData = new JPanel();
		pnlRight.add(pnlSortData, BorderLayout.CENTER);


		////////////////////////////////////////////////////////////////
		pnlSortData.setLayout(new GridLayout(7, 7, 3, 3));

		/////////////// class types /////////////////////////////

		JLabel lblInput = new JLabel("Input");
		lblInput.setForeground(new Color(165, 42, 42));
		lblInput.setFont(new Font("Arial", Font.BOLD, 18));
		lblInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblInput.setBackground(new Color(0, 51, 102));
		pnlSortData.add(lblInput);
		
		btnClassA = new JButton("Class A");
		btnClassA.setFont(new Font("Arial", Font.BOLD, 15));
		pnlSortData.add(btnClassA);
		
		btnClassA.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sensA==null)
					sensA = new SensitivityDetails();
				else
					sensA.setVisible(true);
				
			}
		});
		
		btnClassB = new JButton("Class B");
		btnClassB.setFont(new Font("Arial", Font.BOLD, 15));
		pnlSortData.add(btnClassB);
		
		btnClassB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sensB == null)
					sensB = new SensitivityDetails();
				else
					sensB.setVisible(true);
				
			}
		});
		
		btnClassC = new JButton("Class C");
		btnClassC.setFont(new Font("Arial", Font.BOLD, 15));
		pnlSortData.add(btnClassC);
		
		btnClassC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sensC == null)
					sensC = new SensitivityDetails();
				else
					sensC.setVisible(true);
				
			}
		});
		
		btnClassD = new JButton("Class D");
		btnClassD.setFont(new Font("Arial", Font.BOLD, 15));
		pnlSortData.add(btnClassD);
		
		btnClassD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sensD == null)
					sensD = new SensitivityDetails();
				else
					sensD.setVisible(true);
				
			}
		});
		
		btnClassE = new JButton("Class E");
		btnClassE.setFont(new Font("Arial", Font.BOLD, 15));
		pnlSortData.add(btnClassE);
		
		btnClassE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sensE == null)
					sensE = new SensitivityDetails();
				else
					sensE.setVisible(true);
				
			}
		});
		
		btnClassF = new JButton("Class F");
		btnClassF.setFont(new Font("Arial", Font.BOLD, 15));
		pnlSortData.add(btnClassF);
		
		btnClassF.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sensF == null)
					sensF = new SensitivityDetails();
				else
					sensF.setVisible(true);
				
			}
		});

		JLabel lblLength = new JLabel("Length");
		lblLength.setFont(new Font("Arial", Font.BOLD, 15));
		lblLength.setHorizontalAlignment(SwingConstants.CENTER);
		lblLength.setBackground(new Color(0, 51, 102));
		pnlSortData.add(lblLength);

		JPanel pnlLengthA = new JPanel();
		pnlLengthA.setBackground(new Color(230, 230, 250));
		pnlSortData.add(pnlLengthA);
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
		spnLengthFromA.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
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
		spnLengthToA.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
		GridBagConstraints gbc_spnLengthToA = new GridBagConstraints();
		gbc_spnLengthToA.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnLengthToA.gridwidth = 2;
		gbc_spnLengthToA.gridx = 1;
		gbc_spnLengthToA.gridy = 2;
		pnlLengthA.add(spnLengthToA, gbc_spnLengthToA);

		JPanel pnlLengthB = new JPanel();
		pnlLengthB.setBackground(new Color(230, 230, 250));
		pnlSortData.add(pnlLengthB);
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
		spnLengthFromB.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
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
		spnLengthToB.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
		GridBagConstraints gbc_spnLengthToB = new GridBagConstraints();
		gbc_spnLengthToB.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnLengthToB.gridwidth = 2;
		gbc_spnLengthToB.gridx = 1;
		gbc_spnLengthToB.gridy = 2;
		pnlLengthB.add(spnLengthToB, gbc_spnLengthToB);

		JPanel pnlLengthC = new JPanel();
		pnlLengthC.setBackground(new Color(230, 230, 250));
		pnlSortData.add(pnlLengthC);
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
		spnLengthFromC.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
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
		spnLengthToC.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
		GridBagConstraints gbc_spnLengthToC = new GridBagConstraints();
		gbc_spnLengthToC.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnLengthToC.gridwidth = 2;
		gbc_spnLengthToC.gridx = 1;
		gbc_spnLengthToC.gridy = 2;
		pnlLengthC.add(spnLengthToC, gbc_spnLengthToC);

		JPanel pnlLengthD = new JPanel();
		pnlLengthD.setBackground(new Color(224, 255, 255));
		pnlSortData.add(pnlLengthD);
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
		spnLengthFromD.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
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
		spnLengthToD.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
		GridBagConstraints gbc_spnLengthToD = new GridBagConstraints();
		gbc_spnLengthToD.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnLengthToD.gridwidth = 2;
		gbc_spnLengthToD.gridx = 1;
		gbc_spnLengthToD.gridy = 2;
		pnlLengthD.add(spnLengthToD, gbc_spnLengthToD);

		JPanel pnlLengthE = new JPanel();
		pnlLengthE.setBackground(new Color(224, 255, 255));
		pnlSortData.add(pnlLengthE);
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
		spnLengthFromE.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
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
		spnLengthToE.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
		GridBagConstraints gbc_spnLengthToE = new GridBagConstraints();
		gbc_spnLengthToE.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnLengthToE.gridwidth = 2;
		gbc_spnLengthToE.gridx = 1;
		gbc_spnLengthToE.gridy = 2;
		pnlLengthE.add(spnLengthToE, gbc_spnLengthToE);

		JPanel pnlLengthF = new JPanel();
		pnlLengthF.setBackground(new Color(221, 160, 221));
		pnlSortData.add(pnlLengthF);
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
		spnLengthFromF.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
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
		spnLengthToF.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
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
		pnlSortData.add(lblDiameter);

		JPanel pnlDiameterA = new JPanel();
		pnlDiameterA.setBackground(new Color(230, 230, 250));
		pnlSortData.add(pnlDiameterA);
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
		spnDiameterFromA.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
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
		spnDiameterToA.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
		GridBagConstraints gbc_spnDiameterToA = new GridBagConstraints();
		gbc_spnDiameterToA.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnDiameterToA.gridwidth = 2;
		gbc_spnDiameterToA.gridx = 1;
		gbc_spnDiameterToA.gridy = 2;
		pnlDiameterA.add(spnDiameterToA, gbc_spnDiameterToA);

		JPanel pnlDiameterB = new JPanel();
		pnlDiameterB.setBackground(new Color(230, 230, 250));
		pnlSortData.add(pnlDiameterB);
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
		spnDiameterFromB.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
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
		spnDiameterToB.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
		GridBagConstraints gbc_spnDiameterToB = new GridBagConstraints();
		gbc_spnDiameterToB.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnDiameterToB.gridwidth = 2;
		gbc_spnDiameterToB.gridx = 1;
		gbc_spnDiameterToB.gridy = 2;
		pnlDiameterB.add(spnDiameterToB, gbc_spnDiameterToB);

		JPanel pnlDiameterC = new JPanel();
		pnlDiameterC.setBackground(new Color(230, 230, 250));
		pnlSortData.add(pnlDiameterC);
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
		spnDiameterFromC.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
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
		spnDiameterToC.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
		GridBagConstraints gbc_spnDiameterToC = new GridBagConstraints();
		gbc_spnDiameterToC.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnDiameterToC.gridwidth = 2;
		gbc_spnDiameterToC.gridx = 1;
		gbc_spnDiameterToC.gridy = 2;
		pnlDiameterC.add(spnDiameterToC, gbc_spnDiameterToC);

		JPanel pnlDiameterD = new JPanel();
		pnlDiameterD.setBackground(new Color(224, 255, 255));
		pnlSortData.add(pnlDiameterD);
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
		spnDiameterFromD.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
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
		spnDiameterToD.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
		GridBagConstraints gbc_spnDiameterToD = new GridBagConstraints();
		gbc_spnDiameterToD.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnDiameterToD.gridwidth = 2;
		gbc_spnDiameterToD.gridx = 1;
		gbc_spnDiameterToD.gridy = 2;
		pnlDiameterD.add(spnDiameterToD, gbc_spnDiameterToD);

		JPanel pnlDiameterE = new JPanel();
		pnlDiameterE.setBackground(new Color(224, 255, 255));
		pnlSortData.add(pnlDiameterE);
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
		spnDiameterFromE.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
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
		spnDiameterToE.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
		GridBagConstraints gbc_spnDiameterToE = new GridBagConstraints();
		gbc_spnDiameterToE.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnDiameterToE.gridwidth = 2;
		gbc_spnDiameterToE.gridx = 1;
		gbc_spnDiameterToE.gridy = 2;
		pnlDiameterE.add(spnDiameterToE, gbc_spnDiameterToE);

		JPanel pnlDiameterF = new JPanel();
		pnlDiameterF.setBackground(new Color(221, 160, 221));
		pnlSortData.add(pnlDiameterF);
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
		spnDiameterFromF.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
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
		spnDiameterToF.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
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
		pnlSortData.add(lblBroken);

		JPanel pnlBrokenA = new JPanel();
		pnlSortData.add(pnlBrokenA);

		pnlBrokenA.setBackground(new Color(230, 230, 250));
		FlowLayout _pnlBrokenA = (FlowLayout) pnlBrokenA.getLayout();
		_pnlBrokenA.setVgap(25);

		spnBrokenA = new JSpinner();
		spnBrokenA.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenA.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenA.setPreferredSize(new Dimension(80, 35));
		spnBrokenA.setModel(new SpinnerNumberModel(-1, -1, 100, 1));
		pnlBrokenA.add(spnBrokenA);



		JPanel pnlBrokenB = new JPanel();
		pnlSortData.add(pnlBrokenB);

		pnlBrokenB.setBackground(new Color(230, 230, 250));
		FlowLayout _pnlBrokenB = (FlowLayout) pnlBrokenB.getLayout();
		_pnlBrokenB.setVgap(25);

		spnBrokenB = new JSpinner();
		spnBrokenB.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenB.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenB.setPreferredSize(new Dimension(80, 35));
		spnBrokenB.setModel(new SpinnerNumberModel(-1, -1, 100, 1));
		pnlBrokenB.add(spnBrokenB);

		JPanel pnlBrokenC = new JPanel();
		pnlSortData.add(pnlBrokenC);

		pnlBrokenC.setBackground(new Color(230, 230, 250));
		FlowLayout _pnlBrokenC = (FlowLayout) pnlBrokenC.getLayout();
		_pnlBrokenC.setVgap(25);

		spnBrokenC = new JSpinner();
		spnBrokenC.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenC.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenC.setPreferredSize(new Dimension(80, 35));
		spnBrokenC.setModel(new SpinnerNumberModel(-1, -1, 100, 1));
		pnlBrokenC.add(spnBrokenC);

		JPanel pnlBrokenE = new JPanel();
		pnlSortData.add(pnlBrokenE);

		pnlBrokenE.setBackground(new Color(224, 255, 255));
		FlowLayout _pnlBrokenE = (FlowLayout) pnlBrokenE.getLayout();
		_pnlBrokenE.setVgap(25);

		spnBrokenD = new JSpinner();
		spnBrokenD.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenD.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenD.setPreferredSize(new Dimension(80, 35));
		spnBrokenD.setModel(new SpinnerNumberModel(-1, -1, 100, 1));
		pnlBrokenE.add(spnBrokenD);


		JPanel pnlBrokenF = new JPanel();
		pnlSortData.add(pnlBrokenF);

		pnlBrokenF.setBackground(new Color(224, 255, 255));
		FlowLayout _pnlBrokenF = (FlowLayout) pnlBrokenF.getLayout();
		_pnlBrokenF.setVgap(25);

		spnBrokenE = new JSpinner();
		spnBrokenE.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenE.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenE.setPreferredSize(new Dimension(80, 35));
		spnBrokenE.setModel(new SpinnerNumberModel(-1, -1, 100, 1));
		pnlBrokenF.add(spnBrokenE);

		JPanel pnlBrokenF1 = new JPanel();
		FlowLayout fl_pnlBrokenF1 = (FlowLayout) pnlBrokenF1.getLayout();
		fl_pnlBrokenF1.setVgap(25);
		pnlBrokenF1.setBackground(new Color(221, 160, 221));
		pnlSortData.add(pnlBrokenF1);

		spnBrokenF = new JSpinner();
		spnBrokenF.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnBrokenF.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnBrokenF.setPreferredSize(new Dimension(80, 35));
		spnBrokenF.setModel(new SpinnerNumberModel(-1, -1, 100, 1));
		pnlBrokenF1.add(spnBrokenF);



		JLabel lblS_Shape = new JLabel("S Shape");
		lblS_Shape.setFont(new Font("Arial", Font.BOLD, 15));
		lblS_Shape.setHorizontalAlignment(SwingConstants.CENTER);
		lblS_Shape.setBackground(Color.WHITE);
		pnlSortData.add(lblS_Shape);


		JPanel pnlS_ShapeA = new JPanel();
		pnlSortData.add(pnlS_ShapeA);

		pnlS_ShapeA.setBackground(new Color(230, 230, 250));
		FlowLayout _pnlS_ShapeA = (FlowLayout) pnlS_ShapeA.getLayout();
		_pnlS_ShapeA.setVgap(25);

		spnS_ShapeA = new JSpinner();
		spnS_ShapeA.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeA.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeA.setPreferredSize(new Dimension(80, 35));
		spnS_ShapeA.setModel(new SpinnerNumberModel(-1, -1, 100, 1));
		pnlS_ShapeA.add(spnS_ShapeA);

		JPanel pnlS_ShapeB = new JPanel();
		pnlSortData.add(pnlS_ShapeB);

		pnlS_ShapeB.setBackground(new Color(230, 230, 250));
		FlowLayout _pnlS_ShapeB = (FlowLayout) pnlS_ShapeB.getLayout();
		_pnlS_ShapeB.setVgap(25);

		spnS_ShapeB = new JSpinner();
		spnS_ShapeB.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeB.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeB.setPreferredSize(new Dimension(80, 35));
		spnS_ShapeB.setModel(new SpinnerNumberModel(-1, -1, 100, 1));
		pnlS_ShapeB.add(spnS_ShapeB);

		JPanel pnlS_ShapeC = new JPanel();
		pnlSortData.add(pnlS_ShapeC);

		pnlS_ShapeC.setBackground(new Color(230, 230, 250));
		FlowLayout _pnlS_ShapeC = (FlowLayout) pnlS_ShapeC.getLayout();
		_pnlS_ShapeC.setVgap(25);

		spnS_ShapeC = new JSpinner();
		spnS_ShapeC.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeC.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeC.setPreferredSize(new Dimension(80, 35));
		spnS_ShapeC.setModel(new SpinnerNumberModel(-1, -1, 100, 1));
		pnlS_ShapeC.add(spnS_ShapeC);

		JPanel pnlS_ShapeD = new JPanel();
		pnlSortData.add(pnlS_ShapeD);

		pnlS_ShapeD.setBackground(new Color(224, 255, 255));
		FlowLayout _pnlS_ShapeD = (FlowLayout) pnlS_ShapeD.getLayout();
		_pnlS_ShapeD.setVgap(25);;

		spnS_ShapeD = new JSpinner();
		spnS_ShapeD.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeD.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeD.setPreferredSize(new Dimension(80, 35));
		spnS_ShapeD.setModel(new SpinnerNumberModel(-1, -1, 100, 1));
		pnlS_ShapeD.add(spnS_ShapeD);

		JPanel pnlS_ShapeE = new JPanel();
		pnlSortData.add(pnlS_ShapeE);

		pnlS_ShapeE.setBackground(new Color(224, 255, 255));
		FlowLayout _pnlS_ShapeE = (FlowLayout) pnlS_ShapeE.getLayout();
		_pnlS_ShapeE.setVgap(25);

		spnS_ShapeE = new JSpinner();
		spnS_ShapeE.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeE.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeE.setPreferredSize(new Dimension(80, 35));
		spnS_ShapeE.setModel(new SpinnerNumberModel(-1, -1, 100, 1));
		pnlS_ShapeE.add(spnS_ShapeE);


		JPanel pnlS_ShapeF = new JPanel();
		pnlSortData.add(pnlS_ShapeF);

		pnlS_ShapeF.setBackground(new Color(221, 160, 221));
		FlowLayout _pnlS_ShapeF = (FlowLayout) pnlS_ShapeF.getLayout();
		_pnlS_ShapeF.setVgap(25);

		spnS_ShapeF = new JSpinner();
		spnS_ShapeF.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnS_ShapeF.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnS_ShapeF.setPreferredSize(new Dimension(80, 35));
		spnS_ShapeF.setModel(new SpinnerNumberModel(-1,-1, 100, 1));
		pnlS_ShapeF.add(spnS_ShapeF);

		JLabel lblC_Shape = new JLabel("C Shape");
		lblC_Shape.setFont(new Font("Arial", Font.BOLD, 15));
		lblC_Shape.setHorizontalAlignment(SwingConstants.CENTER);
		lblC_Shape.setBackground(Color.WHITE);
		pnlSortData.add(lblC_Shape);

		JPanel pnlC_ShapeA = new JPanel();
		pnlSortData.add(pnlC_ShapeA);

		pnlC_ShapeA.setBackground(new Color(230, 230, 250));
		pnlC_ShapeA.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 25));

		spnC_ShapeA = new JSpinner();
		spnC_ShapeA.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnC_ShapeA.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnC_ShapeA.setPreferredSize(new Dimension(80, 35));
		spnC_ShapeA.setModel(new SpinnerNumberModel(-1,-1, 100, 1));
		pnlC_ShapeA.add(spnC_ShapeA);

		JPanel pnlC_ShapeB = new JPanel();
		pnlSortData.add(pnlC_ShapeB);

		pnlC_ShapeB.setBackground(new Color(230, 230, 250));
		pnlC_ShapeB.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 25));

		spnC_ShapeB = new JSpinner();
		spnC_ShapeB.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnC_ShapeB.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnC_ShapeB.setPreferredSize(new Dimension(80, 35));
		spnC_ShapeB.setModel(new SpinnerNumberModel(-1, -1, 100, 1));
		pnlC_ShapeB.add(spnC_ShapeB);

		JPanel pnlC_ShapeC = new JPanel();
		pnlSortData.add(pnlC_ShapeC);

		pnlC_ShapeC.setBackground(new Color(230, 230, 250));
		pnlC_ShapeC.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 25));

		spnC_ShapeC = new JSpinner();
		spnC_ShapeC.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnC_ShapeC.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnC_ShapeC.setPreferredSize(new Dimension(80, 35));
		spnC_ShapeC.setModel(new SpinnerNumberModel(-1, -1, 100, 1));
		pnlC_ShapeC.add(spnC_ShapeC);


		JPanel pnlC_ShapeD = new JPanel();
		pnlSortData.add(pnlC_ShapeD);

		pnlC_ShapeD.setBackground(new Color(224, 255, 255));
		pnlC_ShapeD.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 25));

		spnC_ShapeD = new JSpinner();
		spnC_ShapeD.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnC_ShapeD.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnC_ShapeD.setPreferredSize(new Dimension(80, 35));
		spnC_ShapeD.setModel(new SpinnerNumberModel(-1, -1, 100, 1));
		pnlC_ShapeD.add(spnC_ShapeD);


		JPanel pnlC_ShapeE = new JPanel();
		pnlSortData.add(pnlC_ShapeE);

		pnlC_ShapeE.setBackground(new Color(224, 255, 255));
		pnlC_ShapeE.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 25));

		spnC_ShapeE = new JSpinner();
		spnC_ShapeE.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnC_ShapeE.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnC_ShapeE.setPreferredSize(new Dimension(80, 35));
		spnC_ShapeE.setModel(new SpinnerNumberModel(-1, -1, 100, 1));
		pnlC_ShapeE.add(spnC_ShapeE);

		JPanel pnlC_ShapeF = new JPanel();
		pnlSortData.add(pnlC_ShapeF);

		pnlC_ShapeF.setBackground(new Color(221, 160, 221));
		pnlC_ShapeF.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 25));

		spnC_ShapeF = new JSpinner();
		spnC_ShapeF.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spnC_ShapeF.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spnC_ShapeF.setPreferredSize(new Dimension(80, 35));
		spnC_ShapeF.setModel(new SpinnerNumberModel(-1, -1, 100, 1));
		pnlC_ShapeF.add(spnC_ShapeF);

		JPanel pnlbottomEmpty1 = new JPanel();
		pnlSortData.add(pnlbottomEmpty1);

		JPanel pnlbottomEmpty2 = new JPanel();
		pnlSortData.add(pnlbottomEmpty2);
		pnlbottomEmpty2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel pnlbottomEmpty3 = new JPanel();
		pnlSortData.add(pnlbottomEmpty3);
		pnlbottomEmpty3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel pnlBottomReset = new JPanel();
		pnlSortData.add(pnlBottomReset);
		pnlBottomReset.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel pnlBottomEmpty4 = new JPanel();
		pnlSortData.add(pnlBottomEmpty4);
		pnlBottomEmpty4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel pnlBottomEmpty5 = new JPanel();
		pnlSortData.add(pnlBottomEmpty5);
		pnlBottomEmpty5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel pnlbottomEmpty6 = new JPanel();
		pnlSortData.add(pnlbottomEmpty6);

		frmNewSort.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(frmNewSort, "Are you sure to close this window?", "Really Closing?", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
					if (sort!= null){
						SendServer send = new SendServer();
						sort.setEndDate(new Date());
						if (send.insert(sort)){
							JOptionPane.showMessageDialog(null, "**Sort Saved!** ", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
							System.exit(0);
						}
						else
							JOptionPane.showMessageDialog(null, "**Sort Hasent Been Saved!** ", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
					}
					else
						System.exit(0);
				}
			}
		});
	

	}

	private void updatePlotCmb(Growers grower){
		cmbChoosePlot.removeAllItems();
		for (Plots p : grower.getPlots()){
			cmbChoosePlot.addItem(p.toString());
		}
	}


	private void getDataFromDB(){

		SendServer get = new SendServer();
		if (growers.size()!=0)
			growers.clear();
		growers = get.getGrowers();
		cmbGrowers.removeAllItems();

		for (int i=0;i<growers.size();++i){
			cmbGrowers.addItem(growers.get(i).getGrowerDet());
		}
		updatePlotCmb(growers.get(0));
	}


	private void resetAllFields() {
		spnLengthFromA.setValue(-1);
		spnLengthFromB.setValue(-1);
		spnLengthFromC.setValue(-1);
		spnLengthFromD.setValue(-1);
		spnLengthFromE.setValue(-1);
		spnLengthFromF.setValue(-1);
		spnLengthToA.setValue(-1);
		spnLengthToB.setValue(-1);
		spnLengthToC.setValue(-1);
		spnLengthToD.setValue(-1);
		spnLengthToE.setValue(-1);
		spnLengthToF.setValue(-1);
		spnDiameterFromA.setValue(-1);
		spnDiameterFromB.setValue(-1);
		spnDiameterFromC.setValue(-1);
		spnDiameterFromD.setValue(-1);
		spnDiameterFromE.setValue(-1);
		spnDiameterFromF.setValue(-1);
		spnDiameterToA.setValue(-1);
		spnDiameterToB.setValue(-1);
		spnDiameterToC.setValue(-1);
		spnDiameterToD.setValue(-1);
		spnDiameterToE.setValue(-1);
		spnDiameterToF.setValue(-1);
		spnBrokenA.setValue(-1);
		spnBrokenB.setValue(-1);
		spnBrokenC.setValue(-1);
		spnBrokenD.setValue(-1);
		spnBrokenE.setValue(-1);
		spnBrokenF.setValue(-1);
		spnS_ShapeA.setValue(-1);
		spnS_ShapeB.setValue(-1);
		spnS_ShapeC.setValue(-1);
		spnS_ShapeD.setValue(-1);
		spnS_ShapeE.setValue(-1);
		spnS_ShapeF.setValue(-1);
		spnC_ShapeA.setValue(-1);
		spnC_ShapeB.setValue(-1);
		spnC_ShapeC.setValue(-1);
		spnC_ShapeD.setValue(-1);
		spnC_ShapeE.setValue(-1);
		spnC_ShapeF.setValue(-1);

	}

	private boolean checkFileds() {
		if ((Integer)spnLengthFromA.getValue()==-1)
			return false;
		if ((Integer)spnLengthFromB.getValue()==-1)
			return false;
		if ((Integer)spnLengthFromC.getValue()==-1)
			return false;
		if ((Integer)spnLengthFromD.getValue()==-1)
			return false;
		if ((Integer)spnLengthFromE.getValue()==-1)
			return false;
		if ((Integer)spnLengthFromF.getValue()==-1)
			return false;
		if ((Integer)spnLengthToA.getValue()==-1)
			return false;
		if ((Integer)spnLengthToB.getValue()==-1)
			return false;
		if ((Integer)spnLengthToC.getValue()==-1)
			return false;
		if ((Integer)spnLengthToD.getValue()==-1)
			return false;
		if ((Integer)spnLengthToE.getValue()==-1)
			return false;
		if ((Integer)spnLengthToF.getValue()==-1)
			return false;
		if ((Integer)spnDiameterFromA.getValue()==-1)
			return false;
		if ((Integer)spnDiameterFromB.getValue()==-1)
			return false;
		if ((Integer)spnDiameterFromC.getValue()==-1)
			return false;
		if ((Integer)spnDiameterFromD.getValue()==-1)
			return false;
		if ((Integer)spnDiameterFromE.getValue()==-1)
			return false;
		if ((Integer)spnDiameterFromF.getValue()==-1)
			return false;
		if ((Integer)spnDiameterToA.getValue()==-1)
			return false;
		if ((Integer)spnDiameterToB.getValue()==-1)
			return false;
		if ((Integer)spnDiameterToC.getValue()==-1)
			return false;
		if ((Integer)spnDiameterToD.getValue()==-1)
			return false;
		if ((Integer)spnDiameterToE.getValue()==-1)
			return false;
		if ((Integer)spnDiameterToF.getValue()==-1)
			return false;
		if ((Integer)spnBrokenA.getValue()==-1)
			return false;
		if ((Integer)spnBrokenB.getValue()==-1)
			return false;
		if ((Integer)spnBrokenC.getValue()==-1)
			return false;
		if ((Integer)spnBrokenD.getValue()==-1)
			return false;
		if ((Integer)spnBrokenE.getValue()==-1)
			return false;
		if ((Integer)spnBrokenF.getValue()==-1)
			return false;
		if ((Integer)spnS_ShapeA.getValue()==-1)
			return false;
		if ((Integer)spnS_ShapeB.getValue()==-1)
			return false;
		if ((Integer)spnS_ShapeC.getValue()==-1)
			return false;
		if ((Integer)spnS_ShapeD.getValue()==-1)
			return false;
		if ((Integer)spnS_ShapeE.getValue()==-1)
			return false;
		if ((Integer)spnS_ShapeF.getValue()==-1)
			return false;
		if ((Integer)spnC_ShapeA.getValue()==-1)
			return false;
		if ((Integer)spnC_ShapeB.getValue()==-1)
			return false;
		if ((Integer)spnC_ShapeC.getValue()==-1)
			return false;
		if ((Integer)spnC_ShapeD.getValue()==-1)
			return false;
		if ((Integer)spnC_ShapeE.getValue()==-1)
			return false;
		if ((Integer)spnC_ShapeF.getValue()==-1)
			return false;
		return true;
	}


	private void buildSort() {
		sort = new Sorts();
		List<ClassDetails> classes = new ArrayList<>();
		String grower = (String)cmbGrowers.getSelectedItem();
		String growerId = grower.substring(grower.lastIndexOf("ID: ")+4, grower.indexOf("  Name: ")).trim();
		for (int i=0;i<growers.size();++i){
			if (growerId.equals(growers.get(i).getgID())){
				sort.setGrower(growers.get(i));
			}
		}

		String plot = (String)cmbChoosePlot.getSelectedItem();
		for (Plots p:sort.getGrower().getPlots())
		{
			if (plot != null)
			{
				if (plot.equals(p.toString()))
				{
					sort.setPlot(p);
				}
			}
		}

		sort.setComments(txtCommets.getText().trim());
		classes = orangeClasses();
		sort.setUserClassDetails(classes);

		//System.out.println(sort.toString());



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

	private void setFieldsEnable(boolean enable) {
		spnLengthFromA.setEnabled(enable);
		spnLengthFromB.setEnabled(enable);
		spnLengthFromC.setEnabled(enable);
		spnLengthFromD.setEnabled(enable);
		spnLengthFromE.setEnabled(enable);
		spnLengthFromF.setEnabled(enable);
		spnLengthToA.setEnabled(enable);
		spnLengthToB.setEnabled(enable);
		spnLengthToC.setEnabled(enable);
		spnLengthToD.setEnabled(enable);
		spnLengthToE.setEnabled(enable);
		spnLengthToF.setEnabled(enable);
		spnDiameterFromA.setEnabled(enable);
		spnDiameterFromB.setEnabled(enable);
		spnDiameterFromC.setEnabled(enable);
		spnDiameterFromD.setEnabled(enable);
		spnDiameterFromE.setEnabled(enable);
		spnDiameterFromF.setEnabled(enable);
		spnDiameterToA.setEnabled(enable);
		spnDiameterToB.setEnabled(enable);
		spnDiameterToC.setEnabled(enable);
		spnDiameterToD.setEnabled(enable);
		spnDiameterToE.setEnabled(enable);
		spnDiameterToF.setEnabled(enable);
		spnBrokenA.setEnabled(enable);
		spnBrokenB.setEnabled(enable);
		spnBrokenC.setEnabled(enable);
		spnBrokenD.setEnabled(enable);
		spnBrokenE.setEnabled(enable);
		spnBrokenF.setEnabled(enable);
		spnS_ShapeA.setEnabled(enable);
		spnS_ShapeB.setEnabled(enable);
		spnS_ShapeC.setEnabled(enable);
		spnS_ShapeD.setEnabled(enable);
		spnS_ShapeE.setEnabled(enable);
		spnS_ShapeF.setEnabled(enable);
		spnC_ShapeA.setEnabled(enable);
		spnC_ShapeB.setEnabled(enable);
		spnC_ShapeC.setEnabled(enable);
		spnC_ShapeD.setEnabled(enable);
		spnC_ShapeE.setEnabled(enable);
		spnC_ShapeF.setEnabled(enable);
		btnStartSort.setEnabled(enable);
		btnBack.setEnabled(enable);
		btnResert.setEnabled(enable);
		txtCommets.setEnabled(enable);
		cmbChoosePlot.setEnabled(enable);
		cmbGrowers.setEnabled(enable);	
		btnClassA.setEnabled(enable);
		btnClassB.setEnabled(enable);
		btnClassC.setEnabled(enable);
		btnClassD.setEnabled(enable);
		btnClassE.setEnabled(enable);
		btnClassF.setEnabled(enable);
		

	}


}
