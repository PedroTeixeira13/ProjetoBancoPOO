package contas;

public class ContaPoupanca extends Conta {
	private double rendimento;

	public ContaPoupanca() {
	}

	public double getRendimento() {
		return rendimento;
	}

	public ContaPoupanca(String cpfTitular, double saldo, int agencia, String tipo) {
		super(cpfTitular,saldo, agencia, tipo);
		this.rendimento = 0.03;
	}
}
