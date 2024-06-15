package exercise4.services;

import exercise4.database.UserRepository;
import exercise4.exceptions.InvalidEmailException;
import exercise4.models.User;
import exercise4.strategies.ValidationStrategy;

import java.util.List;

public class UserService {
  private final ValidationStrategy validator;

  public UserService(ValidationStrategy validator) {
    this.validator = validator;
  }

  public User create(User user) {
    if (this.validator.isValid(user.getEmail()))
      throw new InvalidEmailException("Invalid email address!");

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
    if (this.validator.isValid(newUserData.getEmail()))
      throw new InvalidEmailException("Invalid email address!");

    UserRepository.update(id, newUserData);
  }

  public void remove(int id) {
    UserRepository.delete(id);
  }
}
