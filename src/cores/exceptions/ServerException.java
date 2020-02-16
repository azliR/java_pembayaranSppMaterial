package cores.exceptions;

/**
 *
 * @author rizal
 */
public class ServerException extends Exception {

    private static final long serialVersionUID = 1L;

    public ServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerException(String message) {
        super(message);
    }
}
