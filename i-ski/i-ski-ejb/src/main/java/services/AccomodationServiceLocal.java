package services;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AccomodationServiceLocal {
	List<persistence.Accomodation> findAllAccomodation();
}
