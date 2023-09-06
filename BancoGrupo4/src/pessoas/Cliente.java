package pessoas;

public class Cliente extends Pessoa {
	public Cliente(String nome, String cpf, int id, String senha, String tipo) {
		super(nome, cpf, id, senha, "Cliente");
	}
}
