package fr.eni.enchere.ihm;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.FactoryBLL;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class EncherirServlet
 */
@WebServlet("/EncherirServlet")
public class EncherirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// session
	private List<Utilisateur> catalogue;
	private ArticleManager manager;
	private HttpSession session;
       
	@Override
	public void init() throws ServletException {
		manager = FactoryBLL.getManagerArticle();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		
		try {
			catalogue = manager.getAll();
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("catalogue", catalogue);
		int id = 0;
		
		for (Utilisateur u : catalogue) {
			for(Article a : u.getListeArticle()) {
				if (Integer.parseInt(req.getParameter("no"))==a.getNoArticle()) {
					id = a.getNoArticle();
					System.out.println(a.getLieuRetrait().getRue());
					System.out.println(a.getLieuRetrait().getCode_postal());
					System.out.println(a.getLieuRetrait().getVille());
				}
			} 
			
		}
		
		req.setAttribute("noArticle", id);	
<<<<<<< HEAD
		req.getRequestDispatcher("/WEB-INF/pages/Encherir.jsp").forward(req, resp);
=======
		req.setAttribute("catalogue", catalogue);
		req.getRequestDispatcher("/WEB-INF/pages/Encherir.jsp").forward(req, resp);	
		
>>>>>>> branch 'main' of https://github.com/hugocampuseni2022/GroupeEni5.git
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.getRequestDispatcher("/WEB-INF/pages/Encherir.jsp").forward(req, resp);
		session = req.getSession();
		
		
		
		
		
	}

}
