<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import = "com.sistemi.informativi.dto.CompanyDTO" %>
<% CompanyDTO companyDTO = (CompanyDTO)session.getAttribute("companyDTO"); %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="update">
<label for="vatNumber">Vat Number</label><input type="text" name="vatNumber" value="<%=companyDTO.getVatNumber()%>" readonly/><br/><br/>
<label for="businessName">Business Name</label><input type="text" name="businessName" value="<%=companyDTO.getBusinessName()%>"/><br/><br/>
<label for="addressLocation">Address Location</label><input type="text" name="addressLocation" value="<%=companyDTO.getAddressLocation()%>"/><br/><br/>
<label for="employeesNumber">Employees Number</label><input type="text" name="employeesNumber"/ value="<%=companyDTO.getEmployeesNumber()%>"><br/><br/>
<input type="submit" value="Update">
</form>
</body>
</html>