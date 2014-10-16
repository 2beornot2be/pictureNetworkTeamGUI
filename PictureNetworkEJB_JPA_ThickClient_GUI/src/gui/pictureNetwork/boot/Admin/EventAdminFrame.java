package gui.pictureNetwork.boot.Admin;

import entities.Event;
import entities.ModelState_Activation;
import entities.User;
import gui.pictureNetwork.boot.tools.delegates.EventAdminBusinessDelegate;
import gui.pictureNetwork.boot.tools.delegates.UserBusinessDelegate;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.Color;

public class EventAdminFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTopic;
	private JDatePickerImpl datePicker;
	private JComboBox comboBoxOwner;
	private JButton btnAdd;
	private JTextArea textAreaDescription;
	private JComboBox comboBoxActivation;
	private JTable table;
	private JScrollPane scrollPane;
	private Event event;
	private JLabel lblAddEvent;
	static EventAdminFrame frame;
	private JMenuBar menuBar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame = new EventAdminFrame();
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
	public EventAdminFrame() {
		initialiseDB();
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\4GL3 info A\\PIDEV\\sprint 1\\images\\icone.png"));
		setMinimumSize(new Dimension(1200, 400));
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
		
		lblAddEvent = new JLabel("Add Event");
		lblAddEvent.setForeground(new Color(255, 255, 255));
		lblAddEvent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddEvent.setBounds(10, 28, 126, 22);
		contentPane.add(lblAddEvent);
		
		JLabel lblNewLabel = new JLabel("Topic:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 73, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setForeground(new Color(255, 255, 255));
		lblDescription.setBounds(10, 105, 71, 14);
		contentPane.add(lblDescription);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(new Color(255, 255, 255));
		lblDate.setBounds(10, 198, 46, 14);
		contentPane.add(lblDate);
		
		JLabel lblOwner = new JLabel("Owner:");
		lblOwner.setForeground(new Color(255, 255, 255));
		lblOwner.setBounds(10, 240, 46, 14);
		contentPane.add(lblOwner);
		
		btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(0, 153, 255));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnAdd.getText().equals("Add"))
				{
					Event event = new Event(textFieldTopic.getText(), textAreaDescription.getText(), (Date)datePicker.getModel().getValue(), (User) comboBoxOwner.getSelectedItem(),null,null,comboBoxActivation.getSelectedItem().toString());
					EventAdminBusinessDelegate.addEvent(event);
					
				}
				else
				{
					event.setTopic(textFieldTopic.getText());
					event.setDescription(textAreaDescription.getText());
					event.setEventDate((Date)datePicker.getModel().getValue());
					event.setOwner((User) comboBoxOwner.getSelectedItem());
					event.setModelState_Activation(comboBoxActivation.getSelectedItem().toString());
					EventAdminBusinessDelegate.updateEvent(event);
					lblAddEvent.setText(lblAddEvent.getText().replace("Update","Add" ));
					btnAdd.setText("Add");
				}
				table.setModel(new EventAdminTableModel());
				
			}
			
			//lblAddEvent.setText(lblAddEvent.getText().replace("Add", "Update"));
			//btnAdd.setText("Update");
		});
		btnAdd.setBounds(10, 313, 89, 23);
		contentPane.add(btnAdd);
		
		textFieldTopic = new JTextField();
		textFieldTopic.setForeground(new Color(0, 153, 255));
		textFieldTopic.setBounds(113, 70, 126, 20);
		contentPane.add(textFieldTopic);
		textFieldTopic.setColumns(10);
		
		textAreaDescription = new JTextArea();
		textAreaDescription.setForeground(new Color(0, 153, 255));
		textAreaDescription.setBounds(113, 100, 126, 69);
		contentPane.add(textAreaDescription);
		
		comboBoxOwner = new JComboBox();
		comboBoxOwner.setBackground(new Color(0, 153, 255));
		comboBoxOwner.setForeground(new Color(255, 255, 255));
		comboBoxOwner.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				refreshComboboxOwner();
			}
		});
		comboBoxOwner.setBounds(113, 237, 126, 20);
		contentPane.add(comboBoxOwner);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(113, 198, 100, 14);
		contentPane.add(lblNewLabel_1);
		
		UtilDateModel model = new UtilDateModel();
		model.setValue(new Date());
		final JDatePanelImpl datePanel = new  JDatePanelImpl(model, new Properties(getDefaultStrings()));
		final SimpleDateFormat longFormat = new SimpleDateFormat( "dd-MM-yyyy" );
		final DateComponentFormatter formatter = new DateComponentFormatter(
				// invers sequence for parsing to satisfy the year parsing rules
				        ) {

				            /**
							 * 
							 */
							private static final long serialVersionUID = 1L;
							private String datePattern = "dd-MM-yyyy";
						    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
							@Override
						    public Object stringToValue(String text) throws ParseException {
						        return dateFormatter.parseObject(text);
						    }
						 
						    @Override
						    public String valueToString(Object value) throws ParseException {
						        if (value != null) {
						            Calendar cal = (Calendar) value;
						            return dateFormatter.format(cal.getTime());
						        }
						         
						        return "";
						    }
				        } ;
		datePicker = new JDatePickerImpl(datePanel,  formatter);
		
		
		 datePicker.setBounds(113, 198, 150, 25);
		contentPane.add(datePicker);
		
		JLabel lblActivation = new JLabel("Activation:");
		lblActivation.setForeground(new Color(255, 255, 255));
		lblActivation.setBounds(10, 280, 71, 14);
		contentPane.add(lblActivation);
		
		comboBoxActivation = new JComboBox();
		comboBoxActivation.setBackground(new Color(0, 153, 255));
		comboBoxActivation.setForeground(new Color(255, 255, 255));
		comboBoxActivation.setBounds(113, 277, 126, 20);
		comboBoxActivation.addItem(ModelState_Activation.ACTIVATED.toString());
		comboBoxActivation.addItem(ModelState_Activation.DESACTIVATED.toString());
		contentPane.add(comboBoxActivation);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(288, 28, 886, 307);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 886, 307);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setGridColor(new Color(255, 255, 255));
		table.setForeground(new Color(0, 153, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRowCount() >= 1)
				{
					event = EventAdminBusinessDelegate.findEvent(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
					textFieldTopic.setText(event.getTopic());
					textAreaDescription.setText(event.getDescription());
					refreshComboboxOwner();
					for(int i = 0; i < comboBoxOwner.getItemCount(); i++)
					{
						if(event.getOwner().toString().equals(comboBoxOwner.getItemAt(i).toString()))
						{
							comboBoxOwner.setSelectedIndex(i);
							break;
						}
					}
					if(event.getModelState_Activation().equals(ModelState_Activation.ACTIVATED.toString()))
					{
						comboBoxActivation.setSelectedIndex(0);
					}
					else
					{
						comboBoxActivation.setSelectedIndex(1);
					}
					//model.setDate(1990, 8, 24);
					datePicker.getModel().setDate( event.getEventDate().getYear() + 1900, event.getEventDate().getMonth(),  event.getEventDate().getDate());
					
					lblAddEvent.setText(lblAddEvent.getText().replace("Add", "Update"));
					btnAdd.setText("Update");
				}
			}
		});
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane.setViewportView(table);
		table.setModel(new EventAdminTableModel());
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(0, 153, 255));
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRowCount() >= 1)
				{
					event = EventAdminBusinessDelegate.findEvent(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
					EventAdminBusinessDelegate.removeEvent(event);
					table.setModel(new EventAdminTableModel());
					lblAddEvent.setText(lblAddEvent.getText().replace("Update","Add" ));
					btnAdd.setText("Add");
				}
					
			}
		});
		btnDelete.setBounds(150, 313, 89, 23);
		contentPane.add(btnDelete);
	}
	protected void Dispose() {
		this.dispose();
		
	}

	protected void refreshComboboxOwner() {
		comboBoxOwner.removeAllItems();
		List<User> users = UserBusinessDelegate.findAllUsers();
		for(User u : users)
		{
			comboBoxOwner.addItem(u);
		}
		
	}

	private Properties getDefaultStrings() {
		Properties defaults = new Properties();
		defaults.put("messages.today", "Today");
		defaults.put("messages.nextMonth", "Next month");
		defaults.put("messages.previousMonth", "Previous month");
		defaults.put("messages.nextYear", "Next year");
		defaults.put("messages.previousYear", "Previous year");
		defaults.put("messages.clear", "Clear");
		
		return defaults;
	}
	private void initialiseDB()
	{
		List<Event> events = EventAdminBusinessDelegate.findAllEvent();
		if(events == null)
		{
			List<User> users = UserBusinessDelegate.findAllUsers();
			if(users != null && users.size() >= 1)
			{
				User u = users.get(users.size()-1);
				EventAdminBusinessDelegate.addEvent(new Event("test topic", "test description", new Date(), u, null,null,ModelState_Activation.ACTIVATED.toString()));
			}
			
		}
	}
}
