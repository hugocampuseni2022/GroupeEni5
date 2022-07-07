<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Creer Compte</title>
<link rel="stylesheet" href="style/CreationCompte3.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
	<header class = "container-fluid">
		<div class = "row">
			<div class="col-sm-12 col-md-4 logo">
				<a href = "<%=request.getContextPath()%>/Accueil" style="text-decoration: none;">ENI-Enchères</a>
			</div>
		</div>
	</header>
	<div>
		<h2 class="text-center">Mon Profil</h2>
	</div>
	<main class = "container">
		<div class = "row justify-content-center back">
			<form action="CreerCompte" method = "post" class="col-12 col-sm-12 col-md-8 row justify-content-center back">
				<div class= "d-flex flex-column flex-sm-column flex-md-row justify-content-between">
					<div class="d-flex my-2" >
						<div class = "form-label">
							<label>Pseudo : </label>
						</div>
						<div class ="form-input">
							<input type="text" name = "pseudo" required></input> 
						</div>
					</div>
				
					<div class="d-flex my-2">
						<div class = "form-label ">
							<label >Nom : </label>
						</div>
						<div  class ="form-input">
							<input type="text" name = "nom" required></input> 
						</div>
					</div>
				</div>	
				<div class="d-flex flex-column flex-sm-column flex-md-row justify-content-between">
						<div class = "d-flex my-2">
							<div class = "form-label">
								<label>Prénom : </label>
							</div>
							<div  class ="form-input">
								<input type="text" name = "prenom" required></input> 
							</div>
						</div>

						<div class="d-flex my-2">
							<div class = "form-label">
								<label>Email : </label>
							</div>
							<div  class ="form-input">
								<input type="email" name = "mail" required></input> 
							</div>
						</div>
				</div>
					<div class="d-flex flex-column flex-sm-column flex-md-row justify-content-between">
						<div class = "d-flex my-2">
							<div class = "form-label">
								<label>Telephone : </label>
							</div>
							<div  class ="form-input">
								<input type="tel" name = "telephone"></input>
							</div>
						</div>
						
						<div class="d-flex my-2">
							<div class = "form-label">
								<label>Rue : </label>
							</div>
							<div  class ="form-input">
								 <input type="text" name = "rue" required></input> 
							</div>
					</div>
				</div>
				<div class="d-flex flex-column flex-sm-column flex-md-row justify-content-between">
						<div class = "d-flex my-2">
							<div class = "form-label">
								<label>Code Postal : </label>
							</div>
							<div  class ="form-input">
								<input type="text" name = "code postal" required></input>
							</div>
						</div>
					
						<div class = "d-flex my-2">
							<div class = "form-label">
								<label>Ville : </label>
							</div>
							<div  class ="form-input">
								<input type="text" name = "ville" required></input> 
							</div>
						</div>
				</div>
				<div class="d-flex flex-column flex-sm-column flex-md-row justify-content-between">
					
						<div class = "d-flex my-2">
							<div class = "form-label">
								<label>Mots de passe : </label>
							</div>
							<div  class ="form-input">
								<input type="password" name = "mot de passe" required></input> 
							</div>
						</div>
				
				
						<div class = "d-flex my-2">
							<div class = "form-label my-2">
								<label>Confirmation : </label>
							</div>
							<div  class ="form-input">
							 	<input type="password" name = "Confirmation" required></input> 
							</div>
						</div>
					
				</div>
					<div class= "d-flex flex-column flex-sm-column flex-md-row justify-content-center">
						<p>${error2}</p>
					</div>	
							
					<div class= "d-flex justify-content-evenly" >
							<div class = "bouton">
								<button class = "button">Créer</button>
							</div>
							<div class = "bouton accueil d-flex justify-content-center align-item-center}">
								<a href = "<%=request.getContextPath()%>/Accueil" class="button">Annuler</a>
							</div>
					</div>
			</form >
			
		</div>
	</main>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
	
</body>
</html>