import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException("Product cannot be null and quantity must be greater than zero.");
        }
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Insufficient stock for " + product.getName());
        }

        CartItem item = new CartItem(product, quantity);
        items.add(item);
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getTotalWeight() {
        double totalWeight = 0.0;
        for (CartItem item : items) {
            totalWeight += item.getProduct().getWeight() * item.getQuantity();
        }
        return totalWeight;
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (CartItem item : items) {
            totalPrice += item.getProduct().getPrice() * item.getQuantity();
        }
        return totalPrice;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
