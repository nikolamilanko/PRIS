package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the KURS11 database table.
 * 
 */
@Entity
@NamedQuery(name="Kurs11.findAll", query="SELECT k FROM Kurs11 k")
public class Kurs11 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkursa;

	@Temporal(TemporalType.DATE)
	private Date datumkraja;

	@Temporal(TemporalType.DATE)
	private Date datumpocetka;

	private String nazivkursa;

	private String opiskursa;

	private int potrebnipoeni;

	//bi-directional many-to-one association to Ishod11
	@OneToMany(mappedBy="kurs11")
	private List<Ishod11> ishod11s;

	//bi-directional many-to-one association to Komentar11
	@OneToMany(mappedBy="kurs11")
	private List<Komentar11> komentar11s;

	//bi-directional many-to-one association to Predavac11
	@ManyToOne
	@JoinColumn(name="IDPREDAVACA")
	private Predavac11 predavac11;

	//bi-directional many-to-one association to Lekcija11
	@OneToMany(mappedBy="kurs11")
	private List<Lekcija11> lekcija11s;

	public Kurs11() {
	}

	public int getIdkursa() {
		return this.idkursa;
	}

	public void setIdkursa(int idkursa) {
		this.idkursa = idkursa;
	}

	public Date getDatumkraja() {
		return this.datumkraja;
	}

	public void setDatumkraja(Date datumkraja) {
		this.datumkraja = datumkraja;
	}

	public Date getDatumpocetka() {
		return this.datumpocetka;
	}

	public void setDatumpocetka(Date datumpocetka) {
		this.datumpocetka = datumpocetka;
	}

	public String getNazivkursa() {
		return this.nazivkursa;
	}

	public void setNazivkursa(String nazivkursa) {
		this.nazivkursa = nazivkursa;
	}

	public String getOpiskursa() {
		return this.opiskursa;
	}

	public void setOpiskursa(String opiskursa) {
		this.opiskursa = opiskursa;
	}

	public int getPotrebnipoeni() {
		return this.potrebnipoeni;
	}

	public void setPotrebnipoeni(int potrebnipoeni) {
		this.potrebnipoeni = potrebnipoeni;
	}

	public List<Ishod11> getIshod11s() {
		return this.ishod11s;
	}

	public void setIshod11s(List<Ishod11> ishod11s) {
		this.ishod11s = ishod11s;
	}

	public Ishod11 addIshod11(Ishod11 ishod11) {
		getIshod11s().add(ishod11);
		ishod11.setKurs11(this);

		return ishod11;
	}

	public Ishod11 removeIshod11(Ishod11 ishod11) {
		getIshod11s().remove(ishod11);
		ishod11.setKurs11(null);

		return ishod11;
	}

	public List<Komentar11> getKomentar11s() {
		return this.komentar11s;
	}

	public void setKomentar11s(List<Komentar11> komentar11s) {
		this.komentar11s = komentar11s;
	}

	public Komentar11 addKomentar11(Komentar11 komentar11) {
		getKomentar11s().add(komentar11);
		komentar11.setKurs11(this);

		return komentar11;
	}

	public Komentar11 removeKomentar11(Komentar11 komentar11) {
		getKomentar11s().remove(komentar11);
		komentar11.setKurs11(null);

		return komentar11;
	}

	public Predavac11 getPredavac11() {
		return this.predavac11;
	}

	public void setPredavac11(Predavac11 predavac11) {
		this.predavac11 = predavac11;
	}

	public List<Lekcija11> getLekcija11s() {
		return this.lekcija11s;
	}

	public void setLekcija11s(List<Lekcija11> lekcija11s) {
		this.lekcija11s = lekcija11s;
	}

	public Lekcija11 addLekcija11(Lekcija11 lekcija11) {
		getLekcija11s().add(lekcija11);
		lekcija11.setKurs11(this);

		return lekcija11;
	}

	public Lekcija11 removeLekcija11(Lekcija11 lekcija11) {
		getLekcija11s().remove(lekcija11);
		lekcija11.setKurs11(null);

		return lekcija11;
	}

}