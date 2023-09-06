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
	public void sacar(Conta origem , double valor) {
		if (saldo + limite >= valor + tarifa) {
			saldo -= valor;
			saldo -= tarifa;
			imprimirExtrato("Saque de " + valor + " na conta de " + origem.getTitular());
		} else if (saldo + limite < valor + tarifa) {
			System.out.println("Saldo insuficiente ou ultrapassou o limite.");
		}
	}

	@Override
	public void depositar(Conta origem, double valor) {
		this.saldo += valor;
		imprimirExtrato(origem.getTitular() + "Depósito de " + valor);
	}

	@Override
	public void transferir(Conta origem, Conta destino, double valor) {
		if (saldo >= valor) {
			saldo -= valor;
			this.saldo += valor;
			imprimirExtrato("Transferência de " + origem.getTitular() + " para " + destino.getTitular() + " no valor de " + valor);
		} else if (saldo < valor) {
			System.out.println("Saldo insuficiente para transferência.");
		}
	}

}
