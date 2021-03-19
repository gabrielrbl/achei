<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:wrapper title="Cadastrar Imóvel">
<style>
	#fotos:not(:first-of-type) { margin-top: 10px; }
</style>

<script>
function checkURL(input) {
	if(input.value == ""){
		return false;
	} else {
		if(input.value.match(/\.(jpeg|jpg|gif|png)$/) == null){
			alert("URL '"+ url +"' inserida não corresponde a uma imagem!");
			input.value = "";
			return false;
		}
	}
	return false;
}

$(document).ready(function(){
	var divImovel = $("#Imovel"), dadosImovel = $(".dadosImovel"), divImovelAP = $("#ImovelApartamento"), divImovelCA = $("#ImovelCasa");
	
	var divNegocio = $("#Negocio"), dadosNegocio = $(".dadosNegocio"), divLocacao = $("#NegocioLocacao"), divVenda = $("#NegocioVenda");
	
	$("select#tipoImovel").on("change", function(){
		switch ($(this).val()){
		case "":
			dadosImovel.html("");
			divImovel.css("display", "none");
			divImovelAP.css("display", "none");
			divImovelCA.css("display", "none");
			break;
		case "AP":
			dadosImovel.html("DADOS DO APARTAMENTO");
			
			$("#ImovelApartamento :input").attr("required", "req");
			$("#ImovelCasa :input").removeAttr("required");
			
			divImovel.css("display", "block");
			divImovelAP.css("display", "block");
			divImovelCA.css("display", "none");
			break;
		case "CA":
			dadosImovel.html("DADOS DA CASA");
			
			$("#ImovelCasa :input").attr("required", "req");
			$("#ImovelApartamento :input").removeAttr("required");
			
			divImovel.css("display", "block");
			divImovelAP.css("display", "none");
			divImovelCA.css("display", "block");
			break;
		}
	});
	
	$("select#tipoNegocio").on("change", function(){
		switch ($(this).val()){
		case "":
			dadosNegocio.html("");
			divNegocio.css("display", "none");
			
			divLocacao.find(":input").not(":button, :submit, :reset, :hidden").val("").removeAttr("checked").removeAttr("selected");
			divLocacao.css("display", "none");

			divVenda.find(":input").not(":button, :submit, :reset, :hidden").val("").removeAttr("checked").removeAttr("selected");
			divVenda.css("display", "none");
			break;
		case "alugar":
			dadosNegocio.html("LOCAÇÃO");
			divNegocio.css("display", "block");
			divLocacao.css("display", "block");

			$("#NegocioLocacao :input").attr("required", "req");
			$("#NegocioVenda :input").removeAttr("required");
			
			divVenda.find(":input").not(":button, :submit, :reset, :hidden").val("").removeAttr("checked").removeAttr("selected");
			divVenda.css("display", "none");
			break;
		case "comprar":
			dadosNegocio.html("VENDA");
			divNegocio.css("display", "block");
			divVenda.css("display", "block");
			
			$("#NegocioVenda :input").attr("required", "req");
			$("#NegocioLocacao :input").removeAttr("required");
			
			divLocacao.find(":input").not(":button, :submit, :reset, :hidden").val("").removeAttr("checked").removeAttr("selected");
			divLocacao.css("display", "none");
			break;
		}
	});
	
	$("#cadastrarImovel").on("submit", function(e){
		if($("#tipoImovel").val() == ""){
			alert("Selecione o tipo de imóvel!");
			
			e.stopPropagation();
			return false;
		} else if($("#tipoNegocio").val() == ""){
			alert("Selecione o tipo de negócio!");
			
			e.stopPropagation();
			return false;
		}
	});
});
</script>

