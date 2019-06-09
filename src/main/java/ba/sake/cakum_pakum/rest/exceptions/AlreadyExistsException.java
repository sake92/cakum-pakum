package ba.sake.cakum_pakum.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlreadyExistsException extends ApiException {

    private static final long serialVersionUID = 1L;

    public AlreadyExistsException(String message) {
        super(message);
    }
}
