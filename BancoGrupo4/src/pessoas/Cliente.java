package pessoas;
/*
Caso o usuário seja um Cliente, o sistema fornecerá um menu com opções de:
	1. Movimentações na Conta
		a. Saque
		b. Depósito
		c. Transferência para outra conta
	2. Relatórios
		a. Saldo. O sistema deverá imprimir o saldo na tela do terminal;
		b. Relatório de tributação da conta corrente
			I. O relatório de tributação deverá apresentar o total gasto nas operações até o momento do relatório.
			II. Adicionalmente deverão ser informados os valores que o banco cobra por cada operação bancária;
			III. Para cada saque será cobrado o valor de R$0.10 (dez centavos);
			IV. Para cada depósito será cobrado o valor de R$0.10 (dez centavos);
			V. Para cada transferência será cobrado o valor de R$0.20 (dez centavos) que deverá ser cobrado apenas do remetente;
		c. Relatório de Rendimento da poupança
			I. Retorna uma simulação do valor de rendimento da poupança no prazo informado. Neste caso o
			cliente deverá informar o valor em dinheiro e a quantidade de dias que pretende simular. O
			sistema deverá informar o rendimento desse dinheiro para o prazo informado;
		d. Desafio:
			I. Criar uma classe seguro de vida que possa ser contratado pelo cliente onde o mesmo informa o
			valor que será segurado. No ato da contratação será debitado 20% do valor contratado como
			tributo do seguro;
			II. Incluir no relatório de tributação o valor referente ao seguro de vida, caso este cliente possua
			estas informações.
*/

public class Cliente extends Pessoa {

	public Cliente() {
		super();
	}

	public Cliente(String nome, String cpf, String senha) {
		super(nome, cpf, senha);
	}

	public String getNome() {
		return super.nome;
	}

	
	
}
