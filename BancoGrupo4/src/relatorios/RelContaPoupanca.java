package relatorios;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

import contas.Conta;

public class RelContaPoupanca {
	static Scanner sc = new Scanner (System.in);
	
	public static void relatorioCP(Conta c) throws InterruptedException {
		Locale.setDefault(Locale.US);
		String dataHoraCompleta = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		
		System.out.println("\nQual valor que pretende simular: ");
		double valor = sc.nextDouble();
		System.out.println("Quantos dias pretende simular: ");
		int dias = sc.nextInt();
		System.out.println();
		System.out.print("Simulando");
		Thread.sleep(800);
		System.out.print(".");
		Thread.sleep(800);
		System.out.print(".");
		Thread.sleep(800);
		System.out.print(".\n\n");
		System.out.println("Simulação Completa!\n");
		Thread.sleep(800);
		double total = valor * dias * 0.003;
        try(PrintWriter ps = new PrintWriter("src\\relatorios\\relatorioCP" + dataHoraCompleta + ".txt")){
        	 System.out.println("Relátorio ContaPoupanca gerado com sucesso!\n\n");
        	 ps.print("SERRA BANK \n\nTotal da simulação de rendimento: " + total);
             ps.close();
        } catch (Exception ex) {
        	System.out.println("Relatório não foi gerado!!!");
        }
       
    }
}
