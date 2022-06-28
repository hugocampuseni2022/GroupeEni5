package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.Article;

public interface ArticleDAO {

	
		void insert (Article article) throws DALException;
		
		//List<Article> selectAll() throws DALException;
		
		//void delete (Integer id) throws DALException;
		
		//void update(Article pizza) throws DALException;
		
	//	Article selectById (Integer id) throws DALException;

	}


