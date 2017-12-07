package services;

import javax.ejb.Stateless;

import persistence.Accomodation;
import utilities.GenericDAO;

/**
 * Session Bean implementation class AccomodationService
 */
@Stateless
public class AccomodationService extends GenericDAO<Accomodation>
		implements AccomodationServiceRemote, AccomodationServiceLocal {

	/**
	 * Default constructor.
	 */
	public AccomodationService() {
		super(Accomodation.class);
	}

}
