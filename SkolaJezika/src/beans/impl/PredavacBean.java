package beans.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Predavac11;

@Stateful
@LocalBean
public class PredavacBean {

	@PersistenceContext
	EntityManager em;
	
	private Predavac11 predavac;

    public PredavacBean() {

    }

    public Predavac11 getPredavac() {
		return predavac;
	}

	public void setPredavac(Predavac11 predavac) {
		this.predavac = predavac;
	}
	
	public boolean login(String username, String password) {
		try {
			TypedQuery<Predavac11> query = em.createNamedQuery(
					"Predavac11.findZaUsernameIPassword",
					Predavac11.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			predavac = query.getSingleResult();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
