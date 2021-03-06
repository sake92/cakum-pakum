package ba.sake.cakum_pakum.utils;

import java.text.MessageFormat;
import org.springframework.stereotype.Component;
import ba.sake.cakum_pakum.rest.exceptions.AlreadyExistsException;
import ba.sake.cakum_pakum.rest.exceptions.ApiException;
import ba.sake.cakum_pakum.rest.exceptions.NotFoundException;

@Component
public class ExceptionUtils {

    public ApiException notFound(String resName, Object resId) {
        String message = MessageFormat.format("{0} with id ''{1}'' not found.", resName, resId);
        return new NotFoundException(message);
    }

    public ApiException alreadyExists(String resName, String fieldName, Object fieldValue) {
        String message = MessageFormat.format(
                "{0} with " + fieldName + " value ''{1}'' already exists.", resName, fieldValue);
        return new AlreadyExistsException(message);
    }

}
