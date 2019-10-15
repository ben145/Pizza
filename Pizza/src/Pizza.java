import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Pizza extends Customer{

    private String specialtyName;
    private double price;
    private int sauceCount;
    private List<Topping> meats;
    private List<Topping> vegs;
    private List<Topping> cheeses;

    private final int MAX_OPTIONS = 3;

    public ArrayList<Topping> getToppings() {

        ArrayList<Topping> t = new ArrayList<>();
        Topping mozzarella = new Topping("Mozzarella", 0,"cheese", 0.49); t.add(mozzarella);
        Topping cheddar = new Topping("Cheddar", 0,"cheese", 0.49); t.add(cheddar);
        Topping pepperoni = new Topping("Pepperoni", 0,"meat", 0.69); t.add(pepperoni);
        Topping sausage = new Topping("Sausage", 0,"meat", 0.69); t.add(sausage);
        Topping bacon = new Topping("Bacon", 0,"meat", 0.69); t.add(bacon);
        Topping ham = new Topping("Ham", 0,"meat", 0.69); t.add(ham);
        Topping chicken = new Topping("Chicken", 0,"meat", 0.89); t.add(chicken);
        Topping onion = new Topping("Onion", 0,"vegetable", 0.59); t.add(onion);
        Topping olives = new Topping("Olives", 0,"vegetable", 0.59); t.add(olives);
        Topping tomatoes = new Topping("Tomatoes", 0,"vegetable", 0.59); t.add(tomatoes);
        Topping gPeppers = new Topping("Green Peppers", 0,"vegetable", 0.59); t.add(gPeppers);
        Topping bPeppers = new Topping("Banana Peppers", 0,"vegetable", 0.59); t.add(bPeppers);
        Topping spinach = new Topping("Spinach", 0,"vegetable", 0.59); t.add(spinach);
        Topping sauce = new Topping("Sauce", 0,"other", 0.49); t.add(sauce);
        return t;
    }

    public Pizza() {
        specialtyName = null;
        price = 0.0;
        sauceCount = 0;
        meats = new ArrayList<>();
        vegs = new ArrayList<>();
        cheeses = new ArrayList<>();
        cheeses.add(getToppings().get(0));
    }

    public void addMeat(Topping m) {
        if (!exceedsMax(m)) {
            boolean shouldAdd = true;
            for (int i = 0; i < meats.size(); i++) {
                if (meats.get(i).getName().equals(m.getName())) {
                    meats.get(i).upCount();
                    shouldAdd = false;
                }
            }
            if (shouldAdd) {
                meats.add(m);
                m.upCount();
            }
        }
    }
    public void removeMeat(Topping m) {
        if (meats.contains(m))
            meats.remove(m);
        else
            System.out.println("No "+m.getName()+" has been added yet.");
    }
    public void addVeg(Topping v) {
        if (!exceedsMax(v)) {
            boolean shouldAdd = true;
            for (int i = 0; i < vegs.size(); i++) {
                if (vegs.get(i).getName().equals(v.getName())) {
                    vegs.get(i).upCount();
                    shouldAdd = false;
                }
            }
            if (shouldAdd) {
                vegs.add(v);
                v.upCount();
            }
        }
    }
    public void removeVeg(Topping v) {
        if (vegs.contains(v))
            vegs.remove(v);
        else
            System.out.println("No "+v.getName()+" has been added yet.");
    }
    public void addCheese(Topping c) {
        if (!exceedsMax(c)) {
            boolean shouldAdd = true;
            for (int i = 0; i < cheeses.size(); i++) {
                if (cheeses.get(i).getName().equals(c.getName())) {
                    cheeses.get(i).upCount();
                    shouldAdd = false;
                }
            }
            if (shouldAdd) {
                cheeses.add(c);
                c.upCount();
            }
        }
    }
    public void removeCheese(Topping c) {
        if (cheeses.contains(c))
            cheeses.remove(c);
        else
            System.out.println("No "+c.getName()+" has been added yet.");
    }

    public boolean exceedsMax(Topping t) {
        // if topping count is already 2, cannot add more
        if (t.getCount() > 1) {
            System.out.println("You have reached your maximum quantity of "+t.getName()+".");
            return true;
        }
        int sauce;
        if (sauceCount == 0)
            sauce = 0;
        else
            sauce = sauceCount - 1;
        if ((getMeatCount() + getVegCount() + getCheeseCount() + sauce) > 5) {
            System.out.println("You have reached your maximum quantity of toppings.");
            return true;
        }
        // at most 5 meat quantities
        if (t.getType().equals("meat") && getMeatCount() > 4) {
            System.out.println("You have reached your maximum quantity of meats.");
            return true;
        }
        // at most 6 veg quantities
        if (t.getType().equals("vegetable") && getVegCount() > 5) {
            System.out.println("You have reached your maximum quantity of vegetables.");
            return true;
        }
        // at most 3 cheese quantities
        if (t.getType().equals("cheese") && getCheeseCount() > 2) {
            System.out.println("You have reached your maximum quantity of cheeses.");
            return true;
        }
        // at most 2 sauce quantities
        if (t.getType().equals("other") && sauceCount > 1) {
            System.out.println("You have reached your maximum quantity of cheeses.");
            return true;
        }
        return false;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }
    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getMeatCount() {
        int meatCount = 0;
        for (int i = 0; i < meats.size(); i++)
            meatCount += meats.get(i).getCount();
        return meatCount;
    }
    public int getVegCount() {
        int vegCount = 0;
        for (int i = 0; i < vegs.size(); i++)
            vegCount += vegs.get(i).getCount();
        return vegCount;
    }
    public int getCheeseCount() {
        int cheeseCount = 0;
        for (int i = 0; i < cheeses.size(); i++)
            cheeseCount += cheeses.get(i).getCount();
        return cheeseCount;
    }
    public int getSauceCount() {
        return sauceCount;
    }
    public List<Topping> getMeats() {
        return meats;
    }
    public List<Topping> getVegs() {
        return vegs;
    }
    public List<Topping> getCheeses() {
        return cheeses;
    }
    public void listOptions() {
        System.out.println("\n1. Pizza\n2. Calzone\n3. Crazy Bread");
    }
    public int getOption(int o) {
        System.out.print("\nJOE: ");
        if (o == 1) {
            System.out.println("A pizza?!?!? WELL, let's get started!\nHey, Tony! Get out here and make this guy's pizza, capisce?");
            System.out.println("\n(TONY walks in)");
            return o;
        }
        if (o == 2)
            System.out.println("We all outs of da calzones.");
        if (o == 3)
            System.out.println("The crazy bread just ain't as crazy as it used to be...");
        initialDisplay();
        return 0;
    }
    public void doOption(int d) {
        if (d == 1)
            pizzaProcess();
    }
    public Pizza pizzaProcess() {
        Pizza p = new Pizza();
        addToOrder(p);
        Scanner s = new Scanner(System.in);
        String sauceOK;
        System.out.print("\nTONY: Hey, so uh, you want sauce on dis thing?\n-> ");
        sauceOK = s.next().toLowerCase();
        if (sauceOK.substring(0,1).equals("y")) {
            System.out.println("You da boss, so we addin' sauce!");
            sauceCount += 1;
        } else {
            System.out.println("One of dem sauceless pizzehs? Whatever you say ...");
        }
        return p;
    }
    public String printOrder() {
        String toReturn = "";
        return toReturn;
    }
    public void initialDisplay() {
        Scanner s = new Scanner(System.in);
        System.out.println("\n\nWhat would you like to order?");
        listOptions();
        System.out.print("\n-> ");
        String option = s.next();
        ArrayList<String> ints = new ArrayList<>();
        ints.add("1");
        ints.add("2");
        ints.add("3");
        String firstChar = option.substring(0, 1);
        if (ints.contains(firstChar)) {
            int d = getOption(Integer.parseInt(option));
            doOption(d);
        }
        else {
            Random rand = new Random();
            int i = rand.nextInt(getSayings().size());
            System.out.println(getSayings().get(i));
        }
        initialDisplay();
    }
    public List<String> getSayings() {
        List<String> sayings = new ArrayList<>();
        String s1 = "C'mon I ain't got time for dis!...";
        String s2 = "That's not on the menu!";
        String s3 = "What the...";
        String s4 = "Who do ya think you are!?";
        String s5 = "This is a pizza place, not a hangout!";
        String s6 = "Do you know where you are...?";
        sayings.add(s1); sayings.add(s2); sayings.add(s3);
        sayings.add(s4); sayings.add(s5); sayings.add(s6);
        return sayings;
    }

    public static void main(String[] args) {
        Pizza p = new Pizza();
        Customer c = new Customer();
        System.out.println("\n!==<>==<>== Welcome to Pizza Joe's ==<>==<>==!");
        p.initialDisplay();
    }
}