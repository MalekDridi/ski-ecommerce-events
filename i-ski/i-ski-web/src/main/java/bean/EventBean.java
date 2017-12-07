package bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import persistence.Event;
import services.EventManagementLocal;

@ManagedBean
@ViewScoped
public class EventBean {
	static Event event = new Event();
	private List<Event> MyEvents = new ArrayList<>();
	private List<Event> OEvents = new ArrayList<>();

	
	private List<Event> EventByUser = new ArrayList<>();
	private Event selectedEvent = new Event();
	private boolean showMyEventsList = false;
	@ManagedProperty(value = "#{identity}")
	private Identity identity;

	@EJB
	EventManagementLocal eventManagementLocal;


	@PostConstruct
	public void doShowAllEvents() {
		MyEvents = eventManagementLocal.findAllEvents();
		// setMyTrades(tradeManagementLocal.findAllMyTrades(identity.getUser()));
	}


	public void doShowOEvents() {
		OEvents = eventManagementLocal.findAllEvents2(identity.getUser());
		
		// setMyTrades(tradeManagementLocal.findAllMyTrades(identity.getUser()));
	} 

	public EventBean() {
		super();
	}



	public void doSelect() {
		showMyEventsList = true;
	}

	
public void doAddEvent(){
		
		eventManagementLocal.addEvent(selectedEvent);
		
		
	}



	public static Event getEvent() {
		return event;
	}



	public static void setEvent(Event event) {
		EventBean.event = event;
	}



	public List<Event> getMyEvents() {
		return MyEvents;
	}



	public void setMyEvents(List<Event> myEvents) {
		MyEvents = myEvents;
	}



	public List<Event> getEventByUser() {
		return EventByUser;
	}



	public void setEventByUser(List<Event> eventByUser) {
		EventByUser = eventByUser;
	}



	public boolean isShowMyEventsList() {
		return showMyEventsList;
	}



	public void setShowMyEventsList(boolean showMyEventsList) {
		this.showMyEventsList = showMyEventsList;
	}



	public Identity getIdentity() {
		return identity;
	}



	public void setIdentity(Identity identity) {
		this.identity = identity;
	}



	public EventManagementLocal getEventManagementLocal() {
		return eventManagementLocal;
	}



	public void setEventManagementLocal(EventManagementLocal eventManagementLocal) {
		this.eventManagementLocal = eventManagementLocal;
	}



	public EventBean(List<Event> myEvents, List<Event> eventByUser, boolean showMyEventsList, Identity identity,
			EventManagementLocal eventManagementLocal) {
		super();
		MyEvents = myEvents;
		EventByUser = eventByUser;
		this.showMyEventsList = showMyEventsList;
		this.identity = identity;
		this.eventManagementLocal = eventManagementLocal;
	}



	public Event getSelectedEvent() {
		return selectedEvent;
	}



	public void setSelectedEvent(Event selectedEvent) {
		this.selectedEvent = selectedEvent;
	}


	public List<Event> getOEvents() {
		return OEvents;
	}


	public void setOEvents(List<Event> oEvents) {
		OEvents = oEvents;
	}





}
