<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<t:wrapper title="Listagem de Imóveis">
<div class="card">
	<div class="card-body">
		<h4 class="box-title d-flex justify-content-between">
			Imóveis cadastrados
			<a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/addImovel">+ ADICIONAR</a>
		</h4>
		<c:out value="${fn:length(imovelList)}" /> resultados.
  	</div>
	<div class="card-body">
		<c:choose>
		  	<c:when test="${empty imovelList}">VAZIO</c:when>
	  		<c:otherwise>
				<table class="table">
					<thead class="thead-light">
						<tr>
					    	<th scope="col">#</th>
					      	<th scope="col">TIPO</th>
					      	<th scope="col">LOCAL</th>
					      	<th scope="col">AÇÕES</th>
						</tr>
					</thead>
				  	<tbody>
						<c:forEach var="im" items="${imovelList}">
						<tr>
				      		<th scope="row">${im.imovel.idimovel}</th>
					      	<td>${im.imovel.tipo}</td>
					      	<td>${im.imovel.cidade}, ${im.imovel.bairro}, ${im.imovel.rua}<c:if test="${im.imovel.numero != null}">, ${im.imovel.numero}</c:if></td>
					      	<td>
					      		<button type="button" class="btn btn-primary"><i class="far fa-eye"></i></button>
		              			<button type="button" class="btn btn-success"><i class="fas fa-edit"></i></button>
		            			<button type="button" class="btn btn-danger"><i class="far fa-trash-alt"></i></button>
					      	</td>
				    	</tr>
						</c:forEach>
					</tbody>
				</table>
		  	</c:otherwise>
		</c:choose>
	</div>
</div>

</t:wrapper>