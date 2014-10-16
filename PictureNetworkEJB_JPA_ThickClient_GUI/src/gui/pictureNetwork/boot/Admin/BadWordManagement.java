package gui.pictureNetwork.boot.Admin;

import entities.BadWorld;
import gui.pictureNetwork.boot.tools.delegates.BadwordBusinessDelegate;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.ScrollPane;

import javax.swing.JTable;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

import java.awt.Toolkit;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;

public class BadWordManagement extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldBadWord;
	private JTable table;
	private BadWorld badword;
	private JLabel lblInsert;
	private JButton btnInsert;
	private JTextField textFieldToValidate;
	private JScrollPane scrollPane;
	private static BadWordManagement temp;
	private JMenuBar menuBar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BadWordManagement frame = new BadWordManagement();
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
	public BadWordManagement() {
		setBackground(new Color(0, 153, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\4GL3 info A\\PIDEV\\sprint 1\\images\\icone.png"));
		setTitle("Bad Word Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 402);
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
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setForeground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblInsert = new JLabel("Insert Bad Word");
		lblInsert.setForeground(new Color(255, 255, 255));
		lblInsert.setBounds(10, 57, 138, 14);
		contentPane.add(lblInsert);
		
		JLabel lblDescription = new JLabel("Bad word: ");
		lblDescription.setForeground(new Color(255, 255, 255));
		lblDescription.setBounds(10, 93, 79, 14);
		contentPane.add(lblDescription);
		
		textFieldBadWord = new JTextField();
		textFieldBadWord.setForeground(new Color(0, 153, 255));
		textFieldBadWord.setBounds(107, 90, 79, 20);
		contentPane.add(textFieldBadWord);
		textFieldBadWord.setColumns(10);
		
		btnInsert = new JButton("Insert");
		btnInsert.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		btnInsert.setBackground(new Color(0, 153, 255));
		btnInsert.setForeground(new Color(255, 255, 255));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnInsert.getText() == "Insert")
				{
					BadWorld b = new BadWorld(textFieldBadWord.getText());
					BadwordBusinessDelegate.addBadWord(b);
					table.setModel(new BadwordTableModel() );
				}
				else 
				{
					badword.setDescription(textFieldBadWord.getText());
					boolean ok = BadwordBusinessDelegate.updateBadWord(badword);
					System.out.println(ok);
					table.setModel(new BadwordTableModel() );
					String lblText = lblInsert.getText().replace("Update","Insert" );
					lblInsert.setText(lblText);
					btnInsert.setText("Insert");
				}
				
			}
		});
		btnInsert.setBounds(10, 121, 89, 23);
		contentPane.add(btnInsert);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(0, 153, 255));
		panel.setAutoscrolls(true);
		panel.setBounds(266, 40, 322, 148);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(0, 5, 322, 143);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 153, 255));
		BadwordBusinessDelegate.addBadWord(new BadWorld("bitch"));
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRowCount() != 0)
				{
					String lblText = lblInsert.getText().replace("Insert", "Update");
					lblInsert.setText(lblText);
					btnInsert.setText("Update");
					badword = (BadWorld) BadwordBusinessDelegate.findBadWord(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
					System.out.println(badword.getId());
					textFieldBadWord.setText(badword.getDescription());
				}
				
			}
		});
		
		table.setBackground(new Color(255, 255, 255));
		table.setModel(new BadwordTableModel());
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		btnDelete.setBackground(new Color(0, 153, 255));
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRowCount() != 0)
				{
					badword = (BadWorld) BadwordBusinessDelegate.findBadWord(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
					BadwordBusinessDelegate.removeBadWord(badword);
					table.setModel(new BadwordTableModel() );
					String lblText = lblInsert.getText().replace("Update","Insert" );
					lblInsert.setText(lblText);
					btnInsert.setText("Insert");
					textFieldBadWord.setText("");
				}
			}
		});
		btnDelete.setBounds(10, 155, 89, 23);
		contentPane.add(btnDelete);
		
		JLabel lblValidateMessage = new JLabel("Validate Message");
		lblValidateMessage.setForeground(new Color(255, 255, 255));
		lblValidateMessage.setBounds(266, 210, 138, 14);
		contentPane.add(lblValidateMessage);
		
		textFieldToValidate = new JTextField();
		textFieldToValidate.setForeground(new Color(0, 153, 255));
		textFieldToValidate.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldToValidate.setBounds(269, 235, 190, 77);
		contentPane.add(textFieldToValidate);
		textFieldToValidate.setColumns(10);
		
		JButton btnValidate = new JButton("Validate");
		btnValidate.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		btnValidate.setBackground(new Color(0, 153, 255));
		btnValidate.setForeground(new Color(255, 255, 255));
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = textFieldToValidate.getText().trim();
				boolean ok = BadwordBusinessDelegate.valider(message);
				
				
				if(ok)
				{
					String result = "The message does not contain bad words";
					JOptionPane messageResult = new JOptionPane(result, JOptionPane.INFORMATION_MESSAGE);
					messageResult.showMessageDialog(null, result);
					
					
					
				}
				else
				{
					String result = "The message contains bad words";
					JOptionPane messageResult = new JOptionPane(result, JOptionPane.ERROR_MESSAGE);
					messageResult.showMessageDialog(null, result);
					
				}
				
			}
		});
		btnValidate.setBounds(323, 316, 89, 23);
		contentPane.add(btnValidate);
		
	}

	protected void Dispose() {
		// TODO Auto-generated method stub
		this.dispose();
	}
}
