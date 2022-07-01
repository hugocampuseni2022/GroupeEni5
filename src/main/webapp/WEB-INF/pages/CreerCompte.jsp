<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Creer Compte</title>
</head>
<body>
	<header>
		<h1> Enchère ENI</h1>
	</header>
	
	<main>
		<div>
			<h2>Mon Profil</h2>
		</div>
		
			<form action="CreerCompte" method = "post">
					<div>
						<div>
							<label>Pseudo : </label>
						</div>
						<div>
							<input type="text" name = "pseudo" required></input> 
						</div>
					</div>
					<div>
						<div>
							<label>Nom : </label>
						</div>
						<div>
							<input type="text" name = "nom" required></input> 
						</div>
					</div>
					<div>
						<div>
							<label>Prénom : </label>
						</div>
						<div>
							<input type="text" name = "prenom" required></input> 
						</div>
					</div> 
					<div>
						<div>
							<label>Email : </label>
						</div>
						<div>
							<input type="email" name = "mail" required></input> 
						</div>
					</div>
					<div>
						<div>
							<label>Telephone : </label>
						</div>
						<div>
							<input type="tel" name = "telephone"></input>
						</div>
					</div>
					<div>
						<div>
							<label>Rue : </label>
						</div>
						<div>
							 <input type="text" name = "rue" required></input> 
						</div>
					</div>
					<div>
						<div>
							<label>Code Postal : </label>
						</div>
						<div>
							<input type="text" name = "code postal" required></input>
						</div>
					</div>
					<div>
						<div>
							<label>Ville : </label>
						</div>
						<div>
							<input type="text" name = "ville" required></input> 
						</div>
					</div>
					<div>
						<div>
							<label>Mots de passe : </label>
						</div>
						<div>
							<input type="password" name = "mot de passe" required></input> 
						</div>
					</div>
					<div>
						<div>
							<label>Confirmation : </label>
						</div>
						<div>
						 	<input type="password" name = "Confirmation" required></input> 
						</div>
					</div> 
						
					 		
				 		
			</form>
					<div>
						<p>${error2}</p>
					</div>			
				
					<div> 	
						<div>
							<button>Créer</button>
						</div>
						<div>
							<a href = "<%=request.getContextPath()%>/Accueil" >
							<button>Annuler</button> </a>
						</div>
					</div>
	</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>