package relatorios;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import contas.Conta;

public class RelatorioPresidente {
	public static void informacaoCliente (Conta c, List<Conta> listaConta) throws FileNotFoundException {
		String dataHoraCompleta = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String texto = null;
		double capital = 0;
		for (int i = 0; i<listaConta.size(); i++) {
			capital += listaConta.get(i).getSaldo();
		}
		texto = "Capital Total no banco R$"+capital;
		try {
			PrintWriter ps = new PrintWriter("BancoGrupo4\\src\\relatorios\\relatorioPresidente" + dataHoraCompleta + ".txt");
			ps.print("SERRA BANK \n\n" + texto);
			System.out.println("Relátorio gerado com sucesso!\n\n");
			ps.close();
		} catch (FileNotFoundException aaaa) {
			PrintWriter ps = new PrintWriter(".\\src\\relatorios\\relatorioPresidente" + dataHoraCompleta + ".txt");
			ps.print("SERRA BANK \n\n" + texto);
			System.out.println("Relátorio gerado com sucesso!\n\n");
			ps.close();
		} catch (Exception error) {
			error.printStackTrace();
		}
		
	}


}
