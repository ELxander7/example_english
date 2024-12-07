<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="ru.kpfu.itis.oris.armanov.example_english.entity.TestType" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: clark
  Date: 4/20/2021
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page buffer="none" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<jsp:include page="../nav.jsp" flush="true" />
<body>

<c:set var="p" value="${page}" scope="session"/>
<c:set var="ts" value="${test}" scope="session"/>
<div class="container">

    <form action="${pageContext.request.contextPath}/test" method="POST">
        <fieldset id="${ts.questions[p-1].questionId}">
            <legend> Question: ${ts.questions[p-1].description}</legend><br>
            <c:forEach var="j" begin="0" end="3">
                <c:set var="tsSelected" scope="session" value="${ts.questions[p-1].isSelected}"/>
                <input type="radio" id="${ts.questions[p-1].choices[j].choiceId}" name="${ts.questions[p-1].questionId}" value="${ts.questions[p-1].choices[j].choiceId}">
                <label for="${ts.questions[p-1].choices[j].choiceId}"><c:out value="${ts.questions[p-1].choices[j].description}"></c:out></label>
                <c:out value="${ts.questions[p-1].choices[j].choiceId}"></c:out>
                <br>
            </c:forEach>
            <c:if test="${p > 1}">
                <c:out value="${ts.questions[p-1].questionId}"></c:out>
                <a href="${pageContext.request.contextPath}/test?testTypeId=${ts.testType.testTypeId}&page=${p - 1}&choiceId=${ts.questions[p-1].questionId}">Before</a>
                <c:set var="p" value="${page - 1}" scope="session"/>
            </c:if>
            <c:if test="${p < 9}">
                <a href="${pageContext.request.contextPath}/test?testTypeId=${ts.testType.testTypeId}&page=${page + 1}&choiceId=${ts.questions[p-1].questionId}">Next</a>
                <c:set var="p" value="${page + 1}" scope="session"/>
            </c:if>
            <c:if test="${p == 9}">
                <a href="">Submit</a>
                <c:set var="p" value="${page}" scope="session"/>
            </c:if>
        </fieldset>
    </form>
</div>


</body>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<script>
    function updateChoiceSelection(elmnt,questionId, chId, index) {
        console.log(name);
        console.log("${ts}");
        console.log("${ts.questions.stream().filter(question -> questi)}");


    }

    function getJSessionId(){
        var jsId = document.cookie.match(/JSESSIONID=[^;]+/);
        if(jsId != null) {
            if (jsId instanceof Array)
                jsId = jsId[0].substring(11);
            else
                jsId = jsId.substring(11);
        }
        return jsId;
    }
    var allcookies = document.cookie;
    document.write ("All Cookies : " + allcookies );
    console.log(document.cookie.match(/JSESSIONID=[^;]+/));
</script>
</html>