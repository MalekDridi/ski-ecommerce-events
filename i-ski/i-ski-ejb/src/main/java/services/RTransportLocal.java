package services;

import java.util.List;

import javax.ejb.Local;

import persistence.Event;
import persistence.Transport;

@Local
public interface RTransportLocal {
	
	public Transport add(Transport rt);
	public Transport update(Transport rt);
	void deleteRtransport(Transport rt);
	public List<Transport> findAll();
	public Transport findById(Integer id);

}
