package pessoas;

public class Cliente extends Pessoa {
	
	public Cliente() {
		super();
	}
	
	public Cliente(String nome, String cpf, String cargo, String senha) {
		super(nome, cpf, cargo, senha);
	}
	
	public String getNome() {
		return super.getNome();
	}

	public String getCargo() {
		return super.getCargo();
	}

}
