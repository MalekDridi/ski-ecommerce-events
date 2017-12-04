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
@SuppressWarnings("serial")
public class FeedbackPk implements Serializable {

	private int idTrade;
	private int idUser;
	@Temporal(TemporalType.DATE)
	private Date feedbackDate;
	private static final long serialVersionUID = 1L;

	public FeedbackPk() {
		super();
	}

	public int getIdTrade() {
		return idTrade;
	}

	public void setIdTrade(int idTrade) {
		this.idTrade = idTrade;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Date getFeedbackDate() {
		return feedbackDate;
	}

	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((feedbackDate == null) ? 0 : feedbackDate.hashCode());
		result = prime * result + idTrade;
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
		FeedbackPk other = (FeedbackPk) obj;
		if (feedbackDate == null) {
			if (other.feedbackDate != null)
				return false;
		} else if (!feedbackDate.equals(other.feedbackDate))
			return false;
		if (idTrade != other.idTrade)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

}
