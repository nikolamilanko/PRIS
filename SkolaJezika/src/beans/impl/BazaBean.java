package beans.impl;

import beans.BazaBeanRemote;
import entities.Kurs11;
import entities.Predavac11;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class BazaBean
 */
@Stateless
@LocalBean
public class BazaBean implements BazaBeanRemote {

	@PersistenceContext
	EntityManager em;

    public BazaBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Kurs11> vratiSveKurseve() {
		TypedQuery<Kurs11> q = em.createNamedQuery("Kurs11.findAll", Kurs11.class);
		List<Kurs11> kursevi = q.getResultList();
	
		if (kursevi != null)
			return kursevi;
		else
			return new ArrayList<>();
	}

	@Override
	public List<Predavac11> vratiSvePredavace() {
		TypedQuery<Predavac11> q = em.createNamedQuery("Predavac11.findAll", Predavac11.class);
		List<Predavac11> predavaci = q.getResultList();
	
		if (predavaci != null)
			return predavaci;
		else
			return new ArrayList<>();
	}

}
