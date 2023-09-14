package relatorios;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import contas.Conta;

public class RelContaCorrente {
	public static void relatorioCC(Conta c) {

		String dataHoraCompleta = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		try (PrintWriter ps = new PrintWriter("src\\relatorios\\relatorioCC" + dataHoraCompleta + ".txt")) {
			System.out.println("\nRelatório ContaPoupanca gerado com sucesso!\n");
			ps.print("Total gasto em operações: " + c.getOperacoes() + "\n\nTotal taxação de saque: " + c.getTaxaSaque()
					+ "\nTotal taxação de deposito: " + c.getTaxaDeposito() + "\nTotal taxação de transferencia: "
					+ c.getTaxaTransferencia());
			ps.close();

		} catch (Exception ex) {
			System.out.println("Relatório não foi gerado!!!");
		}

	}
}
