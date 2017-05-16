
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import Classes.*;
import Handlers.*;
import Validation.ValidationFunctions;

public class NewCustomer {

	private JFrame frmNewDetails;
	private JTextField txtNewGrowerId;
	private JTextField txtNewGrowerName;
	private JTextField txtNewGrowerAddress;
	private JTextField txtNewGrowerPhone;
	private JTextField txtSearchDetails;
	private JTextField txtIdGrowerChosen;
	private JTextField txtGrowerNameChosen;
	private JTextField txtGrowerAddressChosen;
	private JTextField txtGrowerPhoneChosen;
	private JTextField txtPlotSize;
	private JTextField txtPlotName;
	private JTextField txtPlotNameChosen;
	private JTextField txtPlotSpec;
	private JTextField txtPlotSizeChosen;
	private JTextField txtPlotSpeciesChosen;
	private List<Growers> growers = new ArrayList<>();
	private JComboBox<String> cmbChooseGrower, cmbChooseGrower2, cmbChooseGrower1;
	private ButtonGroup btnGroup;
	private ValidationFunctions validate = new ValidationFunctions(); 
	private String growID;
	private Growers choosenGrower = null;
	private Plots originPlot = null;
	private JComboBox<String> cmbChoosePlot;


	/**
	 * Create the application.
	 */
	public NewCustomer() {
		initialize();
		getDataFromDB();
		frmNewDetails.setVisible(true);
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
		pnlTop.setBackground(new Color(192, 192, 192));
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
		pnlRightHeader.setBackground(new Color(128, 128, 128));
		pnlRight.add(pnlRightHeader, BorderLayout.NORTH);

		JLabel lblPlot = new JLabel("Plot");
		lblPlot.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		pnlRightHeader.add(lblPlot);

		JPanel pnlPlotBody = new JPanel();
		pnlPlotBody.setBackground(new Color(192, 192, 192));
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
		lblSelectGrowerPlot.setFont(new Font("Arial", Font.PLAIN, 12));
		pnlPlotBody.add(lblSelectGrowerPlot, "4, 4");

		cmbChooseGrower1 = new JComboBox<String>();
		pnlPlotBody.add(cmbChooseGrower1, "6, 4, 21, 1, fill, default");
		cmbChooseGrower1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cmbChooseGrower1.getItemCount()!=0){
					String grower = (String)cmbChooseGrower1.getSelectedItem();
					String growerId = grower.substring(grower.lastIndexOf("ID: ")+4, 13);
					growID = growerId;
					System.out.println(growID);
				}

			}
		});


		JLabel lblPlotsName = new JLabel("Plot's Name:");
		lblPlotsName.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPlotsName.setHorizontalAlignment(SwingConstants.CENTER);
		pnlPlotBody.add(lblPlotsName, "4, 6");

		txtPlotName = new JTextField();
		txtPlotName.setBackground(new Color(169, 169, 169));
		pnlPlotBody.add(txtPlotName, "6, 6, 9, 1, fill, default");
		txtPlotName.setColumns(10);

		JLabel lblPlotsSize = new JLabel("Plot's Size");
		lblPlotsSize.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPlotsSize.setHorizontalAlignment(SwingConstants.CENTER);
		pnlPlotBody.add(lblPlotsSize, "4, 8, center, default");

		txtPlotSize = new JTextField();
		txtPlotSize.setBackground(new Color(169, 169, 169));
		txtPlotSize.setColumns(10);
		pnlPlotBody.add(txtPlotSize, "6, 8, 9, 1, fill, default");

		JLabel lblPlotsSpecies = new JLabel("Plot's Species:");
		lblPlotsSpecies.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPlotsSpecies.setHorizontalAlignment(SwingConstants.CENTER);
		pnlPlotBody.add(lblPlotsSpecies, "4, 10");

		txtPlotSpec = new JTextField();
		txtPlotSpec.setBackground(new Color(169, 169, 169));
		txtPlotSpec.setColumns(10);
		pnlPlotBody.add(txtPlotSpec, "6, 10, 9, 1, fill, default");

		JButton btnAddPlot = new JButton("Add");
		btnAddPlot.setBackground(new Color(230, 230, 250));
		btnAddPlot.setFont(new Font("Arial", Font.BOLD, 12));
		btnAddPlot.setContentAreaFilled(false);
		btnAddPlot.setOpaque(true);
		pnlPlotBody.add(btnAddPlot, "4, 14, 3, 1");
		btnAddPlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				//should to check if the plot exist before adding!!
				if (!txtPlotName.getText().isEmpty() && !txtPlotSize.getText().isEmpty() && !txtPlotSpec.getText().isEmpty())
				{
					String pName = txtPlotName.getText().trim();
					String pSize = txtPlotSize.getText().trim();
					String pSpecies = txtPlotSpec.getText().trim();

					Plots p = new Plots(pName, pSize, pSpecies);
					try
					{
						SendServer get = new SendServer();
						if (get.AddPlotToGrower(p, growID)){
							PopUpInfo(true, "Added Plot");
							getDataFromDB();
							txtPlotName.setText("");
							txtPlotSize.setText("");
							txtPlotSpec.setText("");
						}
					}
					catch (Exception ex)
					{
						PopUpInfo(false, ex.getMessage());
					}					
				}
				else
					PopUpInfo(false, "Missed Fields");


				/**
				 * 
				 * 
				 * 
				 */

			}
		});

		JLabel lblUpdateAPlots = new JLabel("Update A Plot's Details");
		lblUpdateAPlots.setFont(new Font("Arial", Font.BOLD, 15));
		pnlPlotBody.add(lblUpdateAPlots, "4, 16, 41, 1, center, default");

		JLabel lblSelectGrowerPlot2 = new JLabel("Select A Grower");
		lblSelectGrowerPlot2.setFont(new Font("Arial", Font.PLAIN, 12));
		pnlPlotBody.add(lblSelectGrowerPlot2, "4, 18");

		cmbChooseGrower2 = new JComboBox<String>();
		pnlPlotBody.add(cmbChooseGrower2, "6, 18, 14, 1, fill, default");
		cmbChooseGrower2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cmbChooseGrower2.getItemCount()!=0){
					String grower = (String)cmbChooseGrower2.getSelectedItem();
					String growerId = grower.substring(grower.lastIndexOf("ID: ")+4, 13);
					for (Growers g : growers)
					{
						if (growerId.equals(g.getgID()))
						{
							choosenGrower = g;
							System.out.println(g.toString());
							AddPlotsField();
							break;
						}
					}
				}

			}
		});

		JLabel lblSelectPlot = new JLabel("Select A Plot:");
		lblSelectPlot.setFont(new Font("Arial", Font.PLAIN, 12));
		pnlPlotBody.add(lblSelectPlot, "4, 20");

		cmbChoosePlot = new JComboBox<String>();
		pnlPlotBody.add(cmbChoosePlot, "6, 20, 14, 1, fill, default");
		cmbChoosePlot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String plot = (String)cmbChoosePlot.getSelectedItem();
				for (Plots p:choosenGrower.getPlots())
				{
					if (plot != null)
					{
						if (plot.equals(p.toString()))
						{
							updatePlotFields(p);
							originPlot = new Plots(p.getpName(),p.getpSize(),p.getpSpec());
							break;
						}
					}
				}				
			}
		});

		JLabel lblDetailsOfPlot = new JLabel("The Details Of The Choosen Plot:");
		lblDetailsOfPlot.setFont(new Font("Arial", Font.BOLD, 13));
		pnlPlotBody.add(lblDetailsOfPlot, "4, 22, 15, 1");

		JLabel lblPlotNameChosen = new JLabel("Plot's Name:");
		lblPlotNameChosen.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPlotNameChosen.setHorizontalAlignment(SwingConstants.CENTER);
		pnlPlotBody.add(lblPlotNameChosen, "4, 24");

		txtPlotNameChosen = new JTextField();
		txtPlotNameChosen.setBackground(new Color(169, 169, 169));
		txtPlotNameChosen.setColumns(10);
		pnlPlotBody.add(txtPlotNameChosen, "6, 24, 9, 1, fill, default");

		JLabel lblPlotSizeChosen = new JLabel("Plot's Size:");
		lblPlotSizeChosen.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPlotSizeChosen.setHorizontalAlignment(SwingConstants.CENTER);
		pnlPlotBody.add(lblPlotSizeChosen, "4, 26, right, default");

		txtPlotSizeChosen = new JTextField();
		txtPlotSizeChosen.setBackground(new Color(169, 169, 169));
		txtPlotSizeChosen.setColumns(10);
		pnlPlotBody.add(txtPlotSizeChosen, "6, 26, 9, 1, fill, default");

		JLabel lblPlotsSpeciesChosen = new JLabel("Plot's Species:");
		lblPlotsSpeciesChosen.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPlotsSpeciesChosen.setHorizontalAlignment(SwingConstants.CENTER);
		pnlPlotBody.add(lblPlotsSpeciesChosen, "4, 28, right, default");

		txtPlotSpeciesChosen = new JTextField();
		txtPlotSpeciesChosen.setBackground(new Color(169, 169, 169));
		txtPlotSpeciesChosen.setColumns(10);
		pnlPlotBody.add(txtPlotSpeciesChosen, "6, 28, 9, 1, fill, default");

		JButton btnUpdatePlot = new JButton("Update");
		btnUpdatePlot.setBackground(new Color(230, 230, 250));
		btnUpdatePlot.setFont(new Font("Arial", Font.BOLD, 12));
		btnUpdatePlot.setContentAreaFilled(false);
		btnUpdatePlot.setOpaque(true);
		pnlPlotBody.add(btnUpdatePlot, "4, 32, 3, 1");
		btnUpdatePlot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txtPlotNameChosen.getText().isEmpty() && !txtPlotSizeChosen.getText().isEmpty() && !txtPlotSpeciesChosen.getText().isEmpty())
				{
					String name = txtPlotNameChosen.getText().trim();
					String size = txtPlotSizeChosen.getText().trim();
					String spec = txtPlotSpeciesChosen.getText().trim();

					Plots p = new Plots(name, size, spec);
					try
					{
						SendServer get = new SendServer();
						get.UpdatePlot(choosenGrower.getgID(), originPlot.getpName(), p);
						PopUpInfo(true, "Updated Plot");
						getDataFromDB();
						txtPlotNameChosen.setText("");
						txtPlotSizeChosen.setText("");
						txtPlotSpeciesChosen.setText("");
					}
					catch (Exception ex)
					{
						PopUpInfo(false, ex.getMessage());
					}
				}
				else
					PopUpInfo(false, "Cannot Empty Fields");			
		}
	});		

		JPanel pnlLeft = new JPanel();
		pnlLeft.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmNewDetails.getContentPane().add(pnlLeft, BorderLayout.CENTER);
		pnlLeft.setLayout(new BorderLayout(0, 0));

		JPanel pnlLeftHeader = new JPanel();
		pnlLeftHeader.setBackground(new Color(128, 128, 128));
		pnlLeft.add(pnlLeftHeader, BorderLayout.NORTH);

		JLabel lblGrower = new JLabel("Grower");
		lblGrower.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		pnlLeftHeader.add(lblGrower);

		JPanel pnlLeftBody = new JPanel();
		pnlLeftBody.setBackground(new Color(192, 192, 192));
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
		lblNewGrowerId.setFont(new Font("Arial", Font.PLAIN, 12));
		pnlLeftBody.add(lblNewGrowerId, "4, 4, right, default");

		txtNewGrowerId = new JTextField();
		txtNewGrowerId.setBackground(new Color(169, 169, 169));
		pnlLeftBody.add(txtNewGrowerId, "6, 4, fill, default");
		txtNewGrowerId.setColumns(10);

		JLabel lblNewGrowerName = new JLabel("Name:");
		lblNewGrowerName.setFont(new Font("Arial", Font.PLAIN, 12));
		pnlLeftBody.add(lblNewGrowerName, "4, 6, right, default");

		txtNewGrowerName = new JTextField();
		txtNewGrowerName.setBackground(new Color(169, 169, 169));
		pnlLeftBody.add(txtNewGrowerName, "6, 6, fill, default");
		txtNewGrowerName.setColumns(10);

		JLabel lblNewGrowerAddress = new JLabel("Address: ");
		lblNewGrowerAddress.setFont(new Font("Arial", Font.PLAIN, 12));
		pnlLeftBody.add(lblNewGrowerAddress, "4, 8, right, default");

		txtNewGrowerAddress = new JTextField();
		txtNewGrowerAddress.setBackground(new Color(169, 169, 169));
		pnlLeftBody.add(txtNewGrowerAddress, "6, 8, 8, 1, fill, default");
		txtNewGrowerAddress.setColumns(10);

		JLabel lblNewGrowerPhone = new JLabel("Phone Number:");
		lblNewGrowerPhone.setFont(new Font("Arial", Font.PLAIN, 12));
		pnlLeftBody.add(lblNewGrowerPhone, "4, 10, right, default");

		txtNewGrowerPhone = new JTextField();
		txtNewGrowerPhone.setBackground(new Color(169, 169, 169));
		pnlLeftBody.add(txtNewGrowerPhone, "6, 10, fill, default");
		txtNewGrowerPhone.setColumns(10);

		JButton btnAddGrower = new JButton("Add");
		btnAddGrower.setBackground(new Color(230, 230, 250));
		btnAddGrower.setFont(new Font("Arial", Font.BOLD, 12));
		btnAddGrower.setContentAreaFilled(false);
		btnAddGrower.setOpaque(true);
		pnlLeftBody.add(btnAddGrower, "4, 14, 3, 1");
		btnAddGrower.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (validate.checkId(txtNewGrowerId.getText()) && validate.checkName(txtNewGrowerName.getText()) && 
						validate.checkAddress(txtNewGrowerAddress.getText()) && validate.checkCellular(txtNewGrowerPhone.getText())){
					Growers grower = new Growers(txtNewGrowerId.getText(), txtNewGrowerName.getText(),
							txtNewGrowerAddress.getText(),txtNewGrowerPhone.getText());
					try
					{
						SendServer send = new SendServer();
						send.insert(grower);
						getDataFromDB();
						txtNewGrowerId.setText("");
						txtNewGrowerName.setText("");
						txtNewGrowerAddress.setText("");
						txtNewGrowerPhone.setText("");
						PopUpInfo(true, "Grower Added");
					}
					catch (Exception ex)
					{
						PopUpInfo(false, ex.getMessage());
					}
				}else{
					PopUpInfo(false, "Wrong Details");
				}
			}
		});


		JLabel lblUpdateGrower = new JLabel("Update A Growers Details");
		lblUpdateGrower.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateGrower.setFont(new Font("Arial", Font.BOLD, 15));
		pnlLeftBody.add(lblUpdateGrower, "4, 16, 22, 1");

		JLabel lblSelectGrower = new JLabel("Select A Grower");
		lblSelectGrower.setFont(new Font("Arial", Font.PLAIN, 12));
		pnlLeftBody.add(lblSelectGrower, "4, 18, right, default");




		cmbChooseGrower = new JComboBox<String>();
		pnlLeftBody.add(cmbChooseGrower, "6, 18, 7, 1, fill, default");
		cmbChooseGrower.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cmbChooseGrower.getItemCount()!=0){
					String grower = (String)cmbChooseGrower.getSelectedItem();
					String growerId = grower.substring(grower.lastIndexOf("ID: ")+4, grower.indexOf("  Name: ")).trim();
					for (int i=0;i<growers.size();++i){
						if (growerId.equals(growers.get(i).getgID())){
							updateFields(growers.get(i));
						}
					}

				}
			}
		});


		btnGroup = new ButtonGroup();


		JLabel lblSearchGrower = new JLabel("Search A Grower By:");
		lblSearchGrower.setFont(new Font("Arial", Font.PLAIN, 12));
		pnlLeftBody.add(lblSearchGrower, "4, 20");

		JRadioButton rdbtnId = new JRadioButton("ID");
		rdbtnId.setFont(new Font("Arial", Font.BOLD, 12));
		rdbtnId.setBackground(new Color(192, 192, 192));
		pnlLeftBody.add(rdbtnId, "6, 20");

		btnGroup.add(rdbtnId);

		txtSearchDetails = new JTextField();
		txtSearchDetails.setBackground(new Color(169, 169, 169));
		pnlLeftBody.add(txtSearchDetails, "8, 20, fill, default");
		txtSearchDetails.setColumns(10);

		JRadioButton rdbtnPhoneNumber = new JRadioButton("Phone Number");
		rdbtnPhoneNumber.setFont(new Font("Arial", Font.BOLD, 12));
		rdbtnPhoneNumber.setBackground(new Color(192, 192, 192));
		pnlLeftBody.add(rdbtnPhoneNumber, "6, 22");

		btnGroup.add(rdbtnPhoneNumber);

		JRadioButton rdbtnName = new JRadioButton("Name");
		rdbtnName.setFont(new Font("Arial", Font.BOLD, 12));
		rdbtnName.setBackground(new Color(192, 192, 192));
		pnlLeftBody.add(rdbtnName, "6, 24");

		btnGroup.add(rdbtnName);

		JButton btnSearchGrower = new JButton("Search");
		btnSearchGrower.setBackground(new Color(230, 230, 250));
		btnSearchGrower.setFont(new Font("Arial", Font.BOLD, 12));
		btnSearchGrower.setContentAreaFilled(false);
		btnSearchGrower.setOpaque(true);
		btnSearchGrower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int counter =0;
				Growers grower = null;
				Enumeration elements = btnGroup.getElements();
				while (elements.hasMoreElements()) {
					AbstractButton button = (AbstractButton)elements.nextElement();
					if (button.isSelected()) {
						grower = searchBy(button.getText(), txtSearchDetails.getText().trim());

					}
					else
						counter++;
				}
				if (counter == btnGroup.getButtonCount()){
					System.out.println("No Button Has Been Chekced");
				}
				else if (grower!=null){
					updateFields(grower);
					cmbChooseGrower.setSelectedItem(grower.toString());
				}
				else
					JOptionPane.showMessageDialog(null, "No such Grower", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
			}
		});
		pnlLeftBody.add(btnSearchGrower, "4, 26, 3, 1");

		JLabel lblDetailsGrowerChosen = new JLabel("The Details Of The Choosen Grower:");
		lblDetailsGrowerChosen.setFont(new Font("Arial", Font.BOLD, 13));
		pnlLeftBody.add(lblDetailsGrowerChosen, "4, 28, 3, 1");

		JLabel lblGrowerChosen = new JLabel("ID Number:");
		lblGrowerChosen.setFont(new Font("Arial", Font.PLAIN, 12));
		pnlLeftBody.add(lblGrowerChosen, "4, 30, right, default");

		txtIdGrowerChosen = new JTextField();
		txtIdGrowerChosen.setBackground(new Color(169, 169, 169));
		txtIdGrowerChosen.setEnabled(false);
		txtIdGrowerChosen.setDisabledTextColor(Color.LIGHT_GRAY);
		txtIdGrowerChosen.setText("Non Changable");
		pnlLeftBody.add(txtIdGrowerChosen, "6, 30, fill, default");
		txtIdGrowerChosen.setColumns(10);


		JLabel lblGrowerNameChosen = new JLabel("Name:");
		lblGrowerNameChosen.setFont(new Font("Arial", Font.PLAIN, 12));
		pnlLeftBody.add(lblGrowerNameChosen, "4, 32, right, default");

		txtGrowerNameChosen = new JTextField();
		txtGrowerNameChosen.setBackground(new Color(169, 169, 169));
		pnlLeftBody.add(txtGrowerNameChosen, "6, 32, fill, default");
		txtGrowerNameChosen.setColumns(10);

		JLabel lblGrowerAddressChosen = new JLabel("Address:");
		lblGrowerAddressChosen.setFont(new Font("Arial", Font.PLAIN, 12));
		pnlLeftBody.add(lblGrowerAddressChosen, "4, 34, right, default");

		txtGrowerAddressChosen = new JTextField();
		txtGrowerAddressChosen.setBackground(new Color(169, 169, 169));
		pnlLeftBody.add(txtGrowerAddressChosen, "6, 34, fill, default");
		txtGrowerAddressChosen.setColumns(10);

		JLabel lblGrowerPNumberChosen = new JLabel("Phone Number:");
		lblGrowerPNumberChosen.setFont(new Font("Arial", Font.PLAIN, 12));
		pnlLeftBody.add(lblGrowerPNumberChosen, "4, 36, right, default");

		txtGrowerPhoneChosen = new JTextField();
		txtGrowerPhoneChosen.setBackground(new Color(169, 169, 169));
		pnlLeftBody.add(txtGrowerPhoneChosen, "6, 36, fill, default");
		txtGrowerPhoneChosen.setColumns(10);

		JButton btnUpdateGrower = new JButton("Update");
		btnUpdateGrower.setBackground(new Color(230, 230, 250));
		btnUpdateGrower.setFont(new Font("Arial", Font.BOLD, 12));
		btnUpdateGrower.setContentAreaFilled(false);
		btnUpdateGrower.setOpaque(true);
		pnlLeftBody.add(btnUpdateGrower, "4, 38, 3, 1");

		btnUpdateGrower.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isChanged = false;
				Growers nGrower = null;
				String id = txtIdGrowerChosen.getText().trim();
				String name = txtGrowerNameChosen.getText().trim();
				String addr = txtGrowerAddressChosen.getText().trim();
				String phone = txtGrowerPhoneChosen.getText().trim();

				for ( int i=0;i<growers.size();++i){
					if (growers.get(i).getgID().equals(id)){
						if (!growers.get(i).getgName().equals(name) ||  !growers.get(i).getgAddress().equals(addr) || 
								!growers.get(i).getgPhone().equals(phone)){
							isChanged =true;
							nGrower = new Growers(growers.get(i));
							break;
						}	
					}
				}
				if (isChanged){
					nGrower.setgAddress(addr);
					nGrower.setgName(name);
					nGrower.setgPhone(phone);
					//Growers grower = new Growers(id,name,addr,phone);
					try
					{
						SendServer get = new SendServer();
						get.updateGrower(nGrower);
						getDataFromDB();
						PopUpInfo(true, "Grower Updated");
					}
					catch (Exception ex)
					{
						PopUpInfo(false, ex.getMessage());
					}
				}
				else{
					PopUpInfo(false, "Grower's Data Hasen't Been Changed");
				}
			}
		});

		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(230, 230, 250));
		btnBack.setFont(new Font("Arial", Font.BOLD, 12));
		btnBack.setForeground(new Color(255, 0, 0));
		btnBack.setContentAreaFilled(false);
		btnBack.setOpaque(true);
		pnlLeftBody.add(btnBack, "6, 42");
		
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainMenuWindow();
				frmNewDetails.dispose();
				
			}
		});

}

