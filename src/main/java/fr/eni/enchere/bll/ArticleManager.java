package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DALException;


public interface ArticleManager {

	
	List<Article> getAllArticle() throws BLLException ;
	
	void enregistrerArticle(Article article, int id) throws BLLException;

	void supprimerArticle(int noArticle) throws BLLException;

	Article getArticleById(int noArticle) throws BLLException;
	
	void updateArticle(Article article) throws BLLException;
	
	List<Utilisateur> getAll() throws BLLException;
	
	void validerArticle(Article a) throws BLLException;
	
	List<Categorie> getCategories() throws BLLException;
	
	void encherir(int noArticle, int noUtilisateur, Enchere enchere) throws BLLException;
	
	List<Article> filtreClassique(String query) throws BLLException;
	
	void updateCredit(int noUtilisateur,int credit) throws BLLException;
	
}
