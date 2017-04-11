package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the REZULTAT11 database table.
 * 
 */
@Embeddable
public class Rezultat11PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idpolaznika;

	@Column(insertable=false, updatable=false)
	private int idtesta;

	public Rezultat11PK() {
	}
	public int getIdpolaznika() {
		return this.idpolaznika;
	}
	public void setIdpolaznika(int idpolaznika) {
		this.idpolaznika = idpolaznika;
	}
	public int getIdtesta() {
		return this.idtesta;
	}
	public void setIdtesta(int idtesta) {
		this.idtesta = idtesta;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Rezultat11PK)) {
			return false;
		}
		Rezultat11PK castOther = (Rezultat11PK)other;
		return 
			(this.idpolaznika == castOther.idpolaznika)
			&& (this.idtesta == castOther.idtesta);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idpolaznika;
		hash = hash * prime + this.idtesta;
		
		return hash;
	}
}