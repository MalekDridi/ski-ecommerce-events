package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.SkiTrip;
import persistence.User;
import utilities.GenericDAO;

/**
 * Session Bean implementation class SkiTripService
 */
@Stateless
public class SkiTripService extends GenericDAO<SkiTrip> implements SkiTripServiceRemote, SkiTripServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public SkiTripService() {
		super(SkiTrip.class);
	}

	@Override
	public List<SkiTrip> ifndSkiTripsByUser(User user) {
		List<SkiTrip> skiTrips = null;
		Query query = entityManager.createQuery("SELECT s FROM SkiTrip s WHERE s.user=:param");
		skiTrips = query.setParameter("param", user).getResultList();
		return skiTrips;
	}

}
