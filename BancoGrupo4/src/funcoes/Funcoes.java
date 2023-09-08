package funcoes;

public class Funcoes {
    public final static void limpaTela() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (final Exception e) {
			e.printStackTrace();
		}
    }
}
