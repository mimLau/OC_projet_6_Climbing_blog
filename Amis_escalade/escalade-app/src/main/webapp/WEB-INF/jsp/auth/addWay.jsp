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

        <form method="post" action="${pageContext.request.contextPath}/auth/addSector">
            <h1><c:out value="${site.name}"/></h1><br/>
            <h2><c:out value="${sector.name}"/></h2><br/>

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

            <button type="submit" name="AddWay" class="btn btn-primary">Ajouter la voie</button>
        </form>
</body>
</html>
