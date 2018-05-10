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

	<title>List music instruments</title>
	<meta charset="UTF-8">
	<script type="text/javascript"></script>

	<script src="jquery/jquery-1.12.0.min.js" type="text/javascript"></script>
	<script src="jquery/jquery.maskedinput.js" type="text/javascript"></script>
	<script>
	$(document).ready(function(){
		$(".update").click(function(){
			var id = $(this).val();
			
			
			var price = $(this).closest('tr').find("input[name='price']").val();
			
			var releaseYear =  $(this).closest('tr').find("input[name='releaseYear']").val();
			var nameInstruments =  $(this).closest('tr').find("input[name='nameInstruments']").val();
			var type =  $(this).closest('tr').find("select[name='type']").val();
			
			
			$.ajax({
				url: "crud.html",
				data: "update="+id+			
				"&editprice="+price+
				"&editreleaseYear="+releaseYear+
				"&editnameInstruments="+nameInstruments+
				"&edittype="+type,
				cache: false,
				success: function(xml){window.location.reload();}
			});
		});
		
		
		$("#addtype").click(function(){
			location.href = "type.html";
		});
		
		$('.delete').click(function(){
			var id = $(this).val();
		
			$.ajax({
				url: "crud.html",
				data: "delete="+id,
				cache: false,
				success: function(xml){window.location.reload();}
			});
		});
		
		
		
	});
	
	</script>
	
	
</head>
<body>
<h2>Save in DB musical instruments which bought for musical school</h2>

	<form action="crud.html" method="post" id="form" >
		<table border="1">
			<tr bordercolor="red">
				<td><label>name music instruments</label></td>
				<td><input type="text" name="newname"></td>
			</tr>
			<tr bordercolor="red">
				<td><label>price</label></td>
				<td><input type="number" name="newprice"></td>
			</tr>
			
			
			
			<tr bordercolor="red">
				<td><label>type instruments</label></td>
				<td><select id="selecttype" name="newtype">
					
						<option value="0">take type instruments</option>
						<c:forEach items="${listtype}" var="listtype">						
							<option value="${listtype.id}">
								<c:out value="${listtype.nameType}"></c:out>
							</option>						
						</c:forEach>
					</select>
					<input type="button" value="+" id="addtype">
				</td>
			</tr>
			<tr bordercolor="red">
				<td><label>year release</label></td>
				<td><input type="text" name="newyear"></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="save" name="save">
		</form>
		<p>list instruments</p>
		
		<table border="1">
		<tr id='trhead'>
		<th>name instruments</th>
		<th>type instruments</th>
		<th>price</th>
		<th>year release</th>
		<th>update</th>
		<th>delete</th>
		</tr>
		<c:forEach items="${listinstruments}" var="listinstruments">
	<tr >
	<td class="tool-item" data-tooltip="id=<c:out value="${listinstruments.id}"/> column: nameInstruments"><input type="text" value="<c:out value="${listinstruments.nameInstruments}"/>" name="nameInstruments"></td>
	<td>
			<select id="selecttype" name="type" class="typesel">
					
						<c:forEach items="${listtype}" var="listtype">
						
						
						
							 <option value="${listtype.id}" ${listinstruments.typeInstr.id eq listtype.id ? 'selected' : ''}>${listtype.nameType}</option>
								
							
													
						</c:forEach>
					</select>
		</td>
	<td class="tool-item" data-tooltip="id=<c:out value="${listinstruments.id}"/> column: price"><input type="text" value="<c:out value="${listinstruments.price}"/>" name="price"></td>
		<td class="tool-item" data-tooltip="id=<c:out value="${listinstruments.id}"/> column: releaseYear"><input type="text" value="<c:out value="${listinstruments.releaseYear}"/>" name="releaseYear"></td>	
		
			<td class="tool-item" data-tooltip="id=<c:out value="${listinstruments.id}"/>"><button value="${listinstruments.id}" class="update" name="update">update</button></td>
		
	
			<td class="tool-item" data-tooltip="id=<c:out value="${listinstruments.id}"/>"><button value="${listinstruments.id}" class="delete" name="delete">delete</button></td>
		
	</tr>
	</c:forEach>
		</table>
	
</body>
</html>
