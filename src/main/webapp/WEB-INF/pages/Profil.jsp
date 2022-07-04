<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Profil</title>
<link rel="stylesheet" href="style/Profil.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
	
</head>
<body>
	<header>
		<div class="container-fluid">
			<div class="row">
				<div class="col-12">
					<a id="logo" classe="titre" href = "<%=request.getContextPath()%>/Accueil" style="text-decoration:none;">ENI-Encheres</a>
				</div>
			</div>
		</div>
	</header>
	<main>
		<div>
			<div>
				<c:forEach var="utilisateur" items="${catalogue}">
					<c:if test="${pseudo.equals(utilisateur.getPseudo())}">
						<table>
						<tr>
							<td>Pseudo :</td>
							<td>${utilisateur.getPseudo()}</td>
						</tr>
						<tr>
							<td>Nom :</td>
							<td>${utilisateur.getNom()}</td>
						</tr>
						<tr>
							<td>Prénom :</td>
							<td>${utilisateur.getPrenom()}</td>
						</tr>
						<tr>
							<td>Email :</td>
							<td>${utilisateur.getEmail()}</td>
						</tr>
						<tr>
							<td>Téléphone :</td>
							<td>${utilisateur.getTelephone()}</td>
						</tr>
						<tr>
							<td>Rue :</td>
							<td>${utilisateur.getRue()}</td>
						</tr>
						<tr>
							<td>Code postal :</td>
							<td>${utilisateur.getCodePostale()}</td>
						</tr>
						<tr>
							<td>Ville :</td>
							<td>${utilisateur.getVille()}</td>
						</tr>
					</table>
					</c:if>
				</c:forEach>
			</div>
		</div>
		<div>
			<c:if test="${pseudo.equals(username)}">
				<form action="ModifProfilServlet" method="get">
					<button>Modifier</button>
				</form>
			</c:if>
		</div>
	
	</main>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>