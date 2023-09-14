package exceptions;

import java.util.List;

import contas.Conta;
import menu.MenuInterativo;
import pessoas.Pessoa;

public class CredenciaisNaoEncontradasException extends NullPointerException {
    private static final long serialVersionUID = -2346384474413785588L;

    public CredenciaisNaoEncontradasException(List<Pessoa> listaPessoa, List<Conta> listaConta, int[] totalAg) throws Exception {
        super("Credenciais não encontradas!");
        System.out.println("Credenciais não encontradas, tente novamente!\n");
		MenuInterativo.menu(listaPessoa, listaConta, totalAg);
    }
    
}
