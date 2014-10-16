package gui.pictureNetwork.boot.tools.delegates;

import gui.pictureNetwork.boot.tools.ServiceLocator;
import interfaces.SubCategoryBeanRemote;

import java.util.List;

import entities.SubCategory;
import entities.BadWorld;

public class SubCategoryBusinessDelegate  
{
	private static SubCategoryBeanRemote SubCategoryRemote = (SubCategoryBeanRemote) ServiceLocator.getInstance().lookupProxy("/pictureNetworkEJB_JPA/SubCategoryBean!interfaces.SubCategoryBeanRemote");;
	
	
	public static boolean addSubCategory(SubCategory SubCategory)
	{
		return SubCategoryRemote.addSubCategory(SubCategory);
	}
	
	public static boolean updateSubCategory(SubCategory SubCategory)
	{
		return SubCategoryRemote.updateSubCategory(SubCategory);
	}
	public static boolean removeSubCategory(SubCategory SubCategory)
	{
		return SubCategoryRemote.removeSubCategory(SubCategory);
	}
	public static boolean removeSubCategory(int id)
	{
		return SubCategoryRemote.removeIdSubCategory(id);
	}
	public static SubCategory findSubCategory(int id)
	{
		return SubCategoryRemote.findSubCategoryA(id);
	}
	public static List<SubCategory> findAllSubCategorys()
	{
		return SubCategoryRemote.findAllSubCategory();
	}

}
