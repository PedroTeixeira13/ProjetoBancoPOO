package contas;

public abstract class Conta {
	private String cpfTitular;
	private double saldo;
	private int agencia;
	private String tipo;
	private final double taxDeposito = 0.10;
	private final double taxSaque = 0.10;
	private final double taxTransferencia = 0.20;
	private double operacoes = 0.0;
	private double taxaDeposito = 0.0;
	private double taxaSaque = 0.0;
	private double taxaTransferencia = 0.0;
	
	public double getTaxDeposito() {
		return taxDeposito;
	}

	public double getTaxSaque() {
		return taxSaque;
	}

	public double getTaxTransferencia() {
		return taxTransferencia;
	}

	public double getTaxaDeposito() {
		return taxaDeposito;
	}

	public double getTaxaSaque() {
		return taxaSaque;
	}

	public double getTaxaTransferencia() {
		return taxaTransferencia;
	}

	public double getOperacoes() {
		return operacoes;
	}

	public String getCpfTitular() {
		return cpfTitular;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
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
	
	public String sacar(double valor) {
		if (this.getSaldo() > valor) {
			this.saldo -= valor + taxSaque;
			this.operacoes += valor;
			this.taxaSaque += taxSaque;
			return "Saque realizado com sucesso";
		} else {
			return "Saldo insuficiente";
		}
	}
	
	public String depositar(double valor) {
		this.saldo += valor - taxDeposito;
		this.operacoes += valor;
		this.taxaDeposito += taxDeposito;
		return "Depósito realizado com sucesso";
	}
	
	public String transferir(Conta destino, double valor) {
		if (this.getSaldo() > valor) {
			destino.saldo += valor;
			this.saldo -= valor - taxTransferencia;
			this.operacoes += valor;
			this.taxaTransferencia += taxTransferencia;
			return "Transferência realizada com sucesso";
		} else
			return "Saldo insuficiente";
	}
}