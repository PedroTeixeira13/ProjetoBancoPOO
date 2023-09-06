package pessoas;

public abstract class Pessoa {
	public String nome;
	protected String cpf;
	protected String tipo;
	protected static String id;
	protected int senha;

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public static String getId() {
		return id;
	}

	public int getSenha() {
		return senha;
	}

	public Pessoa() {
	}
	
	public Pessoa(String nome, String cpf, String id, int senha, String tipo) {
		this.nome = nome;
		this.cpf = cpf;
		Pessoa.id = id;
		this.tipo = tipo;
		this.senha = senha;
	}

}