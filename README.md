## TRABALHO EM GRUPO JAVA 1
<br>

### Integrantes do Grupo

- <a href="https://github.com/0ArS0"> Arthur Monteiro</a>
- <a href="https://github.com/DevBrenoXavier"> Breno Xavier</a>
- <a href="https://github.com/PedroTeixeira13"> Pedro Teixeira</a>
- <a href="https://github.com/Rafamassi"> Rafael Massi</a>
- <a href="https://github.com/Thomasten22"> Thomas Victor</a>
- <a href="https://github.com/VitorMelloEsp"> Vitor Mello</a>

### Instruções 
<hr>

#### Sistema Bancário

O objetivo deste trabalho é promover o desenvolvimento de um pequeno sistema bancário utilizando os tópicos
apresentados e desenvolvidos na disciplina.

#### Requisitos Mínimos:

#### Classes

O sistema deverá ter as seguintes classes obrigatoriamente. (Podendo ter classes adicionais perante a necessidade
descoberta por cada grupo):
- Cliente
- Conta
    - Conta Corrente
    - Conta Poupança
- Funcionário
    - Gerente
    - Diretor
    - Presidente
- SistemaInterno ( Classe main )

#### Atributos

- Cliente deve ter os atributos de senha e CPF para que possam logar no sistema interno.

- Conta, que deverá ser uma classe abstrata, deve conter os atributos de CPF do titular, para relacionar a conta
com o usuário logado no sistema, e o saldo. Adicionalmente, a conta deve ter um atributo identificador da
agência.
- Conta Corrente e Conta Poupança, que herdarão os atributos e métodos de Conta, devem conter um atributo
“tipo” para identificação do tipo de conta.
- Funcionário ( abstrata ), deve conter atributos também de CPF e senha para que possam logar no sistema.
Um atributo “cargo” também deve existir para identificar qual é o cargo daquele funcionário. Este atributo
pode existir na própria classe Funcionário ou diretamente em suas classes filhas.
- Gerente, que estenderá de Funcionário deve ter um atributo de identificação da agência que é responsável
por gerir.

#### Características de Funcionamento

Este sistema será executado como um menu interativo no console.

Na versão final (a ser entregue) é esperado que o sistema seja populado com os valores referentes aos clientes,
contas e funcionários através da leitura de um arquivo de texto. Para testes iniciais, entretanto, valores podem ser
atribuídos diretamente.

#### Passos de Execução

No menu inicial o usuário deverá fornecer seu CPF e senha para logar.

O sistema deve ser capaz de identificar, no momento do login se o usuário é um Cliente, Gerente, Diretor ou
Presidente.

#### Caso 1:

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

        V. Para cada transferência será cobrado o valor de R$0.20 (dez centavos) que deverá ser cobrada apenas do remetente;

    c. Relatório de Rendimento da poupança

        I. Retorna uma simulação do valor de rendimento da poupança no prazo informado. Neste caso o cliente deverá informar o valor em dinheiro e a quantidade de dias que pretende simular. O sistema deverá informar o rendimento desse dinheiro para o prazo informado;

    d. Desafio:

        I. Criar uma classe seguro de vida que possa ser contratado pelo cliente onde o mesmo informa o valor que será segurado. No ato da contratação será debitado 20% do valor contratado como tributo do seguro;

        II. Incluir no relatório de tributação o valor referente ao seguro de vida, caso este cliente possua estas informações.

#### Caso 2:

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

        I. Retorna uma simulação do valor de rendimento da poupança no prazo informado. Neste caso o cliente deverá informar o valor em dinheiro e a quantidade de dias que pretende simular. O sistema deverá informar o rendimento desse dinheiro para o prazo informado;

    d. Relatório do número contas na mesma agência em que este gerente trabalha

#### Caso 3:

Caso o usuário seja um Funcionário no cargo de Diretor o sistema fornecerá um menu com todas as opções
anteriores, adicionando:

1. Relatórios

    a. Relatório com as informações de Nome, CPF e Agência de todos os clientes do sistema em ordem alfabética

#### Caso 4:
Por fim, caso o usuário acessando o sistema seja um Funcionário no cargo de Presidente o sistema fornecerá um
menu com todas as opções anteriores, adicionando:

1. Relatórios

    a. Relatório com o valor total do capital armazenado no banco.

#### Restrições
Toda operação bancária (Saque, depósito e transferência) deverá ser registrada em um arquivo de texto de saída que
armazena as operações realizadas durante aquela execução do sistema.
Todo relatório gerado deve ser registrado em um arquivo texto de saída individual.
O sistema deve realizar ao menos um tratamento de erros personalizado.

**Sugestão**: Caso um cliente tente realizar um depósito com valor indevido ( valores negativos )