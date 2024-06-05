package exercise1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
  private String name;
  private WorkerLevel level;
  private double baseSalary;
  private Department department;
  private List<HourContract> contracts;

  public Worker(String name, WorkerLevel level, double baseSalary, Department department) {
    this.name = name;
    this.level = level;
    this.baseSalary = baseSalary;
    this.department = department;
    this.contracts = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public Department getDepartment() {
    return department;
  }

  public double getBaseSalary() {
    return baseSalary;
  }

  public void addContract(HourContract contract) {
    this.contracts.add(contract);
  }

  public void removeContract(HourContract contract) {
    this.contracts.remove(contract);
  }

  public double income(int year, int month) {
    double sum = 0;

    for (HourContract contract : contracts) {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(contract.getDate());

      int contractMonth = calendar.get(Calendar.MONTH) + 1,
          contractYear = calendar.get(Calendar.YEAR);

      if (contractYear == year && contractMonth == month)
        sum += contract.totalValue();
    }

    return sum;
  }

  @Override
  public String toString() {
    return "exercise1.Worker{" +
        "name='" + name + '\'' +
        ", level=" + level +
        ", baseSalary=" + baseSalary +
        ", department=" + department +
        ", contracts=" + contracts +
        '}';
  }
}
