<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>for adding new books to the library</title>
<style>
div {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}
</style>
</head>
<body>

	<div>
		<form method="post" action="./addbook">
			<h1>
				<table>

					<tr>
						<td>Book id :</td>
						<td><input type="text" name="bid"></td>
					</tr>
					<tr>
						<td>Book name :</td>
						<td><input type="text" name="bname"></td>
					</tr>
					<tr>
						<td>Author :</td>
						<td><input type="text" name="author"></td>
					</tr>

					<tr>
						<td>Book cost :</td>
						<td><input type="number" name="cost"></td>
					</tr>
					<tr>
						<td><input type="submit" name="add new book"></td>
					</tr>
				</table>
			</h1>
		</form>
	</div>
	
	<c:set var="status" value='${requestScope.status}'></c:set>
	<c:if test='${0 == status}'>
		<h2 style="color:red;">adding books operation failed, try again...</h2>
	</c:if>
	
	<c:if test='${1 == status}'>
		<h2 style="color:green;">adding books operation success</h2>
	</c:if>
	
	<c:if test='${2 == status}'>
		<h2 style="color:red;">alredy existed..</h2>
	</c:if>
</body>
</html>