<%--
  Created by IntelliJ IDEA.
  User: lam99
  Date: 27/11/2019
  Time: 22:56
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
    <form method="post" action="login">
        <fieldset>
            <legend>Se connecter</legend>

            <label for="email">Adresse e-mail</label>
            <input type="text" id="email" name="email" value="<c:out value="${}"/>">

            <label for="password">Mot de passe</label>
            <input type="password" id="password" name="password" value="<c:out value="${}"/>">
            <span class="errors"></span>
        </fieldset>
    </form>

</body>
</html>
