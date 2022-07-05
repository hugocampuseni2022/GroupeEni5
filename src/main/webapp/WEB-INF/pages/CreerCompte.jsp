<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="style/CreationCompte.css">
<link rel="stylesheet" href="style/CreerCompte.css">
<title>Creer Compte</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
	<div>
		<header>
					<a href = "<%=request.getContextPath()%>/Accueil" style="text-decoration: none;">ENI-Enchères</a>
		</header>
	
		<main>
			<div>
				<h2 id = titre>Mon Profil</h2>
			</div>
			
				<form action="CreerCompte" method = "post">
					<div class="form-line">
						<div class = "form-labeEtInput">
							<div class = "form-label">
								<label>Pseudo : </label>
							</div>
							<div class ="form-input">
								<input type="text" name = "pseudo" required></input> 
							</div>
						</div>
						<div class = "form-labeEtInput">
							<div class = "form-label">
								<label >Nom : </label>
							</div>
							<div  class ="form-input">
								<input type="text" name = "nom" required></input> 
							</div>
						</div>
					</div>
					<div class="form-line">
						<div class = "form-labeEtInput">
							<div class = "form-label">
								<label>Prénom : </label>
							</div>
							<div  class ="form-input">
								<input type="text" name = "prenom" required></input> 
							</div>
						</div>
						<div class = "form-labeEtInput">	
							<div class = "form-label">
								<label>Email : </label>
							</div>
							<div  class ="form-input">
								<input type="email" name = "mail" required></input> 
							</div>
						</div>
					</div>
					<div class="form-line">
						<div class = "form-labeEtInput">
							<div class = "form-label">
								<label>Telephone : </label>
							</div>
							<div  class ="form-input">
								<input type="tel" name = "telephone"></input>
							</div>
						</div>
						<div class = "form-labeEtInput">
							<div class = "form-label">
								<label>Rue : </label>
							</div>
							<div  class ="form-input">
								 <input type="text" name = "rue" required></input> 
							</div>
						</div>
					</div>
					<div class="form-line">
						<div class = "form-labeEtInput">
							<div class = "form-label">
								<label>Code Postal : </label>
							</div>
							<div  class ="form-input">
								<input type="text" name = "code postal" required></input>
							</div>
						</div>
						<div class = "form-labeEtInput">
							<div class = "form-label">
								<label>Ville : </label>
							</div>
							<div  class ="form-input">
								<input type="text" name = "ville" required></input> 
							</div>
						</div>
					</div>	
					<div class="form-line">
						<div class = "form-labeEtInput">
							<div class = "form-label">
								<label>Mots de passe : </label>
							</div>
							<div  class ="form-input">
								<input type="password" name = "mot de passe" required></input> 
							</div>
						</div>
						<div class = "form-labeEtInput">
							<div class = "form-label">
								<label>Confirmation : </label>
							</div>
							<div  class ="form-input">
							 	<input type="password" name = "Confirmation" required></input> 
							</div>
						</div>
					</div>
					<div>
						<p>${error2}</p>
					</div>			
				
					<div id = "lesBoutons"> 	
						<div class = "bouton">
							<button>Créer</button>
						</div>
						<div class = "bouton">
							<a href = "<%=request.getContextPath()%>/Accueil" >
							<button>Annuler</button> </a>
						</div>
					</div>
				</form >
		</main>
	</div>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
	
</body>
</html>