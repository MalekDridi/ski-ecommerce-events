package persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Feedback
 *
 */
@Entity

public class Feedback implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFeedback;
	private Date dateFeedback;
	private String description;
	@ManyToOne
	private User user;
	@OneToMany(mappedBy = "feedback")
	private List<Trade> trades;
	private static final long serialVersionUID = 1L;

	public Feedback() {
		super();
	}   
	public int getIdFeedback() {
		return this.idFeedback;
	}

	public void setIdFeedback(int idFeedback) {
		this.idFeedback = idFeedback;
	}   
	public Date getDateFeedback() {
		return this.dateFeedback;
	}

	public void setDateFeedback(Date dateFeedback) {
		this.dateFeedback = dateFeedback;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Trade> getTrades() {
		return trades;
	}
	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}
	
   
}
