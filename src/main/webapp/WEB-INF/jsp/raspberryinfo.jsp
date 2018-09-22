<%--
  Created by IntelliJ IDEA.
  User: dima7
  Date: 11.08.2018
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ui:html title="Raspberry info">

    <div class="row">
        <div class="col-sm-12">
            <h3>Raspberry Pi 3 Model B+</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12 col-lg-4  mt-2">
            <ui:currtemp/>
        </div>
        <div class="col-sm-12 col-lg-4  mt-2">
            <ui:cpuusage/>
        </div>
        <div class="col-sm-12 col-lg-4  mt-2">
            <ui:ramusage/>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12  mt-2">
            <ui:tempstat/>
        </div>
    </div>


    <script>
        $('#raspberryinfo').addClass('active');

        function getCpuTemperature() {
            <c:url var="url_currtemp" value="/rest/v1/temperature/tempcurrent" />
            $.getJSON("${url_currtemp}", function(temp){
                $("#currtemp").css("width", temp.value + "%");//.text(temp.value + "'C");
                $("#currtempvalue").text(temp.value + "'C");
                $("#currtemp").removeClass("bg-success").removeClass("bg-warning").removeClass("bg-danger");
                if (temp.value < 50) {
                    $("#currtemp").addClass("bg-success");
                } else if (temp.value > 50 && temp.value < 70) {
                    $("#currtemp").addClass("bg-warning");
                } else {
                    $("#currtemp").addClass("bg-danger");
                }
            });
        }

        function getRamUsage() {
            <c:url var="url_currtemp" value="/rest/v1/ram/ramusage" />
            $.getJSON("${url_currtemp}", function(temp){
                $("#ramusage").css("width", temp.value + "%")//.text(temp.value + "%");
                $("#ramusagevalue").text(temp.value + "%");
                $("#ramusage").removeClass("bg-success").removeClass("bg-warning").removeClass("bg-danger");
                if (temp.value < 50) {
                    $("#ramusage").addClass("bg-success");
                } else if (temp.value > 50 && temp.value < 70) {
                    $("#ramusage").addClass("bg-warning");
                } else {
                    $("#ramusage").addClass("bg-danger");
                }
            });
        }

        function getCpuUsage() {
            <c:url var="url_currtemp" value="/rest/v1/cpu/cpuusage" />
            $.getJSON("${url_currtemp}", function(temp){
                $("#cpuusage").css("width", temp.value + "%");//.text(temp.value + "%");
                $("#cpuusagevalue").text(temp.value + "%");
                $("#cpuusage").removeClass("bg-success").removeClass("bg-warning").removeClass("bg-danger");
                if (temp.value < 50) {
                    $("#cpuusage").addClass("bg-success");
                } else if (temp.value > 50 && temp.value < 70) {
                    $("#cpuusage").addClass("bg-warning");
                } else {
                    $("#cpuusage").addClass("bg-danger");
                }
            });
        }

        var timerCpuTemp, timerCpuUsage, timerRamUsage;

        function startCpuTempMonitor() {
            clearInterval(timerCpuTemp);
            timerCpuTemp = setInterval(getCpuTemperature, 5000);
            $('#currtemp').addClass('progress-bar-striped').addClass('progress-bar-animated');
        }
        function stopCpuTempMonitor() {
            clearInterval(timerCpuTemp);
            $('#currtemp').removeClass('progress-bar-striped').removeClass('progress-bar-animated');
        }

        function startCpuUsageMonitor() {
            clearInterval(timerCpuUsage);
            timerCpuUsage = setInterval(getCpuUsage, 5000);
            $('#cpuusage').addClass('progress-bar-striped').addClass('progress-bar-animated');
        }
        function stopCpuUsageMonitor() {
            clearInterval(timerCpuUsage);
            $('#cpuusage').removeClass('progress-bar-striped').removeClass('progress-bar-animated');
        }

        function startRamUsageMonitor() {
            clearInterval(timerRamUsage);
            timerRamUsage = setInterval(getRamUsage, 5000);
            $('#ramusage').addClass('progress-bar-striped').addClass('progress-bar-animated');
        }
        function stopRamUsageMonitor() {
            clearInterval(timerRamUsage);
            $('#ramusage').removeClass('progress-bar-striped').removeClass('progress-bar-animated');
        }

        $(document).ready(function () {
            getCpuTemperature();
            startCpuTempMonitor();

            getCpuUsage();
            startCpuUsageMonitor();

            getRamUsage();
            startRamUsageMonitor();
        });

        $('#btnTempStart').click(startCpuTempMonitor);
        $('#btnTempStop').click(stopCpuTempMonitor);
        $('#btnTempUpd').click(getCpuTemperature);

        $('#btnCpuStart').click(startCpuUsageMonitor);
        $('#btnCpuStop').click(stopCpuUsageMonitor);
        $('#btnCpuUpd').click(getCpuUsage);

        $('#btnRamStart').click(startRamUsageMonitor);
        $('#btnRamStop').click(stopRamUsageMonitor);
        $('#btnRamUpd').click(getRamUsage);

    </script>
</ui:html>
