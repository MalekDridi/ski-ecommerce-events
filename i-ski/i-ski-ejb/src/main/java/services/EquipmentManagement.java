package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Equipment;

/**
 * Session Bean implementation class EquipmentManagement
 */
@Stateless
public class EquipmentManagement implements EquipmentManagementRemote, EquipmentManagementLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public EquipmentManagement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addEquipment(Equipment equipment) {
		entityManager.persist(equipment);

	}

	@Override
	public void updateEquipment(Equipment equipment) {
		entityManager.merge(equipment);

	}

	@Override
	public void deleteEquipmentById(int id) {
		entityManager.remove(findEquipmentById(id));

	}

	@Override
	public void deleteEquipment(Equipment equipment) {
		entityManager.remove(equipment);

	}

	@Override
	public Equipment findEquipmentById(int id) {
		return entityManager.find(Equipment.class, id);
	}

	@Override
	public List<Equipment> findAllEquipments() {
		String jpql = "SELECT e FROM Equipment e WHERE e.idUser=:User.idUser";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}
