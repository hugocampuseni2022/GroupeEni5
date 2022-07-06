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
<link rel="stylesheet" href="style/ModiProfil.css">
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
		
		
		<div class="white m-1 mx-0 p-3 pt-1 d-flex justify-content-center"> <!-- REVIEW padding and margin -->
		 	
			<c:forEach var="utilisateur" items="${catalogue}">
				<c:if test="${id== utilisateur.getNoUtilisateur()}">
					<form action="ModifProfilServlet" method="post">
						<input type = "hidden" name ="idUtilisateur" value="${utilisateur.getNoUtilisateur()}"/></input>
						
							<div class="d-flex my-3 flex-column flex-sm-column flex-md-row justify-content-between">	
						 		<div class="me-lg-5 d-flex m">
						 			<label>Pseudo :</label>
						 			<input type="text" name="newPseudo" size="30" value = "${utilisateur.getPseudo()}" >
						 		</div>						 		
						 		<div class="d-flex">
						 			<label>Nom :</label>
						 			<input type="text" name="newNom" size="30" value = "${utilisateur.getNom()}">
						 		</div>						 		
						 	</div>

							<div class="d-flex my-3 flex-column flex-sm-column flex-md-row justify-content-between">
								<div class="me-lg-5 d-flex m">
									<label>Prénom :</label>
                                	<input type="text" name="newPrenom" size="30" value = "${utilisateur.getPrenom()}">
								</div>
								<div class="d-flex">
									<label>Email :</label>
                                	<input type="text" name="newEmail" size="30" value = "${utilisateur.getEmail()}">
								</div>
							</div>
							
							<div class="d-flex my-3 flex-column flex-sm-column flex-md-row justify-content-between">
								<div class="me-lg-5 d-flex m">
									<label>Téléphone :</label>
                                   	<input type="text" name="newTelephone" size="30" value = "${utilisateur.getTelephone()}">
								</div>
								<div class="d-flex">
									<label>Rue :</label>
                                  	<input type="text" name="newRue" size="30" value = "${utilisateur.getRue()}">
								</div>
							</div>
							
							<div class="d-flex my-3 flex-column flex-sm-column flex-md-row justify-content-between">
								<div class="me-lg-5 d-flex m">
									<label>Code postal :</label>
                                   	<input type="text" name="newCodePostal" size="30" value ="${utilisateur.getCodePostale()}">
								</div>
								<div class="d-flex">
									<label>Ville :</label>
                                   	<input type="text" name="newVille" size="30" value = "${utilisateur.getVille()}">
								</div>
							</div>

							<div class="d-flex my-3 flex-column flex-sm-column flex-md-row justify-content-between">
								<div class="">
									<label class="ls">Mot de passe actuel :</label>
                                   	<input type="password" name="mdpActuel" size="30"></input>
								</div>														
							</div>	<!-- *****************************case vide**************************** -->

							<div class="d-flex my-3 flex-column flex-sm-column flex-md-row justify-content-between">
								<div class="me-lg-5 d-flex m">
									<label>Nouveau mot de passe :</label>
                                   	<input type="password" name="newMdp" size="30"></input>
								</div>
								<div class="d-flex">
									<label>Confirmation :</label>
                                   	<input type="password" name="confirmNewMdp" size="30"></input>
								</div>
							</div>
                            
                            <div class="d-flex">
								<div class="mt-3">
									<p>Credit : ${utilisateur.getCredit()}</p>
								</div>
							</div>
							
							<div class="d-flex m-3">
								<div class="mx-2">
									<p class="red">	${error}	</p>					
									<p class="red">	${erreur}	</p>
								</div>
							</div>
										

	                        <div class="row">
	                            <div class="col-12 text-center">
	                                <button name="btn" value="enregistrer" class="mx-2">Enregistrer</button>
	                                <button name="btn" value="supprimer" class="btnSuppr mx-2 btnMargin">Supprimer mon compte</button>
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