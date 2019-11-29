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
    <title>S'inscrire</title>
    <link type="text/css" rel="stylesheet" href="">
</head>
<body>
    <form method="post" action="registration">
        <fieldset>
            <legend>S'inscrire</legend>
            <label for="username">Nom d'utilisateur</label>
            <input type="text" id="username" name="username" value="<c:out value="${user.username}"/>">
            <span class="erreurs">${form.erreurs['username']}</span>

            <label for="firstname">Nom</label>
            <input type="text" id="firstname" name="firstname" value="<c:out value="${user.firstname}"/>">
            <span class="erreurs">${form.erreurs['firstname']}</span>

            <label for="lastname">Prénom</label>
            <input type="text" id="lastname" name="lastname" value="<c:out value="${user.lastname}"/>">
            <span class="erreurs">${form.erreurs['lastname']}</span>

            <label for="email">Adresse e-mail</label>
            <input type="email" id="email" name="email" value="<c:out value="${user.email}"/>">
            <span class="erreur">${form.erreurs['email']}</span>
            <br />

            <label for="password">Mot de passe</label>
            <input type="password" id="password" name="password">
            <span class="erreur">${form.erreurs['password']}</span>

            <label for="passwordConfirm">Confirmation du mot de passe</label>
            <input type="password" id="passwordConfirm" name="passwordConfirm">
            <span class="erreur">${form.erreurs['passConf']}</span>
        </fieldset>
    </form>

</body>
</html>
