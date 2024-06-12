package exercise4.factories;

import exercise4.models.User;

public class UserFactory {
  private static int idCount = 0;

  public static User create(String name, String email) {
    return new User(++idCount, name, email);
  }

  public static User create(int id, String name, String email) {
    return new User(id, name, email);
  }
}
