package ba.sake.cakum_pakum.exception;

import org.springframework.http.HttpStatus;

public class AlreadyExistsException extends ApiException {

    private static final long serialVersionUID = 1L;

    public AlreadyExistsException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }

}
