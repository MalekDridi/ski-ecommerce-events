package services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import persistence.Company;
import persistence.Contract;
import persistence.User;



@Local
public interface ContractServiceLocal {


	void deleteContract(Contract C );

	List<Contract> findContractsbyCompanybyID(int idcom);

	List<Contract> findAllContracts();


	void SigneContract(java.util.Date dd1, java.util.Date dd2, int a, String st, int iduser, int idCompany, String etat);
	void SigneContract(java.util.Date dd1, java.util.Date dd2, int a, String st, int iduser, int idCompany);
	void SigneContract(java.util.Date sdate, java.util.Date edate, int montant, String des, User u, Company com);

	List<Contract> findContractNonAvailble();

	List<Contract> findContractAvailble();

	void updateC(Contract com);




	
}
