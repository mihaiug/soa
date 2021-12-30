package ro.ucv.inf.soa.ws.springboot.phonebook.exception;

public class DuplicateRecordException extends RuntimeException {

  public DuplicateRecordException() {
    super();
  }

  public DuplicateRecordException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public DuplicateRecordException(final String message) {
    super(message);
  }

  public DuplicateRecordException(final Throwable cause) {
    super(cause);
  }
}