import java.util.ArrayList;
import java.util.List;

public class Checkout {
    public static void process(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        double subtotal = 0;
        double shippingFees = 0;
        List<Shipping> shippableItems = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();

            // Check for insufficient stock
            if (quantity > product.getQuantity()) {
                System.out.println("Error: Insufficient stock for " + product.getName());
                return; // Terminate the process immediately
            }

            // Check for expired products
            if (product instanceof ExpiryDate) {
                ExpiryDate expirable = (ExpiryDate) product;
                if (expirable.isExpired()) {
                    System.out.println("Error: " + product.getName() + " is expired.");
                    return; // Terminate the process immediately
                }
            }

            subtotal += product.getPrice() * quantity;

            if (product instanceof Shipping) {
                Shipping shippable = (Shipping) product;
                shippingFees += 10; // Assume flat shipping fee per item
                shippableItems.add(shippable);
            }
        }

        double totalAmount = subtotal + shippingFees;

        if (customer.getBalance() < totalAmount) {
            System.out.println("Insufficient balance.");
            return;
        }

        customer.deductBalance((int) totalAmount);

        if (!shippableItems.isEmpty()) {
            ShippingService shippingService = new ShippingService();
            shippingService.processShipping(shippableItems);
        }

        System.out.println("\n** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " " + (item.getProduct().getPrice() * item.getQuantity()));
        }
        System.out.println("----------------------");
        System.out.println("Subtotal " + subtotal);
        System.out.println("Shipping " + shippingFees);
        System.out.println("Amount " + totalAmount);
    }
}