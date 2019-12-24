<%--
  Created by IntelliJ IDEA.
  User: lam99
  Date: 24/12/2019
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<html>
    <head>
        <title>Liste des topos</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/templates/header.jsp"/>
        <div>
            <c:choose>
                <c:when test="${! empty topos}">
                    <table class="table table-hover">
                        <tr>
                            <th>Nom du topo</th>
                            <th>Description</th>
                            <th>Date de parution</th>
                            <th>Disponibilité</th>
                            <th>Propriétaire</th>
                        </tr>
                        <c:forEach items="${topos}" var="topo">
                            <tr>
                                <td> <c:out value="${topo.name}"></c:out></td>
                                <td><c:out value="${topo.description}"/></td>
                                <td><c:out value="${topo.releaseDate}"/></td>
                                <td>
                                    <c:if test="${topo.borrowed == false}">
                                    Disponible
                                    </c:if>
                                    <c:if test="${topo.borrowed == true}">
                                        Prêté
                                    </c:if>
                                </td>
                                <td><c:out value="${topo.topoOwner.username}"/></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
                <c:otherwise>
                    <p>Il n'y aucun topo d'enregistré.</p>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
