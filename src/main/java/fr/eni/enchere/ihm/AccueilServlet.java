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
		int filtreRadio = 0;
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
				filtreRadio = 1;
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
				filtreRadio = 2;
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
			listeFiltrer = applyFilter(filtreNom, filtreCategorie, filtreRadio, filtreEnchereOuverte, filtreMesEnchere, filtreEnchereRemportes, filtreVentesEnCours, filtreVentesCree, filtreVentesEnd);
//			for (Utilisateur u : catalogue) {
//				for (Article a : u.getListeArticle()) {
//					listeFiltrer.add(a);
//				}
//			}
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
	
	public List<Article> applyFilter(String filtreNom, int filtreCategorie, int filtreRadio, boolean filtreEnchereOuverte, boolean filtreMesEnchere,	boolean filtreEnchereRemportes, boolean filtreVentesEnCours,boolean filtreVentesCree,boolean filtreVentesEnd) {
		List<Article> filtreArticle = new ArrayList<Article>();
		String req1;
		String req2;
		String req3;
		String req4;
		String req5;		
		
		if (!("".equals(filtreNom))) {
			req1 = "nom_article LIKE '%" + filtreNom + "%'";
			
		} else {
			req1 = "1=1";
		
		}
		
		if (!(filtreCategorie==0)) {
			req2 = "no_categorie=" + filtreCategorie;
		} else {
			req2 = "1=1";	
		}
		
		try {
			if (filtreRadio==1) {
				if (filtreEnchereOuverte) {
					req3 = "(DATEDIFF( DAY, GETDATE(), date_fin_encheres)>=0 AND DATEDIFF(DAY, date_debut_encheres, GETDATE())>=0)";
					if (filtreMesEnchere) {
						req4 = "E.no_utilisateur=" + session.getAttribute("id");
						if (filtreEnchereRemportes) {
							req5 = "(montant_enchere=prix_vente AND DATEDIFF( DAY, GETDATE(), date_fin_encheres)<0)";
						} else {
							req5 = "1=1";
						}
						filtreArticle = manager.filtreClassique("SELECT A.* FROM ARTICLES_VENDUS A JOIN ENCHERES E ON A.no_article=E.no_article WHERE " + req1 + " AND " + req2 + " AND " + req3 + " OR " + req4 + " AND " + req5 + " GROUP BY A.no_article, A.nom_article, A.description, A.date_debut_encheres, A.date_fin_encheres, A.prix_initial, A.prix_vente, A.no_utilisateur, A.no_categorie");
					} else if (filtreEnchereRemportes){
						req4 = "E.no_utilisateur=" + session.getAttribute("id");
						req5 = "(montant_enchere=prix_vente AND DATEDIFF( DAY, GETDATE(), date_fin_encheres)<0)";
						filtreArticle = manager.filtreClassique("SELECT A.* FROM ARTICLES_VENDUS A JOIN ENCHERES E ON A.no_article=E.no_article WHERE " + req1 + " AND " + req2 + " AND " + req3 + " OR " + req4 + " AND " + req5 + " GROUP BY A.no_article, A.nom_article, A.description, A.date_debut_encheres, A.date_fin_encheres, A.prix_initial, A.prix_vente, A.no_utilisateur, A.no_categorie");
					} else {
						filtreArticle = manager.filtreClassique("SELECT * FROM ARTICLES_VENDUS WHERE " + req1 + " AND " + req2 + " AND " + req3);
					}
				} else if (filtreMesEnchere) {
					req3 = "0=1";
					req4 = "E.no_utilisateur=" + session.getAttribute("id");
					if (filtreEnchereRemportes) {
						req5 = "(montant_enchere=prix_vente AND DATEDIFF( DAY, GETDATE(), date_fin_encheres)<0)";
					} else {
						req5 = "1=1";
					}
					filtreArticle = manager.filtreClassique("SELECT A.* FROM ARTICLES_VENDUS A JOIN ENCHERES E ON A.no_article=E.no_article WHERE " + req1 + " AND " + req2 + " AND " + req3 + " OR " + req4 + " AND " + req5 + " GROUP BY A.no_article, A.nom_article, A.description, A.date_debut_encheres, A.date_fin_encheres, A.prix_initial, A.prix_vente, A.no_utilisateur, A.no_categorie");
				}else if (filtreEnchereRemportes) {
					req3 = "0=1";
					req4 = "E.no_utilisateur=" + session.getAttribute("id");
					req5 = "(montant_enchere=prix_vente AND DATEDIFF( DAY, GETDATE(), date_fin_encheres)<0)";
					filtreArticle = manager.filtreClassique("SELECT A.* FROM ARTICLES_VENDUS A JOIN ENCHERES E ON A.no_article=E.no_article WHERE " + req1 + " AND " + req2 + " AND " + req3 + " OR " + req4 + " AND " + req5 + " GROUP BY A.no_article, A.nom_article, A.description, A.date_debut_encheres, A.date_fin_encheres, A.prix_initial, A.prix_vente, A.no_utilisateur, A.no_categorie");
				} else {
					filtreArticle = manager.filtreClassique("SELECT * FROM ARTICLES_VENDUS WHERE " + req1 + " AND " + req2 + " AND (DATEDIFF(DAY, date_debut_encheres, GETDATE())>=0 OR (no_utilisateur=" + session.getAttribute("id") + " AND DATEDIFF(DAY, date_debut_encheres, GETDATE())<0))");
				}
			} else if (filtreRadio==2) {
				if (filtreVentesCree || filtreVentesEnCours || filtreVentesEnd) {
					if (filtreVentesCree) {
						req3 = "DATEDIFF(DAY, date_debut_encheres, GETDATE())<0";
					} else {
						req3 = "0=1";
					}
					if (filtreVentesEnCours) {
						req4 = "(DATEDIFF( DAY, GETDATE(), date_fin_encheres)>=0 AND DATEDIFF(DAY, date_debut_encheres, GETDATE())>=0)";
					} else {
						req4 = "0=1";
					}
					if (filtreVentesEnd) {
						req5 = "DATEDIFF(DAY, GETDATE(), date_fin_encheres)<0";
					} else {
						req5= "0=1";
					}
					
					filtreArticle = manager.filtreClassique("SELECT * FROM ARTICLES_VENDUS WHERE " + req1 + " AND " + req2 + " AND (no_utilisateur=" + session.getAttribute("id") + " AND (" + req3 + " OR " + req4 + " OR " + req5 + "))");
				} else {
					filtreArticle = manager.filtreClassique("SELECT * FROM ARTICLES_VENDUS WHERE " + req1 + " AND " + req2 + " AND (DATEDIFF(DAY, date_debut_encheres, GETDATE())>=0 OR (no_utilisateur=" + session.getAttribute("id") + "  AND DATEDIFF(DAY, date_debut_encheres, GETDATE())<0))");
				}
			} else {
				filtreArticle = manager.filtreClassique("SELECT * FROM ARTICLES_VENDUS WHERE " + req1 + " AND " + req2 + " AND (DATEDIFF(DAY, date_debut_encheres, GETDATE())>=0 OR (no_utilisateur=" + session.getAttribute("id") + " AND DATEDIFF(DAY, date_debut_encheres, GETDATE())<0))");
			} 
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		return filtreArticle;
	}
}
