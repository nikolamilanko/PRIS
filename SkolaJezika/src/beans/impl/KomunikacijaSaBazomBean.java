package beans.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Kurs11;
import entities.Lekcija11;
import entities.Logovanje11;
import entities.Predavac11;
import entities.Slika11;

/**
 * Session Bean implementation class TestBazaBean
 */
@Stateless
@LocalBean
public class KomunikacijaSaBazomBean {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public KomunikacijaSaBazomBean() {
        // TODO Auto-generated constructor stub
    }

    public Kurs11 findKurs(){
    	Kurs11 kurs11 =em.find(Kurs11.class,	1);
    	System.out.println(kurs11.getNazivkursa()+" KURS!!!");
    	return kurs11;
    }
    
    public void sacuvajSlikuUBazu(Slika11 slika){
    	em.persist(slika);
    }
    
    public Lekcija11 getLekcijaForID(int id){
    	return em.find(Lekcija11.class, id);
    }
    
    public int sacuvajLekcijuUBazu(Lekcija11 lekcija11){
    	em.persist(lekcija11);
    	int idLekcije = lekcija11.getIdlekcije();
    	return idLekcije;
    }
    
	public List<Kurs11> vratiSveKurseve() {
		TypedQuery<Kurs11> q = em.createNamedQuery("Kurs11.findAll", Kurs11.class);
		List<Kurs11> kursevi = q.getResultList();
	
		if (kursevi != null)
			return kursevi;
		else
			return new ArrayList<>();
	}
	
	public List<Kurs11> vratiSveKurseveZaUsernamePredavaca(String username) {
		TypedQuery<Kurs11> q = em.createNamedQuery("Kurs11.findAllZaUsernamePredavaca", Kurs11.class);
		q.setParameter("username", username);
		List<Kurs11> kursevi = q.getResultList();
	
		if (kursevi != null)
			return kursevi;
		else
			return new ArrayList<>();
	}

	public List<Predavac11> vratiSvePredavace() {
		TypedQuery<Predavac11> q = em.createNamedQuery("Predavac11.findAll", Predavac11.class);
		List<Predavac11> predavaci = q.getResultList();
	
		if (predavaci != null)
			return predavaci;
		else
			return new ArrayList<>();
	}
	
	public boolean izmeniPassword(int idLogovanja, String noviPassword) {
		try {
			Logovanje11 l = (Logovanje11) em.find(Logovanje11.class, idLogovanja);
			l.setPassword(noviPassword);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
