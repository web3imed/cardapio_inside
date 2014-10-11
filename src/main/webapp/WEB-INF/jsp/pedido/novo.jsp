<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Novo Pedido</title>
	</head>
	<body>
  		<table style="border: 1px solid black; border-collapse: collapse; padding: 5px">
			<c:forEach items="${produtos}" var="produto" >
				<c:url value="/pedido/add" var="uriAdd" />
				<form action="${uriAdd}" method="POST">
					<tr style="border: 1px solid black">
						<td>${produto.nome}</td>
						<td>R$ ${produto.valor}</td>
							<td>	
							<label for="id">Quantidade</label>
							<input type="text" name="quantidade" value="${quantidade}">
						</td>
						<td>	
							<label for="id">pedido</label>
							<input type="text" name="pedido.id" value="${pedido.id}">
						</td>				
					</tr>
					
			</c:forEach>
					<tr>
					<td>
					<input type="submit" value="Enviar">
					</td>
					</tr>
					</form>
			</table>
	</body>
</html>