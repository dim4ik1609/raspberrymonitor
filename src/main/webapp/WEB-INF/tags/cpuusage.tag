<%@ tag pageEncoding="UTF-8" %>
<%@ attribute name="title" required="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<div class="card shadow">
    <div class="card-body">
        <div class="text-center">
            <h4>Использование CPU</h4>
        </div>
        <c:url var="img" value="/static/images/cpu-processor.png"/>
        <div class="text-center">
            <img class="h-25" src="${img}">
        </div>
        <div id="cpuusagevalue" class="text-center">0%</div>
        <div class="progress mt-2">
            <div id="cpuusage" class="progress-bar" role="progressbar" style="width: 0%;" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"></div>
        </div>
        <div class="text-center">
            <div class="btn-group mt-2" role="group">
                <button id="btnCpuStart" type="button" class="btn btn-success">Start</button>
                <button id="btnCpuStop" type="button" class="btn btn-danger">Stop</button>
                <button id="btnCpuUpd" type="button" class="btn btn-warning">Refresh</button>
            </div>
        </div>
    </div>
</div>