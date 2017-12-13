package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: FeedbackPk
 *
 */
@Embeddable
public class FeedbackPk implements Serializable {

	private Trade idTrade;
	private User idUser;
	@Temporal(TemporalType.DATE)
	private Date feedbackDate;
	private static final long serialVersionUID = 1L;

	public FeedbackPk() {
		super();
	}
	
	
	

	public Date getFeedbackDate() {
		return feedbackDate;
	}

	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}




	public Trade getIdTrade() {
		return idTrade;
	}




	public void setIdTrade(Trade idTrade) {
		this.idTrade = idTrade;
	}




	public User getIdUser() {
		return idUser;
	}




	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((feedbackDate == null) ? 0 : feedbackDate.hashCode());
		result = prime * result + ((idTrade == null) ? 0 : idTrade.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
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
		FeedbackPk other = (FeedbackPk) obj;
		if (feedbackDate == null) {
			if (other.feedbackDate != null)
				return false;
		} else if (!feedbackDate.equals(other.feedbackDate))
			return false;
		if (idTrade == null) {
			if (other.idTrade != null)
				return false;
		} else if (!idTrade.equals(other.idTrade))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		return true;
	}




	public FeedbackPk(Trade idTrade, User idUser) {
		super();
		this.idTrade = idTrade;
		this.idUser = idUser;
		this.feedbackDate = new Date();
	}
	
	
	
	
}
