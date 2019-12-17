<%--
  Created by IntelliJ IDEA.
  User: lam99
  Date: 08/12/2019
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Liste des sites</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/templates/header.jsp"/>
    <br/>
    <div>
        <p class="text-center">Découvrez les différents sites d'escalade répertoriés sur notre site!</p><br/>
    </div>
    <div>
        <table class="table table-hover">
            <tr>
                <th>Nom du site</th>
                <th>Nombre de secteurs</th>
                <th>Créé par</th>
                <th></th>
            </tr>
            <c:forEach items="${sites}" var="site">
            <tr>
               <td><a style="text-decoration: none" href="${pageContext.request.contextPath}/showSite?id=${site.id}"> <c:out value="${site.name}"/></a></td>
               <td> <c:out value="${site.nbOfSectors}"></c:out></td>
               <td><c:out value="${site.siteOwner.username}"/></td>
               <td>
                   <c:choose>
                       <c:when test="${site.tagged}"> Site officiel: Les amis de l'escalade</c:when>
                       <c:otherwise>
                           <c:if test="${sessionScope.user.role == 'MEMBRE' || sessionScope.user.role == 'ADMIN'}">
                               <a href="${pageContext.request.contextPath}/auth/addTag?id=${site.id}">Tagguer le site</a>
                           </c:if>
                       </c:otherwise>
                   </c:choose>
               </td>
            </tr>
            </c:forEach>
        </table>
    </div>
    <div>
        <c:if test="${sessionScope.user.username != null}">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/auth/addSite" tabindex="-1" aria-disabled="true">Ajouter un nouveau site</a>
        </c:if>
    </div>
</body>
</html>
