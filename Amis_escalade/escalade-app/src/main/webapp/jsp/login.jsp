<%--
  Created by IntelliJ IDEA.
  User: lam99
  Date: 27/11/2019
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Se connecter</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link type="text/css" rel="stylesheet" href="./css/form.css">
</head>
<body>
    <form method="post" action="login">
        <fieldset>
            <legend>Se connecter</legend>

            <label for="identifier">Adresse e-mail ou nom d'utilisateur</label>
            <input type="text" id="identifier" name="identifier" value="">
            <span class="errors">${form.errors['identifier']}</span>
            <br/>

            <label for="password">Mot de passe</label>
            <input type="password" id="password" name="password" value="">
            <span class="errors">${form.errors['password']}</span>
            <br/>

            <input type="submit" value="Se connecter" class="sansLabel" />
            <br />
        </fieldset>
    </form>

    <a href="register">S'enregistrer</a>
</body>
</html>
