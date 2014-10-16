package gui.pictureNetwork.boot.Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;

import entities.Category;
import gui.pictureNetwork.boot.tools.delegates.CategoryBusinessDelegate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;

import java.awt.ComponentOrientation;

import javax.swing.ScrollPaneConstants;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class CategoryManagement extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTable table;
	private Category category;
	private JLabel lblAddCategory;
	private JButton btnAdd;
	private JScrollPane scrollPane;
	private static CategoryManagement frame;
	private JMenuBar menuBar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CategoryManagement();
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
	public CategoryManagement() {
		setBackground(new Color(0, 153, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\4GL3 info A\\PIDEV\\sprint 1\\images\\icone.png"));
		setTitle("Categories Management");
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAddCategory = new JLabel("Add category");
		lblAddCategory.setForeground(new Color(255, 255, 255));
		lblAddCategory.setBounds(10, 27, 127, 14);
		contentPane.add(lblAddCategory);
		
		JLabel lblName = new JLabel("name: ");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setBounds(20, 52, 55, 14);
		contentPane.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setForeground(new Color(0, 153, 255));
		textFieldName.setBounds(74, 49, 86, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		btnAdd.setBackground(new Color(0, 153, 255));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnAdd.getText().equals("Add"))
				{
					Category c = new Category(textFieldName.getText());
					CategoryBusinessDelegate.addCategory(c);
					table.setModel(new CategoryTableModel());
					textFieldName.setText("");
				}
				else if(btnAdd.getText().equals("Update"))
				{
					category.setName(textFieldName.getText());
					CategoryBusinessDelegate.updateCategory(category);
					textFieldName.setText("");
					lblAddCategory.setText(lblAddCategory.getText().replace("Update", "Add"));
					btnAdd.setText(btnAdd.getText().replace("Update","Add" ));
					table.setModel(new CategoryTableModel());
				}
				
			}
		});
		btnAdd.setBounds(10, 80, 89, 23);
		contentPane.add(btnAdd);
		
		JLabel lblCategoriesList = new JLabel("Categories List");
		lblCategoriesList.setForeground(new Color(255, 255, 255));
		lblCategoriesList.setBounds(219, 27, 100, 14);
		contentPane.add(lblCategoriesList);
		
		JPanel panel = new JPanel();
		panel.setAutoscrolls(true);
		panel.setBounds(196, 52, 211, 133);
		contentPane.add(panel);
		CategoryBusinessDelegate.addCategory(new Category("mariage"));
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 211, 133);
		panel.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setAutoscrolls(true);
		scrollPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		table = new JTable();
		table.setForeground(new Color(0, 153, 255));
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRowCount() >= 1)
				{
					category = CategoryBusinessDelegate.findCategory(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
					textFieldName.setText(category.getName());
					lblAddCategory.setText(lblAddCategory.getText().replace("Add", "Update"));
					btnAdd.setText(btnAdd.getText().replace("Add", "Update"));
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(table.getSelectedRowCount() >= 1)
				{
					category = CategoryBusinessDelegate.findCategory(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
					textFieldName.setText(category.getName());
					lblAddCategory.setText(lblAddCategory.getText().replace("Add", "Update"));
					btnAdd.setText(btnAdd.getText().replace("Add", "Update"));
				}
			}
		});
		table.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(table.getSelectedRowCount() >= 1)
				{
					category = CategoryBusinessDelegate.findCategory(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
					textFieldName.setText(category.getName());
					lblAddCategory.setText(lblAddCategory.getText().replace("Add", "Update"));
					btnAdd.setText(btnAdd.getText().replace("Add", "Update"));
				}
			}
		});
		table.setModel(new CategoryTableModel());
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		btnDelete.setBackground(new Color(0, 153, 255));
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRowCount() >= 1)
				{
					CategoryBusinessDelegate.removeCategory(category);
					textFieldName.setText("");
					lblAddCategory.setText(lblAddCategory.getText().replace("Update", "Add"));
					btnAdd.setText(btnAdd.getText().replace("Update","Add" ));
					table.setModel(new CategoryTableModel());
				}
			}
		});
		btnDelete.setBounds(10, 114, 89, 23);
		contentPane.add(btnDelete);
	}

	protected void Dispose() {
		this.dispose();
		
	}
}
