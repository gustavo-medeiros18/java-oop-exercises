package exercise5.entities;

import java.util.Date;

public class UsedProduct extends Product {
  private Date manufactureDate;

  public UsedProduct(String name, Double price, Date manufactureDate) {
    super(name, price);
    this.manufactureDate = manufactureDate;
  }

  public Date getManufactureDate() {
    return manufactureDate;
  }

  @Override
  public final String priceTag() {
    return getName() +
        " (used) $ " +
        String.format("%.2f", getPrice()) +
        " (Manufacture date: " +
        manufactureDate +
        ")";
  }
}
