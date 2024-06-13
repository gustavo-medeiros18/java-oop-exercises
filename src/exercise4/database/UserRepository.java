package exercise4.database;

import exercise4.exceptions.UserNotFoundException;
import exercise4.models.Photo;
import exercise4.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
  static List<User> users = new ArrayList<>();

  public static void add(User user) {
    users.add(user);
  }

  public static User find(int id) {
    for (User user : users) {
      if (user.getId() == id) {
        return user;
      }
    }
    return null;
  }

  public static User findByEmail(String email) {
    for (User user : users) {
      if (user.getEmail().equals(email)) {
        return user;
      }
    }
    return null;
  }

  public static List<User> all() {
    return users;
  }

  public static void update(int id, User newUserData) {
    User user = find(id);

    if (user == null)
      throw new UserNotFoundException("User with id " + id + " not found.");

    user.setName(newUserData.getName());
    user.setEmail(newUserData.getEmail());

    users.set(id - 1, user);
  }

  public static void delete(int id) {
    User user = find(id);
    users.remove(user);
  }
}
