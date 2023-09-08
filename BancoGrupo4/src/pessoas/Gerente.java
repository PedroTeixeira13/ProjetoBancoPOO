package pessoas;

public class Gerente extends Funcionario {
	protected int agenciaGere;
	
	public Gerente() {
		super();
	}
	
	public Gerente(String nome, String cpf, String senha, String cargo, int agenciaGere) {
		super(nome, cpf, senha, cargo);
		this.agenciaGere = agenciaGere;
	}

	public Gerente(String nome, String cpf, String senha, String cargo) {
		super(nome, cpf, senha, cargo);
	}

}
