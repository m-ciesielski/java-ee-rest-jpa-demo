<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Kierowcy</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- bootbox.js at 4.4.0 -->
<script
	src="https://rawgit.com/makeusabrew/bootbox/f3a04a57877cab071738de558581fbc91812dce9/bootbox.js"></script>

<script src="<%= request.getContextPath() %>/js/utils.js"></script>
<script src="<%= request.getContextPath() %>/js/address.js"></script>
<script src="<%= request.getContextPath() %>/js/driver.js"></script>

<script type="text/javascript">

        $(document).ready(function(){
                   	var ctx = "${pageContext.request.contextPath}";
                       generateDriversTable(ctx);
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
				<a class="navbar-brand" href="${pageContext.request.contextPath}/index.xhtml">java_ee_demo</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="<%= request.getContextPath() %>/drivers.xhtml">Kierowcy</a></li>
					<li class="inactive"><a href="<%= request.getContextPath() %>/vehicles.xhtml">Pojazdy</a></li>
					<li class="inactive"><a href="<%= request.getContextPath() %>/clients.xhtml">Klienci</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid -->
	</nav>

	<a href="${pageContext.request.contextPath}/drivers/add" class="btn btn-success">Dodaj kierowcę</a>

	<table class="table table-hover" id="drivers_table">
		<thead>
			<tr>
				<td>ID</td>
				<td>Imie</td>
				<td>Nazwisko</td>
				<td>PESEL</td>
				<td>Pensja</td>
				<td>Premia</td>
				<td>Adres</td>
				<td>Szczegóły</td>
				<td>Edycja</td>
				<td>Usuwanie</td>
			</tr>
		</thead>
	</table>
</body>
</html>
