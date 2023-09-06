package pessoas;

public class Cliente extends Pessoa {
	public Cliente(String nome, String cpf, String id, int senha, String tipo) {
		super(nome, cpf, id, senha, "Cliente");
	}
}
