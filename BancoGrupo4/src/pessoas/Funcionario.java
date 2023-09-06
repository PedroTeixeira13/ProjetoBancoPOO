package pessoas;

public class Funcionario extends Pessoa {
	protected double salario;

	public Funcionario(String nome, String cpf, int id, String senha, double salario) {
		super(nome, cpf, id, senha, "Funcionario");
		this.salario = salario;
	}
}