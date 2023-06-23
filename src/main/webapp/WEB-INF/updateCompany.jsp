<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "com.sistemi.informativi.dto.CompanyDTO"; %>
    <% CompanyDTO companyDTO = (CompanyDTO) session.getAttribute("companyDTO");%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Company</title>
</head>
<body>
<form action="update" method="post">
<label for="vatNumber">Vat Number</label><input type ="text" name="vatNumber" value="<%=companyDTO.getVatNumber()%> "readonly/><br/><br/>
<label for="businessName">Business Name</label><input type ="text" name="businessName" value="<%=companyDTO.getBusinessName()%> " /><br/><br/>
<label for="adressLocation">Address Location</label><input type ="text" name="addressLocation" value="<%=companyDTO.getAddressLocation()%> "/><br/><br/>
<label for="employeesNumber">Employees Number</label><input type ="text" name="employeesNumber" value="<%=companyDTO.getEmployeesNumber()%> "/>
<input type="submit" value="Update">
</form>
</body>
</html>