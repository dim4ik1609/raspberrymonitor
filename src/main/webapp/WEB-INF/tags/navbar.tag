<%@ tag pageEncoding="UTF-8" %>
<%@ attribute name="title" required="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <c:url var="url" value="/"/>
        <a class="navbar-brand" href="${url}">
            <c:url var="raspicon" value="/static/images/raspicon.ico"/>
            <img src="${raspicon}" width="30" height="30" class="d-inline-block align-top" alt="">
            RaspberryMonitor
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <c:url var="url" value="/raspberry/info"/>
                <a class="nav-item nav-link" href="${url}" id="raspberryinfo">Raspberry</a>
            </div>
        </div>
    </nav>

