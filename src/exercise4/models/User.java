package exercise4.models;

import java.util.ArrayList;
import java.util.List;

public class User {
  private final Integer id;
  private String name;
  private String email;
  private List<Photo> photos;

  public User(int id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.photos = new ArrayList<>();
  }

  public User(String name, String email) {
    this.id = null;
    this.name = name;
    this.email = email;
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

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
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
