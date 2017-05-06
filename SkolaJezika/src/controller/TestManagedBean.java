package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import beans.impl.PredavacBean;
import entities.Pitanje11;

@ManagedBean
@SessionScoped
public class TestManagedBean {
	@EJB
	PredavacBean predavacBean;
	
	List<Pitanje11> pitanja = new ArrayList<>();
	List<String> tekstoviOdgovora = new ArrayList<>();
	List<String> tipoviPitanja = new ArrayList<>();
	String tipPitanja = "";
	
	@PostConstruct
	public void testPopuni(){
		Pitanje11 pitanje = new Pitanje11();
		pitanje.setTekstpitanja("tekst pitanja");
		pitanja.add(pitanje);
		tekstoviOdgovora.add("blabla");
		tekstoviOdgovora.add("ttt");
		tipoviPitanja.add("Unosenje odgovora");
		tipoviPitanja.add("Odabir tacnih");
	}
	
	public void dodajOdgovor(){
		System.out.println("DODAJ ODGOVOR");
		tekstoviOdgovora.add("");
	}

	public List<Pitanje11> getPitanja() {
		return pitanja;
	}

	public void setPitanja(List<Pitanje11> pitanja) {
		this.pitanja = pitanja;
	}
	
	public void sacuvajIzmene(){
		System.out.println(pitanja.get(0).getTekstpitanja());
	}

	public List<String> getTekstoviOdgovora() {
		return tekstoviOdgovora;
	}

	public void setTekstoviOdgovora(List<String> tekstoviOdgovora) {
		this.tekstoviOdgovora = tekstoviOdgovora;
	}

	public List<String> getTipoviPitanja() {
		return tipoviPitanja;
	}

	public void setTipoviPitanja(List<String> tipoviPitanja) {
		this.tipoviPitanja = tipoviPitanja;
	}

	public String getTipPitanja() {
		return tipPitanja;
	}

	public void setTipPitanja(String tipPitanja) {
		this.tipPitanja = tipPitanja;
	}
	
	
	
	
	
	
	
}
