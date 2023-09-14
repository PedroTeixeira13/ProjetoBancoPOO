package movimentacoes;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import contas.Conta;

public class Operacoes {
	static Scanner sc = new Scanner(System.in);

	static public String saqueOP(Conta c) throws InterruptedException {
		
		try {
			Thread.sleep(700);
			System.out.printf("\nSeu saldo atual é de: R$%.2f\n", c.getSaldo());
			System.out.print("Qual o valor que deseja sacar: R$");
			double valor = sc.nextDouble();
			if (valor < c.getSaldo() + c.getTaxSaque()) {
				c.sacar(valor);
				Thread.sleep(500);
				System.out.println("\nSaque de R$" + valor + " realizado com sucesso!");
				System.out.printf("Seu novo saldo é de: R$%.2f\n", c.getSaldo());
				Thread.sleep(1000);
				return "Saque de R$" + valor + " realizado com sucesso!\n";
			} else {
				System.out.println("\nSaldo insuficiente!\n");
				System.out.printf("Seu saldo atual é de: R$%.2f\n", c.getSaldo());
				return "";
			}
		} catch (InputMismatchException error) {
			System.out.println("O valor deve ser um número real");
			return "";
		}
	}

	static public String depositoOP(Conta c) throws InterruptedException {
		
		System.out.printf("\nSeu saldo atual é de: R$%.2f\n", c.getSaldo());
		System.out.print("Qual o valor que deseja depositar: R$");
		double valor = sc.nextDouble();
		if (valor > 0) {
			c.depositar(valor);
			Thread.sleep(500);
			System.out.println("\nDepósito de R$" + valor + " realizado com sucesso!");
			System.out.printf("Seu novo saldo é de: R$%.2f\n", c.getSaldo());
			return "Depósito de R$" + valor + " realizado com sucesso!\n";
		} else {
			System.out.println("\nO valor para depósito deve ser maior que zero\n");
			System.out.printf("Seu saldo atual é de: R$%.2f\n", c.getSaldo());
			return "";
		}
	}
	
	static public String transferenciaOP(Conta c, List<Conta> listaConta) throws InterruptedException {
		Conta cDestino = null, c2 = null;
		System.out.printf("\nSeu saldo atual é de: R$%.2f\n", c.getSaldo());
		System.out.print("\nDigite o CPF do titular da conta destino: ");
		String destino = sc.next();
		System.out.print("Qual o valor que deseja transferir: R$");
		double valor2 = sc.nextDouble();

		for (int i = 0; i < listaConta.size(); i++) {
			c2 = listaConta.get(i);
			if (c2.getCpfTitular().equals(destino)) {
				cDestino = listaConta.get(i);
			}
			
		}
		
		if (cDestino == null) {
			System.out.println("Conta não existe!");
		}
		
		else if (valor2 < c.getSaldo() + c.getTaxTransferencia() && valor2 > 0) {
			c.transferir(cDestino, valor2);
			System.out.println("\nTransferência de R$" + valor2 + " para a conta do CPF: " + destino
					+ " realizada com sucesso!");
			System.out.printf("Seu novo saldo é de: R$%.2f\n", c.getSaldo());
			return "Tranferência de " + valor2 + " para a conta do CPF: " + destino + ".\n";
		} else {
			System.out.println("\nSaldo insuficiente ou valor mínimo para transferência não atingido\n");
			System.out.printf("Seu saldo atual é de: R$%.2f\n", c.getSaldo());
			return "";
		}
		return destino;
	} 

	public static String seguroOP (Conta c) throws Exception {
		try{
			System.out.printf("\nSeu saldo atual é de: R$%.2f\n", c.getSaldo());
			System.out.print("Qual valor você quer assegurar: ");
			double valor = sc.nextDouble();
			if (c.getSaldo() >= (valor * c.getTaxaSeguro())){
				c.seguro(valor);
				System.out.println("\nR$"+ valor + " assegurados com sucesso!");
				System.out.printf("Seu novo saldo é de: R$%.2f\n", c.getSaldo());
				Thread.sleep(500);
				return "Seguro de vida no valor de " + valor + " realizado!\n";
			}else{
				System.out.println("\nSaldo insuficiente!");
				System.out.printf("Seu saldo atual é de: R$%.2f\n", c.getSaldo());
				return "";
			}
		}catch(InputMismatchException error){
			System.out.println("O valor deve ser um número real");
			seguroOP(c);
			return "";
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
