package contas;

public abstract class Conta {
	protected String cpfTitular;
	protected double saldo;
	protected int agencia;
	protected String tipo;
	protected final double TAX_DEPOSITO = 0.10;
	protected final double TAX_SAQUE = 0.10;
	protected final double TAX_TRANSFERENCIA = 0.20;
	protected final double TAX_SEGURO = 0.20;
	protected double operacoes = 0.0;
	protected double taxaDeposito = 0.0;
	protected double taxaSaque = 0.0;
	protected double taxaTransferencia = 0.0;
	protected double valorTotSeguro = 0.0;
	
	public double getTaxaSeguro() {
		return TAX_SEGURO;
	}

	public double getTaxDeposito() {
		return TAX_DEPOSITO;
	}

	public double getTaxSaque() {
		return TAX_SAQUE;
	}

	public double getTaxTransferencia() {
		return TAX_TRANSFERENCIA;
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
	
	public double getValorTotSeguro() {
		return valorTotSeguro;
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
	
	public void sacar(double valor) {
		if (this.getSaldo() > valor) {
			this.saldo -= valor + TAX_SAQUE;
			this.operacoes += valor;
			this.taxaSaque += TAX_SAQUE;
		}
	}
	
	public void depositar(double valor) {
		this.saldo += valor - TAX_DEPOSITO;
		this.operacoes += valor;
		this.taxaDeposito += TAX_DEPOSITO;
	}
	
	public void transferir(Conta destino, double valor) {
		if (this.getSaldo() > valor) {
			destino.saldo += valor;
			this.saldo -= (valor + TAX_TRANSFERENCIA);
			this.operacoes += valor;
			this.taxaTransferencia += TAX_TRANSFERENCIA;
		} 
	}
	public void seguro(double valor){
		double valorAux = 0;
		valorAux = valor * TAX_SEGURO;
		if (this.saldo >= valorAux){
			this.saldo -= valorAux;
			this.valorTotSeguro += valor;
		}
		
	}
}