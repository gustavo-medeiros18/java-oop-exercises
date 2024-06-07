package exercise4.controllers;

import exercise4.services.UserService;
import exercise4.strategies.EmailValidation;

public class UserController {
  private static UserService userService = new UserService(new EmailValidation());

  public static void createUser(String name, String email) {
    userService.create(name, email);
  }
}
