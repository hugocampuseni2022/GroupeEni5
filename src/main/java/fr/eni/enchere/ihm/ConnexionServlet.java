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
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;


/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet(urlPatterns = {"/Connexion"})
public class ConnexionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	private UtilisateurManager UG;
	private HttpSession session;
	
	@Override
	public void init() throws ServletException {
		UG = FactoryBLL.getManagerUtilisateur();
	}
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/pages/pagesConnexion.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	session = request.getSession();
    	try {
    		Utilisateur user = UG.connectionUtilisateur(request.getParameter("identifiant"), request.getParameter("mot de passe"));
			session.setAttribute("id", user.getNoUtilisateur());
			session.setAttribute("connected", "true");
			request.getRequestDispatcher("/WEB-INF/pages/Accueil.jsp").forward(request, response);
			
		} catch (BLLException e) {
			request.setAttribute("error", "Erreur Mot de Passe ou Identifiant");
			request.getRequestDispatcher("/WEB-INF/pages/pagesConnexion.jsp").forward(request, response);
			e.printStackTrace();
		}
    		
    
    }

}
