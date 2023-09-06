package pessoas;

public abstract class Pessoa {
	public String nome;
	protected String cpf;
	protected String tipo;
	protected int id;
	protected String senha;

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public int getId() {
		return id;
	}

	public String getSenha() {
		return senha;
	}

	public Pessoa() {
	}
	
	public Pessoa(String nome, String cpf, int id, String senha, String tipo) {
		this.nome = nome;
		this.cpf = cpf;
		this.id = id;
		this.tipo = tipo;
		this.senha = senha;
	}

}