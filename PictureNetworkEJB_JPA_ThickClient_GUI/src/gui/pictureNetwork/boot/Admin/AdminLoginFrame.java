package gui.pictureNetwork.boot.Admin;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import entities.Admin;
import gui.pictureNetwork.boot.tools.delegates.AdminBusinessDelegate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.SystemColor;

import javax.swing.UIManager;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import javax.swing.JMenuBar;
import java.awt.Toolkit;
import java.awt.Cursor;
import javax.swing.border.LineBorder;

public class AdminLoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JPasswordField passwordField;
	private JLabel lblAuthentication;
	private static AdminLoginFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminLoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private Admin admin;
	
	
	/**
	 * Create the frame.
	 */
	public AdminLoginFrame() {
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setForeground(new Color(0, 153, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\4GL3 info A\\PIDEV\\sprint 1\\images\\icone.png"));
		try {
		
			
			Admin nemesis = new Admin("nemesis", "hades", "manar 3","20747198", "subzero666", "", null);
			AdminBusinessDelegate.addAdmin(nemesis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 504);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("first name:");
		lblFirstName.setForeground(new Color(255, 255, 255));
		lblFirstName.setBounds(151, 239, 68, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("last name:");
		lblLastName.setForeground(new Color(255, 255, 255));
		lblLastName.setBounds(151, 275, 68, 14);
		contentPane.add(lblLastName);
		
		JLabel lblPassword = new JLabel("password:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(151, 317, 68, 14);
		contentPane.add(lblPassword);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		textFieldFirstName.setForeground(new Color(0, 153, 255));
		textFieldFirstName.setBounds(224, 236, 86, 20);
		contentPane.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		textFieldLastName.setForeground(new Color(0, 153, 255));
		textFieldLastName.setColumns(10);
		textFieldLastName.setBounds(224, 272, 86, 20);
		contentPane.add(textFieldLastName);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		passwordField.setForeground(new Color(0, 153, 255));
		passwordField.setBounds(224, 314, 86, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		btnLogin.setBackground(new Color(0, 153, 255));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin = AdminBusinessDelegate.authenticateAdmin(textFieldFirstName.getText(), textFieldLastName.getText(), passwordField.getText());
				boolean authenticated = false;
				if(admin != null)
				{
					
					authenticated = true;
					lblAuthentication.setForeground(Color.green);
					lblAuthentication.setText("authentication success");
					lblAuthentication.setVisible(true);
					UserManagement userManagementFrame = new UserManagement();
					
					userManagementFrame.show();
					userManagementFrame.setVisible(true);
					frame.dispose();
				}
				else
				{
					lblAuthentication.setForeground(Color.red);
					lblAuthentication.setText("authentication failure");
					lblAuthentication.setVisible(true);
				}
				System.out.println("authentication " + (authenticated == true ? "success" : "failure"));
			}
		});
		btnLogin.setBounds(184, 367, 89, 23);
		contentPane.add(btnLogin);
		//Admin nemesis = new Admin("nemesis", "hades", "manar 3","20747198", "subzero666", "", null);
		textFieldFirstName.setText("hades");
		textFieldLastName.setText("nemesis");
		passwordField.setText("subzero666");
		
		lblAuthentication = new JLabel("authentication failure");
		lblAuthentication.setVisible(false);
		lblAuthentication.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthentication.setForeground(Color.RED);
		lblAuthentication.setBounds(127, 415, 235, 14);
		contentPane.add(lblAuthentication);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("D:\\4GL3 info A\\PIDEV\\sprint 1\\images\\logo.jpg"));
		label.setBounds(95, 0, 304, 203);
		contentPane.add(label);
	}
	public Color getContentPaneBackground() {
		return contentPane.getBackground();
	}
	public void setContentPaneBackground(Color background) {
		contentPane.setBackground(background);
	}
}
