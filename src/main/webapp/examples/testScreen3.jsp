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
            <c:set var="tsSelected" scope="session" value="${ts.questions[p-1].isSelected}"/>
            <input type="radio" id="${ts.questions[p-1].choices[j].choiceId}" name="${ts.questions[p-1].questionId}" value="${ts.questions[p-1].choices[0].choiceId}">
            <label for="${ts.questions[p-1].choices[0].choiceId}"><c:out value="${ts.questions[p-1].choices[0].description}"></c:out></label>
            <c:out value="${ts.questions[p-1].choices[0].choiceId}"></c:out>
            <br>
            <input type="radio" id="${ts.questions[p-1].choices[j].choiceId}" name="${ts.questions[p-1].questionId}" value="${ts.questions[p-1].choices[1].choiceId}">
            <label for="${ts.questions[p-1].choices[1].choiceId}"><c:out value="${ts.questions[p-1].choices[1].description}"></c:out></label>
            <c:out value="${qz.questions[p-1].choices[1].choiceId}"></c:out>
            <br>
            <input type="radio" id="${ts.questions[p-1].choices[j].choiceId}" name="${ts.questions[p-1].questionId}" value="${ts.questions[p-1].choices[2].choiceId}">
            <label for="${ts.questions[p-1].choices[2].choiceId}"><c:out value="${ts.questions[p-1].choices[2].description}"></c:out></label>
            <c:out value="${ts.questions[p-1].choices[2].choiceId}"></c:out>
            <br>
            <input type="radio" id="${ts.questions[p-1].choices[j].choiceId}" name="${ts.questions[p-1].questionId}" value="${ts.questions[p-1].choices[3].choiceId}">
            <label for="${ts.questions[p-1].choices[j].choiceId}"><c:out value="${ts.questions[p-1].choices[3].description}"></c:out></label>
            <c:out value="${ts.questions[p-1].choices[3].choiceId}"></c:out>
            <br>
            <c:if test="${p > 1}">
                <c:out value="${ts.questions[p-1].questionId}"></c:out>
                <a href="${pageContext.request.contextPath}/quiz?quizTypeId=${ts.testType.testTypeId}&page=${p - 1}&questionId=${ts.questions[p-1].questionId}">Before</a>
                <c:set var="p" value="${page - 1}" scope="session"/>
            </c:if>
            <c:if test="${p < 9}">
                <a href="${pageContext.request.contextPath}/test?testTypeId=${ts.testType.testTypeId}&page=${page + 1}&questionId=${ts.questions[p-1].questionId}">Next</a>
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
</html>