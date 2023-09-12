package principal;

import java.util.ArrayList;
import java.util.List;

import contas.Conta;
import dados.PegaDados;
import menu.Menu;
import menu.MenuInterativo;
import pessoas.Pessoa;

public class Principal {
	public static void main(String[] args) {
		
		String caminho = ".\\src\\dados\\teste.txt";	
		List<Pessoa> listaPessoa = new ArrayList<>();
        List<Conta> listaConta = new ArrayList<>();
        
		Menu.logo();
        try {
			PegaDados.leitorPessoa(caminho, listaPessoa);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		try {
			MenuInterativo.menu(listaPessoa, listaConta);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
