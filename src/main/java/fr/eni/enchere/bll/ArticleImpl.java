package fr.eni.enchere.bll;

import java.time.LocalDate;
import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.DAOFactory;




public class ArticleImpl implements ArticleManager {
	
private ArticleDAO daoArticle;	

private static ArticleManager instance;
	
	public static ArticleManager getInstance() {
		if(instance==null) {
			instance = new ArticleImpl();
		}
		return instance;
	}
	
	private  ArticleImpl() {
		this.daoArticle = DAOFactory.();
	}

	@Override
	public List<Article> getAllArticle() throws BLLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enregistrerArticle(Article article) throws BLLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerArticle(int noArticle) throws BLLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Article getArticleById(int noArticle) throws BLLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateArticle(Article article) throws BLLException {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
/*
	@Override
	public Article nouvelleVente(int miseAPrix, String nomArticle, String description, LocalDate dateDebutEncheres) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article nouvelArticle(int miseAPrix, String nomArticle, String description, LocalDate dateDebutEncheres) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerArticle(Article article) {
		// TODO Auto-generated method stub
		
	}
*/
 
}
