package exercise4;


import exercise4.controllers.UserController;

import exercise4.models.User;

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
      System.out.println("ID: " + user.getId() + ", Name: " + user.getName() + ", Email: " + user.getEmail());
    }
  }
}