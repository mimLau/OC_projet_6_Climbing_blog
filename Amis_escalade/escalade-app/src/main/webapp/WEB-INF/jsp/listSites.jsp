<%--
  Created by IntelliJ IDEA.
  User: lam99
  Date: 08/12/2019
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <div class="search-sites-form"
         style="width:600px;height:70px;text-align:center;margin: 0 auto;">

        <form method="post" action="${pageContext.request.contextPath}/listSites">
            <div class="outer-div" style="width:650px;text-align: center; padding-bottom: 5px;padding-top: 5px;background-color: rgba(204, 204, 204, 0.7);opacity: 0.5;">
          <div class="form-row inner-div" style="width:550px; margin: 0 auto;padding:2px 2px 2px 2px;background-color: white;">
            <div style="width:110px;">
                <label for="selectPlace" style="height:15px;font-size:10px;width:100px">Lieu</label>
                <select id="selectPlace" name="region" class="form-control" style="height:25px;font-size:10px;width:100px" val>
                    <option></option>
                    <c:forEach items="${countryRegions}" var="countryRegion">
                        <optgroup label="${countryRegion.key}">
                            <c:forEach items="${countryRegion.value}" var="item" varStatus="loop">
                                <option  value="${item}">${item}</option>
                            </c:forEach><br>
                        </optgroup>
                    </c:forEach>
                </select>
            </div>

            <div style="width:110px">
                <label for="official" style="height:15px;font-size:10px;width:100px">Site officiel</label>
                <input type="checkbox" id="official" name="official"class="form-control" style="height:15px;" >
            </div>

            <div style="width:110px">
                <label for="sectorsNb" style="height:15px;font-size:10px;width:100px">Nombre de secteurs</label>
                <input type="number" class="form-control"  id="sectorsNb" name="sectorsNb" min="0" max="15" step="1" style="height:25px;font-size:10px;width:100px">
            </div>

              <div style="width:110px">
                  <label for="rating" style="height:15px;font-size:10px;width:100px">Cotation</label>
                  <select class="form-control" id="rating" name="rating" style="height:25px;font-size:10px;width:100px">
                      <option style="height:28px;font-size:10px;"></option>
                      <c:forEach items="${ratings}" var="rating">
                          <option value="${rating}" style="height:28px;font-size:10px;"> ${rating}</option>
                      </c:forEach>
                  </select>
              </div>

              <div style="width:75px">
                  <label style="height:15px;font-size:10px;width:100px"></label>
                  <button type="submit" class="btn btn-primary" style="height:25px;font-size:10px;width:70px">Rechercher</button>
              </div>

          </div>
            </div>
        </form>
        <c:if test="${!empty searched_sites}">
            Il y a ${fn:length(searched_sites)} résultats.
        </c:if>
    </div>

    <br/>
    <br/>
    <c:if test="${!empty searched_sites}">
        <div class="list-searched-sites">
            <div>
                <c:choose>
                    <c:when test="${!empty searched_sites}">
                        <table class="table table-hover">
                            <tr>
                                <th>Nom du site</th>
                                <th>Nombre de secteurs</th>
                                <th>Créé par</th>
                                <th></th>
                            </tr>

                            <c:forEach items="${searched_sites}" var="site">
                                <tr>
                                    <td><a style="text-decoration: none" href="${pageContext.request.contextPath}/showSite?id=${site.id}"> <c:out value="${site.name}"/></a></td>
                                    <td> <c:out value="${site.nbOfSectors}"></c:out></td>
                                    <td><c:out value="${site.siteOwner.username}"/></td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${site.tagged}">
                                                <c:choose>
                                                    <c:when test="${sessionScope.user.role == 'MEMBRE' || sessionScope.user.role == 'ADMIN'}">
                                                        <a href="${pageContext.request.contextPath}/auth/addTag?id=${site.id}&tag=false" style="text-decoration: none;" title="Cliquez pou détaguer le site">Site officiel: Les amis de l'escalade</a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        Site officiel: Les amis de l'escalade
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:when>
                                            <c:otherwise>
                                                <c:if test="${sessionScope.user.role == 'MEMBRE' || sessionScope.user.role == 'ADMIN'}">
                                                    <a href="${pageContext.request.contextPath}/auth/addTag?id=${site.id}&tag=true" style="text-decoration: none;" title="Cliquez pour taguer le site.">Tagguer le site</a>
                                                </c:if>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:when>
                    <c:otherwise>
                        Il n'y a aucun résultat à votre recherche.
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </c:if>

    <c:if test="${! empty all_sites}">
        <div class="list-all-sites">
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
                    <c:forEach items="${all_sites}" var="site">
                    <tr>
                       <td><a style="text-decoration: none" href="${pageContext.request.contextPath}/showSite?id=${site.id}"> <c:out value="${site.name}"/></a></td>
                       <td> <c:out value="${site.nbOfSectors}"></c:out></td>
                       <td><c:out value="${site.siteOwner.username}"/></td>
                       <td>
                           <c:choose>
                               <c:when test="${site.tagged}">
                                   <c:choose>
                                       <c:when test="${sessionScope.user.role == 'MEMBRE' || sessionScope.user.role == 'ADMIN'}">
                                           <a href="${pageContext.request.contextPath}/auth/addTag?id=${site.id}&tag=false" style="text-decoration: none;" title="Cliquez pou détaguer le site">Site officiel: Les amis de l'escalade</a>
                                       </c:when>
                                       <c:otherwise>
                                           Site officiel: Les amis de l'escalade
                                       </c:otherwise>
                                   </c:choose>
                               </c:when>
                               <c:otherwise>
                                   <c:if test="${sessionScope.user.role == 'MEMBRE' || sessionScope.user.role == 'ADMIN'}">
                                       <a href="${pageContext.request.contextPath}/auth/addTag?id=${site.id}&tag=true" style="text-decoration: none;" title="Cliquez pour taguer le site.">Tagguer le site</a>
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
        </div>
    </c:if>
</body>
</html>
