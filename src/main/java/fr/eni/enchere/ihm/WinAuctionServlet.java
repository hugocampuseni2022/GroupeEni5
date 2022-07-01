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
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DAOFactory;

/**
 * Servlet implementation class WinAuctionServlet
 */
@WebServlet("/WinAuctionServlet")
public class WinAuctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArticleManager manager;
	private UtilisateurManager UG;
	private List<Utilisateur> catalogue;
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WinAuctionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	public void init() throws ServletException {
		UG = FactoryBLL.getManagerUtilisateur();
		manager = FactoryBLL.getManagerArticle();
		
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			catalogue =  manager.getAll();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session= request.getSession();
		request.setAttribute("catalogue", catalogue);
		int id = 0;
		
			for (Utilisateur u : catalogue) {
				for(Article a : u.getListeArticle()) {
					if (Integer.parseInt(request.getParameter("no"))==a.getNoArticle()) {
					id = a.getNoArticle();
			}
			} 
		}
			
		request.setAttribute("noArticle", id);	
		request.getRequestDispatcher("/WEB-INF/pages/WinAuction.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if("Retrait Effectué".equals(request.getParameterValues("btn")[0])) {
			response.sendRedirect(request.getContextPath()+"/Accueil");;
		}
		
		else if ("Back".equals(request.getParameterValues("btn")[0])) {
			response.sendRedirect(request.getContextPath()+"/Accueil");;
			
		}
		
	}

}
