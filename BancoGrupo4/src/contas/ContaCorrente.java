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
    public boolean sacar(double valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sacar'");
    }

    @Override
    public void depositar(double valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depositar'");
    }

    @Override
    public boolean transferir(Conta destino, double valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transferir'");
    }
}
