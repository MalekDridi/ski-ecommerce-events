package services;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@Remote

@WebService
public interface AccomodationServiceRemote {

	@WebMethod(operationName = "findAllAccomodation")
	@WebResult(name = "list")

	List<persistence.Accomodation> findAllAccomodation();
}