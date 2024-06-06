package exercise3;

import java.util.Date;

public class Client {
  private final String name;
  private final String email;
  private final Date birthDate;

  public Client(String name, String email, Date birthDate) {
    this.name = name;
    this.email = email;
    this.birthDate = birthDate;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  @Override
  public String toString() {
    return "Client{" +
        "name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", birthDate=" + birthDate +
        '}';
  }
}
