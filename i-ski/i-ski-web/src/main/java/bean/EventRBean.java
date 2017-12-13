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
import services.EventReservationLocal;

@ManagedBean
@ViewScoped
public class EventRBean {
	@EJB
	EventReservationLocal rsl;

	@ManagedProperty(value = "#{identity}")
	private Identity identity;

	private List<EventReservation> oReservations = new ArrayList<>();
	private List<EventReservation> oReservations2 = new ArrayList<>();
	private List<EventReservation> listReservations = new ArrayList<>();
	private List<EventReservation> Reservations = new ArrayList<>();
	static EventReservation eventReservation;
	private List<EventReservation> ER = new ArrayList<>();
	static List<EventReservation> listEventReservation = new ArrayList<>();
	private List<EventReservation> MyReservations = new ArrayList<>();
	private EventReservation selectedEventReservation = new EventReservation();
	private float moy ;
	private int c;

	@PostConstruct
	public void doShowMyReservations() {
		MyReservations = rsl.findAllEventReservation();

		// setMyTrades(tradeManagementLocal.findAllMyTrades(identity.getUser()));
		setoReservations(rsl.findAllRReservations(identity.getUser()));
		setoReservations2(rsl.findAllHReservations(identity.getUser()));
	}
	public String doShowEventR(Event e) {

		ER=rsl.findAllReservations3(e);
		System.out.println(e.getName());
		for (EventReservation eventReservation : ER) {
			System.out.println(eventReservation.getRate());

		}
		return "/DetailsA?faces-redirect=true";
	}
	
	
	public void MoyenneRate(Event e) {
		ER=rsl.findAllReservations3(e);
	//	c=rsl.CountfindAllReservations3(ER);
		float a = 0;
		float b = 0;
		int i=0;
		for (EventReservation eventReservation : ER) {
			i=i+1;
			b=eventReservation.getRate();
			System.out.println(b);
a=a+b;
		}	
		moy=a/i;
	}
	
	public String doCancelEventR(EventReservation t) {

		t.setStateR("Canceled");
		rsl.updateEventReservation(t);
		return "/MyReservationEvent?faces-redirect=true";
	}

	public String doAddReservation(Event t) {

		eventReservation = new EventReservation();
		eventReservation.setEvent(t);
		
		eventReservation.setUser(identity.getUser());
		rsl.add(eventReservation);
		return "/ListEvent?faces-redirect=true";
	}

	public String doRateEvent(EventReservation t) {

		
		rsl.updateEventReservation(t);
		return "/ReservationsHistory?faces-redirect=true";
	}

	public String doCancelReservation(Event t) {

		eventReservation = new EventReservation();
		eventReservation.setEvent(t);
		;
		eventReservation.setUser(identity.getUser());
		rsl.findAllEventReservation();
		rsl.deleteEventReservation(eventReservation);
		return "/ListEvent?faces-redirect=true";
	}

	public void doShowEventReservation() {

		Reservations = rsl.findAllEventReservation();

	}

	public List<EventReservation> getListReservations() {
		return listReservations;
	}

	public void setListReservations(List<EventReservation> listReservations) {
		this.listReservations = listReservations;
	}

	public boolean checkReservation(Event t) {
		if (rsl.checkReservation(identity.getUser(), t).size() == 0)
			return true;
		return false;

	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public EventReservationLocal getRsl() {
		return rsl;
	}

	public void setRsl(EventReservationLocal rsl) {
		this.rsl = rsl;
	}

	public static EventReservation getEventReservation() {
		return eventReservation;
	}

	public static void setEventReservation(EventReservation eventReservation) {
		EventRBean.eventReservation = eventReservation;
	}

	public List<EventReservation> getoReservations() {
		return oReservations;
	}

	public void setoReservations(List<EventReservation> oReservations) {
		this.oReservations = oReservations;
	}

	public List<EventReservation> getMyReservations() {
		return MyReservations;
	}

	public void setMyReservations(List<EventReservation> myReservations) {
		MyReservations = myReservations;
	}

	public static List<EventReservation> getListEventReservation() {
		return listEventReservation;
	}

	public static void setListEventReservation(List<EventReservation> listEventReservation) {
		EventRBean.listEventReservation = listEventReservation;
	}

	public List<EventReservation> getReservations() {
		return Reservations;
	}

	public void setReservations(List<EventReservation> reservations) {
		Reservations = reservations;
	}

	public List<EventReservation> getoReservations2() {
		return oReservations2;
	}

	public void setoReservations2(List<EventReservation> oReservations2) {
		this.oReservations2 = oReservations2;
	}

	public EventReservation getSelectedEventReservation() {
		return selectedEventReservation;
	}

	public void setSelectedEventReservation(EventReservation selectedEventReservation) {
		this.selectedEventReservation = selectedEventReservation;
	}
	public List<EventReservation> getER() {
		return ER;
	}
	public void setER(List<EventReservation> eR) {
		ER = eR;
	}
	public float getMoy() {
		return moy;
	}
	public void setMoy(float moy) {
		this.moy = moy;
	}

}