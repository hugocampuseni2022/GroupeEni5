package fr.eni.enchere.bo;

import java.util.List;

public class Categorie {

	// attributes
	private int noCategorie;
	private String libelle;
	private List<Article> listeArticleCategorie;
	
	// construct
	public Categorie(int noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}

	// getters and setters
	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Article> getListeArticleCategorie() {
		return listeArticleCategorie;
	}

	public void setListeArticleCategorie(List<Article> listeArticleCategorie) {
		this.listeArticleCategorie = listeArticleCategorie;
	}
	
	
}
