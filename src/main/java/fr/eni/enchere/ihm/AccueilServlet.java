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
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class AcceuilServlet
 */
@WebServlet(urlPatterns = {"/Accueil", ""})
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Utilisateur> catalogue;
	private ArticleManager manager;
	private HttpSession session;

	@Override
	public void init() throws ServletException {
		manager = FactoryBLL.getManagerArticle();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			catalogue = manager.getAll();
		} catch (BLLException e) {
			e.printStackTrace();
		}
		session = request.getSession();
		String action = request.getParameter("action");
		
		if ("deconnexion".equals(action)) {
			session.removeAttribute("id");
			session.removeAttribute("connected");
		}
		
		
		if (!("true".equals( session.getAttribute("connected")))) {
			session.setAttribute("connected", "false");
		}
		for (Utilisateur utilisateur : catalogue) {
			System.out.println(utilisateur.getPseudo());
		}
		System.out.println( catalogue.get(0).getListeArticle().get(0).getNomArticle());
		request.setAttribute("catalogue", catalogue);
		request.getRequestDispatcher("/WEB-INF/pages/Accueil.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
