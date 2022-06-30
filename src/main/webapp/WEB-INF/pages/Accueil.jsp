<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Acceuil</title>
<link rel="stylesheet" href="style/Accueil.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
	<header class="container-fluid ">
		<div class="row">
			<div class="col-sm-12 col-md-4 logo">
				<span>ENI-Enchères</span>
			</div>
			<div class="col-sm-12 col-md-8 nav-menu">
				<c:choose>
					<c:when test="${connected.equals(\"false\")}">
						<div class="liste">
							<ul>
								<li>
									<a href="<%=request.getContextPath()%>/Connexion">S'inscrire - Se connecter</a>
								</li>
							</ul>
						</div>					
					</c:when>
					<c:otherwise>
						<div class="liste">
							<ul>
								<li>
									<a href="<%=request.getContextPath()%>/Accueil?action=deconnexion">Déconnexion</a>
								</li>
								<li>
									<a href="<%=request.getContextPath()%>/ProfilServlet?pseudo=${username}">Mon profil</a>
								</li>
								<li>
									<a href="<%=request.getContextPath()%>/NouvelleVenteServlet">Vendre un article</a>
								</li>
								<li>
									<a href="<%=request.getContextPath()%>">Enchères</a>
								</li>
							</ul>
						</div>
					</c:otherwise>
				</c:choose>
			</div>

		</div>
	</header>
	<main class="container">
		<div class="row">
			<div class="col-12 text-center">
				<h3>Liste des enchères</h3>
			</div>
			<div class="col-12 text-start">
				<h4>Filtres :</h4>
			</div>
			<form action="" method="get" class="col-12">
				<div class="">
					<div>
						<input type="text" placeholder="Le nom de l'article contient">
					</div>
					
					<label for="categorie">Catégorie :</label>
					<select name="categorie">
					    <option value="">Toutes</option>
					    <c:forEach var="categorie" items="${categories}">
			    		    <option value="${categorie.noCategorie}">${categorie.libelle}</option>
					    </c:forEach>
					</select>
					<script src="script/Accueil.js"></script>
					<div>
						<br>
		                <input type="radio" id="radioAchats" name="radio" value="achat">
		                <label for="radioAchats">Achats</label>
		            </div>
		            <div>
			            <c:choose>
			            	<c:when test="radioAchats">
			            		<input type="checkbox" id="enchereOuverte" name="checkboxAchats" >           <!-- accessible seulement si 'radioAchats' est selectionné -->
				                <label for="enchereOuverte">enchères ouvertes</label>
				                <br>
				                <input type="checkbox" id="mesEncheres" name="checkboxAchats" >              <!-- accessible seulement si 'radioAchats' est selectionné -->
				                <label for="mesEncheres">mes enchères</label>
				                <br>
				                <input type="checkbox" id="mesEnchereRemportees" name="checkboxAchats" >     <!-- accessible seulement si 'radioAchats' est selectionné -->
				                <label for="mesEnchereRemportees">mes enchères remportées</label>
			            	</c:when>
			            	<c:otherwise>
				            	<input type="checkbox" id="enchereOuverte" name="checkboxAchats" disabled="disabled">      
				                <label for="enchereOuverte">enchères ouvertes</label>
				                <br>
				                <input type="checkbox" id="mesEncheres" name="checkboxAchats" disabled="disabled">        
				                <label for="mesEncheres">mes enchères</label>
				                <br>
				                <input type="checkbox" id="mesEnchereRemportees" name="checkboxAchats" disabled="disabled">
				                <label for="mesEnchereRemportees">mes enchères remportées</label>
			            	</c:otherwise>
			            </c:choose>
		                
		           	</div>
		           	<div>
		           		<br>
		           		<input type="radio" id="radioVentes" name="radio" value="vente">
		                <label for="radioVentes">Mes ventes</label>
		           	</div>
		           	<div>
		                <input type="checkbox" id="mesVentesEnCours" name="checkboxVentes">       	 <!-- accessible seulement si 'radioVentes' est selectionné -->
		                <label for="mesVentesEnCours">mes ventes en cours</label>
		                <br>
		                <input type="checkbox" id="ventesNonDebutees" name="checkboxVentes">       	 <!-- accessible seulement si 'radioVentes' est selectionné -->
		                <label for="ventesNonDebutees">ventes non débutées</label>
		                <br>
		                <input type="checkbox" id="ventesTerminees" name="checkboxVentes">       	 <!-- accessible seulement si 'radioVentes' est selectionné -->
		                <label for="ventesTerminees">ventes terminées</label>
		            </div>
		            <br>
					<button>Rechercher</button>
				</div>
			</form>
			<div>
				<!-- Liste des articles dans la bdd -->
				<c:forEach var="utilisateur" items="${catalogue}">
					<c:forEach var="article" items="${utilisateur.getListeArticle()}">	
						<div class="card mb-3" style="max-width: 540px;">
							<div class="row no-gutters">
								<div class="col-md-4">
									<img src="..." class="card-img" alt="...">
								</div>
								<div class="col-md-8">
									<div class="card-body">
										<a href="#" class="card-title">${article.getNomArticle()}</a>
										<c:choose>
											<c:when test="${article.getPrixVente()<article.getMiseAPrix()}">
												<p class="card-text">Prix : ${article.getMiseAPrix()} points</p>
											</c:when>
											<c:otherwise>
												<p class="card-text">Prix : ${article.getPrixVente()} points</p>
											</c:otherwise>
										</c:choose>
										<p class="card-text">Fin de l'enchère : ${article.getDateFinEncheres()}</p>
										<span class="card-text">Vendeur : </span>
										<a href="<%=request.getContextPath()%>/ProfilServlet?pseudo=${utilisateur.getPseudo()}" class="card-text">${utilisateur.getPseudo()}</a>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:forEach>
			</div>
		</div>
	</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>