<%--
  Created by IntelliJ IDEA.
  User: lam99
  Date: 14/12/2019
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Voie - </title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/templates/header.jsp"/>
        <c:if test="${way != null}">
            <div>
                <table class="table table-hover">
                    <tr>
                        <th>Nom de la longeur</th>
                        <th>Longueur</th>
                        <th>Cotation</th>
                    </tr>
                    <c:forEach items="${way.lengths}" var="length">
                        <tr>
                            <td><a style="text-decoration: none" href="${pageContext.request.contextPath}/showLength?id=${length.id}"><c:out value="${length.name}"/></a></td>
                            <td><c:out value="${length.length}"/></td>
                            <td><c:out value="${length.rating}"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </c:if>
    <div>
        <c:if test="${sessionScope.user.username != null}">
            <a class="btn btn-primary stretched-link" href="${pageContext.request.contextPath}/auth/addLength">Ajouter une longeur</a>
        </c:if>
    </div>
</body>
</html>