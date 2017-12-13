package services;

import javax.ejb.Local;

import persistence.Accomodation;
import utilities.IGenericDAO;

@Local
public interface AccomodationServiceLocal extends IGenericDAO<Accomodation> {

}
