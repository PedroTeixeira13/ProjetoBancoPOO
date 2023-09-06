package pessoas;

public class Funcionario extends Pessoa {
	protected double salario;

	public Funcionario(String nome, String cpf, String id, int senha, double salario) {
		super(nome, cpf, id, senha, "Funcionario");
		this.salario = salario;
	}
}