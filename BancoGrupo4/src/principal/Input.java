package principal;

import java.util.Scanner;

public class Input {
	
	protected String nome;
	protected String cpf;
	protected String id;
	protected int senha;
	protected String tipo;
	
	protected void Scan(){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Já é cadastrado (y/n): ");
		char op = sc.next().charAt(0);
		if(op == 'y') {
			System.out.println("----- LOGIN -----\n");
			System.out.print("Cpf: ");
			this.cpf = sc.nextLine();
			System.out.print("Senha: ");
			this.senha = sc.nextInt();
			sc.nextLine();
		}
		
		else {
			System.out.println("----- CADASTRO -----");
			System.out.println("Nome: ");
			this.nome = sc.nextLine();
			System.out.print("Cpf: ");
			this.cpf = sc.nextLine();
			System.out.print("Senha: ");
			this.senha = sc.nextInt();
			sc.nextLine();
			
			sc.close();
		}
			
	}
	
}





