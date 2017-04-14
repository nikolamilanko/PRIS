package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJPA {

	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("SkolaJezika");
		EntityManager entityManager = emFactory.createEntityManager();
		entityManager.getTransaction().begin();
		System.out.println((entityManager.find(Lekcija11.class, 1)).getKurs11()+ "   LEKCIJA!");
		entityManager.getTransaction().commit();
		entityManager.close();


	}

}
