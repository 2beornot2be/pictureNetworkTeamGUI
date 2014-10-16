package gui.pictureNetwork.boot.Admin;

import gui.pictureNetwork.boot.tools.delegates.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.ldap.Rdn;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Admin;
import entities.Credit;
import entities.Model;
import entities.ModelState_Activation;
import entities.State;
import entities.User;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.BoxLayout;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.Dimension;

import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ButtonGroup;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;

import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class UserManagement extends JFrame {
	// AdminBusinessDelegate
	private JComboBox comboBoxAuthenticationType;
	private JPanel contentPane;
	
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldTel;
	private JPasswordField passwordField;
	private Context context;
	private Admin admin = null;
	private Model model = null;
	private JTextArea textAreaAddress;
	private JComboBox comboBoxState;
	
	private JComboBox comboBoxModelActivation;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnUsers;
	private JRadioButton rdbtnAdmins;
	private JRadioButton rdbtnModels;
	private int id;
	private JButton btnSubmit;
	private JLabel lblSignUp;
	private User user = null;
	
	private JLabel lblTestAuthentication;
	private JTextField textFieldAuthenticationFirst;
	private JTextField textFieldAuthenticationLast;
	private JPasswordField passwordFieldAuthentication;
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	private static UserManagement temp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final UserManagement frame = new UserManagement();
					temp = frame;
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	/**
	 * Create the frame.
	 */
	public UserManagement() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\4GL3 info A\\PIDEV\\sprint 1\\images\\icone.png"));
		setTitle("Users Management");
		setBackground(Color.BLUE);
		setMinimumSize(new Dimension(1124, 600));
		setSize(new Dimension(1124, 478));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 478);
		// menu 5.0
				menuBar = new JMenuBar();
				setJMenuBar(menuBar);
				
				JMenu mnManagement = new JMenu("Management");
				menuBar.add(mnManagement);
				
				JMenuItem mntmUsers = new JMenuItem("Users");
				mntmUsers.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new UserManagement().setVisible(true);
						Dispose();
						
						
						
					}
				});
				mnManagement.add(mntmUsers);
				
				JMenuItem mntmBadWord = new JMenuItem("Bad Words");
				mntmBadWord.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BadWordManagement bm = new BadWordManagement();
						bm.setVisible(true);
						Dispose();
						
					}
				});
				mnManagement.add(mntmBadWord);
				
				JMenuItem mntmEvent = new JMenuItem("Events");
				mntmEvent.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EventAdminFrame ef = new EventAdminFrame();
						ef.setVisible(true);
						Dispose();
						
					}
				});
				mnManagement.add(mntmEvent);
				
				JMenuItem mntmComments = new JMenuItem("Comments");
				mntmComments.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CommentAdminFrame cf = new CommentAdminFrame();
						cf.setVisible(true);
						Dispose();
						
					}
				});
				mnManagement.add(mntmComments);
				
				JMenuItem mntmCategories = new JMenuItem("Categories");
				mntmCategories.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CategoryManagement cm = new CategoryManagement();
						
						cm.setVisible(true);
						Dispose();
						
					}
				});
				mnManagement.add(mntmCategories);
				
				JMenuItem mntmSubCategories = new JMenuItem("Sub Categories");
				mntmSubCategories.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						SubCategoryManagement scm = new SubCategoryManagement();
						scm.setVisible(true);
						Dispose();
						
					}
				});
				mnManagement.add(mntmSubCategories);
				
				JMenuItem mntmPictures = new JMenuItem("Pictures");
				mntmPictures.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						PictureManagement pm = new PictureManagement();
						pm.setVisible(true);
						Dispose();
						
					}
				});
				mnManagement.add(mntmPictures);
				
				JMenuItem mntmLogout = new JMenuItem("Logout");
				mntmLogout.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AdminLoginFrame alf = new AdminLoginFrame();
						alf.setVisible(true);
						Dispose();
						
					}
				});
				mnManagement.add(mntmLogout);
				//fin menu 5.0
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setForeground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblFirstName = new JLabel("first name:");
		lblFirstName.setForeground(new Color(255, 255, 255));
		lblFirstName.setBounds(15, 196, 84, 14);
		lblFirstName.setFont(new Font("Arial", Font.PLAIN, 14));
		
		lblSignUp = new JLabel("Sign up");
		lblSignUp.setForeground(new Color(255, 255, 255));
		lblSignUp.setBounds(15, 156, 66, 29);
		lblSignUp.setFont(new Font("Arial", Font.BOLD, 17));
		
		JLabel lblLastName = new JLabel("last name:");
		lblLastName.setForeground(new Color(255, 255, 255));
		lblLastName.setBounds(15, 221, 84, 14);
		lblLastName.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setBounds(15, 246, 66, 14);
		lblAddress.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblTel = new JLabel("Tel:");
		lblTel.setForeground(new Color(255, 255, 255));
		lblTel.setBounds(15, 313, 46, 14);
		lblTel.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(15, 346, 66, 14);
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblAccountType = new JLabel("Account type:");
		lblAccountType.setForeground(new Color(255, 255, 255));
		lblAccountType.setBounds(15, 382, 96, 14);
		lblAccountType.setFont(new Font("Arial", Font.PLAIN, 14));
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setForeground(new Color(0, 153, 255));
		textFieldFirstName.setBounds(130, 186, 96, 20);
		textFieldFirstName.setColumns(10);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setForeground(new Color(0, 153, 255));
		textFieldLastName.setBounds(130, 215, 96, 20);
		textFieldLastName.setColumns(10);
		
		textAreaAddress = new JTextArea();
		textAreaAddress.setForeground(new Color(0, 153, 255));
		textAreaAddress.setBounds(130, 246, 96, 56);
		
		textFieldTel = new JTextField();
		textFieldTel.setForeground(new Color(0, 153, 255));
		textFieldTel.setBounds(130, 311, 96, 20);
		textFieldTel.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(0, 153, 255));
		passwordField.setBounds(130, 340, 96, 20);
		
		comboBoxState = new JComboBox();
		comboBoxState.setBounds(131, 380, 95, 20);
		comboBoxState.addItem(State.ADMIN.toString());
		comboBoxState.addItem(State.MODEL.toString());
		comboBoxState.addItem(State.USER.toString());
		
		btnSubmit = new JButton("Register");
		btnSubmit.setBackground(new Color(0, 153, 255));
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setBounds(145, 449, 89, 23);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnSubmit.getText() == "Register")
				{
					if(comboBoxState.getSelectedIndex() == 0)
					{
						admin = new Admin(textFieldLastName.getText(),textFieldFirstName.getText(), textAreaAddress.getText(), textFieldTel.getText(), passwordField.getText(), comboBoxState.getItemAt(comboBoxState.getSelectedIndex()).toString(), Credit.PICTURE_NETWORK_TEAM.toString());
						AdminBusinessDelegate.addAdmin(admin);
						rdbtnAdmins.setSelected(true);
						table.setModel(new UsersTableModel(State.ADMIN));
					}
					else if(comboBoxState.getSelectedIndex() == 1)
					{
						model = new Model(textFieldLastName.getText(),textFieldFirstName.getText(), textAreaAddress.getText(), textFieldTel.getText(), passwordField.getText(), comboBoxState.getItemAt(comboBoxState.getSelectedIndex()).toString(), Credit.FREE_USER.toString(), ModelState_Activation.ACTIVATED.toString());
						ModelBusinessDelegate.addModel(model);
						rdbtnModels.setSelected(true);
						table.setModel(new UsersTableModel(State.MODEL));
					}
					else if(comboBoxState.getSelectedIndex() == 2)
					{
						user = new User(textFieldLastName.getText(),textFieldFirstName.getText(), textAreaAddress.getText(), textFieldTel.getText(), passwordField.getText(), comboBoxState.getItemAt(comboBoxState.getSelectedIndex()).toString(), Credit.FREE_USER.toString());
						UserBusinessDelegate.addUser(user);
						rdbtnUsers.setSelected(true);
						table.setModel(new UsersTableModel(State.USER));
					}
				}
				else if(btnSubmit.getText() == "Update")
				{
					lblSignUp.setText("Sign up");
					if(comboBoxState.getSelectedIndex() == 0)
					{
						admin.setLastName(textFieldLastName.getText());
						admin.setFirstName(textFieldFirstName.getText());
						admin.setAddress(textAreaAddress.getText());
						admin.setTel(textFieldTel.getText());
						  
						admin.setPassword(passwordField.getText());
						
						AdminBusinessDelegate.updateAdmin(admin);
						table.setModel(new UsersTableModel(State.ADMIN));
						btnSubmit.setText("Register");
						comboBoxState.enable(true);
						comboBoxModelActivation.enable(true);
						
					}
					else if(comboBoxState.getSelectedIndex() == 1)
					{
						model.setLastName(textFieldLastName.getText());
						model.setFirstName(textFieldFirstName.getText());
						model.setAddress(textAreaAddress.getText());
						model.setTel(textFieldTel.getText());
						  
						model.setPassword(passwordField.getText());
						String activation = comboBoxModelActivation.getSelectedIndex() == 0 ? ModelState_Activation.ACTIVATED.toString() : ModelState_Activation.DESACTIVATED.toString();
						model.setModelState_Activation(activation);
						ModelBusinessDelegate.updateModel(model);
						table.setModel(new UsersTableModel(State.MODEL));
						btnSubmit.setText("Register");
						comboBoxState.enable(true);
						comboBoxModelActivation.enable(true);
					}
					else if(comboBoxState.getSelectedIndex() == 2)
					{
						user.setLastName(textFieldLastName.getText());
						user.setFirstName(textFieldFirstName.getText());
						user.setAddress(textAreaAddress.getText());
						user.setTel(textFieldTel.getText());
						  
						user.setPassword(passwordField.getText());
						
						UserBusinessDelegate.updateUser(user);
						table.setModel(new UsersTableModel(State.USER));
						btnSubmit.setText("Register");
						comboBoxState.enable(true);
						comboBoxModelActivation.enable(true);
					}
				}
					
				
			}
		});
		
		JButton btnDefaultAdmin = new JButton("Default Admin");
		btnDefaultAdmin.setBackground(new Color(0, 153, 255));
		btnDefaultAdmin.setForeground(new Color(255, 255, 255));
		btnDefaultAdmin.setBounds(15, 64, 128, 23);
		btnDefaultAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String lastName = "admin";
				String firstName = "admin";
				final String address = "manar 3";
				String tel = "20747198";
				String password = "admin";
				int stateIndex = 0;
				textFieldFirstName.setText(firstName);
				textFieldLastName.setText(lastName);
				textAreaAddress.setText(address);
				textFieldTel.setText(tel);
				passwordField.setText(password);
				comboBoxState.setSelectedIndex(stateIndex);
			}
		});
		
		JButton btnDefaultModel = new JButton("Default Model");
		btnDefaultModel.setBackground(new Color(0, 153, 255));
		btnDefaultModel.setForeground(new Color(255, 255, 255));
		btnDefaultModel.setBounds(15, 98, 128, 23);
		btnDefaultModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lastName = "model";
				String firstName = "model";
				final String address = "manar 1";
				String tel = "21495393";
				String password = "model";
				int stateIndex = 1;
				textFieldFirstName.setText(firstName);
				textFieldLastName.setText(lastName);
				textAreaAddress.setText(address);
				textFieldTel.setText(tel);
				passwordField.setText(password);
				comboBoxState.setSelectedIndex(stateIndex);
			}
		});
		
		JLabel lblModelActivation = new JLabel("Model Activation");
		lblModelActivation.setForeground(new Color(255, 255, 255));
		lblModelActivation.setBounds(15, 414, 110, 14);
		lblModelActivation.setFont(new Font("Arial", Font.PLAIN, 14));
		
		comboBoxModelActivation = new JComboBox();
		comboBoxModelActivation.setBounds(130, 411, 112, 20);
		comboBoxModelActivation.addItem(ModelState_Activation.ACTIVATED.toString());
		comboBoxModelActivation.addItem(ModelState_Activation.DESACTIVATED.toString());
		
		JPanel panel = new JPanel();
		panel.setBounds(260, 202, 826, 335);
		panel.setAutoscrolls(true);
		
		JLabel lblView = new JLabel("View:");
		lblView.setForeground(new Color(255, 255, 255));
		lblView.setBounds(290, 181, 46, 14);
		
		rdbtnUsers = new JRadioButton("All Users");
		rdbtnUsers.setBackground(new Color(0, 153, 255));
		rdbtnUsers.setForeground(new Color(255, 255, 255));
		rdbtnUsers.setBounds(342, 177, 109, 23);
		buttonGroup.add(rdbtnUsers);
		rdbtnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new UsersTableModel(State.USER));
			}
		});
		
		rdbtnAdmins = new JRadioButton("Admins");
		rdbtnAdmins.setBackground(new Color(0, 153, 255));
		rdbtnAdmins.setForeground(new Color(255, 255, 255));
		rdbtnAdmins.setBounds(461, 177, 96, 23);
		buttonGroup.add(rdbtnAdmins);
		rdbtnAdmins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new UsersTableModel(State.ADMIN));
			}
		});
		
		rdbtnModels = new JRadioButton("Models");
		rdbtnModels.setBackground(new Color(0, 153, 255));
		rdbtnModels.setForeground(new Color(255, 255, 255));
		rdbtnModels.setBounds(610, 177, 110, 23);
		buttonGroup.add(rdbtnModels);
		rdbtnModels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new UsersTableModel(State.MODEL));
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(0, 153, 255));
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBounds(145, 490, 89, 23);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() >= 0)
				{
					if(rdbtnModels.isSelected())
					{
						model = ModelBusinessDelegate.findModel(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
						id = model.getId();
						ModelBusinessDelegate.removeModel(model);
						table.setModel(new UsersTableModel(State.MODEL));
					}
					if(rdbtnAdmins.isSelected())
					{
						admin = AdminBusinessDelegate.findAdmin(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
						id = admin.getId();
						AdminBusinessDelegate.removeAdmin(admin);
						table.setModel(new UsersTableModel(State.ADMIN));
					}
					if(rdbtnUsers.isSelected())
					{
						String type = table.getValueAt(table.getSelectedRow(), 4).toString();
						if(type.equals(State.USER.toString()) )
						{
							user = UserBusinessDelegate.findUser(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
							UserBusinessDelegate.removeUser(user);
							table.setModel(new UsersTableModel(State.USER));
							
						}
						else if(type.equals(State.MODEL.toString()) )
						{
							model = ModelBusinessDelegate.findModel(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
							ModelBusinessDelegate.removeModel(model);
							table.setModel(new UsersTableModel(State.USER));
						}
						else if( type.equals(State.ADMIN.toString()) )
						{
							admin = AdminBusinessDelegate.findAdmin(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
							AdminBusinessDelegate.removeAdmin(admin);
							table.setModel(new UsersTableModel(State.USER));
						}
					
					}
					btnSubmit.setText("Register");
					comboBoxModelActivation.enable(true);
					comboBoxState.enable(true);
				
				}
			}
			});
		
		
		JButton btnDefaultUser = new JButton("Default User");
		btnDefaultUser.setBackground(new Color(0, 153, 255));
		btnDefaultUser.setForeground(new Color(255, 255, 255));
		btnDefaultUser.setBounds(15, 127, 128, 23);
		btnDefaultUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lastName = "user";
				String firstName = "user";
				final String address = "marsa";
				String tel = "98320705";
				String password = "user";
				int stateIndex = 2;
				
				textFieldFirstName.setText(firstName);
				textFieldLastName.setText(lastName);
				textAreaAddress.setText(address);
				textFieldTel.setText(tel);
				passwordField.setText(password);
				comboBoxState.setSelectedIndex(stateIndex);
			}
		});
		
		lblTestAuthentication = new JLabel("Test authentication:");
		lblTestAuthentication.setForeground(new Color(255, 255, 255));
		lblTestAuthentication.setBounds(290, 102, 130, 14);
		
		JLabel label = new JLabel("first name:");
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(428, 33, 84, 17);
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel label_1 = new JLabel("last name:");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setBounds(428, 70, 84, 17);
		label_1.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("Password:");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setBounds(430, 100, 66, 17);
		label_2.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel label_3 = new JLabel("Account type:");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setBounds(430, 129, 96, 17);
		label_3.setFont(new Font("Arial", Font.PLAIN, 14));
		
		comboBoxAuthenticationType = new JComboBox();
		comboBoxAuthenticationType.setBounds(555, 125, 114, 20);
		comboBoxAuthenticationType.addItem(State.ADMIN.toString());
		comboBoxAuthenticationType.addItem(State.MODEL.toString());
		comboBoxAuthenticationType.addItem(State.USER.toString());
		
		textFieldAuthenticationFirst = new JTextField();
		textFieldAuthenticationFirst.setForeground(new Color(0, 153, 255));
		textFieldAuthenticationFirst.setBounds(555, 32, 114, 20);
		textFieldAuthenticationFirst.setColumns(10);
		
		textFieldAuthenticationLast = new JTextField();
		textFieldAuthenticationLast.setForeground(new Color(0, 153, 255));
		textFieldAuthenticationLast.setBounds(555, 63, 114, 20);
		textFieldAuthenticationLast.setColumns(10);
		
		passwordFieldAuthentication = new JPasswordField();
		passwordFieldAuthentication.setForeground(new Color(0, 153, 255));
		passwordFieldAuthentication.setBounds(555, 94, 114, 20);
		
		JButton btnNewButton = new JButton("Test Authentication");
		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(699, 75, 161, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String success = "authentication succeded";
				String failure = "authentication failed";
				String desactivated =  failure + ", your account has been desactivated";
				switch(comboBoxAuthenticationType.getSelectedIndex())
				{
					
					case 1:
						Model model_test = ModelBusinessDelegate.authenticateModel(textFieldAuthenticationFirst.getText(), textFieldAuthenticationLast.getText(), passwordFieldAuthentication.getText());
						if(model_test == null )
						{
							JOptionPane.showMessageDialog(null, failure );
						}
						else if(model_test.getModelState_Activation() == ModelState_Activation.DESACTIVATED.toString())
						{
							JOptionPane.showMessageDialog(null, desactivated );
						}
						else
						{
							JOptionPane.showMessageDialog(null, success );
						}
						break;
					case 0:
						Admin admin_test = AdminBusinessDelegate.authenticateAdmin(textFieldAuthenticationFirst.getText(), textFieldAuthenticationLast.getText(), passwordFieldAuthentication.getText());
						if(admin_test == null)
						{
							JOptionPane.showMessageDialog(null, failure );
						}
						else
						{
							JOptionPane.showMessageDialog(null, success );
						}
						break;
					case 2:
						User user_test = UserBusinessDelegate.authenticateUser(textFieldAuthenticationFirst.getText(), textFieldAuthenticationLast.getText(), passwordFieldAuthentication.getText());
						if(user_test == null)
						{
							JOptionPane.showMessageDialog(null, failure );
						}
						else
						{
							JOptionPane.showMessageDialog(null, success );
						}
						break;
				}
			    
			}
		});
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 818, 335);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 153, 255));
		scrollPane.setViewportView(table);
		table.setModel(new UsersTableModel(State.USER));
		table.setFillsViewportHeight(true);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRow() >= 0)
				{
					lblSignUp.setText("Update");
					if(rdbtnModels.isSelected())
					{
						model = ModelBusinessDelegate.findModel(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
						textFieldAuthenticationFirst.setText(model.getFirstName());
						textFieldAuthenticationLast.setText(model.getLastName());
						passwordFieldAuthentication.setText(model.getPassword());
						comboBoxAuthenticationType.setSelectedIndex(1);
						
						
						id = model.getId();
						textFieldFirstName.setText(model.getFirstName());
						textFieldLastName.setText(model.getLastName());
						textAreaAddress.setText(model.getAddress());
						textFieldTel.setText(model.getTel());
						passwordField.setText(model.getPassword());
						comboBoxState.setSelectedIndex(1);
						comboBoxState.enable(false);
						
						int index = model.getModelState_Activation() == ModelState_Activation.ACTIVATED.toString() ? 0 : 1;
						comboBoxModelActivation.setEnabled(true);
						comboBoxModelActivation.setSelectedIndex(index);
						btnSubmit.setText("Update");
					}
					else if( rdbtnAdmins.isSelected())
					{
						admin = AdminBusinessDelegate.findAdmin(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
						textFieldAuthenticationFirst.setText(admin.getFirstName());
						textFieldAuthenticationLast.setText(admin.getLastName());
						passwordFieldAuthentication.setText(admin.getPassword());
						comboBoxAuthenticationType.setSelectedIndex(0);
						
						id = admin.getId();
						textFieldFirstName.setText(admin.getFirstName());
						textFieldLastName.setText(admin.getLastName());
						textAreaAddress.setText(admin.getAddress());
						textFieldTel.setText(admin.getTel());
						passwordField.setText(admin.getPassword());
						comboBoxState.setSelectedIndex(0);
						comboBoxState.enable(false);
						comboBoxModelActivation.enable(false);
						
						btnSubmit.setText("Update");
					}
					else if(rdbtnUsers.isSelected())
					{
						String type = table.getValueAt(table.getSelectedRow(), 4).toString();
						if(type.equals(State.USER.toString()) )
						{
							user = UserBusinessDelegate.findUser(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
							textFieldAuthenticationFirst.setText(user.getFirstName());
							textFieldAuthenticationLast.setText(user.getLastName());
							passwordFieldAuthentication.setText(user.getPassword());
							comboBoxAuthenticationType.setSelectedIndex(2);
							
							id = user.getId();
							textFieldFirstName.setText(user.getFirstName());
							textFieldLastName.setText(user.getLastName());
							textAreaAddress.setText(user.getAddress());
							textFieldTel.setText(user.getTel());
							passwordField.setText(user.getPassword());
							comboBoxState.setSelectedIndex(2);
							comboBoxState.enable(false);
							comboBoxModelActivation.setEnabled(false);
							
							btnSubmit.setText("Update");
							
						}
						else if(type.equals(State.MODEL.toString()) )
						{
							model = ModelBusinessDelegate.findModel(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
							textFieldAuthenticationFirst.setText(model.getFirstName());
							textFieldAuthenticationLast.setText(model.getLastName());
							passwordFieldAuthentication.setText(model.getPassword());
							comboBoxAuthenticationType.setSelectedIndex(1);
							
							
							id = model.getId();
							textFieldFirstName.setText(model.getFirstName());
							textFieldLastName.setText(model.getLastName());
							textAreaAddress.setText(model.getAddress());
							textFieldTel.setText(model.getTel());
							passwordField.setText(model.getPassword());
							comboBoxState.setSelectedIndex(1);
							comboBoxState.enable(false);
							int index = model.getModelState_Activation() == ModelState_Activation.ACTIVATED.toString() ? 0 : 1;
							comboBoxModelActivation.setSelectedIndex(index);
							comboBoxModelActivation.setEnabled(true);
							btnSubmit.setText("Update");
						}
						else if( type.equals(State.ADMIN.toString()) )
						{
							admin = AdminBusinessDelegate.findAdmin(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
							textFieldAuthenticationFirst.setText(admin.getFirstName());
							textFieldAuthenticationLast.setText(admin.getLastName());
							passwordFieldAuthentication.setText(admin.getPassword());
							comboBoxAuthenticationType.setSelectedIndex(0);
							
							id = admin.getId();
							textFieldFirstName.setText(admin.getFirstName());
							textFieldLastName.setText(admin.getLastName());
							textAreaAddress.setText(admin.getAddress());
							textFieldTel.setText(admin.getTel());
							passwordField.setText(admin.getPassword());
							comboBoxState.setSelectedIndex(0);
							comboBoxState.enable(false);
							comboBoxModelActivation.setEnabled(false);
							
							btnSubmit.setText("Update");
						}
					}
				}
			
			}
		});
		table.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(table.getSelectedRow() >= 0)
				{
					lblSignUp.setText("Update");
					if(rdbtnModels.isSelected())
					{
						model = ModelBusinessDelegate.findModel(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
						textFieldAuthenticationFirst.setText(model.getFirstName());
						textFieldAuthenticationLast.setText(model.getLastName());
						passwordFieldAuthentication.setText(model.getPassword());
						comboBoxAuthenticationType.setSelectedIndex(1);
						
						
						id = model.getId();
						textFieldFirstName.setText(model.getFirstName());
						textFieldLastName.setText(model.getLastName());
						textAreaAddress.setText(model.getAddress());
						textFieldTel.setText(model.getTel());
						passwordField.setText(model.getPassword());
						comboBoxState.setSelectedIndex(1);
						comboBoxState.enable(false);
						
						int index = model.getModelState_Activation() == ModelState_Activation.ACTIVATED.toString() ? 0 : 1;
						comboBoxModelActivation.setEnabled(true);
						comboBoxModelActivation.setSelectedIndex(index);
						btnSubmit.setText("Update");
					}
					else if( rdbtnAdmins.isSelected())
					{
						admin = AdminBusinessDelegate.findAdmin(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
						textFieldAuthenticationFirst.setText(admin.getFirstName());
						textFieldAuthenticationLast.setText(admin.getLastName());
						passwordFieldAuthentication.setText(admin.getPassword());
						comboBoxAuthenticationType.setSelectedIndex(0);
						
						id = admin.getId();
						textFieldFirstName.setText(admin.getFirstName());
						textFieldLastName.setText(admin.getLastName());
						textAreaAddress.setText(admin.getAddress());
						textFieldTel.setText(admin.getTel());
						passwordField.setText(admin.getPassword());
						comboBoxState.setSelectedIndex(0);
						comboBoxState.enable(false);
						comboBoxModelActivation.enable(false);
						
						btnSubmit.setText("Update");
					}
					else if(rdbtnUsers.isSelected())
					{
						String type = table.getValueAt(table.getSelectedRow(), 4).toString();
						if(type.equals(State.USER.toString()) )
						{
							user = UserBusinessDelegate.findUser(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
							textFieldAuthenticationFirst.setText(user.getFirstName());
							textFieldAuthenticationLast.setText(user.getLastName());
							passwordFieldAuthentication.setText(user.getPassword());
							comboBoxAuthenticationType.setSelectedIndex(2);
							
							id = user.getId();
							textFieldFirstName.setText(user.getFirstName());
							textFieldLastName.setText(user.getLastName());
							textAreaAddress.setText(user.getAddress());
							textFieldTel.setText(user.getTel());
							passwordField.setText(user.getPassword());
							comboBoxState.setSelectedIndex(2);
							comboBoxState.enable(false);
							comboBoxModelActivation.setEnabled(false);
							
							btnSubmit.setText("Update");
							
						}
						else if(type.equals(State.MODEL.toString()) )
						{
							model = ModelBusinessDelegate.findModel(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
							textFieldAuthenticationFirst.setText(model.getFirstName());
							textFieldAuthenticationLast.setText(model.getLastName());
							passwordFieldAuthentication.setText(model.getPassword());
							comboBoxAuthenticationType.setSelectedIndex(1);
							
							
							id = model.getId();
							textFieldFirstName.setText(model.getFirstName());
							textFieldLastName.setText(model.getLastName());
							textAreaAddress.setText(model.getAddress());
							textFieldTel.setText(model.getTel());
							passwordField.setText(model.getPassword());
							comboBoxState.setSelectedIndex(1);
							comboBoxState.enable(false);
							int index = model.getModelState_Activation() == ModelState_Activation.ACTIVATED.toString() ? 0 : 1;
							comboBoxModelActivation.setSelectedIndex(index);
							comboBoxModelActivation.setEnabled(true);
							btnSubmit.setText("Update");
						}
						else if( type.equals(State.ADMIN.toString()) )
						{
							admin = AdminBusinessDelegate.findAdmin(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
							textFieldAuthenticationFirst.setText(admin.getFirstName());
							textFieldAuthenticationLast.setText(admin.getLastName());
							passwordFieldAuthentication.setText(admin.getPassword());
							comboBoxAuthenticationType.setSelectedIndex(0);
							
							id = admin.getId();
							textFieldFirstName.setText(admin.getFirstName());
							textFieldLastName.setText(admin.getLastName());
							textAreaAddress.setText(admin.getAddress());
							textFieldTel.setText(admin.getTel());
							passwordField.setText(admin.getPassword());
							comboBoxState.setSelectedIndex(0);
							comboBoxState.enable(false);
							comboBoxModelActivation.setEnabled(false);
							
							btnSubmit.setText("Update");
						}
					}
				
				}
			
			}
		});
		table.setModel(new UsersTableModel(State.USER));
		
		
		rdbtnUsers.setSelected(true);
		contentPane.setLayout(null);
		contentPane.add(btnDefaultModel);
		contentPane.add(lblSignUp);
		contentPane.add(lblFirstName);
		contentPane.add(textFieldFirstName);
		contentPane.add(lblLastName);
		contentPane.add(textFieldLastName);
		contentPane.add(lblAddress);
		contentPane.add(textAreaAddress);
		contentPane.add(lblTel);
		contentPane.add(textFieldTel);
		contentPane.add(lblPassword);
		contentPane.add(passwordField);
		contentPane.add(lblAccountType);
		contentPane.add(comboBoxState);
		contentPane.add(lblModelActivation);
		contentPane.add(comboBoxModelActivation);
		contentPane.add(btnDelete);
		contentPane.add(btnSubmit);
		contentPane.add(btnDefaultUser);
		contentPane.add(panel);
		contentPane.add(lblView);
		contentPane.add(rdbtnUsers);
		contentPane.add(rdbtnAdmins);
		contentPane.add(rdbtnModels);
		contentPane.add(lblTestAuthentication);
		contentPane.add(label_2);
		contentPane.add(label_3);
		contentPane.add(comboBoxAuthenticationType);
		contentPane.add(passwordFieldAuthentication);
		contentPane.add(textFieldAuthenticationFirst);
		contentPane.add(textFieldAuthenticationLast);
		contentPane.add(btnNewButton);
		contentPane.add(label_1);
		contentPane.add(btnDefaultAdmin);
		contentPane.add(label);
		}



	protected void Dispose() {
		// TODO Auto-generated method stub
		this.dispose();
	}
	}

	
	

	

