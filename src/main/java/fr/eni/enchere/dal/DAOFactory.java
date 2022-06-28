package fr.eni.enchere.dal;

import fr.eni.enchere.bll.ArticleImpl;

public class DAOFactory {

	public static UtilisateurDAO getDaoUtilisateur() {
		return new UtilisateurDAOImpl();
	}
	
	public static ArticleDAO getDaoArticle() {
		return new ArticleImpl();
		
	}
}
