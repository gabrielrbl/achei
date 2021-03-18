package model;

import java.util.Date;

public class Venda {
	private Integer idvenda;
	private Imovel imovel;
	private Date dataVendaIniciada;
	private Date dataVendaFinalizada;
	private Double valorVenda;
	private String formaPagamento;
	
	public Venda() { }

	public Venda(Integer idvenda, Imovel imovel, Date dataVendaIniciada, Date dataVendaFinalizada, Double valorVenda,
			String formaPagamento) {
		super();
		this.idvenda = idvenda;
		this.imovel = imovel;
		this.dataVendaIniciada = dataVendaIniciada;
		this.dataVendaFinalizada = dataVendaFinalizada;
		this.valorVenda = valorVenda;
		this.formaPagamento = formaPagamento;
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

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	@Override
	public String toString() {
		return "Venda [idvenda=" + idvenda + ", imovel=" + imovel + ", dataVendaIniciada=" + dataVendaIniciada
				+ ", dataVendaFinalizada=" + dataVendaFinalizada + ", valorVenda=" + valorVenda + ", formaPagamento="
				+ formaPagamento + "]";
	}
}
