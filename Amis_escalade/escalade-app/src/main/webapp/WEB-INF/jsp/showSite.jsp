<%--
  Created by IntelliJ IDEA.
  User: lam99
  Date: 10/12/2019
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Site - <c:out value="${site.name}"></c:out></title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
    <body>
        <jsp:include page="/WEB-INF/jsp/templates/header.jsp"/>
        <div class="text-center"><h3 class="card-title">Site - <c:out value="${site.name}"></c:out></h3></div><br/><br/>
        <h6 class="card-subtitle mb-2 text-muted">Description du site:</h6>
        <div style="width: 50rem;"><c:out value="${site.description}"></c:out></div><br/>
        <c:choose>
            <c:when test="${!empty site.sectors}">
                <p>Ce site présente différents secteurs, dont vous trouverez  la liste dans le tableau ci-dessous.</p><br/>
                <div>
                    <table class="table table-hover">
                        <tr>
                            <th>Nom du secteur</th>
                            <th>Nombre de voies</th>
                        </tr>
                        <c:forEach items="${site.sectors}" var="sector">
                            <tr>
                                <td> <a style="text-decoration: none" href="${pageContext.request.contextPath}/showSector?id=${sector.id}"><c:out value="${sector.name}"/></a></td>
                                <td><c:out value="${sector.nbOfWays}"></c:out></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </c:when>
            <c:otherwise>
                <p> Aucun secteur n'a été ajouté pour ce site.</p><br/>
            </c:otherwise>
        </c:choose>
        <c:if test="${sessionScope.user.username != null}">
            <div><a class="btn btn-primary" href="${pageContext.request.contextPath}/auth/addSector">Ajouter un secteur</a></div>
        </c:if>
    </body>
</html>
