package persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Transport implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRT;
	private Date dateIn;
	private Date dateOut;
	private String fromP;
	private String toP;
	private String moyenTransport;
	private int nombrePlaces;
	
	@OneToMany (mappedBy="transport")
	private List<User> users;
	
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
	

	public Transport() {
		super();
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
