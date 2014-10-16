package gui.pictureNetwork.boot.Admin;

import java.util.List;

import gui.pictureNetwork.boot.tools.delegates.AdminBusinessDelegate;
import gui.pictureNetwork.boot.tools.delegates.ModelBusinessDelegate;
import gui.pictureNetwork.boot.tools.delegates.UserBusinessDelegate;



import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import entities.Admin;
import entities.Model;
import entities.State;
import entities.User;

public class UsersTableModel implements TableModel 
{
	
	String[] names = { "id", "first name", "last name", "password", "State", "Credit", "address", "telephone", "Activation (Model only)" };
	List<User> users = null;
	List<Admin> admins = null;
	List<Model> models = null;
	State state = null;
	public UsersTableModel(State state)
	{
		this.state = state;
		
		try {
			
			if(state == State.USER)
			{
				
				users = UserBusinessDelegate.findAllUsers();
			}
			else if(state == State.ADMIN)
			{
				
				admins = AdminBusinessDelegate.findAllAdmins();
			}
			else
			{
				
				models = ModelBusinessDelegate.findAllModels();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		
		
		if(state == State.USER)
		{
			if(users != null)
			{
				return users.size();
			}
			else
			{
				return 0;
			}
			
		}
		else if(state == State.MODEL)
		{
			if(models != null)
			{
				return  models.size();
			}
			else
			{
				return 0;
			}
			
		}
		else {
			if(admins != null)
			{
				return admins.size();
			}
			else
			{
				return 0;
			}
			
		}
		
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		if(state == State.MODEL)
		{
			return names.length;
		}
		else
		{
			return names.length - 1;
		}
		
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return names[columnIndex];
	}

	

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if(state == State.USER)
		{
			User u = users.get(rowIndex);
			
			switch(columnIndex)
			{
				case 0:
					return u.getId();
				case 1:
					return u.getFirstName();
				case 2:
					return u.getLastName();
				case 3:
					return u.getPassword();
				case 4:
					return u.getState();
				case 5:
					return u.getCredit();
				case 6:
					return u.getAddress();
				case 7:
					return u.getTel();
				case 8:
						
							return "";
						
					
				
			}
			return "xxx";
		}
		else if(state == State.MODEL)
		{
			// model.getModelState_Activation();
			Model m = models.get(rowIndex);
			
			switch(columnIndex)
			{
				case 0:
					return m.getId();
				case 1:
					return m.getFirstName();
				case 2:
					return m.getLastName();
				case 3:
					return m.getPassword();
				case 4:
					return m.getState();
				case 5:
					return m.getCredit();
				case 6:
					return m.getAddress();
				case 7:
					return m.getTel();
				case 8:
						return m.getModelState_Activation();
						
					
				
			}
			return "xxx";
		}
		else
		{
			Admin a = admins.get(rowIndex);
			
			switch(columnIndex)
			{
				case 0:
					return a.getId();
				case 1:
					return a.getFirstName();
				case 2:
					return a.getLastName();
				case 3:
					return a.getPassword();
				case 4:
					return a.getState();
				case 5:
					return a.getCredit();
				case 6:
					return a.getAddress();
				case 7:
					return a.getTel();
				case 8:
						return "";
						
					
				
			}
			return "xxx";
		}
	}
		

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		if(columnIndex != 8 )
		{
			return User.class;
		}
		else
		{
			return Model.class;
		}
	
	}

}
