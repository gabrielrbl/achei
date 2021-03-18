<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<t:wrapper title="Listagem de Imóveis">
<div class="card">
	<div class="card-body">
	<c:if test="${msgString != null}">${msgString}</c:if>
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
					      	<th scope="col">IMÓVEL</th>
					      	<th scope="col">NEGÓCIO</th>
					      	<th scope="col">LOCAL</th>
					      	<th scope="col">AÇÕES</th>
						</tr>
					</thead>
				  	<tbody>
						<c:forEach var="imovel" items="${imovelList}">
							<c:set var="im" value="${imovel.imovel.imovel}" />
							<c:choose>
								<c:when test="${imovel['class'].simpleName == 'Locacao'}"><c:set var="tipoNegocio" value="Locação" /></c:when>
								<c:when test="${imovel['class'].simpleName == 'Venda'}"><c:set var="tipoNegocio" value="Venda" /></c:when>
							</c:choose>
							<c:set var="tipoImovelClass" value="${imovel.imovel['class'].simpleName}" />
							<tr>
					      		<th scope="row">${im.idimovel}</th>
						      	<td>${imovel.imovel['class'].simpleName}</td>
						      	<td>${tipoNegocio}</td>
						      	<td><span style="text-transform: capitalize;">${fn:toLowerCase(im.cidade)}, ${fn:toLowerCase(im.bairro)}, ${fn:toLowerCase(im.rua)}</span><c:if test="${im.numero != null}">, nº ${im.numero}</c:if></td>
						      	<td>
						      		<a href="${pageContext.request.contextPath}/imovel/${im.idimovel}" target="_blank">
						      			<button type="button" class="btn btn-primary"><i class="far fa-eye"></i></button>
						      		</a>
						      		<a href="#">
			              				<button type="button" class="btn btn-success"><i class="fas fa-edit"></i></button>
		              				</a>
		              				<a href="#" class="deletar" data-id="${im.idimovel}">
			            				<button type="button" class="btn btn-danger"><i class="far fa-trash-alt"></i></button>
						      		</a>
						      	</td>
					    	</tr>
						</c:forEach>
					</tbody>
				</table>
		  	</c:otherwise>
		</c:choose>
	</div>
</div>

<div class="modal fade" id="removeModal" tabindex="-1" role="dialog" aria-labelledby="removeModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
        		<h5 class="modal-title" id="removeModalLabel">Remover Imóvel</h5>
        		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          			<span aria-hidden="true">&times;</span>
        		</button>
      		</div>
      		<div class="modal-body">
				Tem certeza que deseja remover o Imóvel #<span class="idImovelremove"></span>?
      		</div>
      		<div class="modal-footer">
      			<form id="formDelete" action="DeleteImovel">
      				<input type="hidden" id="idImovel" name="idImovel" />
      				<button type="button" class="btn btn-danger btn-primary">Excluir</button>
   				</form>
        		<button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
      		</div>
    	</div>
  	</div>
</div>


<script>
$(document).ready(function() {
	$(document).on("click", ".deletar", function() {
		$(".idImovelremove").html($(this).data("id"));
		$("input#idImovel").val($(this).data("id"));
		$(".confirm-delete").data("id", $(this).data("id"));
		$("#removeModal").modal();
	});
	
	$("#formDelete button").on("click", function(){
		$("#removeModal").find("button").prop("disabled", true);
		$("#formDelete").submit();
	});
});
</script>
</t:wrapper>