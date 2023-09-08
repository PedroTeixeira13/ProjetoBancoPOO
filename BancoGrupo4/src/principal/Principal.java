package principal;

import java.util.Scanner; 
import pessoas.Cliente;

public class Principal {
	public static void main(String[] args) {
		String caminho = "C:\\Serratec\\POO\\Trabalho em grupo\\ProjetoBancoPOO\\BancoGrupo4\\src\\dados\\teste.txt";
		String nome;
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite seu nome: \n");
		nome = sc.nextLine();
		
		
		
		// Cliente c = new Cliente (nome, "12345697810", "pedra123");
//		Pessoa c1 = new Cliente("Arthur","12345678910", "gelo123");
//		Pessoa c2 = new Cliente("Pedro", "01987654321", "areia123";
		sc.close();
	}
}
