public class Customer {
    private double currentBalance;

    public Customer() {
        this.currentBalance = 0.0;
    }

    public Customer(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }
}
