package exercise7.exceptions;

public class NotEnoughBalanceException extends Exception {
  public NotEnoughBalanceException(String message) {
    super(message);
  }
}
