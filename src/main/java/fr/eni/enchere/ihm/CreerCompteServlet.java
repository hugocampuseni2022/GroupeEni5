package fr.eni.enchere.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.FactoryBLL;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;



/**
 * Servlet implementation class CreerCompteServlet
 */
@WebServlet("/CreerCompte")
public class CreerCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UtilisateurManager UG;
	private UtilisateurDAO UD;
	
	@Override
	public void init() throws ServletException {
		UD = DAOFactory.getDaoUtilisateur();//Couplage faible !!!!
		UG = FactoryBLL.getManagerUtilisateur();
		
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerCompteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/pages/CreerCompte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(("mot de passe").equals("Confirmation")){
			
			UD.insert(request.getParameter("identifiant"), request.getParameter("identifiant"), request.getParameter("identifiant"), request.getParameter("identifiant"), request.getParameter("identifiant"), request.getParameter("identifiant"), request.getParameter("identifiant"), request.getParameter("identifiant"), request.getParameter("identifiant"));
			
		
			request.getRequestDispatcher("/WEB-INF/pages/ListeEncheres.jsp").forward(request, response);
			
		}
		
		else {
			
			request.setAttribute("error", "Mots de Passe differents de la Confirmation");
			
		}
		
	}

}
