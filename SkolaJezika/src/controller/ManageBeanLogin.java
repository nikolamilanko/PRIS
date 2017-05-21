package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import beans.impl.KomunikacijaSaBazomBean;
import entities.Kurs11;
import entities.Predavac11;

@ManagedBean(name = "manageBeanLogin")
@ApplicationScoped
public class ManageBeanLogin {

	public static final String ADMINISTRATOR = "administrator";
	public static final String PREDAVAC = "predavac";
	public static final String POLAZNIK = "polaznik";
	
	private String zanimanje;
	
	private Date datumPocetka;
	private Date datumKraja;
	
	private String najboljiKurs;

	private List<Kurs11> kursevi;
	private List<Kurs11> filtriraniKursevi;

	private List<Predavac11> predavaci;
	private List<String> zanimanja;

	@EJB
	KomunikacijaSaBazomBean bazaBR;

	public void onLoadZaAdministratora() {
		kursevi = bazaBR.vratiSveKurseve();
		predavaci = bazaBR.vratiSvePredavace();
	}

	public void onLoadZaPredavaca(String username) {
		kursevi = bazaBR.vratiSveKurseveZaUsernamePredavaca(username);
	}
	
	public void onLoadZaPolaznika(String username) {
		kursevi = bazaBR.vratiSveKurseveZaUsernamePolaznika(username);
	}
	
	public void vratiSveKurseve() throws IOException {
		kursevi = bazaBR.vratiSveKurseve();
	}
	
	public void vratiPolozeneKurseve(String username) {
		kursevi = bazaBR.vratiPolozeneKurseveZaPolaznika(username);
	}

	@PostConstruct
	private void init() {
		zanimanja = new ArrayList<>();
		zanimanja.add(ADMINISTRATOR);
		zanimanja.add(PREDAVAC);
		zanimanja.add(POLAZNIK);
		vratiNajboljiKurs();
	}

	private void vratiNajboljiKurs() {
		if (!prviUMesecu()) {
			najboljiKurs = bazaBR.getNajboljiKurs().getNazivkursa();
		} else {
			najboljiKurs = bazaBR.izracunajNajboljiKurs().getNazivkursa();
		}
	}

	private boolean prviUMesecu() {
		return Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == 1;
	}

	public List<Kurs11> getKursevi() {
		return kursevi;
	}

	public void setKursevi(List<Kurs11> kursevi) {
		this.kursevi = kursevi;
	}

	public List<Kurs11> getFiltriraniKursevi() {
		return filtriraniKursevi;
	}

	public void setFiltriraniKursevi(List<Kurs11> filtriraniKursevi) {
		this.filtriraniKursevi = filtriraniKursevi;
	}

	public List<Predavac11> getPredavaci() {
		return predavaci;
	}

	public void setPredavaci(List<Predavac11> predavaci) {
		this.predavaci = predavaci;
	}

	public String getZanimanje() {
		return zanimanje;
	}

	public void setZanimanje(String zanimanje) {
		this.zanimanje = zanimanje;
	}

	public List<String> getZanimanja() {
		return zanimanja;
	}

	public void setZanimanja(List<String> zanimanja) {
		this.zanimanja = zanimanja;
	}

	public Date getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public Date getDatumKraja() {
		return datumKraja;
	}

	public void setDatumKraja(Date datumKraja) {
		this.datumKraja = datumKraja;
	}

	public String getNajboljiKurs() {
		return najboljiKurs;
	}

	public void setNajboljiKurs(String najboljiKurs) {
		this.najboljiKurs = najboljiKurs;
	}

	public String logout() {
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
		return "/page-svi/login.xhtml?faces-redirect=true";
	}
}
