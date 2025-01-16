package org.example;

public class Customer implements Runnable {
    private CoffeeShop coffeeShop;
    private String customerName;

    public Customer(CoffeeShop coffeeShop, String customerName) {
        this.coffeeShop = coffeeShop;
        this.customerName = customerName;
    }

    @Override
    public void run() {
        String order = customerName + " wants a coffee. ";
        coffeeShop.addOrder(order);
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(e.getMessage());
        }
    }
}
