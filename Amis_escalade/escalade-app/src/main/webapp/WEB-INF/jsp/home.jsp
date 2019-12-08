<%--
  Created by IntelliJ IDEA.
  User: lam99
  Date: 30/11/2019
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<head>
    <title>Accueil</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/templates/header.jsp"/>
    <c:if test="${sessionScope.user.username != null}">
        <a href="${pageContext.request.contextPath}/auth/addSite" tabindex="-1" aria-disabled="true">Ajouter un nouveau site d'escalade.</a>
    </c:if>
    <c:if test="${sessionScope.user.role == 'ADMIN'}">
        <a href="${pageContext.request.contextPath}/admin/addPlace">Page admin</a>
    </c:if>

</body>
</DOCTYPE>
