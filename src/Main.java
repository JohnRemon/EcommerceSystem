public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(1000);
        Cart cart = new Cart();
        Product cheese = new Product("Cheese", 20.0, 10, true, false);
        Product tv = new ShippableProduct("TV", 500.0, 10, false, false, 1000.0);
        Product scratchCard = new ShippableProduct("Scratch Card", 10.0, 10, false, false, 1.0);


        try {
            cart.add(cheese, 1);
            cart.add(tv, 1);
            cart.add(scratchCard, 5);
            cart.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
