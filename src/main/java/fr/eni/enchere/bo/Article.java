package fr.eni.enchere.bo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Article {

	// attributes
	private int noArticle, miseAPrix, prixVente, noCategorie;
	private String nomArticle, description, etatVente;
	private Date dateDebutEncheres, dateFinEncheres;
	private List<Enchere> listeEnchere = new ArrayList<Enchere>();
	private Retrait lieuRetrait;
	
	// construct
	public Article(int noArticle, String nomArticle, String description, Date dateDebutEncheres,Date dateFinEncheres, int miseAPrix,
					int prixVente, int noCategorie) 
	
	{
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.miseAPrix = miseAPrix;
		this.description = description;
		this.prixVente = prixVente;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.noCategorie = noCategorie;
		setEtatVente(Date.valueOf(LocalDate.now()),dateDebutEncheres, dateFinEncheres);
	}

	public Article(String nomArticle, String description, int noCategorie, int miseAPrix, Date dateDebutEncheres,
			Date dateFinEncheres, Retrait lieuRetrait) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.noCategorie = noCategorie;
		this.miseAPrix = miseAPrix;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.lieuRetrait = lieuRetrait;
		setEtatVente(Date.valueOf(LocalDate.now()),dateDebutEncheres, dateFinEncheres);
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

	public void setEtatVente(Date now, Date debut, Date fin) {
		if (now.compareTo(debut)>0) {
			this.etatVente = "Créée";
		} else if (debut.compareTo(fin)>0) {
			this.etatVente = "En cours";
		} else if (debut.compareTo(fin)<0) {
			this.etatVente = "Terminé";
		}
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

	public List<Enchere> getListeEnchere() {
		return listeEnchere;
	}

	public void setListeEnchere(List<Enchere> listeEnchere) {
		this.listeEnchere = listeEnchere;
	}

	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}

	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	
	
	
	
}
