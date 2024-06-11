package exercise4;

import exercise4.controllers.PhotoController;
import exercise4.controllers.UserController;
import exercise4.models.Photo;
import exercise4.models.User;

import java.util.Date;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter user's name: ");
    String name = input.nextLine();

    System.out.print("Enter user's email: ");
    String email = input.next();

    User user = UserController.createUser(name, email);
    System.out.println(user);

    System.out.println("-------------------");

    System.out.print("Enter photo's user ID: ");
    int id = input.nextInt();

    System.out.print("Enter photo's URL: ");
    String url = input.next();

    Photo photo = PhotoController.createPhoto(url, new Date(), id);
    System.out.println(photo);
  }
}
