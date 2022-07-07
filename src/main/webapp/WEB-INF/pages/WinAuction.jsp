<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>WinAuction</title>
<link rel="stylesheet" href="style/EnchereGagne.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
	<header class="container-fluid ">
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
					<c:forEach var ="enchere" items = "${article.getListeEnchere()}">
					   <c:forEach var ="user2" items = "${catalogue}">
					   		<c:forEach var = "enchere2" items = "${user2.getListeEnchere()}">
					   			<c:if test="${enchere.getNumero_Enchere()== enchere2.getNumero_Enchere()}">
					   				<c:if test="${article.getPrixVente()==enchere2.getMontant_Enchere()}">
									    <div class="container">
									        <div class="row justify-content-center back p-4">
									            <div class="col-12 col-12-sm col-md-8">
										
													<c:choose>
															<c:when test="${id==user2.getNoUtilisateur()}">
																<div>
												                    <h4 class="text-center titre">Vous avez remporté la vente</h4>
												                </div>
															</c:when>
															<c:otherwise>
																<div>
												                    <h4 class="text-center titre">${user2.getPseudo()} a remporté l'enchere</h4>
												                </div>
															</c:otherwise>
													</c:choose>
													<div>
									                    <p>${article.getNomArticle()}</p>
									                </div>
									                <div class="d-none d-sm-none  d-md-flex">
									                    <p class="label">Description :</p>
									                    <p class="data">${article.getDescription()}</p>
									                </div>
									                <div class="d-flex">
									                    <p class="label">Meilleure offre :</p>
									                    <p class="data"> ${article.getPrixVente()}<c:if test="${id== utilisateur.getNoUtilisateur()}"> par <a href="<%=request.getContextPath()%>/ProfilServlet?pseudo=${user2.getPseudo()}">${user2.getPseudo()}</a></c:if></p>
									                </div>
									                <div class="d-flex">
									                    <p class="label">Mise à prix :</p>
									                    <p class="data"> ${article.getMiseAPrix()}</p>
									                </div>	
									                
													<c:if test="${id== utilisateur.getNoUtilisateur()}">
														<div class="d-flex">
										                    <p class="label">Fin de l'enchère :</p>
										                    <p class="data">${article.getDateFinEncheres()}</p>
										                </div>
													</c:if>
													<div class="d-flex">
									                    <p class="label label-retrait">Retrait :</p>
									                    <div class="data data-retrait">
									                        <p>${article.getLieuRetrait().getRue()}</p>
									                        <p>${article.getLieuRetrait().getCode_postal()} ${article.getLieuRetrait().getVille()}</p>
									                    </div>
									                </div>
													<div class="d-flex">
									                    <p class="label">Vendeur :</p>
									                    <p class="data"> ${utilisateur.getPseudo()}</p>
									                </div>
													<c:if test="${id != utilisateur.getNoUtilisateur()}">
														<div class="d-flex">
										                    <p class="label">Tel :</p>
										                    <p class="data"> ${utilisateur.getTelephone()}</p>
										                </div>
													</c:if>
													<form action="WinAuction" method="post">
														<c:choose>
																<c:when test="${id== utilisateur.getNoUtilisateur()}">
																	<button name="btn" value="Retrait Effectué" class="button">Retrait Effectué</button>
																</c:when>	
																<c:otherwise>	
																	<button name="btn" value="Back" class="button"> Back</button>
																</c:otherwise>
														</c:choose>
														<input type = "hidden" name ="no" value="${noArticle}"/>
													</form>
												</div>
											</div>
										</div>
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