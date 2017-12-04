package services;

import java.util.List;

import javax.ejb.Stateless;
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
public class TradeManagement implements TradeManagementRemote, TradeManagementLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public TradeManagement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addTradeRequest(Trade trade) {
		entityManager.persist(trade);

	}

	@Override
	public void updateTradeRequest(Trade trade) {
		entityManager.merge(trade);

	}

	@Override
	public void deleteTradeRequestById(int id) {
		entityManager.remove(findTradeById(id));

	}

	@Override
	public void deleteTradeRequest(Trade trade) {
		entityManager.remove(trade);

	}

	@Override
	public List<Trade> findAllMyAcceptedTrades() {
		String jpql = "SELECT t FROM Trade t";
		javax.persistence.Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<Trade> findAllMyDeclinedTrades() {
		String jpql = "SELECT t FROM Trade t";
		javax.persistence.Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<Trade> findAllMyRequests(int user) {
		String jpql = "SELECT t FROM Trade t join t.User u WHERE u.id= :param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", user);
		return query.getResultList();
	}

	@Override
	public Trade findTradeById(int id) {
		return entityManager.find(Trade.class, id);
	}

	@Override
	public List<Trade> findAllMyTrades(User user) {
		String jpql = "FROM Trade WHERE idTrasmitter =:param1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", user);
		return query.getResultList();
	}

	@Override
	public List<Trade> findAllMyRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void acceptRequest(Trade trade) {
		trade.setState("accepted");
		updateTradeRequest(trade);
	}

}
