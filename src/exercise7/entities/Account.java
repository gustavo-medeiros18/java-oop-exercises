package exercise7.entities;

import exercise7.exceptions.ExceededLimitException;
import exercise7.exceptions.NotEnoughBalanceException;

public class Account {
  private int number;
  private String holder;
  private double balance;
  private double withdrawLimit;


  public Account(int number, String holder, double initialDeposit, double withdrawLimit) {
    this.number = number;
    this.holder = holder;
    this.withdrawLimit = withdrawLimit;
    deposit(initialDeposit);
  }

  public int getNumber() {
    return number;
  }

  public String getHolder() {
    return holder;
  }

  public double getBalance() {
    return balance;
  }

  public void deposit(double amount) {
    balance += amount;
  }

  public void withdraw(double amount) throws ExceededLimitException, NotEnoughBalanceException {
    if (amount > withdrawLimit)
      throw new ExceededLimitException("The amount exceeds withdraw limit");
    else if (amount > balance)
      throw new NotEnoughBalanceException("Not enough balance");

    balance -= amount;
  }

  public String toString() {
    return "Account " + number + ", Holder: " + holder + ", Balance: $ " + String.format("%.2f", balance);
  }
}
