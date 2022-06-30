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
		
		session= request.getSession();
		String mdpCourant="";
		for (Utilisateur u : catalogue) {
			if (Integer.parseInt(request.getParameter("idUtilisateur"))==u.getNoUtilisateur()) {
				mdpCourant = u.getMotDePasse();
			}
		}
		
			
		if("enregistrer".equals(request.getParameterValues("btn")[0])) {
				if(!(request.getParameter("mdpActuel").equals(mdpCourant))){
					request.setAttribute("erreur", "Mot de passe faux");
					request.setAttribute("catalogue", catalogue);
					request.getRequestDispatcher("/WEB-INF/pages/ModifProfil.jsp").forward(request, response);
				}
				
				else if(!(request.getParameter("newMdp").equals(request.getParameter("confirmNewMdp")))) {
					request.setAttribute("erreur", "Nouveau mot de passe different de la Confirmation");
					request.setAttribute("catalogue", catalogue);
					request.getRequestDispatcher("/WEB-INF/pages/ModifProfil.jsp").forward(request, response);
					
				} else {
					try {
						UG.validerUtilisateur(new Utilisateur(request.getParameter("newPseudo"), request.getParameter("newNom"), request.getParameter("newPrenom"), request.getParameter("newEmail"), request.getParameter("newTelephone"), request.getParameter("newRue"), request.getParameter("newCodePostal"), request.getParameter("newVille"), request.getParameter("mdpActuel")));	
						UG.modifierUtilisateurById(new Utilisateur(request.getParameter("newPseudo"), request.getParameter("newNom"), request.getParameter("newPrenom"), request.getParameter("newEmail"), request.getParameter("newTelephone"), request.getParameter("newRue"), request.getParameter("newCodePostal"), request.getParameter("newVille"), request.getParameter("mdpActuel")),Integer.parseInt(request.getParameterValues("idUtilisateur")[0]));
						session.setAttribute("username", request.getParameter("newPseudo"));
						response.sendRedirect(request.getContextPath()+"/Accueil");
					} catch (BLLException e) {
						request.setAttribute("error", e.getMessage());
						request.setAttribute("catalogue", catalogue);
						request.getRequestDispatcher("/WEB-INF/pages/ModifProfil.jsp").forward(request, response);
						e.printStackTrace();
					}
				}	
		} 
		else {
			try {
				UG.supprimerUtilisateur(Integer.parseInt(request.getParameterValues("idUtilisateur")[0]));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect(request.getContextPath()+"/Accueil");
			
			
		}
		

	}
}
