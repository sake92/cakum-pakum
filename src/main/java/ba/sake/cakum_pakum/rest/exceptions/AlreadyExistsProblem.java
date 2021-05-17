package ba.sake.cakum_pakum.rest.exceptions;

import java.net.URI;
import java.text.MessageFormat;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class AlreadyExistsProblem extends AbstractThrowableProblem {

    private static final long serialVersionUID = 1L;

    private static final URI TYPE = URI.create("https://example.org/not-found");

    public AlreadyExistsProblem(String resName, String fieldName, Object fieldValue) {
        super(TYPE, "Already exists", Status.BAD_REQUEST, MessageFormat.format(
                "{0} with {1} value ''{2}'' already exists.", resName, fieldName, fieldValue));
    }

}
