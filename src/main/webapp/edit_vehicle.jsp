<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Edycja Pojazdu</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script src="<%= request.getContextPath() %>/js/utils.js"></script>
<script src="<%= request.getContextPath() %>/js/vehicle.js"></script>
<script type="text/javascript">

        $(document).ready(function(){
          //Append context path to all AJAX requests
          var ctx = "${pageContext.request.contextPath}";
          var url = window.location.href;
          var vehicleId = url.substr(url.lastIndexOf('/') + 1);
          fillVehicleEditForm(vehicleId, ctx);
        });


</script>
</head>

<body>

<!-- Static navbar -->
        <nav class="navbar navbar-inverse">
          <div class="container-fluid">
            <div class="navbar-header">
              <button model="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">java_ee_demo</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}/drivers.jsp">Kierowcy</a></li>
                <li class="inactive"><a href="${pageContext.request.contextPath}/vehicles.jsp">Pojazdy</a></li>
              </ul>
            </div><!--/.nav-collapse -->
          </div><!--/.container-fluid -->
        </nav>

  <form name="edit_vehicle_form" id="edit_vehicle_form" data-toggle="validator" onsubmit="return editVehicle('${pageContext.request.contextPath}');">
      <input type="hidden" path="vehicleId" id="vehicleId" name="id"/>
      <div class="form-group">
        <label for="brand">Marka:</label>
        <input type="text" class="form-control" name="brand"  path="brand" id="brand" required="true" />
      </div>
      <div class="form-group">
        <label for="model">Model:</label>
        <input type="text" class="form-control" id="model"  path="model" name="model" required="true" />
      </div>
      <div class="form-group">
        <label for="engine">Silnik:</label>
        <input type="number" class="form-control" id="engine"  path="engine" name="engine" required="true" />
      </div>
      <div class="form-group">
        <label for="vin">VIN:</label>
        <input type="text" class="form-control" minlength="17" maxlength="17" data-error="VIN musi miec dokładnie 17 znaków." id="vin" name="vin" path="vin" />
       </div>
      <div class="form-group">
        <label for="mileage">Przebieg:</label>
        <input type="number" class="form-control" id="mileage" name="mileage" path="mileage" required="true" />
      </div>
      <div class="form-group">
        <label for="horsepower">KM:</label>
        <input type="number" class="form-control" id="horsepower" name="horsepower" path="horsepower" required="true" />
      </div>
      <div class="form-group">
        <label for="productionDate">Data produkcji:</label>
        <input type="date" class="form-control" id="productionDate" name="productionDate" path="productionDate" required="true" />
      </div>
      <div class="checkbox">
        <label><input type="checkbox" checked="checked"  path="available" id="available" name="available"/>Dostepny</label>
      </div>

        <button model="submit" class="btn btn-primary">Edytuj</button>
        <a class="btn btn-warning" href="${pageContext.request.contextPath}/vehicles.jsp">Anuluj</a>
  </form>
</body>
</html>