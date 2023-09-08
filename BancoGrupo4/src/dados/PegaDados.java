package dados;

import java.io.File; 
import java.util.List;
import java.util.Scanner;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import enums.ContaE;
import enums.PessoaE;
import pessoas.Diretor;
import pessoas.Gerente;
import pessoas.Pessoa;
import pessoas.Presidente;
import pessoas.Cliente;

public class PegaDados {
    public static void leitorPessoa(String caminho, List<Pessoa> listaPessoa) throws Exception {

        Scanner sc = new Scanner(new File(caminho));

        String linha = "";
        
        while (true) {

            linha = sc.nextLine();

            if (linha != null) {
                String [] divide = linha.split(",");

                if(divide[2] == (PessoaE.Diretor.name())) {
                    Diretor d = new Diretor(divide[0], divide[1], divide[2], divide[3]);
                    listaPessoa.add(d);
                } else if(divide[2] == (PessoaE.Gerente.name())) {
                    Gerente g = new Gerente(divide[0], divide[1], divide[2], divide[3]);
                    listaPessoa.add(g);
                } else if(divide[2] == (PessoaE.Presidente.name())) {
                    Presidente p = new Presidente(divide[0], divide[1], divide[2], divide[3]);
                    listaPessoa.add(p);
                } else if(divide[2] == (PessoaE.Cliente.name())) {
                    Cliente c = new Cliente(divide[0], divide[1], divide[2], divide[3]);
                    listaPessoa.add(c);
                }
            } else {
                break;
            }
        }
        sc.close();
    }

    public static void leConta(String caminho, List<Conta> listaConta) throws Exception {

        Scanner sc = new Scanner(new File(caminho));

        String linha = "";

        while (true) {
            linha = sc.nextLine();

            if(linha != null) {
                String [] divide = linha.split(",");

                if(divide[3] == (ContaE.ContaCorrente.name())) {
                    ContaCorrente cc = new ContaCorrente(divide[0], Double.parseDouble(divide[1]), Integer.parseInt(divide[2]), divide[3]);
                    listaConta.add(cc);
                } else if(divide[3] == (ContaE.ContaPoupanca.name())) {
                    ContaPoupanca cp = new ContaPoupanca(divide[0], Double.parseDouble(divide[1]), Integer.parseInt(divide[2]), divide[3]);
                    listaConta.add(cp);
                }
            } else {
                break;
            }
        }
        sc.close();
    }
}