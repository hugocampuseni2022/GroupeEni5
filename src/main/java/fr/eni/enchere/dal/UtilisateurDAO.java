package fr.eni.enchere.dal;

import fr.eni.enchere.bo.Utilisateur;

public interface UtilisateurDAO {

	Utilisateur connection(String login, String mdp) throws DALException; 

	void insert(Utilisateur utilisateur) throws DALException;
	
	void delete(int noUtilisateur) throws DALException;
	
	void updateById (Utilisateur utilisateur,int noUtilisateur) throws DALException;
	
	Utilisateur selectByPseudo (String login) throws DALException;
	
}
