<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:wrapper title="Início">
<b>Imóveis:</b>
<ul class="list-unstyled">
	<li>Página Inicial</li>
</ul>

<c:choose>
  	<c:when test="${empty imovelList}">VAZIO</c:when>
  	<c:otherwise>
  		<table class="table table-striped">
	  		<tr>
		      	<th>ID</th>
		      	<th>TIPO</th>
		      	<th>VALOR</th>
		      	<th>EDITAR</th>
		      	<th>REMOVER</th>
		    </tr>
		  	<c:forEach var="imovel" items="${imovelList}">
				<tr>
					<td><c:out value="${imovel.idimovel}" /></td>
					<td><c:out value="${imovel.tipo}" /></td>
					<td><c:out value="${imovel.valor}" /></td>
					<td>
			          	<a href="${pageContext.request.contextPath}/editImovel?code=${imovel.idimovel}">Editar</a>
			        </td>
			        <td>
			          	<a href="${pageContext.request.contextPath}/deleteImovel?code=${imovel.idimovel}">Excluir</a>
			        </td>
				</tr>
			</c:forEach>
  	</c:otherwise>
</c:choose>

<a class="btn btn-primary" role="button" href="createProduct">Create Imóvel</a>
</t:wrapper>