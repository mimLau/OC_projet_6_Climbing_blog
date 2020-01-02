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
                                <td><c:out value="${topo.key.name}"></c:out></td>
                                <td><c:out value="${topo.key.description}"/></td>
                                <td><c:out value="${topo.key.releaseDate}"/></td>
                                <td>
                                    <c:if test="${topo.key.borrowed == false}">
                                    Disponible
                                    </c:if>
                                    <c:if test="${topo.key.borrowed == true}">
                                        Indisponible
                                    </c:if>
                                </td>
                                <td><c:out value="${topo.key.topoOwner.username}"/></td>
                                <td>
                                    <c:if test="${topo.key.borrowed == false}">
                                        <c:choose>
                                            <c:when  test="${topo.value == false}">
                                                <c:if test="${topo.key.topoOwner.username != sessionScope.user.username }">
                                                    <button><a style="text-decoration:none;" href="${pageContext.request.contextPath}/auth/bookingTopo?id=${topo.key.id}">Réserver</a></button>
                                                </c:if>
                                                <c:if test="${topo.key.topoOwner.username == sessionScope.user.username }">
                                                    <button style="color:#D8D5D5;cursor: default;" title="Vous ne pouvez pas réserver votre propre topo.">Réserver</button>
                                                </c:if>
                                            </c:when>
                                            <c:otherwise>
                                                <button style="color:#D8D5D5;cursor: default;" title="Une demande de réservation est déjà en cours.">Réserver</button>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:if>
                                    <c:if test="${topo.key.borrowed == true}">
                                        <c:choose>
                                            <c:when test="${topo.key.topoOwner.username == sessionScope.user.username }">
                                                <button style="color:#D8D5D5;cursor: default;" title="Topo indisponible. Vous ne pouvez pas réserver votre propre topo.">Réserver</button>
                                            </c:when>
                                            <c:otherwise>
                                                <button style="color:#D8D5D5;cursor: default;" title="Topo indisponible.">Réserver</button>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:if>
                                </td>
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
