package fr.eni.enchere.bll;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
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
	
	private ArticleImpl() {
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
	public void enregistrerArticle(Article article, int id) throws BLLException {
		try {
			daoArticle.insert(article, id);
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
	public void updateArticle(Article article, int id) throws BLLException {
		try {
			daoArticle.update(article, id);
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

	@Override
	public void validerArticle(Article a) throws BLLException {
		StringBuilder res = new StringBuilder();
		res.append("Les champs suivant ne sont pas correctement renseignés :\n");
		boolean error = false;
		
		if (a.getNomArticle().isBlank() || "".equals(a.getNomArticle())) {
			res.append(" - Le nom de l'article\n");
			error=true;
		}
		
		if (a.getDescription().isBlank() || "".equals(a.getDescription())) {
			res.append(" - La description\n");
			error=true;
		}
		
		if (Date.valueOf(LocalDate.now()).compareTo(a.getDateDebutEncheres())>0) {
			res.append(" - La date de début\n");
			error=true;
		}
		
		if (a.getDateDebutEncheres().compareTo(a.getDateFinEncheres())>=0) {
			res.append(" - La date de fin\n");
			error=true;
		}
		
		if (error) {
			throw new BLLException(res.toString());
		}
	}
	
	public List<Categorie> getCategories() throws BLLException {
		try {
			return daoArticle.selectCategorie();
		} catch (DALException e) {
			throw new BLLException(e.getMessage(), e);
		}
	}

	
	@Override
	public void encherir(int noArticle, int noUtilisateur, Enchere enchere) throws BLLException {
		try {
			daoArticle.encherir(noArticle, noUtilisateur, enchere);
		} catch (DALException e) {
			throw new BLLException(e.getMessage(), e);
		}
		
	}
	
	

	
	
 
}
