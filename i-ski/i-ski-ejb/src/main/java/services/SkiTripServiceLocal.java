package services;

import javax.ejb.Local;

import persistence.SkiTrip;
import utilities.IGenericDAO;

@Local
public interface SkiTripServiceLocal extends IGenericDAO<SkiTrip> {

}
