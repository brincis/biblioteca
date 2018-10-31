<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="webjars/bootstrap/3.3.5/css/bootstrap.min.css">
 <link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css">


<title>Login</title>
</head>
<jsp:include page="partial/header.jsp"/>

<body>
<div class="container-fluid">

<h2>Login page</h2>
<form action="login" method ="post">
<div>
 <label for="idusername">  Username: </label>
  <input type="text" id ="idusername" name="variabileUsrname" value="username">
  </div>
   <div>
  <label for="idpassword">  Password: </label>
  <input type="password" id ="idpassword" name="variabilePassword" value="password">
 </div>
 <div>
 <label for="idSubmit">Premi invia per fare login</label>
  <input id ="idSubmit" type="submit" value="Invia">
</div>
<div id="messageErr" class="errors"> ${messageErr}</div>
</form> 

</div>
</body>
<jsp:include page="partial/footer.jsp"/>

</html>