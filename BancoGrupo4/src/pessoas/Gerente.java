package pessoas;

public class Gerente extends Funcionario {
	private int agenciaGere;
	
	public Gerente() {
		super();
	}
	
	public Gerente(String nome, String cpf, String cargo, String senha, int agenciaGere) {
		super(nome, cpf, cargo, senha);
		this.agenciaGere = agenciaGere;
	}
}
