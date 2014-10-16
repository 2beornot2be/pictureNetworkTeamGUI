package gui.pictureNetwork.boot.Admin;

import java.util.List;





import gui.pictureNetwork.boot.tools.delegates.CommentAdminBusinessDelegate;


import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;




import entities.Comment;


public class CommentAdminTableModel implements TableModel 
{
	
	String[] names = { "Id", "Content", "Date created", "Date modified", "Admin", "Credit" };
	List<Comment> comments = CommentAdminBusinessDelegate.findAllComment();
	
	public CommentAdminTableModel()
	{
		try
		{
			comments = CommentAdminBusinessDelegate.findAllComment();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if(comments != null)
		{
			return comments.size();
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

	//{ "Id", "Content", "Date created", "Date modified", "Admin", "Credit" };
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if(comments != null)
		{
			Comment b = comments.get(rowIndex);
			switch(columnIndex)
			{
				case 0:
					return b.getId()+ "";
				case 1:
					return b.getContent();
				case 2:
					return b.getDateCreated().toString();
				case 3:
					return b.getDateModified().toString();
				case 4:
					return b.getSender().toString();
				case 5:
					return b.getCredit();
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
