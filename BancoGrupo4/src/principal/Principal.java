package principal;

import contas.ContaCorrente; 
import contas.ContaPoupanca;
import pessoas.Cliente;

public class Principal {
	public static void main(String[] args) {

		Cliente cliente1 = new Cliente("Arthur", "176.853.543-32", 0001, "seila1234", "Cliente");
		Cliente cliente2 = new Cliente("Fulano", "129.876.543-21", 0002, "naosei987", "Cliente");
		System.out.println("--------- Demonstração ---------\n");
		
		ContaCorrente contaCorrente1 = new ContaCorrente(123456789, cliente1.getNome(), 1000.0, 5.0, 1000.0);
		ContaPoupanca contaPoupanca1 = new ContaPoupanca(237361450, cliente1.getNome(), 5000.0, 2.5);

		ContaCorrente contaCorrente2 = new ContaCorrente(123456789, cliente2.getNome(), 2000.0, 5.0, 1500.0);
		ContaPoupanca contaPoupanca2 = new ContaPoupanca(135792460, cliente2.getNome(), 8000.0, 2.5);

		contaCorrente1.sacar(contaCorrente1, 500.0);
		contaCorrente1.transferir(contaCorrente1, contaCorrente2, 100.0);
		contaPoupanca1.aplicarRendimento();
		
		System.out.println();
		contaCorrente2.depositar(contaCorrente2, 400.0);
		contaCorrente2.sacar(contaCorrente2, 100.0);
		contaCorrente2.transferir(contaCorrente2, contaCorrente1, 200.0);
		contaPoupanca2.aplicarRendimento();
	
	}
}