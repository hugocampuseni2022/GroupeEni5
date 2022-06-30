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
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class ModifProfilServlet
 */
@WebServlet("/ModifProfilServlet")
public class ModifProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private List<Utilisateur> catalogue;
	private HttpSession session;
	private ArticleManager manager;
	private UtilisateurManager UG;
	
	public void init()throws ServletException {
		
		UG = FactoryBLL.getManagerUtilisateur();
		manager = FactoryBLL.getManagerArticle();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session= request.getSession();
		try {
			
			catalogue =  manager.getAll();
			
		} catch (BLLException e) {
			e.printStackTrace();
		}
		request.setAttribute("catalogue", catalogue);
		request.getRequestDispatcher("/WEB-INF/pages/ModifProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("enregistrer".equals(request.getParameterValues("btn")[0]));
		
		try {
	
		if("enregistrer".equals(request.getParameterValues("btn")[0])) {
			System.out.println("Nique ta mere");
			UG.modifierUtilisateurById(new Utilisateur(request.getParameter("newPseudo"), request.getParameter("newNom"), request.getParameter("newPrenom"), request.getParameter("newEmail"), request.getParameter("newTelephone"), request.getParameter("newRue"), request.getParameter("newCodePostal"), request.getParameter("newVille"), request.getParameter("mdpActuel")),Integer.parseInt(request.getParameterValues("idUtilisateur")[0]));
			request.getRequestDispatcher("/WEB-INF/pages/ListeEncheres.jsp").forward(request, response);
			
			
		} 
		else {
			System.out.println("Nique ton pere");
			
			UG.supprimerUtilisateur(Integer.parseInt(request.getParameter("idutilisateur")));
			request.getRequestDispatcher("/WEB-INF/pages/Accueil.jsp").forward(request, response);
			
			
		}
		} catch (BLLException e) {
			
			e.printStackTrace();
		}

	}
}
