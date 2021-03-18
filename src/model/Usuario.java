package model;

public class Usuario {	
	private Integer idusuario;
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	private String observacao;
	private boolean ativo;

	public Usuario() { }
		
	public Usuario(Integer idusuario, String nome, String cpf, String email, String senha, String observacao, boolean ativo) {
		super();
		this.idusuario = idusuario;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.observacao = observacao;
		this.ativo = ativo;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", senha="
				+ senha + ", observacao=" + observacao + ", ativo=" + ativo + "]";
	}
}
