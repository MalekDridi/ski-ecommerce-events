package services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import persistence.Transport;
import persistence.User;

@Local
public interface RTransportLocal {
	
	public Transport add(Transport rt);
	public Transport update(Transport rt);
	void deleteRtransport(Transport rt);
	public List<Transport> findAll();
	public Transport findById(Integer id);
    public List<Transport> findRTransportByUser(User user);
    List<Transport> findTransByParams(String moyen, String place ) ;
}
