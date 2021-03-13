<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:wrapper title="Início">
<div class="row">
	<div class="col-lg-3">
		<h1 class="my-4">Imóveis</h1>
        <div class="list-group">
        	<a href="#" class="list-group-item">Todos</a>
          	<a href="#" class="list-group-item">Apartamentos</a>
          	<a href="#" class="list-group-item">Casas</a>
		</div>
    </div>
	<div class="col-lg-9">
		<div class="row">
			<c:choose>
			  	<c:when test="${empty imovelList}">VAZIO</c:when>
			  	<c:otherwise>
				  	<c:forEach var="imovel" items="${imovelList}">
					  	<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<div id="carouselExampleIndicators-${imovel.imovel.idimovel}" class="carousel slide" data-ride="carousel">
									<ol class="carousel-indicators">
						  				<c:forEach var="foto" items="${imovel.imovel.fotos}" varStatus="loop">
									  		<li data-target="#carouselExampleIndicators-${imovel.imovel.idimovel}" data-slide-to="${loop.index}" <c:if test="${loop.index == 0}">class="active"</c:if>></li>
								  		</c:forEach>
							  		</ol>
							  		<div class="carousel-inner">
								  		<c:forEach var="foto" items="${imovel.imovel.fotos}" varStatus="loop">
									  		<div class="carousel-item <c:if test="${loop.index == 0}">active</c:if>">
										      	<img class="d-block w-100" src="${foto.foto}" alt="First slide">
										    </div>
									    </c:forEach>
							  		</div>
							  		<a class="carousel-control-prev" href="#carouselExampleIndicators-${imovel.imovel.idimovel}" role="button" data-slide="prev">
								    	<span class="carousel-control-prev-icon" aria-hidden="true"></span>
								    	<span class="sr-only">Previous</span>
								  	</a>
								  	<a class="carousel-control-next" href="#carouselExampleIndicators-${imovel.imovel.idimovel}" role="button" data-slide="next">
								   		<span class="carousel-control-next-icon" aria-hidden="true"></span>
								    	<span class="sr-only">Next</span>
								 	</a>
								</div>
						      	<div class="card-body">
						        	<h4 class="card-title">
							        	<a href="#">
								        	<c:choose>
												<c:when test="${imovel.imovel.tipo == 'AP'}">APARTAMENTO</c:when>
												<c:when test="${imovel.imovel.tipo == 'CA'}">CASA</c:when>
											</c:choose>
										</a>
									</h4>
						        	<h5>R$ <c:out value="${imovel.imovel.valor}" /></h5>
						        	<p class="card-text"><c:out value="${imovel.imovel.descricao}" /></p>
						      	</div>
						      	<div class="card-footer">
						        	<small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
						        	<a href="#" class="btn btn-primary float-right">Comprar</a>
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