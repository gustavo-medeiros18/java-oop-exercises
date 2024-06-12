package exercise4.services;

import exercise4.database.UserRepository;
import exercise4.factories.UserFactory;
import exercise4.models.User;
import exercise4.strategies.ValidationStrategy;

import java.util.List;

public class UserService {
  private ValidationStrategy validator;

  public UserService(ValidationStrategy validator) {
    this.validator = validator;
  }

  public User create(User user) {
    if (!this.validator.isValid(user.getEmail())) {
      System.out.println("Email address is invalid!");
      return null;
    }

    UserRepository.add(user);

    return user;
  }

  public List<User> index() {
    return UserRepository.all();
  }

  public User show(int id) {
    return UserRepository.find(id);
  }

  // update method
  public void update(int id, User newUserData) {
    UserRepository.update(id, newUserData);
  }

  public void remove(int id) {
    UserRepository.delete(id);
  }
}
