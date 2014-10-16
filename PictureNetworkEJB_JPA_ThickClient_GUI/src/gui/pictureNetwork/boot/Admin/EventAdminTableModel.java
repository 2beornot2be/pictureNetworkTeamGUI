package gui.pictureNetwork.boot.Admin;

import java.util.List;







import gui.pictureNetwork.boot.tools.delegates.EventAdminBusinessDelegate;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;





import entities.ModelState_Activation;
import entities.Event;


public class EventAdminTableModel implements TableModel 
{
	
	String[] names = { "id", "topic",  "description",  "date",  "owner name", "activation" };
	List<Event> Events = null;
	
	public EventAdminTableModel()
	{
		try
		{
			Events = EventAdminBusinessDelegate.findAllEvent();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if(Events != null)
		{
			return Events.size();
		}
		else
		{
			return 0;
		}
		
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return names.length;
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
		// String[] names = { "id", "topic",  "description",  "date",  "owner name", "activation" };
		if(Events != null)
		{
			Event b = Events.get(rowIndex);
			switch(columnIndex)
			{
				case 0:
					return b.getId()+ "";
				case 2:
					return b.getDescription();
				case 1:
					return b.getTopic();
				case 3:
					return b.getEventDate().toString();
				case 4:
					return b.getOwner().toString();
				case 5:
					return b.getModelState_Activation();
				
					
				default:
					return "!!!";
						
			}

		}
		else
		{
			return "";
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
		return String.class;
	
	}

}
