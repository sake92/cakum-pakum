package ba.sake.cakum_pakum.rest.exceptions;

import java.net.URI;
import java.text.MessageFormat;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public final class NotFoundProblem extends AbstractThrowableProblem {

    private static final long serialVersionUID = 1L;

    private static final URI TYPE = URI.create("https://example.org/not-found");

    public NotFoundProblem(String resName, Object resId) {
        super(TYPE, "Not found", Status.NOT_FOUND,
                MessageFormat.format("{0} with id ''{1}'' not found.", resName, resId));
    }

}
