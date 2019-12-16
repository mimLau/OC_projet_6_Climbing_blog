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
    <div>
        <c:if test="${sector != null}">
           <c:forEach items="${sector.ways}" var="way">
                <a href="${pageContext.request.contextPath}/showWay?id=${way.id}"><c:out value="${way.name}"/></a><br/>
           </c:forEach>
        </c:if>
    </div>
    <div>
        <c:if test="${sessionScope.user.username != null}">
            <a href="${pageContext.request.contextPath}/auth/addWay">Ajouter une voie</a>
        </c:if>
    </div>
</body>
</html>
