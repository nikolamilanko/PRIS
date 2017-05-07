package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import beans.impl.KomunikacijaSaBazomBean;
import beans.impl.PredavacBean;
import entities.Odgovornapitanje11;
import entities.Pitanje11;
import entities.Test11;

@ManagedBean
@SessionScoped
public class TestManagedBean {
	@EJB
	PredavacBean predavacBean;

	@EJB
	KomunikacijaSaBazomBean komunikacijaSaBazomBean;
	
	Test11 test11 = new Test11();
//	Test11 test11 = komunikacijaSaBazomBean.getPrviTest();

	List<Pitanje11> pitanja = new ArrayList<>();
	Map<Pitanje11, List<Boolean>> mapa = new HashMap<>();
	boolean imaPonudjenihOdgovora = false;
	@PostConstruct
	public void testPopuni() {
		test11 = komunikacijaSaBazomBean.getPrviTest();
	
	}
	

	public void setImaPonudjenihOdgovora(){
		imaPonudjenihOdgovora = true;
	}
	
	public void dodajOdgovor(Pitanje11 pitanje11) {
		Odgovornapitanje11 odgovornapitanje11 = new Odgovornapitanje11();
		mapa.get(pitanje11).add(false);
		odgovornapitanje11.setJetacan((byte) 0);
		odgovornapitanje11.setTekstodgovora("");
		pitanje11.getOdgovornapitanje11s().add(odgovornapitanje11);
	}

	public void dodajPitanje() {
		komunikacijaSaBazomBean.getPrviTest();
		
		
		imaPonudjenihOdgovora = false;
		Pitanje11 pitanjeTemp = new Pitanje11();
		mapa.put(pitanjeTemp, new ArrayList<>());
		pitanjeTemp.setTekstpitanja("");
		pitanjeTemp.setOdgovornapitanje11s(new ArrayList<>());
		pitanja.add(pitanjeTemp);
	}

	public void promeniStanje(Pitanje11 pitanje11, Integer index) {
		List<Boolean> temp = mapa.get(pitanje11);
		System.out.println(temp.get(index) + " POCETAK");
		if (temp.get(index) == true) {
			temp.set(index, false);
		} else {
			temp.set(index, true);
		}
		System.out.println(temp.get(index) + " KRAJ");
	}

	public void savePitanjaUBazu() {
		for (int i = 0; i < pitanja.size(); i++) {
			pitanja.get(i).setTest11(test11);
			for (int j = 0; j < pitanja.get(i).getOdgovornapitanje11s().size(); j++) {
				pitanja.get(i).getOdgovornapitanje11s().get(j)
						.setJetacan(boolToByte((mapa.get(pitanja.get(i)).get(j))));
			}
			komunikacijaSaBazomBean.savePitanje(pitanja.get(i));
			for(int k=0;k<pitanja.get(i).getOdgovornapitanje11s().size();k++){
				pitanja.get(i).getOdgovornapitanje11s().get(k).setPitanje11(pitanja.get(i));
				komunikacijaSaBazomBean.saveOdgovorNaPitanje(pitanja.get(i).getOdgovornapitanje11s().get(k));
			}
			
		}

	}

	public byte boolToByte(boolean b) {
		if (b) {
			return 1;
		} else {
			return 0;
		}
	}

	public void obrisiOdogovr(Pitanje11 pitanje11,Integer pozicija){
		System.out.println(pozicija+ "  "+ pitanje11.getTekstpitanja());
		System.out.println(pitanje11.getOdgovornapitanje11s().size()+ "   "+ mapa.get(pitanje11).size());
		pitanje11.getOdgovornapitanje11s().remove((int)pozicija);
		mapa.get(pitanje11).remove((int)pozicija);
		System.out.println(pitanje11.getOdgovornapitanje11s().size()+ "   "+ mapa.get(pitanje11).size());
		
	}
	
	public List<Pitanje11> getPitanja() {
		return pitanja;
	}

	public void setPitanja(List<Pitanje11> pitanja) {
		this.pitanja = pitanja;
	}

	public void sacuvajIzmene() {
		System.out.println(pitanja.get(0).getTekstpitanja());
	}

	public Map<Pitanje11, List<Boolean>> getMapa() {
		return mapa;
	}

	public void setMapa(Map<Pitanje11, List<Boolean>> mapa) {
		this.mapa = mapa;
	}

	public boolean isImaPonudjenihOdgovora() {
		return imaPonudjenihOdgovora;
	}

	public void setImaPonudjenihOdgovora(boolean imaPonudjenihOdgovora) {
		this.imaPonudjenihOdgovora = imaPonudjenihOdgovora;
	}
	

}
