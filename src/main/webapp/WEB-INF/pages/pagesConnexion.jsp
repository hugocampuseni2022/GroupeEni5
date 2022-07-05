<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pages Connexion</title>
<link rel="stylesheet" href="style/connexion.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
	<header class="container-fluid">
		<div class="row">
			<div class="col-sm-12 col-md-4 logo">
				<a href="<%=request.getContextPath()%>/Accueil">ENI-Enchères</a>
            </div>
		</div>
	</header>
    <main class="container">
        <div class="row justify-content-center">
            <div class="col-12 col-sm-12 col-md-10 col-lg-6 d-flex flex-column corps py-4 p-md-4">
                <form action="Connexion" method="post">
                    <fieldset>
                        <legend class="text-center pb-3">Connexion</legend>
                        <div class="d-flex justify-content-center mb-2">
                            <label for="identifiant" class="label-field">Identifiant : </label>
                            <input type="text" name="identifiant" id="identifiant" class="input-t"></input>
                        </div>
                        <div class="d-flex justify-content-center mb-4">
                            <label for="mot de passe" class="label-field">Mot de passe : </label>
                            <input type="password" name="mot de passe" id="mot de passe" class="input-t"></input>
                        </div>
                        <div class="d-flex justify-content-around justify-content-md-center mb-4 ">
                            <div class="button-div d-flex justify-content-center align-items-center">
                                <button class="button">Connexion</button>
                            </div>
                            <div class="d-flex flex-column align-items-center">
                                <div class="mb-2 checkbox-label d-flex justify-content-center">
                                    <label for="remember" class="label-check"><input type="checkbox" id="remember"></input> Se souvenir de moi</label>
                                </div>
                                <a href > Mot de passe oublié</a>
                            </div>
                        </div>
                    </fieldset>
                </form>
                <div class="d-flex justify-content-center">
                    <button class="button button2">
                        <a href ="<%=request.getContextPath()%>/CreerCompte">Créer un compte</a>
                    </button>
                </div>
            </div>
        </div>
    </main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>                
</body>
</html>