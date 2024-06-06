package exercise3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws ParseException {
    Scanner input = new Scanner(System.in);

    System.out.println("Enter client data:");

    System.out.print("Name: ");
    String name = input.nextLine();
    System.out.print("Email: ");
    String email = input.nextLine();
    System.out.print("Birth date (DD/MM/YYYY): ");
    String birthString = input.nextLine();

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date birthDate = formatter.parse(birthString);

    Client client = new Client(name, email, birthDate);

    System.out.println("Enter order data:");

    System.out.print("Status: ");
    String status = input.nextLine();

    Order order = new Order(new Date(), OrderStatus.valueOf(status), client);

    System.out.print("How many items to this order? ");
    int size = input.nextInt();
    input.nextLine();

    for (int i = 0; i < size; i++) {
      System.out.printf("Enter #%d item data:\n", i + 1);

      System.out.print("Product name: ");
      String productName = input.nextLine();
      input.nextLine();

      System.out.print("Product price: ");
      Double price = input.nextDouble();

      System.out.print("Quantity: ");
      Integer quantity = input.nextInt();

      order.addItem(new OrderItem(quantity, new Product(productName, price)));
    }

    input.close();

    System.out.println("ORDER SUMMARY:");

    System.out.println("Order moment: " + order.getMoment());
  }
}
