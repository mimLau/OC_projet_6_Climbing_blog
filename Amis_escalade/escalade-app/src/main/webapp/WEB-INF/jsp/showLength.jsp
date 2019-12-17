<%--
  Created by IntelliJ IDEA.
  User: lam99
  Date: 17/12/2019
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Longueur - </title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
    <body>
        <jsp:include page="/WEB-INF/jsp/templates/header.jsp"/>
        <c:if test="${length != null}">
            <div class="text-center"><h3 class="card-title"><c:out value="${length.name}"></c:out></h3></div><br/><br/>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item" style="list-style-type: none">Site: <c:out value="${site.name}"></c:out></li>
                    <li class="list-group-item">Secteur : <c:out value="${sector.name}"></c:out></li>
                    <li class="list-group-item">Voie : <c:out value="${way.name}"></c:out></li>
                    <li class="list-group-item">Longueur : <c:out value="${length.name}"></c:out></li>
                </ul>
        </c:if>
    </body>
</html>

