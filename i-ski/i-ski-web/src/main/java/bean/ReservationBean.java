package bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import persistence.Reservation;
import persistence.Transport;
import services.RTransportLocal;
import services.ReservationServicesLocal;

@ManagedBean
@ViewScoped
public class ReservationBean {
	@EJB
	ReservationServicesLocal rsl;
	
	@ManagedProperty(value="#{identity}")
	private Identity identity;
	private List<Reservation> oReservations =new ArrayList<>();
	static Reservation reservation;
	private List<Reservation> listReservation =new ArrayList<>();
	private List<Reservation> mylist =new ArrayList<>();
	private Transport transportSelected= new Transport();
	private Reservation reservationSelected= new Reservation();
	private int nbPlaces;
	private Date date;

@PostConstruct
	
	public void doShowMyReservations(){
	listReservation=rsl.findAllTransportReservations();
	mylist=rsl.findAllReservations2(identity.getUser());
}

public List<Reservation> getMylist() {
	return mylist;
}

public void setMylist(List<Reservation> mylist) {
	this.mylist = mylist;
}

public void doAddReservation( ){
	rsl.addReservation(identity.getUser(), transportSelected, nbPlaces);
	
}
public void cancelReservation(Reservation r){
	System.out.println("FAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA555555555555555555555555555555");
	rsl.cancelReservation(r);
	mylist=rsl.findAllReservations2(identity.getUser());
	
	
}

 public Reservation getReservationSelected() {
	return reservationSelected;
}

public void setReservationSelected(Reservation reservationSelected) {
	this.reservationSelected = reservationSelected;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public boolean checkReservation(Transport t ){
	 if(rsl.checkReservation(identity.getUser(), t).size()==0)
		 return true;
	 
	
		 
	 
	 
	 return false;
 }
 
 
 public Identity getIdentity() {
		return identity;
	}
	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	public ReservationServicesLocal getRsl() {
		return rsl;
	}

	public void setRsl(ReservationServicesLocal rsl) {
		this.rsl = rsl;
	}

	public List<Reservation> getoReservations() {
		return oReservations;
	}

	public void setoReservations(List<Reservation> oReservations) {
		this.oReservations = oReservations;
	}

	public static Reservation getReservation() {
		return reservation;
	}

	public static void setReservation(Reservation reservation) {
		ReservationBean.reservation = reservation;
	}

	public List<Reservation> getListReservation() {
		return listReservation;
	}

	public void setListReservation(List<Reservation> listReservation) {
		this.listReservation = listReservation;
	}

	public Transport getTransportSelected() {
		return transportSelected;
	}

	public void setTransportSelected(Transport transportSelected) {
		this.transportSelected = transportSelected;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

}
