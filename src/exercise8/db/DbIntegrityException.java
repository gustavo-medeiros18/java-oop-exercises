package exercise8.db;

public class DbIntegrityException extends RuntimeException {
  public DbIntegrityException(String message) {
    super(message);
  }
}
