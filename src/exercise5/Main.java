package exercise5;

import exercise5.entities.ImportedProduct;
import exercise5.entities.Product;
import exercise5.entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
  public static void main(String[] args) throws ParseException {
    Locale.setDefault(Locale.US);

    Scanner input = new Scanner(System.in);

    System.out.print("Enter the number of products: ");
    int size = input.nextInt();

    List<Product> products = new ArrayList<>();

    for (int i = 0; i < size; i++) {
      System.out.printf("Product #%d data:\n", i + 1);

      System.out.print("Common, used or imported (c/u/i)? ");
      char type = input.next().charAt(0);

      System.out.print("Name: ");
      String name = input.next();
      System.out.print("Price: ");
      Double price = input.nextDouble();

      Product newProduct = null;

      if (type == 'i') {
        System.out.print("Custom fee: ");
        Double fee = input.nextDouble();

        newProduct = new ImportedProduct(name, price, fee);
      } else if(type == 'u') {
        System.out.print("Manufacture date (DD/MM/YYYY): ");
        String date = input.next();

        newProduct = new UsedProduct(name, price, formatDate(date));
      } else {
        newProduct = new Product(name, price);
      }

      products.add(newProduct);
    }

    System.out.println();

    System.out.println("PRICE TAGS:");
    for (Product p: products)
      System.out.println(p.priceTag());
  }

  public static Date formatDate(String dateString) throws ParseException {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    return formatter.parse(dateString);
  }
}
