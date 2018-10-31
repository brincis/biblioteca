<%@page import="it.cb.biblioteca.dto.UtenteDto" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="webjars/bootstrap/3.3.5/css/bootstrap.min.css">

<title>Registrazione 3/3</title>
</head>
<jsp:include page="partial/header.jsp"/>

<body>
<jsp:include page="partial/userLog.jsp"/>

<form action="registrationStep2" method ="post">

<div>
 Nome: ${userInSessionToRegister.nome}
 </div>
 <div>
 Cognome: ${userInSessionToRegister.cognome}
 </div>
 <div>
CF: ${userInSessionToRegister.cf}
 </div>
 <div>
Username:  ${userInSessionToRegister.username}
 </div>
 <div>
Password: ${userInSessionToRegister.password}
 </div>
  <label for="idSubmit">Salva</label>
  <input id ="idSubmit" type="submit" value="Salva">
 </form>
</body>
<jsp:include page="partial/footer.jsp"/>

</html>