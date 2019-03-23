<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>getting books back page</title>
</head>
<body>
	<form action="./getserv" method="post">
		<table>
			 <tr>
				<td>Book1 Id : </td>
				<td><input type="text" name="bid" required="required"></td> 
			</tr>
			
			<tr>
				<td>Book2 Id : </td>
				<td><input type="text" name="bid"></td> 
			</tr>
			
			<tr>
				<td>Customer Id : </td>
				<td><input type="text" name="cid" required="required"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="get book"></td>
			</tr>
		</table>
	</form>
	
	<c:set var="status" value='${requestScope.status}'></c:set>
	<c:if test='${status == 0 }'>
		<h2 style="color:red">transaction failed...</h2>
	</c:if>
	
	<c:if test='${status == 1 }'>
		<h2 style="color:green">transaction success</h2>
		<h2 style="color:green">details updated successfully</h2>
	</c:if>
</body>
</html>