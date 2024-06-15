package exercise4.strategies;

import java.util.regex.Pattern;

public class UrlValidation implements ValidationStrategy {
  private static final Pattern URL_PATTERN = Pattern.compile(
      "^((http|https|ftp)://|(www)\\.)?[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?$"
  );

  @Override
  public boolean isValid(String inputData) {
    return !URL_PATTERN.matcher(inputData).matches();
  }
}
