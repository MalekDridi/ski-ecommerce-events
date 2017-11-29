package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Trade;
import persistence.User;

/**
 * Session Bean implementation class TradeManagement
 */
@Stateless
@WebService(name="TradeServicePortType",portName="TradeService",serviceName="TradeService",
targetNamespace="http://iski.tn",endpointInterface="Service.TradeManagementRemote")
public class TradeManagement implements TradeManagementRemote, TradeManagementLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public TradeManagement() {
		// TODO Auto-generated constructor stub
	}
	@WebMethod
	@WebResult
	@Override
	public void addTradeRequest(Trade trade) {
		entityManager.persist(trade);

	}
	@WebMethod
	@WebResult
	@Override
	public void updateTradeRequest(Trade trade) {
		entityManager.merge(trade);

	}
	@WebMethod
	@WebResult
	@Override
	public void deleteTradeRequestById(int id) {
		entityManager.remove(findTradeById(id));

	}
	@WebMethod
	@WebResult
	@Override
	public void deleteTradeRequest(Trade trade) {
		entityManager.remove(trade);

	}
	@WebMethod
	@WebResult
	@Override
	public List<Trade> findAllMyAcceptedTrades() {
		String jpql = "SELECT t FROM Trade t";
		javax.persistence.Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	@WebMethod
	@WebResult
	@Override
	public List<Trade> findAllMyDeclinedTrades() {
		String jpql = "SELECT t FROM Trade t";
		javax.persistence.Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	@WebMethod
	@WebResult
	@Override
	public List<Trade> findAllMyRequests(int user) {
		String jpql = "SELECT t FROM Trade t join t.User u WHERE u.id= :param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", user);
		return query.getResultList();
	}
	@WebMethod
	@WebResult
	@Override
	public Trade findTradeById(int id) {
		return entityManager.find(Trade.class, id);
	}
	@WebMethod
	@WebResult
	@Override
	public List<Trade> findAllMyTrades(User user) {
		String jpql = "FROM Trade WHERE idTrasmitter =:param1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", user);
		return query.getResultList();
	}
	@WebMethod
	@WebResult
	@Override
	public List<Trade> findAllMyRequests() {
		// TODO Auto-generated method stub
		return null;
	}
	@WebMethod
	@WebResult
	@Override
	public void acceptRequest(Trade trade) {
		trade.setState("accepted");
		updateTradeRequest(trade);
	}
	
	

	

	
}