<div class="container">
	<div class="main-body">
		<nav aria-label="breadcrumb" class="main-breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/">Início</a></li>
				<li class="breadcrumb-item"><a href="javascript:void(0)">Imóveis</a></li>
				<li class="breadcrumb-item active" aria-current="page">Cadastrar</li>
            </ol>
		</nav>
    
		<div class="row gutters-sm">
			<div class="col-md-12 mb-3">
				<form method="POST" id="cadastrarImovel" action="doNewImovel">
					<h4>DADOS DO IMÓVEL</h4>
					<hr>
					<div class="form-group">
				    	<label for="tipoImovel">Tipo de Imóvel</label>
				      	<select name="tipoImovel" class="form-control" id="tipoImovel">
				      		<option value="" selected>Selecione</option>
				        	<option value="AP">Apartamento</option>
				        	<option value="CA">Casa</option>
				      	</select>
				   	</div>
				
					<div class="form-row">
						<div class="form-group col-md-3">
						    <label for="cidade">Cidade</label>
						    <input type="text" name="cidade" class="form-control" id="cidade" required />
					  	</div>
						<div class="form-group col-md-2">
						    <label for="bairro">Bairro</label>
						    <input type="text" name="bairro" class="form-control" id="bairro" required />
					  	</div>
						<div class="form-group col-md-5">
						    <label for="rua">Rua</label>
						    <input type="text" name="rua" class="form-control" id="rua" required />
					  	</div>
						<div class="form-group col-md-2">
						    <label for="numero">Número</label>
						    <input type="number" name="numero" class="form-control" id="numero" />
					  	</div>
				  	</div>
					
					<div class="form-row">
					   	<div class="form-group col-md-3">
							<label for="quartos">Quartos</label>
							<input type="number" name="quartos" class="form-control" id="quartos" value="0" required />
						</div>
					   	<div class="form-group col-md-3">
							<label for="banheiros">Banheiros</label>
							<input type="number" name="banheiros" class="form-control" id="banheiros" value="0" required />
						</div>
					   	<div class="form-group col-md-3">
							<label for="suites">Suítes</label>
							<input type="number" name="suites" class="form-control" id="suites" value="0" required />
						</div>
					   	<div class="form-group col-md-3">
							<label for="vagasGaragem">Vagas na garagem</label>
							<input type="number" name="vagasGaragem" class="form-control" id="vagasGaragem" value="0" required >
						</div>
					</div>
					
					<div class="form-row">
					   	<div class="form-group col-md-4">
							<label for="areaConstruida">Área construída (m²)</label>
							<input type="number" name="areaConstruida" class="form-control" id="areaConstruida" value="0.0" required />
						</div>
					   	<div class="form-group col-md-4">
							<label for="areaTotal">Área total (m²)</label>
							<input type="number" name="areaTotal" class="form-control" id="areaTotal" value="0.0" required />
						</div>
					</div>
				  	
					<div class="form-row">
						<div id="fotos" class="form-group col-md-12">
							<label>Fotos</label>
							<div id="inputFoto" class="input-group mb-3">
								<input onfocusout="checkURL(this)" class="form-control" name="fotos" type="url" placeholder="http://exemplo.com.br - Informe URL válido de uma imagem" required />
								<button class="btn btn-success btn-add" type="button"><i class="fas fa-plus"></i></button>
							</div>
						</div>
					</div>
					
					<div class="form-row">
						<div class="form-group col-md-12">
					   		<label for="descricao">Descrição</label>
					   		<textarea name="descricao" class="form-control" id="descricao" rows="3" required></textarea>
						</div>
					</div>
					
					<div class="form-row">
						<div class="form-group col-md-12">
					    	<label for="tipoNegocio">Tipo de Negócio</label>
					      	<select name="tipoNegocio" class="form-control" id="tipoNegocio">
					      		<option value="" selected>Selecione</option>
					        	<option value="alugar">Locação</option>
					        	<option value="comprar">Venda</option>
					      	</select>
					   	</div>
				   	</div>
					
					<br>
				
					<div id="Imovel" style="display:none;" class="px-0 col-md-12">
						<h4 class="dadosImovel"></h4>
						<hr>
						<div id="ImovelApartamento" style="display:none;" class="px-0 col-md-12">
							<div class="form-row">
								<div class="form-group col-md-4">
								    <label for="bloco">Bloco</label>
								    <input type="text" name="bloco" class="form-control" id="bloco" />
							  	</div>
								<div class="form-group col-md-3">
								    <label for="andar">Andar</label>
								    <input type="number" name="andar" class="form-control" id="andar" />
							  	</div>
							  	<div class="form-group col-md-3">
								    <label for="numeroAp">Número do AP</label>
								    <input type="number" name="numeroAp" class="form-control" id="numeroAp" />
							  	</div>
							  	<div class="form-group col-md-2">
									<div class="form-check">
										<input type="checkbox" name="sacada" class="form-check-input" id="sacada" />
										<label for="sacada" class="form-check-label">Sacada</label>
							  		</div>
						  		</div>
							</div>
						</div>
						<div id="ImovelCasa" style="display:none;" class="px-0 col-md-12">
							<div class="form-row">
								<div class="form-group col-md-4">
							    	<label for="lote">Lote</label>
							    	<input type="text" name="lote" class="form-control" id="lote" />
							  	</div>
								<div class="form-group col-md-4">
							    	<label for="quadra">Quadra</label>
							    	<input type="text" name="quadra" class="form-control" id="quadra" />
							  	</div>
							</div>
						</div>
					</div>
					
					<div id="Negocio" style="display:none;" class="px-0 col-md-12">
						<h4 class="dadosNegocio"></h4>
						<hr>
						<div id="NegocioLocacao" style="display:none;" class="px-0 col-md-12">
							<div class="form-row">
								<div class="form-group col-md-4">
								    <label for="dataLocacaoInicio">Data de Início</label>
								    <input type="date" name="dataLocacaoInicio" class="form-control" id="dataLocacaoInicio" />
							  	</div>
							  	<div class="form-group col-md-4">
								    <label for="dataLocacaoFim">Data de Fim</label>
								    <input type="date" name="dataLocacaoFim" class="form-control" id="dataLocacaoFim" />
							  	</div>
							</div>
							<div class="form-row">
							  	<div class="form-group col-md-4">
								    <label for="valorMensal">Valor mensal</label>
								    <input type="number" name="valorMensal" class="form-control" id="valorMensal" />
							  	</div>
							  	<div class="form-group col-md-4">
								    <label for="valorAnual">Valor anual</label>
								    <input type="number" name="valorAnual" class="form-control" id="valorAnual" />
							  	</div>
								<div class="form-group col-md-4">
								    <label for="formaPagamentoLocacao">Forma de pagamento</label>
								    <input type="text" name="formaPagamentoLocacao" class="form-control" id="formaPagamentoLocacao" />
							  	</div>
							</div>
						</div>
						<div id="NegocioVenda" style="display:none;" class="px-0 col-md-12">
							<div class="form-row">
								<div class="form-group col-md-4">
								    <label for="dataVendaIniciada">Data de Início da venda</label>
								    <input type="date" name="dataVendaIniciada" class="form-control" id="dataVendaIniciada" />
							  	</div>
							  	<div class="form-group col-md-4">
								    <label for="dataVendaFinalizada">Data de Fim da venda</label>
								    <input type="date" name="dataVendaFinalizada" class="form-control" id="dataVendaFinalizada" />
							  	</div>
							</div>
							<div class="form-row">
							  	<div class="form-group col-md-4">
								    <label for="valorVenda">Valor mensal</label>
								    <input type="number" name="valorVenda" class="form-control" id="valorVenda" />
							  	</div>
								<div class="form-group col-md-4">
								    <label for="formaPagamentoVenda">Forma de pagamento</label>
								    <input type="text" name="formaPagamentoVenda" class="form-control" id="formaPagamentoVenda" />
							  	</div>
							</div>
						</div>
					</div>
				
					<div class="text-right">
						<button type="submit" class="btn btn-primary">INSERIR +</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
  
<script>
$(document).ready(function() {	
	Date.prototype.toDateInputValue = (function() {
	    var local = new Date(this);
	    local.setMinutes(this.getMinutes() - this.getTimezoneOffset());
	    return local.toJSON().slice(0,10);
	});
	
	$("#dataVendaIniciada").val(new Date().toDateInputValue());

	$(document).on('click', '.btn-add', function(e) {
		e.preventDefault();

		var divFotos = $("#fotos"),
		currentEntry = $(this).parent(),
		newEntry = $(currentEntry.clone()).appendTo(divFotos);

		newEntry.find('input').val(''); // seto valor para '' do input clonado

		divFotos.find('.btn-add:not(:last)')
	    	.removeClass('btn-add').addClass('btn-remove') // tiro classe do botao add e adiciono botao remove
	      	.removeClass('btn-success').addClass('btn-danger') // tiro classe de botao succes e adiciono botao danger
	      	.html('<i class="fas fa-minus"></i>');

  	}).on('click', '.btn-remove', function(e) {
    	$(this).parents(':first').remove();
  		
		e.preventDefault();
		return false;
	});
});
</script>
</t:wrapper>