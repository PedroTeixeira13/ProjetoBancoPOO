package pessoas;

public class Atendente extends Funcionario {
	private int ramal;

	public int getRamal() {
		return ramal;
	}

	public Atendente(String nome, String cpf, String id, int senha, double salario, int ramal) {
		super(nome, cpf, id, senha, salario);
		this.ramal = ramal;
	}
}
