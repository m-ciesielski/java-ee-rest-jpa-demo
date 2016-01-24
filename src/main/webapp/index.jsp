<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JEE Demo</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
  <!-- Static navbar -->
        <nav class="navbar navbar-inverse">
          <div class="container-fluid">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">java_ee_demo</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="inactive"><a href="${pageContext.request.contextPath}/drivers.xhtml">Kierowcy</a></li>
                <li class="inactive"><a href="${pageContext.request.contextPath}/vehicles.xhtml">Pojazdy</a></li>
              </ul>
            </div><!--/.nav-collapse -->
          </div><!--/.container-fluid -->
        </nav>
        <a type="button" class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/drivers.jsp">Kierowcy</a>
        <a type="button" class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/vehicles.jsp">Pojazdy</a>
</body>
</html>