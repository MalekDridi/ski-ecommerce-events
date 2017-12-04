package services;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebService;

import persistence.Equipment;

@Remote
@WebService
public interface EquipmentManagementRemote {

	void addEquipment(Equipment equipment);

	void updateEquipment(Equipment equipment);

	void deleteEquipmentById(int id);

	void deleteEquipment(Equipment equipment);

	Equipment findEquipmentById(int id);

	List<Equipment> findAllEquipments();

}
