package pessoas;
/*
Caso o usuário seja um Funcionário no cargo de Gerente o sistema fornecerá um menu com opções de:
	1. Movimentações e Informações da Conta
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
			I. Retorna uma simulação do valor de rendimento da poupança no prazo informado. Neste caso o cliente deverá informar 
			o valor em dinheiro e a quantidade de dias que pretende simular. O sistema deverá informar o rendimento desse dinheiro 
			para o prazo informado;
		d. Relatório do número contas na mesma agência em que este gerente trabalha
*/


public class Gerente extends Funcionario {
	protected int agenciaGere;
	
	public Gerente() {
		super();
	}
	
	public Gerente(String nome, String cpf, String senha, String cargo, int agenciaGere) {
		super(nome, cpf, senha, cargo);
		this.agenciaGere = agenciaGere;
	}

}
