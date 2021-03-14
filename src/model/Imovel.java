package model;

import java.util.*;

public class Imovel {
	private Integer idimovel;
	private List<ImovelFoto> fotos;
	private String tipo;
	private Integer dormitorios;
	private Integer banheiros;
	private Integer suites;
	private Integer vagasGaragem;
	private Double areaConstruida;
	private Double areaTotal;
	private Double valor;
	private String descricao;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero;
	private String observacao;
	private String status;
	
	public Imovel() { }

	public Imovel(Integer idimovel, List<ImovelFoto> fotos, String tipo, Integer dormitorios, Integer banheiros,
			Integer suites, Integer vagasGaragem, Double areaConstruida, Double areaTotal, Double valor,
			String descricao, String cidade, String bairro, String rua, String numero, String observacao,
			String status) {
		super();
		this.idimovel = idimovel;
		this.fotos = fotos;
		this.tipo = tipo;
		this.dormitorios = dormitorios;
		this.banheiros = banheiros;
		this.suites = suites;
		this.vagasGaragem = vagasGaragem;
		this.areaConstruida = areaConstruida;
		this.areaTotal = areaTotal;
		this.valor = valor;
		this.descricao = descricao;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.observacao = observacao;
		this.status = status;
	}

	public Integer getIdimovel() {
		return idimovel;
	}

	public void setIdimovel(Integer idimovel) {
		this.idimovel = idimovel;
	}

	public List<ImovelFoto> getFotos() {
		return fotos;
	}

	public void setFotos(List<ImovelFoto> fotos) {
		this.fotos = fotos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getDormitorios() {
		return dormitorios;
	}

	public void setDormitorios(Integer dormitorios) {
		this.dormitorios = dormitorios;
	}

	public Integer getBanheiros() {
		return banheiros;
	}

	public void setBanheiros(Integer banheiros) {
		this.banheiros = banheiros;
	}

	public Integer getSuites() {
		return suites;
	}

	public void setSuites(Integer suites) {
		this.suites = suites;
	}

	public Integer getVagasGaragem() {
		return vagasGaragem;
	}

	public void setVagasGaragem(Integer vagasGaragem) {
		this.vagasGaragem = vagasGaragem;
	}

	public Double getAreaConstruida() {
		return areaConstruida;
	}

	public void setAreaConstruida(Double areaConstruida) {
		this.areaConstruida = areaConstruida;
	}

	public Double getAreaTotal() {
		return areaTotal;
	}

	public void setAreaTotal(Double areaTotal) {
		this.areaTotal = areaTotal;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Imovel [idimovel=" + idimovel + ", tipo=" + tipo + ", dormitorios=" + dormitorios
				+ ", banheiros=" + banheiros + ", suites=" + suites + ", vagasGaragem=" + vagasGaragem
				+ ", areaConstruida=" + areaConstruida + ", areaTotal=" + areaTotal + ", valor=" + valor
				+ ", descricao=" + descricao + ", cidade=" + cidade + ", bairro=" + bairro + ", rua=" + rua
				+ ", numero=" + numero + ", observacao=" + observacao + ", status=" + status + "]";
	}

	public void cadastrar() {
		
	}
	
	public void consultar() {
		
	}
	
	public void alterar() {
		
	}
	
	public void excluir() {
		
	}
}
