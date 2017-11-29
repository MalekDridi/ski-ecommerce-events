package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Trade
 *
 */
@Entity

public class Trade implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTrade;
	private String message;
	private Date tradeDate;
	@ManyToOne
	private User idTrasmitter;
	@ManyToOne
	private User idReceiver;
	private String state;
	@OneToOne
	private Equipment equipment;
	private static final long serialVersionUID = 1L;

	public Trade() {
		super();
	}

	public Trade(String message, User idTrasmitter, User idReceiver, String state, Equipment equipment) {
		super();
		this.message = message;
		this.idTrasmitter = idTrasmitter;
		this.idReceiver = idReceiver;
		this.state = state;
		this.equipment = equipment;
	}
	
	
	
	
	public Trade(String state) {
		super();
		this.state = state;
	}

	public Trade(String message, Date tradeDate, String state, Equipment equipment) {
		super();
		this.message = message;
		this.tradeDate = tradeDate;
		this.state = state;
		this.equipment = equipment;
	}

	public Trade(String message, String state, Equipment equipment) {
		super();
		this.message = message;
		this.state = state;
		this.equipment = equipment;
	}

	public Trade(String message, Date tradeDate, User idTrasmitter, User idReceiver, String state,
			Equipment equipment) {
		super();
		this.message = message;
		this.tradeDate = tradeDate;
		this.idTrasmitter = idTrasmitter;
		this.idReceiver = idReceiver;
		this.state = state;
		this.equipment = equipment;
	}

	public int getIdTrade() {
		return this.idTrade;
	}

	public void setIdTrade(int idTrade) {
		this.idTrade = idTrade;
	}

	public Date getTradeDate() {
		return this.tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public User getIdTrasmitter() {
		return idTrasmitter;
	}

	public void setIdTrasmitter(User idTrasmitter) {
		this.idTrasmitter = idTrasmitter;
	}

	public User getIdReceiver() {
		return idReceiver;
	}

	public void setIdReceiver(User idReceiver) {
		this.idReceiver = idReceiver;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTrasmitter == null) ? 0 : idTrasmitter.hashCode());
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
		Trade other = (Trade) obj;
		if (idTrasmitter == null) {
			if (other.idTrasmitter != null)
				return false;
		} else if (!idTrasmitter.equals(other.idTrasmitter))
			return false;
		return true;
	}

}
