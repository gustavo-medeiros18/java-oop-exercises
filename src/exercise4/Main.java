package exercise4;

import exercise4.controllers.UserController;
import exercise4.models.User;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter user's name: ");
    String name = input.nextLine();

    System.out.print("Enter user's email: ");
    String email = input.nextLine();

    User user = UserController.createUser(name, email);
    System.out.println(user);
  }
}
