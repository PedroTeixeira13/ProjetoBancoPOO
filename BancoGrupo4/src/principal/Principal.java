package principal;

import pessoas.Cliente;
import pessoas.Diretor;
import pessoas.Gerente;
import pessoas.Pessoa;

public class Principal {
	public static void main(String[] args) {
		
		String caminho = "C:\\Serratec\\POO\\Trabalho em grupo\\ProjetoBancoPOO\\BancoGrupo4\\src\\dados\\teste.txt";
		
		Pessoa c = new Cliente("Vitor","12345678910","Cliente","1111");
		Pessoa d = new Diretor("Arthur","32165498701","Diretor","2222");
		Pessoa g = new Gerente("Pedro","32145698710","Gerente","3333");
	}
}
