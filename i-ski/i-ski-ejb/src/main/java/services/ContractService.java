package services;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Company;
import persistence.Contract;
import persistence.User;

/**
 * Session Bean implementation class ContractService
 */
@Stateless
public class ContractService implements ContractServiceRemote, ContractServiceLocal {

	@PersistenceContext
	private EntityManager entityManager;
	/**
	 * Default constructor.
	 */

	@EJB
	private UserServiceRemote basicOpsLocal;

	@EJB
	private ContractServiceLocal contractServiceLocal;

	public ContractService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deleteContract(Contract C) {

		entityManager.remove(C);

	}

	@Override
	public List<Contract> findAllContracts() {
		String jpql = "SELECT com FROM Contract com";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	/*
	 * @Override public List<Contract> findContractsbyCompanybyID(int idcom) {
	 * String jpql = "SELECT z FROM Contract z WHERE z.company.id=:param"; Query
	 * query = entityManager.createQuery(jpql); query.setParameter("param",
	 * idcom); return query.getResultList(); }
	 * 
	 */

	public void SigneContract(java.util.Date sdate, java.util.Date edate, int montant, String des, int iduser,
			int idCompany, String etat) {

		Contract contract = new Contract(sdate, edate, montant, des, iduser, idCompany, etat);
		entityManager.persist(contract);

	}

	@Override
	public List<Contract> findContractsbyCompanybyID(int com) {
		String jpql = "SELECT z FROM Contract z WHERE z.company.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", com);
		return query.getResultList();
	}

	@Override
	public List<Contract> findContractNonAvailble() {
		String jpql = "SELECT z FROM Contract z WHERE z.etat=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", "nonValid");
		return query.getResultList();
	}

	@Override
	public List<Contract> findContractAvailble() {
		String jpql = "SELECT z FROM Contract z WHERE z.etat=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", "Valid");
		return query.getResultList();
	}

	@Override
	public void SigneContract(Date sdate, Date edate, int montant, String des, User u, Company com) {

	}

	@Override
	public void SigneContract(Date dd1, Date dd2, int a, String st, int iduser, int idCompany) {
		Contract contract = new Contract(dd1, dd2, a, st, iduser, idCompany);
		entityManager.persist(contract);

	}

	/*
	 * public void assingContracttouser(List<Contract> com, User u) {
	 * 
	 * List<Contract> contratcs = contractServiceLocal.findAllContracts();
	 * 
	 * for (Contract r : contratcs) { contratcs.add(r); }
	 * 
	 * u.setContract(contratcs);
	 * 
	 * basicOpsLocal.update(u); }
	 */

}
