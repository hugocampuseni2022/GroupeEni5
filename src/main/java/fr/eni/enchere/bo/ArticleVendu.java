package fr.eni.enchere.bo;

import java.time.LocalDate;

public class ArticleVendu {

	// attributes
	private int noArticle, miseAPrix, prixVente;
	private String nomArticle, description, etatVente;
	private LocalDate dateDebutEncheres, dateFinEncheres;
	
	// construct
	public ArticleVendu(int noArticle, int miseAPrix, int prixVente, String nomArticle, String description,
			String etatVente, LocalDate dateDebutEncheres, LocalDate dateFinEncheres) {
		super();
		this.noArticle = noArticle;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.nomArticle = nomArticle;
		this.description = description;
		this.etatVente = etatVente;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
	}

	// getters and setters
	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public int getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	
	
	
	
}
