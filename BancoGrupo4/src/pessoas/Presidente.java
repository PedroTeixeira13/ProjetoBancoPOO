package pessoas;

/*
Caso o usuário seja um Funcionário no cargo de Presidente o sistema fornecerá um menu com todas as opções
anteriores, adicionando:

1. Relatórios
	a. Relatório com o valor total do capital armazenado no banco.
*/

public class Presidente extends Funcionario {

	public Presidente() {
		super();
	}

	public Presidente(String nome, String cpf, String senha, String cargo) {
		super(nome, cpf, senha, cargo);
	}

}
