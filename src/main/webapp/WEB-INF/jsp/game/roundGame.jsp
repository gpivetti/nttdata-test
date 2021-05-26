<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-6">
    <div class="row">
        <div class="col-md-12 text-left">
            <div><strong>Player Name: </strong> ${game.playerName}</div>
            <div><strong>Round Count: </strong> ${roundCount}</div>
        </div>
    </div>
    <c:set var="marginDiv" value="25"/>
    <div class="row" style="margin-top: ${marginDiv}px">
        <c:if test="${not empty game.winner}">
            <%@include file="winnerGame.jsp" %>
        </c:if>
        <c:if test="${empty game.winner}">
            <%@include file="selectGame.jsp" %>
        </c:if>
        <%@include file="gameScore.jsp" %>
    </div>
</div>