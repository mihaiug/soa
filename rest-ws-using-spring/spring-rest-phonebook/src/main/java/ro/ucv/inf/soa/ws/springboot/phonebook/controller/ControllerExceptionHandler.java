package ro.ucv.inf.soa.ws.springboot.phonebook.controller;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ro.ucv.inf.soa.ws.springboot.phonebook.dto.ErrorMessage;
import ro.ucv.inf.soa.ws.springboot.phonebook.exception.DuplicateRecordException;
import ro.ucv.inf.soa.ws.springboot.phonebook.exception.RecordNotFoundException;

/**
 * Handle the exceptions.
 */
@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = { RecordNotFoundException.class })
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorMessage handleRecordNotFoundException(RecordNotFoundException ex, WebRequest request) {
    ErrorMessage errorMessage = new ErrorMessage(
        HttpStatus.NOT_FOUND.value(),
        ex.getMessage(),
        request.getDescription(false));

    return errorMessage;
  }

  @ExceptionHandler(value = { DuplicateRecordException.class })
  public ResponseEntity<ErrorMessage> handleDuplicateRecordException(DuplicateRecordException ex, WebRequest request) {
    ErrorMessage errorMessage = new ErrorMessage(
        HttpStatus.CONFLICT.value(),
        ex.getMessage(),
        request.getDescription(false));
    return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.CONFLICT);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(  MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDate.now());
    body.put("status", status.value());

    List<String> errors = ex.getBindingResult()
        .getFieldErrors()
        .stream()
        .map(x -> x.getDefaultMessage())
        .collect(Collectors.toList());

    body.put("errors", errors);

    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }

}
