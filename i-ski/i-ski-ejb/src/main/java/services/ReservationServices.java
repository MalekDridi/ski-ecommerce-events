package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Reservation;
import persistence.Transport;
import persistence.User;

@Stateless
@LocalBean
public class ReservationServices implements ReservationServicesRemote, ReservationServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	public ReservationServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Reservation> checkReservation(User u, Transport t) {
		String jpql = "SELECT e FROM Reservation e WHERE e.user = :param and e.transport = :param1 ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", u);
		query.setParameter("param1", t);
		return query.getResultList();
	}

	@Override
	public Transport findTransportById(int id) {
		return entityManager.find(Transport.class, id);
	}

	@Override
	public List<Reservation> findAllReservations2(User user) {
		String jpql = "SELECT e FROM Reservation e WHERE e.user = :param ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", user);
		return query.getResultList();

	}

	@Override
	public List<Reservation> findAllTransportReservations() {
		String jpql = "SELECT e FROM Reservation e ";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();

	}

	@Override
	public List<Reservation> checknbr(Transport t, Reservation r) {
		Query query = entityManager.createNativeQuery(
				"select r.nbr, t.nombrePlaces from reservation r inner join transport t on r.transport_id =t.id where t.nombrePlaces> r.nbr");
		return query.getResultList();
	}

	@Override
	public String addReservation(User user, Transport transport, int nbPlace) {
		if (nbPlace <= transport.getNombrePlaces()) {
			Reservation reservation = new Reservation(nbPlace, user, transport);
			int nbrDisponible = 0;
			nbrDisponible = transport.getNombrePlaces() - nbPlace;
			transport.setNombrePlaces(nbrDisponible);
			entityManager.merge(reservation);
		}
		return"";

	}

	@Override
	public void cancelReservation(Reservation r) {
		// entityManager.createNativeQuery("DELETE FROM reservation WHERE id=" +
		// r.getId()).executeUpdate();
		entityManager.remove(entityManager.merge(r));
		

	}

}
