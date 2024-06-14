package exercise4.exceptions;

public class InvalidUrlException extends RuntimeException {
  public InvalidUrlException(String message) {
    super(message);
  }
}
