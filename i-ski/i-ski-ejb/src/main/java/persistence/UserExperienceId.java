package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class UserExperienceId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idUser;
	private int idSkiTrip;
	private Date dateOfStory;

	public UserExperienceId() {
		// TODO Auto-generated constructor stub
	}

	public UserExperienceId(int idUser, int idSkiTrip) {
		super();
		this.idUser = idUser;
		this.idSkiTrip = idSkiTrip;
		this.dateOfStory = new Date();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfStory == null) ? 0 : dateOfStory.hashCode());
		result = prime * result + idSkiTrip;
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
		UserExperienceId other = (UserExperienceId) obj;
		if (dateOfStory == null) {
			if (other.dateOfStory != null)
				return false;
		} else if (!dateOfStory.equals(other.dateOfStory))
			return false;
		if (idSkiTrip != other.idSkiTrip)
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

	public int getIdSkiTrip() {
		return idSkiTrip;
	}

	public void setIdSkiTrip(int idSkiTrip) {
		this.idSkiTrip = idSkiTrip;
	}

	public Date getDateOfStory() {
		return dateOfStory;
	}

	public void setDateOfStory(Date dateOfStory) {
		this.dateOfStory = dateOfStory;
	}

}
