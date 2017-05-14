package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class SensitivityDetails{

	private JDialog frmSensitivity;
	private JTextField txtSplitNum;
	private JTextField txtBSpotsNum;
	private JTextField txtGdamageNum;
	private JTextField txtCrownNum;
	private JButton btnFinish;
	private JScrollBar scbSplit;
	private JScrollBar scbBlackSpots;
	private JScrollBar scbGrayDamage;
	private JScrollBar scbCrown;

	// [Split,BSpots,Graydamage,Crown]
	private String whatClass = "";
	private int[] sens = new int[4];
	private JButton btnCancel;

	/**
	 * Create the application.
	 */
	public SensitivityDetails() {
		initialize();
		frmSensitivity.setVisible(true);
	}

	public SensitivityDetails(boolean off) {
		initialize();
		frmSensitivity.setVisible(off);
	}

	public SensitivityDetails(int[] sens, String cla) {
		StringBuilder sb = new StringBuilder();
		initialize();
		this.sens = sens;
		this.txtSplitNum.setText(sb.append(this.sens[0]).toString());
		this.scbSplit.setValue(this.sens[0]);
		sb.delete(0, 0);
		this.txtBSpotsNum.setText(sb.append(this.sens[1]).toString());
		this.scbBlackSpots.setValue(this.sens[1]);
		sb.delete(0, 0);
		this.txtGdamageNum.setText(sb.append(this.sens[2]).toString());
		this.scbGrayDamage.setValue(this.sens[2]);
		sb.delete(0, 0);
		this.txtCrownNum.setText(sb.append(this.sens[3]).toString());
		this.scbCrown.setValue(this.sens[3]);
		this.whatClass=cla;
		frmSensitivity.setVisible(false);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSensitivity = new JDialog();
		frmSensitivity.setType(Type.NORMAL);
		frmSensitivity.setTitle("Sensitivity Window\r\n");
		frmSensitivity.setBounds(100, 100, 590, 361);
		frmSensitivity.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

		JPanel pnlSensitivity = new JPanel();
		frmSensitivity.getContentPane().add(pnlSensitivity, BorderLayout.CENTER);
		pnlSensitivity.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
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
						FormSpecs.DEFAULT_ROWSPEC,}));

		JLabel lblSensitivityPrefrences = new JLabel("Sensitivity Prefrences");
		lblSensitivityPrefrences.setFont(new Font("Arial", Font.BOLD, 15));
		lblSensitivityPrefrences.setHorizontalAlignment(SwingConstants.CENTER);
		pnlSensitivity.add(lblSensitivityPrefrences, "2, 2, 31, 1");

		JLabel lblSplit = new JLabel("Split");
		lblSplit.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlSensitivity.add(lblSplit, "2, 6, right, default");

		txtSplitNum = new JTextField();
		txtSplitNum.setText("0");
		txtSplitNum.setFont(new Font("Arial", Font.BOLD, 13));
		txtSplitNum.setEditable(false);
		pnlSensitivity.add(txtSplitNum, "4, 6, center, default");
		txtSplitNum.setColumns(10);

		scbSplit = new JScrollBar();
		scbSplit.setBlockIncrement(1);
		scbSplit.setMaximum(1000);
		scbSplit.setToolTipText("");
		scbSplit.setOrientation(JScrollBar.HORIZONTAL);
		pnlSensitivity.add(scbSplit, "8, 6, 23, 1");

		scbSplit.addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				StringBuilder sb = new StringBuilder();
				sb.append(scbSplit.getValue());
				txtSplitNum.setText(sb.toString());

			}
		});

		JLabel lblBlackSpots = new JLabel("Black Spots");
		lblBlackSpots.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlSensitivity.add(lblBlackSpots, "2, 10, right, default");

		txtBSpotsNum = new JTextField();
		txtBSpotsNum.setText("0");
		txtBSpotsNum.setFont(new Font("Arial", Font.BOLD, 13));
		txtBSpotsNum.setEditable(false);
		pnlSensitivity.add(txtBSpotsNum, "4, 10, center, default");
		txtBSpotsNum.setColumns(10);

		scbBlackSpots = new JScrollBar();
		scbBlackSpots.setMaximum(1000);
		scbBlackSpots.setOrientation(JScrollBar.HORIZONTAL);
		pnlSensitivity.add(scbBlackSpots, "8, 10, 23, 1");

		scbBlackSpots.addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				StringBuilder sb = new StringBuilder();
				sb.append(scbBlackSpots.getValue());
				txtBSpotsNum.setText(sb.toString());

			}
		});

		JLabel lblGrayDamage = new JLabel("Gray Damage");
		lblGrayDamage.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlSensitivity.add(lblGrayDamage, "2, 14, right, default");

		txtGdamageNum = new JTextField();
		txtGdamageNum.setText("0");
		txtGdamageNum.setFont(new Font("Arial", Font.BOLD, 13));
		txtGdamageNum.setEditable(false);
		pnlSensitivity.add(txtGdamageNum, "4, 14, center, default");
		txtGdamageNum.setColumns(10);

		scbGrayDamage = new JScrollBar();
		scbGrayDamage.setMaximum(1000);
		scbGrayDamage.setOrientation(JScrollBar.HORIZONTAL);
		pnlSensitivity.add(scbGrayDamage, "8, 14, 23, 1");

		scbGrayDamage.addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				StringBuilder sb = new StringBuilder();
				sb.append(scbGrayDamage.getValue());
				txtGdamageNum.setText(sb.toString());

			}
		});

		JLabel lblCrown = new JLabel("Crown");
		lblCrown.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlSensitivity.add(lblCrown, "2, 18, right, default");

		txtCrownNum = new JTextField();
		txtCrownNum.setText("0");
		txtCrownNum.setFont(new Font("Arial", Font.BOLD, 13));
		txtCrownNum.setEditable(false);
		pnlSensitivity.add(txtCrownNum, "4, 18, center, default");
		txtCrownNum.setColumns(10);

		scbCrown = new JScrollBar();
		scbCrown.setMaximum(1000);
		scbCrown.setOrientation(JScrollBar.HORIZONTAL);
		pnlSensitivity.add(scbCrown, "8, 18, 23, 1");

		scbCrown.addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				StringBuilder sb = new StringBuilder();
				sb.append(scbCrown.getValue());
				txtCrownNum.setText(sb.toString());

			}
		});



		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Arial", Font.BOLD, 13));
		pnlSensitivity.add(btnCancel, "2, 24, 31, 1, center, center");
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				scbSplit.setValue(sens[0]);
				scbBlackSpots.setValue(sens[1]);
				scbGrayDamage.setValue(sens[2]);
				scbCrown.setValue(sens[3]);
				frmSensitivity.setVisible(false);
				
			}
		});

		btnFinish = new JButton("Update");
		btnFinish.setFont(new Font("Arial", Font.BOLD, 13));
		pnlSensitivity.add(btnFinish, "2, 22, 31, 1, center, center");
		
		btnFinish.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sens[0] = scbSplit.getValue();
				sens[1] = scbBlackSpots.getValue();
				sens[2] = scbGrayDamage.getValue();
				sens[3] = scbCrown.getValue();
				frmSensitivity.setVisible(false);
			}
		});
	}

	public int[] getArr(){
		return this.sens;
	}

	public String getWhatClass(){
		return this.whatClass;
	}

	public void setVisible(boolean enable){
		frmSensitivity.setVisible(enable);
	}

	public void closeWindow(){
		this.sens = null;
		scbSplit.setValue(0);
		scbBlackSpots.setValue(0);
		scbGrayDamage.setValue(0);
		scbCrown.setValue(0);
		frmSensitivity.dispose();
	}

}
