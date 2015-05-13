<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="se.tacton.webshop.model.Organization"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Organizations</title>
</head>
<body>
	<table border="1">
		<%
			if (request.getAttribute("org") != null)
			{
				List<Organization> orgs = (List) request.getAttribute("org");
				boolean isLastLevel = true;
				int level = 0;
				do
				{
					isLastLevel = true;
					for (Organization org : orgs)
					{
						if (org.getLevel() == level)
						{
							isLastLevel = false;
		%>
		<tr>

			<th>Level: <%=level %></th>
			<td><%=org.getOrganization().toString()%></td>
		</tr>
		<%
			}
					}
					level++;
				}
				while (!isLastLevel);
			}
		%>
	</table>
</body>
</html>