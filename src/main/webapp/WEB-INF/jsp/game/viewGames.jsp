<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<table class="table table-striped" style="font-size: 13px;">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Player</th>
      <th scope="col">Date</th>
      <th scope="col">Winner</th>
      <th scope="col">Player Wins</th>
      <th scope="col">NPC Wins</th>
    </tr>
  </thead>
  <tbody>
    <c:if test="${not empty games}">
        <c:forEach items="${games}" var="game">
            <tr>
                <th scope="row">${game.id}</th>
                <td>${game.playerName}</td>
                <td>${game.date}</td>
                <td>${game.winner}</td>
                <td>${game.playerWins}</td>
                <td>${game.npcWins}</td>
            </tr>
        </c:forEach>
    </c:if>
  </tbody>
</table>
</div>