package beans;

import javax.ejb.Remote;

import entities.Administrator11;

@Remote
public interface AdministratorBeanRemote {

	boolean login(String username, String password);
	
	boolean dodajPredavaca(String ime, String prezime, String titula, String email, String username, String password);

	public Administrator11 getAdministrator();
}
