<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>WinAuction</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
	<body>
		<header class="container-fluid ">
				<div class="row">
					<div class="col-sm-12 col-md-4 logo">
						<span>ENI-Enchères</span>
					</div>
				</div>
		</header>
	<main>
	<c:forEach var="utilisateur" items="${catalogue}">
		<c:forEach var="article" items="${utilisateur.getListeArticle()}">
				<c:if test="${noArticle==article.getNoArticle()}">
					<c:forEach var ="enchere" items = "${article.getListeEnchere()}">
					   <c:forEach var ="user2" items = "${catalogue}">
					   		<c:forEach var = "enchere2" items = "${user2.getListeEnchere()}">
					   			<c:if test="${enchere.getNumero_Enchere()== enchere2.getNumero_Enchere()}">
					   				<c:if test="${article.getPrixVente()==enchere2.getMontant_Enchere()}">
										<c:choose>
												<c:when test="${id==user2.getNoUtilisateur()}">
														<div>
															<t1>Vous avez remporté la vente</t1>
														</div>
														
												</c:when>
												
												<c:otherwise>	
														<t1>${user2.getPseudo()} a remporté l'enchere</t1>
												</c:otherwise>
												
										</c:choose>
							
											<div>
												${article.getNomArticle()}
											</div>
											
											<div>
												Description : ${article.getDescription()}
											</div>
											
											<div>
												Meilleure offre : ${article.getPrixVente()} <c:if test="${id== utilisateur.getNoUtilisateur()}">par ${user2.getPseudo()}</c:if>
											</div>
											
											<div>
												Mise à prix : ${article.getMiseAPrix()}
											</div>
										
										<c:if test="${id== utilisateur.getNoUtilisateur()}">
											<div>
												Fin de l'enchère : ${article.getDateFinEncheres()}
											</div>
										</c:if>
										
										<div>
											<p>Retrait :${article.getLieuRetrait().getRue()}</p>
											
											<div>
												${article.getLieuRetrait().getCode_postal()}
												${article.getLieuRetrait().getVille()}
											</div>		
										</div>
										
											<div>
												Vendeur : ${utilisateur.getPseudo()}
											</div>
										<c:if test="${id != utilisateur.getNoUtilisateur()}">
												<div>
													Tel : ${utilisateur.getTelephone()}
												</div>
										</c:if>
										<form action="WinAuctionServlet" method="post">
											<c:choose>
													<c:when test="${id== utilisateur.getNoUtilisateur()}">
														<button name="btn" value="Retrait Effectué">Retrait Effectué</button>
													</c:when>
													
													<c:otherwise>	
														<button name="btn" value="Back"> Back</button>
													</c:otherwise>
											</c:choose>
										</form>
									</c:if>
								</c:if>
							</c:forEach>
						</c:forEach>
					</c:forEach>	
				</c:if>
			</c:forEach>
		</c:forEach>
	</main>	
		
		
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
	</body>
</html>