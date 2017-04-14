package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ADMINISTRATOR11 database table.
 * 
 */
@Entity
@NamedQuery(name="Administrator11.findAll", query="SELECT a FROM Administrator11 a")
@Table(name="ADMINISTRATOR11")
public class Administrator11 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idadmin;

	private String emailadmin;

	private int idlogovanja;

	private String imeadmin;

	private String prezimeadmin;

	public Administrator11() {
	}

	public int getIdadmin() {
		return this.idadmin;
	}

	public void setIdadmin(int idadmin) {
		this.idadmin = idadmin;
	}

	public String getEmailadmin() {
		return this.emailadmin;
	}

	public void setEmailadmin(String emailadmin) {
		this.emailadmin = emailadmin;
	}

	public int getIdlogovanja() {
		return this.idlogovanja;
	}

	public void setIdlogovanja(int idlogovanja) {
		this.idlogovanja = idlogovanja;
	}

	public String getImeadmin() {
		return this.imeadmin;
	}

	public void setImeadmin(String imeadmin) {
		this.imeadmin = imeadmin;
	}

	public String getPrezimeadmin() {
		return this.prezimeadmin;
	}

	public void setPrezimeadmin(String prezimeadmin) {
		this.prezimeadmin = prezimeadmin;
	}

}