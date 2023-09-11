package pessoas;

public abstract class Funcionario extends Pessoa {
	
	public Funcionario() {
		super();
	}
	
	public Funcionario(String nome, String cpf, String cargo, String senha) {
		super(nome, cpf, cargo, senha);
	}
}