package model;

public class TipoImovel {
	private Integer idtipoimovel;
	private String tipoimovel;
	
	public TipoImovel() { }

	public TipoImovel(Integer idtipoimovel, String tipoimovel) {
		super();
		this.idtipoimovel = idtipoimovel;
		this.tipoimovel = tipoimovel;
	}

	public Integer getIdtipoimovel() {
		return idtipoimovel;
	}

	public void setIdtipoimovel(Integer idtipoimovel) {
		this.idtipoimovel = idtipoimovel;
	}

	public String getTipoimovel() {
		return tipoimovel;
	}

	public void setTipoimovel(String tipoimovel) {
		this.tipoimovel = tipoimovel;
	}

	@Override
	public String toString() {
		return "TipoImovel [idtipoimovel=" + idtipoimovel + ", tipoimovel=" + tipoimovel + "]";
	}
}
