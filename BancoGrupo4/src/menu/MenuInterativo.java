package menu;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import contas.Conta;
import enums.PessoaE;
import movimentacoes.Operacoes;
import pessoas.Pessoa;
import relatorios.RelContaCorrente;
import relatorios.RelContaPoupanca;
import relatorios.RelatorioDiretor;
import relatorios.RelatorioPresidente;

public class MenuInterativo {
	static double valor;
	static Scanner sc = new Scanner(System.in);
	static int opcao;

	public static void menu(List<Pessoa> listaPessoa, List<Conta> listaConta, int[] totalAg) throws Exception {
		Locale.setDefault(Locale.US);
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

				if (p.getCpf().equals(cpf) && p.getSenha().equals(senha)) {
					System.out.println("\n\nOlá " + p.getNome() + "!");
					if (p.getCargo().equals(PessoaE.Cliente.name())) {
						menuCliente(listaPessoa, p, c, listaConta);
					} else if (p.getCargo().equals(PessoaE.Gerente.name())) {
						menuGerente(listaPessoa, p, c, listaConta, totalAg);
					} else if (p.getCargo().equals(PessoaE.Diretor.name())) {
						menuDiretor(listaPessoa, p, c, listaConta);
					} else if (p.getCargo().equals(PessoaE.Presidente.name())) {
						menuPresidente(listaPessoa, p, c, listaConta);
					}
				} else
					System.out.println("Senha incorreta");

			} while (continua);

		} catch (NullPointerException error) {
			System.out.println("Credenciais nao encontradas");
			menu(listaPessoa, listaConta, totalAg);
		}
	}

	public static void menuCliente(List<Pessoa> listaPessoa, Pessoa p, Conta c, List<Conta> listaConta)
			throws Exception {
		Locale.setDefault(Locale.US);
		do {
			System.out.print("\nBem-vindo ao Serra Bank!\n");
			System.out.println("1 - Movimentações na Conta");
			System.out.println("2 - Relatórios");
			System.out.println("3 - Sair");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();
			switch (opcao) {
				case 1:
					movimentacoesConta(c, listaConta);
					break;
				case 2:
					relatorios(c);
					break;
			}

		} while (opcao != 3);
	}

	public static void menuGerente(List<Pessoa> listaPessoa, Pessoa p, Conta c, List<Conta> listaConta, int[] totalAg)
			throws Exception {
		Locale.setDefault(Locale.US);
		do {
			System.out.print("\nBem-vindo ao Serra Bank!\n");
			System.out.println("1 - Movimentações na Conta");
			System.out.println("2 - Relatórios");
			System.out.println("3 - Relatórios gerenciais");
			System.out.println("4 - Sair");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();
			switch (opcao) {
				case 1:
					movimentacoesConta(c, listaConta);
					break;
				case 2:
					relatorios(c);
					break;
				case 3:
					Operacoes.agenciaOP(c, totalAg);
					break;
			}

		} while (opcao != 3);
	}

	public static void menuDiretor(List<Pessoa> listaPessoa, Pessoa p, Conta c, List<Conta> listaConta)
			throws Exception {
		Locale.setDefault(Locale.US);
		do {
			System.out.print("\nBem-vindo ao Serra Bank!\n");
			System.out.println("1 - Movimentações na Conta");
			System.out.println("2 - Relatórios");
			System.out.println("3 - Relatório diretoria");
			System.out.println("4 - Sair");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();
			switch (opcao) {
				case 1:
					movimentacoesConta(c, listaConta);
					break;
				case 2:
					relatorios(c);
					break;
				case 3:
					RelatorioDiretor.infoCliente(listaConta, listaPessoa);
					break;
			}

		} while (opcao != 3);
	}

	public static void menuPresidente(List<Pessoa> listaPessoa, Pessoa p, Conta c, List<Conta> listaConta)
			throws Exception {
		Locale.setDefault(Locale.US);
		do {
			System.out.print("\nBem-vindo ao Serra Bank!\n");
			System.out.println("1 - Movimentações na Conta");
			System.out.println("2 - Relatórios");
			System.out.println("3 - Relatórios presidenciais");
			System.out.println("4 - Sair");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();
			switch (opcao) {
				case 1:
					movimentacoesConta(c, listaConta);
					break;
				case 2:
					relatorios(c);
					break;
				case 3:
					RelatorioPresidente.informacaoCliente(c, listaConta);
					break;
			}

		} while (opcao != 3);
	}

	public static void movimentacoesConta(Conta c, List<Conta> listaConta) throws InterruptedException {
		Locale.setDefault(Locale.US);
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
					Operacoes.saqueOP(c);
					break;
				case 2:
					Operacoes.depositoOP(c);
					break;
				case 3:
					Operacoes.transferenciaOP(c, listaConta);
					break;
			}

		} while (opcao != 4);
	}

	public static void relatorios(Conta c) throws Exception {
		Locale.setDefault(Locale.US);
		do {
			System.out.println("\nRelatórios");
			System.out.println("1 - Saldo");
			System.out.println("2 - Relatório de tributação da conta corrente");
			System.out.println("3 - Relatório de Rendimento da poupança");
			System.out.println("4 - Contratar seguro de vida");
			System.out.println("5 - Voltar");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();
			switch (opcao) {
				case 1:
					System.out.println("\n\nSaldo em conta: " + c.getSaldo() + "\n\n");
					Thread.sleep(2000);
					break;
				case 2:
					RelContaCorrente.relatorioCC(c);
					break;
				case 3:
					RelContaPoupanca.relatorioCP(c);
					break;
				case 4:
					Operacoes.seguroOP(c);
					break;
			}

		} while (opcao != 5);
	}

}
