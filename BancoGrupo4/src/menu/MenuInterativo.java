package menu;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import contas.Conta;
import dados.SobrescreveDados;
import enums.PessoaE;
import exceptions.CredenciaisNaoEncontradasException;
import movimentacoes.Operacoes;
import pessoas.Pessoa;
import relatorios.RelContaCorrente;
import relatorios.RelContaPoupanca;
import relatorios.RelatorioDiretor;
import relatorios.RelatorioPresidente;

public class MenuInterativo {
	static double valor;
	static Scanner sc = new Scanner(System.in);
	static String extrato = "SERRA BANK\n\n";

	public static void menu(List<Pessoa> listaPessoa, List<Conta> listaConta, int[] totalAg) throws Exception {
		Locale.setDefault(Locale.US);
		String cpf = "";
		String senha = "";
		Pessoa p = null, p1 = null;
		Conta c = null, c1 = null;
		boolean continua = true;

		try {
			do {
				System.out.println("----Login----\n");
				System.out.print("Digite seu CPF: ");
				cpf = sc.next();
				System.out.print("Digite sua senha: ");
				senha = sc.next();
				System.out.println("\n-------------\n");
				Thread.sleep(700);
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
					System.out.println("Logado como " + p.getCargo());
					Thread.sleep(700);
					System.out.print("\n-------------\n");
					System.out.println("\nSeja Bem-vindo(a) " + p.getNome() + "!\n");
					System.out.print("-------------\n\n\n");
					if (p.getCargo().equals(PessoaE.Cliente.name())) {
						menuCliente(listaPessoa, p, c, listaConta);
					} else if (p.getCargo().equals(PessoaE.Gerente.name())) {
						menuGerente(listaPessoa, p, c, listaConta, totalAg);
					} else if (p.getCargo().equals(PessoaE.Diretor.name())) {
						menuDiretor(listaPessoa, p, c, listaConta);
					} else if (p.getCargo().equals(PessoaE.Presidente.name())) {
						menuPresidente(listaPessoa, p, c, listaConta);
					}
				} else {
					System.out.println("Senha incorreta, tente novamemente!");
					menu(listaPessoa, listaConta, totalAg);
				}

				continua = false;
			} while (continua);

		} catch (NullPointerException error) {
			throw new CredenciaisNaoEncontradasException(listaPessoa, listaConta, totalAg);
		}
	}

	public static void menuCliente(List<Pessoa> listaPessoa, Pessoa p, Conta c, List<Conta> listaConta)
			throws Exception {
		Locale.setDefault(Locale.US);
		int opcao = 0;
		do {
			Thread.sleep(700);
			System.out.println("Menu Inicial");
			System.out.print("-------------\n");
			System.out.println("1 - Movimentações na Conta");
			System.out.println("2 - Relatórios");
			System.out.println("3 - Sair");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();
			System.out.print("-------------\n\n\n");
			switch (opcao) {
				case 1:
					movimentacoesConta(c, listaConta, listaPessoa);
					break;
				case 2:
					relatorios(c);
					break;
				case 3:
					imprimeExtrato(extrato, c.getCpfTitular());
					Menu.sair();
					break;
				default:
					System.out.println("Opcão inválida, tente novamente!");
					break;
			}

		} while (opcao != 3);
		SobrescreveDados.sobrescrita(listaConta, listaPessoa);
	}

	public static void menuGerente(List<Pessoa> listaPessoa, Pessoa p, Conta c, List<Conta> listaConta, int[] totalAg)
			throws Exception {
		Locale.setDefault(Locale.US);
		int opcao = 0;
		do {
			Thread.sleep(700);
			System.out.println("Menu Inicial");
			System.out.print("-------------\n");
			System.out.println("1 - Movimentações na Conta");
			System.out.println("2 - Relatórios");
			System.out.println("3 - Relatórios gerenciais");
			System.out.println("4 - Sair");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();
			System.out.print("-------------\n\n\n");
			switch (opcao) {
				case 1:
					movimentacoesConta(c, listaConta, listaPessoa);
					break;
				case 2:
					relatorios(c);
					break;
				case 3:
					Operacoes.agenciaOP(c, totalAg);
					break;
				case 4:
					imprimeExtrato(extrato, c.getCpfTitular());
					Menu.sair();
					break;
				default:
					System.out.println("Opcão inválida, tente novamente!");
					break;
			}

		} while (opcao != 4);
		SobrescreveDados.sobrescrita(listaConta, listaPessoa);
	}

	public static void menuDiretor(List<Pessoa> listaPessoa, Pessoa p, Conta c, List<Conta> listaConta)
			throws Exception {
		Locale.setDefault(Locale.US);
		int opcao = 0;
		do {
			Thread.sleep(700);
			System.out.println("Menu Inicial");
			System.out.print("-------------\n");
			System.out.println("1 - Movimentações na Conta");
			System.out.println("2 - Relatórios");
			System.out.println("3 - Relatório diretoria");
			System.out.println("4 - Sair");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();
			System.out.print("-------------\n\n\n");
			switch (opcao) {
				case 1:
					movimentacoesConta(c, listaConta, listaPessoa);
					break;
				case 2:
					relatorios(c);
					break;
				case 3:
					RelatorioDiretor.infoCliente(listaConta, listaPessoa);
					break;
				case 4:
					imprimeExtrato(extrato, c.getCpfTitular());
					Menu.sair();
					break;
				default:
					System.out.println("Opcão inválida, tente novamente!");
					break;
			}
		} while (opcao != 4);
		SobrescreveDados.sobrescrita(listaConta, listaPessoa);
	}

	public static void menuPresidente(List<Pessoa> listaPessoa, Pessoa p, Conta c, List<Conta> listaConta)
			throws Exception {
		Locale.setDefault(Locale.US);
		int opcao = 0;
		do {
			Thread.sleep(700);
			System.out.println("Menu Inicial");
			System.out.print("-------------\n");
			System.out.println("1 - Movimentações na Conta");
			System.out.println("2 - Relatórios");
			System.out.println("3 - Relatórios presidenciais");
			System.out.println("4 - Sair");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();
			System.out.print("-------------\n\n\n");
			switch (opcao) {
				case 1:
					movimentacoesConta(c, listaConta, listaPessoa);
					break;
				case 2:
					relatorios(c);
					break;
				case 3:
					RelatorioPresidente.informacaoCliente(c, listaConta);
					break;
				case 4:
					imprimeExtrato(extrato, c.getCpfTitular());
					Menu.sair();
					break;
				default:
					System.out.println("Opcão inválida, tente novamente!");
					break;
			}
		} while (opcao != 4);
		SobrescreveDados.sobrescrita(listaConta, listaPessoa);
	}

	public static void movimentacoesConta(Conta c, List<Conta> listaConta, List<Pessoa> listaPessoa) throws Exception {
		Locale.setDefault(Locale.US);
		int opcao = 0;
		do {
			Thread.sleep(700);
			System.out.println("\nMovimentações na Conta");
			System.out.print("-------------\n");
			System.out.println("1 - Saque");
			System.out.println("2 - Depósito");
			System.out.println("3 - Transferência para outra conta");
			System.out.println("4 - Voltar");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();
			System.out.print("-------------\n\n\n");
			switch (opcao) {
				case 1:
					extrato += Operacoes.saqueOP(c);
					SobrescreveDados.sobrescrita(listaConta, listaPessoa);
					break;
				case 2:
					extrato += Operacoes.depositoOP(c);
					SobrescreveDados.sobrescrita(listaConta, listaPessoa);
					break;
				case 3:
					extrato += Operacoes.transferenciaOP(c, listaConta);
					SobrescreveDados.sobrescrita(listaConta, listaPessoa);
					break;
				case 4:
					System.out.print("\n-------------\n");
					System.out.println("Voltando...");
					System.out.print("-------------\n\n\n");
					Thread.sleep(600);
					break;
				default:
					System.out.println("Opcão inválida, tente novamente!");
					break;
			}

		} while (opcao != 4);
	}

	public static void imprimeExtrato(String extrato, String cpf) throws IOException, InterruptedException {
		String dataHoraCompleta = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

		if (extrato.equals("SERRA BANK\n\n")) {
			Thread.sleep(10);
		} else {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("BancoGrupo4\\src\\relatorios\\extrato" + cpf + dataHoraCompleta + ".txt"));
				bw.append(extrato);
				bw.close();
			} catch (FileNotFoundException FNFError) {
				BufferedWriter bw = new BufferedWriter(new FileWriter(".\\src\\relatorios\\extrato" + cpf + dataHoraCompleta + ".txt"));
				bw.append(extrato);
				bw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void relatorios(Conta c) throws Exception {
		Locale.setDefault(Locale.US);
		int opcao = 0;
		do {
			Thread.sleep(700);
			System.out.println("Relatórios");
			System.out.print("-------------\n");
			System.out.println("1 - Saldo");
			System.out.println("2 - Relatório de tributação da conta corrente");
			System.out.println("3 - Relatório de Rendimento da poupança");
			System.out.println("4 - Contratar seguro de vida");
			System.out.println("5 - Voltar");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();
			System.out.print("-------------\n");
			switch (opcao) {
				case 1:
					System.out.println("\n\nSaldo em conta: " + c.getSaldo() + "\n\n");
					Thread.sleep(600);
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
				case 5:
					System.out.print("\n-------------\n");
					System.out.println("Voltando...");
					System.out.print("-------------\n\n\n");
					Thread.sleep(600);
					break;
				default:
					System.out.println("Opcão inválida, tente novamente!");
					break;
			}

		} while (opcao != 5);
	}
}
