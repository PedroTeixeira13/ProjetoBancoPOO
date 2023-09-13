package relatorios;

import java.util.List;

import contas.Conta;

public class RelatorioPresidente {
	public static void informacaoCliente (Conta c, List<Conta> listaConta) {
		double capital = 0;
		for (int i = 0; i<listaConta.size(); i++) {
			capital += listaConta.get(i).getSaldo();
		}
		System.out.println("Capital Total no banco R$"+capital);
		
	}


}
