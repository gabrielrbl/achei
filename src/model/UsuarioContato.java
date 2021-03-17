package model;

public class UsuarioContato {
	private Integer idusuariocontato;
	private Usuario usuario;
	private String tipo;
	private String contato;
	
	public UsuarioContato() {  }

	public UsuarioContato(Integer idusuariocontato, Usuario usuario, String tipo, String contato) {
		super();
		this.idusuariocontato = idusuariocontato;
		this.usuario = usuario;
		this.tipo = tipo;
		this.contato = contato;
	}

	public Integer getIdusuariocontato() {
		return idusuariocontato;
	}

	public void setIdusuariocontato(Integer idusuariocontato) {
		this.idusuariocontato = idusuariocontato;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	@Override
	public String toString() {
		return "UsuarioContato [idusuariocontato=" + idusuariocontato + ", usuario=" + usuario + ", tipo=" + tipo
				+ ", contato=" + contato + "]";
	}
}
