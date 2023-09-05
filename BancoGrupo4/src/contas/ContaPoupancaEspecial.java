package contas;

public class ContaPoupancaEspecial extends ContaPoupanca {
    private String cartaoDebito;

    public String getCartaoDebito() {
        return cartaoDebito;
    }

    public ContaPoupancaEspecial() {
        this.tipo = "CPE";
    }

    public ContaPoupancaEspecial(int numero, String titular, double saldo, double rendimento, String cartaoDebito) {
        super(numero, titular, saldo, rendimento);
        this.tipo = "CPE";
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.rendimento = rendimento;
        this.cartaoDebito = cartaoDebito;
    }

    @Override
    public boolean sacar(double valor) {
        throw new UnsupportedOperationException("Unimplemented method 'sacar'");
    }

    @Override
    public void depositar(double valor) {
        throw new UnsupportedOperationException("Unimplemented method 'depositar'");
    }

    @Override
    public boolean transferir(Conta destino, double valor) {
        throw new UnsupportedOperationException("Unimplemented method 'transferir'");
    }

	@Override
	public String toString() {
		return "ContaPoupancaEspecial [cartaoDebito=" + cartaoDebito + ", rendimento=" + rendimento + ", numero="
				+ numero + ", titular=" + titular + ", saldo=" + saldo + ", tipo=" + tipo + ", getCartaoDebito()="
				+ getCartaoDebito() + ", getNumero()=" + getNumero() + ", getTitular()=" + getTitular()
				+ ", getSaldo()=" + getSaldo() + ", getTipo()=" + getTipo() + "]";
	}
}