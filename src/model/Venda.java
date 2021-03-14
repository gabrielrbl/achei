package model;

import java.util.Date;

public class Venda {
	private Integer idvenda;
	private Imovel imovel;
	private Date dataVendaIniciada;
	private Date dataVendaFinalizada;
	private Double valorMensal;
	private Double valorAnual;
	private String formaPagamento;
	private Date dataPagamentoVenda;
	
	public Venda() { }
	
	public Venda(Integer idvenda, Imovel imovel, Date dataVendaIniciada, Date dataVendaFinalizada, Double valorMensal,
			Double valorAnual, String formaPagamento, Date dataPagamentoVenda) {
		super();
		this.idvenda = idvenda;
		this.imovel = imovel;
		this.dataVendaIniciada = dataVendaIniciada;
		this.dataVendaFinalizada = dataVendaFinalizada;
		this.valorMensal = valorMensal;
		this.valorAnual = valorAnual;
		this.formaPagamento = formaPagamento;
		this.dataPagamentoVenda = dataPagamentoVenda;
	}

	public Integer getIdvenda() {
		return idvenda;
	}

	public void setIdvenda(Integer idvenda) {
		this.idvenda = idvenda;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Date getDataVendaIniciada() {
		return dataVendaIniciada;
	}

	public void setDataVendaIniciada(Date dataVendaIniciada) {
		this.dataVendaIniciada = dataVendaIniciada;
	}

	public Date getDataVendaFinalizada() {
		return dataVendaFinalizada;
	}

	public void setDataVendaFinalizada(Date dataVendaFinalizada) {
		this.dataVendaFinalizada = dataVendaFinalizada;
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

	public Date getDataPagamentoVenda() {
		return dataPagamentoVenda;
	}

	public void setDataPagamentoVenda(Date dataPagamentoVenda) {
		this.dataPagamentoVenda = dataPagamentoVenda;
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
		return "Venda [idvenda=" + idvenda + ", imovel=" + imovel + ", dataVendaIniciada=" + dataVendaIniciada
				+ ", dataVendaFinalizada=" + dataVendaFinalizada + ", valorMensal=" + valorMensal + ", valorAnual="
				+ valorAnual + ", formaPagamento=" + formaPagamento + ", dataPagamentoVenda=" + dataPagamentoVenda
				+ "]";
	}	
}
