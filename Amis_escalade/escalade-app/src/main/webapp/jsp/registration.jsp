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
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="./css/bootstrap.css">
    <link rel="stylesheet" href="./css/form.css">
</head>
<body>
    <jsp:include page="/templates/header.jsp"/>
    <form method="post" action="register">
        <div class="form-group">
            <label for="username">Nom d'utilisateur</label>
            <input type="text" class="form-control" id="username" name="username" value="<c:out value="${user.username}"/>">
            <span class="errors">${form.errors['username']}</span>
        </div>
        <div class="form-group">
            <label for="firstname">Nom</label>
            <input type="text" class="form-control" id="firstname" name="firstname" value="<c:out value="${user.firstname}"/>">
            <span class="errors">${form.errors['firstname']}</span>
        </div>
        <div class="form-group">
            <label for="lastname">Prénom</label>
            <input type="text" class="form-control" id="lastname" name="lastname" value="<c:out value="${user.lastname}"/>">
            <span class="errors">${form.errors['lastname']}</span>
        </div>
        <div class="form-group">
            <label for="email">Adresse e-mail</label>
            <input type="email" class="form-control" id="email" name="email" value="<c:out value="${user.email}"/>">
            <span class="errors">${form.errors['email']}</span>
        </div>
        <div class="form-group">
            <label for="password">Mot de passe</label>
            <input type="password" class="form-control" id="password" name="password">
            <span class="errors">${form.errors['password']}</span>
        </div>
        <div class="form-group">
            <label for="passConf">Confirmation du mot de passe</label>
            <input type="password" class="form-control" id="passConf" name="passConf">
            <span class="errors">${form.errors['passConf']}</span>
        </div>
        <button type="submit" class="btn btn-primary">Créer votre compte</button>
    </form>

</body>
</html>
