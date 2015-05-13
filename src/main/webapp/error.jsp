<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Error</title>
	</head>	
	<body>
		<%
			if (request.getAttribute("message") != null)
			{
				String message = (String)request.getAttribute("message");
			%>
			<h1><%=message%></h1>
			<%} 
			else 
			{ %>
				<h1>Unknown Error!</h1>
			<%} 
		%>
	</body>
</html>