<%--
  Created by IntelliJ IDEA.
  User: lam99
  Date: 27/11/2019
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>S'inscrire</title>
    <link type="text/css" rel="stylesheet" href="">
</head>
<body>
    <form method="post" action="registration">
        <legend>S'inscrire</legend>
        <label for="username">Nom d'utilisateur</label>
        <input type="text" id="username" name="username">

        <label for="lastname">Nom</label>
        <input type="text" id="lastname" name="lastname">

        <label for="firstname">Prénom</label>
        <input type="text" id="firstname" name="firstname">

        <label for="email">E-mail</label>
        <input type="text" id="email" name="email">

        <label for="password">Mot de passe</label>
        <input type="text" id="password" name="password">

        <label for="passwordConfirm">Confirmation du mot de passe</label>
        <input type="text" id="passwordConfirm" name="passwordConfirm">
    </form>

</body>
</html>
