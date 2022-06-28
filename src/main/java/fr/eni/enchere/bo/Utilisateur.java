package fr.eni.enchere.bo;

import java.util.List;

public class Utilisateur {

	// attributes
	private int noUtilisateur, credit;
	private String pseudo, nom, prenom, email, telephone, 
	rue, codePostale, ville, motDePasse;
	private boolean administrateur;
	private List<Article> listeArticle;
	private List<Enchere> listeEnchere;
	
	// construct
	public Utilisateur(int noUtilisateur, int credit, String pseudo, String nom, String prenom, String email,
			String telephone, String rue, String codePostale, String ville, String motDePasse, boolean administrateur) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.credit = credit;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostale = codePostale;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.administrateur = administrateur;
	}

	// construct sans 'telephone'
	public Utilisateur(int noUtilisateur, int credit, String pseudo, String nom, String prenom, String email,
			String rue, String codePostale, String ville, String motDePasse, boolean administrateur) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.credit = credit;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.rue = rue;
		this.codePostale = codePostale;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.administrateur = administrateur;
	}

	// construct sans 'telephone' ni 'administrateur'
	public Utilisateur(int noUtilisateur, int credit, String pseudo, String nom, String prenom, String email,
			String rue, String codePostale, String ville, String motDePasse) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.credit = credit;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.rue = rue;
		this.codePostale = codePostale;
		this.ville = ville;
		this.motDePasse = motDePasse;
	}

	// getters and setters
	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public boolean isAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	public List<Article> getListeArticle() {
		return listeArticle;
	}

	public void setListeArticle(List<Article> listeArticle) {
		this.listeArticle = listeArticle;
	}

	public List<Enchere> getListeEnchere() {
		return listeEnchere;
	}

	public void setListeEnchere(List<Enchere> listeEnchere) {
		this.listeEnchere = listeEnchere;
	}

	
	
}
