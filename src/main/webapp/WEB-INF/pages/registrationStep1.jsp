<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="webjars/bootstrap/3.3.5/css/bootstrap.min.css">

<title>Registrazione 1/3</title>
</head>
<jsp:include page="partial/header.jsp"/>

<body>
<jsp:include page="partial/userLog.jsp"/>

<h2>Registrazione nuovo utente: step 1</h2>
<form action="registrationStep1" method ="post">
<div>
 <label for="idnome">  Nome: </label>
  <input type="text" id ="idnome" name="variabileNome" value="nome">
  </div>
   <div>
  <label for="idcognome">  Cognome: </label>
  <input type="text" id ="idcognome" name="variabileCognome" value="cognome">
 </div>
 <div>
    <div>
  <label for="idcf">  Codice fiscale: </label>
  <input type="text" id ="idcf" name="variabileCf" value="cf">
 </div>
 <div>
 <label for="idSubmit">Avanti</label>
  <input id ="idSubmit" type="submit" value="Invia">
</div>
</form> 
</body>
<jsp:include page="partial/footer.jsp"/>

</html>