package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Feedback
 *
 */
@Entity

public class Feedback implements Serializable {

	@EmbeddedId
	private FeedbackPk feedbackPk;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date dateOfFeedback;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idUser", referencedColumnName = "idUser", insertable = false, updatable = false)
	private User user;
	@ManyToOne
	@JoinColumn(name = "idTrade", referencedColumnName = "idTrade", insertable = false, updatable = false)
	private Trade trade;
	@Enumerated(EnumType.STRING)
	private TypeOfFeedback typeOfFeedback;
	private static final long serialVersionUID = 1L;

	public Feedback() {
		super();
	}

	public Feedback(FeedbackPk feedbackPk, String description, Date dateOfFeedback, User user, Trade trade) {
		super();
		this.feedbackPk = new FeedbackPk(trade, user);
		this.description = description;
		this.dateOfFeedback = dateOfFeedback;
		this.user = user;
		this.trade = trade;
	}

	public Date getDateOfFeedback() {
		return dateOfFeedback;
	}

	public void setDateOfFeedback(Date dateOfFeedback) {
		this.dateOfFeedback = dateOfFeedback;
	}

	public TypeOfFeedback getTypeOfFeedback() {
		return typeOfFeedback;
	}

	public void setTypeOfFeedback(TypeOfFeedback typeOfFeedback) {
		this.typeOfFeedback = typeOfFeedback;
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
