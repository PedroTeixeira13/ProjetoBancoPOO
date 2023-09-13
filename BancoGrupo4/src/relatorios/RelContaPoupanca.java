package relatorios;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import contas.Conta;

public class RelContaPoupanca {
	public static void relatorioCP(Conta c) throws Exception {
		Scanner sc = new Scanner (System.in);
		String dataHoraCompleta = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		
		System.out.println("Qual valor que pretende simular: ");
		double valor = sc.nextDouble();
		System.out.println("Quantos dias pretende simular: ");
		int dias = sc.nextInt();
		sc.close();
		
		double total = valor * dias * 0.003;
        PrintWriter ps = new PrintWriter("src\\relatorios\\relatorioCP" + dataHoraCompleta + ".txt");
        ps.print("SERRA BANK \n\nTotal da simulação de rendimento: " + total);
        ps.close();
    }
}
