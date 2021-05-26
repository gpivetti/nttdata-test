<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@include file="shared/header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-12 text-center">
            <label for="name">Insert your name:
            <div class="input-group mb-3">
                <form action="/index/newGame" class="form-inline" method="post">
                  <input type="text" id="player" name="player" class="form-control" placeholder="User Name" aria-label="User Name" aria-describedby="button-addon2" />
                  <div class="input-group-append">
                    <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Start</button>
                  </div>
                </form>
            </div>
        </div>
    </div>
    <div class="row">
        <%@include file="game/viewGames.jsp" %>
    </div>
</div>
<%@include file="shared/footer.jsp" %>