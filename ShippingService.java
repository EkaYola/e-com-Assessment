import java.util.List;
public class ShippingService {
    public void processShipping(List<Shipping> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (Shipping item : items) {
            System.out.println(item.getName() + " " + item.getWeight() + "kg");
            totalWeight += item.getWeight();
        }
        System.out.println("Total package weight " + totalWeight + "kg");
    }
    }
