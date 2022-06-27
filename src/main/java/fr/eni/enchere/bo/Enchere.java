package fr.eni.enchere.bo;

import java.time.LocalDate;

public class Enchere {

	// attributes
	private LocalDate dateEnchere;
	private int montant_Enchere;
	
	// construct
	public Enchere(LocalDate dateEnchere, int montant_Enchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_Enchere = montant_Enchere;
	}

	// getters and setters
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontant_Enchere() {
		return montant_Enchere;
	}

	public void setMontant_Enchere(int montant_Enchere) {
		this.montant_Enchere = montant_Enchere;
	}
	
}
