package contas;

public class ContaCorrente extends Conta {

	public ContaCorrente() {
	}

	public ContaCorrente(String cpfTitular, double saldo, int agencia, String tipo) {
		super(cpfTitular, saldo, agencia, tipo);
	}
}
