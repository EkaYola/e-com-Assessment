abstract class Product {
    String Name;
  double Price;
  int Quantity;

  public Product(String name, double price, int quantity) {
    this.Name = name;
    this.Price = price;
    this.Quantity = quantity;
  }

  public String getName() {
    return Name;
  }

  public double getPrice() {
    return Price;
  }

  public int getQuantity() {
    return Quantity;
  }

  public void remainQuantity(int Qty){
    this.Quantity -= Qty;

  }

  public void setQuantity(int i) {
    if (i >= 0) {
      this.Quantity = i;
    } else {
      System.out.println("Quantity cannot be negative.");
    }
  }
    public abstract double getWeight(); // Abstract method for weight, to be implemented by subclasses
}
