package exercise7;

import exercise7.entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    System.out.println("Enter account data");
    Scanner input = new Scanner(System.in);

    System.out.print("Number: ");
    int accountNumber = input.nextInt();

    System.out.print("Holder: ");
    input.nextLine();
    String holder = input.nextLine();

    System.out.print("Initial balance: ");
    double initialBalance = input.nextDouble();

    System.out.print("Withdraw limit: ");
    double withdrawLimit = input.nextDouble();

    Account account = new Account(accountNumber, holder, initialBalance, withdrawLimit);

    System.out.println();
    System.out.print("Enter amount for withdraw: ");

    double amount = input.nextDouble();
    input.close();

    try {
      account.withdraw(amount);
      System.out.printf("New balance: %.2f\n", account.getBalance());
    } catch (Exception e) {
      System.out.println("Withdraw error: " + e.getMessage());
    }
  }
}
