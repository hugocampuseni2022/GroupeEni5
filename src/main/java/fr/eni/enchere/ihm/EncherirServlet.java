package fr.eni.enchere.ihm;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
				}
			} 
			
		}
		
		req.setAttribute("noArticle", id);	
		req.getRequestDispatcher("/WEB-INF/pages/Encherir.jsp").forward(req, resp);

	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		if("Encherir".equals(request.getParameterValues("btn")[0])) {
			
			try {
				manager.encherir(Integer.parseInt(request.getParameter("no")),Integer.parseInt(request.getParameter("id")),new Enchere(Timestamp.valueOf(LocalDateTime.now()),Integer.parseInt(request.getParameter("offre"))));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			response.sendRedirect(request.getContextPath()+"/Accueil");
			}
			
			else if ("unavailable".equals(request.getParameterValues("btn")[0])) {
				
				request.setAttribute("error", "Credit insufisant pour enchérir");	
				
				request.setAttribute("catalogue", catalogue);
				int id = 0;
				
				for (Utilisateur u : catalogue) {
					for(Article a : u.getListeArticle()) {
						if (Integer.parseInt(request.getParameter("no"))==a.getNoArticle()) {
							id = a.getNoArticle();
						}
					} 
					
				}
				
				request.setAttribute("noArticle", id);	
				request.getRequestDispatcher("/WEB-INF/pages/Encherir.jsp").forward(request, response);

				
				
			}
		
	
		
		
	}

}
