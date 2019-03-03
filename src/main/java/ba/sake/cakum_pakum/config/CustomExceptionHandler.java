package ba.sake.cakum_pakum.config;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ba.sake.cakum_pakum.dto.error.ErrorMessageDto;
import ba.sake.cakum_pakum.exception.ApiException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiException.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, ApiException ex) {
        ErrorMessageDto errorMessageDto = new ErrorMessageDto();
        errorMessageDto.setMessage(ex.getMessage());
        errorMessageDto.setDebugMessage(ex.getMessage()); // TODO if DEV mode
        return new ResponseEntity<>(errorMessageDto, ex.getHttpStatus());
    }
}
