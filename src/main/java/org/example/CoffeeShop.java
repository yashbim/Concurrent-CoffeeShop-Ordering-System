package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeShop {

    private Queue<String> coffeeOrders;
    private int maxOrders;

    public CoffeeShop(int maxOrders) {
        this.coffeeOrders = new LinkedList<>();
        this.maxOrders = maxOrders;
    }

    public synchronized void addOrder(String order) {
        while (coffeeOrders.size() >= maxOrders) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        coffeeOrders.add(order);
        notifyAll();
        System.out.println("Order added: " + order + "\nRemaining orders: " + coffeeOrders.size() + "\nMaximal orders: " + maxOrders);
    }
}
