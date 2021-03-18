<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<t:wrapper title="Imóvel">
<style>
.card-img-top {
   	width: 100%;
   	height: 10vw;
   	object-fit: cover;
}
</style>

<c:set var="tipoNegocioClass" value="${imovel['class'].simpleName}" />
<c:set var="tipoImovelClass" value="${imovel.imovel['class'].simpleName}" />

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

<div class="container pt-4">
	<h4 class="pt-4">
		${tipoImovelClass} em <span style="text-transform: capitalize;">${fn:toLowerCase(im.bairro)}, ${fn:toLowerCase(im.cidade)}</span>, ${im.idimovel} m² <span class="badge badge-success badge-pill">R$<c:out value="${valor}" /></span>
	</h4>
	<small class="text-muted" style="text-transform: capitalize;">${fn:toLowerCase(im.rua)}, nº ${im.numero}</small>

	<div class="row pt-4">
    	<div class=col-4>
        	<ul class="list-group">
            	<li class="list-group-item">Quartos <span class="badge badge-primary badge-pill">${im.quartos}</span></li>
            	<!-- 
            	<li class="list-group-item">Salas de estar    <span class="badge badge-primary badge-pill"> salas estar</span></li>
            	<li class="list-group-item">Salas de jantar   <span class="badge badge-primary badge-pill"> salas jantar</span></li>
            	 -->
            	<li class="list-group-item">Área total  ${im.areaTotal} m²</li>
            	<li class="list-group-item">Vagas na garagem  <span class="badge badge-primary badge-pill">${im.vagasGaragem}</span></li>
				<!-- 
                <li class="list-group-item">Armário embutido
                    <span class="badge badge-success badge-pill">&#10004;
                    </span>
                </li>
            	-->
            	<li class="list-group-item">
            		<span style="text-transform: capitalize;">${fn:toLowerCase(im.rua)}</span>, nº ${im.numero}, <span style="text-transform: capitalize;">${fn:toLowerCase(im.bairro)}</span></li>
            	<li class="list-group-item list-group-item-info">
            		<c:choose>
						<c:when test="${tipoNegocioClass == 'Locacao'}">Aluguel: R$<c:out value="${valor}" /></c:when>
						<c:when test="${tipoNegocioClass == 'Venda'}">Venda: R$<c:out value="${valor}" /></c:when>
					</c:choose>
            	</li>
        	</ul>
        	<blockquote class="blockquote text-center pt-4">
            	<p class="mb-0 text-justify">${im.descricao}</p>
        	</blockquote>
    	</div>

    	<div class=col-8>
			<div id="carouselExampleIndicators-${im.idimovel}" class="carousel slide carousel-fade" data-ride="carousel">
				<ol class="carousel-indicators">
  					<c:forEach var="foto" items="${im.fotos}" varStatus="loop">
			  			<li data-target="#carouselExampleIndicators-${im.idimovel}" data-slide-to="${loop.index}" <c:if test="${loop.index == 0}">class="active"</c:if>></li>
		  			</c:forEach>
	  			</ol>
	  			<div class="carousel-inner">
		  			<c:forEach var="foto" items="${im.fotos}" varStatus="loop">
			  			<div class="carousel-item <c:if test="${loop.index == 0}">active</c:if>">
				      		<img class="d-block w-100" src="${foto.foto}" alt="First slide">
				    	</div>
			    	</c:forEach>
	  			</div>
	  			<a class="carousel-control-prev" href="#carouselExampleIndicators-${im.idimovel}" role="button" data-slide="prev">
		    		<span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    		<span class="sr-only">Anterior</span>
		  		</a>
		  		<a class="carousel-control-next" href="#carouselExampleIndicators-${im.idimovel}" role="button" data-slide="next">
		   			<span class="carousel-control-next-icon" aria-hidden="true"></span>
		    		<span class="sr-only">Próximo</span>
		 		</a>
			</div>
    	</div>
	</div>
</div>
</t:wrapper>