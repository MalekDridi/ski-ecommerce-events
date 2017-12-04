package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Accomodation;

/**
 * Session Bean implementation class AccomodationService
 */
@Stateless
@WebService(name = "ServiceAccomodationPortType", portName = "AccomodationPort", serviceName = "Accomodation", targetNamespace = "http://iski.tn", endpointInterface = "services.AccomodationServiceRemote")
public class AccomodationService implements AccomodationServiceRemote, AccomodationServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public AccomodationService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Accomodation> findAllAccomodation() {

		String jpql = "SELECT a FROM Accomodation a";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}
