package gui.pictureNetwork.boot.Admin;

import entities.Category;
import entities.Model;
import entities.ModelState_Activation;
import entities.Picture;
import entities.State;
import entities.SubCategory;
import entities.User;
import gui.pictureNetwork.boot.tools.delegates.ModelBusinessDelegate;
import gui.pictureNetwork.boot.tools.delegates.PictureBusinessDelegate;
import gui.pictureNetwork.boot.tools.delegates.SubCategoryBusinessDelegate;
import gui.pictureNetwork.boot.tools.delegates.UserBusinessDelegate;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

import org.eclipse.swt.internal.win32.OPENFILENAME;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JRadioButton;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.ButtonGroup;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Cursor;

public class PictureManagement extends JFrame {
	
	private JLabel labelPictureView;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JComboBox comboBoxSubCategory;
	private JComboBox comboBoxType;
	private JComboBox comboBoxUser;
	private byte[] fileContent;
	private JButton btnAdd;
	private static PictureManagement frame;
	private Picture picture = null;
	private JTextArea textAreaDescription;
	private JTextField textFieldSection;
	private JComboBox comboBoxActivation;
	private JTable table;
	private JLabel lblAddPicture;
	private JComboBox comboBoxShow;
	private JTextField textFieldSearch;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private  JRadioButton rdbtnPictureName;
	private JRadioButton rdbtnSection;
	private JRadioButton rdbtnSubCategory;
	private JMenuBar menuBar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new PictureManagement();
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
	public PictureManagement() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\4GL3 info A\\PIDEV\\sprint 1\\images\\icone.png"));
		setMinimumSize(new Dimension(1300, 650));
		setTitle("Picture Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 503);
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
		
		lblAddPicture = new JLabel("Add Picture");
		lblAddPicture.setForeground(new Color(255, 255, 255));
		lblAddPicture.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddPicture.setBounds(10, 11, 118, 34);
		contentPane.add(lblAddPicture);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 44, 63, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setForeground(new Color(255, 255, 255));
		lblDescription.setBounds(10, 76, 75, 26);
		contentPane.add(lblDescription);
		
		JLabel lblSubCategory = new JLabel("Sub category:");
		lblSubCategory.setForeground(new Color(255, 255, 255));
		lblSubCategory.setBounds(10, 172, 98, 26);
		contentPane.add(lblSubCategory);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setBounds(10, 308, 63, 26);
		contentPane.add(lblUser);
		
		JLabel lblImagefile = new JLabel("image File:");
		lblImagefile.setForeground(new Color(255, 255, 255));
		lblImagefile.setBounds(10, 345, 63, 26);
		contentPane.add(lblImagefile);
		
		textFieldName = new JTextField();
		textFieldName.setForeground(new Color(0, 153, 255));
		textFieldName.setBounds(101, 47, 86, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textAreaDescription = new JTextArea();
		textAreaDescription.setForeground(new Color(0, 153, 255));
		textAreaDescription.setBounds(104, 78, 83, 83);
		contentPane.add(textAreaDescription);
		
		comboBoxSubCategory = new JComboBox();
		comboBoxSubCategory.setBackground(new Color(255, 255, 255));
		comboBoxSubCategory.setForeground(new Color(0, 0, 0));
		comboBoxSubCategory.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				refreshComboboxSubCategories();
				
			}

			
		});
		comboBoxSubCategory.setBounds(101, 175, 86, 20);
		contentPane.add(comboBoxSubCategory);
		
		comboBoxUser = new JComboBox();
		comboBoxUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxUser.setBackground(new Color(255, 255, 255));
		comboBoxUser.setForeground(new Color(0, 0, 0));
		comboBoxUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				refreshComboboxUsers();
			}

			
		});
		comboBoxUser.setBounds(101, 311, 118, 20);
		contentPane.add(comboBoxUser);
		
		btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(0, 153, 255));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnAdd.getText().equals("Add"))
				{
					picture = new Picture(textFieldName.getText(), textAreaDescription.getText(), (SubCategory) comboBoxSubCategory.getSelectedItem(), textFieldSection.getText(), (User) comboBoxUser.getSelectedItem(), new Date(), null,null, fileContent,comboBoxActivation.getSelectedItem().toString());
					PictureBusinessDelegate.addPicture(picture);
					table.setModel(new PictureTableModel());
				}
				else
				{
					picture = new Picture(picture.getId(), textFieldName.getText(), textAreaDescription.getText(), (SubCategory) comboBoxSubCategory.getSelectedItem(), textFieldSection.getText(), (User) comboBoxUser.getSelectedItem(), new Date(), null,null, fileContent == null ? picture.getContent() : fileContent,comboBoxActivation.getSelectedItem().toString());
					PictureBusinessDelegate.updatePicture(picture);
					table.setModel(new PictureTableModel());
					/////////////////////////////////////////////////////////////////////////////
					lblAddPicture.setText(lblAddPicture.getText().replace("Update","Add"));
					btnAdd.setText(btnAdd.getText().replace( "Update", "Add"));
					comboBoxUser.setEnabled(true);
					comboBoxType.setEnabled(true);
					/////////////////////////////////////////////////////////////////////////////
				}
				
			}
		});
		btnAdd.setBounds(10, 418, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnSelectImage = new JButton("Select Image");
		btnSelectImage.setBackground(new Color(0, 153, 255));
		btnSelectImage.setForeground(new Color(255, 255, 255));
		btnSelectImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File("."));
			    fileChooser.setDialogTitle("Choose a file");
			    
			    contentPane.add(fileChooser);
			    fileChooser.setVisible(true);
			    fileChooser.showOpenDialog(null);
			    
			    
			    File curFile = fileChooser.getSelectedFile();
			    fileContent = readFile(curFile);
			}
		});
		btnSelectImage.setBounds(101, 347, 118, 23);
		contentPane.add(btnSelectImage);
		
		JLabel lblUserType = new JLabel("User Type:");
		lblUserType.setForeground(new Color(255, 255, 255));
		lblUserType.setBounds(10, 261, 69, 26);
		contentPane.add(lblUserType);
		
		comboBoxType = new JComboBox();
		comboBoxType.setBackground(new Color(0, 153, 255));
		comboBoxType.setForeground(new Color(255, 255, 255));
		comboBoxType.addItem(State.MODEL.toString());
		comboBoxType.addItem(State.USER.toString());
		comboBoxType.setBounds(101, 264, 86, 20);
		contentPane.add(comboBoxType);
		
		JLabel lblSection = new JLabel("Section:");
		lblSection.setForeground(new Color(255, 255, 255));
		lblSection.setBounds(10, 224, 69, 26);
		contentPane.add(lblSection);
		
		textFieldSection = new JTextField();
		textFieldSection.setForeground(new Color(0, 153, 255));
		textFieldSection.setColumns(10);
		textFieldSection.setBounds(101, 227, 86, 20);
		contentPane.add(textFieldSection);
		
		JLabel lblActivation = new JLabel("Activation:");
		lblActivation.setForeground(new Color(255, 255, 255));
		lblActivation.setBounds(10, 377, 63, 26);
		contentPane.add(lblActivation);
		
		comboBoxActivation = new JComboBox();
		comboBoxActivation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxActivation.setBackground(new Color(255, 255, 255));
		comboBoxActivation.setForeground(new Color(0, 0, 0));
		comboBoxActivation.setBounds(101, 383, 118, 20);
		contentPane.add(comboBoxActivation);
		comboBoxActivation.addItem(ModelState_Activation.ACTIVATED.toString());
		comboBoxActivation.addItem(ModelState_Activation.DESACTIVATED.toString());
		
		JLabel lblPicturesList = new JLabel("Pictures List");
		lblPicturesList.setForeground(new Color(255, 255, 255));
		lblPicturesList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPicturesList.setBounds(316, 11, 118, 34);
		contentPane.add(lblPicturesList);
		
		JPanel panel = new JPanel();
		panel.setBounds(243, 44, 1031, 260);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 1011, 238);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 153, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(table.getSelectedRowCount() >= 1)
				{
					picture = PictureBusinessDelegate.findPicture(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
					fileContent = picture.getContent();
					
					////////////////UPDATE VIEW IMAGE////////////////////////////
					if(fileContent != null)
					{
						ImageIcon icon = new ImageIcon(fileContent);
						icon.getImage().flush();
						Image img = icon.getImage();  
						Image newimg = img.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH);  
						Icon icon2 = new ImageIcon(newimg); 
						labelPictureView.setIcon(icon2);
					}
					else
					{
						ImageIcon icon = new ImageIcon();
						labelPictureView.setIcon(icon);
					}
					
					/////////////////////////////////////////////////////////////////////
					textFieldName.setText(picture.getName());
					textFieldSection.setText(picture.getSection());
					textAreaDescription.setText(picture.getDescription());
					refreshComboboxSubCategories();
					for(int i = 0; i < comboBoxSubCategory.getComponentCount(); i++)
					{
						if(picture.getPictureSubCategory().toString().equals(comboBoxSubCategory.getItemAt(i).toString()))
						{
							comboBoxSubCategory.setSelectedIndex(i);
							break;
						}
					}
					for(int i = 0; i < comboBoxType.getComponentCount();i++)
					{
						if(picture.getPictureOwner().getState().equals(comboBoxType.getItemAt(i).toString()))
						{
							comboBoxType.setSelectedIndex(i);
							break;
						}
					}
					refreshComboboxUsers();
					for(int i = 0; i < comboBoxUser.getComponentCount();i++)
					{
						if(picture.getPictureOwner().toString().equals(comboBoxUser.getItemAt(i).toString()))
						{
							comboBoxUser.setSelectedIndex(i);
							break;
						}
					}
					for(int i = 0; i < comboBoxActivation.getComponentCount();i++)
					{
						if(picture.getActivation().equals(comboBoxActivation.getItemAt(i).toString()))
						{
							comboBoxActivation.setSelectedIndex(i);
							break;
						}
					}
					
					/////////////////////////////////////////////////////////////////////////////
					lblAddPicture.setText(lblAddPicture.getText().replace("Add", "Update"));
					btnAdd.setText(btnAdd.getText().replace("Add", "Update"));
					comboBoxUser.setEnabled(false);
					comboBoxType.setEnabled(false);
					/////////////////////////////////////////////////////////////////////////////
					fileContent = null;
				}
			}
		});
		table.setModel(new PictureTableModel());
		scrollPane.setViewportView(table);
		
		JLabel lblPictureView = new JLabel("Picture View");
		lblPictureView.setForeground(new Color(255, 255, 255));
		lblPictureView.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPictureView.setBounds(698, 302, 118, 34);
		contentPane.add(lblPictureView);
		
		labelPictureView = new JLabel("");
		labelPictureView.setBorder(UIManager.getBorder("DesktopIcon.border"));
		labelPictureView.setMinimumSize(new Dimension(300, 300));
		labelPictureView.setBounds(585, 330, 313, 249);
		contentPane.add(labelPictureView);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PictureBusinessDelegate.removePicture(picture.getId());
				table.setModel(new PictureTableModel());
				/////////////////////////////////////////////////////////////////////////////
				lblAddPicture.setText(lblAddPicture.getText().replace("Update","Add"));
				btnAdd.setText(btnAdd.getText().replace( "Update", "Add"));
				comboBoxUser.setEnabled(true);
				comboBoxType.setEnabled(true);
				/////////////////////////////////////////////////////////////////////////////
			}
		});
		btnNewButton.setBounds(130, 418, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblShow = new JLabel("Show:");
		lblShow.setForeground(new Color(255, 255, 255));
		lblShow.setBounds(442, 17, 75, 26);
		contentPane.add(lblShow);
		
		comboBoxShow = new JComboBox();
		comboBoxShow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxShow.setBackground(new Color(255, 255, 255));
		comboBoxShow.setForeground(new Color(0, 0, 0));
		comboBoxShow.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBoxShow.getSelectedItem().toString().equals("ALL"))
				{
					table.setModel(new PictureTableModel("ALL"));
				}
				else if(comboBoxShow.getSelectedItem().toString().equals(ModelState_Activation.DESACTIVATED.toString()))
				{
					table.setModel(new PictureTableModel(ModelState_Activation.DESACTIVATED.toString()));
				}
			}
		});
		comboBoxShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		comboBoxShow.setBounds(506, 20, 136, 20);
		comboBoxShow.addItem("ALL");
		comboBoxShow.addItem(ModelState_Activation.DESACTIVATED.toString());
		
		
		contentPane.add(comboBoxShow);
		
		JLabel lblFindBy = new JLabel("Search by:");
		lblFindBy.setBackground(new Color(0, 153, 255));
		lblFindBy.setForeground(new Color(255, 255, 255));
		lblFindBy.setBounds(685, 17, 75, 26);
		contentPane.add(lblFindBy);
		
		// JRadioButton rdbtnPictureName
		// JRadioButton rdbtnSection
		// JRadioButton rdbtnSubCategory
		rdbtnPictureName = new JRadioButton("picture name");
		rdbtnPictureName.setBackground(new Color(0, 153, 255));
		rdbtnPictureName.setForeground(new Color(255, 255, 255));
		rdbtnPictureName.setSelected(true);
		buttonGroup.add(rdbtnPictureName);
		rdbtnPictureName.setBounds(750, 19, 109, 23);
		contentPane.add(rdbtnPictureName);
		
		rdbtnSection = new JRadioButton("section");
		rdbtnSection.setBackground(new Color(0, 153, 255));
		rdbtnSection.setForeground(new Color(255, 255, 255));
		buttonGroup.add(rdbtnSection);
		rdbtnSection.setBounds(853, 19, 75, 23);
		contentPane.add(rdbtnSection);
		
		rdbtnSubCategory = new JRadioButton("sub category");
		rdbtnSubCategory.setBackground(new Color(0, 153, 255));
		rdbtnSubCategory.setForeground(new Color(255, 255, 255));
		buttonGroup.add(rdbtnSubCategory);
		rdbtnSubCategory.setBounds(924, 19, 109, 23);
		contentPane.add(rdbtnSubCategory);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setForeground(new Color(0, 153, 255));
		textFieldSearch.setBounds(1051, 20, 86, 20);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(0, 153, 255));
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//table.setModel(new PictureTableModel(btnNewButton.getSelectedObjects()));
				String type = "";
				if(rdbtnPictureName.isSelected())
				{
					type = rdbtnPictureName.getText();
				}
				else if(rdbtnSection.isSelected())
				{
					type = rdbtnSection.getText();
				}
				else
				{
					type = rdbtnSubCategory.getText();
				}
				String value = textFieldSearch.getText();
				table.setModel(new PictureTableModel(type,value));
			}
		});
		btnSearch.setBounds(1155, 19, 89, 23);
		contentPane.add(btnSearch);
	}
	protected void Dispose() {
		this.dispose();
		
	}

	private byte[] readFile(File file)
	{
		byte[] bFile = null;
		if(file != null)
		{
			FileInputStream fileInputStream=null;
			 
	         
			 
	        bFile = new byte[(int) file.length()];
	 
	        try {
	            //convert file into array of bytes
		    fileInputStream = new FileInputStream(file);
		    fileInputStream.read(bFile);
		    fileInputStream.close();
	 
		    
	 
		    System.out.println("Done");
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
		}

        return bFile;
	}
	private void refreshComboboxUsers() {
		if(comboBoxType.getSelectedItem().toString().equals(State.MODEL.toString()))
		{
			comboBoxUser.removeAllItems();
			List<Model> models = ModelBusinessDelegate.findAllModels();
			for(Model m : models)
			{
				comboBoxUser.addItem(m);
			}
		}
		else
		{
			comboBoxUser.removeAllItems();
			List<User> photographers = UserBusinessDelegate.findAllPhtograhers();
			for(User m : photographers)
			{
				comboBoxUser.addItem(m);
			}
		}
		
	}
	private void refreshComboboxSubCategories() {
		comboBoxSubCategory.removeAllItems();
		List<SubCategory> categories = SubCategoryBusinessDelegate.findAllSubCategorys();
		for(SubCategory s : categories)
		{
			comboBoxSubCategory.addItem(s);
		}
		
	}
}
