package fr.eni.enchere.bll;

import java.time.LocalDate;
import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.DALException;
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
		this.daoArticle = DAOFactory.getDaoArticle();
	}

	@Override
	public List<Article> getAllArticle() throws BLLException {
		try {
			return daoArticle.selectAll();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			throw new BLLException("erreur Affichage All Article");
		}
	
	}

	@Override
	public void enregistrerArticle(Article article) throws BLLException {
		try {
			daoArticle.insert(article);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			throw new BLLException ("erreur enregistrement Article");
		}
		
	}

	@Override
	public void supprimerArticle(int noArticle) throws BLLException {
		try {
			daoArticle.delete(noArticle);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			throw new BLLException("Erreur supprimer Article");
		}
		
	}

	@Override
	public Article getArticleById(int noArticle) throws BLLException {
		
		try {
			return daoArticle.selectById(noArticle);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			throw new BLLException("Erreur get Article by Id");
		}
	}

	@Override
	public void updateArticle(Article article) throws BLLException {
		try {
			daoArticle.update(article);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			throw new BLLException("Erreur Update Article");
		}
		
	}

	@Override
	public List<Utilisateur> getAll() throws BLLException {
		try {
			return daoArticle.selectAllArticle();
		} catch (DALException e) {
			throw new BLLException(e.getMessage(), e);
		}
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
