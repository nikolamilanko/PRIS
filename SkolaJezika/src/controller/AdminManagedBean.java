package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import beans.AdministratorBeanRemote;
import beans.BazaBeanRemote;
import entities.Kurs11;
import entities.Predavac11;

@ManagedBean(name="adminMB")
@SessionScoped
public class AdminManagedBean {
	private String username;
	private String password;
	
	private List<Kurs11> kursevi;
	private List<Predavac11> predavaci;

	@EJB
	AdministratorBeanRemote adminBR;
	
	@EJB
	BazaBeanRemote bazaBR;

	@PostConstruct
	private void init() {
		kursevi = bazaBR.vratiSveKurseve();
		predavaci = bazaBR.vratiSvePredavace();
	}

	public AdminManagedBean() {

	}

	public List<Predavac11> getPredavaci() {
		return predavaci;
	}

	public void setPredavaci(List<Predavac11> predavaci) {
		this.predavaci = predavaci;
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

	public AdministratorBeanRemote getAdminBR() {
		return adminBR;
	}

	public void setAdminBR(AdministratorBeanRemote adminBR) {
		this.adminBR = adminBR;
	}

	public List<Kurs11> getKursevi() {
		return kursevi;
	}

	public void setKursevi(List<Kurs11> kursevi) {
		this.kursevi = kursevi;
	}

	public BazaBeanRemote getBazaBR() {
		return bazaBR;
	}
	
	public void login() {
		adminBR.login(username, password);
	}

//	public void ispisi() {
//		System.out.println("ADMIN ISPISI");
//		System.out.println(abr.getAdministrator().getImeadmin());
//		FacesContext context = FacesContext.getCurrentInstance();
//		context.getExternalContext().getSessionMap().get("test");
//		System.out.println(context);
//		System.out.println(context.getExternalContext().getSessionMap().get("test"));
//	}
}
