public class Item implements Comparable<Item> {
    private String name;
    private ItemCondition condition;
    private double mass;
    private Integer quantity;

    public Item(String name, ItemCondition condition, double mass, Integer quantity) {
        this.name = name;
        this.condition = condition;
        this.mass = mass;
        this.quantity = quantity;
    }

    public Item(Item a) {
        this.name = a.name;
        this.condition = a.condition;
        this.mass = a.mass;
        this.quantity = a.quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public double getMass() {
        return mass;
    }

    public String getName() {
        return name;
    }

    public ItemCondition getCondition() {
        return condition;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void print() {
        System.out.println(String.format("%s(stan: %s) masa=%.2fkg, ilosc=%dszt.", name, condition, mass, quantity));
    }

    public int compareTo(Item obiekt) {
        return name.compareTo(obiekt.name);
    }

    public boolean compare(String obiekt) {
        return name.contains(obiekt);
    }
}