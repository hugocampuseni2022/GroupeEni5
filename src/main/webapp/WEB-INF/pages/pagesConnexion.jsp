<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pages Connexion</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<h1>ENI -Enchères</h1>

        <form action="Connexion" method = "post">
            <label>Identifiant : </label>
            <input type="text" name = "identifiant"></input>
            <label>Mots de passe : </label>
            <input type="text" name = "identifiant"></input>
            <input type="checkbox"> Se souvenir de moi</input>
            <a href > Mot de passe oublié</a>
            <button>Connextion</button> 
        </form>

        <p>${error}</p>

        <button>
        <a href ="<%=request.getContextPath()%>/CreerCompte"> Créer un compte</a>
        </button>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>                
</body>
</html>