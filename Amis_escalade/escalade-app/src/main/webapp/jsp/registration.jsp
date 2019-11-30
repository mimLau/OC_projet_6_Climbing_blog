<%--
  Created by IntelliJ IDEA.
  User: lam99
  Date: 27/11/2019
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>S'enregistrer</title>
    <link type="text/css" rel="stylesheet" href="./css/form.css">
</head>
<body>
    <form method="post" action="register">
        <fieldset>
            <legend>S'inscrire</legend>
            <label for="username">Nom d'utilisateur</label>
            <input type="text" id="username" name="username" value="<c:out value="${user.username}"/>">
            <span class="errors">${form.errors['username']}</span>
            <br />

            <label for="firstname">Nom</label>
            <input type="text" id="firstname" name="firstname" value="<c:out value="${user.firstname}"/>">
            <span class="errors">${form.errors['firstname']}</span>
            <br />

            <label for="lastname">Prénom</label>
            <input type="text" id="lastname" name="lastname" value="<c:out value="${user.lastname}"/>">
            <span class="errors">${form.errors['lastname']}</span>
            <br/>

            <label for="email">Adresse e-mail</label>
            <input type="email" id="email" name="email" value="<c:out value="${user.email}"/>">
            <span class="errors">${form.errors['email']}</span>
            <br />

            <label for="password">Mot de passe</label>
            <input type="password" id="password" name="password">
            <span class="errors">${form.errors['password']}</span>
            <br />

            <label for="passConf">Confirmation du mot de passe</label>
            <input type="password" id="passConf" name="passConf">
            <span class="errors">${form.errors['passConf']}</span>
            <br />

            <input type="submit" value="Créer votre compte" class="sansLabel" />
            <br />
        </fieldset>
    </form>

</body>
</html>
