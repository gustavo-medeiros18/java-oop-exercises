package exercise6;

import exercise6.entities.LegalPerson;
import exercise6.entities.Person;
import exercise6.entities.PhysicalPerson;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner input = new Scanner(System.in);

    System.out.print("Enter the number of tax payers: ");
    int size = input.nextInt();

    List<Person> people = new ArrayList<>();

    for (int i = 0; i < size; i++) {
      System.out.printf("Tax payer #%d data:\n", i + 1);

      System.out.print("Individual or company (i/c)? ");
      char type = input.next().charAt(0);

      System.out.print("Name: ");
      String name = input.next();
      System.out.print("Anual income: ");
      double annualIncome = input.nextDouble();

      Person newPerson = null;

      if (type == 'i') {
        System.out.print("Health expenditures: ");
        double healthExpenditures = input.nextDouble();

        newPerson = new PhysicalPerson(name, annualIncome, healthExpenditures);
      } else {
        System.out.print("Number of employees: ");
        int numberOfEmployees = input.nextInt();

        newPerson = new LegalPerson(name, annualIncome, numberOfEmployees);
      }

      people.add(newPerson);
    }
    
    input.close();

    System.out.println();
    System.out.println("TAXES PAID:");

    for (Person person : people)
      System.out.printf("%s: $ %.2f\n", person.getName(), person.calculateTaxes());

    double totalTaxes = 0;

    for (Person person : people)
      totalTaxes += person.calculateTaxes();

    System.out.printf("\nTOTAL TAXES: $ %.2f\n", totalTaxes);
  }
}
