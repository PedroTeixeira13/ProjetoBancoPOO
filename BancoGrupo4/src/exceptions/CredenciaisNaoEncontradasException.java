package exceptions;

public class CredenciaisNaoEncontradasException extends NullPointerException {
    private static final long serialVersionUID = -2346384474413785588L;

    public CredenciaisNaoEncontradasException() {
        super("Credenciais não encontradas!");
    }
}
