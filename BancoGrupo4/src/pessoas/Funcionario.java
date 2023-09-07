package pessoas;

public abstract class Funcionario extends Pessoa {
	private String cargo;

	public String getCargo() {
		return cargo;
	}
	
	public Funcionario() {
		super();
	}
	
	public Funcionario(String nome, String cpf, String senha, String cargo) {
		super(nome, cpf, senha);
		this.cargo = cargo;
	}
	
	
}