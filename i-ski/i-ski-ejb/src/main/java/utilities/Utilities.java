package utilities;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import persistence.Accomodation;
import persistence.SkiTrip;
import persistence.Station;
import persistence.User;
import services.AccomodationServiceLocal;
import services.SkiTripServiceLocal;
import services.UserServiceLocal;

/**
 * Session Bean implementation class Utilities
 */
@Singleton
@LocalBean
@Startup
public class Utilities {
	@EJB
	private UserServiceLocal userServiceLocal;
	@EJB
	private AccomodationServiceLocal accomodationServiceLocal;

	@EJB
	private SkiTripServiceLocal skiTripServiceLocal;

	/**
	 * Default constructor.
	 */
	public Utilities() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	private void init() {
		User user = new User("insaf");
		user.setEmail("i");
		user.setPassword("i");

		Station station = new Station("grenoble");

		SkiTrip skiTrip = new SkiTrip("re7la");
		skiTrip.setStation(station);
		skiTrip.setUser(userServiceLocal.update(user));

		Accomodation accomodation = new Accomodation("skiresort", 120F, 15, "hotel");
		Accomodation accomodation2 = new Accomodation("confort", 90F, 10, "house");
		Accomodation accomodation3 = new Accomodation("motel", 100F, 20, "motel");

		List<SkiTrip> skiTrips = new ArrayList<>();
		skiTrips.add(skiTripServiceLocal.update(skiTrip));

		accomodation.setSkiTrips(skiTrips);
		accomodation2.setSkiTrips(skiTrips);
		accomodation3.setSkiTrips(skiTrips);

		//userServiceLocal.update(user);

		accomodationServiceLocal.update(accomodation);
		accomodationServiceLocal.update(accomodation2);
		accomodationServiceLocal.update(accomodation3);
	}

}
