package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Utilisateur;

public interface UtilisateurManager {
	
	Utilisateur connectionUtilisateur (String pseudo, String motDePasse) throws BLLException;

	void creerCompteUtilisateur(Utilisateur utilsateur) throws BLLException;
	
	void supprimerUtilisateur (int noUtilisateur) throws BLLException;
	
	void modifierUtilisateurById (Utilisateur utilisateur,int noUtilisateur)throws BLLException;
	
	Utilisateur afficherUtilisateurByPseudo (String pseudo) throws BLLException;	
	
	
	
}
