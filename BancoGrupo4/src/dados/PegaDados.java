package dados;

import java.io.BufferedReader; 
import java.io.FileReader;
import java.util.List;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import enums.ContaE;
import enums.PessoaE;
import pessoas.Cliente;
import pessoas.Diretor;
import pessoas.Gerente;
import pessoas.Pessoa;
import pessoas.Presidente;

public class PegaDados {
	public static void leitorPessoa(String caminho, List<Pessoa> listaPessoa) throws Exception {

		try (BufferedReader buffRead = new BufferedReader(new FileReader(caminho))) {
			String linha;

			while ((linha = buffRead.readLine()) != null) {

				if (linha != null) {
					String[] divide = linha.split(",");

					if (divide[2].equalsIgnoreCase(PessoaE.Diretor.name())) {
						Diretor d = new Diretor(divide[0], divide[1], divide[2], divide[3]);
						listaPessoa.add(d);
					} else if (divide[2].equalsIgnoreCase(PessoaE.Gerente.name())) {
						Gerente g = new Gerente(divide[0], divide[1], divide[2], divide[3]);
						listaPessoa.add(g);
					} else if (divide[2].equalsIgnoreCase(PessoaE.Presidente.name())) {
						Presidente p = new Presidente(divide[0], divide[1], divide[2], divide[3]);
						listaPessoa.add(p);
					} else if (divide[2].equalsIgnoreCase(PessoaE.Cliente.name())) {
						Cliente c = new Cliente(divide[0], divide[1], divide[2], divide[3]);
						listaPessoa.add(c);
					}
				}
			}
		} 
	}

	public static void leConta(String caminho, List<Conta> listaConta, int[] totalAg) throws Exception {
		
		try (BufferedReader buffRead = new BufferedReader(new FileReader(caminho))) {
			String linha;
			int total1 = 0;
			int total2 = 0;
			
			while ((linha = buffRead.readLine()) != null) {

				if (linha != null) {
					String[] divide = linha.split(",");

					if (divide[3].equalsIgnoreCase(ContaE.ContaCorrente.name())) {
						ContaCorrente cc = new ContaCorrente(divide[0], Double.parseDouble(divide[1]),
								Integer.parseInt(divide[2]), divide[3]);
						listaConta.add(cc);
					} else if (divide[3].equalsIgnoreCase(ContaE.ContaPoupanca.name())) {
						ContaPoupanca cp = new ContaPoupanca(divide[0], Double.parseDouble(divide[1]),
								Integer.parseInt(divide[2]), divide[3]);
						listaConta.add(cp);
					}
					if (divide[2].equals("0001")) {
						total1++;
					} else if (divide[2].equals("0002")) {
						total2++;
					}
					totalAg[0] = total1;
					totalAg[1] = total2;
				}
			}
		}
	}
}