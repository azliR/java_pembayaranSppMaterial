package cores.exceptions;

public class IllegalOrphanException extends Exception {

    private static final long serialVersionUID = 1L;

    public IllegalOrphanException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalOrphanException(String message) {
        super(message);
    }
}
