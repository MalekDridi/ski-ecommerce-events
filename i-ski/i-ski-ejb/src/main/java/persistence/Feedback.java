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

	@EmbeddedId
	private FeedbackPk feedbackPk;
	private String description;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idUser", referencedColumnName = "idUser", insertable = false, updatable = false)
	private User user;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idTrade", referencedColumnName = "idTrade", insertable = false, updatable = false)
	private Trade trade;
	private static final long serialVersionUID = 1L;

	public Feedback() {
		super();
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

	public FeedbackPk getFeedbackPk() {
		return feedbackPk;
	}

	public void setFeedbackPk(FeedbackPk feedbackPk) {
		this.feedbackPk = feedbackPk;
	}

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}
	
   
}
