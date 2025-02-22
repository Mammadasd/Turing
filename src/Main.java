import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Customer c1 = new Customer(1, "Məmmədəli Şabanov", "mammadali@mail.com");
        Customer c2 = new Customer(2, "Əli Məmmədov", "ali@mail.com");
        Customer c3 = new Customer(3, "Aytac Hüseynova", "aytac@mail.com");
        Customer c4 = new Customer(4, "Murad Quliyev", "murad@mail.com");
        Customer c5 = new Customer(5, "Leyla Əliyeva", "leyla@mail.com");

        Product p1 = new Product(1, "Noutbuk", 1200);
        Product p2 = new Product(2, "Telefon", 850);
        Product p3 = new Product(3, "Planşet", 450);
        Product p4 = new Product(4, "Qulaqcıq", 150);
        Product p5 = new Product(5, "Klaviatura", 250);
        Product p6 = new Product(6, "Monitor", 700);
        Product p7 = new Product(7, "Printer", 600);
        Product p8 = new Product(8, "Powerbank", 100);

        List<Order> orders = Arrays.asList(
                new Order(101, c1, Arrays.asList(p1, p3, p4), LocalDate.now().minusDays(10)),
                new Order(102, c2, Arrays.asList(p2, p8), LocalDate.now().minusDays(40)),
                new Order(103, c1, Arrays.asList(p3, p3, p5), LocalDate.now()),
                new Order(104, c3, Arrays.asList(p6, p7), LocalDate.now().minusDays(5)),
                new Order(105, c4, Arrays.asList(p1, p2, p3), LocalDate.now().minusDays(20)),
                new Order(106, c5, Arrays.asList(p5, p4, p8, p8), LocalDate.now().minusDays(2)),
                new Order(107, c2, Arrays.asList(p1, p4), LocalDate.now().minusDays(15)),
                new Order(108, c3, Arrays.asList(p2, p3, p4), LocalDate.now().minusDays(25)),
                new Order(109, c5, Arrays.asList(p6), LocalDate.now().minusDays(8)),
                new Order(110, c4, Arrays.asList(p7, p5, p8), LocalDate.now())
        );


    }
}
