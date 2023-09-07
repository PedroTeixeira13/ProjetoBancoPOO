package contas;

public class ContaPoupanca extends Conta {
	protected double rendimento;

	public ContaPoupanca(String cpfTitular, double saldo, int agencia, String tipo, double rendimento) {
		this.cpfTitular = cpfTitular;
		this.saldo = saldo;
		this.agencia = agencia;
		this.tipo = tipo;
		this.rendimento = rendimento;
	}

	public ContaPoupanca() {
	}

	public double getRendimento() {
		return rendimento;
	}

}
