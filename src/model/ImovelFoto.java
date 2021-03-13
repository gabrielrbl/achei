package model;

public class ImovelFoto {
	private Integer idimovelfoto;
	private Imovel imovel;
	private String foto;
	
	public ImovelFoto() { }

	public ImovelFoto(Integer idimovelfoto, Imovel imovel, String foto) {
		super();
		this.idimovelfoto = idimovelfoto;
		this.imovel = imovel;
		this.foto = foto;
	}

	public Integer getIdimovelfoto() {
		return idimovelfoto;
	}

	public void setIdimovelfoto(Integer idimovelfoto) {
		this.idimovelfoto = idimovelfoto;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "ImovelFoto [idimovelfoto=" + idimovelfoto + ", imovel=" + imovel + ", foto=" + foto + "]";
	}
}
