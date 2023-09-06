package pessoas;

public class Gerente extends Executivo {
	private int numeroFuncionarios;

	public int getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public Gerente(String nome, String cpf, String id, int senha, double salario, int senhaExecutivo,
			int numeroFuncionarios) {
		super(nome, cpf, id, senha, salario, senhaExecutivo);
		this.numeroFuncionarios = numeroFuncionarios;
	}
}
