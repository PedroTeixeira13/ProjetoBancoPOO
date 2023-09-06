package contas;

public class ContaCorrente extends Conta {
	protected double tarifa;
	protected double limite;

	public double getTarifa() {
		return tarifa;
	}

	public double getLimite() {
		return limite;
	}

	public ContaCorrente() {
		super();
		this.tipo = "CC";
	}

	public ContaCorrente(int numero, String titular, double saldo, double tarifa, double limite) {
		super(numero, titular, saldo);
		this.tipo = "CC";
		this.tarifa = tarifa;
		this.limite = limite;
	}

	@Override
	public void sacar(double valor) {
		if (saldo + limite >= valor + tarifa) {
			saldo -= valor;
			saldo -= tarifa;
			imprimirExtrato("Saque de " + valor);
		} else if (saldo + limite < valor + tarifa) {
			System.out.println("Saldo insuficiente ou ultrapassou o limite.");
		}
	}

	@Override
	public void depositar(double valor) {
		this.saldo += valor;
		imprimirExtrato("Depósito de " + valor);
	}

	@Override
	public void transferir(Conta destino, double valor) {
		if (saldo >= valor) {
			saldo -= valor;
			this.saldo += valor;
			imprimirExtrato("Transferência de " + valor + " para " + destino.getTitular());
		} else if (saldo < valor) {
			System.out.println("Saldo insuficiente para transferência.");
		}
	}

}
