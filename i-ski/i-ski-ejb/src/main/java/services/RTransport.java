package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Event;
import persistence.Transport;
import persistence.User;

/**
 * Session Bean implementation class RTransport
 */
@Stateless
@LocalBean
public class RTransport implements RTransportRemote, RTransportLocal {

	@PersistenceContext
	private EntityManager entityManager;
    

	@Override
	public Transport add(Transport rt) {
		entityManager.persist(rt);
		entityManager.flush();
		return rt;
		
	}

	@Override
	public Transport update(Transport rt) {
		entityManager.merge(rt);
		return rt;
		
	}

	@Override
	public void deleteRtransport(Transport rt) {
		entityManager.remove(rt);
	}
	

	@Override
	public List<Transport> findAll() {
		String jpql = "SELECT com FROM Transport com";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
		}
	

	@Override
	public Transport findById(Integer id) {
		String jpql = "SELECT e FROM Transport e WHERE e.id =:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", id);
		return (Transport) query.getSingleResult();
	}

}
