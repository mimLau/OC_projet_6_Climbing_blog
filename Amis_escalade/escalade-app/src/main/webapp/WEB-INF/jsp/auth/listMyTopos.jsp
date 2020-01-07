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
        <div class="outer-div">
            <div class= "col-sm-10" style="margin:0 auto;">
                <c:choose>
                    <c:when test="${! empty topos}">
                        <br/>
                        <p class="text-center"> Mes topos enregistrés</p>
                        <table class="table" style="border: 1px solid #DDD;">
                            <thead>
                                <tr >
                                    <th>Nom du topo</th>
                                    <th>Disponibilité</th>
                                </tr>
                            </thead>
                            <tbody
                                <c:forEach items="${topos}" var="topo">
                                    <tr>
                                        <td> <c:out value="${topo.name}"></c:out></td>
                                        <td>
                                            <c:if test="${topo.borrowed == true}">
                                                <button type="button" class="btn btn-secondary" title="Cliquez pour rendre le topo disponible" style="width:115px;background-color:#CECEB7;border:none;opacity: 0.9;"><a style="text-decoration:none;color:white;" href="${pageContext.request.contextPath}/auth/updateTopo?id=${topo.id}&disp=false">Indisponible</a></button>
                                            </c:if>
                                            <c:if test="${topo.borrowed == false}">
                                                <button type="button" class="btn btn-secondary" title="Cliquez pour rendre le topo indisponible" style="width:115px;background-color:#CECEB7;border:none;opacity:0.9;"><a style="text-decoration:none;color:white;" href="${pageContext.request.contextPath}/auth/updateTopo?id=${topo.id}&disp=true">Disponible</a></button>
                                            </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <p>Vous n'avez enregistré aucun topo.</p>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class= "col-sm-10" style="margin:0 auto;">
                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/auth/addTopo" tabindex="-1" aria-disabled="true">Ajouter un topo</a>
            </div>
        </div>
    </body>
</html>
