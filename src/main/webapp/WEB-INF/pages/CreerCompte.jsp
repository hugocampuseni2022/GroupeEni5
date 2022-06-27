<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Creer Compte</title>
</head>
<h1> Enchère ENI</h1>
<h2>Mon Profil</h2>

<form action="" method = "post">
<label>Pseudo : </label>
 <input type="text" name = "pseudo" required></input> 
<label>Nom : </label>
 <input type="text" name = "nom" required></input> 
 <label>Prénom : </label>
 <input type="text" name = "prenom" required></input> 
 <label>Email : </label>
 <input type="email" name = "mail" required></input> 
 <label>Telephone : </label>
 <input type="tel" name = "telephone"></input> 
 <label>Rue : </label>
 <input type="number" name = "rue" required></input> 
 <label>Code Postal : </label>
 <input type="text" name = "code postal" required></input> 
 <label>Ville : </label>
 <input type="text" name = "ville" required></input> 
 <label>Mots de passe : </label>
 <input type="password" name = "mot de passe" required></input> 
 <label>Confirmation : </label>
 <input type="password" name = "Confirmation" required></input> 
 <button>Créer</button>
</form>

<a href = "<%=request.getContextPath()%>/Accueil" ><button>Annuler</button> </a>


<body>
<h1></h1>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>