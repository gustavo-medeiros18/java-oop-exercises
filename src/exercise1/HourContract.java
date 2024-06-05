package exercise1;

import java.util.Date;

public class HourContract {
  private Date date;
  private double valuePerHour;
  private int hours;

  public HourContract(Date date, double valuePerHour, int hours) {
    this.date = date;
    this.valuePerHour = valuePerHour;
    this.hours = hours;
  }

  public Date getDate() {
    return date;
  }

  public double getValuePerHour() {
    return valuePerHour;
  }

  public int getHours() {
    return hours;
  }

  public double totalValue() {
    return this.valuePerHour * this.hours;
  }
}
