<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Modification de profil</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link rel="stylesheet" href="style/ModifProfil2.css">
</head>
<body>
	<header class="container-fluid">
		<div class = "row">
			<div class="col-sm-12 col-md-12 logo">
				<a href = "<%=request.getContextPath()%>/Accueil">ENI-Enchères</a>
			</div>
		</div>
	</header>
	<main class="container">
	
		<div class="row"> <!--  debut	div titre main -->
			<div class="col-12 justify-content-center">
				<h3 class="text-center">Mon Profil</h3>
			</div>
		</div> <!-- 	Fin div titre main -->
		
		
		<div class="white m-3 p-3 pt-1"> <!-- REVIEW padding and margin -->
		 	
			<p>	${error}	</p>					
			<p>	${erreur}	</p>
			<c:forEach var="utilisateur" items="${catalogue}">
				<c:if test="${id== utilisateur.getNoUtilisateur()}">
					<form action="ModifProfilServlet" method="post">
						<input type = "hidden" name ="idUtilisateur" value="${utilisateur.getNoUtilisateur()}"/></input>
						 	<div class="row">
							 	<table class="col-12 table">
							 		<tr>
							 			<td><label>Pseudo :</label></td>
							 			<td><input type="text" name="newPseudo" size="30" value = "${utilisateur.getPseudo()}" ></td>
							 			
							 			<td><label>Nom :</label></td>
							 			<td><input type="text" name="newNom" size="30" value = "${utilisateur.getNom()}"></td>
							 		</tr>
							 		
							 		<tr>						 			
							 			<td><label>Prénom :</label></td>
							 			<td><input type="text" name="newPrenom" size="30" value = "${utilisateur.getPrenom()}"></td>
							 			
							 			<td><label>Email :</label></td>
							 			<td><input type="text" name="newEmail" size="30" value = "${utilisateur.getEmail()}"></td>
							 		</tr>						
							 		
							 		<tr>					 			
							 			<td><label>Téléphone :</label></td> 
										<td><input type="text" name="newTelephone" size="30" value = "${utilisateur.getTelephone()}"></td>
										
										<td><label>Rue :</label></td>
										<td><input type="text" name="newRue" size="30" value = "${utilisateur.getRue()}"></td>
							 		</tr>
							 		
							 		<tr>
							 			<td><label>Code postal :</label></td>
							 			<td><input type="text" name="newCodePostal" size="30" value ="${utilisateur.getCodePostale()}"></td>
							 			
							 			<td><label>Ville :</label></td>
										<td><input type="text" name="newVille" size="30" value = "${utilisateur.getVille()}"></td>
							 		</tr>
							 		
							 		<tr>						 									 			
							 			<td><label>Mot de passe actuel :</label></td>
							 			<td><input type="password" name="mdpActuel" size="30"></input></td>
							 		</tr>
							 		
							 		<tr>						 									 			
							 			<td><label>Nouveau mot de passe :</label></td>
							 			<td><input type="password" name="newMdp" size="30"></input></td>
							 			
							 			<td><label>Confirmation :</label></td>
							 			<td><input type="password" name="confirmNewMdp" size="30"></input></td>
							 		</tr>
							 		
							 		<tr> <!-- ligne vide -->
							 			<td></td>
							 		</tr>
							 		
							 		<tr>
							 			<td>Credit : ${utilisateur.getCredit()}</td>
							 		</tr>
							 		
							 	</table>
						 	</div>
						 	
						 	<div class="row justify-content-center">
								<div class="col-12 text-center">
									<button name="btn" value="enregistrer">Enregistrer</button>
									<button name="btn" value="supprimer" class="btnSuppr">Supprimer mon compte</button>
								</div>
							</div>
								
					</form>
				</c:if>		
			</c:forEach>
		</div>
	</main>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

</body>
</html>