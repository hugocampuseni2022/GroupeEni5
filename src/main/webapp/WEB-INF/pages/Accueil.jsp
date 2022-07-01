<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Accueil</title>
<link rel="stylesheet" href="style/Accueil.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
	<header class="container-fluid ">
		<div class="row">
			<div class="col-sm-12 col-md-4 logo">
				<span>ENI-Enchères</span>
			</div>
			<div class="col-sm-12 col-md-8 nav-menu">
				<c:choose>
					<c:when test="${connected.equals(\"false\")}">
						<div class="liste">
							<ul>
								<li>
									<a href="<%=request.getContextPath()%>/Connexion">S'inscrire - Se connecter</a>
								</li>
							</ul>
						</div>					
					</c:when>
					<c:otherwise>
						<div class="liste">
							<ul>
								<li>
									<a href="<%=request.getContextPath()%>/Accueil?action=deconnexion">Déconnexion</a>
								</li>
								<li>
									<a href="<%=request.getContextPath()%>/ProfilServlet?pseudo=${username}">Mon profil</a>
								</li>
								<li>
									<a href="<%=request.getContextPath()%>/NouvelleVenteServlet">Vendre un article</a>
								</li>
								<li>
									<a href="<%=request.getContextPath()%>">Enchères</a>
								</li>
							</ul>
						</div>
					</c:otherwise>
				</c:choose>
			</div>

		</div>
	</header>
	<main class="container">
		<div class="row">
			<div class="col-12 text-center">
				<h3>Liste des enchères</h3>
			</div>
			<div class="col-12 text-start">
				<h4>Filtres :</h4>
			</div>
			<form action="" method="get" class="col-12">
				<div class="">
					<div>
						<input type="text" placeholder="Le nom de l'article contient">
					</div>
					
					<label for="categorie">Catégorie :</label>
					<select name="categorie">
					    <option value="">Toutes</option>
					    <c:forEach var="categorie" items="${categories}">
			    		    <option value="${categorie.noCategorie}">${categorie.libelle}</option>
					    </c:forEach>
					</select>
					<script src="script/Accueil.js"></script>
					<div>
						<br>
		                <input type="radio" id="radioAchats" name="radio" value="achat">
		                <label for="radioAchats">Achats</label>
		            </div>
		            <div>
	            		<label><input type="checkbox" name="enchereOuverte" id="checkboxAchats" disabled> enchère ouvertes</label>           <!-- accessible seulement si 'radioAchats' est selectionné -->
		                <br>
		                <label><input type="checkbox" name="mesEncheres" id="checkboxAchats" disabled> mes enchères</label>             <!-- accessible seulement si 'radioAchats' est selectionné -->
		                <br>
		                <label><input type="checkbox" name="mesEnchereRemportees" id="checkboxAchats" disabled> mes enchères remportées</label>     <!-- accessible seulement si 'radioAchats' est selectionné -->
		           	</div>
		           	<div>
		           		<br>
		           		<input type="radio" id="radioVentes" name="radio" value="vente">
		                <label for="radioVentes">Mes ventes</label>
		           	</div>
		           	<div>
		                <label><input type="checkbox" name="mesVentesEnCours" id="checkboxVentes" disabled> mes ventes en cours</label>       	 <!-- accessible seulement si 'radioVentes' est selectionné -->
		                <br>
		                <label><input type="checkbox" name="ventesNonDebutees" id="checkboxVentes" disabled> ventes non débutées</label>     	 <!-- accessible seulement si 'radioVentes' est selectionné -->
		                <br>
		                <label><input type="checkbox" name="ventesTerminees" id="checkboxVentes" disabled> ventes terminées</label>       	 <!-- accessible seulement si 'radioVentes' est selectionné -->
		            </div>
		            <br>
					<button>Rechercher</button>
				</div>
			</form>
			<div>
				<!-- Liste des articles dans la bdd -->
				<c:forEach var="utilisateur" items="${catalogue}">
					<c:forEach var="article" items="${utilisateur.getListeArticle()}">	
						<div class="card mb-3" style="max-width: 540px;">
							<div class="row no-gutters">
								<div class="col-md-4">
									<img src="..." class="card-img" alt="...">
								</div>
								<div class="col-md-8">
									<div class="card-body">
										<a href="#" class="card-title">${article.getNomArticle()}</a>
										<c:choose>
											<c:when test="${article.getPrixVente()<article.getMiseAPrix()}">
												<p class="card-text">Prix : ${article.getMiseAPrix()} points</p>
											</c:when>
											<c:otherwise>
												<p class="card-text">Prix : ${article.getPrixVente()} points</p>
											</c:otherwise>
										</c:choose>
										<p class="card-text">Fin de l'enchère : ${article.getDateFinEncheres()}</p>
										<span class="card-text">Vendeur : </span>
										<a href="<%=request.getContextPath()%>/ProfilServlet?pseudo=${utilisateur.getPseudo()}" class="card-text">${utilisateur.getPseudo()}</a>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:forEach>
			</div>
		</div>
	</main>
		<script>
            // assign onclick handler to hazard checkbox
            document.getElementById('radioAchats').onclick = function() {
            
            // is hazard checkbox checked?
            var radio1 = this.checked; // true or false
            
            // get list of radio buttons with name 'ship'
            var check1 = this.form.elements["checkboxAchats"];

            // loop through list of radio buttons
            for (var i=0, len=check1.length; i<len; i++) {
                var r = check1[i]; // current radio button

                if ( radio1 ) { // hazard checkbox checked
                    r.disabled = false; // no radios disabled   
                } else { // hazard not checked 
                    r.checked = false; // unchecked
                    r.disabled = true; // disable
                } 

            }

            var check2 = this.form.elements["checkboxVentes"];

            for (var i=0, len=check2.length; i<len; i++) {
                var r = check2[i]; // current radio button

                if ( radio1 ) { // hazard checkbox checked
                    r.checked = false; // unchecked
                    r.disabled = true; // disable                 
                } else { // hazard not checked 
                    r.disabled = false; // no radios disabled  
                } 

            }
            
            }
            
            // assign onclick handler to hazard checkbox
            document.getElementById('radioVentes').onclick = function() {

            // is hazard checkbox checked?
            var radio2 = this.checked; // true or false

            // get list of radio buttons with name 'ship'
            var check2 = this.form.elements["checkboxVentes"];

            // loop through list of radio buttons
            for (var i=0, len=check2.length; i<len; i++) {
                var r = check2[i]; // current radio button

                if ( radio2 ) { // hazard checkbox checked

                    r.disabled = false; // no radios disabled   
                } else { // hazard not checked 
                    r.checked = false; // unchecked
                    r.disabled = true; // disable
                } 

            }

            var check1 = this.form.elements["checkboxAchats"];

            for (var i=0, len=check1.length; i<len; i++) {
                var r = check1[i]; // current radio button

                if ( radio2 ) { // hazard checkbox checked
                    r.checked = false; // unchecked
                    r.disabled = true; // disable                 
                } else { // hazard not checked 
                    r.disabled = false; // no radios disabled  
                } 

            }
            }

	</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>