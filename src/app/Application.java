package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.EventoDao;
import dao.LocationDao;
import dao.PartecipazioneDao;
import dao.PersonaDao;
import entities.Evento;
import entities.Location;
import entities.Partecipazione;
import entities.Persona;
import entities.Sesso;
import entities.Stato;
import entities.TipoEvento;
import lombok.extern.slf4j.Slf4j;
import utils.JpaUtil;

@Slf4j
public class Application {
	private static EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		log.info("Hello World!");
		System.out.println();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EventoDao eventoDao = new EventoDao(entityManager);
		PersonaDao personaDao = new PersonaDao(entityManager);
		LocationDao locationDao = new LocationDao(entityManager);
		PartecipazioneDao partecipazioneDao = new PartecipazioneDao(entityManager);

		Evento primoEvento = new Evento("Cena con la regina", LocalDate.now(), "En evento leggendario", 15,
				TipoEvento.PRIVATO, primaLocation);
		eventoDao.saveEvent(primoEvento);
//		eventoDao.getEventById(2);
//		eventoDao.getEventByIdAndDelete(3);
//		eventoDao.refreshEvent(7);

		Persona primaPersona = new Persona("Mario", "Rossi", "mariorossi@gmail.com", Sesso.MASCHIO, LocalDate.now());
		personaDao.savePerson(primaPersona);
		Location primaLocation = new Location("Bologna", "Piazza Maggiore");
		locationDao.saveLocation(primaLocation);
		Partecipazione primaPartecipazione = new Partecipazione(primoEvento, primaPersona, Stato.CONFERMATA);
		partecipazioneDao.savePartecipation(primaPartecipazione);

		entityManager.close();
		entityManagerFactory.close();

	}

}
