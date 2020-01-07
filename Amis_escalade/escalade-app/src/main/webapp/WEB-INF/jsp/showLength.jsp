<%--
  Created by IntelliJ IDEA.
  User: lam99
  Date: 17/12/2019
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Longueur - </title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
    <body>
        <jsp:include page="/WEB-INF/jsp/templates/header.jsp"/>
        <div class="outer-div">
            <div class="row">
                <div class= "col-sm-10" style="margin:0 auto;">
                    <c:choose>
                        <c:when test="${length != null}">
                            <br/><div class="text-center"><h3 class="card-title">Longueur - <c:out value="${length.name}"></c:out></h3></div><br/>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item" style="list-style-type: none">Site: <c:out value="${site.name}"></c:out></li>
                                <li class="list-group-item">Secteur : <c:out value="${sector.name}"></c:out></li>
                                <li class="list-group-item">Voie : <c:out value="${way.name}"></c:out></li>
                                <li class="list-group-item" style="border-bottom: none"><h6 class="card-subtitle mb-2 text-muted">Description de la longueur :</h6><br/>
                                    <p class="text-justify">Integer malesuada elit vel massa porttitor sodales quis ut tellus. Nullam bibendum ante sed nulla iaculis rutrum. Suspendisse nec porttitor magna. In hac habitasse platea dictumst. Aenean quis lorem in orci fermentum laoreet vitae eu felis. Ut aliquet dui at quam fermentum, eget tincidunt magna sagittis. Aenean ut urna at ante viverra pulvinar. Sed luctus elit turpis, nec efficitur augue pretium a. Mauris et lacinia leo. Morbi posuere convallis leo, ornare tempor neque. Sed lobortis risus quis vehicula ultrices. Pellentesque gravida est non eros varius lobortis.</p>
                                </li><br/>
                            </ul>
                        </c:when>
                        <c:otherwise>
                            <p class="text-center">Pas de longueur enregistrée pour cette voie.</p>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-10" style="margin:0 auto;">
                    <div style="float:left">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/showWay?id=${way.id}" style="text-decoration:none;">Retour</a></li>
                            </ul>
                        </nav>
                    </div>

                </div>
            </div>

        </div>
    </body>
</html>

