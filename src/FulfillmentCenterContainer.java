import java.util.*;
import java.util.Map.Entry;

public class FulfillmentCenterContainer {
    Map<String, FulfillmentCenter> containers = new TreeMap<>(); //nazwa i magazyn --- key & value

    public void addCenter(String name, double capacity) {
        FulfillmentCenter newCenter = new FulfillmentCenter(name, capacity);
        containers.put(name, newCenter);
    }

    public void addCenter(String name, FulfillmentCenter container) {
        containers.put(name, container);
    }

    public void removeCenter(String name) {
        containers.remove(name);
    }

    public List<FulfillmentCenter> findEmpty() {
        List<FulfillmentCenter> emptyContainers = new LinkedList<>();
        for (Entry<String, FulfillmentCenter> singleContainer : containers.entrySet()) {
            if (singleContainer.getValue().isEmpty()) {
                emptyContainers.add(singleContainer.getValue());
            }
        }
        return emptyContainers;
    }

    public void summary() {
        for (Entry<String, FulfillmentCenter> entry : containers.entrySet()) {
            double percentages = (entry.getValue().massOfAllProducts() * 100.0 / entry.getValue().maxMass);
            int per = (int) percentages;
            System.out.println(String.format("Magazyn o nazwie: %s, jest zapełniony w ok. %d%%", entry.getKey(), per));
        }
    }
}
