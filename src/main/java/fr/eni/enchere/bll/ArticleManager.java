package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Utilisateur;


public interface ArticleManager {

	
	List<Article> getAllArticle() throws BLLException ;
	
	void enregistrerArticle(Article article, int id) throws BLLException;

	void supprimerArticle(int noArticle) throws BLLException;

	Article getArticleById(int noArticle) throws BLLException;
	
	void updateArticle(Article article, int id) throws BLLException;
	
	List<Utilisateur> getAll() throws BLLException;
	
	void validerArticle(Article a) throws BLLException;
	
	List<Categorie> getCategories() throws BLLException;
	
	int encherir(int noArticle, int meilleureOffre) throws BLLException;
	
	
	
	
	
	
}
