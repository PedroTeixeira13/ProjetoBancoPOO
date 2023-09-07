package pessoas;

public abstract class Pessoa {
	protected String nome;
	private String cpf;
	private String senha;
	
	public Pessoa(String nome, String cpf, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

	public Pessoa() {
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getSenha() {
		return senha;
	}

	
}

	
