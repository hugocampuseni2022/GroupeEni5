<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Profil</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
	<header>
		<h2>ENI-Encheres</h2>
	</header>
	<main>
		<div>
			<table>
				<tr>
					<td>Pseudo :</td>
					<td><!-- ${getPseudo} --></td>
				</tr>
				<tr>
					<td>Nom :</td>
					<td><!-- ${getNom} --></td>
				</tr>
				<tr>
					<td>Prénom :</td>
					<td><!-- ${getPrenom} --></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><!-- ${getEmail} --></td>
				</tr>
				<tr>
					<td>Téléphone :</td>
					<td><!-- ${getTel} --></td>
				</tr>
				<tr>
					<td>Rue :</td>
					<td><!-- ${getRue} --></td>
				</tr>
				<tr>
					<td>Code postal :</td>
					<td><!-- ${getCP} --></td>
				</tr>
				<tr>
					<td>Ville :</td>
					<td><!-- ${getVille} --></td>
				</tr>
			</table>
		</div>
		<div>
			<form action="" method="post"> 				<!-- TODO lien vers la page de modif profil -->
				<button>Modifier</button> 				<!-- TODO affichage button (c:if user=userEnCours) -->
			</form>
		</div>
	
	</main>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>