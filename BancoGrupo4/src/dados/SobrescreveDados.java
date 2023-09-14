package dados;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import contas.Conta;
import pessoas.Pessoa;

public class SobrescreveDados {
    public static void sobrescrita(List<Conta> listaConta, List<Pessoa> listaPessoa) throws Exception {

        
        String caminho = "BancoGrupo4\\src\\dados\\dados.txt";
        String caminho2 = ".\\src\\dados\\dados.txt";
        
        try {
            buffer(caminho, listaConta, listaPessoa);
        } catch (FileNotFoundException FNFError) {
            buffer(caminho2, listaConta, listaPessoa);
        } catch (Exception e) {
            System.out.println("Não foi possível gerar o arquivo seguinte de dados.");
        }
    }

    private static void buffer(String caminho, List<Conta> listaConta, List<Pessoa> listaPessoa) throws IOException {
        String nome = null;
        String cpf = null;
        String cargo = null;
        String senha = null;
        double saldo = 0.0;
        int agencia = 0;
        String tipo = null;

        BufferedWriter bw = new BufferedWriter(new FileWriter(caminho));
            for (int i = 0; i < listaPessoa.size(); i++) {
                nome = listaPessoa.get(i).getNome();
                cpf = listaPessoa.get(i).getCpf();
                cargo = listaPessoa.get(i).getCargo();
                senha = listaPessoa.get(i).getSenha();
                String linha = nome + "," + cpf + "," + cargo + "," + senha;
                bw.append(linha + "\n");
            }

            for (int i = 0; i < listaConta.size(); i++) {
                cpf = listaConta.get(i).getCpfTitular();
                saldo = listaConta.get(i).getSaldo();
                String qq = String.format("%.2f", saldo);
                agencia = listaConta.get(i).getAgencia();
                tipo = listaConta.get(i).getTipo();
                String linha = cpf + "," + qq + "," + "000" + agencia + "," + tipo;
                bw.append(linha + "\n");
            }
            bw.close();
        }
}
