package gui.pictureNetwork.boot.tools.delegates;

import gui.pictureNetwork.boot.tools.ServiceLocator;
import interfaces.CategoryBeanRemote;

import java.util.List;

import entities.Category;
import entities.BadWorld;

public class CategoryBusinessDelegate  
{
	private static CategoryBeanRemote CategoryRemote = (CategoryBeanRemote) ServiceLocator.getInstance().lookupProxy("/pictureNetworkEJB_JPA/CategoryBean!interfaces.CategoryBeanRemote");;
	
	
	public static boolean addCategory(Category Category)
	{
		return CategoryRemote.addCategory(Category);
	}
	
	public static boolean updateCategory(Category Category)
	{
		return CategoryRemote.updateCategory(Category);
	}
	public static boolean removeCategory(Category Category)
	{
		return CategoryRemote.removeCategory(Category);
	}
	public static boolean removeCategory(int id)
	{
		return CategoryRemote.removeCategory(id);
	}
	public static Category findCategory(int id)
	{
		return CategoryRemote.findCategory(id);
	}
	public static List<Category> findAllCategorys()
	{
		return CategoryRemote.findAllCategories();
	}

}
