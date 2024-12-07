<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="ru.kpfu.itis.oris.armanov.example_english.entity.TestType" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<jsp:include page="nav.jsp" flush="true" />
<body>
<div class="container">
    <div class="row">
        <c:forEach var="testType" items="${testTypeList}">
            <div class="col-sm-4">
                <div class="card border-primary mb-3" style="max-width: 25rem;">
                    <img class="card-img-top" src="${testType.getImageUrl()}" alt="Card image" width="100%" height="200">
                    <div class="card-body">
                        <h4 class="card-title"><c:out value="${testType.getName()}"/></h4>
                        <p class="card-text"><c:out value="${testType.getDescription()}"/></p>
                        <form action="${pageContext.request.contextPath}/test" method="GET">
                            <div class="form-group">
                                <input type="hidden" class="form-control" name="testTypeId" value="${testType.gettestTypeId()}">
                            </div>
                            <div class="form-group">
                                <input type="hidden" class="form-control" name="page" value="1">
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-block">Start Test</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
