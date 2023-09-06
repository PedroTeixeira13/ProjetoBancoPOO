package contas;

import java.text.SimpleDateFormat;  
import java.util.Date;

public abstract class Conta {
	protected int numero;
	protected String titular;
	protected double saldo;
	protected String tipo;	
	
	public int getNumero() {
		return numero;
	}

	public String getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getTipo() {
		return tipo;
	}

	public Conta() {
	}

	public Conta(int numero, String titular, double saldo) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}

	public void sacar(Conta origem, double valor) {
		if (saldo >= valor) {
			saldo -= valor;
			imprimirExtrato("Saque de " + valor + " na conta de " + origem.getTitular());
		} else {
			System.out.println("Saldo insuficiente.");
		}
	}

	public void depositar(Conta origem, double valor) {
		this.saldo += valor;
		imprimirExtrato(origem.getTitular() + "Depósito de " + valor);
	}

	public void transferir(Conta origem, Conta destino, double valor) {
		if (saldo >= valor) {
			destino.depositar(origem, valor);
			imprimirExtrato("Transferência de " + origem.getTitular() + " para " + destino.getTitular() + " no valor de " + valor);
		} else {
			System.out.println("Saldo insuficiente para transferência.");
		}
	}
	
	public void imprimirExtrato(String acao) {
		Date data = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM HH:mm");
		String dataFormatada = dateFormat.format(data);
		System.out.println(dataFormatada + " - " + this.numero + this.tipo + " - " + acao);
	}
}