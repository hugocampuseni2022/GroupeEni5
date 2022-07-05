package fr.eni.enchere.ihm;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
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
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class NouvelleVenteServlet
 */
@WebServlet("/NouvelleVenteServlet")
public class NouvelleVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleManager manager;
	private HttpSession session;
	private List<Utilisateur> catalogue;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NouvelleVenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	public void init() throws ServletException {
		manager = FactoryBLL.getManagerArticle();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		try {
			catalogue =  manager.getAll();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int id = 0;
		if (!("".equals(request.getParameter("no")) || request.getParameter("no")==null)) {
			for (Utilisateur u : catalogue) {
				for(Article a : u.getListeArticle()) {
					if (Integer.parseInt(request.getParameter("no"))==a.getNoArticle()) {
						id = a.getNoArticle();
					}
				} 
			}
		}
			
		request.setAttribute("noArticle", id);	
		request.setAttribute("catalogue", catalogue);
		request.getRequestDispatcher("/WEB-INF/pages/NouvelleVente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	
			if("enregistrer".equals(request.getParameterValues("btn")[0])) {
				
				try {
					manager.validerArticle(new Article(request.getParameter("article"), request.getParameter("description"),Integer.parseInt(request.getParameterValues("categorie")[0]), Integer.parseInt(request.getParameter("prix")), Date.valueOf(request.getParameter("dateDebut")), Date.valueOf(request.getParameter("dateFin")), new Retrait(request.getParameter("rue"), request.getParameter("codePostal"), request.getParameter("ville"))));
					
					manager.enregistrerArticle(new Article(request.getParameter("article"), request.getParameter("description"),Integer.parseInt(request.getParameterValues("categorie")[0]), Integer.parseInt(request.getParameter("prix")), Date.valueOf(request.getParameter("dateDebut")), Date.valueOf(request.getParameter("dateFin")), new Retrait(request.getParameter("rue"), request.getParameter("codePostal"), request.getParameter("ville"))),Integer.parseInt(request.getParameterValues("id")[0]));
					response.sendRedirect(request.getContextPath()+"/Accueil");
				
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (BLLException e) {
					request.setAttribute("error", e.getMessage());
					request.getRequestDispatcher("/WEB-INF/pages/NouvelleVente.jsp").forward(request, response);
					e.printStackTrace();
				
				}
				
			} else if ("annulerVente".equals(request.getParameterValues("btn")[0])){
				try {
					manager.supprimerArticle(Integer.parseInt(request.getParameter("no")));
					response.sendRedirect(request.getContextPath()+"/Accueil");
				} catch (BLLException e) {
					e.printStackTrace();
					request.getRequestDispatcher("/WEB-INF/pages/NouvelleVente.jsp").forward(request, response);
				}
				
			} else {
				response.sendRedirect(request.getContextPath()+"/Accueil");	
			}
		}
	
	
	}



