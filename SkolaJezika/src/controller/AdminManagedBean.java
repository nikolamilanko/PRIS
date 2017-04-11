package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
		abr.login(username, password);
	}
}
