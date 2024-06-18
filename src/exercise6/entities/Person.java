package exercise6.entities;

public abstract class Person {
  private String name;
  private Double income;

  public Person(String name, Double income) {
    this.name = name;
    this.income = income;
  }

  public String getName() {
    return name;
  }

  public Double getIncome() {
    return income;
  }

  public abstract Double calculateTaxes();
}
