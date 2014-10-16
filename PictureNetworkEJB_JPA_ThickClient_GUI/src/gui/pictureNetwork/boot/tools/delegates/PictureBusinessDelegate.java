package gui.pictureNetwork.boot.tools.delegates;

import gui.pictureNetwork.boot.tools.ServiceLocator;
import interfaces.PictureBeanRemote;

import java.util.List;

import entities.Picture;
import entities.BadWorld;

public class PictureBusinessDelegate  
{
	// PictureBean
	private static PictureBeanRemote PictureRemote = (PictureBeanRemote) ServiceLocator.getInstance().lookupProxy("/pictureNetworkEJB_JPA/PictureBean!interfaces.PictureBeanRemote");;
	
	public static boolean addPicture(Picture picture)
	{
		return PictureRemote.addPicture(picture);
	}
	public static boolean updatePicture(Picture picture)
	{
		 return PictureRemote.updatePicture(picture);
	}
	public static boolean removePicture(int id)
	{
		return PictureRemote.removePicture(id);
	}
	
	public static Picture findPicture(int id)
	{
		return PictureRemote.findPicture(id);
	}
	public static List<Picture> findAllPicture()
	{
		return PictureRemote.findAllPicture();
	}
    public static List<Picture> findBySection(String section)
    {
		return PictureRemote.findBySection(section);
    }
    public static List<Picture> findByName(String name)
    {
		return PictureRemote.findByName(name);
    }
    public static List<Picture> findBySubcategory(String pictureSubCategory)
    {
		return PictureRemote.findBySubcategory(pictureSubCategory);
    }
    public static List<Picture> findDesactivated() {
    	return PictureRemote.findDesactivated();
    }
    

}
