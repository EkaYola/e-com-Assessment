public class TV extends Product implements Shipping {

    private double weight;

    public TV(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }


    @Override
    public double getWeight() {
        return weight;
    }
}
