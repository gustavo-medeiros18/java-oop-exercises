package exercise4.controllers;

import exercise4.models.User;
import exercise4.services.UserService;
import exercise4.strategies.EmailValidation;

public class UserController {
  private static final UserService userService = new UserService(new EmailValidation());

  public static User createUser(String name, String email) {
    return userService.create(name, email);
  }
}
