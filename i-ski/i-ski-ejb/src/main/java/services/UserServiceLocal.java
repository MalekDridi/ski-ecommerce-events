package services;

import javax.ejb.Local;

import persistence.User;
import utilities.IGenericDAO;

@Local
public interface UserServiceLocal extends IGenericDAO<User> {

	public User findByEmail(String l);

	User login(String login, String password);
	

}
