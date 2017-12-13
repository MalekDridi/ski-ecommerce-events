package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.Accomodation;
import persistence.Event;
import persistence.User;

@Remote
public interface EventManagementRemote {
	void addEvent(Event event);

	List<Event> findOPastEvents(User user);

	void updateEvent(Event event);

	List<Event> findAvailableEvents();

	List<Event> findCanceledEvents();

	List<Event> findPastEvents();

	List<Event> findOAvailableEvents(User user);

	void updateEventById(int id);

	List<Event> findAllEvents2(User u);

	void deleteEventById(int id);

	void deleteEvent(Event event);

	Accomodation findAccoByName(String Name);

	Event findEventById(int id);

	Accomodation findAccoById(int id);

	List<Event> findAllEvents();

	User findUserById(int id);

	List<Accomodation> findAllAccomodation();

	List<Event> findEventByMultiChoices(String location, String Station);

	Event findEventByName(String name);

	void cancelEvent(Event event);

}