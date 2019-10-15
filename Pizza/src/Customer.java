import java.util.ArrayList;
import java.util.List;


public class Customer {

    private String name;
    private List<Object> order;

    public Customer() {
        name = "Joe Blow";
        order = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Object> getOrder() {
        return order;
    }
    public void addToOrder(Pizza order) {
        this.order.add(order);
    }
}
