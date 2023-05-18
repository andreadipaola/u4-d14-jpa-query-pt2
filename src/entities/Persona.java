package entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "persone")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

	@Id
	@SequenceGenerator(name = "persona_seq", sequenceName = "persona_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_seq")
	private int id;
	private String nome;
	private String cognome;
	private String email;
	private LocalDate datanascita;
	@Enumerated(EnumType.STRING)
	private Sesso sesso;
	@OneToMany(mappedBy = "persona", cascade = CascadeType.REMOVE)
	@OrderBy(value = "evento.dataEvento")
	private List<Partecipazione> listaPartecipazioni;

	@Override
	public String toString() {
		return id + " | Nome: " + nome + " | Cognome: " + cognome + " | email: " + email + " | Data di nascita: "
				+ datanascita + " | Sesso: " + sesso;
	}

}
