package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Utilisateur;

public interface UtilisateurManager {

	/*
	List<Utilisateur> getAllUtilisateur();
	
	void enregistrerUtilisateur (Utilisateur utilisateur);
	
	void supprimerUtilisateur (int noUtilisateur); // Integer ?
	
	Utilisateur getUtilisateurByNo (int noUtilisateur); // Integer ?
	*/
	
	Utilisateur connectionUtilisateur (String pseudo, String motDePasse) throws BLLException;

	void CreerCompteUtilisateur(String pseudo, String nom, String prenom, String email, String tel, String rue,
			String CP, String ville, String mdp) throws BLLException;
	
	
	
	
}
