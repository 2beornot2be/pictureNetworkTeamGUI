package gui.pictureNetwork.boot.Admin;

import entities.Admin;
import entities.Comment;
import gui.pictureNetwork.boot.tools.delegates.AdminBusinessDelegate;
import gui.pictureNetwork.boot.tools.delegates.CommentAdminBusinessDelegate;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;

import java.awt.FlowLayout;

import javax.swing.JScrollPane;

import java.awt.Cursor;

import javax.swing.ScrollPaneConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class CommentAdminFrame extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxAdmin;
	private JButton btnAdd;
	private JTextArea textAreaContent;
	private JTable table;
	private JScrollPane scrollPane;
	private Comment comment;
	private JLabel lblAddComment;
	private JButton btnDelete;
	private static CommentAdminFrame frame ;
	private JMenuBar menuBar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CommentAdminFrame();
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
	public CommentAdminFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\4GL3 info A\\PIDEV\\sprint 1\\images\\icone.png"));
		setTitle("Picture Network Team Comments Management");
		setMinimumSize(new Dimension(1300, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAddComment = new JLabel("Add Comment:");
		lblAddComment.setForeground(new Color(255, 255, 255));
		lblAddComment.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddComment.setBounds(10, 26, 250, 30);
		contentPane.add(lblAddComment);
		
		JLabel lblContent = new JLabel("Content:");
		lblContent.setForeground(new Color(255, 255, 255));
		lblContent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContent.setBounds(10, 67, 76, 14);
		contentPane.add(lblContent);
		
		JLabel lblAdmin = new JLabel("Admin: ");
		lblAdmin.setForeground(new Color(255, 255, 255));
		lblAdmin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdmin.setBounds(10, 188, 62, 14);
		contentPane.add(lblAdmin);
		
		comboBoxAdmin = new JComboBox();
		comboBoxAdmin.setBackground(new Color(0, 153, 255));
		comboBoxAdmin.setForeground(new Color(255, 255, 255));
		comboBoxAdmin.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				refreshComboboxAdmins();
				
			}
		});
		comboBoxAdmin.setBounds(91, 187, 141, 20);
		contentPane.add(comboBoxAdmin);
		
		textAreaContent = new JTextArea();
		textAreaContent.setForeground(new Color(0, 153, 255));
		textAreaContent.setBounds(91, 64, 141, 112);
		contentPane.add(textAreaContent);
		
		btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(0, 153, 255));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnAdd.getText().equals("Add"))
				{
					Comment c = new Comment(textAreaContent.getText(), new Date(), new Date(), (Admin) comboBoxAdmin.getSelectedItem(), ((Admin) comboBoxAdmin.getSelectedItem()).getCredit());
					CommentAdminBusinessDelegate.addComment(c);
				}
				else
				{
					comment.setContent(textAreaContent.getText());
					comment.setSender((Admin)comboBoxAdmin.getSelectedItem());
					comment.setDateModified(new Date());
					CommentAdminBusinessDelegate.updateComment(comment);
					btnAdd.setText(btnAdd.getText().replace("Update" ,"Add"));
					lblAddComment.setText(lblAddComment.getText().replace("Update","Add"));
				}
				
				table.setModel(new CommentAdminTableModel());
			}
		});
		btnAdd.setBounds(10, 247, 89, 23);
		contentPane.add(btnAdd);
		
		JPanel panel = new JPanel();
		panel.setBounds(326, 26, 948, 244);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane.setBounds(0, 0, 938, 244);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 153, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRowCount() >= 1)
				{
					comment = CommentAdminBusinessDelegate.findComment(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
					textAreaContent.setText(comment.getContent());
					refreshComboboxAdmins();
					for(int i = 0; i < comboBoxAdmin.getItemCount(); i++)
					{
						if(comment.getSender().toString().equals(comboBoxAdmin.getItemAt(i).toString()))
						{
							comboBoxAdmin.setSelectedIndex(i);
							break;
						}
					}
					btnAdd.setText(btnAdd.getText().replace("Add", "Update"));
					lblAddComment.setText(lblAddComment.getText().replace("Add","Update"));
				}
			}
		});
		table.setModel(new CommentAdminTableModel());
		scrollPane.setViewportView(table);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(0, 153, 255));
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comment c = CommentAdminBusinessDelegate.findComment(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
				CommentAdminBusinessDelegate.removeComment(c);
				table.setModel(new CommentAdminTableModel());
			}
		});
		btnDelete.setBounds(143, 247, 89, 23);
		contentPane.add(btnDelete);
	}

	protected void Dispose() {
		this.dispose();
		
	}

	protected void refreshComboboxAdmins() {
		comboBoxAdmin.removeAllItems();
		List<Admin> admins = AdminBusinessDelegate.findAllAdmins();
		for(Admin a : admins)
		{
			comboBoxAdmin.addItem(a);
		}
		
	}
}
