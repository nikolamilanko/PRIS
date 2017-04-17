package controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import beans.AdministratorBeanRemote;
import beans.impl.KomunikacijaSaBazomBean;
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
	KomunikacijaSaBazomBean bazaBR;

	public void onLoad() {
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

	public KomunikacijaSaBazomBean getBazaBR() {
		return bazaBR;
	}
	
	public void login() {

		if (adminBR.login(username, password)) {

			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dlg1').show();");
			username ="";
			password= "";
		}
	
	}
	
	public String logout() {
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext()
		         .getSession(false)).invalidate();
        return "/home.xhtml?faces-redirect=true";
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
