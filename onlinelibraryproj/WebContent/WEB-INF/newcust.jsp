<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding new customer</title>
</head>
<body>
	<form method="post" action="./addcust">
		<table>
			<tr>
				<td>Customer Id: </td>
				<td><input type="text" name= "cid"></td>
			</tr>
			
			<tr>
				<td>Customer Name : </td>
				<td><input type="text" name="cname"></td>
			</tr>
			
			<tr>
				<td>Mobile number : </td>
				<td><input type="tel" name = "mobno"></td>
			</tr>
			<tr><td><input type="submit" value="Add"></td></tr>
		</table>
	</form>
	
	
	<c:if test='${1 == status}'>
	<h2 style="color:red">Faliled customer addition action try again..</h2>
	</c:if>
	
	<c:if test='${2 == status }'>
	<h2 style="color:green">customer successfully added..</h2>
	</c:if>
	<button><a href="http://localhost:8080/onlinelibraryproj/action">back to admin page</a></button>

</body>
</html>