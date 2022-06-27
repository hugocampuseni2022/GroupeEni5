<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acceuil</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
	<header>
		<h2>ENI-Encheres</h2>
		<a href="connexion">S'inscrire - Se connecter</a>
	</header>
	<main>
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
		<c:forEach var="article" items="${listeArticle}">
			<!-- TODO Card article -->
		</c:forEach>
	</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>