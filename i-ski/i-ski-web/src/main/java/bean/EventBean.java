package bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import persistence.Event;
import services.EventManagementLocal;

@ManagedBean
public class EventBean {
	private List<Event> MyEvents = new ArrayList<>();
	@ManagedProperty(value = "#{Identity}")
	private Identity identity;
	@EJB
	EventManagementLocal eventManagementLocal;
	
	
	
	public void doShowMyEvents() {
		MyEvents = eventManagementLocal.findAllEvents();}
	
	public List<Event> getMyEvents() {
		return MyEvents;
	}

	public void setMyEvents(List<Event> myEvents) {
		MyEvents = myEvents;
	}
	

}
