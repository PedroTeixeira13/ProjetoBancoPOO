package movimentacoes;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import contas.Conta;

public class Operacoes {
	static Scanner sc = new Scanner(System.in);

	static public void saqueOP(Conta c) throws InterruptedException {
		
		try {
			System.out.print("Qual o valor que deseja sacar: ");
			double valor = sc.nextDouble();
			if (valor < c.getSaldo() + c.getTaxSaque()) {
				c.sacar(valor);
				Thread.sleep(500);
				System.out.println("Saque de R$" + valor + " realizado com sucesso!\n");
				System.out.println("Seu novo saldo é: R$" + c.getSaldo());
			} else {
				System.out.println("Saldo insuficiente!\n");
				System.out.println("Seu saldo atual é de: R$" + c.getSaldo());
			}
			Thread.sleep(2000);
		} catch (InputMismatchException error) {
			System.out.println("O valor deve ser um número real");
		}
	}

	static public void depositoOP(Conta c) throws InterruptedException {
		
		System.out.print("Qual o valor que deseja depositar: ");
		double valor = sc.nextDouble();
		if (valor > 0) {
			c.depositar(valor);
			Thread.sleep(500);
			System.out.println("Depósito de R$" + valor + " realizado com sucesso!\n");
			System.out.println("Seu novo saldo é: R$" + c.getSaldo());
		} else {
			System.out.println("O valor para depósito deve ser maior que zero\n");
			System.out.println("Seu saldo atual é de: R$" + c.getSaldo());
		}
	}
	
	static public void transferenciaOP(Conta c, List<Conta> listaConta) throws InterruptedException {
		
		Conta cDestino = null;
		System.out.print("Digite o CPF da conta destino: ");
		String destino = sc.next();
		System.out.print("\nQual o valor que deseja transferir: ");
		double valor2 = sc.nextDouble();

		for (int i = 0; i < listaConta.size(); i++) {
			cDestino = listaConta.get(i);
			if (cDestino.getCpfTitular().equals(destino)) {
				cDestino = listaConta.get(i);
			}
			if (cDestino == null) {
				System.out.println("Conta não existe!");
			}
		}
		if (valor2 < c.getSaldo() + c.getTaxTransferencia() && valor2 > 0) {
			c.transferir(cDestino, valor2);
			System.out.println("Transferência de R$" + valor2 + " para a conta " + cDestino.getCpfTitular()
					+ " realizado com sucesso!\n");
			System.out.println("Seu novo saldo é: R$" + c.getSaldo());
		} else {
			System.out.println("Saldo insuficiente ou valor mínimo para transferência não atingido\n");
			System.out.println("Seu saldo atual é de: R$" + c.getSaldo());
		}
	} 

	public static void seguroOP (Conta c)throws Exception {
		try{
			System.out.println("Qual valor você quer assegurar:");
			double valor = sc.nextDouble();
			if (c.getSaldo() >= (valor * c.getTaxaSeguro())){
				c.seguro(valor);
				System.out.println("R$"+ valor + " assegurados com sucesso!");
				System.out.println("Seu saldo atual é de: R$" + c.getSaldo());
				Thread.sleep(500);
			}else{
				System.out.println("Saldo insuficiente!");
				System.out.println("Seu saldo atual é de: R$" + c.getSaldo());
			}
		}catch(InputMismatchException error){
			System.out.println("O valor deve ser um número real");
		}
	}
	
	public static void agenciaOP(Conta c, int[]totalAg) throws IOException {
		if(c.getAgencia() == (0001)) {
			System.out.println("Você gere " + totalAg[0] + " contas ");
		}else if(c.getAgencia() == 0002){
			System.out.println("Você gere " + totalAg[1] + " contas ");
		}else {
			System.out.println("Número da agência da sua conta é invalido. ");
		}
	}
}
