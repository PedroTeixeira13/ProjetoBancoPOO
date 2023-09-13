package relatorios;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

import contas.Conta;

public class RelContaPoupanca {
	static Scanner sc = new Scanner (System.in);
	
	public static void relatorioCP(Conta c) throws Exception {
		Locale.setDefault(Locale.US);
		String dataHoraCompleta = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		
		System.out.println("Qual valor que pretende simular: ");
		double valor = sc.nextDouble();
		System.out.println("Quantos dias pretende simular: ");
		int dias = sc.nextInt();
		
		double total = valor * dias * 0.003;
        PrintWriter ps = new PrintWriter("src\\relatorios\\relatorioCP" + dataHoraCompleta + ".txt");
        ps.print("SERRA BANK \n\nTotal da simulação de rendimento: " + total);
        System.out.println("Relátorio gerado com sucesso!\n\n");
        ps.close();
    }
}
