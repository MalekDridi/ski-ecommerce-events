package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import persistence.SkiTrip;
import persistence.User;
import persistence.UserExperience;
import persistence.UserExperienceId;

/**
 * Session Bean implementation class UserExperienceServive
 */
@Stateless
public class UserExperienceServive implements UserExperienceServiveRemote, UserExperienceServiveLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserExperienceServive() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveUserExperience(User user, SkiTrip skiTrip, String description, int rate) {
		UserExperience userExperience = new UserExperience(rate, description, user, skiTrip);

		entityManager.merge(userExperience);

	}

	@Override
	public UserExperience findUserExperienceById(UserExperienceId experienceId) {
		return entityManager.find(UserExperience.class, experienceId);
	}

}
