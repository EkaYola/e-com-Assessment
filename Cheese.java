import java.time.LocalDate;

public class Cheese extends Product implements ExpiryDate, Shipping {

    private double weight;
    private LocalDate expirationDate;

    public Cheese(String name, double price, int quantity, double weight, LocalDate expirationDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expirationDate = expirationDate;
    }


    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }
    public double getWeight() {
        return weight;
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
