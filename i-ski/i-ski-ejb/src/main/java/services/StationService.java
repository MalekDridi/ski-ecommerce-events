package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import persistence.Station;

/**
 * Session Bean implementation class StationService
 */
@Stateless
public class StationService implements StationServiceRemote, StationServiceLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public StationService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addStation(Station station) {
		entityManager.persist(station);
	}

	@Override
	public void deleteStationById(int id) {
		entityManager.remove(findStationById(id));

	}

	@Override
	public List<Station> findAllStation(int id) {
		String jpql = "SELECT t FROM Station s";
		javax.persistence.Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Station findStationById(int id) {
		return entityManager.find(Station.class, id);
	}

	@Override
	public void deleteStation(Station station) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStation(Station station) {
		entityManager.merge(station);
	}

	@Override
	public void updateStationt(Station station) {
		// TODO Auto-generated method stub

	}

}
