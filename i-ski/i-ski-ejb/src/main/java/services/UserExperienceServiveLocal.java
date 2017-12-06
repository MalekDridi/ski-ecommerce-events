package services;

import java.util.List;

import javax.ejb.Local;

import persistence.ReviewUserExperience;
import persistence.SkiTrip;
import persistence.User;
import persistence.UserExperience;
import persistence.UserExperienceId;
import utilities.IGenericDAO;

@Local
public interface UserExperienceServiveLocal extends IGenericDAO<UserExperience> {
	void saveUserExperience(User user, SkiTrip skiTrip, String description, int rate);

	UserExperience findUserExperienceById(UserExperienceId experienceId);

	List<UserExperience> findUserExperiencesByUser(User user);

	void reviewUserExperience(UserExperience userExperience, ReviewUserExperience reviewUserExperience);
}
