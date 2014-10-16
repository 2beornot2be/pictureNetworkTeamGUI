package gui.pictureNetwork.boot.tools.delegates;

import gui.pictureNetwork.boot.tools.ServiceLocator;
import interfaces.BadWordBeanRemote;

import java.util.List;

import entities.BadWorld;

public class BadwordBusinessDelegate  
{
	private static BadWordBeanRemote badwordRemote = null;
	
	private static void init()
	{
		badwordRemote = (BadWordBeanRemote) ServiceLocator.getInstance().lookupProxy("/pictureNetworkEJB_JPA/BadWordBean!interfaces.BadWordBeanRemote");
	}
	public static boolean valider(String message) {
		init();
		return badwordRemote.valider(message);
	}
	public static Boolean addBadWord(BadWorld badword)
	{
		init();
		return badwordRemote.addBadWord(badword);
	}
	public static Boolean removeBadWord(BadWorld badword)
	{
		init();
		return badwordRemote.removeBadWord(badword);
	}
	public static Boolean updateBadWord(BadWorld badword)
	{
		init();
		return badwordRemote.updateBadWord(badword);
	}
	public static boolean removeBadWord(int id)
	{
		init();
		return badwordRemote.removeBadWord(id);
	}
	public static BadWorld findBadWord(int id)
	{
		init();
		return badwordRemote.findBadWord(id);
	}
	
	public static List<BadWorld> findAllBadWorld()
	{
		init();
		return badwordRemote.findAllBadWorld();
	}

}
