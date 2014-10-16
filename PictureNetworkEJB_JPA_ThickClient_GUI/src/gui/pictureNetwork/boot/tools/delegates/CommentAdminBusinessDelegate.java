package gui.pictureNetwork.boot.tools.delegates;

import gui.pictureNetwork.boot.tools.ServiceLocator;
import interfaces.CommentBeanRemote;

import java.util.List;

import entities.Comment;

public class CommentAdminBusinessDelegate  
{
	private static CommentBeanRemote CommentRemote = null;
	
	private static void init()
	{
		CommentRemote = (CommentBeanRemote) ServiceLocator.getInstance().lookupProxy("/pictureNetworkEJB_JPA/CommentBean!interfaces.CommentBeanRemote");
	}
	
	public static Boolean addComment(Comment Comment)
	{
		init();
		return CommentRemote.addComment(Comment);
	}
	public static Boolean removeComment(Comment Comment)
	{
		init();
		return CommentRemote.removeComment(Comment);
	}
	public static Boolean updateComment(Comment Comment)
	{
		init();
		return CommentRemote.updateComment(Comment);
	}
	public static boolean removeComment(int id)
	{
		init();
		return CommentRemote.removeComment(id);
	}
	public static Comment findComment(int id)
	{
		init();
		return CommentRemote.findComment(id);
	}
	
	public static List<Comment> findAllComment()
	{
		init();
		return CommentRemote.findAllComment();
	}

}
