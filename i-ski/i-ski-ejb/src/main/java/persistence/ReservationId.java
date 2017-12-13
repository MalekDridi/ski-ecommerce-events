package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class ReservationId implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private int idUser;
	private int idTransport;
	private Date dateOfReservation;

	public ReservationId() {
		// TODO Auto-generated constructor stub
	}

	public ReservationId(int idUser, int idTransport) {
		super();
		this.idUser = idUser;
		this.idTransport = idTransport;
		this.dateOfReservation = new Date();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfReservation == null) ? 0 : dateOfReservation.hashCode());
		result = prime * result + idTransport;
		result = prime * result + idUser;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservationId other = (ReservationId) obj;
		if (dateOfReservation == null) {
			if (other.dateOfReservation != null)
				return false;
		} else if (!dateOfReservation.equals(other.dateOfReservation))
			return false;
		if (idTransport != other.idTransport)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdTransport() {
		return idTransport;
	}

	public void setIdTransport(int idTransport) {
		this.idTransport = idTransport;
	}

	public Date getDateOfReservation() {
		return dateOfReservation;
	}

	public void setDateOfReservation(Date dateOfReservation) {
		this.dateOfReservation = dateOfReservation;
	}

	public ReservationId(int idUser, int idTransport, Date dateOfReservation) {
		super();
		this.idUser = idUser;
		this.idTransport = idTransport;
		this.dateOfReservation = dateOfReservation;
	}

}
