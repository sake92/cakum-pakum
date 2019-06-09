package ba.sake.cakum_pakum.exception;

public abstract class ApiException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ApiException(String message) {
        super(message);
    }

}
