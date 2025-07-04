public class MobileShards extends Product {
    public MobileShards(String name, double price, int quantity) {
        super(name, price, quantity);
    }
    @Override
    public double getWeight() {
        return 0.0;
    }
}


