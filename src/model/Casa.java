package model;

public class Casa extends Imovel {
	private Integer idcasa;
	private Imovel imovel;
	private String lote;
	private String quadra;
	
	public Casa() { }
	
	public Casa(Integer idcasa, Imovel imovel, String lote, String quadra) {
		super();
		this.idcasa = idcasa;
		this.imovel = imovel;
		this.lote = lote;
		this.quadra = quadra;
	}

	public Integer getIdcasa() {
		return idcasa;
	}

	public void setIdcasa(Integer idcasa) {
		this.idcasa = idcasa;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getQuadra() {
		return quadra;
	}

	public void setQuadra(String quadra) {
		this.quadra = quadra;
	}

	@Override
	public String toString() {
		return "Casa [idcasa=" + idcasa + ", imovel=" + imovel + ", lote=" + lote + ", quadra=" + quadra + "]";
	}
}
