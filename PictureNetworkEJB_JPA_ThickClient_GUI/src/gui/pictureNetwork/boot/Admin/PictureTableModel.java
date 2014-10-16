package gui.pictureNetwork.boot.Admin;

import java.util.List;





import gui.pictureNetwork.boot.tools.delegates.PictureBusinessDelegate;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;




import entities.ModelState_Activation;
import entities.Picture;


public class PictureTableModel implements TableModel 
{
	
	String[] names = { "id", "picture name",  "description", "sub category", "section", "owner type", "owner name", "activation" };
	List<Picture> pictures = null;
	
	public PictureTableModel()
	{
		try
		{
			pictures = PictureBusinessDelegate.findAllPicture();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public PictureTableModel(String type, String value)
	{
		try
		{
			if(type.equals("picture name"))
			{
				pictures = PictureBusinessDelegate.findByName(value);
			}
			else if(type.equals("section"))
			{
				pictures = PictureBusinessDelegate.findBySection(value);
			}
			else
			{
				pictures = PictureBusinessDelegate.findBySubcategory(value);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public PictureTableModel(String toShow)
	{
		try
		{
			if(toShow.equals("ALL"))
			{
				pictures = PictureBusinessDelegate.findAllPicture();
			}
			else if(toShow.equals(ModelState_Activation.DESACTIVATED.toString()))
			{
				pictures = PictureBusinessDelegate.findDesactivated();
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if(pictures != null)
		{
			return pictures.size();
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
		// String[] names = { "id", "picture name",  "description", "sub category", "section", "owner type", "owner name" "activation" };
		if(pictures != null)
		{
			Picture b = pictures.get(rowIndex);
			switch(columnIndex)
			{
				case 0:
					return b.getId()+ "";
				case 2:
					return b.getDescription();
				case 1:
					return b.getName();
				case 3:
					return b.getPictureSubCategory().toString();
				case 4:
					return b.getSection();
				case 5:
					return b.getPictureOwner().getState();
				case 6:
					return b.getPictureOwner().toString();
				case 7:
					return b.getActivation();
					
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
