package persistence;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reservation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private ReservationId reservationId;
	private int nbPlace;

	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "idUser", insertable = false, updatable = false)
	private User user;

	@ManyToOne
	(cascade=CascadeType.MERGE )
	@JoinColumn(name = "idTransport", referencedColumnName = "id", insertable = false, updatable = false)
	private Transport transport;

	public Reservation(User user, Transport transport) {
		super();
		this.user = user;
		this.transport = transport;
	}

	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public Reservation(int nbPlace, User user, Transport transport) {
		super();
		this.nbPlace = nbPlace;
		this.user = user;
		this.transport = transport;
		this.reservationId = new ReservationId(user.getIdUser(), transport.getId());
	}

	public ReservationId getReservationId() {
		return reservationId;
	}

	public void setReservationId(ReservationId reservationId) {
		this.reservationId = reservationId;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

}
