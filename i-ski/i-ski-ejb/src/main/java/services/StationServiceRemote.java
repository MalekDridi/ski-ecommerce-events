package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.Station;

@Remote
public interface StationServiceRemote {

	void addStation(Station station);

	void deleteStationById(int  id);;

	List<Station> findAllStation(int id);

	Station findStationById(int id);

	void updateStation(Station station);

}
