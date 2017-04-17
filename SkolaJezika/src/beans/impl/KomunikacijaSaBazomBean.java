package beans.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Kurs11;
import entities.Lekcija11;
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
    
}
