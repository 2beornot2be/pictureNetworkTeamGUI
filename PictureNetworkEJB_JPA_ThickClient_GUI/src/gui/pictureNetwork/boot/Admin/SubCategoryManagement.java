package gui.pictureNetwork.boot.Admin;

import entities.Category;
import entities.SubCategory;
import gui.pictureNetwork.boot.tools.delegates.CategoryBusinessDelegate;
import gui.pictureNetwork.boot.tools.delegates.SubCategoryBusinessDelegate;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.Color;

public class SubCategoryManagement extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JComboBox comboBox;
	private JTable table;
	private SubCategory subCategory;
	private JLabel lblAddSubCategory;
	private JButton btnAdd;
	static SubCategoryManagement frame;
	private JMenuBar menuBar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SubCategoryManagement();
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
	public SubCategoryManagement() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\4GL3 info A\\PIDEV\\sprint 1\\images\\icone.png"));
		setTitle("Sub Category Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 300);
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAddSubCategory = new JLabel("Add Sub Category");
		lblAddSubCategory.setForeground(new Color(255, 255, 255));
		lblAddSubCategory.setBounds(10, 29, 125, 14);
		contentPane.add(lblAddSubCategory);
		
		JLabel lblName = new JLabel("name:");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setBounds(10, 54, 56, 14);
		contentPane.add(lblName);
		
		JLabel lblCategory = new JLabel("Category: ");
		lblCategory.setForeground(new Color(255, 255, 255));
		lblCategory.setBounds(10, 79, 73, 14);
		contentPane.add(lblCategory);
		
		btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(0, 153, 255));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnAdd.getText().equals("Add"))
				{
					SubCategory sc = new SubCategory(textFieldName.getText(), (Category) comboBox.getItemAt(comboBox.getSelectedIndex()));
					SubCategoryBusinessDelegate.addSubCategory(sc);
				}
				else
				{
					subCategory.setParentCategory((Category)comboBox.getItemAt(comboBox.getSelectedIndex()));
					subCategory.setName(textFieldName.getText());
					SubCategoryBusinessDelegate.updateSubCategory(subCategory);
					lblAddSubCategory.setText(lblAddSubCategory.getText().replace("Update", "Add"));
					btnAdd.setText(btnAdd.getText().replace("Update","Add" ));
				}
				table.setModel(new SubCategoryTableModel());
			}
		});
		btnAdd.setBounds(10, 114, 89, 23);
		contentPane.add(btnAdd);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(76, 51, 86, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		comboBox = new JComboBox();
		List<Category> categories = CategoryBusinessDelegate.findAllCategorys();
		for(Category c : categories)
		{
			comboBox.addItem(c);
		}
		comboBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				comboBox.removeAllItems();
				List<Category> categories = CategoryBusinessDelegate.findAllCategorys();
				for(Category c : categories)
				{
					comboBox.addItem(c);
				}
			}
		});
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		comboBox.setBounds(76, 76, 86, 20);
		contentPane.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(182, 54, 385, 118);
		contentPane.add(panel);
		List<SubCategory> subcategories = SubCategoryBusinessDelegate.findAllSubCategorys();
		if(subcategories == null || subcategories.size() == 0)
		{
			List<Category> categs = CategoryBusinessDelegate.findAllCategorys();
			if(categs != null && categs.size() >= 1)
			{
				SubCategoryBusinessDelegate.addSubCategory( new SubCategory("cosutumes",categs.get(0)));
			}
			else
			{
				Category c = new Category("mariage");
				CategoryBusinessDelegate.addCategory(c);
				categs = CategoryBusinessDelegate.findAllCategorys();
				SubCategoryBusinessDelegate.addSubCategory( new SubCategory("cosutumes",categs.get(0)));
			}
			
		}
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 153, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(table.getSelectedRowCount() >= 1)
				{
					subCategory = SubCategoryBusinessDelegate.findSubCategory( Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
					textFieldName.setText(subCategory.getName());
					for(int i = 0; i < comboBox.getItemCount(); i++)
					{
						Category temp = (Category)comboBox.getItemAt(i);
						if(subCategory.getParentCategory().getName().equals(temp.getName()))
						{
							comboBox.setSelectedIndex(i);
							break;
						}
					}
					lblAddSubCategory.setText(lblAddSubCategory.getText().replace("Add", "Update"));
					btnAdd.setText(btnAdd.getText().replace("Add", "Update"));
				}
			}
		});
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane.setViewportView(table);
		table.setMinimumSize(new Dimension(400, 400));
		table.setModel(new SubCategoryTableModel());
		
		JLabel lblListOfSub = new JLabel("List of Sub Categories");
		lblListOfSub.setForeground(new Color(255, 255, 255));
		lblListOfSub.setBounds(184, 29, 160, 14);
		contentPane.add(lblListOfSub);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(0, 153, 255));
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRowCount() >= 1)
				{
					subCategory = SubCategoryBusinessDelegate.findSubCategory( Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
					SubCategoryBusinessDelegate.removeSubCategory(subCategory);
					lblAddSubCategory.setText(lblAddSubCategory.getText().replace( "Update","Add"));
					btnAdd.setText(btnAdd.getText().replace( "Update","Add" ));
					table.setModel(new SubCategoryTableModel());
				}
			}
		});
		btnDelete.setBounds(10, 148, 89, 23);
		contentPane.add(btnDelete);
		
		
	}

	protected void Dispose() {
		this.dispose();
		
	}
}
