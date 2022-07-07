package fr.eni.enchere.ihm;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class EncherirServlet
 */
@WebServlet("/Encherir")
public class EncherirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// session
	private List<Utilisateur> catalogue;
	private List<Article> catalogueArticle;
	private ArticleManager manager;
	private HttpSession session;
       
	@Override
	public void init() throws ServletException {
		manager = FactoryBLL.getManagerArticle();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		
		try {
			catalogue = manager.getAll();
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("catalogue", catalogue);
		int id = 0;
		
		for (Utilisateur u : catalogue) {
			for(Article a : u.getListeArticle()) {
				if (Integer.parseInt(req.getParameter("no"))==a.getNoArticle()) {
					id = a.getNoArticle();
				}
			} 
			
		}
		
		req.setAttribute("noArticle", id);	
		req.getRequestDispatcher("/WEB-INF/pages/Encherir.jsp").forward(req, resp);

	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		try {
			catalogue = manager.getAll();
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("catalogue", catalogue);
		int id = 0;
		int credit = 0;
		int offreModif = 0;
		boolean reEnchere = false;
		
		if("Encherir".equals(request.getParameterValues("btn")[0])) {
			for (Utilisateur u : catalogue) {
				for (Article a : u.getListeArticle()) {
					if (a.getNoArticle() == Integer.parseInt(request.getParameter("no"))) {
						id = a.getNoArticle();
						if (a.getListeEnchere().isEmpty()) {
							for (Utilisateur u2 : catalogue) {
								if (Integer.parseInt(request.getParameter("id"))==u2.getNoUtilisateur()) {
									credit = u2.getCredit();
								}
							}
							if (credit>=Integer.parseInt(request.getParameter("offre"))) {
								try {
									manager.encherir(Integer.parseInt(request.getParameter("no")),Integer.parseInt(request.getParameter("id")),new Enchere(Timestamp.valueOf(LocalDateTime.now()),Integer.parseInt(request.getParameter("offre"))));
									manager.updateCredit(Integer.parseInt(request.getParameter("id")), credit-Integer.parseInt(request.getParameter("offre")));
									response.sendRedirect(request.getContextPath()+"/Accueil");
								} catch (NumberFormatException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (BLLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} else {
								request.setAttribute("error", "Pas assez de credit pour encherir");
								request.setAttribute("noArticle", id);	
						 		request.getRequestDispatcher("/WEB-INF/pages/Encherir.jsp").forward(request, response);
							}
						} else {
							for (Utilisateur u2 : catalogue) {
								if (Integer.parseInt(request.getParameter("id"))==u2.getNoUtilisateur()) {
									credit = u2.getCredit();
									for (Enchere e : u2.getListeEnchere()) {
										if (a.getListeEnchere().get(a.getListeEnchere().size()-1).getNumero_Enchere()==e.getNumero_Enchere()) {
											reEnchere = true;
											offreModif = Integer.parseInt(request.getParameter("offre"))-e.getMontant_Enchere();
											if (credit>=offreModif) {
												try {
													manager.encherir(Integer.parseInt(request.getParameter("no")),Integer.parseInt(request.getParameter("id")),new Enchere(Timestamp.valueOf(LocalDateTime.now()),Integer.parseInt(request.getParameter("offre"))));
													manager.updateCredit(Integer.parseInt(request.getParameter("id")), credit-offreModif);
													response.sendRedirect(request.getContextPath()+"/Accueil");
												} catch (NumberFormatException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												} catch (BLLException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
											} else {
												request.setAttribute("error", "Pas assez de credit pour encherir");
												request.setAttribute("noArticle", id);	
										 		request.getRequestDispatcher("/WEB-INF/pages/Encherir.jsp").forward(request, response);
											}
										}
									} 
									if (!reEnchere) {
										for (Utilisateur u3 : catalogue) {
											for (Enchere e2 : u3.getListeEnchere()) {
												if (e2.getNumero_Enchere()==a.getListeEnchere().get(a.getListeEnchere().size()-1).getNumero_Enchere()) {
													try {
														manager.updateCredit(u3.getNoUtilisateur(), u3.getCredit()+a.getListeEnchere().get(a.getListeEnchere().size()-1).getMontant_Enchere());
													} catch (BLLException e1) {
														e1.printStackTrace();
													}
												}
											}
										}
										if (credit>=Integer.parseInt(request.getParameter("offre"))) {
											try {
												manager.encherir(Integer.parseInt(request.getParameter("no")),Integer.parseInt(request.getParameter("id")),new Enchere(Timestamp.valueOf(LocalDateTime.now()),Integer.parseInt(request.getParameter("offre"))));
												manager.updateCredit(Integer.parseInt(request.getParameter("id")), credit-Integer.parseInt(request.getParameter("offre")));
												response.sendRedirect(request.getContextPath()+"/Accueil");
											} catch (NumberFormatException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											} catch (BLLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
										} else {
											request.setAttribute("error", "Pas assez de credit pour encherir");
											request.setAttribute("noArticle", id);	
									 		request.getRequestDispatcher("/WEB-INF/pages/Encherir.jsp").forward(request, response);
										}
									}
								}
							}	
						}
					} 
				}
			}
		}
	}
}
			

