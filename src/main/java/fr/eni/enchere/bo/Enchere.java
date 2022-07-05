
package fr.eni.enchere.bo;

import java.sql.Timestamp;

public class Enchere {

	// attributes
	private Timestamp dateEnchere;
	private int montant_Enchere;
	private int numero_Enchere;
	
	public Enchere(Timestamp dateEnchere, int montant_Enchere, int numero_Enchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_Enchere = montant_Enchere;
		this.numero_Enchere = numero_Enchere;
	}
	
	public Enchere(Timestamp dateEnchere, int montant_Enchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_Enchere = montant_Enchere;
	}

	// getters and setters
	public Timestamp getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(Timestamp dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontant_Enchere() {
		return montant_Enchere;
	}

	public void setMontant_Enchere(int montant_Enchere) {
		this.montant_Enchere = montant_Enchere;
	}

	public int getNumero_Enchere() {
		return numero_Enchere;
	}

	public void setNumero_Enchere(int numero_Enchere) {
		this.numero_Enchere = numero_Enchere;
	}
	
	
	
}
