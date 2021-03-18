package model;

import java.util.*;

public class Imovel {
	private Integer idimovel;
	private Usuario responsavel;
	private List<ImovelFoto> fotos;
	private String tipo;
	private Integer quartos;
	private Integer banheiros;
	private Integer suites;
	private Integer vagasGaragem;
	private Double areaConstruida;
	private Double areaTotal;
	private String descricao;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero;
	private Boolean status;
	
	public Imovel() { }

	public Imovel(Integer idimovel, Usuario responsavel, List<ImovelFoto> fotos, String tipo, Integer quartos,
			Integer banheiros, Integer suites, Integer vagasGaragem, Double areaConstruida, Double areaTotal,
			String descricao, String cidade, String bairro, String rua, String numero, Boolean status) {
		super();
		this.idimovel = idimovel;
		this.responsavel = responsavel;
		this.fotos = fotos;
		this.tipo = tipo;
		this.quartos = quartos;
		this.banheiros = banheiros;
		this.suites = suites;
		this.vagasGaragem = vagasGaragem;
		this.areaConstruida = areaConstruida;
		this.areaTotal = areaTotal;
		this.descricao = descricao;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.status = status;
	}

	public Integer getIdimovel() {
		return idimovel;
	}

	public void setIdimovel(Integer idimovel) {
		this.idimovel = idimovel;
	}

	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
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

	public Integer getQuartos() {
		return quartos;
	}

	public void setQuartos(Integer quartos) {
		this.quartos = quartos;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Imovel [idimovel=" + idimovel + ", responsavel=" + responsavel + ", fotos=" + fotos + ", tipo=" + tipo
				+ ", quartos=" + quartos + ", banheiros=" + banheiros + ", suites=" + suites + ", vagasGaragem="
				+ vagasGaragem + ", areaConstruida=" + areaConstruida + ", areaTotal=" + areaTotal + ", descricao="
				+ descricao + ", cidade=" + cidade + ", bairro=" + bairro + ", rua=" + rua + ", numero=" + numero
				+ ", status=" + status + "]";
	}
}
