package services;

import java.util.Date;
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
		entityManager.merge(rt);
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
		System.out.println("Transport ::::"+rt.getId());
		entityManager.createNativeQuery("DELETE FROM transport  WHERE id=" + rt.getId()).executeUpdate();
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

	@Override
	public List<Transport> findRTransportByUser(User user) {
		String jpql = "SELECT e FROM Transport e WHERE e.user = :param " ;
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", user);
		return query.getResultList();
		
	}

	

	@Override
	public List<Transport> findTransByParams(String moyen, String place) {
		String jpql = "SELECT e FROM Transport e WHERE e.moyenTransport like :param1 and e.fromP like :param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", "%"+moyen+"%");
		query.setParameter("param2", "%"+place+"%");
		return query.getResultList();	}
	 
	
	

}
