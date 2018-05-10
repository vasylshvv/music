<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>type instruments</title>
	<meta charset="UTF-8">

	<script type="text/javascript"></script>
	<script src="jquery/jquery-1.12.0.min.js"></script>

	
</head>
<body>
	<h2>Add new type musical instruments</h2>
	<form action="type.html" method="post">
		<label>name type</label>
		<input type="text" name="type">
		<br>
		<input type="submit" name="save" value="save">
	</form>
<p><b>list type instruments</b></p>
		<table border="1">
		<tr id='trhead'>
		<th>id</th>
		<th>type name</th>
		</tr>
		
		<c:forEach items="${listtype}" var="listtype">
		<tr>
		
			<td class="tool-item" data-tooltip="id=<c:out value="${listtype.id}"/> column: id"><input type="text" value="<c:out value="${listtype.id}"/>" name="id"></td>
			<td class="tool-item" data-tooltip="id=<c:out value="${listtype.id}"/> column: nameType"><input type="text" value="<c:out value="${listtype.nameType}"/>" name="nameType"></td>
		
		</tr>	
		</c:forEach>
		
	</table>
	<a href="index.html">Previous</a>
</body>
</html>