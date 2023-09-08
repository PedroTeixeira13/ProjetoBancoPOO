package contas;

public class ContaCorrente extends Conta {
	protected double tarifa;
	protected double limite;

	public ContaCorrente() {
	}

	public ContaCorrente(String cpfTitular, double saldo, int agencia, String tipo) {
		super(cpfTitular, saldo, agencia, tipo);
	}

	public double getTarifa() {
		return tarifa;
	}

	public double getLimite() {
		return limite;
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
			destino.saldo += valor;
			this.saldo -= valor - taxTransferencia;
			return "Transferência realizada com sucesso";
		} else
			return "Saldo insuficiente";
	}
	
}
