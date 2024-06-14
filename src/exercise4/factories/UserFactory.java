package exercise4.factories;

import exercise4.models.User;

public class UserFactory {
  public static User create(String name, String email) {
    return new User(name, email);
  }
}
