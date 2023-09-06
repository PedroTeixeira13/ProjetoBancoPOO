package contas;

public class ContaPoupancaEspecial extends ContaPoupanca {
	private String cartaoDebito;

	public String getCartaoDebito() {
		return cartaoDebito;
	}

	public ContaPoupancaEspecial(int numero, String titular, double saldo, double rendimento, String cartaoDebito) {
		super(numero, titular, saldo, rendimento);
		this.tipo = "CPE";
		this.cartaoDebito = cartaoDebito;
	}

	@Override
	public void sacar(double valor) {
		this.saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		this.saldo += valor;
	}

	@Override
	public void transferir(Conta destino, double valor) {
		throw new UnsupportedOperationException("Unimplemented method 'transferir'");
	}

//	@Override
//	public String toString() {
//		return "ContaPoupancaEspecial [cartaoDebito=" + cartaoDebito + ", rendimento=" + rendimento + ", numero="
//				+ numero + ", titular=" + titular + ", saldo=" + saldo + ", tipo=" + tipo + ", getCartaoDebito()="
//				+ getCartaoDebito() + ", getNumero()=" + getNumero() + ", getTitular()=" + getTitular()
//				+ ", getSaldo()=" + getSaldo() + ", getTipo()=" + getTipo() + "]";
//	}
}