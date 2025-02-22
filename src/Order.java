import java.time.LocalDate;
import java.util.List;

public class Order {

    private int id;
    private Customer customer;
    private List<Product> productLis;
    private double totalAmount;
    private LocalDate orderDate;


    public Order(int id, Customer customer, List<Product> productLis, LocalDate orderDate) {
        this.id = id;
        this.customer = customer;
        this.productLis = productLis;
        this.orderDate = orderDate;
        this.totalAmount=productLis.stream().mapToDouble(Product::getPrice).sum();
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProductLis() {
        return productLis;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Order #" + id + " Total: $" + totalAmount;
    }
}
