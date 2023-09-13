package relatorios;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import contas.Conta;

public class RelContaCorrente {
    public static void relatorioCC(Conta c) throws Exception {

        String dataHoraCompleta = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        PrintWriter ps = new PrintWriter("src\\relatorios\\" + dataHoraCompleta + ".txt");
        
        ps.print("Total gasto em operações: " + c.getOperacoes() + "\n\nTotal taxação de saque: " + c.getTaxaSaque()
        + "\nTotal taxação de deposito: " + c.getTaxaDeposito() + "\nTotal taxação de transferencia: " + c.getTaxaTransferencia());
        ps.close();
    }
}
