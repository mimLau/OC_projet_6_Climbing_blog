<%--
  Created by IntelliJ IDEA.
  User: lam99
  Date: 27/12/2019
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<html>
    <head>
        <title>Tableau de réservations</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/templates/header.jsp"/>
        <div>
            <c:choose>
                <c:when test="${! empty bookings}">
                    <table class="table table-hover">
                        <tr>
                            <th>Nom du topo</th>
                            <th>Demandeur</th>
                            <th>Adresse email</th>
                            <th>Statut</th>
                        </tr>
                        <c:forEach items="${bookings}" var="booking">
                            <tr>
                                <td><c:out value="${booking.topo.name}"></c:out></td>
                                <td><c:out value="${booking.userRequest.username}"></c:out></td>
                                <td><c:out value="${booking.userRequest.email}"></c:out></td>
                                <td>
                                    <c:if test="${booking.status == 'IN_PROGRESS'}">
                                        En attente
                                    </c:if>
                                    <c:if test="${booking.status == 'ACCEPTED'}">
                                        Acceptée
                                    </c:if>
                                    <c:if test="${booking.status == 'EXPIRED'}">
                                        expirée
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${booking.status == 'IN_PROGRESS'}">
                                        <c:if test="${booking.topo.borrowed != true}">
                                            <button><a style="text-decoration:none;" href="${pageContext.request.contextPath}/auth/validateBooking?id=${booking.id}">Valider</a></button>
                                        </c:if>

                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
                <c:otherwise>
                    Il n'y a aucune demande de réservation.
                </c:otherwise>
            </c:choose>
        </div>

    </body>
</html>
