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
     * @see HttpServlet#HttpServlet()
     */
    public ModifProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		
		request.setAttribute("cataogue", catalogue);
		request.getRequestDispatcher("/WEB-INF/pages/ModifProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
		
		if(("enregister").equals(request.getParameter("btn"))) {
			
			UG.modifierUtilisateurById(new Utilisateur(request.getParameter("pseudo"), request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("mail"), request.getParameter("telephone"), request.getParameter("rue"), request.getParameter("code postal"), request.getParameter("ville"), request.getParameter("mot de passe")),Integer.parseInt( request.getParameter("idutilisateur")));
			request.getRequestDispatcher("/WEB-INF/pages/ListeEncheres.jsp").forward(request, response);
		} 
		else {
			
			UG.supprimerUtilisateur(Integer.parseInt(request.getParameter("idutilisateur")));
			request.getRequestDispatcher("/WEB-INF/pages/Accueil.jsp").forward(request, response);
			
			
		}
		} catch (BLLException e) {
			
			e.printStackTrace();
		}

	}
}
