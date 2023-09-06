package contas;

import java.text.SimpleDateFormat;
import java.util.Date;

import pessoas.Pessoa;

abstract class Conta {
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

	public void sacar(double valor) {
		if (saldo >= valor) {
			saldo -= valor;
			imprimirExtrato("Saque de " + valor);
		} else {
			System.out.println("Saldo insuficiente.");
		}
	}

	public void depositar(double valor) {
		this.saldo += valor;
		imprimirExtrato("Depósito de " + valor);
	}

	public void transferir(Conta destino, double valor) {
		if (saldo >= valor) {
			saldo -= valor;
			destino.depositar(valor);
			imprimirExtrato("Transferência de " + valor + " para " + destino.getTitular());
		} else {
			System.out.println("Saldo insuficiente para transferência.");
		}
	
	}
	
	public void imprimirExtrato(String acao) {
		Date data = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM HH:mm");
		String dataFormatada = dateFormat.format(data);
		String idFormatado = String.format("%04d", Pessoa.getId());
		System.out.println(dataFormatada + " - " + this.numero + this.tipo + idFormatado + " - " + acao);
	}
}