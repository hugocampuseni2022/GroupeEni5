<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Nouvelle Vente</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
	<link rel="stylesheet" href="style/nouvelleVente.css">
</head>
<body>
	<header class="container-fluid">
		<div class="row">
			<div class="col-sm-12 col-md-4 logo">
				<a href="<%=request.getContextPath()%>/Accueil">Eni-Enchères</a>
            </div>
		</div>
	</header>
    <div class="container">
        <div class="row">
            <div class="col-12 justify-content-center mb-4">
                <h2 class="text-center">Nouvelle Vente</h2>
            </div>
        </div>
    </div>
    <main class="container">
        <div class="row justify-content-center">
        	${error}
            <form action="NouvelleVenteServlet" class="col-12 col-sm-12 col-md-10 col-lg-8 p-4 d-flex flex-column justify-content-center" method="post">
            	<input type = "hidden" name ="id" value="${id}"/>
                <div class="mb-2 d-flex justify-content-center">
                    <label for="article">Article :</label>
                    <input type="text" name="article" id="article"></input>
                </div>
                <div class="d-flex justify-content-center mb-2">
                    <label for="description">Description :</label>
                    <textarea name="description" id="description" rows="3"></textarea>
                </div>
                <div class="mb-2 d-flex justify-content-center">
                    <label for="categorie">Catégorie :</label>
                    <select name="categorie" id="categorie">
                    	<c:forEach var="categorie" items="${categories}">
							<option value="${categorie.noCategorie}">${categorie.libelle}</option>
						</c:forEach>
                    </select>
                </div>
                <div class="mb-2 d-flex justify-content-center">
                    <label for="photo">Photo de l'article :</label>
                    <input type="file" name="photo" id="photo">
                </div>
                <div class="mb-2 d-flex justify-content-center">
                    <label for="prix">Mise à prix :</label>
                    <input type="number" name="prix" id="prix" min="0" value="100" step="5">
                </div>
                <div class="mb-2 d-flex justify-content-center">
                    <label for="dateDebut">Début de l'enchère :</label>
                    <input type="date" name="dateDebut" id="dateDebut">
                </div>
                <div class="mb-2 d-flex justify-content-center">
                    <label for="dateFin">Fin de l'enchère :</label>
                    <input type="date" name="dateFin" id="dateFin">
                </div>
                <div class="container">
                    <div class="row justify-content-center">
                        <fieldset class="col-12 col-sm-12 col-md-9 col-lg-7 mb-2">
                            <legend >Retrait</legend>
                           	<c:forEach var="utilisateur" items="${catalogue}">
                            	<c:if test="${utilisateur.getNoUtilisateur()==id}">
                            		<div class="mb-2  d-flex justify-content-center">
		                                <label for="rue">Rue :</label>
		                                <input type="text" name="rue" id="rue" value="${utilisateur.getRue()}">
		                            </div>
		                            <div class="mb-2 d-flex justify-content-center">
		                                <label for="codePostal">Code postal :</label>
		                                <input type="text" name="codePostal" id="codePostal" value="${utilisateur.getCodePostale()}">
		                            </div>
		                            <div class="mb-2 d-flex justify-content-center">
		                                <label for="ville">Ville :</label>
		                                <input type="text" name="ville" id="ville" value="${utilisateur.getVille()}">
		                            </div>
                            	</c:if>
                            </c:forEach>
                        </fieldset>
                        <div class="d-inline text-center">
                            <button class="button" name="btn" value="enregistrer">Enregistrer</button>
                            <button class="button" name="btn" value="annuler">Annuler</button>
                            <c:forEach var="utilisateur" items="${catalogue}">
                            	<c:if test="${utilisateur.getNoUtilisateur()==id}">
	                            	<c:forEach var="article" items="${utilisateur.getListeArticle()}">
	                            		<c:if test="${noArticle==article.getNoArticle()}">
	                            			<button class="button" name="btn" value="annulerVente">Annuler la vente</button>
	                            		</c:if>
	                            	</c:forEach>
                            	</c:if>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </main>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>