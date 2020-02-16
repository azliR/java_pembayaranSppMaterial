package cores.exceptions;

/**
 *
 * @author rizal
 */
public class UnexpectedException extends Exception {

    private static final long serialVersionUID = 1L;

    public UnexpectedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnexpectedException(String message) {
        super(message);
    }
}
