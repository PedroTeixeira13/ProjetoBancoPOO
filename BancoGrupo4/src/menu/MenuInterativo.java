package menu;

import java.util.List;
import java.util.Scanner;

import contas.Conta;
import enums.PessoaE;
import pessoas.Pessoa;
import relatorios.RelContaCorrente;

public class MenuInterativo {

	static Scanner sc = new Scanner(System.in);
	static String cpf;

	public static void menu(List<Pessoa> listaPessoa, List<Conta> listaConta) throws Exception {
		Pessoa p = null, p1 = null;
		Conta c = null, c1 = null;

		boolean continua = true;
		do {
			try {
				Menu.logo();
				System.out.println("Digite seu CPF: ");
				cpf = sc.next();
				System.out.println("Digite sua senha: ");
				String senha = sc.next();

				for (int i = 0; i < listaPessoa.size(); i++) {
					p1 = listaPessoa.get(i);
					if (p1.getCpf().equals(cpf)) {
						p = listaPessoa.get(i);
					}
				}

				for (int i = 0; i < listaConta.size(); i++) {
					c1 = listaConta.get(i);
					if (c1.getCpfTitular().equals(cpf)) {
						c = listaConta.get(i);
					}
				}

				System.out.println("\n\nOlá " + p.getNome() + "!");

				if (p.getCpf().equals(cpf) && p.getSenha().equals(senha) && p.getCargo().equals(PessoaE.Cliente.name())) {
					menuCliente(listaPessoa,p,c,listaConta);
				} else if (p.getCpf().equals(cpf) && p.getSenha().equals(senha)	&& p.getCargo().equals(PessoaE.Gerente.name())) {
					// menuGerente(listaPessoa,p,c,listaConta)
				} else if (p.getCpf().equals(cpf) && p.getSenha().equals(senha) && p.getCargo().equals(PessoaE.Diretor.name())) {
					// menuDiretor(listaPessoa,p,c,listaConta)
				} else if (p.getCpf().equals(cpf) && p.getSenha().equals(senha) && p.getCargo().equals(PessoaE.Presidente.name())) {
					// menuPresidente(listaPessoa,p,c,listaConta)
				}

				continua = false;

				if (p.getSenha() != senha) {
					continua = true;
					System.out.println("Senha incorreta!");
				}

			} catch (NullPointerException error) {
				System.out.println("Cpf nao encontrado" + error.getMessage());
			}

		} while (continua);

	}

	public static void menuCliente(List<Pessoa> listaPessoa, Pessoa p, Conta c, List<Conta> listaConta) throws Exception {

		int op;

		Menu.logo();

		do {
			System.out.println("\tEscolha uma opção:");
			System.out.println("1 - Movimentações na Conta");
			System.out.println("2 - Relatórios");
			System.out.println("3 - Sair");
			op = sc.nextInt();
		
			switch (op) {
				case 1:
					int opcao;
					do {
						System.out.println("\tEscolha uma opção:");
						System.out.println("1 - Saque");
						System.out.println("2 - Depósito");
						System.out.println("3 - Transferência para outra conta");
						System.out.println("4 - Sair");
						opcao = sc.nextInt();
						
						switch (opcao) {
						case 1:
							System.out.print("Qual o valor que deseja sacar: ");
							double valor = sc.nextDouble();
							c.sacar(valor);
						case 2:
							System.out.print("Qual o valor que deseja depositar: ");
							valor = sc.nextDouble();
							c.depositar(valor);
						case 3:
							Conta cDestino = null;
							System.out.print("Digite o Cpf da conta destino: ");
							String destino = sc.next();
							System.out.print("\nQual o valor que deseja transferir: ");
							valor = sc.nextDouble();
							
							for (int i = 0; i < listaConta.size(); i++) {
								cDestino = listaConta.get(i);
								if (cDestino.getCpfTitular().equals(destino)) {
									cDestino = listaConta.get(i);
								}
								if(cDestino == null) {
									System.out.println("Conta não existe!");
								}
							}
							c.transferir(cDestino, valor);
						}
					}while(opcao != 4);
					
				case 2:
					int opcao2;
					do {
						System.out.println("\tEscolha uma opção:");
						System.out.println("1 - Saldo");
						System.out.println("2 - Relatório de tributação da conta corrente");
						System.out.println("3 - Relatório de Rendimento da poupança");
						System.out.println("4 - Contratar seguro de vida");
						System.out.println("5 - Sair");
						opcao2 = sc.nextInt();
						switch(opcao2) {
						case 1:
							System.out.println("Saldo atual: "+ c.getSaldo());
						case 2:
						RelContaCorrente.relatorioCC(c);
						
						case 3: 
							//Relatório de Rendimento da poupança
						case 4:
							//Desafio seguro de vida
						}
						
					}while(opcao2 != 5);
				}
			
		}while (op != 3);

	}
	
}
