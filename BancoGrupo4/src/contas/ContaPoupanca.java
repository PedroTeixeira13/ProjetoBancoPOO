package contas;

public class ContaPoupanca extends Conta {
	protected double rendimento;

	public ContaPoupanca() {
	}

	public double getRendimento() {
		return rendimento;
	}

	public ContaPoupanca(String cpfTitular, double saldo, int agencia, String tipo, double rendimento) {
		this.cpfTitular = cpfTitular;
		this.saldo = saldo;
		this.agencia = agencia;
		this.tipo = tipo;
		this.rendimento = rendimento;
	}

	@Override
	public String sacar(double valor) {
		if (this.getSaldo() > valor) {
			this.saldo -= valor - taxSaque;
			return "Saque realizado com sucesso";
		} else {
			return "Saldo insuficiente";
		}

	}

	@Override
	public String depositar(double valor) {
		this.saldo += valor - taxDeposito;
		return "Depósito realizado com sucesso";
	}

	@Override
	public String transferir(Conta destino, double valor) {
		if (this.getSaldo() > valor) {
			destino.saldo += valor - taxTransferencia;
			this.saldo -= valor;
			return "Transferência realizada com sucesso";
		} else {
			return "Saldo insuficiente";
		}
	}
}
