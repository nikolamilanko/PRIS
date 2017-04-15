package beans;

import java.util.List;

import javax.ejb.Remote;

import entities.Kurs11;
import entities.Predavac11;

@Remote
public interface BazaBeanRemote {

	public List<Kurs11> vratiSveKurseve();

	public List<Predavac11> vratiSvePredavace();
}
