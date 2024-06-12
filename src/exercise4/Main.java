package exercise4;


import exercise4.controllers.PhotoController;
import exercise4.controllers.UserController;

import exercise4.models.Photo;
import exercise4.models.User;

import java.util.Date;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // Criando três usuários
    UserController.create("User1", "user1@email.com");
    UserController.create("User2", "user2@email.com");
    UserController.create("User3", "user3@email.com");

    // Exibindo os usuários criados
    List<User> users = UserController.index();
    for (User user : users) {
      System.out.println(user);
    }

    PhotoController.create("https://photo1.com", new Date(), 1);
    PhotoController.create("https://photo2.com", new Date(), 2);

    List<Photo> photos = PhotoController.index();

    for (Photo photo : photos) {
      System.out.println(photo);
    }
  }
}