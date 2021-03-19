<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<t:wrapper title="Imóvel">
	<style>
.card-img-top {
	width: 100%;
	height: 10vw;
	object-fit: cover;
}
</style>

	<c:set var="tipoNegocioClass" value="${imovel['class'].simpleName}" />
	<c:set var="tipoImovelClass"
		value="${imovel.imovel['class'].simpleName}" />
	<c:set var="im" value="${imovel.imovel.imovel}" />

	<c:choose>
		<c:when test="${tipoNegocioClass == 'Locacao'}">
			<c:set var="valor" value="${imovel.valorMensal}" />
		</c:when>
		<c:when test="${tipoNegocioClass == 'Venda'}">
			<c:set var="valor" value="${imovel.valorVenda}" />
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${tipoImovelClass == 'Apartamento'}"></c:when>
		<c:when test="${tipoImovelClass == 'Casa'}"></c:when>
	</c:choose>

	<div class="container">
		<div class="main-body">
			<nav aria-label="breadcrumb" class="main-breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a
						href="${pageContext.request.contextPath}/">Início</a></li>
					<li class="breadcrumb-item"><a href="javascript:void(0)">Imóveis</a></li>
					<li class="breadcrumb-item active" aria-current="page">${tipoImovelClass}
						#${im.idimovel}</li>
				</ol>
			</nav>

			<div class="row gutters-sm">
				<div class="col-md-12 mb-3">
					<div class="card">
						<div
							class="card-header d-flex flex-row justify-content-between pmd-card-border">
							<div>
								<h3 class="card-title">
									${tipoImovelClass} em <span style="text-transform: capitalize;">${fn:toLowerCase(im.bairro)},
										${fn:toLowerCase(im.cidade)}</span>, ${im.idimovel} m²
								</h3>
							</div>
							<div>
								<h3>
									<span class="badge badge-success badge-pill">R$<c:out
											value="${valor}" /></span>
								</h3>
							</div>
						</div>
						<div class="card-body">
							<div id="carouselExampleIndicators-${im.idimovel}"
								class="carousel slide carousel-fade" data-ride="carousel">
								<ol class="carousel-indicators">
									<c:forEach var="foto" items="${im.fotos}" varStatus="loop">
										<li data-target="#carouselExampleIndicators-${im.idimovel}"
											data-slide-to="${loop.index}"
											<c:if test="${loop.index == 0}">class="active"</c:if>></li>
									</c:forEach>
								</ol>
								<div class="carousel-inner">
									<c:forEach var="foto" items="${im.fotos}" varStatus="loop">
										<div
											class="carousel-item <c:if test="${loop.index == 0}">active</c:if>">
											<img class="d-block w-100" src="${foto.foto}"
												alt="First slide">
										</div>
									</c:forEach>
								</div>
								<a class="carousel-control-prev"
									href="#carouselExampleIndicators-${im.idimovel}" role="button"
									data-slide="prev"> <span class="carousel-control-prev-icon"
									aria-hidden="true"></span> <span class="sr-only">Anterior</span>
								</a> <a class="carousel-control-next"
									href="#carouselExampleIndicators-${im.idimovel}" role="button"
									data-slide="next"> <span class="carousel-control-next-icon"
									aria-hidden="true"></span> <span class="sr-only">Próximo</span>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row gutters-sm">
				<div class="col-md-12 mb-3">
					<div class="card text-center">
						<div class="card-header">
							<span class="display-4">Responsável</span>
						</div>
						<div class="card-body card-block">
							<div class="row">
								<div class="col-md-4">
									<img src="https://bootdey.com/img/Content/avatar/avatar7.png"
										alt="Admin" class="rounded-circle" width="150">
									<div class="mt-3">
										<h4 style="text-transform: capitalize;">${fn:toLowerCase(im.responsavel.nome)}</h4>
									</div>
								</div>
								<div class="col-md-8">
									<div class="row">
										<c:if test="${empty responsavelContatos}">
											<div class="col-12">
												<h3>O responsável pelo imóvel não cadastrou nenhuma
													forma de contato...</h3>
											</div>
										</c:if>
										<c:forEach var="responsavelContato"
											items="${responsavelContatos}">
											<div class="col-3">
												<h5>${responsavelContato.tipo}</h5>
											</div>
											<div class="col-9 text-secondary">
												<h5>${responsavelContato.contato}</h5>
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<c:if test="${empty usuarioLogado}">
				<div class="row gutters-sm">
					<div class="col-md-12">
						<div class="alert alert-warning text-center" role="alert">
							<strong>Atenção!</strong> Faça <a
								href="${pageContext.request.contextPath}/login"><strong>login</strong></a>
							para ver mais detalhes do imóvel!
						</div>
					</div>
				</div>
			</c:if>

			<div class="row gutters-sm">
				<div class="col-md-4 mb-3">
					<ul class="list-group lead">
						<li class="list-group-item"><i class="fas fa-bed"></i>
							Quartos <span class="badge badge-primary badge-pill"><c:choose>
									<c:when test="${!empty usuarioLogado}">${im.quartos}</c:when>
									<c:otherwise>
										<i class="fas fa-question"></i>
									</c:otherwise>
								</c:choose></span></li>
						<li class="list-group-item"><i class="fas fa-toilet"></i>
							Banheiros <span class="badge badge-primary badge-pill"><c:choose>
									<c:when test="${!empty usuarioLogado}">${im.banheiros}</c:when>
									<c:otherwise>
										<i class="fas fa-question"></i>
									</c:otherwise>
								</c:choose></span></li>
						<li class="list-group-item"><i class="fas fa-ruler"></i> Área
							total <c:choose>
								<c:when test="${!empty usuarioLogado}">${im.areaTotal} m²</c:when>
								<c:otherwise>
									<i class="fas fa-question"></i>
								</c:otherwise>
							</c:choose></li>
						<li class="list-group-item"><i class="fas fa-hammer"></i>
							Área construída <c:choose>
								<c:when test="${!empty usuarioLogado}">${im.areaConstruida} m²</c:when>
								<c:otherwise>
									<i class="fas fa-question"></i>
								</c:otherwise>
							</c:choose>
						<li class="list-group-item"><i class="fas fa-warehouse"></i>
							Vagas na garagem <span class="badge badge-primary badge-pill"><c:choose>
									<c:when test="${!empty usuarioLogado}">${im.vagasGaragem}</c:when>
									<c:otherwise>
										<i class="fas fa-question"></i>
									</c:otherwise>
								</c:choose></span></li>
						<c:if test="${tipoImovelClass == 'Apartamento'}">
							<li class="list-group-item"><i class="fas fa-street-view"></i>
								Sacada <c:choose>
									<c:when test="${!empty usuarioLogado}">
										<span
											class='badge badge-pill ${imovel.imovel.sacada ? "badge-success'>&#10004;"
											: "badge-danger'>&#10060;"}</span>
									</c:when>
									<c:otherwise>
										<i class="fas fa-question"></i>
									</c:otherwise>
								</c:choose></li>
						</c:if>
						<li class="list-group-item"><i class="fas fa-map-marker-alt"></i>
							<span style="text-transform: capitalize;">${fn:toLowerCase(im.rua)}</span>,
							nº ${im.numero}, <span style="text-transform: capitalize;">${fn:toLowerCase(im.bairro)}</span></li>
						<li class="list-group-item list-group-item-info"><i
							class="fas fa-money-bill-alt"></i> <c:choose>
								<c:when test="${tipoNegocioClass == 'Locacao'}">Aluguel</c:when>
								<c:when test="${tipoNegocioClass == 'Venda'}">Venda</c:when>
							</c:choose>: <c:choose>
								<c:when test="${!empty usuarioLogado}">
									<span class="badge badge-success badge-pill">R$<c:out value="${valor}" />
								</c:when>
								<c:otherwise>
									<i class="fas fa-question"></i>
								</c:otherwise>
							</c:choose></span></li>
					</ul>
				</div>
				<div class="col-md-8 mb-3">
					<div class="card h-100">
						<div class="card-header text-center">
							<span class="display-4">Descrição</span>
						</div>
						<div class="card-body">
							<p class="card-text lead">
								<c:choose>
									<c:when test="${!empty usuarioLogado}">${im.descricao}</c:when>
									<c:otherwise>
										<i class="fas fa-question"></i>
									</c:otherwise>
								</c:choose>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</t:wrapper>