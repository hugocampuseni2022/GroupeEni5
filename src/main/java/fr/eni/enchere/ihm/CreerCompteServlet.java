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
	private HttpSession session;
	private ArticleManager AM;
	private List<Utilisateur> catalogue;
	
	@Override
	public void init() throws ServletException {
		AM = FactoryBLL.getManagerArticle();
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
			session = request.getSession();
			
			try {
				catalogue = AM.getAll();
			} catch (BLLException e) {
				e.printStackTrace();
			}
			
			for(Utilisateur u : catalogue) {
				if(u.getPseudo().equals(request.getParameter("pseudo"))|| u.getEmail().equals(request.getParameter("mail"))) {
					
					request.setAttribute("error2", "Pseudo ou email déjà utilisé");
					request.getRequestDispatcher("/WEB-INF/pages/CreerCompte.jsp").forward(request, response);	
				}	
			}	
				
			if (request.getParameter("mot de passe").equals(request.getParameter("Confirmation"))){
				try {
					
					UG.creerCompteUtilisateur(new Utilisateur(request.getParameter("pseudo"), request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("mail"), request.getParameter("telephone"), request.getParameter("rue"), request.getParameter("code postal"), request.getParameter("ville"), request.getParameter("mot de passe")));
					session.setAttribute("connected", "true");
					session.setAttribute("username", request.getParameter("pseudo"));
					response.sendRedirect(request.getContextPath()+"/Accueil");
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
