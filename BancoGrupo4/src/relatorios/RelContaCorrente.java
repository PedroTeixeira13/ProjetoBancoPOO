package relatorios;

import java.io.PrintWriter;
import java.util.List;

import contas.Conta;

import pessoas.Pessoa;

public class RelContaCorrente {
    public static void relatorioCC(Conta c) throws Exception {

        PrintWriter ps = new PrintWriter("..\\src\\TestesImpressao.txt");
        ps.print("Total gasto em operações: " + c.getOperacoes() + "\n\nTotal taxação de saque: " + c.getTaxaSaque()
        + "\nTotal taxação de deposito: " + c.getTaxaDeposito() + "\nTotal taxação de transferencia: " + c.getTaxaTransferencia());
        ps.close();
    }
}
