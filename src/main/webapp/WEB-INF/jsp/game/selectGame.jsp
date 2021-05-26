<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-12 text-left">
    <form action="/game/addRound" method="post" class="form-inline">
        <select id="choice" name="choice" class="form-control" aria-describedby="button-addon2" style="margin-right: 10px; padding-left: 25px; padding-right: 25px" />
            <c:forEach items="${choices}" var="choise">
                <option value="${choise}"><c:out value="${choise}"/></option>
            </c:forEach>
        </select>
        <div class="input-group-append">
            <button class="btn btn-outline-primary handleButton" type="submit" id="button-addon2">Handle</button>
            <button class="btn btn-outline-secondary handleButton"
                    type="button" id="button-addon2"
                    onclick="location.href ='/index'">Clear</button>
        </div>
    </form>
</div>
<c:if test="${not empty gameRound}">
    <div class="col-md-12 text-left result">
        <strong>NPC Choice: </strong>${gameRound.npcChoice}
    </div>
    <div class="col-md-12 text-left result">
        <strong>Winner: </strong>
        <span class="winner-${gameRound.winner}">${gameRound.winner}</span>
        <c:if test="${gameRound.winner == 'DRAW'}">
            <span> (PLAY AGAIN)
        </c:if>
    </div>
</c:if>