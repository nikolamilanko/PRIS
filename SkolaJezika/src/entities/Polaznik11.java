package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the POLAZNIK11 database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Polaznik11.findAll", query="SELECT p FROM Polaznik11 p"),
	@NamedQuery(name="Polaznik11.findZaUsernameIPassword", query="SELECT p FROM Polaznik11 p WHERE p.logovanje11.idlogovanja=(SELECT l.idlogovanja FROM Logovanje11 l WHERE l.username=:username AND l.password=:password)")
})
@Table(name="POLAZNIK11")
public class Polaznik11 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idpolaznika;

	@Temporal(TemporalType.DATE)
	private Date datumrodjenja;

	private String emailpolaznika;

	private String imepolaznika;

	private String prezimepolaznika;

	//bi-directional many-to-one association to Ocenakursa
	@OneToMany(mappedBy="polaznik11")
	private List<Ocenakursa> ocenakursas;

	//bi-directional many-to-one association to Ishod11
	@OneToMany(mappedBy="polaznik11")
	private List<Ishod11> ishod11s;

	//bi-directional many-to-one association to Komentar11
	@OneToMany(mappedBy="polaznik11")
	private List<Komentar11> komentar11s;

	//bi-directional many-to-one association to Odgovor11
	@OneToMany(mappedBy="polaznik11")
	private List<Odgovor11> odgovor11s;

	//bi-directional many-to-one association to Logovanje11
	@ManyToOne
	@JoinColumn(name="IDLOGOVANJA")
	private Logovanje11 logovanje11;

	//bi-directional many-to-one association to Rezultat11
	@OneToMany(mappedBy="polaznik11")
	private List<Rezultat11> rezultat11s;

	public Polaznik11() {
	}

	public int getIdpolaznika() {
		return this.idpolaznika;
	}

	public void setIdpolaznika(int idpolaznika) {
		this.idpolaznika = idpolaznika;
	}

	public Date getDatumrodjenja() {
		return this.datumrodjenja;
	}

	public void setDatumrodjenja(Date datumrodjenja) {
		this.datumrodjenja = datumrodjenja;
	}

	public String getEmailpolaznika() {
		return this.emailpolaznika;
	}

	public void setEmailpolaznika(String emailpolaznika) {
		this.emailpolaznika = emailpolaznika;
	}

	public String getImepolaznika() {
		return this.imepolaznika;
	}

	public void setImepolaznika(String imepolaznika) {
		this.imepolaznika = imepolaznika;
	}

	public String getPrezimepolaznika() {
		return this.prezimepolaznika;
	}

	public void setPrezimepolaznika(String prezimepolaznika) {
		this.prezimepolaznika = prezimepolaznika;
	}

	public List<Ocenakursa> getOcenakursas() {
		return this.ocenakursas;
	}

	public void setOcenakursas(List<Ocenakursa> ocenakursas) {
		this.ocenakursas = ocenakursas;
	}

	public Ocenakursa addOcenakursa(Ocenakursa ocenakursa) {
		getOcenakursas().add(ocenakursa);
		ocenakursa.setPolaznik11(this);

		return ocenakursa;
	}

	public Ocenakursa removeOcenakursa(Ocenakursa ocenakursa) {
		getOcenakursas().remove(ocenakursa);
		ocenakursa.setPolaznik11(null);

		return ocenakursa;
	}

	public List<Ishod11> getIshod11s() {
		return this.ishod11s;
	}

	public void setIshod11s(List<Ishod11> ishod11s) {
		this.ishod11s = ishod11s;
	}

	public Ishod11 addIshod11(Ishod11 ishod11) {
		getIshod11s().add(ishod11);
		ishod11.setPolaznik11(this);

		return ishod11;
	}

	public Ishod11 removeIshod11(Ishod11 ishod11) {
		getIshod11s().remove(ishod11);
		ishod11.setPolaznik11(null);

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
		komentar11.setPolaznik11(this);

		return komentar11;
	}

	public Komentar11 removeKomentar11(Komentar11 komentar11) {
		getKomentar11s().remove(komentar11);
		komentar11.setPolaznik11(null);

		return komentar11;
	}

	public List<Odgovor11> getOdgovor11s() {
		return this.odgovor11s;
	}

	public void setOdgovor11s(List<Odgovor11> odgovor11s) {
		this.odgovor11s = odgovor11s;
	}

	public Odgovor11 addOdgovor11(Odgovor11 odgovor11) {
		getOdgovor11s().add(odgovor11);
		odgovor11.setPolaznik11(this);

		return odgovor11;
	}

	public Odgovor11 removeOdgovor11(Odgovor11 odgovor11) {
		getOdgovor11s().remove(odgovor11);
		odgovor11.setPolaznik11(null);

		return odgovor11;
	}

	public Logovanje11 getLogovanje11() {
		return this.logovanje11;
	}

	public void setLogovanje11(Logovanje11 logovanje11) {
		this.logovanje11 = logovanje11;
	}

	public List<Rezultat11> getRezultat11s() {
		return this.rezultat11s;
	}

	public void setRezultat11s(List<Rezultat11> rezultat11s) {
		this.rezultat11s = rezultat11s;
	}

	public Rezultat11 addRezultat11(Rezultat11 rezultat11) {
		getRezultat11s().add(rezultat11);
		rezultat11.setPolaznik11(this);

		return rezultat11;
	}

	public Rezultat11 removeRezultat11(Rezultat11 rezultat11) {
		getRezultat11s().remove(rezultat11);
		rezultat11.setPolaznik11(null);

		return rezultat11;
	}

}