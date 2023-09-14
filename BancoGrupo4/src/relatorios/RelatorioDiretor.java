package relatorios;

import java.util.List;

import contas.Conta;
import pessoas.Pessoa;

public class RelatorioDiretor {

	public static void infoCliente (List<Conta> listaConta, List<Pessoa> listaPessoa) {
		System.out.println("Relatório dos Clientes: ");
		for(int i = 0; i<listaConta.size(); i++) {
			String nome = null, cpf = null;
			int agencia = 0;
			nome = listaPessoa.get(i).getNome();
			cpf = listaPessoa.get(i).getCpf();
			agencia = listaConta.get(i).getAgencia();
			System.out.printf("Nome: %s, CPF: %s, Agencia: %s\n",nome,cpf,agencia);
		}
	}
}