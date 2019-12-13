<%--
  Created by IntelliJ IDEA.
  User: lam99
  Date: 10/12/2019
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html lang="en">
<head>
    <title>Ajouter un secteur</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/templates/header.jsp"/>
    <form method="post" action="${pageContext.request.contextPath}/auth/addSector">
        <h1><c:out value="${site.name}"/></h1><br/>
        <div class="form-group">
            <label for="sectorName">Nom du secteur</label>
            <input type="text" name="sectorName" class="form-control" id="sectorName">
        </div>

        <button type="submit" name="AddSector" class="btn btn-primary">Ajouter le secteur</button>
    </form>
<body>
</html>
