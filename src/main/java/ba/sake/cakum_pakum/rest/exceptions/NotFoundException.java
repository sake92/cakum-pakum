package ba.sake.cakum_pakum.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends ApiException {

    private static final long serialVersionUID = 1L;

    public NotFoundException(String message) {
        super(message);
    }

}
