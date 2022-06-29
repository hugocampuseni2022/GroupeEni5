package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Utilisateur;


public interface ArticleManager {

	
	List<Article> getAllArticle() throws BLLException ;
	
	void enregistrerArticle(Article article) throws BLLException;

	void supprimerArticle(int noArticle) throws BLLException;

	Article getArticleById(int noArticle) throws BLLException;
	
	void updateArticle(Article article) throws BLLException;
	
	List<Utilisateur> getAll() throws BLLException;
	
	
	/*

	Article nouvelArticle (int miseAPrix, String nomArticle, String description, LocalDate dateDebutEncheres);
	
	void supprimerArticle (Article article);

	Article nouvelleVente(int miseAPrix, String nomArticle, String description, LocalDate dateDebutEncheres);

	*/
	
	
	
	
	
	
}
