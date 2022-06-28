package fr.eni.enchere.bo;

import java.sql.Date;
import java.time.LocalDate;

public class Article {

	// attributes
	private int noArticle, miseAPrix, prixVente, numero_utilisateur, categorie;
	private String nomArticle, description, etatVente;

	private Date dateDebutEncheres, dateFinEncheres;
	
	// construct
	public Article(int noArticle, String nomArticle, String description, Date dateDebutEncheres,Date dateFinEncheres, int miseAPrix,
					int categorie) 
	
	{
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.miseAPrix = miseAPrix;
		this.description = description;
		this.categorie = categorie;
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

	public Date getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(Date dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public Date getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(Date dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public int getNumero_utilisateur() {
		return numero_utilisateur;
	}

	public void setNumero_utilisateur(int numero_utilisateur) {
		this.numero_utilisateur = numero_utilisateur;
	}

	public int getCategorie() {
		return categorie;
	}

	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}
	
	
	
	
}
