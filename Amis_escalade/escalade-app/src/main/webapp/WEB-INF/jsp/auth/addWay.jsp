<%--
  Created by IntelliJ IDEA.
  User: lam99
  Date: 10/12/2019
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html lang="en">
<head>
    <title>Ajouter une voie</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
    <body>
        <jsp:include page="/WEB-INF/jsp/templates/header.jsp"/>

        <div class="outer-div">

            <div class="col-sm-10" style="margin:0 auto;">
                <br/><div class="text-center"><h3 class="card-title">Secteur - <c:out value="${sector.name}"></c:out></h3></div><br/>
            </div>

            <form method="post" action="${pageContext.request.contextPath}/auth/addWay">

                <div class= "col-sm-4" style="margin:0 auto;">
                    <p class="text-center"> Ajouter une nouvelle voie</p><br/>
                    <div class="form-group">
                        <label for="wayName">Nom de la voie</label>
                        <input type="text" name="wayName" class="form-control" id="wayName">
                    </div>

                    <div class="form-group">
                        <label for="length">Longeur</label>
                        <input type="number" name="length" class="form-control" id="length">
                    </div>

                    <div class="form-group">
                        <label for="rating">Cotation</label>
                        <select class="form-control" id="rating" name="rating" >
                            <option value=""> -- Choisissez une cotation --  </option>
                            <c:forEach items="${ratings}" var="rating">
                                <option value="${rating}"> ${rating}  </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-sm-4" style="margin:0 auto;">
                    <div style="float:left">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/showSector?id=${sector.id}" style="text-decoration:none;">Retour</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div style="float: right">
                        <button type="submit" name="AddWay" class="btn btn-primary">Ajouter</button>
                    </div>
                </div>
            </form>

        </div>
    </body>
</html>
