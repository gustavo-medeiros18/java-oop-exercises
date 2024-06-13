package exercise4;

import exercise4.controllers.PhotoController;
import exercise4.controllers.UserController;
import exercise4.exceptions.PhotoNotFoundException;
import exercise4.exceptions.UserNotFoundException;
import exercise4.factories.PhotoFactory;
import exercise4.factories.UserFactory;
import exercise4.models.Photo;
import exercise4.models.User;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
  // TODO: Lançar exceção caso sejam passados urls e emails inválidos
  // FIXME: Fazer com que uma foto seja movida de usuário caso o userId
  //  dela seja alterado.

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int choice;
    do {
      System.out.println("1. User CRUD");
      System.out.println("2. Photo CRUD");
      System.out.println("0. Exit");
      System.out.print("Enter your choice: ");
      choice = input.nextInt();

      switch (choice) {
        case 1:
          System.out.println("1. Create User");
          System.out.println("2. List a User");
          System.out.println("3. List all Users");
          System.out.println("4. Update User");
          System.out.println("5. Delete User");
          System.out.println("0. Back");
          System.out.print("Enter your choice: ");
          int userChoice = input.nextInt();
          handleUserCrud(userChoice);
          break;
        case 2:
          System.out.println("1. Create Photo");
          System.out.println("2. List a Photo");
          System.out.println("3. List all Photos");
          System.out.println("4. Update Photo");
          System.out.println("5. Delete Photo");
          System.out.println("0. Back");
          System.out.print("Enter your choice: ");
          int photoChoice = input.nextInt();
          handlePhotoCrud(photoChoice);
          break;
        case 0:
          System.out.println("Exiting...");
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    } while (choice != 0);
    input.close();
  }

  private static void handleUserCrud(int choice) {
    Scanner input = new Scanner(System.in);
    switch (choice) {
      case 1:
        System.out.print("Enter user name: ");
        String name = input.nextLine();
        System.out.print("Enter user email: ");
        String email = input.nextLine();
        User user = UserFactory.create(name, email);
        UserController.create(user);
        break;
      case 2:
        System.out.print("Enter user id: ");
        int id = input.nextInt();
        User foundUser = UserController.show(id);
        System.out.println(foundUser);
        break;
      case 3:
        List<User> users = UserController.index();
        for (User u : users) System.out.println(u);
        break;
      case 4:
        boolean validInput = false;
        do {
          try {
            System.out.print("Enter user id: ");
            int userId = input.nextInt();
            input.nextLine();
            System.out.print("Enter new user name: ");
            String newName = input.nextLine();
            System.out.print("Enter new user email: ");
            String newEmail = input.nextLine();
            User newUser = UserFactory.create(newName, newEmail);
            UserController.update(userId, newUser);
            validInput = true;
          } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Please try again.");
          }
        } while (!validInput);
        break;
      case 5:
        System.out.print("Enter user id: ");
        int deleteId = input.nextInt();
        UserController.remove(deleteId);
        break;
      case 0:
        break;
      default:
        System.out.println("Invalid choice. Please try again.");
    }
  }

  private static void handlePhotoCrud(int choice) {
    Scanner input = new Scanner(System.in);
    switch (choice) {
      case 1:
        System.out.print("Enter photo url: ");
        String url = input.nextLine();
        System.out.print("Enter user id: ");
        int userId = input.nextInt();
        Photo photo = PhotoFactory.create(url, new Date(), userId);
        PhotoController.create(photo);
        break;
      case 2:
        System.out.print("Enter photo id: ");
        int id = input.nextInt();
        Photo foundPhoto = PhotoController.show(id);
        System.out.println(foundPhoto);
        break;
      case 3:
        List<Photo> photos = PhotoController.index();
        for (Photo p : photos) System.out.println(p);
        break;
      case 4:
        boolean validInput = false;
        do {
          try {
            System.out.print("Enter photo id: ");
            int photoId = input.nextInt();
            input.nextLine();
            System.out.print("Enter new photo url: ");
            String newUrl = input.nextLine();
            System.out.print("Enter new user id: ");
            int newUserId = input.nextInt();
            Photo newPhoto = PhotoFactory.create(newUrl, new Date(), newUserId);
            PhotoController.update(photoId, newPhoto);
            validInput = true;
          } catch (PhotoNotFoundException | UserNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Please try again.");
          }
        } while (!validInput);
        break;
      case 5:
        System.out.print("Enter photo id: ");
        int deleteId = input.nextInt();
        PhotoController.remove(deleteId);
        break;
      case 0:
        break;
      default:
        System.out.println("Invalid choice. Please try again.");
    }
  }
}