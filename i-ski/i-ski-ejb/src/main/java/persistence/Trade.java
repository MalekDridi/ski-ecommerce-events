package persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@ManyToOne
	private Equipment equipment;
	@ManyToOne
	private Feedback feedback;
	
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

	
}
