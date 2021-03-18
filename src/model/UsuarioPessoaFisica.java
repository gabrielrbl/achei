package model;

public class UsuarioPessoaFisica {
	private Integer idusuariopessoafisica;
	private Usuario usuario;
	
	public UsuarioPessoaFisica() { }

	public UsuarioPessoaFisica(Integer idusuariopessoafisica, Usuario usuario) {
		super();
		this.idusuariopessoafisica = idusuariopessoafisica;
		this.usuario = usuario;
	}

	public Integer getIdusuariopessoafisica() {
		return idusuariopessoafisica;
	}

	public void setIdusuariopessoafisica(Integer idusuariopessoafisica) {
		this.idusuariopessoafisica = idusuariopessoafisica;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "UsuarioPessoaFisica [idusuariopessoafisica=" + idusuariopessoafisica + ", usuario=" + usuario + "]";
	}
}
