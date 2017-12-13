package services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Event;
import persistence.EventReservation;
import persistence.User;

@Stateless
@LocalBean
public class EventReservationServices implements EventReservationLocal, EventReservationRemote {

	@PersistenceContext
	private EntityManager entityManager;

	public EventReservationServices() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void updateEventReservation(EventReservation eventr) {
		entityManager.merge(eventr);
	}
	@Override
	public EventReservation add(EventReservation rt) {

		entityManager.persist(rt);
		entityManager.flush();
		return rt;
	}

	@Override
	public List<EventReservation> findAllEventReservation() {
		String jpql = "SELECT u FROM EventReservation u";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public void deleteEventReservationById(int id) {
		entityManager.remove(findEventReservationById(id));
	}

	@Override
	public List<EventReservation> findAllReservations2(User user) {

		String jpql = "SELECT c FROM EventReservation c WHERE c.user=:p";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("p", user);
		return query.getResultList();
	}

	@Override
	public List<EventReservation> findAllRReservations(User user) {

		String jpql = "SELECT c FROM EventReservation c WHERE c.user=:p and c.event.endDate> :date and c.stateR=:k and c.event.state=:z";

		Query query = entityManager.createQuery(jpql);
		Date date = Calendar.getInstance().getTime();
		query.setParameter("p", user);
		query.setParameter("date", date);
		query.setParameter("k", "available");
		query.setParameter("z", "available");
		return query.getResultList();
	}
	
	@Override
	public List<EventReservation> findAllHReservations(User user) {

		String jpql = "SELECT c FROM EventReservation c WHERE c.user=:p and c.event.endDate< :date";

		Query query = entityManager.createQuery(jpql);
		Date date = Calendar.getInstance().getTime();
		query.setParameter("p", user);
		query.setParameter("date", date);

		return query.getResultList();
	}
	
	@Override
	public List<EventReservation> countR(List<EventReservation> er) {

		String jpql = "SELECT count(*) FROM EventReservation c WHERE c.event=:p";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("p", er);
		return query.getResultList();
	}
	
	
	@Override
	public List<EventReservation> CountfindAllReservations3(Event event) {

		String jpql = "Count c FROM EventReservation c WHERE c.event=:p";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("p", event);
		return query.getResultList();
	}
	@Override
	public List<EventReservation> findAllReservations3(Event event) {

		String jpql = "SELECT c FROM EventReservation c WHERE c.event=:p";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("p", event);
		return query.getResultList();
	}

	@Override
	public List<EventReservation> checkReservation(User u, Event e) {

		String jpql = "SELECT e FROM EventReservation e WHERE e.user=:param AND e.event=:param1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", u);
		query.setParameter("param1", e);
		return query.getResultList();
	}

	@Override
	public Event findEventById(int id) {
		return entityManager.find(Event.class, id);
	}

	@Override
	public EventReservation findEventReservationById(int id) {
		return entityManager.find(EventReservation.class, id);
	}

	@Override
	public void deleteEventReservation(EventReservation eventr) {
		entityManager.remove(eventr);
	}
}