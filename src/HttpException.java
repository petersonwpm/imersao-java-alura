public class HttpException extends RuntimeException {
    private static final long serialVersionUID = 7718828512143293558L;

    public HttpException() {
        super();
    }

    public HttpException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpException(String message) {
        super(message);
    }

    public HttpException(Throwable cause) {
        super(cause);
    }
}
