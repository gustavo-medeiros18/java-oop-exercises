package exercise6.entities;

public class LegalPerson extends Person {
  private int workersNumber;

  public LegalPerson(String name, Double income, int workersNumber) {
    super(name, income);
    this.workersNumber = workersNumber;
  }

  public int getWorkersNumber() {
    return workersNumber;
  }

  @Override
  public Double calculateTaxes() {
    double taxes = 0.0;

    if (workersNumber > 10)
      taxes = getIncome() * 0.14;
    else
      taxes = getIncome() * 0.16;

    return taxes;
  }
}
