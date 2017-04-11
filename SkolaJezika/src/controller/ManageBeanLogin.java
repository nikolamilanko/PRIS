package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ManageBeanLogin {
	
	private String zanimanje;
	private String username;
	private String password;

	private List<String> zanimanja;
	
	@PostConstruct
	private void init() {
		zanimanja = new ArrayList<>();
		zanimanja.add("administrator");
		zanimanja.add("predavac");
		zanimanja.add("polaznik");
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
}
