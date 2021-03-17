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
					      		<a href="${pageContext.request.contextPath}/imovel/${im.imovel.idimovel}" target="_blank">
					      			<button type="button" class="btn btn-primary"><i class="far fa-eye"></i></button>
					      		</a>
					      		<a href="#">
		              				<button type="button" class="btn btn-success"><i class="fas fa-edit"></i></button>
	              				</a>
	              				<a href="#" class="deletar" data-id="${im.imovel.idimovel}">
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
        		<button type="button" class="btn btn-danger btn-primary confirm-delete">Excluir</button>
        		<button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
      		</div>
    	</div>
  	</div>
</div>


<script>
$(document).ready(function() {
	$(document).on("click", ".deletar", function() {
		$(".idImovelremove").html($(this).data("id"));
		$(".confirm-delete").data("id", $(this).data("id"));
		$("#removeModal").modal();
		
	});	
	
	$(document).on("click", ".confirm-delete", function() {
		$.ajax({
			type: "POST",
			url: "DeleteImovel",
			data: JSON.stringify({id: $(this).data("id")}),
			contentType: "json",
			success: (response) => {
				if(response){
					alert("Imóvel "+ $(this).data("id") +" excluído com sucesso!");
					window.location.reload(true);
				} else {
					alert("Não foi possível excluir o imóvel...");
				}
			},
			error: (e) => {
				console.log(e);
			}
		});
	});
});
</script>
</t:wrapper>