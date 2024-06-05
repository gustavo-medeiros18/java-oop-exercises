package exercise1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws ParseException {
    Scanner input = new Scanner(System.in).useLocale(Locale.US);

    System.out.print("Enter departament's name: ");
    String departmentName = input.nextLine();

    System.out.print("Enter worker data:\nName: ");
    String name = input.nextLine();

    System.out.print("Level: ");
    String level = input.nextLine();

    System.out.print("Base salary: ");
    double baseSalary = input.nextDouble();

    Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(departmentName));

    System.out.print("How many contracts to this worker? ");
    int contractsNumber = input.nextInt();

    for (int i = 0; i < contractsNumber; i++) {
      System.out.printf("Enter contract #%d data:\n", i + 1);

      System.out.print("Date (DD/MM/YYYY): ");
      String date = input.next();
      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

      System.out.print("Value per hour: ");
      double valuePerHour = input.nextDouble();

      System.out.print("Duration (hours): ");
      int duration = input.nextInt();

      worker.addContract(new HourContract(formatter.parse(date), valuePerHour, duration));
    }

    System.out.print("Enter month and year to calculate income (MM/YYYY): ");
    String incomeDate = input.next();
    input.close();

    String[] parts = incomeDate.split("/");
    int month = Integer.parseInt(parts[0]),
        year = Integer.parseInt(parts[1]);

    double income = worker.income(year, month) + worker.getBaseSalary();

    System.out.println("Name: " + worker.getName());
    System.out.println("Departament: " + worker.getDepartment().getName());
    System.out.printf(Locale.US, "Income for %s: %.2f\n", incomeDate, income);
  }
}