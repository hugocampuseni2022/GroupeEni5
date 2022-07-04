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
<<<<<<< HEAD
											<div class="container-fluid">
												<div class="row">
													<div class="col-12">
														<h3>Détail vente</h3>				
													</div>
												</div>
=======
				
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
							<div class="col-9">
								<div class="row">
									<div>
										${article.getNomArticle()}
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
										<div>
											${enchere.getMontant_Enchere()}
										</div>
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
												${article.getLieuRetrait().getCode_postal()}
												${article.getLieuRetrait().getVille()}
											</p>
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
										<div>
											Ma proposition :
										</div>
									</div>
									<div class="col-6">
										<form action="encherir" method="post">
											<div>
												<!-- si pas encore d'enchere, 'placeholder'= miseAPrix, sinon, 'placeholder'=meilleureOffre + 5 -->
													<input type="number" maxlength="4" min="1" name="offre" id="offre" placeholder="">
												
												
													<!-- utilisateur.getArticle().getMontant_Enchere()+10 -->
													
													<!-- if (offre>utilisateur.getCredit) btnEncher=disabled -->
												<%-- <c:choose>
													<c:when test="${utilisateur.getCredit()}=>offre"> --%>
														<button name="btnEncher" >Enchérir</button>
													<%-- </c:when>
													<c:otherwise>
														<button name="btnEncher" disabled>Enchérir</button> <!-- afficher à l'utilisateur qu'il n'a pas assez de crédit -->
													</c:otherwise>
												</c:choose> --%>
												
>>>>>>> branch 'main' of https://github.com/hugocampuseni2022/GroupeEni5.git
											</div>
										<div class="container-fluid">
											<div class="row">
												<div class="col-3 position-relative">
													<a class="position-absolute top-50 start-50 translate-middle">img placeholder</a>
												</div>
												<div class="col-9">
													<div class="row">
														<div class="col-3">
															<div>
																Article :
															</div>
														</div >
														<div class="col-6">
															<div>
																${article.getNomArticle()}
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
															<div>
																${enchere.getMontant_Enchere()}
															</div>
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
																<p>${article.getLieuRetrait().getRue()}</p>
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
															<div>
																Ma proposition :
															</div>
														</div>
														<div class="col-6">
															<form action="encherir" method="post">
																<div>
																	<input type="number" maxlength="4" min="1" name="offre" id="">
																	<!-- utilisateur.getArticle().getMontant_Enchere()+10 -->
																	
																	
																	<!-- if (offre>utilisateur.getCredit) btnEncher=disabled -->
																	
																	<button name="btnEncher">Enchérir</button>
																</div>
															</form>
														</div>
													</div>
								
												</div>
											</div>
											</div>
								
						
				</c:if>
			</c:forEach>
		</c:forEach>
	</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>