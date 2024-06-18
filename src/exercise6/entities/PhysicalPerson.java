package exercise6.entities;

public class PhysicalPerson extends Person {
  private double healthSpending;

  public PhysicalPerson(String name, Double income, double healthSpending) {
    super(name, income);
    this.healthSpending = healthSpending;
  }

  public double getHealthSpending() {
    return healthSpending;
  }

  @Override
  public Double calculateTaxes() {
    double taxes = 0;

    if (this.getIncome() < 20000)
      taxes = this.getIncome() * 0.15 - healthSpending * 0.5;
    else if (this.getIncome() >= 20000)
      taxes = this.getIncome() * 0.25 - healthSpending * 0.5;

    return taxes;
  }
}
