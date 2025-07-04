public class Customer {
    private double Balance;
    private String Name;

    public Customer(String name, double balance) {
        this.Name = name;
        this.Balance = balance;
    }
    public String getName() {
        return Name;
    }
    public double getBalance() {
        return Balance;
    }

    public void deductBalance(double amount) {
        if (amount <= Balance) {
            this.Balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
