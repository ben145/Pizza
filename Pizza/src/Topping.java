import java.util.ArrayList;
import java.util.List;

public class Topping {

    private String name;
    private int count;
    private String type; // meat, vegetable, or cheese
    private double price; // in 0x.xx format

    public Topping(String n, int c, String t, double p) {
        name = n;
        count = c;
        type = t;
        price = p;
    }

    public Topping() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void upCount() {
        count += 1;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}