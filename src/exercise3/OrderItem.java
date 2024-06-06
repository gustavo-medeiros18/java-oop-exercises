package exercise3;

public class OrderItem {
  private final Integer quantity;
  private final Double price;
  private final Product product;

  public OrderItem(Integer quantity, Product product) {
    this.quantity = quantity;
    this.product = product;

    this.price = this.quantity * this.product.getPrice();
  }

  public Integer getQuantity() {
    return quantity;
  }

  public Product getProduct() {
    return product;
  }

  public Double subTotal() {
    return price;
  }

  @Override
  public String toString() {
    return "OrderItem{" +
        "quantity=" + quantity +
        ", price=" + price +
        ", product=" + product +
        '}';
  }
}
