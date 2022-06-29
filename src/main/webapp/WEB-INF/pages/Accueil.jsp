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
		<div>
			
		</div>
		<h3>Liste des enchères</h3>
		<h4>Filtres :</h4>
		<form action="" method="get">
			<input type="text" placeholder="Le nom de l'article contient">
			<label for="categorie">Catégorie :</label>
			<select name="categorie">
			    <option value="">Toutes</option>
			    <option value="Informatique">Informatique</option>
			    <option value="Ameublement">Ameublement</option>
			    <option value="Vetement">Vêtement</option>
			    <option value="Sport">Sport&Loisirs</option>
			</select>
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