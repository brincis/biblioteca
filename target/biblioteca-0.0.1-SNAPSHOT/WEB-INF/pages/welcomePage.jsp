<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="it.cb.biblioteca.dto.UtenteDto" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="webjars/bootstrap/3.3.5/css/bootstrap.min.css">

<title>DashBoard</title>
</head>
<jsp:include page="partial/header.jsp"/>

<body>
<jsp:include page="partial/userLog.jsp"/>


<a href="gotouserList">Elenco Utenti</a>
</div>
<div>
<a href="gotoRegistrationStep1">Inserisci un nuovo utente</a>
</div>
</body>
<jsp:include page="partial/footer.jsp"/>

</html>