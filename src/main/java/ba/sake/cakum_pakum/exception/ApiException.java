package ba.sake.cakum_pakum.exception;

import org.springframework.http.HttpStatus;

public abstract class ApiException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final HttpStatus httpStatus;

    public ApiException(HttpStatus httpStatus, String message, Throwable cause) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    public ApiException(String message, Throwable cause) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, message, cause);
    }

    public ApiException(HttpStatus httpStatus, String message) {
        this(httpStatus, message, null);
    }

    public ApiException(String message) {
        this(message, null);
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
