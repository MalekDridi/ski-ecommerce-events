package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.Event;
import persistence.EventReservation;
import persistence.User;

@Remote
public interface EventReservationRemote {

	public EventReservation add(EventReservation rt);
	public List<EventReservation> checkReservation(User u, Event e);
	 Event findEventById(int id);
		List<EventReservation> findAllReservations2(User user);

		List<EventReservation> findAllEventReservation();
		EventReservation findEventReservationById(int id);
		List<EventReservation> countR(List<EventReservation> er);
		List<EventReservation> CountfindAllReservations3(Event event);

		void deleteEventReservationById(int id);
		void deleteEventReservation(EventReservation eventr);
		List<EventReservation> findAllReservations3(Event event);
		List<EventReservation> findAllRReservations(User user);
		List<EventReservation> findAllHReservations(User user);
		void updateEventReservation(EventReservation eventr);

}
