package fr.eni.enchere.dal;

import fr.eni.enchere.bo.Utilisateur;

public interface UtilisateurDAO {

	Utilisateur connection(String login, String mdp) throws DALException; 
	
}
