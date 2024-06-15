package exercise4.database;

import exercise4.exceptions.UserNotFoundException;
import exercise4.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class UserRepository {
  private static int idCount = 1;
  static List<User> users = new ArrayList<>();

  public static void add(User user) {
    user.setId(idCount++);
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
    OptionalInt indexOpt = IntStream.range(0, users.size())
            .filter(i -> users.get(i).getId() == id)
            .findFirst();

    if (indexOpt.isEmpty())
      throw new UserNotFoundException("User with id " + id + " not found.");

    User user = users.get(indexOpt.getAsInt());

    user.setName(newUserData.getName());
    user.setEmail(newUserData.getEmail());

    users.set(indexOpt.getAsInt(), user);
  }

  public static void delete(int id) {
    User user = find(id);

    if (user == null)
      throw new UserNotFoundException("User with id " + id + " not found.");
    else {
      PhotoRepository.photos.removeIf(photo -> photo.getUserId() == user.getId());
      users.remove(user);
    }
  }
}
