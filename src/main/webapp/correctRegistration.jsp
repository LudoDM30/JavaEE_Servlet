<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<%@ page import="com.sistemi.informativi.dto.CompanyDTO" %>
<%@ page import="com.sistemi.informativi.key.Key" %>
<% CompanyDTO companyDTO = (CompanyDTO)session.getAttribute(Key.companyDTO); %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%= "Registrazione corretta per la Company "+ companyDTO.getBusinessName() %>
</body>
</html>