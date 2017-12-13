package services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import persistence.Transport;

@Remote
public interface RTransportRemote {
	
	public Transport add(Transport rt);
	public Transport update(Transport rt);
	public void deleteRtransport(Transport rt);
	public List<Transport> findAll();
	public Transport findById(Integer id);

	List<Transport> findTransByParams(String moyen, String place ) ;
	}
