package services;

import javax.ejb.Remote;
import javax.jws.WebService;

import persistence.User;
import utilities.IGenericDAO;

@Remote
@WebService
public interface UserServiceRemote extends IGenericDAO<User> {

	public User findByEmail(String l);

	User login(String login, String password);

}
