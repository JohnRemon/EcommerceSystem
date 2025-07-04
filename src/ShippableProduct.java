public class ShippableProduct extends Product implements Shippable {
    private final double weight;

    public ShippableProduct(String name, double price, int quantity, boolean expirable, boolean isExpired,double weight) {
        super(name, price, quantity, expirable, isExpired);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
