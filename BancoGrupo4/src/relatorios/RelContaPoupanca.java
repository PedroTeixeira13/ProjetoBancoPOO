package relatorios;

import java.io.PrintWriter;

import contas.Conta;

public class RelContaPoupanca {
	public static void relatorioCP(Conta c) throws Exception {

        PrintWriter ps = new PrintWriter("..\\src\\TestesImpressaoCP.txt");
        //ps.print();
        ps.close();
    }
}
