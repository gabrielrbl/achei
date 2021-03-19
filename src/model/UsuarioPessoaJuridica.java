package model;

public class UsuarioPessoaJuridica {
	private Integer idusuariopessoajuridica;
	private Usuario usuario;
	private String cnpj;
	
	public UsuarioPessoaJuridica() { }

	public UsuarioPessoaJuridica(Integer idusuariopessoajuridica, Usuario usuario, String cnpj) {
		super();
		this.idusuariopessoajuridica = idusuariopessoajuridica;
		this.usuario = usuario;
		this.cnpj = cnpj;
	}

	public Integer getIdusuariopessoajuridica() {
		return idusuariopessoajuridica;
	}

	public void setIdusuariopessoajuridica(Integer idusuariopessoajuridica) {
		this.idusuariopessoajuridica = idusuariopessoajuridica;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "UsuarioPessoaJuridica [idusuariopessoajuridica=" + idusuariopessoajuridica + ", usuario=" + usuario
				+ ", cnpj=" + cnpj + "]";
	}
}
