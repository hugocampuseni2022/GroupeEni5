package fr.eni.enchere.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.FactoryBLL;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;



/**
 * Servlet implementation class CreerCompteServlet
 */
@WebServlet("/CreerCompte")
public class CreerCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UtilisateurManager UG;
	
	
	@Override
	public void init() throws ServletException {
		
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
		
			if (request.getParameter("mot de passe").equals(request.getParameter("Confirmation"))){
			try {
				
				UG.CreerCompteUtilisateur(new Utilisateur(request.getParameter("pseudo"), request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("mail"), request.getParameter("telephone"), request.getParameter("rue"), request.getParameter("code postal"), request.getParameter("ville"), request.getParameter("mot de passe")));
				request.getRequestDispatcher("/WEB-INF/pages/ListeEncheres.jsp").forward(request, response);
			
			} catch (BLLException e) {
				
				e.printStackTrace();
			}
			}
			else {
				request.setAttribute("error2", "Mots de Passe differents de la Confirmation");
				request.getRequestDispatcher("/WEB-INF/pages/CreerCompte.jsp").forward(request, response);	
			}
		
				
		}

		
	}
