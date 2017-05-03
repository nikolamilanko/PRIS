package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.primefaces.context.RequestContext;

import beans.impl.KomunikacijaSaBazomBean;
import beans.impl.PredavacBean;
import entities.Predavac11;

@ManagedBean(name = "predavacMB")
@SessionScoped
public class PredavacManagedBean {
	private String username;
	private String password;

	private String stariPassword;

	@Pattern(regexp = "^[a-zA-Z0-9]*$")
	@Size(min = 1, max = 20)
	private String noviPassword;
	private String potvrdaNovogPassworda;

	private Predavac11 selektovaniPredavac;

	@EJB
	PredavacBean predavacBR;

	@EJB
	KomunikacijaSaBazomBean bazaBR;

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

	public String getStariPassword() {
		return stariPassword;
	}

	public void setStariPassword(String stariPassword) {
		this.stariPassword = stariPassword;
	}

	public String getNoviPassword() {
		return noviPassword;
	}

	public void setNoviPassword(String noviPassword) {
		this.noviPassword = noviPassword;
	}

	public String getPotvrdaNovogPassworda() {
		return potvrdaNovogPassworda;
	}

	public void setPotvrdaNovogPassworda(String potvrdaNovogPassworda) {
		this.potvrdaNovogPassworda = potvrdaNovogPassworda;
	}

	public Predavac11 getSelektovaniPredavac() {
		return selektovaniPredavac;
	}

	public void setSelektovaniPredavac(Predavac11 selektovaniPredavac) {
		this.selektovaniPredavac = selektovaniPredavac;
	}

	public PredavacBean getPredavacBR() {
		return predavacBR;
	}

	public void setPredavacBR(PredavacBean predavacBR) {
		this.predavacBR = predavacBR;
	}
	
	public void login() {

		if (predavacBR.login(username, password)) {

			try {
				ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext(); 
				ec.redirect(ec.getRequestContextPath() + "/page-predavac/predavac.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dlg1').show();");
			username = "";
			password = "";
		}

	}
}
