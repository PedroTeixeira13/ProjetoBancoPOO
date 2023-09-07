package contas;

public abstract class Conta {
	protected String cpfTitular;
	protected double saldo;
	protected int agencia;
	protected String tipo;
	protected final double taxDeposito = 0.10;
	protected final double taxSaque = 0.10;
	protected final double taxTransferencia = 0.20;

	public String getCpfTitular() {
		return cpfTitular;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public Conta(String cpfTitular, double saldo, int agencia, String tipo) {
		this.cpfTitular = cpfTitular;
		this.saldo = saldo;
		this.agencia = agencia;
		this.tipo = tipo;
	}
	
	public Conta() {
	}	
	
	public abstract String sacar(double valor);
	
	public abstract String depositar(double valor);
	
	public abstract String transferir(Conta destino, double valor);

	
}

