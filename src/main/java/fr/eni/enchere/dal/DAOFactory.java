package fr.eni.enchere.dal;

public class DAOFactory {

	public static UtilisateurDAO getDaoUtilisateur() {
		return new UtilisateurDAOImpl();
	}
	
	public static ArticleDAO getDaoArticle() {
		return new ArticleDAOImpl();
		
	}
}
