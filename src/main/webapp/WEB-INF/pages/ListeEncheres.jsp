<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des enchères</title>
</head>
<body>
    <header>
        <a href = "<%=request.getContextPath()%>/Accueil">ENI-Encheres</a>
        <a href="">Enchères</a>              <!-- TODO lien -->
        <a href="">Vendre un article</a>     <!-- TODO lien -->
        <a href="">Mon profil</a>            <!-- TODO lien -->
        <a href="">Déconnexion</a>           <!-- TODO lien -->
    </header>
    <main>
        <h3>Liste des enchères</h3>
        <div>
            <h4>Filtres :</h4>
            <form action="" method="get">
                <input type="text" placeholder="Le nom de l'article contient">
                <label for="categorie">Catégorie :</label>
                <select name="categorie">
                    <option value="">Toutes</option>
                    <option value="Informatique">Informatique</option>
                    <option value="Ameublement">Ameublement</option>
                    <option value="Vetement">Vêtement</option>
                    <option value="Sport">Sport&Loisirs</option>
                </select>
                <button>Rechercher</button>
                <div>
                    <input type="radio" id="radioAchats" name="radio" value="achat">
                    <label for="achats">Achats</label>
                    <input type="radio" id="radioVentes" name="radio" value="vente">
                    <label for="ventes">Mes ventes</label>
                </div>
                <div>
                    <input type="checkbox" id="enchereOuverte" name="checkboxAchats" >           <!-- accessible seulement si 'radioAchats' est selectionné -->
                    <label for="enchereOuverte">enchères ouvertes</label>
                    <input type="checkbox" id="mesEncheres" name="checkboxAchats" >              <!-- accessible seulement si 'radioAchats' est selectionné -->
                    <label for="mesEncheres">mes enchères</label>
                    <input type="checkbox" id="mesEnchereRemportees" name="checkboxAchats" >     <!-- accessible seulement si 'radioAchats' est selectionné -->
                    <label for="mesEnchereRemportees">mes enchères remportées</label>
                    
                    <input type="checkbox" id="mesVentesEnCours" name="checkboxVentes">       	 <!-- accessible seulement si 'radioVentes' est selectionné -->
                    <label for="mesVentesEnCours">mes ventes en cours</label>
                    <input type="checkbox" id="ventesNonDebutees" name="checkboxVentes">       	 <!-- accessible seulement si 'radioVentes' est selectionné -->
                    <label for="ventesNonDebutees">ventes non débutées</label>
                    <input type="checkbox" id="ventesTerminees" name="checkboxVentes">       	 <!-- accessible seulement si 'radioVentes' est selectionné -->
                    <label for="ventesTerminees">ventes terminées</label>
                </div>
            </form>
        </div>
        <!-- Liste des articles dans la bdd -->
        <c:forEach var="article" items="${listeArticle}">
            <!-- TODO Card article -->
        </c:forEach>
    </main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>