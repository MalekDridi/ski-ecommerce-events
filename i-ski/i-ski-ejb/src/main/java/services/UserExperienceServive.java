package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import persistence.ReviewUserExperience;
import persistence.SkiTrip;
import persistence.User;
import persistence.UserExperience;
import persistence.UserExperienceId;
import utilities.GenericDAO;

/**
 * Session Bean implementation class UserExperienceServive
 */
@Stateless
public class UserExperienceServive extends GenericDAO<UserExperience>
		implements UserExperienceServiveRemote, UserExperienceServiveLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserExperienceServive() {
		super(UserExperience.class);
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

	@Override
	public List<UserExperience> findUserExperiencesByUser(User user) {
		return entityManager.createQuery("select e from UserExperience e where e.user=:param")
				.setParameter("param", user).getResultList();
	}

	@Override
	public void reviewUserExperience(UserExperience userExperience, ReviewUserExperience reviewUserExperience) {
		if (reviewUserExperience.equals(ReviewUserExperience.LIKE)) {
			int old = userExperience.getNbLike();
			old += 1;
			userExperience.setNbLike(old);
			entityManager.merge(userExperience);

		} else if (reviewUserExperience.equals(ReviewUserExperience.DISLIKE)) {
			int old = userExperience.getNbDisLike();
			old += 1;
			userExperience.setNbDisLike(old);
			entityManager.merge(userExperience);
		}
	}
}
