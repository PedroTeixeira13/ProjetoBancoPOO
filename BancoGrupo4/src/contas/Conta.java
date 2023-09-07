package contas;

public abstract class Conta {
	protected String cpfTitular;
	protected double saldo;
	protected int agencia;
	protected String tipo;
	
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
}

