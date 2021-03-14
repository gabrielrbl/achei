package model;

import java.util.Date;

public class Locacao {
	private Integer idlocacao;
	private Imovel imovel;
	private Date dataLocacaoInicio;
	private Date dataLocacaoFim;
	private Double valorMensal;
	private Double valorAnual;
	private String formaPagamento;
	
	public Locacao() { }
	
	public Locacao(Integer idlocacao, Imovel imovel, Date dataLocacaoInicio, Date dataLocacaoFim, Double valorMensal,
			Double valorAnual, String formaPagamento) {
		super();
		this.idlocacao = idlocacao;
		this.imovel = imovel;
		this.dataLocacaoInicio = dataLocacaoInicio;
		this.dataLocacaoFim = dataLocacaoFim;
		this.valorMensal = valorMensal;
		this.valorAnual = valorAnual;
		this.formaPagamento = formaPagamento;
	}

	public Integer getIdlocacao() {
		return idlocacao;
	}

	public void setIdlocacao(Integer idlocacao) {
		this.idlocacao = idlocacao;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Date getDataLocacaoInicio() {
		return dataLocacaoInicio;
	}

	public void setDataLocacaoInicio(Date dataLocacaoInicio) {
		this.dataLocacaoInicio = dataLocacaoInicio;
	}

	public Date getDataLocacaoFim() {
		return dataLocacaoFim;
	}

	public void setDataLocacaoFim(Date dataLocacaoFim) {
		this.dataLocacaoFim = dataLocacaoFim;
	}

	public Double getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(Double valorMensal) {
		this.valorMensal = valorMensal;
	}

	public Double getValorAnual() {
		return valorAnual;
	}

	public void setValorAnual(Double valorAnual) {
		this.valorAnual = valorAnual;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public void cadastrar() {
		
	}
	
	public void consultar() {
		
	}
	
	public void alterar() {
		
	}
	
	public void excluir() {
		
	}

	@Override
	public String toString() {
		return "Locacao [idlocacao=" + idlocacao + ", imovel=" + imovel + ", dataLocacaoInicio=" + dataLocacaoInicio
				+ ", dataLocacaoFim=" + dataLocacaoFim + ", valorMensal=" + valorMensal + ", valorAnual=" + valorAnual
				+ ", formaPagamento=" + formaPagamento + "]";
	}
}
