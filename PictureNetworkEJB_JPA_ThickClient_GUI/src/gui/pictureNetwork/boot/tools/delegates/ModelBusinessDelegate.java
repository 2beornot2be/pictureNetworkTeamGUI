package gui.pictureNetwork.boot.tools.delegates;

import gui.pictureNetwork.boot.tools.ServiceLocator;
import interfaces.ModelBeanRemote;

import java.util.List;

import entities.Model;
import entities.BadWorld;

public class ModelBusinessDelegate  
{
	private static ModelBeanRemote ModelRemote = (ModelBeanRemote) ServiceLocator.getInstance().lookupProxy("/pictureNetworkEJB_JPA/ModelBean!interfaces.ModelBeanRemote");;
	
	
	public static boolean addModel(Model Model)
	{
		return ModelRemote.addModel(Model);
	}
	public static Model authenticateModel(String first, String last, String Password)
	{
		return ModelRemote.authenticateModel(first, last, Password);
	}
	public static boolean updateModel(Model Model)
	{
		return ModelRemote.updateModel(Model);
	}
	public static boolean removeModel(Model Model)
	{
		return ModelRemote.removeModel(Model);
	}
	public static boolean removeModel(int id)
	{
		return ModelRemote.removeModel(id);
	}
	public static Model findModel(int id)
	{
		return ModelRemote.findModel(id);
	}
	public static List<Model> findAllModels()
	{
		return ModelRemote.findAllModels();
	}

}
