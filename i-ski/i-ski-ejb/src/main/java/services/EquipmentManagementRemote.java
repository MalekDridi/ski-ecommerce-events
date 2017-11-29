package services;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import persistence.Equipment;


@Remote
@WebService
public interface EquipmentManagementRemote {

	@WebMethod
	@WebResult
	void addEquipment(Equipment equipment);

	@WebMethod(operationName="update")
	@WebResult(name="updateequipment")

	void updateEquipment(Equipment equipment);

	@WebMethod(operationName="deletebyid")
	@WebResult(name="res")

	void deleteEquipmentById(int id);

	@WebMethod (operationName="delete")
	@WebResult(name="res")

	void deleteEquipment(Equipment equipment);

	@WebMethod (operationName="findbyid")
	@WebResult(name="dd")

	Equipment findEquipmentById(int id);

	@WebMethod (operationName="findallequipments")
	@WebResult(name="list")

	List<Equipment> findAllEquipments();

}
