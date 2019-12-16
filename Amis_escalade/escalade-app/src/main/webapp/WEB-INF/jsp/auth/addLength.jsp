<%--
  Created by IntelliJ IDEA.
  User: lam99
  Date: 14/12/2019
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html lang="en">
<head>
    <title>Ajouter un site d'escalade</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
    <body>
        <jsp:include page="/WEB-INF/jsp/templates/header.jsp"/>
        <form method="post" action="${pageContext.request.contextPath}/auth/addLength">

            <div class="form-group">
                <label for="lengthName">Nom de la longueur</label>
                <input type="text" name="lengthName" class="form-control" id="lengthName">
            </div>
            <div class="form-group">
                <label for="lengthLength">Longeur</label>
                <input type="number" name="lengthLength" class="form-control" id="lengthLength">
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



            <button type="submit" name="AddLength" class="btn btn-primary">Ajouter la longeur</button>
        </form>
    </body>
</html>