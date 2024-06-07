package exercise4.services;

import exercise4.models.User;
import exercise4.strategies.ValidationStrategy;

public class UserService {
  private ValidationStrategy validator;

  public UserService(ValidationStrategy validator) {
    this.validator = validator;
  }
}
