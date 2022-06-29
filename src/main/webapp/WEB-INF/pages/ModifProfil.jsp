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
</head>
<body>
	<header>
		<h2>ENI-Encheres</h2>
	</header>
	<main>
		<div>
			<h3>Mon Profil</h3>
		</div>
		<div>
			<form action="" method="post"> 			<!--   TODO lien vers page 'Profil'   -->
				<input type = "hidden" name ="idutilisateur" value="${!empty utilisateur?'' : utilisateur.noUtilisateur}"/> 
				<div>
					<div>
						<label>Pseudo :</label>
					</div>
					<div>
						<input type="text" name="newPseudo" size="30"></input>
					</div>
					<div>
						<label>Nom :</label>
					</div>
					<div>
						<input type="text" name="newNom" size="30"></input>
					</div>
				</div>
				<div>
					<div>
						<label>Prénom :</label>
					</div>
					<div>
						<input type="text" name="newPrenom" size="30"></input>
					</div>
					<div>
						<label>Email :</label>
					</div>
					<div>
						<input type="text" name="newEmail" size="30"></input>
					</div>
				</div>
				<div>
					<div>
						<label>Téléphone :</label>
					</div>
					<div>
						<input type="text" name="newTelephone" size="30"></input>
					</div>
					<div>
						<label>Rue :</label>
					</div>
					<div>
						<input type="text" name="newRue" size="30"></input>
					</div>
				</div>
				<div>
					<div>
						<label>Code postal :</label>
					</div>
					<div>
						<input type="text" name="newCodePostal" size="30"></input>
					</div>
					<div>
						<label>Ville :</label>
					</div>
					<div>
						<input type="text" name="newVille" size="30"></input>
					</div>
				</div>
				<div>
					<div>
						<label>Mot de passe actuel :</label>
					</div>
					<div>
						<input type="text" name="mdpActuel" size="30"></input>
					</div>
					<div>
						<!-- Case vide -->
					</div>
				</div>
				<div>
					<div>
						<label>Nouveau mot de passe :</label>
					</div>
					<div>
						<input type="text" name="newMdp" size="30"></input>
					</div>
					<div>
						<label>Confirmation :</label>
					</div>
					<div>
						<input type="text" name="confirmNewMdp" size="30"></input>
					</div>
				</div>
				<div>
					<!--   Ligne vide entre 'MDP' et 'Crédit'  	 -->
				</div>
				<div>
					Crédit				<!-- TODO ${user.getCredit) -->
				</div>
				<div>
					<!--   Ligne vide entre 'Crédit' et les boutons 	 -->
				</div>
				<button name="btn" value="enregistrer">Enregistrer</button>
				<button name="btn" value="supprimer">Supprimer mon compte</button>
			</form>
		</div>
	</main>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

</body>
</html>