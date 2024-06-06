package exercise3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
  private final Date moment;
  private final OrderStatus status;
  private final List<OrderItem> items;
  private final Client client;

  public Order(Date moment, OrderStatus status, Client client) {
    this.moment = moment;
    this.status = status;
    this.client = client;
    this.items = new ArrayList<>();
  }

  public Date getMoment() {
    return moment;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public List<OrderItem> getItems() {
    return items;
  }

  public Client getClient() {
    return client;
  }

  public void addItem(OrderItem item) {
    this.items.add(item);
  }

  public void removeItem(OrderItem item) {
    this.items.remove(item);
  }

  public Double total() {
    Double totalSum = null;

    for (OrderItem item: items)
      totalSum += item.subTotal();

    return totalSum;
  }

  @Override
  public String toString() {
    return "Order{" +
        "moment=" + moment +
        ", status=" + status +
        ", items=" + items +
        ", client=" + client.toString() +
        '}';
  }
}
