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
import java.awt.Dimension;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Statistics {

	private JFrame frmStatistics;

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
		pnLeft.setPreferredSize(new Dimension(750, 10));
		frmStatistics.getContentPane().add(pnLeft, BorderLayout.WEST);
		pnLeft.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlExport = new JPanel();
		FlowLayout fl_pnlExport = (FlowLayout) pnlExport.getLayout();
		fl_pnlExport.setVgap(20);
		pnLeft.add(pnlExport, BorderLayout.NORTH);
		
		JLabel lblExport = new JLabel("Export / Forecast");
		lblExport.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		pnlExport.add(lblExport);
		
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
		pnlExportDetails.add(lblChooseWhatTo, "8, 4, center, default");
		
		JLabel lblLastSorts = new JLabel("Last Sorts: ");
		lblLastSorts.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLastSorts.setFont(new Font("Arial", Font.PLAIN, 14));
		pnlExportDetails.add(lblLastSorts, "2, 8, right, default");
		
		JComboBox cmbLastExportRes = new JComboBox();
		pnlExportDetails.add(cmbLastExportRes, "8, 8, 5, 1, fill, default");
		
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
		
		JButton btnForecast = new JButton("Forecasting Data");
		btnForecast.setPreferredSize(new Dimension(65, 25));
		pnlExportDetails.add(btnForecast, "8, 26, 1, 3");
		
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
	}

}
