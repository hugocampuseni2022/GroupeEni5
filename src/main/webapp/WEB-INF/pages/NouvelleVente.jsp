<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Nouvelle Vente</title>
<link rel="stylesheet" href="style/Accueil.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>

<header class="container-fluid ">
			<div class="col-sm-12 col-md-4 logo">
				<span>ENI-Enchères</span>
			</div>
			<div>Nouvelle Vente</div>
</header>
<main class="container">
${error}
<form action="NouvelleVenteServlet" method = "post">
	<input type = "hidden" name ="id" value="${id}"/>
		<div>
			<div>
				<label> Article :</label>
			</div>
			<div>
				<input type="text" name="article" size="30"></input>
			</div>
		</div>
	
		<div>
			<div>
				<label> Description :</label>
			</div>
			<div>
				<input type="text" name="description" size="30"></input>
			</div>
		</div>
		
		<div>
			<div>
				<label> Catégorie :</label>
			</div>
			<div>
				<select name="categorie" id = "categorie-select">
					    <option value="1">Informatique</option>
					    <option value="2">Ameublement</option>
					    <option value="3">Vêtement</option>
					    <option value="4">Sport&Loisirs</option>
					   
				</select>
			</div>
		</div>
		
		<div>
			<div>
				<label> Photo de l'article :</label>
			</div>
			<div>
				<input type="image" name="photo" size="30"></input>
			</div>
		</div>
		
		<div>
			<div>
				<label> Mise à prix :</label>
			</div>
			<div>
				<input type="number" name="prix" size="30" min="0" value="100"></input>
			</div>
		</div>
		
		<div>
			<div>
				<label> Début de l'enchère :</label>
			</div>
			<div>
				<input type="date" name="dateDebut" size="30"></input>
			</div>
		</div>
		
		
		<div>
			<div>
				<label> Fin de l'enchère :</label>
			</div>
			<div>
				<input type="date" name="dateFin" size="30"></input>
			</div>
		</div>
		
		<div>
			<fieldset>
	   			 <legend>Retrait</legend>
						<div>
							<div>
								<label>Rue :</label>
							</div>
							<div>
								<input type="text" name="rue" size="30">${test}
							</div>
						</div>
						
						<div>
							<div>
								<label>Code postal :</label>
							</div>
							<div>
								<input type="text" name="codePostal" size="30">${test}
							</div>
						</div>
						
						
						<div>
							<div>
								<label>Ville :</label>
							</div>
							<div>
								<input type="text" name="ville" size="30">${test}
							</div>
						</div>
			</fieldset>
		</div>
	<button  name="btn" value="enregistrer">Enregister</button>
	<button  name="btn" value="annuler">Annuler</button>
	
	
</form>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>