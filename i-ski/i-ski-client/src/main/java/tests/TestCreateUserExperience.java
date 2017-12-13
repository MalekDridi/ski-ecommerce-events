package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.SkiTrip;
import persistence.User;
import services.SkiTripServiceRemote;
import services.UserExperienceServiveRemote;
import services.UserServiceRemote;

public class TestCreateUserExperience {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();

		UserExperienceServiveRemote experienceServiveRemote = (UserExperienceServiveRemote) context
				.lookup("i-ski-ear/i-ski-ejb/UserExperienceServive!services.UserExperienceServiveRemote");

		UserServiceRemote userServiceRemote = (UserServiceRemote) context
				.lookup("i-ski-ear/i-ski-ejb/UserService!services.UserServiceRemote");

		SkiTripServiceRemote skiTripServiceRemote = (SkiTripServiceRemote) context
				.lookup("i-ski-ear/i-ski-ejb/SkiTripService!services.SkiTripServiceRemote");

		User user = userServiceRemote.find(1);
		SkiTrip skiTrip = skiTripServiceRemote.find(1);
		experienceServiveRemote.saveUserExperience(user, skiTrip, "mriguela", 10, "");

	}

}
