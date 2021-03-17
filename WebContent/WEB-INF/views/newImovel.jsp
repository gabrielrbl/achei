<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:wrapper title="Cadastrar Imóvel">
<style>
	#fotos:not(:first-of-type) { margin-top: 10px; }
</style>

<div class="container">
<script>
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
			divImovel.css("display", "block");
			divImovelAP.css("display", "block");
			divImovelCA.css("display", "none");
			break;
		case "CA":
			dadosImovel.html("DADOS DA CASA");
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
			divLocacao.css("display", "none");
			divVenda.css("display", "none");
			break;
		case "alugar":
			dadosNegocio.html("LOCAÇÃO");
			divNegocio.css("display", "block");
			divLocacao.css("display", "block");
			divVenda.css("display", "none");
			break;
		case "comprar":
			dadosNegocio.html("VENDA");
			divNegocio.css("display", "block");
			divVenda.css("display", "block");
			divLocacao.css("display", "none");
			break;
		}
	});
	
	$("#cadastrarImovel").on("submit", function(e){
		if($("#tipoImovel").val() == ""){
			alert("Selecione o tipo de imóvel!");
			
			e.stopPropagation();
			return false;
		}
	});
});
</script>

<form method="POST" id="cadastrarImovel" action="doNewImovel">
	<h4>DADOS DO IMÓVEL</h4>
	<hr>
	<div class="form-group">
    	<label for="tipoImovel">Tipo de Imóvel</label>
      	<select name="tipoImovel" class="form-control" id="tipoImovel">
      		<option value="" selected>Selecione</option>
        	<option value="AP">APARTAMENTO</option>
        	<option value="CA">CASA</option>
      	</select>
   	</div>
	<div id="fotos" class="form-group">
		<label>Fotos</label>
		<div id="inputFoto" class="input-group mb-3">
			<input class="form-control" name="fotos" type="text" placeholder="Informe o URL da foto do Imóvel" required />
			<button class="btn btn-success btn-add" type="button"><i class="fas fa-plus"></i></button>
		</div>
	</div>
	
	<div class="form-row">
	   	<div class="form-group col-md-3">
			<label for="dormitorios">Dormitórios</label>
			<input type="number" name="dormitorios" class="form-control" id="dormitorios" value="0" required />
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
			<label for="vagasgaragem">Vagas na garagem</label>
			<input type="number" name="vagasgaragem" class="form-control" id="vagasgaragem" value="0" required >
		</div>
	</div>
	
	<div class="form-row">
	   	<div class="form-group col-md-4">
			<label for="areaconstruida">Área construída (m²)</label>
			<input type="number" name="areaconstruida" class="form-control" id="areaconstruida" value="0.0" required />
		</div>
	   	<div class="form-group col-md-4">
			<label for="areatotal">Área total (m²)</label>
			<input type="number" name="areatotal" class="form-control" id="areatotal" value="0.0" required />
		</div>
	   	<div class="form-group col-md-4">
			<label for="valor">Valor (R$)</label>
			<input type="number" name="valor" class="form-control" id="valor" placeholder="R$" value="0.0" required />
		</div>
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
		<div class="form-group col-md-12">
	   		<label for="descricao">Descrição</label>
	   		<textarea name="descricao" class="form-control" id="descricao" rows="3" required></textarea>
		</div>
	</div>
	
	<div class="form-group">
    	<label for="tipoNegocio">Tipo de Negócio</label>
      	<select name="tipoNegocio" class="form-control" id="tipoNegocio">
      		<option value="" selected>Selecione</option>
        	<option value="alugar">LOCAÇÃO</option>
        	<option value="comprar" disabled>VENDA</option>
      	</select>
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
				    <input type="number" name="valorMensal" class="form-control" id="valorMensal" required />
			  	</div>
			  	<div class="form-group col-md-4">
				    <label for="valorAnual">Valor anual</label>
				    <input type="number" name="valorAnual" class="form-control" id="valorAnual" required />
			  	</div>
				<div class="form-group col-md-4">
				    <label for="formaPagamento">Forma de pagamento</label>
				    <input type="text" name="formaPagamento" class="form-control" id="formaPagamento" />
			  	</div>
			</div>
		</div>
		<div id="NegocioVenda" style="display:none;" class="px-0 col-md-12">
			<div class="form-row">
				<div class="form-group col-md-4">
			    	<label for="x">x</label>
			    	<input type="text" name="" class="form-control" id="x" />
			  	</div>
			</div>
		</div>
	</div>

	<div class="form-row">
		<button type="submit" class="btn btn-primary">INSERIR</button>
	</div>
</form>
</div>
  
<script>
$(document).ready(function() {
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