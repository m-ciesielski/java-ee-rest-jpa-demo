<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Edycja Kierowcy</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script src="<%= request.getContextPath() %>/js/utils.js"></script>
<script src="<%= request.getContextPath() %>/js/address.js"></script>
<script src="<%= request.getContextPath() %>/js/driver.js"></script>
<script type="text/javascript">

        $(document).ready(function(){
          //Append context path to all AJAX requests
          var ctx = "${pageContext.request.contextPath}";
          var url = window.location.href;
          var driverId = url.substr(url.lastIndexOf('/') + 1);
          fillDriverEditForm(driverId, ctx);
        });


</script>
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

  <form name="edit_driver_form" id="edit_driver_form" modelAttribute="editDriverForm" data-toggle="validator" onsubmit="return editDriver('${pageContext.request.contextPath}');">
      <input type="hidden" path="id" id="driverId" name="id"/>
      <div class="form-group">
        <label for="firstName">Imie:</label>
        <input type="text" class="form-control" minlength="2" name="firstName"  path="firstName" id="firstName"
         required="true" />
      </div>
      <div class="form-group">
        <label for="lastName">Nazwisko:</label>
        <input type="text" class="form-control" id="lastName" minlength="2"  path="lastName" name="lastName"
         required="true" />
      </div>
      <div class="form-group">
        <label for="pesel">Pesel:</label>
        <input type="text" class="form-control" id="pesel"  path="pesel" pattern="\d{11}" minlength="11" maxlength="11"
         data-error="Pesel musi miec dokładnie 11 znaków." name="pesel" required="true" />
      </div>
      <div class="form-group">
        <label for="salary">Pensja:</label>
        <div class="input-group">
            <span class="input-group-addon">zł</span>
            <input type="number" class="form-control" id="salary" name="salary"  path="salary" required="true"/>
        </div>
       </div>
      <div class="form-group">
        <label for="salaryBonus">Premia:</label>
        <div class="input-group">
            <span class="input-group-addon">zł</span>
            <input type="number" class="form-control" id="salaryBonus" name="salaryBonus"  path="salaryBonus"
             placeholder="zł" />
        </div>
      </div>
      <div class="form-group">
        <label for="addressId">Adres:</label>
        <select name="addressId" id="addressId"  path="addressId" class="form-control">
        </select>
      </div>
      <div class="checkbox">
        <label><input type="checkbox" checked="checked"  path="available" id="available" name="available"/>Dostepny</label>
      </div>
      
        <button type="submit" class="btn btn-primary">Edytuj</button>
        <a class="btn btn-warning" href="${pageContext.request.contextPath}/drivers.jsp">Anuluj</a>
  </form>
</body>
</html>