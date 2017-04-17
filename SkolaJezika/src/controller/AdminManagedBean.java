package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.jms.Session;

import org.primefaces.context.RequestContext;

import beans.AdministratorBeanRemote;

@ManagedBean
@SessionScoped
public class AdminManagedBean {
	private String username;
	private String password;

	@EJB
	AdministratorBeanRemote abr;

	public AdminManagedBean() {

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

	public AdministratorBeanRemote getAbr() {
		return abr;
	}

	public void setAbr(AdministratorBeanRemote abr) {
		this.abr = abr;
	}

	public void login() {

		if (abr.login(username, password)) {

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

	public void ispisi() {
		System.out.println("ADMIN ISPISI");
		System.out.println(abr.getAdministrator().getImeadmin());
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().get("test");
		System.out.println(context);
		System.out.println(context.getExternalContext().getSessionMap().get("test"));
	}
}
