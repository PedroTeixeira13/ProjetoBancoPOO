package contas;

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

    public abstract boolean sacar(double valor);
	
	public abstract void depositar(double valor);
	
	public abstract boolean transferir(Conta destino, double valor);

}