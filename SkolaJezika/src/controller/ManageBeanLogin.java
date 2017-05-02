package controller;

import java.util.ArrayList;
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

@ManagedBean(name="manageBeanLogin")
@ApplicationScoped
public class ManageBeanLogin {
	
	private String zanimanje;
	private String username;
	private String password;


	private List<Kurs11> kursevi;
	private List<Predavac11> predavaci;
	private List<String> zanimanja;
	
	@EJB
	KomunikacijaSaBazomBean bazaBR;
	
	public void onLoad() {
		kursevi = bazaBR.vratiSveKurseve();
		predavaci = bazaBR.vratiSvePredavace();
	}
	
	public void onLoadZaPredavaca(String username) {
		kursevi = bazaBR.vratiSveKurseveZaUsernamePredavaca(username);
		predavaci = bazaBR.vratiSvePredavace();
	}
	
	@PostConstruct
	private void init() {
		zanimanja = new ArrayList<>();
		zanimanja.add("administrator");
		zanimanja.add("predavac");
		zanimanja.add("polaznik");
	}

	public List<Kurs11> getKursevi() {
		return kursevi;
	}

	public void setKursevi(List<Kurs11> kursevi) {
		this.kursevi = kursevi;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getZanimanja() {
		return zanimanja;
	}

	public void setZanimanja(List<String> zanimanja) {
		this.zanimanja = zanimanja;
	}
	
	public String logout() {
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
		return "/page-svi/home.xhtml?faces-redirect=true";
	}
}
