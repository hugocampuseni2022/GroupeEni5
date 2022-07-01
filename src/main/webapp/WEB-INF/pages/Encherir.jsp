<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Encherir</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
	<header class="container-fluid">
		<div = class="row">
			<div class="col-sm-12 col-md-4 logo">
				<span>ENI-Enchères</span>
			</div>
		</div>
	</header>
	<main>
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
					<!-- ${user.getArticle.getImage} -->
				</div>
				<div class="col-9">
					<div class="row">
						<p>${utilisateur.getArticle().getNomArticle()}</p>
						<!-- ${user.getArticle.getNom} -->
					</div>
					<div class="row">
						<div class="col-3">
							<p>Description :</p>
						</div>
						<div class="col-6">
							<p>${utilisateur.getArticle().getDescription()}</p>
							<!-- ${user.getArticle.getDescription} -->
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<p>Catégorie :</p>
						</div>
						<div class="col-6">
							<p>${utilisateur.getArticle().getCategorie()}</p>
							<!-- ${user.getArticle.getCategorie} -->
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<p>Meilleure offre :</p>
						</div>
						<div class="col-6">
							<p>${enchere.getMontant_Enchere()}</p>
							<!-- ${enchere.getMontant_Enchere()} -->
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<p>Mise à prix :</p>
						</div>
						<div class="col-6">
							<p>${utilisateur.getArticle().getMiseAPrix()}</p>
							<!-- ${user.getArticle.getMiseAPrix} -->
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<p>Fin de l'enchère :</p>
						</div>
						<div class="col-6">
							<p>${enchere.getDateEnchere()}</p>
							<!-- ${enchere.getDateEnchere()} -->
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<p>Retrait :</p>
						</div>
						<div class="col-6">
							<p>${utilisateur.}</p>
							<!-- ${user.getArticle.getLieuRetrait} -->
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<p>Vendeur :</p>
						</div>
						<div class="col-6">
							<p>jojo44 / placeholder</p>
							<!-- ${user.getPseudo} -->
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<p>Ma proposition :</p>
						</div>
						<div class="col-6">
							<form action="encherir" method="post">
								<div>
									<input type="number" maxlength="4" min="1">
									<!-- ${user.getArticle.getMeilleureOffre+10} -->
									<button>Enchérir</button>
								</div>
							</form>
						</div>
					</div>

				</div>
			</div>
		</div>
	
	</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>