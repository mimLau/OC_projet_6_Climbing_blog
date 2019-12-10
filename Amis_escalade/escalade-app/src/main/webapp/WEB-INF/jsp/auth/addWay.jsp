<%--
  Created by IntelliJ IDEA.
  User: lam99
  Date: 10/12/2019
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html lang="en">
<head>
    <title>Ajouter une voie</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/templates/header.jsp"/>
    <form method="post" action="${pageContext.request.contextPath}/auth/addWay">
        <h1><c:out value="${site.name}"/></h1><br/>
        <h2><c:out value="${sector.name}"/></h2><br/>

    </form>
    <button type="submit" name="AddSector" class="btn btn-primary">Ajouter la voie</button>
    <button type="submit" name="AddSector" class="btn btn-primary">Ajouter un autre secteur</button>
</body>
</html>
