package gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Classes.Users;
import Handlers.SendServer;

public class LoginWindow {
	/**Form variables**/
	private JFrame frmLogin;
	private JTextField txtUserName;
	private JLabel lblPassword;
	private JPasswordField txtpasswordField;
	private JLabel lblImgLogo;
	private JButton btnClear;
	private List<Users> users = new ArrayList<>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();	
		getDataFromDB();
	}

	private void initialize()
	{
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(Color.WHITE);
		frmLogin.setBounds(100, 100, 354, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmLogin.setLocation(dim.width/2-frmLogin.getSize().width/2, dim.height/2-frmLogin.getSize().height/2);

		JPanel pnlHeader = new JPanel();
		pnlHeader.setBackground(Color.WHITE);
		pnlHeader.setBounds(10, 11, 318, 140);
		frmLogin.getContentPane().add(pnlHeader);
		pnlHeader.setLayout(null);

		lblImgLogo = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("/GoCarrotsLogo.png")).getImage();
		lblImgLogo.setIcon(new ImageIcon(image));
		lblImgLogo.setBounds(50,0, 254, 140);
		pnlHeader.add(lblImgLogo);

		JPanel pnlContent = new JPanel();
		pnlContent.setBackground(Color.WHITE);
		pnlContent.setBounds(10, 162, 318, 88);
		frmLogin.getContentPane().add(pnlContent);
		pnlContent.setLayout(null);

		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Arial", Font.PLAIN, 12));
		txtUserName.setBounds(75, 23, 105, 20);
		pnlContent.add(txtUserName);
		txtUserName.setColumns(10);

		JLabel lblUserName = new JLabel("Username");
		lblUserName.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUserName.setBounds(0, 25, 65, 17);
		pnlContent.add(lblUserName);

		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPassword.setBounds(0, 53, 65, 17);
		pnlContent.add(lblPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLogin.setBackground(Color.LIGHT_GRAY);
		btnLogin.setBounds(211, 51, 95, 20);
		pnlContent.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String pass = "";
				boolean isUser = false;
				for (int i=0;i<txtpasswordField.getPassword().length;++i){
					pass+=txtpasswordField.getPassword()[i];
				}
				if (txtpasswordField.getPassword().length!=0 && !txtUserName.getText().equals(null)){
					for (Users u : users){
						if (u.getUserName().equals(txtUserName.getText()) && u.getPass().equals(pass)){
							new MainMenuWindow();
							frmLogin.dispose();
							isUser=true;
						}
					}
					if (!isUser)
						JOptionPane.showMessageDialog(null, "Wrong! Username/Password!", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null, "Please Enter User Name And Password!", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});


		txtpasswordField = new JPasswordField();
		txtpasswordField.setFont(new Font("Arial", Font.PLAIN, 12));
		txtpasswordField.setBounds(75, 51, 105, 20);
		pnlContent.add(txtpasswordField);

		btnClear = new JButton("Clear");
		btnClear.setBackground(Color.LIGHT_GRAY);
		btnClear.setFont(new Font("Arial", Font.PLAIN, 12));
		btnClear.setBounds(211, 23, 95, 20);
		pnlContent.add(btnClear);
		btnClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtUserName.setText("");
				txtpasswordField.setText("");

			}
		});
	}

	private void getDataFromDB(){

		SendServer get = new SendServer();
		users = get.getUsers();

	}
}

