package gui.pictureNetwork.boot.Admin;

import java.util.List;






import gui.pictureNetwork.boot.tools.delegates.BadwordBusinessDelegate;
import gui.pictureNetwork.boot.tools.delegates.CategoryBusinessDelegate;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;





import entities.BadWorld;
import entities.Category;


public class CategoryTableModel implements TableModel 
{
	
	String[] names = { "id", "category" };
	List<Category> categories = CategoryBusinessDelegate.findAllCategorys();
	
	public CategoryTableModel()
	{
		try
		{
			categories = CategoryBusinessDelegate.findAllCategorys();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if(categories != null)
		{
			return categories.size();
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
		if(categories != null)
		{
			Category b = categories.get(rowIndex);
			switch(columnIndex)
			{
				case 0:
					return b.getId()+ "";
				case 1:
					return b.getName();
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
		return Object.class;
	
	}

}
