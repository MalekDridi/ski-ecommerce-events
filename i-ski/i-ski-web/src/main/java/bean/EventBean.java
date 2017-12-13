package bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import persistence.Event;
import persistence.EventReservation;
import services.EventManagementLocal;
import services.EventReservationLocal;

@ManagedBean
@ViewScoped
public class EventBean {
	static Event event = new Event();
	private List<Event> MyEvents = new ArrayList<>();
	private List<Event> MyAvailableEvents = new ArrayList<>();
	private List<Event> MyCanceledEvents = new ArrayList<>();
	private List<Event> MyPastEvents = new ArrayList<>();
	private List<Event> OPastEvents = new ArrayList<>();
	
	private List<Event> OAvailablesEvents = new ArrayList<>();

	private List<Event> oEvents = new ArrayList<>();
	static Event event1;

	private List<Event> EventByUser = new ArrayList<>();
	private Event selectedEvent = new Event();
	private boolean showMyEventsList = false;
	@ManagedProperty(value = "#{identity}")
	private Identity identity;

	@EJB
	EventManagementLocal eventManagementLocal;
@EJB
EventReservationLocal rsl;
	@PostConstruct
	public void doShowAllEvents() {
		MyEvents = eventManagementLocal.findAllEvents();
		MyAvailableEvents = eventManagementLocal.findAvailableEvents();
		MyCanceledEvents = eventManagementLocal.findCanceledEvents();
		MyPastEvents = eventManagementLocal.findPastEvents();
		setOPastEvents(eventManagementLocal.findOPastEvents(identity.getUser()));
		setOAvailablesEvents(eventManagementLocal.findOAvailableEvents(identity.getUser()));
		// setMyTrades(tradeManagementLocal.findAllMyTrades(identity.getUser()));
		setoEvents(eventManagementLocal.findAllEvents2(identity.getUser()));
		selectedEvent.setUser(identity.getUser());
	}
	 public boolean checkReservation(Event e) {
		 if(rsl.checkReservation(identity.getUser(), e).size()==0)
			 return true;
		 return false;
		 
	 }
	

	public void doShowOEvents() {
		setoEvents(eventManagementLocal.findAllEvents2(identity.getUser()));

		// setMyTrades(tradeManagementLocal.findAllMyTrades(identity.getUser()));
	}

	public EventBean() {
		super();
	}

	public void doSelect() {
		showMyEventsList = true;
	}

	public String doAddEvent() {

		eventManagementLocal.addEvent(selectedEvent);
		return "/ListEventO?faces-redirect=true";

	}

	
	public String doCancelEvent(Event t ){
		
	
		t.setState("Canceled");
		eventManagementLocal.updateEvent(t);
		return "/ListEventA?faces-redirect=true";
	}
	
	public String doCancelEventO(Event t ){
		
		
		t.setState("Canceled");
		eventManagementLocal.updateEvent(t);
		return "/ListEventO?faces-redirect=true";
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

	public List<Event> getoEvents() {
		return oEvents;
	}

	public void setoEvents(List<Event> oEvents) {
		this.oEvents = oEvents;
	}
	public List<Event> getMyAvailableEvents() {
		return MyAvailableEvents;
	}
	public void setMyAvailableEvents(List<Event> myAvailableEvents) {
		MyAvailableEvents = myAvailableEvents;
	}
	public static Event getEvent1() {
		return event1;
	}
	public static void setEvent1(Event event1) {
		EventBean.event1 = event1;
	}
	public EventReservationLocal getRsl() {
		return rsl;
	}
	public void setRsl(EventReservationLocal rsl) {
		this.rsl = rsl;
	}
	public List<Event> getMyCanceledEvents() {
		return MyCanceledEvents;
	}
	public void setMyCanceledEvents(List<Event> myCanceledEvents) {
		MyCanceledEvents = myCanceledEvents;
	}
	public List<Event> getMyPastEvents() {
		return MyPastEvents;
	}
	public void setMyPastEvents(List<Event> myPastEvents) {
		MyPastEvents = myPastEvents;
	}
	public List<Event> getOPastEvents() {
		return OPastEvents;
	}
	public void setOPastEvents(List<Event> oPastEvents) {
		OPastEvents = oPastEvents;
	}
	public List<Event> getOAvailablesEvents() {
		return OAvailablesEvents;
	}
	public void setOAvailablesEvents(List<Event> oAvailablesEvents) {
		OAvailablesEvents = oAvailablesEvents;
	}

}
