<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page for admin</title>
</head>
<body>
	<form  action="./login">
		<table>
			<tr>
				<td>user name : </td>
				<td>
					<input type="text" name="name" value="admin">
				</td>
			</tr>
			<tr>
				<td>password : </td>
				<td>
					<input type="password" name="password" value="admin">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="submit">
				</td>
			</tr>
		</table>
	</form>
	<c:set var="status" value='${requestScope.status}'></c:set>
	<c:if test='${0 == status }' var="x">
		<h2>login failed.. try agin</h2>
	</c:if>
</body>
</html>