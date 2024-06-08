package exercise4.models;

import java.util.ArrayList;
import java.util.List;

public class User {
  private final int id;
  private String name;
  private String email;
  private List<Photo> photos;

  public User(int id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.photos = new ArrayList<>();
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public List<Photo> getPhotos() {
    return photos;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", photos=" + photos +
            '}';
  }
}
