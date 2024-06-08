package exercise4.services;

import exercise4.factories.UserFactory;
import exercise4.models.User;
import exercise4.strategies.ValidationStrategy;

public class UserService {
  private ValidationStrategy validator;

  public UserService(ValidationStrategy validator) {
    this.validator = validator;
  }

  public User create(String name, String email) {
    if (!this.validator.isValid(email)) {
      System.out.println("Email address is invalid!");
      return null;
    }

    return UserFactory.create(name, email);
  }
}
