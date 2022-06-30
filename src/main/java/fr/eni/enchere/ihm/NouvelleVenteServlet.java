package fr.eni.enchere.ihm;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

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

/**
 * Servlet implementation class NouvelleVenteServlet
 */
@WebServlet("/NouvelleVenteServlet")
public class NouvelleVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleManager manager;
	private HttpSession session;
	
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
				
			}			
			else {
				response.sendRedirect(request.getContextPath()+"/Accueil");	
			}
		}
	
	
	}



