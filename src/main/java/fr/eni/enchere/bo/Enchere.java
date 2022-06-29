package fr.eni.enchere.bo;

import java.sql.Date;

public class Enchere {

	// attributes
	private Date dateEnchere;
	private int montant_Enchere;
	
	// construct
	public Enchere(Date dateEnchere, int montant_Enchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_Enchere = montant_Enchere;
	}

	// getters and setters
	public Date getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontant_Enchere() {
		return montant_Enchere;
	}

	public void setMontant_Enchere(int montant_Enchere) {
		this.montant_Enchere = montant_Enchere;
	}
	
}
