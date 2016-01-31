<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Pojazdy</title>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<!-- bootbox.js at 4.4.0 -->
<script
	src="https://rawgit.com/makeusabrew/bootbox/f3a04a57877cab071738de558581fbc91812dce9/bootbox.js"></script>

<script src="<%= request.getContextPath() %>/js/utils.js"></script>
<script src="<%= request.getContextPath() %>/js/vehicle.js"></script>
<script>
  $(document).ready(function(){
          	var ctx = "${pageContext.request.contextPath}";
              generateVehiclesTable(ctx);
          });
</script>

</head>

<body>

<!-- Static navbar -->
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">java_ee_demo</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="inactive"><a href="<%= request.getContextPath() %>/drivers.jsp">Kierowcy</a></li>
					<li class="active"><a href="<%= request.getContextPath() %>/vehicles.jsp">Pojazdy</a></li>
					<li class="inactive"><a href="<%= request.getContextPath() %>/clients.jsp">Klienci</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid -->
	</nav>

  <a href="${pageContext.request.contextPath}/vehicles/add" class="btn btn-success">Dodaj pojazd</a>

  <table class="table table-hover" id="vehicles_table">
  <thead>
      <tr>
           <td>ID</td>
           <td>Marka</td>
           <td>Typ</td>
           <td>Silnik</td>
           <td>VIN</td>
           <td>KM</td>
           <td>Przebieg</td>
           <td>Edycja</td>
           <td>Usuwanie</td>
      </tr>
  </thead>
  </table>

</body>
</html>