package model;

public class UsuarioPessoaFisica {
	private Integer idusuariopessoafisica;
	private Usuario usuario;
	private String cpf;
	
	public UsuarioPessoaFisica() { }

	public UsuarioPessoaFisica(Integer idusuariopessoafisica, Usuario usuario, String cpf) {
		super();
		this.idusuariopessoafisica = idusuariopessoafisica;
		this.usuario = usuario;
		this.cpf = cpf;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "UsuarioPessoaFisica [idusuariopessoafisica=" + idusuariopessoafisica + ", usuario=" + usuario + ", cpf="
				+ cpf + "]";
	}
}
