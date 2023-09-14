package relatorios;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import contas.Conta;
import pessoas.Pessoa;

public class RelatorioDiretor {

	public static void infoCliente(List<Conta> listaConta, List<Pessoa> listaPessoa) throws FileNotFoundException {
		Map<Conta, String> contaNomeMap = new HashMap<>();

		for (int i = 0; i < listaConta.size(); i++) {
			contaNomeMap.put(listaConta.get(i), listaPessoa.get(i).getNome());
		}
		listaConta.sort((conta1, conta2) -> contaNomeMap.get(conta1).compareTo(contaNomeMap.get(conta2)));
		listaPessoa.sort((p1, p2) -> p1.getNome().compareTo(p2.getNome()));

		String dataHoraCompleta = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		System.out.println("Relatório dos Clientes gerado!");
		PrintWriter ps = new PrintWriter("src\\relatorios\\relatorioDiretor" + dataHoraCompleta + ".txt");
		String nome = null, cpf = null;
		int agencia = 0;

		ps.print("SERRA BANK \n\n");
		for (int i = 0; i < listaConta.size(); i++) {
			nome = listaPessoa.get(i).getNome();
			cpf = listaPessoa.get(i).getCpf();
			agencia = listaConta.get(i).getAgencia();
			ps.printf("Nome: %s, CPF: %s, Agencia: %s\n", nome, cpf, agencia);
		}
		System.out.println("Relátorio gerado com sucesso!\n\n");
		ps.close();
	}
}