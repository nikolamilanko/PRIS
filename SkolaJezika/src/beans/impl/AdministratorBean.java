package beans.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import beans.AdministratorBeanRemote;
import entities.Administrator11;

/**
 * Session Bean implementation class AdministratorBean
 */
@Stateful
@LocalBean
public class AdministratorBean implements AdministratorBeanRemote {

	private Administrator11 administrator;
	
	@PersistenceContext
	EntityManager entityManager;
	
    public AdministratorBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Administrator11> query = entityManager.createQuery(
					"select a from Administrator11 a where a.idlogovanja=(select l.idlogovanja from Logovanje11 l where l.username=:username and l.password=:password)",
					Administrator11.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			administrator = query.getResultList().get(0);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public Administrator11 getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator11 administrator) {
		this.administrator = administrator;
	}
}
