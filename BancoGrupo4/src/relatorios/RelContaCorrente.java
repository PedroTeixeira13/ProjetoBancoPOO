package relatorios;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import contas.Conta;

public class RelContaCorrente {
	public static void relatorioCC(Conta c) throws FileNotFoundException {

		String dataHoraCompleta = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		try  {
			PrintWriter ps = new PrintWriter("src\\relatorios\\relatorioCC" + dataHoraCompleta + ".txt");
			System.out.println("\nRelatório ContaCorrente gerado com sucesso!\n");
			ps.print("Total gasto em operações: " + c.getOperacoes() + "\n\nTotal taxação de saque: " + c.getTaxaSaque()
					+ "\nTotal taxação de deposito: " + c.getTaxaDeposito() + "\nTotal taxação de transferencia: "
					+ c.getTaxaTransferencia());
			ps.close();

		} catch (FileNotFoundException FNFError){
			PrintWriter ps = new PrintWriter("BancoGrupo4\\src\\relatorios\\relatorioCC" + dataHoraCompleta + ".txt");
			System.out.println("\nRelatório ContaCorrente gerado com sucesso!\n");
			ps.print("Total gasto em operações: " + c.getOperacoes() + "\n\nTotal taxação de saque: " + c.getTaxaSaque()
					+ "\nTotal taxação de deposito: " + c.getTaxaDeposito() + "\nTotal taxação de transferencia: "
					+ c.getTaxaTransferencia());
			ps.close();
		}catch (Exception ex) {
			System.out.println("\n\nRelatório não foi gerado!!!\n\n");
		}

	}
}
