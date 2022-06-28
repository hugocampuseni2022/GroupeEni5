package fr.eni.enchere.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
       
	private HttpSession session;
	private UtilisateurManager UG;
	
	public void init()throws ServletException {
		
		UG = FactoryBLL.getManagerUtilisateur();
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
		request.getRequestDispatcher("/WEB-INF/pages/ModifProfilServlet.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
		
		if(("enregister").equals(request.getParameter("btn"))) {
			
			UG.modifierUtilisateurByid(new Utilisateur(request.getParameter("pseudo"), request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("mail"), request.getParameter("telephone"), request.getParameter("rue"), request.getParameter("code postal"), request.getParameter("ville"), request.getParameter("mot de passe")),Integer.parseInt((String) session.getAttribute("id")));
			request.getRequestDispatcher("/WEB-INF/pages/ListeEncheres.jsp").forward(request, response);
		}
		else {
			
			UG.supprimerUtilisateur(Integer.parseInt((String) session.getAttribute("id")));
			request.getRequestDispatcher("/WEB-INF/pages/Accueil.jsp").forward(request, response);
			
			
		}
		} catch (BLLException e) {
			
			e.printStackTrace();
		}

	}
}
