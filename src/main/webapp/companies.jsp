<%@ page language="java" contentType="text/html;charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.sistemi.informativi.vo.CompanyVO"%>
<%@ page import="java.util.ArrayList"%>

<%@ page import="com.sistemi.informativi.key.Key" %>
<%@ page import="com.sistemi.informativi.page.Page"%>
<%
/*
recupero dell'ArrayList<CompanyVO>
salvata in sessione dalla Servlet
ViewEmployeeServlet
*/
ArrayList<CompanyVO> companies = (ArrayList<CompanyVO>) session.getAttribute(Key.companies);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Companies</title>
</head>
<body>
	<table align="center" border="1">
		<%
		for (int i = 0; i < companies.size(); i++) {
			;
		%>

		<form method="post" action="toupdate">
			<tr>

				<%
				String vatNumber = companies.get(i).getVatNumber();
				String businessName = companies.get(i).getBusinessName();
				String addressLocation = companies.get(i).getAddressLocation();
				int employeesNumber = companies.get(i).getEmployeesNumber();
				%>

				<td><input type="text" name="vatNumber" value="<%=vatNumber%>" readonly /></td>
				<td><input type="text" name="businessName"
					value="<%=businessName%>" readonly /></td>
				<td><input type="text" name="addressLocation"
					value="<%=addressLocation%>" readonly/></td>
				<td><input type="text" name="employeesNumber"
					value="<%=employeesNumber%>" readonly/></td>
				<td><a href="delete?vatNumber=<%=vatNumber%>">delete</a></td>
				<td><input type="submit" value="update"></td>
			</tr>
		</form>

		<%
		}
		;
		%>

	</table>
	<table align="center">
		<tr>
			<td><a href="<%=Page.home%>">Home</a></td>
		</tr>
	</table>
</body>
</html>