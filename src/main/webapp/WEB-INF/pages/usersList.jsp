<%@page import="it.cb.biblioteca.dto.UtenteDto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String path = request.getContextPath();%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/common.css"/>
 <link rel="stylesheet" href="webjars/bootstrap/3.3.5/css/bootstrap.min.css">


<title>lista Utenti</title>
</head>
<jsp:include page="partial/header.jsp"/>

<body class="body-content">
<jsp:include page="partial/userLog.jsp"/>


					<div class="user-table-container">
							<table class="user-table">
								<thead> 
									<p>Elenco Utenti Biblioteca </p>
									<tr  class="user-table-header" >
										<th>Username</th>
										<th>Password</th>
									</tr>
								</thead>
								<tbody>
									
								   <c:forEach items='${usersList}' var="current">
										<tr>
											<td>											
														<c:out value="${current.username}" />

											</td>
											<td><c:out value="${current.password}" /></td>
										</tr>			
									</c:forEach>	
									
								</tbody>
							</table>
					</div>

</body>
<jsp:include page="partial/footer.jsp"/>

</html>