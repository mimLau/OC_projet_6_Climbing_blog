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
             style="width:650px;height:70px;text-align:center;margin: 0 auto;">

            <form method="post" action="${pageContext.request.contextPath}/listSites">
              <div class="outer-div" style="width:600px;text-align: center; padding-bottom: 5px;padding-top: 5px; background-color: rgba(204, 204, 204, 0.7);opacity: 0.7;">
                  <div class="form-row inner-div" style="width:550px; margin: 0 auto;padding:2px 2px 2px 2px;">
                    <div style="width:120px;">
                        <label for="region" style="height:15px;font-size:10px;width:115px;margin-bottom: 1px;">Lieu</label>
                        <select id="region" name="region" class="form-control selection" style="height:28px;font-size:10px;width:115px;position: absolute;" onchange="this.form.submit();" ${chosen_place == region? 'selected':''}>
                            <option disabled selected value></option>
                            <c:forEach items="${countryRegions}" var="countryRegion">
                                <optgroup label="${countryRegion.key}">
                                    <c:forEach items="${countryRegion.value}" var="item" varStatus="loop">
                                        <option  value="${item}" ${chosen_region == item? 'selected':''}>${item}</option>
                                    </c:forEach><br>
                                </optgroup>
                            </c:forEach>
                        </select>
                    </div>

                    <div style="width:120px">
                        <label for="official" style="height:15px;font-size:10px;width:115px;margin-bottom: 1px;">Taggué</label>
                        <select id="official" name="official" class="form-control selection" style="height:28px;font-size:10px;width:115px" onchange="this.form.submit();" ${chosen_tag == official.value ? 'selected':''}>
                            <option disabled selected value></option>
                            <c:forEach items="${tags}" var="tag">
                                <option value="${tag.value}" style="height:28px;font-size:10px;" ${chosen_tag == tag.value ? 'selected':''}> ${tag.key}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div style="width:120px">
                        <label for="sectorsNb" style="height:15px;font-size:10px;width:115px;margin-bottom: 1px;">Nombre de secteurs</label>
                        <select id="sectorsNb" name="sectorsNb" class="form-control selection" style="height:28px;font-size:10px;width:115px;" onchange="this.form.submit();">
                            <option disabled selected value></option>
                            <c:forEach var="i" begin="0" end="${nbSectorMax}">
                                <option  value="${ i }" ${chosen_sectorNb == i ? 'selected':''}> <c:out value="${ i }"/> </option>
                            </c:forEach>
                        </select>
                    </div>

                      <div style="width:120px">
                          <label for="rating" style="height:15px;font-size:10px;width:115px;margin-bottom: 1px;">Cotation</label>
                          <select class="form-control selection" id="rating" name="rating" style="height:28px;font-size:10px;width:115px;" onchange="this.form.submit();">
                              <option disabled selected value></option>
                              <c:forEach items="${ratings}" var="rating">
                                  <option value="${rating}" style="height:28px;font-size:10px;" ${chosen_rating == rating ? 'selected':''}> ${rating}</option>
                              </c:forEach>
                          </select>
                      </div>

                      <div style="width:50px;">
                          <label style="height:15px;font-size:10px;width:100px;margin: 0 auto;"></label>
                          <button type="button" class="btn btn-secondary btn-sm" style="height:28px;font-size:10px;width:70px;"><a href="${pageContext.request.contextPath}/listSites" style="text-decoration: none; color:white">Réinitialiser</a></button>
                      </div>

                  </div>
              </div>
            </form>

            <c:if test="${!empty sites && list == false}">
                <c:choose>
                    <c:when test="${fn:length(sites) gt 1}">
                        Il y a ${fn:length(sites)} résultats.
                    </c:when>
                    <c:otherwise>
                        Il y a ${fn:length(sites)} résultat.
                    </c:otherwise>
                </c:choose>

            </c:if>
        </div> <br/>

        <br/>
        <div class="list-searched-sites">
            <c:if test="${list == true}">
                <div>
                    <p class="text-center">Découvrez les différents sites d'escalade répertoriés sur notre blog!</p><br/>
                </div>
            </c:if>
            <div class="outer-div">
                <div class= "col-sm-10" style="margin:0 auto;">
                    <c:choose>
                        <c:when test="${!empty sites}">
                            <table class="table table-hover" style="border: 1px solid #DDD;">
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
                            <p class="text-center">Il n'y a aucun résultat à votre recherche.</p>
                        </c:otherwise>
                    </c:choose>
                </div>
                <c:if test="${list == true}">
                    <div class= "col-sm-10" style="margin:0 auto;">
                        <c:if test="${sessionScope.user.username != null}">
                            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/auth/addSite" tabindex="-1" aria-disabled="true">Ajouter un nouveau site</a>
                        </c:if>
                    </div>
                </c:if>
            </div>

            <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    </body>
</html>
