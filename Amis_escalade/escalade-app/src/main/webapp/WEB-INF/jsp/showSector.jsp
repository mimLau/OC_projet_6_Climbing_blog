<%--
  Created by IntelliJ IDEA.
  User: lam99
  Date: 11/12/2019
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<html>
    <head>
        <title>Secteur - ${sector.name}</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/templates/header.jsp"/>
               <c:if test="${sector != null}">
                    <div>
                        <table class="table table-hover">
                            <tr>
                                <th>Nom de la voie</th>
                                <th>Longueur</th>
                                <th>Cotation</th>
                                <th>Nombre de longueurs</th>
                            </tr>
                            <c:forEach items="${sector.ways}" var="way">
                                <tr>
                                    <td><a style="text-decoration: none" href="${pageContext.request.contextPath}/showWay?id=${way.id}"><c:out value="${way.name}"/></a></td>
                                    <td><c:out value="${way.length}"/></td>
                                    <td><c:out value="${way.rating}"/></td>
                                    <td><c:out value="${way.nbOfLengths}"/></td>
                                </tr>
                            </c:forEach>
                        </table>
                </div>
            </c:if>
            <c:if test="${sessionScope.user.username != null}">
                <div>
                <a class="btn btn-primary stretched-link" href="${pageContext.request.contextPath}/auth/addWay">Ajouter une voie</a>
                </div>
            </c:if>
    </body>
</html>
