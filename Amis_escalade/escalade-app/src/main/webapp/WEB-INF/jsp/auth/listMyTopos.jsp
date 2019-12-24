<%--
  Created by IntelliJ IDEA.
  User: lam99
  Date: 24/12/2019
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<html>
    <head>
        <title>Mes topos</title>
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
                            <th>Disponibilité</th>
                        </tr>
                        <c:forEach items="${topos}" var="topo">
                            <tr>
                                <td> <c:out value="${topo.name}"></c:out></td>
                                <td>
                                    <c:if test="${topo.borrowed == true}">
                                        <button><a href="${pageContext.request.contextPath}/auth/updateTopo?id=${topo.id}&disp=false">Indisponible</a></button>
                                    </c:if>
                                    <c:if test="${topo.borrowed == false}">
                                        <button><a href="${pageContext.request.contextPath}/auth/updateTopo?id=${topo.id}&disp=true">Disponible</a></button>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
                <c:otherwise>
                    <p>Vous n'avez enregistré aucun topo.</p>
                </c:otherwise>
            </c:choose>
        </div>
        <div>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/auth/addTopo" tabindex="-1" aria-disabled="true">Ajouter un topo</a>
        </div>
    </body>
</html>
