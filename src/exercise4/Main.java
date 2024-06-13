package exercise4;

import exercise4.controllers.PhotoController;
import exercise4.controllers.UserController;

import exercise4.factories.PhotoFactory;
import exercise4.factories.UserFactory;
import exercise4.models.Photo;
import exercise4.models.User;

import java.util.Date;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    testUserCreation();
    testUserDisplay();
    testUserUpdate();
    testUserDeletion();

    testPhotoCreation();

    testUserDisplay();

    testPhotoDisplay();
    testPhotoDeletion();
    testUserDisplay();

    testPhotoUpdate();
    testUserDisplay();
  }

  private static void testUserCreation() {
    System.out.println("Testing User Creation:");

    User user1 = UserFactory.create("User1", "user1@email.com");
    User user2 = UserFactory.create("User2", "user2@email.com");
    User user3 = UserFactory.create("User3", "user3@email.com");

    UserController.create(user1);
    UserController.create(user2);
    UserController.create(user3);

    List<User> users = UserController.index();
    for (User user : users) {
      System.out.println(user);
    }
    System.out.println("User Creation Test Completed.\n");
  }

  private static void testUserDisplay() {
    System.out.println("Testing User Display:");
    User user = UserController.show(1);
    System.out.println(user);
    System.out.println("User Display Test Completed.\n");
  }

  private static void testUserUpdate() {
    System.out.println("Testing User Update:");
    UserController.update(1, new User("User1Updated", "newemail.com"));
    List<User> users = UserController.index();
    for (User user : users) {
      System.out.println(user);
    }
    System.out.println("User Update Test Completed.\n");
  }

  private static void testUserDeletion() {
    System.out.println("Testing User Deletion:");
    UserController.remove(2);
    List<User> users = UserController.index();
    for (User user : users) {
      System.out.println(user);
    }
    System.out.println("User Deletion Test Completed.\n");
  }

  private static void testPhotoCreation() {
    System.out.println("Testing Photo Creation:");

    Photo photo1 = PhotoFactory.create("https://photo1.com", new Date(), 1);
    Photo photo2 = PhotoFactory.create("https://photo2.com", new Date(), 1);

    PhotoController.create(photo1);
    PhotoController.create(photo2);

    List<Photo> photos = PhotoController.index();
    for (Photo photo : photos) {
      System.out.println(photo);
    }
    System.out.println("Photo Creation Test Completed.\n");
  }

  private static void testPhotoDisplay() {
    System.out.println("Testing Photo Display:");
    Photo photo = PhotoController.show(1);
    System.out.println(photo);
    System.out.println("Photo Display Test Completed.\n");
  }

  private static void testPhotoUpdate() {
    System.out.println("Testing Photo Update:");
    PhotoController.update(1, new Photo("https://photo1updated.com", new Date(), 1));
    List<Photo> photos = PhotoController.index();
    for (Photo photo : photos) {
      System.out.println(photo);
    }
    System.out.println("Photo Update Test Completed.\n");
  }

  private static void testPhotoDeletion() {
    System.out.println("Testing Photo Deletion:");
    PhotoController.remove(2);
    List<Photo> photos = PhotoController.index();
    for (Photo photo : photos) {
      System.out.println(photo);
    }
    System.out.println("Photo Deletion Test Completed.\n");
  }
}