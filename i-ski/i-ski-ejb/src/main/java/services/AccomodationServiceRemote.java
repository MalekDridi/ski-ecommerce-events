package services;

import javax.ejb.Remote;

import persistence.Accomodation;
import utilities.IGenericDAO;

@Remote
public interface AccomodationServiceRemote extends IGenericDAO<Accomodation>{

}
