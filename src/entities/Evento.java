package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "eventi")
@Getter
@Setter
public class Evento {
	@Override
	public String toString() {
		return id + " | Titolo: " + titolo + " | Data Evento: " + dataEvento + " | Descrizione: " + descrizione
				+ " | Tipo Evento: " + tipoEvento + " | Max Partecipanti: " + numeroMassimoPartecipanti;
	}

	@Id
	@GeneratedValue
//	private UUID id;
	private long id;
	private String titolo;
	private LocalDate dataEvento;
	private String descrizione;
	@Enumerated(EnumType.STRING)
	private TipoEvento tipoEvento;
	private int numeroMassimoPartecipanti;

	public Evento() {
	}

	public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti) {
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}
}
