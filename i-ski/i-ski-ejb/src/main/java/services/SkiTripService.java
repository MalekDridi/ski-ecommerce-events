package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import persistence.SkiTrip;
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

}
