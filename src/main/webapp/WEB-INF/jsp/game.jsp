<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="shared/header.jsp" %>
<div class="container">
    <div class="row">
        <c:if test="${empty game}">
            <%@include file="shared/newGame.jsp" %>
        </c:if>
        <c:if test="${not empty game}">
            <%@include file="game/roundGame.jsp" %>
            <%@include file="game/gameRounds.jsp" %>
        </c:if>
    </div>
</div>
<%@include file="shared/footer.jsp" %>