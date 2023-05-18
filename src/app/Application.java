package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.EventoDao;
import entities.Evento;
import entities.TipoEvento;
import lombok.extern.slf4j.Slf4j;
import utils.JpaUtil;

@Slf4j
public class Application {
	private static EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		log.info("Hello World!");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EventoDao eventoDao = new EventoDao(entityManager);

		Evento primoEvento = new Evento("Mostra di pittura serale", LocalDate.now(), "Un evento leggendario",
				TipoEvento.PRIVATO, 15);
		eventoDao.saveEvent(primoEvento);

		eventoDao.getEventById(2);
		eventoDao.getEventByIdAndDelete(3);
//		eventoDao.refreshEvent(7);

		entityManager.close();
		entityManagerFactory.close();

	}

}
