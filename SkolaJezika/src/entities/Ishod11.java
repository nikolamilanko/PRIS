package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ISHOD11 database table.
 * 
 */
@Entity
@NamedQuery(name="Ishod11.findAll", query="SELECT i FROM Ishod11 i")
public class Ishod11 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Ishod11PK id;

	private byte jepolozio;

	//bi-directional many-to-one association to Kurs11
	@ManyToOne
	@JoinColumn(name="IDKURSA")
	private Kurs11 kurs11;

	public Ishod11() {
	}

	public Ishod11PK getId() {
		return this.id;
	}

	public void setId(Ishod11PK id) {
		this.id = id;
	}

	public byte getJepolozio() {
		return this.jepolozio;
	}

	public void setJepolozio(byte jepolozio) {
		this.jepolozio = jepolozio;
	}

	public Kurs11 getKurs11() {
		return this.kurs11;
	}

	public void setKurs11(Kurs11 kurs11) {
		this.kurs11 = kurs11;
	}

}