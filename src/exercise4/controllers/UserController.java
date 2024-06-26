package exercise4.controllers;

import exercise4.models.User;
import exercise4.services.UserService;
import exercise4.strategies.EmailValidation;

import java.util.List;

public class UserController {
  private static final UserService userService =
      new UserService(new EmailValidation());

  public static User create(User user) {
    return userService.create(user);
  }

  public static List<User> index() {
    return userService.index();
  }

  public static User show(int id) {
    return userService.show(id);
  }

  public static void update(int id, User newUserData) {
    userService.update(id, newUserData);
  }

  public static void remove(int id) {
    userService.remove(id);
  }
}
