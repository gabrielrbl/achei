package model;

public class Apartamento extends Imovel {
	private Integer idapartamento;
	private Imovel imovel;
	private String bloco;
	private Integer andar;
	private Integer numeroAp;
	private boolean sacada;

	public Apartamento() { }

	public Apartamento(Integer idapartamento, Imovel imovel, String bloco, Integer andar, Integer numeroAp, boolean sacada) {
		super();
		this.idapartamento = idapartamento;
		this.imovel = imovel;
		this.bloco = bloco;
		this.andar = andar;
		this.numeroAp = numeroAp;
		this.sacada = sacada;
	}

	public Integer getIdapartamento() {
		return idapartamento;
	}

	public void setIdapartamento(Integer idapartamento) {
		this.idapartamento = idapartamento;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public Integer getAndar() {
		return andar;
	}

	public void setAndar(Integer andar) {
		this.andar = andar;
	}
	
	public Integer getNumeroAp() {
		return numeroAp;
	}

	public void setNumeroAp(Integer numeroAp) {
		this.numeroAp = numeroAp;
	}

	public boolean isSacada() {
		return sacada;
	}

	public void setSacada(boolean sacada) {
		this.sacada = sacada;
	}

	@Override
	public String toString() {
		return "Apartamento [idapartamento=" + idapartamento + ", imovel=" + imovel + ", bloco=" + bloco + ", andar="
				+ andar + ", numeroAp=" + numeroAp + ", sacada=" + sacada + "]";
	}	
}
