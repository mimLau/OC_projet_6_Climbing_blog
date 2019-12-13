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
    <h2><c:out value="${site.name}"></c:out></h2><br/>
    <div><c:out value="${site.description}"></c:out></div><br/>

    <div>
        <c:if test="${site.sectors != null}">
          <c:forEach items="${site.sectors}" var="sector">
              <a href="${pageContext.request.contextPath}/showSector?id=${sector.id}"><c:out value="${sector.name}"/></a><br/>
          </c:forEach>
        </c:if>
    </div>

    <div>
        <c:if test="${sessionScope.user.username != null}">
            <a href="${pageContext.request.contextPath}/auth/addSector">Ajouter un secteur</a>
        </c:if>
    </div>

</body>
</html>
