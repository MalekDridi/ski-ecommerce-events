package services;

import java.util.List;

import javax.ejb.Local;

import persistence.Station;

@Local
public interface StationServiceLocal {
	void addStation(Station station);

	void deleteStation(Station station);;

	List<Station> findAllStation(int id);

	Station findStationById(int id);

	void updateStationt(Station station);


}
