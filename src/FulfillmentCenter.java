import java.util.*;

public class FulfillmentCenter {
    String name;
    List<Item> products = new LinkedList<Item>();
    Double maxMass;

    public FulfillmentCenter(String name, Double maxMass) {
        this.name = name;
        this.maxMass = maxMass;
    }

    public Boolean isEmpty() {
        int size = 0;
        for (Item singleProduct : products) {
            size += singleProduct.getQuantity();
        }
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public double massOfAllProducts() {
        double size = 0.0;
        for (Item singleProduct : products) {
            size += singleProduct.getMass();
        }
        return size;
    }

    public void addProduct(Item product) {
        if (massOfAllProducts() + product.getMass() <= maxMass) {
            for (Item singleProduct : products) {
                int ile = product.getQuantity();
                double masa = product.getMass();
                if (product.compareTo(singleProduct) == 0) {
                    System.out.println("Taki produkt już istnieje, dodaję masę i ilość");
                    singleProduct.setQuantity(singleProduct.getQuantity() + ile);
                    singleProduct.setMass(singleProduct.getMass() + masa);
                    return;
                }
            }
            Item newProduct = new Item(product);
            products.add(newProduct);
        } else {
            System.err.println("Pojemność przekroczona, nie dodano produktu");
        }
    }

    public void getProduct(Item takenProduct) {
        for (Item singleProduct : products) {
            if (singleProduct.compareTo(takenProduct) == 0) {//taki sam jest w magazynie
                if (singleProduct.getQuantity() > takenProduct.getQuantity()) {
                    singleProduct.setQuantity(singleProduct.getQuantity() - takenProduct.getQuantity());
                    singleProduct.setMass(singleProduct.getMass() - takenProduct.getMass());
                    return;
                } else if (singleProduct.getQuantity() == takenProduct.getQuantity()) {
                    removeProduct(singleProduct);
                    return;
                } else {
                    break;
                }
            }
        }
        System.out.println("Brak wystarczających zapasów w magazynie.");
    }

    public void removeProduct(Item removedProduct) {
        products.remove(removedProduct);
        System.out.println("Całkowicie usunięto produkt");
    }

    public Item search(String name) {
        for (Item singleProduct : products) {
            if (singleProduct.getName().compareTo(name) == 0) {
                return singleProduct;
            }
        }
        System.out.println("Nie znaleziono takiego produktu");
        return null;
    }

    public List<Item> searchPartial(String name) {
        List<Item> listOfCorrectProducts = new LinkedList<>();
        for (Item singleProduct : products) {
            if (singleProduct.compare(name)) {
                listOfCorrectProducts.add(singleProduct);
            }
        }
        return listOfCorrectProducts;
    }

    public int countByCondition(ItemCondition condition) {
        int counter = 0;
        for (Item singleProduct : products) {
            if (singleProduct.getCondition() == condition) {
                counter += singleProduct.getQuantity();
            }
        }
        return counter;
    }

    public void summary() {
        System.out.println("Magazyn o nazwie " + name + ", ma na stanie:");
        for (Item singleProduct : products) {
            singleProduct.print();
        }
    }

    public void sortByName() {
        Collections.sort(products);
    }

    public void sortByAmount() {
        Collections.sort(products, new ComparatorNumber());
    }

    public Item max() {
        Item item = Collections.max(products, new Comparator<Item>() {
            @Override
            public int compare(Item i1, Item i2) {
                return Integer.compare(i1.getQuantity(), i2.getQuantity());
            }
        });
        return item;
    }
}

class ComparatorNumber implements Comparator<Item> {
    @Override
    public int compare(Item item, Item item1) {
        return item1.getQuantity() - item.getQuantity();
    }
}
