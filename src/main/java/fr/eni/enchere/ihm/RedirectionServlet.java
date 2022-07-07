package fr.eni.enchere.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RedirectionServlet
 */
@WebServlet("/Redirection")
public class RedirectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		if ("En cours".equals(request.getParameter("etat"))) {	
			response.sendRedirect(request.getContextPath()+"/Encherir?no=" + request.getParameter("no"));	
		} else if ("Terminé".equals(request.getParameter("etat"))) {
			response.sendRedirect(request.getContextPath()+"/WinAuction?no=" + request.getParameter("no"));
		} else if ("Créée".equals(request.getParameter("etat"))) {
			response.sendRedirect(request.getContextPath()+"/NouvelleVente?no=" + request.getParameter("no"));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
