package services;

import java.util.List;

import javax.ejb.Local;

import persistence.SkiTrip;
import persistence.User;
import utilities.IGenericDAO;

@Local
public interface SkiTripServiceLocal extends IGenericDAO<SkiTrip> {
	List<SkiTrip> ifndSkiTripsByUser(User user);
}
