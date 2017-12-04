package services;

import javax.ejb.Local;

import persistence.SkiTrip;
import persistence.User;
import persistence.UserExperience;
import persistence.UserExperienceId;

@Local
public interface UserExperienceServiveLocal {
	void saveUserExperience(User user, SkiTrip skiTrip, String description, int rate);

	UserExperience findUserExperienceById(UserExperienceId experienceId);
}
