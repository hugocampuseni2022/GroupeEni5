package fr.eni.enchere.bll;

public class FactoryBLL {
	
	public static UtilisateurManager getManagerUtilisateur() {
		return new UtilisateurImpl();
	}

	public static ArticleManager getManagerArticle() {
		return ArticleImpl.getInstance();
	}
}
