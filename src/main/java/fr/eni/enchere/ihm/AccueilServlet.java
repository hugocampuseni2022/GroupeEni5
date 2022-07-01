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
import fr.eni.enchere.bo.Enchere;
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
		boolean filtreEnchereOuverte = false;
		boolean filtreMesEnchere = false;
		boolean filtreEnchereRemportes = false;
		boolean filtreVentesEnCours = false;
		boolean filtreVentesCree = false;
		boolean filtreVentesEnd = false;
		
		if ("deconnexion".equals(action)) {
			session.removeAttribute("id");
			session.removeAttribute("connected");
			session.removeAttribute("username");
		}
		
		
		if (!("".equals(request.getParameter("filtreNom")) || request.getParameter("filtreNom")==null)){
			filtreNom = request.getParameter("filtreNom") ;
		}
		
		if (!("0".equals(request.getParameter("categorie")) || request.getParameter("categorie")==null)) {
			filtreCategorie = Integer.parseInt(request.getParameter("categorie"));
		}
		
		if ("true".equals( session.getAttribute("connected"))) {
			if ("achat".equals(request.getParameter("radio"))) {
				if ("on".equals(request.getParameter("enchereOuverte"))) {
					filtreEnchereOuverte = true;
				}
				if ("on".equals(request.getParameter("mesEncheres"))) {
					filtreMesEnchere = true;
				}
				if ("on".equals(request.getParameter("mesEnchereRemportees"))) {
					filtreEnchereRemportes = true;
				}
			}
			if ("vente".equals(request.getParameter("radio"))) {
				if ("on".equals(request.getParameter("mesVentesEnCours"))) {
					filtreVentesEnCours = true;
				}
				if ("on".equals(request.getParameter("ventesNonDebutees"))) {
					filtreVentesCree = true;	
				}
				if ("on".equals(request.getParameter("ventesTerminees"))) {
					filtreVentesEnd = true;
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
			listeFiltrer = applyFilter(filtreNom, filtreCategorie);
		} else {
			//listeFiltrer = applyFilter(filtreNom, filtreCategorie, filtreEnchereOuverte, filtreMesEnchere, filtreEnchereRemportes, filtreVentesEnCours, filtreVentesCree, filtreVentesEnd);
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

	public List<Article> applyFilter(String filtreNom, int filtreCategorie) {
		List<Article> filtreArticle = new ArrayList<Article>();
		for (Utilisateur u : catalogue) {
			for (Article a : u.getListeArticle()) {
				if (a.getEtatVente().equals("En cours")) {

					if (!("".equals(filtreNom)) && !(filtreCategorie==0)) {
						if (a.getNomArticle().contains(filtreNom) && a.getNoCategorie()==filtreCategorie) {
							filtreArticle.add(a);
						}
					} else if (!(filtreCategorie==0)) {
						if (a.getNoCategorie()==filtreCategorie) {
							filtreArticle.add(a);
						}
					} else if (!("".equals(filtreNom))) {
						if (a.getNomArticle().contains(filtreNom)) {
							filtreArticle.add(a);
						}
					} else {
						filtreArticle.add(a);
					}
					
				}
			}
		}
		return filtreArticle;
	}
	
	public List<Article> applyFilter(String filtreNom, int filtreCategorie, boolean filtreEnchereOuverte, boolean filtreMesEnchere,	boolean filtreEnchereRemportes, boolean filtreVentesEnCours,boolean filtreVentesCree,boolean filtreVentesEnd) {
		List<Article> filtreArticle = new ArrayList<Article>();
		for (Utilisateur u : catalogue) {
			for (Article a : u.getListeArticle()) {
				if (!("".equals(filtreNom)) &&
						!(filtreCategorie==0) &&
						filtreEnchereOuverte &&
						filtreEnchereRemportes &&
						filtreMesEnchere
						) {
					
				}
					
				
				
				
				
				
				
				
				
				
				
				
				
				
				if (!("".equals(filtreNom))) {
					if (a.getNoCategorie()==filtreCategorie) {
						for (Article art : filtreArticle) {
							if (!(a.getNoArticle()==art.getNoArticle())) {
								filtreArticle.add(a);
							}
						}
					}
				}
				if (!(filtreCategorie==0)) {
					if (a.getNoCategorie()==filtreCategorie) {
						for (Article art : filtreArticle) {
							if (!(a.getNoArticle()==art.getNoArticle())) {
								filtreArticle.add(a);
							}
						}
					}
				}
				if (filtreEnchereOuverte) {
					if (a.getEtatVente().equals("En cours")) {
						for (Article art : filtreArticle) {
							if (!(a.getNoArticle()==art.getNoArticle())) {
								filtreArticle.add(a);
							}
						}
					}
				}
				if (filtreMesEnchere) {
					for (Enchere e1 : u.getListeEnchere()) {
						for (Enchere e2 : a.getListeEnchere()) {
							if (e1==e2) {
								System.out.println("test");
								for (Article art : filtreArticle) {
									if (!(a.getNoArticle()==art.getNoArticle())) {
										filtreArticle.add(a);
									}
								}
							}
						}
					}
				}
				if (filtreEnchereRemportes) {
					if (a.getEtatVente().equals("Terminé")) {
						for (Enchere e1 : u.getListeEnchere()) {
							for (Enchere e2 : a.getListeEnchere()) {
								if (e1==e2 && e1.getMontant_Enchere()==a.getPrixVente()) {
									System.out.println("test");
									for (Article art : filtreArticle) {
										if (!(a.getNoArticle()==art.getNoArticle())) {
											filtreArticle.add(a);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return filtreArticle;
	}
}
