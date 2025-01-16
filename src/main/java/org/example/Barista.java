package org.example;

public class Barista  implements Runnable{

    private CoffeeShop coffeeShop;
    private String baristaName;

    public Barista(CoffeeShop coffeeShop, String baristaName) {
        this.coffeeShop = coffeeShop;
        this.baristaName = baristaName;
    }

    @Override
    public void run() {
        while (true) {
            String order = coffeeShop.makeOrder();
            if (order == null) {
                break;
            }

            try{
                Thread.sleep(1000); // preperation time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(e.getMessage());
                break;
            }
            System.out.println(order + " was prepared by " + baristaName);
            System.out.println("Remaining orders: " + coffeeShop.getRemainingOrders());
        }

    }

}
