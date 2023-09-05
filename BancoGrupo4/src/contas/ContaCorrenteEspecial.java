package contas;

public class ContaCorrenteEspecial extends ContaCorrente {
    private String cartaoCredito;
	private double investimento;

    public String getCartaoCredito() {
        return cartaoCredito;
    }

    public double getInvestimento() {
        return investimento;
    }

    public ContaCorrenteEspecial() {
    }

    public ContaCorrenteEspecial(int numero, String titular, double tarifa, double limite, String cartaoCredito, double investimento) {
        super();
        this.numero = numero;
        this.titular = titular;
        this.tarifa = tarifa;
        this.limite = limite;
        this.tipo = "CCE";
        this.cartaoCredito = cartaoCredito;
        this.investimento = investimento;
    }

	@Override
	public String toString() {
		return "ContaCorrenteEspecial [cartaoCredito=" + cartaoCredito + ", investimento=" + investimento + ", tarifa="
				+ tarifa + ", limite=" + limite + ", numero=" + numero + ", titular=" + titular + ", saldo=" + saldo
				+ ", tipo=" + tipo + ", getCartaoCredito()=" + getCartaoCredito() + ", getInvestimento()="
				+ getInvestimento() + ", getTarifa()=" + getTarifa() + ", getLimite()=" + getLimite() + ", getNumero()="
				+ getNumero() + ", getTitular()=" + getTitular() + ", getSaldo()=" + getSaldo() + ", getTipo()="
				+ getTipo() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}