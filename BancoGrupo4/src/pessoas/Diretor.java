package pessoas;

/*
Caso o usuário seja um Funcionário no cargo de Diretor o sistema fornecerá um menu com todas as opções
anteriores, adicionando:

1. Relatórios
	a. Relatório com as informações de Nome, CPF e Agência de todos os clientes do sistema em ordem alfabética	
*/

public class Diretor extends Funcionario {

	public Diretor() {
		super();
	}

	public Diretor(String nome, String cpf, String senha, String cargo) {
		super(nome, cpf, senha, cargo);
	}

}
