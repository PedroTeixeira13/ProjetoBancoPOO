package pessoas;

public abstract class Executivo extends Funcionario {
	protected int senhaExecutivo;

	public int getSenhaExecutivo() {
		return senhaExecutivo;
	}

	public Executivo(String nome, String cpf, int id, String senha, double salario, int senhaExecutivo) {
		super(nome, cpf, id, senha, salario);
		this.senhaExecutivo = senhaExecutivo;
	}
}
