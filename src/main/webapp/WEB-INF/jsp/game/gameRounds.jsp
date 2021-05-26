<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-6">
    <div class="row">
        <div class="col-md-12 text-left">
            <div><strong>Round Results</strong></div>
        </div>
    </div>
    <div class="row" style="margin-top: ${marginDiv}px">
        <div class="col-md-12 text-left">
            <c:forEach items="${game.rounds}" var="round" varStatus="loop">
                <div class="col-md-6 card roundBox">
                    <div class="card-body">
                        <div class="col-md-12 text-left"><strong>Round: </strong>${loop.index + 1}</div>
                        <div class="col-md-12 text-left"><strong>Player Choice: </strong>${round.playerChoice}</div>
                        <div class="col-md-12 text-left"><strong>NPC Choice: </strong>${round.npcChoice}</div>
                        <div class="col-md-12 text-left">
                            <strong>Winner: </strong>
                            <span class="winner-${round.winner}">${round.winner}</span>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>