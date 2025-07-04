public class Product {
    private String name;
    private double price;
    private int quantity;
    private boolean expirable;
    private boolean isExpired;

    public Product(String name, double price, int quantity, boolean expirable, boolean isExpired) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expirable = expirable;
        this.isExpired = isExpired;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean isExpired) {
        this.isExpired = isExpired;
    }
}
