package services;

import java.util.List;

import javax.ejb.Local;

import persistence.Equipment;

@Local
public interface EquipmentManagementLocal {
	void addEquipment(Equipment equipment);

	void updateEquipment(Equipment equipment);

	void deleteEquipmentById(int id);

	void deleteEquipment(Equipment equipment);

	Equipment findEquipmentById(int id);

	List<Equipment> findAllEquipments();
}
