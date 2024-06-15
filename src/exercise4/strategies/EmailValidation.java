package exercise4.strategies;

import java.util.regex.Pattern;

public class EmailValidation implements ValidationStrategy {
  private static final Pattern EMAIL_PATTERN =
      Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,6}$");

  @Override
  public boolean isValid(String inputData) {
    return !EMAIL_PATTERN.matcher(inputData).matches();
  }
}
