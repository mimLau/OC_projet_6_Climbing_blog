<%--
  Created by IntelliJ IDEA.
  User: lam99
  Date: 24/12/2019
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<html>
    <head>
        <title>Ajouter un topo</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    </head>
    <body>
    <jsp:include page="/WEB-INF/jsp/templates/header.jsp"/>
    <form method="post" action="${pageContext.request.contextPath}/auth/addTopo">
        <div class="form-group">
            <label for="topoName">Nom du topo</label>
            <input type="text" name="topoName" class="form-control" id="topoName">
            <label for="topoDesc">Description</label>
            <textarea type="text" name="topoDesc" class="form-control" id="topoDesc"></textarea>
            <label for="topoDate">Date de parution</label>
            <input type="date" name="topoDate" class="form-control" id="topoDate">

        </div>

        <button type="submit" name="AddTopo" class="btn btn-primary">Ajouter le topo</button>
    </form>

</html>
