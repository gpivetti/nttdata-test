<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty game}">
    <div class="col-md-12 text-center score">
        PLAYER: <span>${game.playerWins}</span>
        <span class="versus">VS</span>
        NPC: <span>${game.npcWins}</span>
    </div>
</c:if>