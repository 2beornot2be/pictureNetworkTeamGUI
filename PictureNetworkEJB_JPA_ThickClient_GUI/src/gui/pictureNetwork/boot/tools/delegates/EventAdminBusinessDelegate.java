package gui.pictureNetwork.boot.tools.delegates;

import gui.pictureNetwork.boot.tools.ServiceLocator;
import interfaces.EventBeanRemote;

import java.util.List;

import entities.Event;

public class EventAdminBusinessDelegate  
{
	private static EventBeanRemote EventRemote = null;
	
	private static void init()
	{
		EventRemote = (EventBeanRemote) ServiceLocator.getInstance().lookupProxy("/pictureNetworkEJB_JPA/EventBean!interfaces.EventBeanRemote");
	}
	
	public static Boolean addEvent(Event Event)
	{
		init();
		return EventRemote.addEvent(Event);
	}
	public static void removeEvent(Event Event)
	{
		init();
		EventRemote.removeEvent(Event);
	}
	public static Boolean updateEvent(Event Event)
	{
		init();
		return EventRemote.updateEvent(Event);
	}
	public static void removeEvent(int id)
	{
		init();
		EventRemote.removeEvent(id);
	}
	public static Event findEvent(int id)
	{
		init();
		return EventRemote.findEvent(id);
	}
	
	public static List<Event> findAllEvent()
	{
		init();
		return EventRemote.findAllEvents();
	}

}
