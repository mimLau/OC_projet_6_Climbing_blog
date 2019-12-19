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
        <div>
            <div class="text-center"><h3 class="card-title">COMMENTAIRES</h3></div><br/>
            <c:if test="${! empty site.comments}">
                    <c:forEach items="${site.comments}" var="comment">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item"><c:out value="${comment.commentOwner.username}"/></li>
                            <li class="list-group-item"><c:out value="${comment.date}"/></li>
                            <li class="list-group-item"><c:out value="${comment.contents}"/></li>
                        </ul>
                    </c:forEach>
            </c:if>
        </div>
        <c:if test="${sessionScope.user.username != null}">
            <div class="text-center"><h3 class="card-title">Laisser un commentaire</h3></div>
            <form method="post" action="${pageContext.request.contextPath}/showSite">
                <textarea name="comment_contents" cols="100" rows="5" placeholder="Votre commentaire" aria-required="true"></textarea>
                <div class="form-group">
                    <input name="submit" type="submit" id="submit" class="submit" class="btn btn-primary" value="Publier">
                </div>
            </form>
        </c:if>


        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    </body>
</html>
