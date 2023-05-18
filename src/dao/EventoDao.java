package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Evento;

public class EventoDao {
	private final EntityManager entityManager;

	public EventoDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void saveEvent(Evento evento) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(evento);
		transaction.commit();
		System.out.println("Evento salvato correttamente!");
	}

	public void getEventById(long id) {
		Evento foundEvent = entityManager.find(Evento.class, id);
		if (foundEvent != null) {
			System.out.println(foundEvent);
		} else {
			System.out.println("Ci dispiace ma l'evento " + id + " non è stato trovato");
		}
	}

	public void getEventByIdAndDelete(long id) {
		Evento foundEvent = entityManager.find(Evento.class, id);
		if (foundEvent != null) {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.remove(foundEvent);
			transaction.commit();
			System.out.println("Evento " + id + " eliminato con successo!");
		} else {
			System.out.println("Ci dispiace ma l'evento con id " + id + " non è stato trovato");
		}
	}

	public void refreshEvent(long id) {
		Evento foundEvent = entityManager.find(Evento.class, id);
		foundEvent.setTitolo("Rimpatriata 3a C");
		System.out.println("Pre Refresh");
		System.out.println(foundEvent);
		entityManager.refresh(foundEvent);
		System.out.println("Post Refresh");
		System.out.println(foundEvent);
	}
}
