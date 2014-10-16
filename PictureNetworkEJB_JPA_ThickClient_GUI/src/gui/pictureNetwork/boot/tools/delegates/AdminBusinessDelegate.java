package gui.pictureNetwork.boot.tools.delegates;

import gui.pictureNetwork.boot.tools.ServiceLocator;
import interfaces.AdminBeanRemote;

import java.util.List;

import entities.Admin;
import entities.BadWorld;

public class AdminBusinessDelegate  
{
	private static AdminBeanRemote AdminRemote = (AdminBeanRemote) ServiceLocator.getInstance().lookupProxy("/pictureNetworkEJB_JPA/AdminBean!interfaces.AdminBeanRemote");;
	
	
	public static boolean addAdmin(Admin Admin)
	{
		return AdminRemote.addAdmin(Admin);
	}
	public static Admin authenticateAdmin(String first, String last, String Password)
	{
		return AdminRemote.authenticateAdmin(first, last, Password);
	}
	public static boolean updateAdmin(Admin Admin)
	{
		return AdminRemote.updateAdmin(Admin);
	}
	public static boolean removeAdmin(Admin Admin)
	{
		return AdminRemote.removeAdmin(Admin);
	}
	public static boolean removeAdmin(int id)
	{
		return AdminRemote.removeAdmin(id);
	}
	public static Admin findAdmin(int id)
	{
		return AdminRemote.findAdmin(id);
	}
	public static List<Admin> findAllAdmins()
	{
		return AdminRemote.findAllAdmins();
	}

}
