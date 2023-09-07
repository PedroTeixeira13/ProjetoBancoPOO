package pessoas;

public class Cliente extends Pessoa {

	public Cliente() {
	}

	public Cliente(String nome, String cpf, String senha) {
		super(nome, cpf, senha);
	}
	public String getNome() {
		return super.nome;
		}
}
