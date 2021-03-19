<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<t:wrapper title="Listagem de Imóveis">
	<style>
body {
	margin-top: 20px;
	color: #1a202c;
	text-align: left;
}

.main-body {
	padding: 15px;
}

.card {
	box-shadow: 0 1px 3px 0 rgba(0, 0, 0, .1), 0 1px 2px 0
		rgba(0, 0, 0, .06);
}

.card {
	position: relative;
	display: flex;
	flex-direction: column;
	min-width: 0;
	word-wrap: break-word;
	background-color: #fff;
	background-clip: border-box;
	border: 0 solid rgba(0, 0, 0, .125);
	border-radius: .25rem;
}

.card-body {
	flex: 1 1 auto;
	min-height: 1px;
	padding: 1rem;
}

.gutters-sm {
	margin-right: -8px;
	margin-left: -8px;
}

.gutters-sm>.col, .gutters-sm>[class*=col-] {
	padding-right: 8px;
	padding-left: 8px;
}

.mb-3, .my-3 {
	margin-bottom: 1rem !important;
}

.bg-gray-300 {
	background-color: #e2e8f0;
}

.h-100 {
	height: 100% !important;
}

.shadow-none {
	box-shadow: none !important;
}
</style>

	<div class="container">
		<div class="main-body">
			<nav aria-label="breadcrumb" class="main-breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a
						href="${pageContext.request.contextPath}/">Início</a></li>
					<li class="breadcrumb-item"><a href="javascript:void(0)">Usuário</a></li>
					<li class="breadcrumb-item active" aria-current="page">Imóveis</li>
				</ol>
			</nav>

			<div class="row gutters-sm">
				<div class="col-md-12">
					<div class="card">
						<div class="card-body">
							<h4 class="box-title d-flex justify-content-between">
								Imóveis cadastrados <a class="btn btn-sm btn-primary"
									href="${pageContext.request.contextPath}/addImovel">+
									ADICIONAR</a>
							</h4>
							<c:out value="${fn:length(imovelList)}" />
							resultados.
						</div>
						<div class="card-body">
							<c:if test="${!empty imovelList}">
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
												<c:when test="${imovel['class'].simpleName == 'Locacao'}">
													<c:set var="tipoNegocio" value="Locação" />
												</c:when>
												<c:when test="${imovel['class'].simpleName == 'Venda'}">
													<c:set var="tipoNegocio" value="Venda" />
												</c:when>
											</c:choose>
											<c:set var="tipoImovelClass"
												value="${imovel.imovel['class'].simpleName}" />
											<tr>
												<th scope="row">${im.idimovel}</th>
												<td>${imovel.imovel['class'].simpleName}</td>
												<td>${tipoNegocio}</td>
												<td><span style="text-transform: capitalize;">${fn:toLowerCase(im.cidade)},
														${fn:toLowerCase(im.bairro)}, ${fn:toLowerCase(im.rua)}</span>
												<c:if test="${im.numero != null}">, nº ${im.numero}</c:if></td>
												<td><a
													href="${pageContext.request.contextPath}/imovel/${im.idimovel}"
													target="_blank">
														<button type="button" class="btn btn-primary">
															<i class="far fa-eye"></i>
														</button>
												</a> <a href="#">
														<button type="button" class="btn btn-success">
															<i class="fas fa-edit"></i>
														</button>
												</a> <a href="#" class="deletar" data-id="${im.idimovel}">
														<button type="button" class="btn btn-danger">
															<i class="far fa-trash-alt"></i>
														</button>
												</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="removeModal" tabindex="-1" role="dialog"
		aria-labelledby="removeModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="removeModalLabel">Remover Imóvel</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					Tem certeza que deseja remover o Imóvel #<span
						class="idImovelremove"></span>?
				</div>
				<div class="modal-footer">
					<form id="formDelete" action="DeleteImovel">
						<input type="hidden" id="idImovel" name="idImovel" />
						<button type="button" class="btn btn-danger btn-primary">Excluir</button>
					</form>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fechar</button>
				</div>
			</div>
		</div>
	</div>


	<script>
$(document).ready(function() {
	$(document).on("click", ".deletar", function() {
		$(".idImovelremove").html($(this).data("id"));
		$("input#idImovel").val($(this).data("id"));
		$("#removeModal").modal();
	});
	
	$("#formDelete button").on("click", function(){
		$("#removeModal").find("button").prop("disabled", true);
		alert("Imóvel removido com sucesso!");
		$("#formDelete").submit();
	});
});
</script>
</t:wrapper>