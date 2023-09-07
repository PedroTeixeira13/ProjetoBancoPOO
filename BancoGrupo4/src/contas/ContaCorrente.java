package contas;

public class ContaCorrente extends Conta {
	protected double tarifa;
	protected double limite;

	
	public ContaCorrente(String cpfTitular, double saldo, int agencia, String tipo, double tarifa, double limite) {
		this.cpfTitular = cpfTitular;
		this.saldo = saldo;
		this.agencia = agencia;
		this.tipo = tipo;
		this.tarifa = tarifa;
		this.limite = limite;
	}

	public ContaCorrente() {
	}

	public double getTarifa() {
		return tarifa;
	}

	public double getLimite() {
		return limite;
	}


	
	
}
