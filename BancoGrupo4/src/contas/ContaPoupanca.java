package contas;

public abstract class ContaPoupanca extends Conta {
    protected double rendimento;

    public ContaPoupanca() {
		super();
		this.tipo = "CP";
	}

    public ContaPoupanca(double rendimento) {
        this.rendimento = rendimento;
    }

    public ContaPoupanca(int numero, String titular, double saldo, double rendimento) {
        super(numero, titular, saldo);
        this.rendimento = rendimento;
    }
}
