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
<script src="script/Accueil.js"></script>
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
		<div>
			
		</div>
		<h3>Liste des enchères</h3>
		<h4>Filtres :</h4>
		<form action="" method="get">
			<input type="text" placeholder="Le nom de l'article contient">
			<label for="categorie">Catégorie :</label>
			<select name="categorie">
			    <option value="">Toutes</option>
			    <option value="1">Informatique</option>
			    <option value="2">Ameublement</option>
			    <option value="3">Vêtement</option>
			    <option value="4">Sport&Loisirs</option>
			</select>
			<div>
                <input type="radio" id="radioAchats" name="radio" value="achat">
                <label for="achats">Achats</label>
                <input type="radio" id="radioVentes" name="radio" value="vente">
                <label for="ventes">Mes ventes</label>
            </div>
            <div>
                <input type="checkbox" id="enchereOuverte" name="checkboxAchats" >           <!-- accessible seulement si 'radioAchats' est selectionné -->
                <label for="enchereOuverte">enchères ouvertes</label>
                <input type="checkbox" id="mesEncheres" name="checkboxAchats" >              <!-- accessible seulement si 'radioAchats' est selectionné -->
                <label for="mesEncheres">mes enchères</label>
                <input type="checkbox" id="mesEnchereRemportees" name="checkboxAchats" >     <!-- accessible seulement si 'radioAchats' est selectionné -->
                <label for="mesEnchereRemportees">mes enchères remportées</label>
                
                <input type="checkbox" id="mesVentesEnCours" name="checkboxVentes">       	 <!-- accessible seulement si 'radioVentes' est selectionné -->
                <label for="mesVentesEnCours">mes ventes en cours</label>
                <input type="checkbox" id="ventesNonDebutees" name="checkboxVentes">       	 <!-- accessible seulement si 'radioVentes' est selectionné -->
                <label for="ventesNonDebutees">ventes non débutées</label>
                <input type="checkbox" id="ventesTerminees" name="checkboxVentes">       	 <!-- accessible seulement si 'radioVentes' est selectionné -->
                <label for="ventesTerminees">ventes terminées</label>
            </div>
			<button>Rechercher</button>
		</form>
		<!-- Liste des articles dans la bdd -->
		<c:forEach var="utilisateur" items="${catalogue}">
			<!-- TODO Card article -->
			<c:forEach var="article" items="${utilisateur.getListeArticle()}">
			<!-- TODO Card article -->
				<p>${article.getNomArticle()}
				<a href="<%=request.getContextPath()%>/ProfilServlet?pseudo=${utilisateur.getPseudo()}">${utilisateur.getPseudo()}</a>
				<br>
			</c:forEach>
		</c:forEach>
	</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>