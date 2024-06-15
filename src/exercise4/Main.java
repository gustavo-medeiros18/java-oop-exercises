package exercise4;

import exercise4.controllers.PhotoController;
import exercise4.controllers.UserController;
import exercise4.exceptions.InvalidEmailException;
import exercise4.exceptions.InvalidUrlException;
import exercise4.exceptions.PhotoNotFoundException;
import exercise4.exceptions.UserNotFoundException;
import exercise4.factories.PhotoFactory;
import exercise4.factories.UserFactory;
import exercise4.models.Photo;
import exercise4.models.User;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int choice;

    do {
      System.out.println("1. User CRUD");
      System.out.println("2. Photo CRUD");
      System.out.println("0. Exit");
      System.out.print("Enter your choice: ");

      try {
        choice = input.nextInt();

        switch (choice) {
          case 1:
            handleUserCrud();
            break;
          case 2:
            handlePhotoCrud();
            break;
          case 0:
            System.out.println("Exiting...");
            break;
          default:
            System.out.println("Invalid choice. Please try again.");
        }
      } catch (InputMismatchException e) {
        System.out.println("Invalid choice. Please enter a valid number.");
        input.next();
        choice = -1;
      }
    } while (choice != 0);

    input.close();
  }

  private static void handleUserCrud() {
    Scanner input = new Scanner(System.in);
    int userChoice;
    try {
      do {
        System.out.println("1. Create User");
        System.out.println("2. List a User");
        System.out.println("3. List all Users");
        System.out.println("4. Update User");
        System.out.println("5. Delete User");
        System.out.println("0. Back");
        System.out.print("Enter your choice: ");
        userChoice = input.nextInt();
        input.nextLine();  // Consume newline

        switch (userChoice) {
          case 1:
            try {
              System.out.print("Enter user name (or type 'cancel' to go back): ");
              String name = input.nextLine();
              if (name.equalsIgnoreCase("cancel")) break;
              System.out.print("Enter user email (or type 'cancel' to go back): ");
              String email = input.nextLine();
              if (email.equalsIgnoreCase("cancel")) break;
              User user = UserFactory.create(name, email);
              UserController.create(user);
            } catch (InvalidEmailException e) {
              System.out.println(e.getMessage());
            }
            break;
          case 2:
            try {
              System.out.print("Enter user id (or type 'cancel' to go back): ");
              String idInput = input.nextLine();
              if (idInput.equalsIgnoreCase("cancel")) break;
              int id = Integer.parseInt(idInput);
              User foundUser = UserController.show(id);
              System.out.println(foundUser);
            } catch (RuntimeException e) {
              if (e instanceof NumberFormatException) System.out.println("Invalid user id. Please try again.");
              else if (e instanceof UserNotFoundException) System.out.println(e.getMessage());
              else System.out.println("An error occurred. Please try again.");
            }
            break;
          case 3:
            List<User> users = UserController.index();
            for (User u : users) System.out.println(u);
            break;
          case 4:
            boolean validInput = false;
            do {
              try {
                System.out.print("Enter user id (or type 'cancel' to go back): ");
                String userIdInput = input.nextLine();
                if (userIdInput.equalsIgnoreCase("cancel")) break;
                int userId = Integer.parseInt(userIdInput);
                System.out.print("Enter new user name (or type 'cancel' to go back): ");
                String newName = input.nextLine();
                if (newName.equalsIgnoreCase("cancel")) break;
                System.out.print("Enter new user email (or type 'cancel' to go back): ");
                String newEmail = input.nextLine();
                if (newEmail.equalsIgnoreCase("cancel")) break;
                User newUser = UserFactory.create(newName, newEmail);
                UserController.update(userId, newUser);
                validInput = true;
              } catch (RuntimeException e) {
                if (e instanceof UserNotFoundException || e instanceof InvalidEmailException)
                  System.out.println(e.getMessage());
                else if (e instanceof NumberFormatException) System.out.println("Invalid user id. Please try again.");
                else System.out.println("An error occurred. Please try again.");
              }
            } while (!validInput);
            break;
          case 5:
            try {
              System.out.print("Enter user id (or type 'cancel' to go back): ");
              String deleteIdInput = input.nextLine();
              if (deleteIdInput.equalsIgnoreCase("cancel")) break;
              int deleteId = Integer.parseInt(deleteIdInput);
              UserController.remove(deleteId);
            } catch (RuntimeException e) {
              if (e instanceof NumberFormatException) System.out.println("Invalid user id. Please try again.");
              else if (e instanceof UserNotFoundException) System.out.println(e.getMessage());
              else System.out.println("An error occurred. Please try again.");
            }
            break;
          case 0:
            break;
          default:
            System.out.println("Invalid choice. Please try again.");
        }
      } while (userChoice != 0);
    } catch (InputMismatchException e) {
      System.out.println("Invalid choice. Please try again.");
    }
  }

  private static void handlePhotoCrud() {
    Scanner input = new Scanner(System.in);
    int photoChoice;
    try {
      do {
        System.out.println("1. Create Photo");
        System.out.println("2. List a Photo");
        System.out.println("3. List all Photos");
        System.out.println("4. Update Photo");
        System.out.println("5. Delete Photo");
        System.out.println("0. Back");
        System.out.print("Enter your choice: ");
        photoChoice = input.nextInt();
        input.nextLine();  // Consume newline

        switch (photoChoice) {
          case 1:
            try {
              System.out.print("Enter photo url (or type 'cancel' to go back): ");
              String url = input.nextLine();
              if (url.equalsIgnoreCase("cancel")) break;
              System.out.print("Enter user id (or type 'cancel' to go back): ");
              String userIdInput = input.nextLine();
              if (userIdInput.equalsIgnoreCase("cancel")) break;
              int userId = Integer.parseInt(userIdInput);
              Photo photo = PhotoFactory.create(url, new Date(), userId);
              PhotoController.create(photo);
            } catch (RuntimeException e) {
              if (e instanceof UserNotFoundException || e instanceof InvalidUrlException)
                System.out.println(e.getMessage());
              else if (e instanceof NumberFormatException)
                System.out.println("Invalid user id. Please try again.");
              else System.out.println("An error occurred. Please try again.");
            }
            break;
          case 2:
            try {
              System.out.print("Enter photo id (or type 'cancel' to go back): ");
              String idInput = input.nextLine();
              if (idInput.equalsIgnoreCase("cancel")) break;
              int id = Integer.parseInt(idInput);
              Photo foundPhoto = PhotoController.show(id);
              System.out.println(foundPhoto);
            } catch (NumberFormatException e) {
              System.out.println("Invalid photo id. Please try again.");
            }
            break;
          case 3:
            List<Photo> photos = PhotoController.index();
            for (Photo p : photos) System.out.println(p);
            break;
          case 4:
            boolean validInput = false;
            do {
              try {
                System.out.print("Enter photo id (or type 'cancel' to go back): ");
                String photoIdInput = input.nextLine();
                if (photoIdInput.equalsIgnoreCase("cancel")) break;
                int photoId = Integer.parseInt(photoIdInput);
                System.out.print("Enter new photo url (or type 'cancel' to go back): ");
                String newUrl = input.nextLine();
                if (newUrl.equalsIgnoreCase("cancel")) break;
                System.out.print("Enter new user id (or type 'cancel' to go back): ");
                String newUserIdInput = input.nextLine();
                if (newUserIdInput.equalsIgnoreCase("cancel")) break;
                int newUserId = Integer.parseInt(newUserIdInput);
                Photo newPhoto = PhotoFactory.create(newUrl, new Date(), newUserId);
                PhotoController.update(photoId, newPhoto);
                validInput = true;
              } catch (RuntimeException e) {
                if (e instanceof PhotoNotFoundException || e instanceof UserNotFoundException || e instanceof InvalidUrlException) {
                  System.out.println(e.getMessage());
                  System.out.println("Please try again.");
                } else if (e instanceof NumberFormatException)
                  System.out.println("Invalid photo id. Please try again.");
                else System.out.println("An error occurred. Please try again.");
              }
            } while (!validInput);
            break;
          case 5:
            try {
              System.out.print("Enter photo id (or type 'cancel' to go back): ");
              String deleteIdInput = input.nextLine();
              if (deleteIdInput.equalsIgnoreCase("cancel")) break;
              int deleteId = Integer.parseInt(deleteIdInput);
              PhotoController.remove(deleteId);
            } catch (NumberFormatException e) {
              System.out.println("Invalid photo id. Please try again.");
            }
            break;
          case 0:
            break;
          default:
            System.out.println("Invalid choice. Please try again.");
        }
      } while (photoChoice != 0);
    } catch (InputMismatchException e) {
      System.out.println("Invalid choice. Please try again.");
    }
  }
}
