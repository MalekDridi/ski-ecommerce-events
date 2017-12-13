package services;

import javax.ejb.Remote;

import persistence.SkiTrip;
import utilities.IGenericDAO;

@Remote
public interface SkiTripServiceRemote extends IGenericDAO<SkiTrip>{
	
}
