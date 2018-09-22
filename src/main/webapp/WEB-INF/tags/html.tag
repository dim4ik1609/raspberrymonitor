<%@ tag pageEncoding="UTF-8" %>
<%@ attribute name="title" required="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="ui" %>
<html>

<head>

    <c:url value="Unknown" var="deftitle"/>
    <c:choose>
        <c:when test="${not empty title}">
            <title>${title}</title>
        </c:when>
        <c:when test="${empty title}">
            <title>${deftitle}</title>
        </c:when>
        <c:otherwise/>
    </c:choose>
    <meta charset="utf-8">
    <c:url var="icon" value="/static/images/raspicon.ico"/>
    <link rel="icon" href="${icon}">

    <!--=======CSS=======-->
    <c:url var="url" value="/static/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${url}"/>

</head>
<body>
<!--======JS=======-->
<c:url var="url" value="/static/js/jquery-3.3.1.min.js"/>
<script src="${url}"></script>
<c:url var="url" value="/static/js/popper.min.js"/>
<script src="${url}"></script>
<c:url var="url" value="/static/js/bootstrap.min.js"/>
<script src="${url}"></script>

    <div class="container">
        <ui:navbar/>
    </div>
    <!--======CODEOFPAGE=======-->
    <div class="container">
        <jsp:doBody/>
    </div>

</body>
</html>
