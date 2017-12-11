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
	public void saveUserExperience(User user, SkiTrip skiTrip, String description, int rate,String img) {
		UserExperience userExperience = new UserExperience(rate, description, user, skiTrip,img);

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
	public void reviewUserExperience(User user, UserExperience userExperience,
			ReviewUserExperience reviewUserExperience) {
		if (reviewUserExperience.equals(ReviewUserExperience.LIKE)) {
			if (!userExperience.getLikerUsers().contains(user)) {
				int old = userExperience.getNbLike();
				old += 1;
				userExperience.setNbLike(old);
				entityManager.merge(userExperience);

			} else {
				System.out.println("already send review");
			}

		} else if (reviewUserExperience.equals(ReviewUserExperience.DISLIKE)) {
			if (!userExperience.getDisLikerUsers().contains(user)) {

				int old = userExperience.getNbDisLike();
				old += 1;
				userExperience.setNbDisLike(old);
				entityManager.merge(userExperience);
			} else {
				System.out.println("already send review");
			}
		}
	}

//	public void addUserToUsersReviewed(User user, UserExperience userExperience,
//			ReviewUserExperience reviewUserExperience) {
//		if (reviewUserExperience.equals(ReviewUserExperience.LIKE)) {
//			List<User> users = entityManager
//					.createQuery("select u from User u where :p member of u.experiencesLiked   ")
//					.setParameter("p", userExperience).getResultList();
//		}
//	}
}
