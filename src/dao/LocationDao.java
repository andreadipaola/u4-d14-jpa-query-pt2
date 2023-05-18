package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Location;

public class LocationDao {
	private final EntityManager entityManager;

	public LocationDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void saveLocation(Location location) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(location);
		transaction.commit();
		System.out.println("Location salvata correttamente!");
	}
}
