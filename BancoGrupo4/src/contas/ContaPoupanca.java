package contas;

public class ContaPoupanca extends Conta {
	protected double rendimento;

	public ContaPoupanca(int numero, String titular, double saldo, double rendimento) {
		super(numero, titular, saldo);
		this.tipo = "CP";
		this.rendimento = rendimento;
	}

	public void aplicarRendimento() {
		saldo += saldo * (rendimento / 100);
		imprimirExtrato("Rendimento de " + (saldo * (rendimento / 100)));
	}

}
