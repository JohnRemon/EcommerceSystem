public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(1000);
        Cart cart = new Cart();
        Product cheese = new Product("Cheese", 20, 3, true, false);
        Product tv = new ShippableProduct("TV", 500, 10, false, false, 1000);
        Product scratchCard = new ShippableProduct("Scratch Card", 10, 10, false, false, 1);


        try {
            cart.add(cheese, 3);
            cart.add(tv, 1);
            cart.add(scratchCard, 5);
            cart.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
