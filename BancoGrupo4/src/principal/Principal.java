package principal;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import contas.Conta;
import dados.PegaDados;
import menu.Menu;
import menu.MenuInterativo;
import pessoas.Pessoa;

public class Principal {
	public static void main(String[] args) throws Exception {
		
		String caminho = "BancoGrupo4\\src\\dados\\teste.txt";
		String caminho2 = ".\\src\\dados\\teste.txt";	
		List<Pessoa> listaPessoa = new ArrayList<>();
        List<Conta> listaConta = new ArrayList<>();
        int[] totalAg;
        totalAg = new int[2];
        
		Menu.logo();
        try {
			PegaDados.leitorPessoa(caminho, listaPessoa);
			PegaDados.leConta(caminho, listaConta, totalAg);
		}catch(FileNotFoundException FNFError) {
			PegaDados.leitorPessoa(caminho2, listaPessoa);
			PegaDados.leConta(caminho2, listaConta, totalAg);
		}catch (Exception e) {
			e.printStackTrace();
		}
        
		try {
			MenuInterativo.menu(listaPessoa, listaConta, totalAg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
