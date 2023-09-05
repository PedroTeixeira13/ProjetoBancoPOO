package pessoas;

public abstract class Funcionario extends Pessoa {
    protected double salario;

    public Funcionario () {
    }

    public Funcionario(String nome, String cpf, int id, int senha, double salario) {
        super(nome, cpf, id, senha);
        this.salario = salario;
    }
}