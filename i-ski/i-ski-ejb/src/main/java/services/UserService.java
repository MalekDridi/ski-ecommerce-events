package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.User;
import utilities.GenericDAO;

/**
 * Session Bean implementation class UserService
 */
@Stateless
@LocalBean
@WebService(name = "UserPortype", portName = "UserPort", serviceName = "UserService")
public class UserService extends GenericDAO<User> implements UserServiceRemote, UserServiceLocal {

	@PersistenceContext
	private EntityManager entityManager;

	public UserService() {
		super(User.class);
	}

	@Override
	public User findByEmail(String l) {
		User user = null;
		String jpql = "SELECT u FROM User u WHERE u.email = :param1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", l);
		try {
			user = (User) query.getSingleResult();
			System.out.println("User found " + user.getEmail());
			return user;
		} catch (Exception e) {
			System.err.println("User Not found");
		}

		return null;

	}

	@Override
	public User login(String login, String password) {
		User user = null;
		String jpql = "SELECT u FROM User u WHERE u.email=:email AND u.password=:password";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("email", login);
		query.setParameter("password", password);
		try {
			user = (User) query.getSingleResult();
		} catch (Exception e) {
			System.err.println(e);
		}
		return user;
	}

}
