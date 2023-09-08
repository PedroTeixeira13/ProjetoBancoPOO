package menu;

import java.util.List;
import java.util.Scanner;

import contas.Conta;
import pessoas.Pessoa;

public class MenuInterativo {
	static Scanner sc = new Scanner (System.in);
	static String cpf;
	
	public static void menu (List<Pessoa> listaPessoa, List<Conta> listaConta) throws Exception {
		boolean continua = true; 
		Pessoa p = null, p1 = null;
		Conta c = null, c1 = null;
		
		
		do {
			try {
				Menu.logo();
				System.out.println("Digite seu CPF: ");
				cpf = sc.next();
				System.out.println("Digite sua senha: ");
				String senha = sc.next();
				
				for (int i = 0; i<listaPessoa.size(); i++) {
					p1 = listaPessoa.get(i);
					if (p1.getCpf() == cpf) {
						p = listaPessoa.get(i);
					}
				}
				for (int i = 0; i<listaConta.size(); i++) {
					c1 = listaConta.get(i);
					if (c1.getCpfTitular() == cpf) {
						c = listaConta.get(i);
						
					}
					
				}
				
			}
			
		}while(continua);
	}

}
