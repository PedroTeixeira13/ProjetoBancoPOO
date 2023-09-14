package dados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
    public static void leitorPessoa(String caminho, List<Pessoa> listaPessoa) throws IOException {

        BufferedReader buffRead = new BufferedReader(new FileReader(caminho));

        String linha = "";

        while (true) {

            linha = buffRead.readLine();

            if (linha != null) {
                String[] divide = linha.split(",");

                if (divide[2].equals(PessoaE.Diretor.name())) {
                    Diretor d = new Diretor(divide[0], divide[1], divide[2], divide[3]);
                    listaPessoa.add(d);
                } else if (divide[2].equals(PessoaE.Gerente.name())) {
                    Gerente g = new Gerente(divide[0], divide[1], divide[2], divide[3]);
                    listaPessoa.add(g);
                } else if (divide[2].equals(PessoaE.Presidente.name())) {
                    Presidente p = new Presidente(divide[0], divide[1], divide[2], divide[3]);
                    listaPessoa.add(p);
                } else if (divide[2].equals(PessoaE.Cliente.name())) {
                    Cliente c = new Cliente(divide[0], divide[1], divide[2], divide[3]);
                    listaPessoa.add(c);
                }
            } else {
                break;
            }
        }
        buffRead.close();
    }

    public static void leConta(String caminho, List<Conta> listaConta, int[] totalAg) throws Exception {

        BufferedReader buffRead = new BufferedReader(new FileReader(caminho));

        String linha = "";
        int total1 = 0;
        int total2 = 0;

        while (true) {
            linha = buffRead.readLine();

            if (linha != null) {
                String[] divide = linha.split(",");

                if (divide[3].equals(ContaE.ContaCorrente.name())) {
                    ContaCorrente cc = new ContaCorrente(divide[0], Double.parseDouble(divide[1]),
                            Integer.parseInt(divide[2]), divide[3]);
                    listaConta.add(cc);
                } else if (divide[3].equals(ContaE.ContaPoupanca.name())) {
                    ContaPoupanca cp = new ContaPoupanca(divide[0], Double.parseDouble(divide[1]),
                            Integer.parseInt(divide[2]), divide[3]);
                    listaConta.add(cp);
                }
                if (divide[2].equals("0001")) {
                    total1++;
                } else if (divide[2].equals("0002")) {
                    total2++;
                }
            } else {
                break;
            }
            totalAg[0] = total1;
            totalAg[1] = total2;
        }
        buffRead.close();
    }
}