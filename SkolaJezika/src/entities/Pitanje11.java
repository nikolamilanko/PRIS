package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PITANJE11 database table.
 * 
 */
@Entity
@NamedQuery(name="Pitanje11.findAll", query="SELECT p FROM Pitanje11 p")
public class Pitanje11 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idpitanja;

	private int brpitanja;

	private String tekstpitanja;

	//bi-directional many-to-one association to Odgovor11
	@OneToMany(mappedBy="pitanje11")
	private List<Odgovor11> odgovor11s;

	//bi-directional many-to-one association to Test11
	@ManyToOne
	@JoinColumn(name="IDTESTA")
	private Test11 test11;

	public Pitanje11() {
	}

	public int getIdpitanja() {
		return this.idpitanja;
	}

	public void setIdpitanja(int idpitanja) {
		this.idpitanja = idpitanja;
	}

	public int getBrpitanja() {
		return this.brpitanja;
	}

	public void setBrpitanja(int brpitanja) {
		this.brpitanja = brpitanja;
	}

	public String getTekstpitanja() {
		return this.tekstpitanja;
	}

	public void setTekstpitanja(String tekstpitanja) {
		this.tekstpitanja = tekstpitanja;
	}

	public List<Odgovor11> getOdgovor11s() {
		return this.odgovor11s;
	}

	public void setOdgovor11s(List<Odgovor11> odgovor11s) {
		this.odgovor11s = odgovor11s;
	}

	public Odgovor11 addOdgovor11(Odgovor11 odgovor11) {
		getOdgovor11s().add(odgovor11);
		odgovor11.setPitanje11(this);

		return odgovor11;
	}

	public Odgovor11 removeOdgovor11(Odgovor11 odgovor11) {
		getOdgovor11s().remove(odgovor11);
		odgovor11.setPitanje11(null);

		return odgovor11;
	}

	public Test11 getTest11() {
		return this.test11;
	}

	public void setTest11(Test11 test11) {
		this.test11 = test11;
	}

}