private Growers searchBy(String catagory, String whatToSearch){
	switch(catagory){
	case "ID": 
		for ( int i=0;i<growers.size();++i){
			if (growers.get(i).getgID().equals(whatToSearch)){
				return growers.get(i);
			}
		}
		break;
	case "Phone Number":
		for ( int i=0;i<growers.size();++i){
			if (growers.get(i).getgPhone().equals(whatToSearch)){
				return growers.get(i);
			}
		}
		break;
	case "Name":
		for ( int i=0;i<growers.size();++i){
			if (growers.get(i).getgName().equals(whatToSearch)){
				return growers.get(i);
			}
		}
		break;
	default: return null;
	}
	return null;

}

private void updateFields(Growers grower){
	if (grower!=null){
		txtIdGrowerChosen.setText(grower.getgID());
		txtGrowerNameChosen.setText(grower.getgName());
		txtGrowerAddressChosen.setText(grower.getgAddress());
		txtGrowerPhoneChosen.setText(grower.getgPhone());
	}
}

private void updatePlotFields(Plots p){
	if (p != null){
		txtPlotNameChosen.setText(p.getpName());
		txtPlotSizeChosen.setText(p.getpSize());
		txtPlotSpeciesChosen.setText(p.getpSpec());
	}
}


private void getDataFromDB(){

	SendServer get = new SendServer();
	if (growers.size()!=0)
		growers.clear();
	growers = get.getGrowers();
	cmbChooseGrower.removeAllItems();
	cmbChooseGrower1.removeAllItems();
	cmbChooseGrower2.removeAllItems();

	for (int i=0;i<growers.size();++i){
		cmbChooseGrower.addItem(growers.get(i).toString());
		cmbChooseGrower1.addItem(growers.get(i).toString());
		cmbChooseGrower2.addItem(growers.get(i).toString());
	}
	//updateFields(growers.get(0));
}

private void AddPlotsField()
{
	cmbChoosePlot.removeAllItems();
	for (Plots p:choosenGrower.getPlots())
	{
		cmbChoosePlot.addItem(p.toString());
	}
}

private void PopUpInfo(boolean bool, String info)
{
	if (bool == true)
		JOptionPane.showMessageDialog(null, info + " Successfully", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
	else
		JOptionPane.showMessageDialog(null, "Failed: " + info, "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
}

}




