package services;

import javax.ejb.Remote;

import persistence.SkiTrip;
import persistence.User;
import persistence.UserExperience;
import persistence.UserExperienceId;

@Remote
public interface UserExperienceServiveRemote {
	void saveUserExperience(User user, SkiTrip skiTrip, String description, int rate,String img);

	UserExperience findUserExperienceById(UserExperienceId experienceId);
}
