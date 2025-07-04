import exceptions.*;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void add(Product product, int quantity){
        //Check if the product is out of stock
        if(product.getQuantity() == 0){
            throw new ProductOutOfStock(product.getName() + " is out of stock");
        }
        //Check if we have enough of the product in stock
        if(quantity > product.getQuantity()){
            throw new InsufficientQuantity("We don't have enough of " + product.getName() + " in stock");
        }
        //Check if the product is expired
        if(product.isExpired()){
            throw new ProductExpired(product.getName() + " has Expired");
        }
        items.add(new Item(product, quantity));
    }

    public void checkout(Customer customer, Cart cart){
        //Empty Cart
        if(cart.getItems().isEmpty())
            throw new EmptyCart("Your Cart is empty");

        //Calculate Order Subtotal
        double subTotal = 0;
        ArrayList<Item> shippableItems = new ArrayList<>();
        for(Item item : cart.getItems()){
            // Check if the product is shippable
            if(item.getProduct() instanceof ShippableProduct) {
                shippableItems.add(item);
            }
            if(item.getProduct().isExpired()){
                throw new ProductExpired(item.getProduct().getName() + " has Expired");
            }
            subTotal += item.getProduct().getPrice() * item.getQuantity();
        }

        //Calculate Order Shipping Fees
        double totalWeight = 0;
        for(Item item : shippableItems){
            totalWeight += ((ShippableProduct) item.getProduct()).getWeight() * item.getQuantity();
        }
        double shippingFees = (totalWeight / 1000) * 30; // Assuming shipping fee is 30 per kg
        double totalFees = subTotal + shippingFees;

        //Check if the customer has enough balance
        if(customer.getCurrentBalance() < totalFees){
            throw new InsufficientBalance("You have insufficient balance");
        }

        //Print the Shipping Details and Weight
        System.out.println("** Shipment Notice **");
        for(Item item : shippableItems){
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " " + ((ShippableProduct) item.getProduct()).getWeight() * item.getQuantity() + "g");
        }
        System.out.println("Total Package Weight " + totalWeight / 1000 + "kg\n");

        //Print the Checkout Receipt and Fees
        System.out.println("** Checkout Receipt **");
        for(Item item : cart.getItems()){
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " " + item.getProduct().getPrice() * item.getQuantity());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal          %.1f\n", subTotal);
        System.out.printf("Shipping Fees     %.1f\n", shippingFees);
        System.out.printf("Total             %.1f\n", totalFees);
        System.out.printf("Remaining Balance %.1f\n", customer.getCurrentBalance() - totalFees);


        //Reduce the items from the stock
        for(Item item : cart.getItems()){
            item.getProduct().setQuantity(item.getProduct().getQuantity() - item.getQuantity());
        }
        //Reduce the customer's balance
        customer.setCurrentBalance(customer.getCurrentBalance() - totalFees);
    }
    public ArrayList<Item> getItems(){
        return items;
    }
}
