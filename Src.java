import java.time.LocalDate;

public class Src {
    public static void main(String[] args) {
        Product TV = new TV("Samsung TV", 5000, 10, 15.0);
        Product mobileshards = new MobileShards("Apple iPhone", 5, 5);
        Product cheese = new Cheese("Cheddar Cheese", 0.99, 120, 0.5, LocalDate.of(2028, 12, 31));
        Product biscuits = new Biscuits("Chocolate Biscuits", 6, 50, 0.2, LocalDate.of(2028, 11, 30));

        Customer customer = new Customer("John Doe", 10000);

        Cart cart = new Cart();
        try{
            cart.addItem(cheese, 1);
            cart.addItem(mobileshards, 1);
            cart.addItem(biscuits, 1);
            cart.addItem(TV, 1);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }


        Checkout.process(customer, cart);

    }
}
