package GlobalExceptionHandling.Advice;

import GlobalExceptionHandling.CustomException.EmptyDBException;
import GlobalExceptionHandling.CustomException.EmptyInputFieldsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.xml.ws.Response;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandlerClass extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmptyInputFieldsException.class)
    public ResponseEntity<?> handleEmptyException(EmptyInputFieldsException emptyInputFieldsException)
    {

        return new ResponseEntity<String>(emptyInputFieldsException.getErrorMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyDBException.class)
    public ResponseEntity<?> handleEmptyDbException(EmptyDBException emptyDBException)
    {
        return new ResponseEntity<String>("No records found in DB",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> handleNoSuchElementException(NoSuchElementException noSuchElementException)
    {
        return new ResponseEntity<String>("No Record with given id is in DB",HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>("Please use proper request",HttpStatus.BAD_REQUEST);
    }
}
