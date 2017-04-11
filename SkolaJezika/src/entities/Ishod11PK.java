package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ISHOD11 database table.
 * 
 */
@Embeddable
public class Ishod11PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idpolaznika;

	@Column(insertable=false, updatable=false)
	private int idkursa;

	public Ishod11PK() {
	}
	public int getIdpolaznika() {
		return this.idpolaznika;
	}
	public void setIdpolaznika(int idpolaznika) {
		this.idpolaznika = idpolaznika;
	}
	public int getIdkursa() {
		return this.idkursa;
	}
	public void setIdkursa(int idkursa) {
		this.idkursa = idkursa;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Ishod11PK)) {
			return false;
		}
		Ishod11PK castOther = (Ishod11PK)other;
		return 
			(this.idpolaznika == castOther.idpolaznika)
			&& (this.idkursa == castOther.idkursa);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idpolaznika;
		hash = hash * prime + this.idkursa;
		
		return hash;
	}
}