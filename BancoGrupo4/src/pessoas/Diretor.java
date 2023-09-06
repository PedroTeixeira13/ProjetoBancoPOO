package pessoas;

public class Diretor extends Executivo {
	private String acoes;
	private double capital;

	public String getAcoes() {
		return acoes;
	}

	public double getCapital() {
		return capital;
	}

	public Diretor(String nome, String cpf, int id, String senha, double salario, int senhaExecutivo, String acoes,
			double capital) {
		super(nome, cpf, id, senha, salario, senhaExecutivo);
		this.acoes = acoes;
		this.capital = capital;
	}
}
