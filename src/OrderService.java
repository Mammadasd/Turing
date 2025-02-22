import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderService {


    public List<Customer> topMostSpendigCustomer(List<Order> orders,int top){

        return orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer ,Collectors.summingDouble(Order::getTotalAmount)))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(top)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Product mostSellerProduct(List<Order> orders) {

        return orders.stream()
                .flatMap(order -> order.getProductLis().stream())
                .collect(Collectors.groupingBy(product -> product, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

    }

    public Map<Customer,Double> avarageOrderPerCustomer(List<Order> orders){

        return orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer,Collectors.averagingDouble(order->1)));
    }

    public double totalRevenue(List<Order> orders){

        return orders.stream()
                .mapToDouble(Order::getTotalAmount)
                .sum();
    }




    public List<Order> ordersPerCustomer(List<Order> order){
        LocalDate monthAgo = LocalDate.now().minusMonths(1);
        return order.stream()
                .filter(o->o.getOrderDate().isAfter(monthAgo))
                .collect(Collectors.toList());
    }

    public Map<Customer,Double> customerOrderSummery(List<Order> orders){

        return orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer,Collectors.summingDouble(Order::getTotalAmount)));

    }

    public List<Order> expensivePurchases(List<Order> orders){

        return orders.stream()
                .filter(order -> order.getTotalAmount()>1000)
                .collect(Collectors.toList());

    }
}

