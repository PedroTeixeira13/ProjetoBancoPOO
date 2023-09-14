package pessoas;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private String senha;
	private String cargo;
	private String agencia;
		
	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public Pessoa() {
	}
	
	public Pessoa(String nome, String cpf, String cargo, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
		this.senha = senha;
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
	
	public String getCargo() {
		return cargo;
	}

}

	
