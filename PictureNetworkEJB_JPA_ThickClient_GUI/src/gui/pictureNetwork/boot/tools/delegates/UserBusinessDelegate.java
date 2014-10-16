package gui.pictureNetwork.boot.tools.delegates;

import gui.pictureNetwork.boot.tools.ServiceLocator;
import interfaces.UserBeanRemote;

import java.util.List;

import entities.User;


public class UserBusinessDelegate  
{
	private static UserBeanRemote UserRemote = (UserBeanRemote) ServiceLocator.getInstance().lookupProxy("/pictureNetworkEJB_JPA/UserBean!interfaces.UserBeanRemote");;
	
	
	public static boolean addUser(User User)
	{
		return UserRemote.addUser(User);
	}
	public static User authenticateUser(String first, String last, String Password)
	{
		return UserRemote.authenticateUser(first, last, Password);
	}
	public static boolean updateUser(User User)
	{
		return UserRemote.updateUser(User);
	}
	public static boolean removeUser(User User)
	{
		return UserRemote.removeUser(User);
	}
	public static boolean removeUser(int id)
	{
		return UserRemote.removeUser(id);
	}
	public static User findUser(int id)
	{
		return UserRemote.findUser(id);
	}
	public static List<User> findAllUsers()
	{
		return UserRemote.findAllUsers();
	}
	public static List<User> findAllPhtograhers()
	{
		return UserRemote.findAllPhtograhers();
	}

}
