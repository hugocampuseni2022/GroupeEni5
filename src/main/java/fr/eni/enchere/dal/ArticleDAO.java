package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.Article;

public interface ArticleDAO {

	
		void insert (Article article) throws DALException;

		List<Article> selectAll() throws DALException;
	
		void delete (int noArticle) throws DALException;
		
		void update(Article article) throws DALException;
		
		Article selectById (int noArticle) throws DALException;

	}


