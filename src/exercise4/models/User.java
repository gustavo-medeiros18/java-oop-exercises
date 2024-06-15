package exercise4.models;

import java.util.ArrayList;
import java.util.List;

public class User {
  private Integer id;
  private String name;
  private String email;
  private final List<Photo> photos;

  public User(String name, String email) {
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

  public void setId(Integer id) {
    this.id = id;
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
