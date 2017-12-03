package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Transport implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRT;
	private Date dateIn;
	private Date dateOut;
	private String fromP;
	private String toP;
	private String moyenTransport;
	private int nombrePlaces;
	@ManyToOne
	private User user;
	
	public int getIdRT() {
		return idRT;
	}
	public void setIdRT(int idRT) {
		this.idRT = idRT;
	}
	public Date getDateIn() {
		return dateIn;
	}
	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}
	public Date getDateOut() {
		return dateOut;
	}
	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}
	public String getFromP() {
		return fromP;
	}
	public void setFromP(String fromP) {
		this.fromP = fromP;
	}
	public String getToP() {
		return toP;
	}
	public void setToP(String toP) {
		this.toP = toP;
	}
	public String getMoyenTransport() {
		return moyenTransport;
	}
	public void setMoyenTransport(String moyenTransport) {
		this.moyenTransport = moyenTransport;
	}
	public int getNombrePlaces() {
		return nombrePlaces;
	}
	public void setNombrePlaces(int nombrePlaces) {
		this.nombrePlaces = nombrePlaces;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Transport(int idRT, Date dateIn, Date dateOut, String fromP, String toP, String moyenTransport,
			int nombrePlaces, User user) {
		super();
		this.idRT = idRT;
		this.dateIn = dateIn;
		this.dateOut = dateOut;
		this.fromP = fromP;
		this.toP = toP;
		this.moyenTransport = moyenTransport;
		this.nombrePlaces = nombrePlaces;
		this.user = user;
	}
	
	

}
