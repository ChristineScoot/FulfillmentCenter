import java.util.List;

public class Main {
    public static void main(String[] args) {
        Item produkt1 = new Item("kwiatek", ItemCondition.NEW, 3, 2);
        Item produkt2 = new Item("zegarek", ItemCondition.NEW, 1, 1);
        Item produkt3 = new Item("telefon", ItemCondition.USED, 2, 1);
        FulfillmentCenter a = new FulfillmentCenter("a", 12.0);
        FulfillmentCenter b = new FulfillmentCenter("b", 8.0);
        a.addProduct(produkt1);
        a.addProduct(produkt1);
        a.addProduct(produkt2);
        a.addProduct(produkt2);
        a.addProduct(produkt3);
        a.addProduct(produkt1);//nie mieści się
        a.addProduct(produkt2);

        System.out.println("LISTA produktów:");
        a.summary();
        a.getProduct(produkt3);
        System.out.println("LISTA produktów:");
        a.summary();

        System.out.println("wynik metody search('kwiatek')");
        a.search("kwiatek").print();
        System.out.println("wynik metody search('mandarynka')");
        a.search("mandarynka");

        System.out.println("Szukanie 'te' w produktach:");
        List<Item> items = a.searchPartial("te");
        for (Item c : items) {
            c.print();
        }
        System.out.println("Ilość NEW produktów:");
        System.out.println(a.countByCondition(ItemCondition.NEW));

        System.out.println("\nSortowanie po nazwie");
        a.sortByName();
        a.summary();
        System.out.println("Sortowanie po ilości");
        a.sortByAmount();
        a.summary();
        System.out.println("Max:");
        a.max().print();

        FulfillmentCenterContainer m = new FulfillmentCenterContainer();
        m.addCenter("a", a);
        m.addCenter("b", b);
        m.addCenter("c", 8.0);

        System.out.println("\nPuste magazyny:");
        List<FulfillmentCenter> emptyMag = m.findEmpty();
        for (FulfillmentCenter mag : emptyMag) {
            System.out.println(String.format("-%s", mag.name));
        }

        System.out.println("\n");
        a.summary();
        a.getProduct(produkt2);
        a.summary();
        System.out.println("\n");

        System.out.println("Spis wszystkich magazynów:");
        m.summary();
        m.removeCenter("a");
    }
}