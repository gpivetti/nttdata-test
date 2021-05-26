<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-12 text-center winner">
    <strong>WINNER: </strong>
    <span class="winner-${game.winner}">${game.winner}</span>
</div>
<%@include file="../shared/newGame.jsp" %>