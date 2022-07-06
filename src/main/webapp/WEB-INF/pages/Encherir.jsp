<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Encherir</title>
<link rel="stylesheet" href="style/Enchere2.css">
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
	<div>
        <h2 class="text-center">Détail Vente</h2>
    </div>
	<main class="container">
		<div class="row justify-content-center back p-4">
			<form action="EncherirServlet" method = "post" class="col-12 col-sm-12 col-md-8 col-lg-6">
				<input type = "hidden" name ="id" value="${id}"/>
				<input type = "hidden" name ="no" value="${noArticle}"/>
				<c:forEach var="utilisateur" items="${catalogue}">
					<c:forEach var="article" items="${utilisateur.getListeArticle()}">
						<c:if test="${noArticle==article.getNoArticle()}">					
							<div>
			                    <p>${article.getNomArticle()}</p>
			                </div>
			                <div class="d-flex">
			                    <p class="label">Description :</p>
			                    <p class="data">${article.getDescription()}</p>
			                </div>
							<div class="d-flex">
			                    <p class="label">Catégorie :</p>
			                    <c:forEach var="categorie" items="${categories}">
									<c:if test ="${article.getNoCategorie() == categorie.noCategorie}">
										<p class="data">${categorie.libelle}</p>
									</c:if>
								</c:forEach>
			                </div>
							<div class="d-flex">
			                    <p class="label">Meilleure offre :</p>
			                    <c:choose>
									<c:when test="${!empty article.getListeEnchere()}">
										<c:forEach var ="enchere" items = "${article.getListeEnchere()}">
			 							  <c:forEach var ="user2" items = "${catalogue}">
			   									<c:forEach var = "enchere2" items = "${user2.getListeEnchere()}">	
													<c:if test="${enchere.getNumero_Enchere()== enchere2.getNumero_Enchere()}">
				   										<c:if test ="${article.getPrixVente()==enchere2.getMontant_Enchere()}">
															<div>
																<p class="data">${enchere.getMontant_Enchere()} pts par ${user2.getPseudo()}</p>
															</div>
														</c:if>
													</c:if>
									 			</c:forEach>
									 		</c:forEach>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<p class="data">Pas d'enchere pour le moment</p>
									</c:otherwise>
								</c:choose>
			                </div>		
							<div class="d-flex">
			                    <p class="label">Mise à prix :</p>
			                    <p class="data">${article.getMiseAPrix()} pts</p>
			                </div>
			                <div class="d-flex">
			                    <p class="label">Fin de l'enchère :</p>
			                    <p class="data">${article.getDateFinEncheres()}</p>
			                </div>
			                <div class="d-flex">
			                    <p class="label label-retrait">Retrait :</p>
			                    <div class="data data-retrait">
			                        <p>${article.getLieuRetrait().getRue()}</p>
			                        <p>${article.getLieuRetrait().getCode_postal()} ${article.getLieuRetrait().getVille()}</p>
			                    </div>
			                </div>
			                <div class="d-flex">
			                    <p class="label">Vendeur :</p>
			                    <p class="data">${utilisateur.getPseudo()}</p>
			                </div>		
			                <c:if test="${connected.equals(\"true\") and id!=utilisateur.noUtilisateur}">
			                	<div class="d-flex">
				                    <p class="label">Ma proposition :</p>
				                    <c:choose>
								  		 <c:when test="${empty article.getListeEnchere()}">
											<input type="number" name = "offre" required  min="${article.getMiseAPrix()}" step = "5"></input>
										</c:when>
										<c:otherwise>
											<input type="number" name = "offre" required  min="${article.getPrixVente()+5}" step = "5"></input>
										</c:otherwise>
									</c:choose>  
				                </div>
				                <div class="d-flex justify-content-center">
				                    <button class="button" name="btn" value="Encherir">Enchérir</button>
				                    <p>${error}</p>
				                </div>
							</c:if>
							<input type = "hidden" name ="credit" value="${utilisateur.getCredit()}"/>				
						</c:if>
					</c:forEach>
				</c:forEach>
			</form>
		</div>
	</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>