package services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import persistence.Reservation;
import persistence.Transport;
import persistence.User;

@Local
public interface ReservationServicesLocal {
    String addReservation(User user , Transport transport , int nbPlace);
    
    void cancelReservation(Reservation r);

    public List<Reservation> checkReservation(User u, Transport t);

	Transport findTransportById(int id);

	List<Reservation> findAllReservations2(User user);

	List<Reservation> findAllTransportReservations();

	List<Reservation> checknbr(Transport t, Reservation r);

	

}