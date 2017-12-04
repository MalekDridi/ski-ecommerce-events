package persistence;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: UserExperience
 *
 */
@Entity

public class UserExperience implements Serializable {
	@EmbeddedId
	private UserExperienceId experienceId;
	private String description;
	private int rate;

	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "idUser", insertable = false, updatable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "idSkiTrip", referencedColumnName = "id", insertable = false, updatable = false)
	private SkiTrip skiTrip;
	private static final long serialVersionUID = 1L;

	public UserExperience() {
		super();
	}

	public UserExperience(int rate, String description, User user, SkiTrip skiTrip) {
		super();
		this.description = description;
		this.user = user;
		this.skiTrip = skiTrip;
		this.rate = rate;
		this.experienceId = new UserExperienceId(user.getIdUser(), skiTrip.getId());
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserExperienceId getExperienceId() {
		return experienceId;
	}

	public void setExperienceId(UserExperienceId experienceId) {
		this.experienceId = experienceId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SkiTrip getSkiTrip() {
		return skiTrip;
	}

	public void setSkiTrip(SkiTrip skiTrip) {
		this.skiTrip = skiTrip;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

}
