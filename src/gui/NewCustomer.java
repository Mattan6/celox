package gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class NewCustomer {

	private JFrame frmNewDetails;
	private JTextField txtGower;
	private JTextField txtPlot;
	private JTextField txtGrowerName;
	private JTextField txtGrowerID;
	private JTextField txtGrowerAddr;
	private JTextField txtGrowerPhone;
	private JTextField txtNewGrowerId;
	private JTextField txtNewGrowerName;
	private JTextField txtNewGrowerAddress;
	private JTextField txtNewGrowerPhone;
	private JTextField txtSearchDetails;
	private JTextField txtIdGrowerChosen;
	private JTextField txtGrowerNameChosen;
	private JTextField txtGrowerAddressChosen;
	private JTextField textField_9;
	private JTextField txtPlotId;
	private JTextField txtPlotName;
	private JTextField txtPlotIdChosen;
	private JTextField txtPlotNameChosen;
	private JTextField txtPlotSize;
	private JTextField txtSpeciesChoosen;
	private JTextField txtPlotSizeChosen;
	private JTextField txtPlotSpeciesChosen;
	private JTextField txtAddNewSpecies;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCustomer window = new NewCustomer();
					window.frmNewDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewCustomer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewDetails = new JFrame();
		frmNewDetails.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmNewDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNewDetails.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTop = new JPanel();
		pnlTop.setBackground(Color.WHITE);
		FlowLayout fl_pnlTop = (FlowLayout) pnlTop.getLayout();
		fl_pnlTop.setVgap(50);
		frmNewDetails.getContentPane().add(pnlTop, BorderLayout.NORTH);
		
		JLabel lblAddNewDetails = new JLabel("Add/Update Details ");
		lblAddNewDetails.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 47));
		pnlTop.add(lblAddNewDetails);
		
		JPanel pnlRight = new JPanel();
		pnlRight.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlRight.setPreferredSize(new Dimension(800, 10));
		frmNewDetails.getContentPane().add(pnlRight, BorderLayout.EAST);
		pnlRight.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlRightHeader = new JPanel();
		pnlRightHeader.setBackground(Color.WHITE);
		pnlRight.add(pnlRightHeader, BorderLayout.NORTH);
		
		JLabel lblPlot = new JLabel("Plot");
		lblPlot.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		pnlRightHeader.add(lblPlot);
		
		JPanel pnlPlotBody = new JPanel();
		pnlRight.add(pnlPlotBody, BorderLayout.CENTER);
		pnlPlotBody.setLayout(new FormLayout(new ColumnSpec[] {
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
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
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
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblAddNewPlot1 = new JLabel("Add A New Plot");
		lblAddNewPlot1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewPlot1.setFont(new Font("Arial", Font.BOLD, 15));
		pnlPlotBody.add(lblAddNewPlot1, "2, 2, 43, 1");
		
		JLabel lblSelectGrowerPlot = new JLabel("Select A Grower");
		pnlPlotBody.add(lblSelectGrowerPlot, "4, 4");
		
		JComboBox cmbChooseGrower1 = new JComboBox();
		pnlPlotBody.add(cmbChooseGrower1, "6, 4, 21, 1, fill, default");
		
		JLabel lblPlotId = new JLabel("Plot's ID:");
		lblPlotId.setHorizontalAlignment(SwingConstants.CENTER);
		pnlPlotBody.add(lblPlotId, "4, 6, center, default");
		
		txtPlotId = new JTextField();
		pnlPlotBody.add(txtPlotId, "6, 6, 9, 1, fill, default");
		txtPlotId.setColumns(10);
		
		JLabel lblPlotsName = new JLabel("Plot's Name:");
		lblPlotsName.setHorizontalAlignment(SwingConstants.CENTER);
		pnlPlotBody.add(lblPlotsName, "4, 8");
		
		txtPlotName = new JTextField();
		txtPlotName.setColumns(10);
		pnlPlotBody.add(txtPlotName, "6, 8, 9, 1, fill, default");
		
		JLabel lblPlotsSize = new JLabel("Plot's Size");
		lblPlotsSize.setHorizontalAlignment(SwingConstants.CENTER);
		pnlPlotBody.add(lblPlotsSize, "4, 10, center, default");
		
		txtPlotSize = new JTextField();
		txtPlotSize.setColumns(10);
		pnlPlotBody.add(txtPlotSize, "6, 10, 9, 1, fill, default");
		
		JLabel lblPlotsSpecies = new JLabel("Plot's Species:");
		lblPlotsSpecies.setHorizontalAlignment(SwingConstants.CENTER);
		pnlPlotBody.add(lblPlotsSpecies, "4, 12");
		
		JComboBox cmbPlotSpecies = new JComboBox();
		pnlPlotBody.add(cmbPlotSpecies, "6, 12, 9, 1, fill, default");
		
		txtSpeciesChoosen = new JTextField();
		txtSpeciesChoosen.setText("Species Choosen:");
		txtSpeciesChoosen.setEnabled(false);
		txtSpeciesChoosen.setColumns(10);
		pnlPlotBody.add(txtSpeciesChoosen, "18, 12, 11, 1, fill, default");
		
		JButton btnAddPlot = new JButton("Add");
		pnlPlotBody.add(btnAddPlot, "2, 16, 11, 1");
		
		JLabel lblUpdateAPlots = new JLabel("Update A Plot's Details");
		lblUpdateAPlots.setFont(new Font("Arial", Font.BOLD, 15));
		pnlPlotBody.add(lblUpdateAPlots, "2, 20, 43, 1, center, default");
		
		JLabel lblSelectGrowerPlot2 = new JLabel("Select A Grower");
		pnlPlotBody.add(lblSelectGrowerPlot2, "4, 22");
		
		JComboBox cmbChooseGrower2 = new JComboBox();
		pnlPlotBody.add(cmbChooseGrower2, "6, 22, 21, 1, fill, default");
		
		JLabel lblSelectPlot = new JLabel("Select A Plot:");
		pnlPlotBody.add(lblSelectPlot, "4, 24");
		
		JComboBox cmbChoosePlot = new JComboBox();
		pnlPlotBody.add(cmbChoosePlot, "6, 24, 21, 1, fill, default");
		
		JLabel lblDetailsOfPlot = new JLabel("The Details Of The Choosen Plot:");
		pnlPlotBody.add(lblDetailsOfPlot, "2, 28, 17, 1");
		
		JLabel lblPlotIdChosen = new JLabel("Plot's ID:");
		lblPlotIdChosen.setHorizontalAlignment(SwingConstants.CENTER);
		pnlPlotBody.add(lblPlotIdChosen, "4, 30");
		
		txtPlotIdChosen = new JTextField();
		txtPlotIdChosen.setText("Non Changable");
		txtPlotIdChosen.setEnabled(false);
		txtPlotIdChosen.setColumns(10);
		pnlPlotBody.add(txtPlotIdChosen, "6, 30, 9, 1, fill, default");
		
		JLabel lblPlotNameChosen = new JLabel("Plot's Name:");
		lblPlotNameChosen.setHorizontalAlignment(SwingConstants.CENTER);
		pnlPlotBody.add(lblPlotNameChosen, "4, 32");
		
		txtPlotNameChosen = new JTextField();
		txtPlotNameChosen.setColumns(10);
		pnlPlotBody.add(txtPlotNameChosen, "6, 32, 9, 1, fill, default");
		
		JLabel lblPlotSizeChosen = new JLabel("Plot's Size:");
		lblPlotSizeChosen.setHorizontalAlignment(SwingConstants.CENTER);
		pnlPlotBody.add(lblPlotSizeChosen, "4, 34, right, default");
		
		txtPlotSizeChosen = new JTextField();
		txtPlotSizeChosen.setColumns(10);
		pnlPlotBody.add(txtPlotSizeChosen, "6, 34, 9, 1, fill, default");
		
		JLabel lblPlotsSpeciesChosen = new JLabel("Plot's Species:");
		lblPlotsSpeciesChosen.setHorizontalAlignment(SwingConstants.CENTER);
		pnlPlotBody.add(lblPlotsSpeciesChosen, "4, 36, right, default");
		
		txtPlotSpeciesChosen = new JTextField();
		txtPlotSpeciesChosen.setColumns(10);
		pnlPlotBody.add(txtPlotSpeciesChosen, "6, 36, 9, 1, fill, default");
		
		JButton btnUpdatePlot = new JButton("Update");
		pnlPlotBody.add(btnUpdatePlot, "2, 40, 11, 1");
		
		JPanel pnlDown = new JPanel();
		pnlDown.setPreferredSize(new Dimension(10, 110));
		pnlRight.add(pnlDown, BorderLayout.SOUTH);
		pnlDown.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlDownHeader = new JPanel();
		pnlDownHeader.setBackground(Color.WHITE);
		pnlDown.add(pnlDownHeader, BorderLayout.NORTH);
		
		JLabel lblDownHeader = new JLabel("Species");
		lblDownHeader.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		pnlDownHeader.add(lblDownHeader);
		
		JPanel pnlDownBody = new JPanel();
		pnlDown.add(pnlDownBody, BorderLayout.CENTER);
		pnlDownBody.setLayout(new FormLayout(new ColumnSpec[] {
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
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblAddNewSpecies = new JLabel("Add New Species");
		lblAddNewSpecies.setHorizontalAlignment(SwingConstants.CENTER);
		pnlDownBody.add(lblAddNewSpecies, "2, 2, 19, 1");
		
		txtAddNewSpecies = new JTextField();
		txtAddNewSpecies.setColumns(10);
		pnlDownBody.add(txtAddNewSpecies, "2, 4, 5, 1, fill, default");
		
		JButton btnAddSpecies = new JButton("Add");
		btnAddSpecies.setPreferredSize(new Dimension(45, 23));
		pnlDownBody.add(btnAddSpecies, "8, 4, 11, 1");
		
		JPanel pnlLeft = new JPanel();
		pnlLeft.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmNewDetails.getContentPane().add(pnlLeft, BorderLayout.CENTER);
		pnlLeft.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlLeftHeader = new JPanel();
		pnlLeftHeader.setBackground(Color.WHITE);
		pnlLeft.add(pnlLeftHeader, BorderLayout.NORTH);
		
		JLabel lblGrower = new JLabel("Grower");
		lblGrower.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		pnlLeftHeader.add(lblGrower);
		
		JPanel pnlLeftBody = new JPanel();
		pnlLeft.add(pnlLeftBody, BorderLayout.CENTER);
		pnlLeftBody.setLayout(new FormLayout(new ColumnSpec[] {
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
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblAddNewGrower = new JLabel("Add A New Grower");
		lblAddNewGrower.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewGrower.setFont(new Font("Arial", Font.BOLD, 15));
		pnlLeftBody.add(lblAddNewGrower, "4, 2, 23, 1");
		
		JLabel lblNewGrowerId = new JLabel("ID Number:");
		pnlLeftBody.add(lblNewGrowerId, "4, 4, right, default");
		
		txtNewGrowerId = new JTextField();
		pnlLeftBody.add(txtNewGrowerId, "6, 4, fill, default");
		txtNewGrowerId.setColumns(10);
		
		JLabel lblNewGrowerName = new JLabel("Name:");
		pnlLeftBody.add(lblNewGrowerName, "4, 6, right, default");
		
		txtNewGrowerName = new JTextField();
		pnlLeftBody.add(txtNewGrowerName, "6, 6, fill, default");
		txtNewGrowerName.setColumns(10);
		
		JLabel lblNewGrowerAddress = new JLabel("Address: ");
		pnlLeftBody.add(lblNewGrowerAddress, "4, 8, right, default");
		
		txtNewGrowerAddress = new JTextField();
		pnlLeftBody.add(txtNewGrowerAddress, "6, 8, 8, 1, fill, default");
		txtNewGrowerAddress.setColumns(10);
		
		JLabel lblNewGrowerPhone = new JLabel("Phone Number:");
		pnlLeftBody.add(lblNewGrowerPhone, "4, 10, right, default");
		
		txtNewGrowerPhone = new JTextField();
		pnlLeftBody.add(txtNewGrowerPhone, "6, 10, fill, default");
		txtNewGrowerPhone.setColumns(10);
		
		JButton btnAddGrower = new JButton("Add");
		pnlLeftBody.add(btnAddGrower, "4, 14, 3, 1");
		
		JLabel lblUpdateGrower = new JLabel("Update A Growers Details");
		lblUpdateGrower.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateGrower.setFont(new Font("Arial", Font.BOLD, 15));
		pnlLeftBody.add(lblUpdateGrower, "4, 16, 22, 1");
		
		JLabel lblSelectGrower = new JLabel("Select A Grower");
		pnlLeftBody.add(lblSelectGrower, "4, 18, right, default");
		
		JComboBox cmbSelectGrower = new JComboBox();
		pnlLeftBody.add(cmbSelectGrower, "6, 18, 7, 1, fill, default");
		
		JLabel lblSearchGrower = new JLabel("Search A Grower By:");
		pnlLeftBody.add(lblSearchGrower, "4, 20");
		
		JRadioButton rdbtnId = new JRadioButton("ID");
		pnlLeftBody.add(rdbtnId, "6, 20");
		
		txtSearchDetails = new JTextField();
		pnlLeftBody.add(txtSearchDetails, "8, 20, fill, default");
		txtSearchDetails.setColumns(10);
		
		JRadioButton rdbtnPhoneNumber = new JRadioButton("Phone Number");
		pnlLeftBody.add(rdbtnPhoneNumber, "6, 22");
		
		JRadioButton rdbtnName = new JRadioButton("Name");
		pnlLeftBody.add(rdbtnName, "6, 24");
		
		JLabel lblDetailsGrowerChosen = new JLabel("The Details Of The Choosen Grower:");
		pnlLeftBody.add(lblDetailsGrowerChosen, "4, 28, 3, 1");
		
		JLabel lblGrowerChosen = new JLabel("ID Number:");
		pnlLeftBody.add(lblGrowerChosen, "4, 30, right, default");
		
		txtIdGrowerChosen = new JTextField();
		txtIdGrowerChosen.setEnabled(false);
		txtIdGrowerChosen.setDisabledTextColor(Color.LIGHT_GRAY);
		txtIdGrowerChosen.setText("Non Changable");
		pnlLeftBody.add(txtIdGrowerChosen, "6, 30, fill, default");
		txtIdGrowerChosen.setColumns(10);
		
		JLabel lblGrowerNameChosen = new JLabel("Name:");
		pnlLeftBody.add(lblGrowerNameChosen, "4, 32, right, default");
		
		txtGrowerNameChosen = new JTextField();
		pnlLeftBody.add(txtGrowerNameChosen, "6, 32, fill, default");
		txtGrowerNameChosen.setColumns(10);
		
		JLabel lblGrowerAddressChosen = new JLabel("Address:");
		pnlLeftBody.add(lblGrowerAddressChosen, "4, 34, right, default");
		
		txtGrowerAddressChosen = new JTextField();
		pnlLeftBody.add(txtGrowerAddressChosen, "6, 34, fill, default");
		txtGrowerAddressChosen.setColumns(10);
		
		JLabel lblGrowerPNumberChosen = new JLabel("Phone Number:");
		pnlLeftBody.add(lblGrowerPNumberChosen, "4, 36, right, default");
		
		textField_9 = new JTextField();
		pnlLeftBody.add(textField_9, "6, 36, fill, default");
		textField_9.setColumns(10);
		
		JButton btnUpdateGrower = new JButton("Update");
		pnlLeftBody.add(btnUpdateGrower, "4, 38, 3, 1");
		FieldsFormPlots();
		FieldsFormNewCustomer();
	}
	private void FieldsFormNewCustomer()
	{
	}
	
	private void FieldsFormPlots()
	{
	}

}