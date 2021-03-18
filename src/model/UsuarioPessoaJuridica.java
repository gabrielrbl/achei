package model;

public class UsuarioPessoaJuridica {
	private Integer idusuariopessoajuridica;
	private Usuario usuario;
	
	public UsuarioPessoaJuridica() { }
	
	public UsuarioPessoaJuridica(Integer idusuariopessoajuridica, Usuario usuario) {
		super();
		this.idusuariopessoajuridica = idusuariopessoajuridica;
		this.usuario = usuario;
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

	@Override
	public String toString() {
		return "UsuarioPessoaJuridica [idusuariopessoajuridica=" + idusuariopessoajuridica + ", usuario=" + usuario
				+ "]";
	}
}
