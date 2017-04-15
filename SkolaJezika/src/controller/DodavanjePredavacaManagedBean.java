package controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import beans.AdministratorBeanRemote;

@ManagedBean(name="dodavanjePredavacaMB")
@ViewScoped
public class DodavanjePredavacaManagedBean {

	private String ime;
	private String prezime;
	private String titula;
	
	private String username;
	private String password;
	private String potvrdiPassword;
	
	@EJB
	AdministratorBeanRemote abr;
	
	public DodavanjePredavacaManagedBean() {

	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getTitula() {
		return titula;
	}

	public void setTitula(String titula) {
		this.titula = titula;
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
	
	public String getPotvrdiPassword() {
		return potvrdiPassword;
	}

	public void setPotvrdiPassword(String potvrdiPassword) {
		this.potvrdiPassword = potvrdiPassword;
	}

	public void sacuvaj() {
		if (password.equals(potvrdiPassword)) {
			if (abr.dodajPredavaca(ime, prezime, titula, username, password)) {
				RequestContext context = RequestContext.getCurrentInstance();
				context.execute("PF('dlgUspesno').show();");
			} else {
				RequestContext context = RequestContext.getCurrentInstance();
				context.execute("PF('dlgNeuspesno').show();");
			}
		} else {
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dlgLosPassword').show();");
		}
	}
}
