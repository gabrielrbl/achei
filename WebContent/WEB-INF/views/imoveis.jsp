<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:wrapper title="Início">
<c:set var="tipoNegocio" value="${param.tipoNegocio}" />
<c:set var="tipoImovel" value="${param.tipoImovel}" />
<div class="row">
	<div class="col-lg-3">
		<h1 class="my-4">
			<c:choose>
				<c:when test="${tipoNegocio == 'comprar'}">IMÓVEIS À VENDA</c:when>
				<c:when test="${tipoNegocio == 'alugar'}">IMÓVEIS PARA ALUGAR</c:when>
			</c:choose>
		</h1>
		<ul class="nav nav-tabs">
			<li class="nav-item">
				<a href="${pageContext.request.contextPath}/SearchImovel?tipoNegocio=comprar&tipoImovel=${tipoImovel}" class="nav-link <c:if test="${tipoNegocio == 'comprar'}">active</c:if>">COMPRAR</a>
			</li>
			<li class="nav-item">
				<a href="${pageContext.request.contextPath}/SearchImovel?tipoNegocio=alugar&tipoImovel=${tipoImovel}" class="nav-link <c:if test="${tipoNegocio == 'alugar'}">active</c:if>">ALUGAR</a>
			</li>
		</ul>
        <div class="list-group">
        	<a href="${pageContext.request.contextPath}/SearchImovel?tipoNegocio=${tipoNegocio}&tipoImovel=" class="list-group-item list-group-item-action <c:if test="${tipoImovel == ''}">active</c:if>">TODOS</a>
          	<a href="${pageContext.request.contextPath}/SearchImovel?tipoNegocio=${tipoNegocio}&tipoImovel=ap" class="list-group-item list-group-item-action <c:if test="${tipoImovel == 'ap'}">active</c:if>">APARTAMENTOS</a>
          	<a href="${pageContext.request.contextPath}/SearchImovel?tipoNegocio=${tipoNegocio}&tipoImovel=ca" class="list-group-item list-group-item-action <c:if test="${tipoImovel == 'ca'}">active</c:if>">CASAS</a>
		</div>
    </div>
	<div class="col-lg-9">
		<div class="row">
			<c:choose>
			  	<c:when test="${empty imovelList}">VAZIO</c:when>
			  	<c:otherwise>
				  	<c:forEach var="im" items="${imovelList}">
				  		<c:set var="imovel" value="${im.imovel.imovel}" />
				  		<c:set var="tipoNegocioClass" value="${im['class'].simpleName}" />
					  	<div class="col-lg-6 col-md-6 mb-6">
							<div class="card h-100">
								<div id="carouselExampleIndicators-${imovel.idimovel}" class="carousel slide carousel-fade" data-ride="carousel">
									<ol class="carousel-indicators">
						  				<c:forEach var="foto" items="${imovel.fotos}" varStatus="loop">
									  		<li data-target="#carouselExampleIndicators-${imovel.idimovel}" data-slide-to="${loop.index}" <c:if test="${loop.index == 0}">class="active"</c:if>></li>
								  		</c:forEach>
							  		</ol>
							  		<div class="carousel-inner">
								  		<c:forEach var="foto" items="${imovel.fotos}" varStatus="loop">
									  		<div class="carousel-item <c:if test="${loop.index == 0}">active</c:if>">
										      	<img class="d-block w-100" src="${foto.foto}" alt="First slide">
										    </div>
									    </c:forEach>
							  		</div>
							  		<a class="carousel-control-prev" href="#carouselExampleIndicators-${imovel.idimovel}" role="button" data-slide="prev">
								    	<span class="carousel-control-prev-icon" aria-hidden="true"></span>
								    	<span class="sr-only">Anterior</span>
								  	</a>
								  	<a class="carousel-control-next" href="#carouselExampleIndicators-${imovel.idimovel}" role="button" data-slide="next">
								   		<span class="carousel-control-next-icon" aria-hidden="true"></span>
								    	<span class="sr-only">Próximo</span>
								 	</a>
								</div>
						      	<div class="card-body">
						        	<c:choose>
										<c:when test="${tipoNegocioClass == 'Locacao'}">ALUGUEL</c:when>
										<c:when test="${tipoNegocioClass == 'Venda'}">VENDA</c:when>
									</c:choose>
						        	<h4 class="card-title">
							        	<a href="#">
								        	<c:choose>
												<c:when test="${imovel.tipo == 'AP'}">APARTAMENTO</c:when>
												<c:when test="${imovel.tipo == 'CA'}">CASA</c:when>
											</c:choose>
										</a>
									</h4>
									<c:if test="${!empty usuarioLogado}">
						        		<h5>R$ <c:out value="${imovel.valor}" /></h5>
						        		<p class="card-text"><c:out value="${imovel.descricao}" /></p>
						        	</c:if>
						      	</div>
						      	<div class="card-footer">
						        	<small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
						        	<a href="${pageContext.request.contextPath}/imovel/${imovel.idimovel}" class="btn btn-primary float-right">+ DETALHES</a>
						      	</div>
							</div>
						</div>
						<!-- 
				          	<a href="${pageContext.request.contextPath}/editImovel?code=${imovel.idimovel}">Editar</a>
				          	<a href="${pageContext.request.contextPath}/deleteImovel?code=${imovel.idimovel}">Excluir</a>
						-->
					</c:forEach>
			  	</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
</t:wrapper>