<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Encherir</title>
<link rel="stylesheet" href="style/Enchere.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
	<header class="container-fluid">
		<div class="row">
			<div class="col-sm-12 col-md-4 logo">
				<a href = "<%=request.getContextPath()%>/Accueil">ENI-Enchères</a>
			</div>
		</div>
	</header>
	<main>
	<c:forEach var="utilisateur" items="${catalogue}">
		<c:forEach var="article" items="${utilisateur.getListeArticle()}">
				<c:if test="${noArticle==article.getNoArticle()}">					
					<div class="container-fluid">
						<div class="row">
							<div class="col-12">
								<h3>Détail vente</h3>				
							</div>
						</div>
					</div>
					<div class="container-fluid">
						<div class="row">
							<div class="col-3 position-relative">
								<a class="position-absolute top-50 start-50 translate-middle">img placeholder</a>
							</div>
							<div class="row">
								<div class="col-9">
									<div class="row">
										<div>
											${article.getNomArticle()}
										</div>
									</div>
								</div>
							</div>
							</div>	
								<div class="row">
									<div class="col-3">
										<div>
											Description :
										</div>
									</div>
									<div class="col-6">
										<div>
											${article.getDescription()}
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-3">
										<div>
											Catégorie :
										</div>
									</div>
									<div class="col-6">
										<div>
											${article.getNoCategorie()}
										</div>
									</div>
								</div>
									<div class="row">
										<div class="col-3">
											<div>
												Meilleure offre :
											</div>
										</div>
									<div class="col-6">
										<c:choose>
											<c:when test="${!empty article.getListeEnchere()}">
												<c:forEach var ="enchere" items = "${article.getListeEnchere()}">
					 							  <c:forEach var ="user2" items = "${catalogue}">
					   									<c:forEach var = "enchere2" items = "${user2.getListeEnchere()}">	
															<c:if test="${enchere.getNumero_Enchere()== enchere2.getNumero_Enchere()}">
						   										<c:if test ="${article.getPrixVente()==enchere2.getMontant_Enchere()}">
																	<div>
																		<p>${enchere.getMontant_Enchere()} par ${user2.getPseudo()}</p>
																	</div>
																</c:if>
															</c:if>
											 			</c:forEa ch>
											 		</c:forEach>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<p>Pas d'enchere pour le moment</p>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
								<div class="row">
									<div class="col-3">
										<p>Mise à prix :</p>
									</div>
									<div class="col-6">
										<div>
											${article.getMiseAPrix()}
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-3">
										<div>
											Fin de l'enchère :
										</div>
									</div>
									<div class="col-6">
										<div>
											${article.getDateFinEncheres()}
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-3">
										<div>
											Retrait :
										</div>
									</div>
									<div class="col-6">
										<div>
											<p>
												${article.getLieuRetrait().getRue()}
											</p>
											
											<div>
												${article.getLieuRetrait().getCode_postal()}
												${article.getLieuRetrait().getVille()}
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-3">
										<div>
											Vendeur :
										</div>
									</div>
									<div class="col-6">
										<div>
											${utilisateur.getPseudo()}
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-3">		
										Ma proposition :
									</div>
									<div class="col-6">
									   <c:choose>
									  		 <c:when test="${empty article.getListeEnchere()}">
												<div>
													<input type="number" name = "offre" required  min="${article.getMiseAPrix()}" step = "5"></input>
												</div>
											</c:when>
											<c:otherwise>
												<input type="number" name = "offre" required  min="${enchere2.getMontant_Enchere()}" step = "5"></input>
											</c:otherwise>
										</c:choose>
									</div>					
								</div>
								
								<form action="EncherirServlet"   method = "post">
											<button  name="btn" value="Encherir">
												Enchérir
											</button>
								</form>
								
					</div>	
				</c:if>
			</c:forEach>
		</c:forEach>
	</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>