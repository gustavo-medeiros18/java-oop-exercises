package exercise4;

import exercise4.controllers.PhotoController;
import exercise4.controllers.UserController;

import exercise4.models.Photo;
import exercise4.models.User;

import java.util.Date;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    testUserCreation();
    testPhotoCreation();
    testUserDisplay();
    testUserDeletion();
  }

  private static void testUserCreation() {
    System.out.println("Testing User Creation:");
    UserController.create("User1", "user1@email.com");
    UserController.create("User2", "user2@email.com");
    UserController.create("User3", "user3@email.com");

    List<User> users = UserController.index();
    for (User user : users) {
      System.out.println(user);
    }
    System.out.println("User Creation Test Completed.\n");
  }

  private static void testPhotoCreation() {
    System.out.println("Testing Photo Creation:");
    PhotoController.create("https://photo1.com", new Date(), 1);
    PhotoController.create("https://photo2.com", new Date(), 2);

    List<Photo> photos = PhotoController.index();
    for (Photo photo : photos) {
      System.out.println(photo);
    }
    System.out.println("Photo Creation Test Completed.\n");
  }

  private static void testUserDisplay() {
    System.out.println("Testing User Display:");
    User user = UserController.show(1);
    System.out.println(user);
    System.out.println("User Display Test Completed.\n");
  }

  private static void testUserDeletion() {
    System.out.println("Testing User Deletion:");
    UserController.remove(1);
    List<User> users = UserController.index();
    for (User user : users) {
      System.out.println(user);
    }
    System.out.println("User Deletion Test Completed.\n");
  }
}