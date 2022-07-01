package fr.eni.enchere.ihm;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class AcceuilServlet
 */
@WebServlet(urlPatterns = {"/Accueil", ""})
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Utilisateur> catalogue;
	private ArticleManager manager;
	private HttpSession session;
	private List<Categorie> categories;
	private List<Article> listeFiltrer;

	@Override
	public void init() throws ServletException {
		manager = FactoryBLL.getManagerArticle();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		listeFiltrer = new ArrayList<Article>();
		String action = request.getParameter("action");
		String filtreNom = "";
		int filtreCategorie = 0;
		
		if ("deconnexion".equals(action)) {
			session.removeAttribute("id");
			session.removeAttribute("connected");
			session.removeAttribute("username");
		}
		
		
		if (!("".equals(request.getParameter("filtreNom")) || request.getParameter("filtreNom")==null)){
			filtreNom = request.getParameter("filtreNom") ;
		}
		
		System.out.println(request.getParameter("categorie"));
		
		if (!("0".equals(request.getParameter("categorie")) || request.getParameter("categorie")==null)) {
			filtreCategorie = Integer.parseInt(request.getParameter("categorie"));
		}
		
		if ("true".equals( session.getAttribute("connected"))) {
			if ("achat".equals(request.getParameter("radio"))) {
				if ("on".equals(request.getParameter("enchereOuverte"))) {
					
				}
				if ("on".equals(request.getParameter("mesEncheres"))) {
									
				}
				if ("on".equals(request.getParameter("mesEnchereRemportees"))) {
					
				}
			}
			if ("vente".equals(request.getParameter("radio"))) {
				if ("on".equals(request.getParameter("mesVentesEnCours"))) {
					
				}
				if ("on".equals(request.getParameter("ventesNonDebutees"))) {
									
				}
				if ("on".equals(request.getParameter("ventesTerminees"))) {
					
				}
			}
		}
		
		try {
			catalogue = manager.getAll();
			categories = manager.getCategories();
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		if (!("true".equals( session.getAttribute("connected")))) {
			session.setAttribute("connected", "false");
			for (Utilisateur u : catalogue) {
				for (Article a : u.getListeArticle()) {
					if (a.getEtatVente().equals("En cours")) {
						listeFiltrer.add(a);
					}
				}
			}
		} else {
			for (Utilisateur u : catalogue) {
				for (Article a : u.getListeArticle()) {			
					listeFiltrer.add(a);	
				}
			}
		}
		
		for (Utilisateur utilisateur : catalogue) {
			if (utilisateur.getPseudo().equals(session.getAttribute("username"))) {
				session.setAttribute("id", utilisateur.getNoUtilisateur());
			}
		}
		
		
		
		session.setAttribute("categories", categories);
		request.setAttribute("catalogue", catalogue);
		request.setAttribute("filtre", listeFiltrer);
		request.getRequestDispatcher("/WEB-INF/pages/Accueil.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
