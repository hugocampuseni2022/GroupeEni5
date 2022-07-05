package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;

public interface ArticleDAO {

	
		void insert (Article article, int idUser) throws DALException;

		List<Article> selectAll() throws DALException;
	
		void delete (int noArticle) throws DALException;
		
		void update(Article article, int idUser) throws DALException;
		
		Article selectById (int noArticle) throws DALException;

		List<Utilisateur> selectAllArticle() throws DALException;
		
		List<Article> selectByNoUtilisateur(int idUser) throws DALException ;
		
		List<Enchere> selectEnchereByArticle(int idArticle) throws DALException;
		
		Retrait selectRetraitByArticle(int idArticle) throws DALException;
		
		List<Enchere> selectEnchereByUser(int idUser) throws DALException;
		
		List<Categorie> selectCategorie() throws DALException;

		void encherir(int idArticle, int idUser, Enchere enchere) throws DALException;

		void modifPrixDeVente(int prixVente,int numeroArticle) throws DALException;
		
		List<Article> filterClassique(String query) throws DALException;
	}


