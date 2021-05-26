<html>
    <head>
        <title>NTT Data - Sudoku Test</title>
        <link href="<c:url value="/content/main.css"/>" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="row">
            <div class="col-md-12 text-center alert alert-dark">
                <h1>Sudoku Game</h1>
            </div>
        </div>
        <div class="container">
            <c:if test="${not empty errorMessage}">
                <div class="row">
                    <div class="col-md-12 text-left">
                        <div class="alert alert-danger" role="alert">
                          <strong>ERROR: </strong>${errorMessage}
                        </div>
                    </div>
                </div>
            </c:if>
        </div>