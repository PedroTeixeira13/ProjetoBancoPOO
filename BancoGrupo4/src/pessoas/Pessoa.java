package pessoas;

public abstract class Pessoa {
    protected String nome;
    protected String cpf;
    protected int id;
    protected int senha;

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public int getId() {
        return id;
    }
    public int getSenha() {
        return senha;
    }
    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, int id, int senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.id = id;
        this.senha = senha;
    }
}