package fr.eni.enchere.ihm;

import java.io.IOException;
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
		
		int id = 0;
		
		for (Utilisateur u : catalogue) {
			for(Article a : u.getListeArticle()) {
				if (Integer.parseInt(req.getParameter("no"))==a.getNoArticle()) {
					id = a.getNoArticle();
				}
			} 
		}
		
		req.setAttribute("noArticle", id);	
		req.setAttribute("catalogue", catalogue);
		req.getRequestDispatcher("/WEB-INF/pages/Encherir.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/pages/Encherir.jsp").forward(req, resp);
	}

}
