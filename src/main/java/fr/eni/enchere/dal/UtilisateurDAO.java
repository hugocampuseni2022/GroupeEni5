package fr.eni.enchere.dal;

import fr.eni.enchere.bo.Utilisateur;

public interface UtilisateurDAO {

	Utilisateur connection(String login, String mdp) throws DALException; 

	void insert(String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal,
			String ville, String motDePasse) throws DALException;
	
}
