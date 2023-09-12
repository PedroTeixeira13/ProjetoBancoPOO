package menu;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import contas.Conta;
import enums.PessoaE;
import pessoas.Pessoa;
import relatorios.RelContaCorrente;

public class MenuInterativo {
	static Scanner sc = new Scanner(System.in);
	static double valor;

	public static void menu(List<Pessoa> listaPessoa, List<Conta> listaConta) throws Exception {

		String cpf;
		Pessoa p = null, p1 = null;
		Conta c = null, c1 = null;
		boolean continua = true;

		try {
			do {
				System.out.println("Digite seu CPF: ");
				cpf = sc.next();
				System.out.println("Digite sua senha: ");
				String senha = sc.next();
				for (int i = 0; i < listaConta.size(); i++) {
					c1 = listaConta.get(i);
					if (c1.getCpfTitular().equals(cpf)) {
						c = listaConta.get(i);
					}
				}
				for (int i = 0; i < listaPessoa.size(); i++) {
					p1 = listaPessoa.get(i);
					if (p1.getCpf().equals(cpf)) {
						p = listaPessoa.get(i);
					}
				}

				if (p.getCpf().equals(cpf) && p.getCargo().equals(PessoaE.Cliente.name())) {
					if (p.getCpf().equals(cpf) && p.getSenha().equals(senha)) {
						System.out.println("\n\nOlá " + p.getNome() + "!");
						menuCliente(listaPessoa, p, c, listaConta);
						continua = false;
					} else {
						System.out.println("Credenciais nao encontradas");
						menu(listaPessoa, listaConta);
					}

				} else if (p.getCpf().equals(cpf) && p.getCargo().equals(PessoaE.Gerente.name())) {
					if (p.getCpf().equals(cpf) && p.getSenha().equals(senha)) {
						System.out.println("\n\nOlá " + p.getNome() + "!");
						// menuGerente(listaPessoa,p,c,listaConta)
						continua = false;
					} else {
						System.out.println("Credenciais nao encontradas");
						menu(listaPessoa, listaConta);
					}

				} else if (p.getCpf().equals(cpf) && p.getCargo().equals(PessoaE.Diretor.name())) {
					if (p.getCpf().equals(cpf) && p.getSenha().equals(senha)) {
						System.out.println("\n\nOlá " + p.getNome() + "!");
						// menuDiretor(listaPessoa,p,c,listaConta)
						continua = false;
					} else {
						System.out.println("Credenciais nao encontradas");
						menu(listaPessoa, listaConta);
					}

				} else if (p.getCpf().equals(cpf) && p.getCargo().equals(PessoaE.Presidente.name())) {
					if (p.getCpf().equals(cpf) && p.getSenha().equals(senha)) {
						System.out.println("\n\nOlá " + p.getNome() + "!");
						// menuPresidente(listaPessoa,p,c,listaConta)
						continua = false;
					} else {
						System.out.println("Credenciais nao encontradas");
						menu(listaPessoa, listaConta);
					}
				}
			} while (continua);

		} catch (NullPointerException error) {
			System.out.println("Credenciais nao encontradas");
			menu(listaPessoa, listaConta);
		}
	}

	public static void menuCliente(List<Pessoa> listaPessoa, Pessoa p, Conta c, List<Conta> listaConta)
			throws Exception {
		Locale.setDefault(Locale.US);
		int op;
		double valor;
		boolean continua;

		do {
			System.out.print("\nBem-vindo ao Serra Bank!\n");
			System.out.println("1 - Movimentações na Conta");
			System.out.println("2 - Relatórios");
			System.out.println("3 - Sair");
			System.out.print("Escolha uma opção: ");
			op = sc.nextInt();
			switch (op) {
			case 1:
				movimentacoesConta(c, listaConta);
				break;
			case 2:
				relatorios(c);
				break;
			}

		} while (op != 3);
	}

	public static void movimentacoesConta(Conta c, List<Conta> listaConta) throws InterruptedException {
		int opcao;
		do {
			System.out.println("\nMovimentações na Conta");
			System.out.println("1 - Saque");
			System.out.println("2 - Depósito");
			System.out.println("3 - Transferência para outra conta");
			System.out.println("4 - Voltar");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				try {
					System.out.print("Qual o valor que deseja sacar: ");
					valor = sc.nextDouble();
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
				break;
			case 2:
				System.out.print("Qual o valor que deseja depositar: ");
				valor = sc.nextDouble();
				if (valor > 0) {
					c.depositar(valor);
					Thread.sleep(500);
					System.out.println("Depósito de R$" + valor + " realizado com sucesso!\n");
					System.out.println("Seu novo saldo é: R$" + c.getSaldo());
				} else {
					System.out.println("O valor para depósito deve ser maior que zero\n");
					System.out.println("Seu saldo atual é de: R$" + c.getSaldo());
				}
				break;
			case 3:
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
					System.out.println("Transferência de R$" + valor2 + " para " + cDestino.getCpfTitular()
							+ " realizado com sucesso!\n");
					System.out.println("Seu novo saldo é: R$" + c.getSaldo());
				} else {
					System.out.println("Saldo insuficiente ou valor mínimo para transferência não atingido\n");
					System.out.println("Seu saldo atual é de: R$" + c.getSaldo());
				}
				break;

			}

		} while (opcao != 4);
	}

	public static void relatorios(Conta c) throws Exception {
		int opcao2;
		do {
			System.out.println("\nRelatórios");
			System.out.println("1 - Saldo");
			System.out.println("2 - Relatório de tributação da conta corrente");
			System.out.println("3 - Relatório de Rendimento da poupança");
			System.out.println("4 - Contratar seguro de vida");
			System.out.println("5 - Voltar");
			System.out.print("Escolha uma opção: ");
			opcao2 = sc.nextInt();
			switch (opcao2) {
			case 1:
				System.out.println("\n\nSaldo em conta: " + c.getSaldo() + "\n\n");
				Thread.sleep(2000);
				break;
			case 2:  
				RelContaCorrente.relatorioCC(c);
				break;
			case 3:
				System.out.println("Digite o valor: ");
				valor = sc.nextDouble();
				System.out.println("Digite a quantidade de dias: ");
				int dias = sc.nextInt();
				double total = valor * dias * 0.003;
				System.out.println("Seu rendimento em " + dias + " será: R$" + total);
				break;
			case 4: // Desafio seguro de vida
				break;
			}

		} while (opcao2 != 5);
	}
}
