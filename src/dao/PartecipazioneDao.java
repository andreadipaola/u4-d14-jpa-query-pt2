package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Partecipazione;

public class PartecipazioneDao {
	private final EntityManager entityManager;

	public PartecipazioneDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void savePartecipation(Partecipazione partecipazione) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(partecipazione);
		transaction.commit();
		System.out.println("Partecipazione salvata correttamente!");
	}
}
