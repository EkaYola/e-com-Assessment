
import java.time.LocalDate;
public class Biscuits extends Product implements ExpiryDate, Shipping {

    private double weight;
    private LocalDate expirationDate;

    public Biscuits(String name, double price, int quantity, double weight, LocalDate expirationDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expirationDate = expirationDate;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
